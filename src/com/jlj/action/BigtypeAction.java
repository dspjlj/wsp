package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.jlj.model.Pubclient;
import com.jlj.model.Wgw;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IPubclientService;
import com.jlj.service.IWgwService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("bigtypeAction")
@Scope("prototype")
public class BigtypeAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IWgwService wgwService;
	private IBigtypeService bigtypeService;
	private IPubclientService pubclientService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Bigtype bigtype;
	private Wgw wgw;
	private int wgwid;
	//分页显示
	private String[] arg=new String[2];
	private List<Bigtype> bigtypes;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	private int isdelpic;
	
	private String frontpa;
	private String temp2;
	private int bigtypeid;
	
	//=========前台类别=================================================
	public String frontBigtypes(){
		wgw = wgwService.loadById(wgwid);
		if(wgw==null){
			return NONE;
		}
		bigtype = bigtypeService.loadById(bigtypeid);
		bigtypes = bigtypeService.querySonBigtypesByParentBigtypeId(bigtypeid);
		//模板
		int temp = wgw.getTemplate2();
		temp2="temp"+temp;
		return "frontbigtypes";
	}
	//=========后台类别管理=================================================
	/**
	 * 类别管理
	 */
	public String list() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=bigtypeService.getTotalCount(paccount);
		//总页数
		pageCount=bigtypeService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		bigtypes=bigtypeService.queryList(paccount,page,size);
		return "list";
		
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgw=wgwService.queryWgwByPublicAccount(paccount);
		if(wgw!=null){
			return "add";
		}else{
			//请先设置微官网
			arg[0]="wgwAction!view";
			arg[1]="微官网设置";
			String goInfo = "请先设置微官网";
			request.put("goInfo", goInfo);
			return "goanother";
		}
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
			ToolKitUtil.upload(imageName,picture,folderUrl);
			bigtype.setImageurl(paccount+"/"+imageName);
		}
		bigtype.setPublicaccount(paccount);
		bigtypeService.add(bigtype);
		
		arg[0]="bigtypeAction!list";
		arg[1]="类别管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Bigtype bigtype=bigtypeService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
		photofile.delete();
		bigtypeService.delete(bigtype);
		
		arg[0]="bigtypeAction!list";
		arg[1]="类别管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(isdelpic==0){
			if(picture!=null){
					String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
					String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
					ToolKitUtil.upload(imageName,picture,folderUrl);
					//删除原图片
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
					photofile.delete();
					bigtype.setImageurl(paccount+"/"+imageName);
			}
		}else{
			//删除原图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
			photofile.delete();
			bigtype.setImageurl(null);
		}
		bigtype.setPublicaccount(paccount);
		bigtypeService.update(bigtype);
		
		arg[0]="bigtypeAction!list";
		arg[1]="类别管理";
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		bigtype=bigtypeService.loadById(id);
		return "load";
	}
	
	
	
	//子类别管理============================================start
	/**
	 * 子类别管理
	 */
	public String sonlist() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=bigtypeService.getTotalCount(pid,paccount);
		//总页数
		pageCount=bigtypeService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		bigtypes=bigtypeService.queryList(pid,paccount,page,size);
		return "sonlist";
		
	}
	
	private Bigtype parentBigtype;
	/**
	 * 跳转到添加页面-子类别
	 * @return
	 */
	public String goToAddSon(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgw=wgwService.queryWgwByPublicAccount(paccount);
		if(wgw!=null){
			parentBigtype = bigtypeService.loadById(pid);
			return "sonadd";
		}else{
			//请先设置微官网
			arg[0]="wgwAction!view";
			arg[1]="微官网设置";
			String goInfo = "请先设置微官网";
			request.put("goInfo", goInfo);
			return "goanother";
		}
		
	}
	
	/**
	 * 添加-子类别
	 * @return
	 * @throws Exception
	 */
	public String addson() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
			ToolKitUtil.upload(imageName,picture,folderUrl);
			bigtype.setImageurl(paccount+"/"+imageName);
		}
		bigtype.setPublicaccount(paccount);
		bigtypeService.add(bigtype);
		
		arg[0]="bigtypeAction!sonlist?pid="+pid;
		arg[1]="子类别管理";
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改页面-子分类
	 * @return
	 */
	public String loadson() throws Exception{
		parentBigtype = bigtypeService.loadById(pid);
		bigtype=bigtypeService.loadById(id);
		return "loadson";
	}
	
	/**
	 * 删除-子分类
	 * @return
	 */
	public String deleteson(){
		Bigtype bigtype=bigtypeService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
		photofile.delete();
		bigtypeService.delete(bigtype);
		
		arg[0]="bigtypeAction!sonlist?pid="+pid;
		arg[1]="子类别管理";
		return SUCCESS;
	}
	
	/**
	 * 修改-子分类
	 * @return
	 */
	public String updateson() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(isdelpic==0){
			if(picture!=null){
				String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
				String folderUrl=ServletActionContext.getServletContext().getRealPath(paccount);
				ToolKitUtil.upload(imageName,picture,folderUrl);
				//删除原图片
				File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
				photofile.delete();
				bigtype.setImageurl(paccount+"/"+imageName);
			}
		}else{
			//删除原图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigtype.getImageurl());
			photofile.delete();
			bigtype.setImageurl(null);
		}
		bigtype.setPublicaccount(paccount);
		bigtypeService.update(bigtype);
		
		arg[0]="bigtypeAction!sonlist?pid="+pid;
		arg[1]="子类别管理";
		return SUCCESS;
	}
	
	//get、set-------------------------------------------
	public IBigtypeService getBigtypeService() {
		return bigtypeService;
	}
	@Resource
	public void setBigtypeService(IBigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
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
	
	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}
	
	public Bigtype getBigtype() {
		return bigtype;
	}
	public List<Bigtype> getBigtypes() {
		return bigtypes;
	}
	public void setBigtypes(List<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
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
	public Wgw getWgw() {
		return wgw;
	}
	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}
	public Bigtype getParentBigtype() {
		return parentBigtype;
	}
	public void setParentBigtype(Bigtype parentBigtype) {
		this.parentBigtype = parentBigtype;
	}
	public int getIsdelpic() {
		return isdelpic;
	}
	public void setIsdelpic(int isdelpic) {
		this.isdelpic = isdelpic;
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
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	
	
}
