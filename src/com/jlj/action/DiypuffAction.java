package com.jlj.action;

import java.io.File;
import java.net.URLDecoder;
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

import com.jlj.model.Autores;
import com.jlj.model.Diypuff;
import com.jlj.model.Pubclient;
import com.jlj.service.IDiypuffService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("diypuffAction")
@Scope("prototype")
public class DiypuffAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private IDiypuffService diypuffService;
	private IPubclientService pubclientService;
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Diypuff diypuff;
	//分页显示
	private String[] arg=new String[2];
	private List<Diypuff> diypuffs;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	//查询条件
	private int status;//按状态
	private String publicaccount;//公众号原始ID
	private int con;
	private String convalue;
	private String frontpa;
	
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	//=========前台显示=================================================
	/**
	 * Diy宣传页展示
	 */
	public String frontDiypuff(){
		diypuffs = diypuffService.getFrontDiypuffsByPublicAccount(frontpa);
		Diypuff diypuff = diypuffs.get(0);
		request.put("diypuff", diypuff);
		return NONE;
	}
	//=========后台管理=================================================
	/**
	 * Diy宣传页管理
	 */
//	public String list() throws Exception{
//		if(convalue!=null&&!convalue.equals("")){
//			convalue=URLDecoder.decode(convalue, "utf-8");
//		}
//		if(page<1){
//			page=1;
//		}
//		//总记录数
//		totalCount=diypuffService.getTotalCount(con,convalue,status,publicaccount);
//		//总页数
//		pageCount=diypuffService.getPageCount(totalCount,size);
//		if(page>pageCount&&pageCount!=0){
//			page=pageCount;
//		}
//		//所有当前页记录对象
//		diypuffs=diypuffService.queryList(con,convalue,status,publicaccount,page,size);
//		
//		return "list";
//	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		return "add";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		System.out.println("add");
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		//保存二维码图片
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(publicaccount,imageName,picture);
			diypuff.setEwmimg("res/"+publicaccount+"/"+imageName);//设置图片地址全称
		}
		//保存链接地址
		diypuff.setLinkurl("http://www.di3p.com:8088/wsp/front/diypuff.jsp?frontpa="+publicaccount);
		//保存公众号
		diypuff.setPublicaccount(publicaccount);
		diypuffService.add(diypuff);
		return this.view();
	}
	
	/**
	 * 删除
	 * @return
	 */
//	public String delete(){
//		diypuffService.deleteById(id);
//		arg[0]="diypuffAction!list";
//		arg[1]="Diy宣传页管理";
//		return SUCCESS;
//	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
//	public String load() throws Exception{
//		diypuff=diypuffService.loadById(id);
//		return "load";
//	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		//上传并记录图片地址
		if(picture!=null){
			String paccount = diypuff.getPublicaccount();//获取原始ID
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(paccount,imageName,picture);
			//删除原来的图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+diypuff.getEwmimg());
			photofile.delete();
			diypuff.setEwmimg("res/"+paccount+"/"+imageName);//设置图片地址全称
		}
		
		diypuffService.update(diypuff);
		return this.view();
	}
	
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		//若客户第一次浏览该页，首先进入添加自动关注回复页面;否则，直接进入查看页面
		List<Diypuff> diypufflist= diypuffService.queryListByPublicAccount(publicaccount);
		if(diypufflist.size()>0){
			diypuff=diypufflist.get(0);
			return "load";
		}else{
			return this.goToAdd();
		}
	}
	
	
	
	//get、set-------------------------------------------
	//service注入
	public IPubclientService getPubclientService() {
		return pubclientService;
	}
	@Resource
	public void setPubclientService(IPubclientService pubclientService) {
		this.pubclientService = pubclientService;
	}
	
	public IDiypuffService getDiypuffService() {
		return diypuffService;
	}
	@Resource
	public void setDiypuffService(IDiypuffService diypuffService) {
		this.diypuffService = diypuffService;
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
    
	//字段获取
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDiypuff(Diypuff diypuff) {
		this.diypuff = diypuff;
	}
	public Diypuff getDiypuff() {
		return diypuff;
	}
	
	public List<Diypuff> getDiypuffs() {
		return diypuffs;
	}
	public void setDiypuffs(List<Diypuff> diypuffs) {
		this.diypuffs = diypuffs;
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
	public String getFrontpa() {
		return frontpa;
	}
	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
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
	
}
