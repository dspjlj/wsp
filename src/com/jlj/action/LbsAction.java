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

import com.jlj.model.Lbs;
import com.jlj.model.Pubclient;
import com.jlj.service.ILbsService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("lbsAction")
@Scope("prototype")
public class LbsAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private ILbsService lbsService;
	private IPubclientService pubclientService;
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Lbs lbs;
	//分页显示
	private String[] arg=new String[2];
	private List<Lbs> lbss;
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
	 * 位置展示
	 */
	public String frontLbss(){
		lbss = lbsService.getFrontLbssByPublicAccount(frontpa);
		request.put("lbss", lbss);
		return NONE;
	}
	//=========后台管理=================================================
	/**
	 * LBS位置管理
	 */
	public String list() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();//获取原始ID
		
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=lbsService.getTotalCount(con,convalue,publicaccount);
		//总页数
		pageCount=lbsService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		lbss=lbsService.queryList(con,convalue,publicaccount,page,size);
		
		return "list";
	}
	
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();//获取原始ID
		lbs.setPublicaccount(publicaccount);
		//上传并记录图片地址
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(publicaccount,imageName,picture);
			lbs.setShowimg("res/"+publicaccount+"/"+imageName);//设置图片地址全称
		}
		
		lbsService.add(lbs);
		arg[0]="lbsAction!list";
		arg[1]="LBS位置管理";
		return SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();//获取原始ID
		//删除图片
		lbsService.deleteById(id);
		//删除该公众号的所有资源res/{paccount}
		if(publicaccount!=null&&!publicaccount.equals("")){
			ToolKitUtil.deleteFile(ServletActionContext.getServletContext().getRealPath("/")+"res/"+publicaccount);
		}
		return this.list();
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		lbs=lbsService.loadById(id);
		return "load";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String publicaccount = lbs.getPublicaccount();//获取原始ID
		//上传并记录图片地址
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(publicaccount,imageName,picture);
			//删除原来的图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+lbs.getShowimg());
			photofile.delete();
			lbs.setShowimg("res/"+publicaccount+"/"+imageName);//设置图片地址全称
		}
		
		lbsService.update(lbs);
		arg[0]="lbsAction!list";
		arg[1]="LBS位置管理";
		return SUCCESS;
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
	
	public ILbsService getLbsService() {
		return lbsService;
	}
	@Resource
	public void setLbsService(ILbsService lbsService) {
		this.lbsService = lbsService;
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
	
	public void setLbs(Lbs lbs) {
		this.lbs = lbs;
	}
	public Lbs getLbs() {
		return lbs;
	}
	
	public List<Lbs> getLbss() {
		return lbss;
	}
	public void setLbss(List<Lbs> lbss) {
		this.lbss = lbss;
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
