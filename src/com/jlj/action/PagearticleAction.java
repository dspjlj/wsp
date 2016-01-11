package com.jlj.action;

import java.io.File;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Bigtype;
import com.jlj.model.Pagearticle;
import com.jlj.model.Pubclient;
import com.jlj.model.Wgw;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IPagearticleService;
import com.jlj.service.IPubclientService;
import com.jlj.service.IWgwService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("pagearticleAction")
@Scope("prototype")
public class PagearticleAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPagearticleService pagearticleService;
	private IWgwService wgwService;
	private IBigtypeService bigtypeService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Pagearticle pagearticle;
	private Wgw wgw;
	private Bigtype bigtype;
//	//添加页面显示大类别
//	private List<Sontype> sontypes;
	//分页显示
	private String[] arg=new String[2];
	private List<Pagearticle> pagearticles;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	
	private List<Bigtype> bigtypes;
	private String frontpa;//传入参数，查询所有大类别信息
	private String temp3;
	private String temp4;
	private int wgwid;
	private int bigtypeid;
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	//前台=======================================
	/**
	 * 前台-分页显示文章列表
	 * @return
	 */
	public String frontPages(){
		wgw = wgwService.loadById(wgwid);
		if(wgw==null){
			return NONE;
		}
		bigtype = bigtypeService.loadById(bigtypeid);
		pagearticles = pagearticleService.queryPagearticlesByEndBigtypeId(bigtypeid);
		//模板
		int temp = wgw.getTemplate3();
		temp3="temp"+temp;
		return "frontpages";
	}
	
	/**
	 * 前台-跳转到文章详细展示界面
	 * @return
	 */
	public String frontView(){
		pagearticle = pagearticleService.loadById(id);
		wgw = wgwService.loadById(wgwid);
		if(wgw==null){
			return NONE;
		}
		//模板
		int temp = wgw.getTemplate2();
		temp4="temp"+temp;
		return "frontview";
	}
	//后台管理============文章管理===========================
	/**
	 * 后台-文章管理
	 */
	public String list() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=pagearticleService.getTotalCount(con,convalue,status,paccount);
		//总页数
		pageCount=pagearticleService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryList(con,convalue,status,paccount,page,size);
		
		return "list";
	}
	
	
	/**
	 * 后台-跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		int ison = 1;//启用
//		int ttype = 0;//类别
		int hastype = 0;//无子类别
		bigtypes = bigtypeService.getBigtypesBycondition(ison,hastype,paccount);
		//若无子类别，则跳转到先添加子类别
		if(bigtypes!=null&&bigtypes.size()>0){
			return "add";
		}else{
			//请先设置微官网
			arg[0]="bigtypeAction!list";
			arg[1]="类别管理";
			String goInfo = "请先设置类别，必需1个以上类别（该类别没有子类别）";
			request.put("goInfo", goInfo);
			return "goanother";
		}
	}
	
	/**
	 * 后台-添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/pagearticle",imageName,picture);
			pagearticle.setImageurl("res/"+paccount+"/pagearticle/"+imageName);
			
		}
		pagearticle.setPublicaccount(paccount);
		pagearticle.setCreatetime(new Date());//设置创建日期
		pagearticleService.add(pagearticle);
		
		arg[0]="pagearticleAction!list";
		arg[1]="文章管理";
		return SUCCESS;
	}
	
	/**
	 * 后台-删除
	 * @return
	 */
	public String delete(){
		Pagearticle pagearticle=pagearticleService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImageurl());
		photofile.delete();
		pagearticleService.delete(pagearticle);
		arg[0]="pagearticleAction!list";
		arg[1]="文章管理";
		return SUCCESS;
	}
	/**
	 * 后台-修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/pagearticle",imageName,picture);
			//删除原图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImageurl());
			photofile.delete();
			pagearticle.setImageurl("res/"+paccount+"/pagearticle/"+imageName);
			
		}
		pagearticle.setPublicaccount(paccount);
//		//设置创建日期
//		pagearticle.setCreatetime(new Date());
//		//设置详细描述
//		pagearticle.setDescription(htmlspecialchars(pagearticle.getDescription()));
		pagearticleService.update(pagearticle);
		arg[0]="pagearticleAction!list";
		arg[1]="文章管理";
		return SUCCESS;
	}
	/**
	 * 后台-跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		int ison = 1;//启用
//		int ttype = 0;//类别
		int hastype = 0;//无子类别
		bigtypes = bigtypeService.getBigtypesBycondition(ison,hastype,paccount);
		//文章对象
		pagearticle=pagearticleService.loadById(id);
		return "load";
	}
	
	//get、set-------------------------------------------
	public IPagearticleService getPagearticleService() {
		return pagearticleService;
	}
	@Resource
	public void setPagearticleService(IPagearticleService pagearticleService) {
		this.pagearticleService = pagearticleService;
	}
	public IBigtypeService getBigtypeService() {
		return bigtypeService;
	}
	@Resource
	public void setBigtypeService(IBigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
	}
	public IPubclientService getPubclientService() {
		return pubclientService;
	}
	@Resource
	public void setPubclientService(IPubclientService pubclientService) {
		this.pubclientService = pubclientService;
	}
	
	public IWgwService getWgwService() {
		return wgwService;
	}
	@Resource
	public void setWgwService(IWgwService wgwService) {
		this.wgwService = wgwService;
	}
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }    
    public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
    public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPagearticle(Pagearticle pagearticle) {
		this.pagearticle = pagearticle;
	}
	
	public Pagearticle getPagearticle() {
		return pagearticle;
	}
	public List<Pagearticle> getPagearticles() {
		return pagearticles;
	}
	public void setPagearticles(List<Pagearticle> pagearticles) {
		this.pagearticles = pagearticles;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public String getConvalue() {
		return convalue;
	}
	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	public String getPublicaccount() {
		return publicaccount;
	}
	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public List<Bigtype> getBigtypes() {
		return bigtypes;
	}

	public void setBigtypes(List<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
	}

	public String getFrontpa() {
		return frontpa;
	}
	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public Wgw getWgw() {
		return wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	public Bigtype getBigtype() {
		return bigtype;
	}

	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}

	public String getTemp3() {
		return temp3;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public int getWgwid() {
		return wgwid;
	}

	public void setWgwid(int wgwid) {
		this.wgwid = wgwid;
	}

	public int getBigtypeid() {
		return bigtypeid;
	}

	public void setBigtypeid(int bigtypeid) {
		this.bigtypeid = bigtypeid;
	}

	public String getTemp4() {
		return temp4;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}
	
	
	
}
