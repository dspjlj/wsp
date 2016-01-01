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

import com.jlj.model.Pubclient;
import com.jlj.model.Wgw;
import com.jlj.model.Wgwmenu;
import com.jlj.service.IPubclientService;
import com.jlj.service.IWgwService;
import com.jlj.service.IWgwmenuService;
import com.opensymphony.xwork2.ActionSupport;

@Component("wgwmenuAction")
@Scope("prototype")
public class WgwmenuAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private IWgwService wgwService;
	private IWgwmenuService wgwmenuService;
	
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Wgw wgw;
	private Wgwmenu wgwmenu;
	//分页显示
	private String[] arg=new String[2];
	private List<Wgwmenu> wgwmenus;
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
//	/**
//	 * 微官网菜单展示
//	 */
//	public String frontWgwmenus(){
//		wgwmenus = wgwmenuService.getFrontWgwmenusByPublicAccount(frontpa);
//		request.put("wgwmenus", wgwmenus);
//		return NONE;
//	}
	//=========后台管理=================================================
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgwmenu.setPublicaccount(paccount);
		wgwmenuService.add(wgwmenu);
		arg[0]="wgwmenuAction!view";
		arg[1]="微官网菜单设置";
		return SUCCESS;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgwmenu.setPublicaccount(paccount);
		wgwmenuService.update(wgwmenu);
		arg[0]="wgwmenuAction!view";
		arg[1]="微官网菜单设置";
		return SUCCESS;
	}
	
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		wgw=wgwService.queryWgwByPublicAccount(paccount);
		if(wgw!=null){
			//判断该公众号的轮播图片是否存在，不存在跳转到add；存在跳转到load页
			wgwmenu=wgwmenuService.queryWgwmenuByPublicAccount(paccount);
			if(wgwmenu!=null){
				return "load";
			}else{
				return "add";
			}
		}else{
			//请先设置微官网
			arg[0]="wgwAction!view";
			arg[1]="微官网设置";
			String goInfo = "请先设置微官网";
			request.put("goInfo", goInfo);
			return "goanother";
		}
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
	public IWgwmenuService getWgwmenuService() {
		return wgwmenuService;
	}
	@Resource
	public void setWgwmenuService(IWgwmenuService wgwmenuService) {
		this.wgwmenuService = wgwmenuService;
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
	
	public void setWgwmenu(Wgwmenu wgwmenu) {
		this.wgwmenu = wgwmenu;
	}
	public Wgwmenu getWgwmenu() {
		return wgwmenu;
	}
	
	public List<Wgwmenu> getWgwmenus() {
		return wgwmenus;
	}
	public void setWgwmenus(List<Wgwmenu> wgwmenus) {
		this.wgwmenus = wgwmenus;
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

	public Wgw getWgw() {
		return wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}
	
	
	
}
