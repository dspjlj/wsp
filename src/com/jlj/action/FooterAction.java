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

import com.jlj.model.Footer;
import com.jlj.model.Pubclient;
import com.jlj.model.Wgw;
import com.jlj.service.IFooterService;
import com.jlj.service.IWgwService;
import com.opensymphony.xwork2.ActionSupport;

@Component("footerAction")
@Scope("prototype")
public class FooterAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	//service
	private IWgwService wgwService;
	private IFooterService footerService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Wgw wgw;
	private Footer footer;
	//操作参数
	private String[] arg=new String[2];
	
	//前台参数
	private int wgwid;
	//前台=======================================================start
	public String frontFooter(){
		footer = footerService.queryFooterByWgwId(wgwid);
		request.put("footer", footer);
		return NONE;
	}
	
	//=========后台管理=================================================start
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		footer.setPublicaccount(paccount);
		footerService.add(footer);
		
		arg[0]="footerAction!view";
		arg[1]="底部版权设置";
		return SUCCESS;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		footer.setPublicaccount(paccount);
		footerService.update(footer);
		
		arg[0]="footerAction!view";
		arg[1]="底部版权设置";
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
			footer=footerService.queryFooterByPublicAccount(paccount);
			if(footer!=null){
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
	public IFooterService getFooterService() {
		return footerService;
	}
	@Resource
	public void setFooterService(IFooterService footerService) {
		this.footerService = footerService;
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
    //传参
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFooter(Footer footer) {
		this.footer = footer;
	}
	
	public Footer getFooter() {
		return footer;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}

	public Wgw getWgw() {
		return wgw;
	}
	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	public int getWgwid() {
		return wgwid;
	}

	public void setWgwid(int wgwid) {
		this.wgwid = wgwid;
	}
	
	
	
}
