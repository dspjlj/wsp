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

import com.jlj.model.Dspuser;
import com.jlj.model.Pubclient;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("pubclientAction")
@Scope("prototype")
public class PubclientAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPubclientService pubclientService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//删除、进入修改页等改传入参数
	private int id;
	private Pubclient pubclient;
	
	//分页显示
	private String[] arg=new String[2];
	private List<Pubclient> pubclients;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	//前端的属性
	private String frontpa;
	
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	/**
	 * 前台-查出公众账号存入request
	 * @return
	 */
	public String getfrontpubclient(){
		pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
		request.put("pubclient", pubclient);
		return null;
	}
	
	/**
	 * 后台-公众号管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//判断权限级别，若为管理员0，查询所有用户信息
		//若为高级用户1，查询下级用户信息
		Dspuser dspuser1 = (Dspuser)session.get("dspuser");
		int limits = dspuser1.getLimits();
		if(limits==0){
			//总记录数
			totalCount=pubclientService.getAllTotalCount(con,convalue);
			//总页数
			pageCount=pubclientService.getPageCount(totalCount,size);
			if(page>pageCount&&pageCount!=0){
				page=pageCount;
			}
			//所有当前页记录对象
			pubclients=pubclientService.queryAllList(con,convalue,page,size);
		}else{
			int selfid = dspuser1.getId();
			//总记录数
			totalCount=pubclientService.getTotalCount(con,convalue,selfid);
			//总页数
			pageCount=pubclientService.getPageCount(totalCount,size);
			if(page>pageCount&&pageCount!=0){
				page=pageCount;
			}
			//所有当前页记录对象
			pubclients=pubclientService.queryList(con,convalue,selfid,page,size);
		}
		
		return "list";
	}
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
		//设置创建日期和过期日期
		Date nowDate = new Date();
		pubclient.setCreatedate(nowDate);
		pubclient.setDeaddate(DateTimeKit.dateBeforethisDate(nowDate, -365));
		//关联用户
		Dspuser dspuser1 = (Dspuser)session.get("dspuser");
		pubclient.setDspuser(dspuser1);
		//上传并记录图片地址
		if(picture!=null){
			String paccount = pubclient.getPublicaccount();//获取原始ID
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(paccount,imageName,picture);
			pubclient.setImgurl("res/"+paccount+"/"+imageName);//设置图片地址全称
		}
		//设置url、token和43位的随机密钥encodingAESKey
		String url = "http://121.40.87.194/wsp/vcoreAction!vprocess?vxinpublic="+pubclient.getPublicno();
		String token = pubclient.getPublicno();
		String encodingAESKey = ToolKitUtil.getRandomString(43);
		pubclient.setUrl(url);
		pubclient.setToken(token);
		pubclient.setEncodingaeskey(encodingAESKey);
		pubclientService.add(pubclient);
		
		arg[0]="pubclientAction!list";
		arg[1]="公众号管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		Pubclient pubclient=pubclientService.loadById(id);
		String paccount = pubclient.getPublicaccount();//获取原始ID
		pubclientService.deleteById(id);
		//删除该公众号的所有资源res/{paccount}
		if(paccount!=null&&!paccount.equals("")){
			ToolKitUtil.deleteFile(ServletActionContext.getServletContext().getRealPath("/")+"res/"+paccount);
		}
		return this.list();
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		pubclient=pubclientService.loadById(id);
		return "load";
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		
		//上传并记录图片地址
		if(picture!=null){
			String paccount = pubclient.getPublicaccount();//获取原始ID
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(paccount,imageName,picture);
			//删除原来的图片
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pubclient.getImgurl());
			photofile.delete();
			pubclient.setImgurl("res/"+paccount+"/"+imageName);//设置图片地址全称
		}
		
		pubclientService.update(pubclient);
		arg[0]="pubclientAction!list";
		arg[1]="公众号管理";
		return SUCCESS;
	}
	
	/**
	 * 跳转到绑定API页面
	 * @return
	 */
	public String loadbind() throws Exception{
		pubclient=pubclientService.loadById(id);
		return "loadbind";
	}
	
	/**
	 * 进入某公众号的功能列表进行管理
	 * @return
	 */
	public String loadpubfun(){
		pubclient=pubclientService.getById(id);
		session.put("pubclient", pubclient);
		return "loadpubfun";
	}
	/**
	 * 进入某公众号的功能列表进行管理
	 * @return
	 */
	public String loadappauth(){
		Pubclient sessionPub=(Pubclient)session.get("pubclient");
		pubclient = pubclientService.loadById(sessionPub.getId());
		return "loadappauth";
	}
	
	/**
	 * 修改appid和appsecret
	 * @return
	 */
	private int pubid;//用于接收需要修改appauth的id
	private String appid;
	private String appsecret;
	public String updateAppAuth(){
		pubclientService.updateAppAuthById(appid,appsecret,pubid);
		pubclient = pubclientService.loadById(pubid);
		return "loadappauth";
	}
	
	//get、set-------------------------------------------
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
	
	public void setPubclient(Pubclient pubclient) {
		this.pubclient = pubclient;
	}
	
	public Pubclient getPubclient() {
		return pubclient;
	}

	public List<Pubclient> getPubclients() {
		return pubclients;
	}
	public void setPubclients(List<Pubclient> pubclients) {
		this.pubclients = pubclients;
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

	public int getPubid() {
		return pubid;
	}

	public void setPubid(int pubid) {
		this.pubid = pubid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	
}
