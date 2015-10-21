package com.jlj.action;

import java.net.URLDecoder;
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

import com.jlj.model.Whdgoldeneggrecord;
import com.jlj.service.IPubclientService;
import com.jlj.service.IWhdgoldeneggrecordService;
import com.opensymphony.xwork2.ActionSupport;

@Component("whdgoldeneggrecordAction")
@Scope("prototype")
public class WhdgoldeneggrecordAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private IWhdgoldeneggrecordService whdgoldeneggrecordService;
	private IPubclientService pubclientService;
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Whdgoldeneggrecord whdgoldeneggrecord;
	//分页显示
	private String[] arg=new String[2];
	private List<Whdgoldeneggrecord> whdgoldeneggrecords;
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
	//=========前台显示=================================================
	/**
	 * 砸金蛋记录展示
	 */
	public String frontWhdgoldeneggrecords(){
		whdgoldeneggrecords = whdgoldeneggrecordService.getFrontWhdgoldeneggrecordsByPublicAccount(frontpa);
		request.put("whdgoldeneggrecords", whdgoldeneggrecords);
		return NONE;
	}
	//=========后台管理=================================================
	/**
	 * 砸金蛋记录管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=whdgoldeneggrecordService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=whdgoldeneggrecordService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		whdgoldeneggrecords=whdgoldeneggrecordService.queryList(con,convalue,status,publicaccount,page,size);
		
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
		whdgoldeneggrecordService.add(whdgoldeneggrecord);
		arg[0]="whdgoldeneggrecordAction!list";
		arg[1]="砸金蛋记录管理";
		return SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		whdgoldeneggrecordService.deleteById(id);
		arg[0]="whdgoldeneggrecordAction!list";
		arg[1]="砸金蛋记录管理";
		return SUCCESS;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		whdgoldeneggrecordService.update(whdgoldeneggrecord);
		arg[0]="whdgoldeneggrecordAction!list";
		arg[1]="砸金蛋记录管理";
		return SUCCESS;
	}
	
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		whdgoldeneggrecord=whdgoldeneggrecordService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		whdgoldeneggrecord=whdgoldeneggrecordService.loadById(id);
		return "load";
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
	
	public IWhdgoldeneggrecordService getWhdgoldeneggrecordService() {
		return whdgoldeneggrecordService;
	}
	@Resource
	public void setWhdgoldeneggrecordService(IWhdgoldeneggrecordService whdgoldeneggrecordService) {
		this.whdgoldeneggrecordService = whdgoldeneggrecordService;
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
	
	public void setWhdgoldeneggrecord(Whdgoldeneggrecord whdgoldeneggrecord) {
		this.whdgoldeneggrecord = whdgoldeneggrecord;
	}
	public Whdgoldeneggrecord getWhdgoldeneggrecord() {
		return whdgoldeneggrecord;
	}
	
	public List<Whdgoldeneggrecord> getWhdgoldeneggrecords() {
		return whdgoldeneggrecords;
	}
	public void setWhdgoldeneggrecords(List<Whdgoldeneggrecord> whdgoldeneggrecords) {
		this.whdgoldeneggrecords = whdgoldeneggrecords;
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
	
}
