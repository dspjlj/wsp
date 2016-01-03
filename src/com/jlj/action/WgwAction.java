package com.jlj.action;

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

import com.jlj.model.Bigtype;
import com.jlj.model.Pubclient;
import com.jlj.model.Screenimg;
import com.jlj.model.Wgw;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IScreenimgService;
import com.jlj.service.IWgwService;
import com.opensymphony.xwork2.ActionSupport;

@Component("wgwAction")
@Scope("prototype")
public class WgwAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private IWgwService wgwService;
	private IBigtypeService bigtypeService;
	private IScreenimgService screenimgService;
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Wgw wgw;
	private Screenimg screenimg;
	//分页显示
	private String[] arg=new String[2];
	private List<Wgw> wgws;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	//查询条件
	private int status;//按状态
	private String publicaccount;//公众号原始ID
	private int con;
	private String convalue;
	//仅仅前台
	private String frontpa;
	private List<Bigtype> bigtypes;
	//=========前台显示=================================================
	/**
	 * 微官网首页显示
	 */
	public String index(){
		wgw = wgwService.queryWgwByPublicAccount(frontpa);
		if(wgw==null){
			return NONE;
		}
		bigtypes = bigtypeService.queryIndexBigtypesByWgwId(wgw.getId());
		screenimg = screenimgService.queryScreenimgByWgwId(wgw.getId());
		request.put("wgw", wgw);
		request.put("screenimg", screenimg);
		request.put("bigtypes", bigtypes);
		return NONE;
	}
	//=========后台管理=================================================
	/**
	 * 微官网-设置
	 * @return
	 */
	public String view(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		//判断该公众号的微官网是否存在，不存在跳转到add；存在跳转到load页
		wgw=wgwService.queryWgwByPublicAccount(paccount);
		if(wgw!=null){
			return "load";
		}else{
			return "add";
		}
	}

	/**
	 * 微官网-设置-添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		wgw.setLinkurl("http://#daiding");
		wgwService.add(wgw);
		arg[0]="wgwAction!view";
		arg[1]="微官网设置";
		return SUCCESS;
	}
	
	/**
	 * 微官网-设置-修改
	 * @return
	 */
	public String update() throws Exception{
		wgwService.update(wgw);
		arg[0]="wgwAction!view";
		arg[1]="微官网设置";
		return SUCCESS;
	}
	/**
	 * 进入微官网模板设置页
	 * @return
	 */
	public String template(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		//判断该公众号的微官网是否存在，不存在跳转到add；存在跳转到loadtemplate
		wgw=wgwService.queryWgwByPublicAccount(paccount);
		if(wgw!=null){
			return "loadtemplate";
		}else{
			return "add";
		}
	}
	/**
	 * 修改模板信息
	 * @return
	 */
	private int template1;
	private int template2;
	private int template3;
	private int template4;
	public String updatetemplate(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgwService.updateTemplateByPublicAccount(template1,template2,template3,template4,paccount);
		arg[0]="wgwAction!template";
		arg[1]="微官网模板设置";
		return SUCCESS;
	}
	//get、set-------------------------------------------
	//service注入
	
	
	public IWgwService getWgwService() {
		return wgwService;
	}
	@Resource
	public void setWgwService(IWgwService wgwService) {
		this.wgwService = wgwService;
	}
	
	public IBigtypeService getBigtypeService() {
		return bigtypeService;
	}
	@Resource
	public void setBigtypeService(IBigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
	}
	public IScreenimgService getScreenimgService() {
		return screenimgService;
	}
	@Resource
	public void setScreenimgService(IScreenimgService screenimgService) {
		this.screenimgService = screenimgService;
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
	
	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}
	public Wgw getWgw() {
		return wgw;
	}
	
	public List<Wgw> getWgws() {
		return wgws;
	}
	public void setWgws(List<Wgw> wgws) {
		this.wgws = wgws;
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
	public int getTemplate1() {
		return template1;
	}
	public void setTemplate1(int template1) {
		this.template1 = template1;
	}
	public int getTemplate2() {
		return template2;
	}
	public void setTemplate2(int template2) {
		this.template2 = template2;
	}
	public int getTemplate3() {
		return template3;
	}
	public void setTemplate3(int template3) {
		this.template3 = template3;
	}
	public int getTemplate4() {
		return template4;
	}
	public void setTemplate4(int template4) {
		this.template4 = template4;
	}
	
	
	
	
}
