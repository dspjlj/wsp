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

import com.jlj.model.Autores;
import com.jlj.model.Pubclient;
import com.jlj.model.Publickey;
import com.jlj.service.IPublickeyService;
import com.opensymphony.xwork2.ActionSupport;

@Component("publickeyAction")
@Scope("prototype")
public class PublickeyAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPublickeyService publickeyService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Publickey publickey;
	//分页显示
	private String[] arg=new String[2];
	private List<Publickey> publickeys;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	//条件
	private int con;
	private String convalue;
	
	
	/**
	 * 关键词分组管理
	 */
	public String list() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=publickeyService.getTotalCount(con,convalue,publicaccount);
		//总页数
		pageCount=publickeyService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		publickeys=publickeyService.queryList(con,convalue,publicaccount,page,size);
		
		return "list";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
		publickeyService.add(publickey);
		
		arg[0]="publickeyAction!list";
		arg[1]="关键词分组管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		publickeyService.deleteById(id);
		return this.list();
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		publickey=publickeyService.loadById(id);
		return "load";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		publickeyService.update(publickey);
		
		arg[0]="publickeyAction!list";
		arg[1]="关键词分组管理";
		return SUCCESS;
	}
	
	
	
	
	//get、set-------------------------------------------
	public IPublickeyService getPublickeyService() {
		return publickeyService;
	}
	@Resource
	public void setPublickeyService(IPublickeyService publickeyService) {
		this.publickeyService = publickeyService;
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
	
	public void setPublickey(Publickey publickey) {
		this.publickey = publickey;
	}
	
	public Publickey getPublickey() {
		return publickey;
	}
	public List<Publickey> getPublickeys() {
		return publickeys;
	}
	public void setPublickeys(List<Publickey> publickeys) {
		this.publickeys = publickeys;
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
	
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	
	
	
}
