package com.jlj.action;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Dspuser;
import com.jlj.service.IDspuserService;
import com.opensymphony.xwork2.ActionSupport;

@Component("dspuserAction")
@Scope("prototype")
public class DspuserAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IDspuserService dspuserService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//删除、进入修改页等改传入参数
	private int id;
	private Dspuser dspuser;
	//登陆-用户名、密码、验证码参数
	private String username;
	private String password;
//	private String validate;
	//修改个人信息的属性
	private String phone;
	private String qq;
	private String email;
	//修改个人密码的属性
	private String newpwd;//新密码
	private String againpwd;//再次输入新密码
	private String oldpwd;//旧密码
	//分页显示列表
	private String[] arg=new String[2];
	private List<Dspuser> dspusers;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	/**
	 * 用户登陆
	 */
	public String login(){
		if(username==null||username.equals("")||password==null||password.equals("")){
			String loginfail="用户名或密码不能为空";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}
		Dspuser dspuser=dspuserService.userlogin(username,password);
		if(dspuser==null){
			String loginfail="用户名或密码输入有误";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}else{
			session.put("dspuser", dspuser);
			return "loginSucc";
		}
	}
	/**
	 * 用户管理
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
			totalCount=dspuserService.getAllTotalCount(con,convalue);
			//总页数
			pageCount=dspuserService.getPageCount(totalCount,size);
			if(page>pageCount&&pageCount!=0){
				page=pageCount;
			}
			//所有当前页记录对象
			dspusers=dspuserService.queryAllList(con,convalue,page,size);
		}else if(limits==1){
			int pid=dspuser1.getId();
			//总记录数
			totalCount=dspuserService.getTotalCount(con,convalue,pid);
			//总页数
			pageCount=dspuserService.getPageCount(totalCount,size);
			if(page>pageCount&&pageCount!=0){
				page=pageCount;
			}
			//所有当前页记录对象
			dspusers=dspuserService.queryList(con,convalue,pid,page,size);
		}
		
		return "list";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		dspuser.setRegdate(new Date());
		dspuserService.add(dspuser);
		
		arg[0]="dspuserAction!list";
		arg[1]="用户管理";
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		dspuser=dspuserService.loadById(id);
		return "load";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		dspuserService.update(dspuser);
		arg[0]="dspuserAction!list";
		arg[1]="用户管理";
		return SUCCESS;
	}
	
	/**
	 * 是否冻结
	 * @return
	 */
	public String freeze() throws Exception{
		dspuserService.updateFreezeStatusById(status,id);
		return this.list();
	}
	
	
	/**
	 * 修改个人的信息
	 * @return
	 */
	public String updateself() throws Exception{
		Dspuser dspuser1 = (Dspuser)session.get("dspuser");
		int id = 0;
		if(dspuser1!=null){
			id = dspuser1.getId();
		}else{
			String loginfail="会话已过期，请重新登录";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}
		dspuserService.updateBaseInfoById(phone,qq,email,id);
		arg[0]="dspuser_self_update.jsp";
		arg[1]="修改账户信息";
		return SUCCESS;
	}
	
	/**
	 * 修改个人的密码
	 * @return
	 */
	public String updateselfpwd() throws Exception{
		Dspuser dspuser=dspuserService.userlogin(username,oldpwd);
		String failInfo=null;
		if(dspuser==null){
			failInfo="原密码输入有误";
			request.put("failInfo", failInfo);
			return "opfail";
		}else{
			if(newpwd!=null&&!newpwd.equals("")&&againpwd!=null&&!againpwd.equals("")&&againpwd.equals(newpwd)){
				dspuserService.updatePwd(newpwd,dspuser.getId());
				
				arg[0]="dspuser_self_update_pwd.jsp";
				arg[1]="修改密码";
				return SUCCESS;
			}else{
				failInfo="两次密码输入不一致";
				request.put("failInfo", failInfo);
				return "opfail";
			}
		}
	}
	

	
	
	
	//get、set-------------------------------------------
	public IDspuserService getDspuserService() {
		return dspuserService;
	}
	@Resource
	public void setDspuserService(IDspuserService dspuserService) {
		this.dspuserService = dspuserService;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDspuser(Dspuser dspuser) {
		this.dspuser = dspuser;
	}
	
	public Dspuser getDspuser() {
		return dspuser;
	}

//	public String getValidate() {
//		return validate;
//	}
//	public void setValidate(String validate) {
//		this.validate = validate;
//	}
	public List<Dspuser> getDspusers() {
		return dspusers;
	}
	public void setDspusers(List<Dspuser> dspusers) {
		this.dspusers = dspusers;
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
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getAgainpwd() {
		return againpwd;
	}
	public void setAgainpwd(String againpwd) {
		this.againpwd = againpwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
