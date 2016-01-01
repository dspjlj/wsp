package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Calendar;
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
//import com.jlj.model.Sontype;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IPagearticleService;
import com.jlj.service.IPubclientService;
//import com.jlj.service.ISontypeService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("pagearticleAction")
@Scope("prototype")
public class PagearticleAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPagearticleService pagearticleService;
	private IBigtypeService bigtypeService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Pagearticle pagearticle;
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
	
	private int stid;//子类别id
	private List<Bigtype> bigtypes;
	private String frontpa;//传入参数，查询所有大类别信息
	private String template;
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	//前台=======================================
	/**
	 * 前台-分页显示文章列表
	 * @return
	 */
	public String frontpagearticle(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		int psize=10;//每页显示10条
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getFrontPageCount(stid,psize);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryFrontList(stid,page,psize);
		//总记录数
		totalCount=pagearticleService.getFrontTotalCount(stid);
		//模板
		int temp=0;
		if(session.get("template")!=null){
			temp = (Integer)session.get("template");
		}else{
			Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
//			temp = pubclient.getTemplate();
//			session.put("template",temp);
		}
		template="template"+temp;
		return "frontpagearticle";
	}
	/**
	 * 前台-跳转到文章详细展示界面
	 * @return
	 */
	public String frontview(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		pagearticle=pagearticleService.loadById(id);
		//模板
		int temp=0;
		if(session.get("template")!=null){
			temp = (Integer)session.get("template");
		}else{
			Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
//			temp = pubclient.getTemplate();
//			session.put("template",temp);
		}
		template="template"+temp;
		return "frontview";
	}
	/**
	 * 前台-首页-头版文章列表
	 * @return
	 */
	public String frontindexview(){
		int isshow = 2;//查询头版
		int page = 1;//只提取第一页
		int psize = 2;//只显示2条头版
		pagearticles=pagearticleService.queryFrontIndexList(frontpa,isshow,page,psize);
		request.put("pagearticles", pagearticles);
		return null;
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
		int ttype = 0;//类别
		int hastype = 0;//无子类别
		bigtypes = bigtypeService.getBigtypesBycondition(ison,ttype,hastype,paccount);
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
			String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
			ToolKitUtil.upload(imageName,picture,folderUrl);
			pagearticle.setImageurl(paccount+"/"+imageName);
			
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
			String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
			ToolKitUtil.upload(imageName,picture,folderUrl);
			//删除原图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImageurl());
			photofile.delete();
			pagearticle.setImageurl(paccount+"/"+imageName);
			
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
		int ttype = 0;//类别
		int hastype = 0;//无子类别
		bigtypes = bigtypeService.getBigtypesBycondition(ison,ttype,hastype,paccount);
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

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
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
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	
	
	
}
