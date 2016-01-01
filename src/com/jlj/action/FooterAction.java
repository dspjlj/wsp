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
	//分页显示
	private String[] arg=new String[2];
	private List<Footer> footers;
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
	
	//=========后台管理=================================================
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
	public List<Footer> getFooters() {
		return footers;
	}
	public void setFooters(List<Footer> footers) {
		this.footers = footers;
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

	public Wgw getWgw() {
		return wgw;
	}
	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}
	
	
}
