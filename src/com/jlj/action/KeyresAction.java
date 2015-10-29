package com.jlj.action;

import java.io.PrintWriter;
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

import com.jlj.model.Fodder;
import com.jlj.model.Keyres;
import com.jlj.model.Publickey;
import com.jlj.service.IFodderService;
import com.jlj.service.IKeyresService;
import com.opensymphony.xwork2.ActionSupport;

@Component("keyresAction")
@Scope("prototype")
public class KeyresAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	//sevice
	private IKeyresService keyresService;
	private IFodderService fodderService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Keyres keyres;
	//分页显示
	private String[] arg=new String[2];
	private List<Keyres> keyress;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pkid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	/**
	 * 关键词管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=keyresService.getTotalCountByPkid(con,convalue,status,pkid);
		//总页数
		pageCount=keyresService.getPageCountByPkid(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		keyress=keyresService.queryListByPkid(con,convalue,status,pkid,page,size);
		
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		//清空session，并跳转到add页
		session.put("sucainame", "");
		session.put("fodderid", "");
		session.put("pkid", pkid);
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
		pkid = (Integer)session.get("pkid");
		keyresService.add(keyres);
		
		arg[0]="keyresAction!list?pkid="+pkid;
		arg[1]="关键词管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		keyresService.deleteById(id);
		return this.list();
	}
	
	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	private String ids;
	public String deleteids(){
		System.out.println(ids);

		PrintWriter out= null;
		try {
			out=response.getWriter();
			keyresService.deleteByIds(ids);
			out.print(1);
		} catch (Exception e) {
			e.printStackTrace();
			out.print(0);
		}
		
		return NONE;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		keyres=keyresService.loadById(id);
		
		//查出该素材，并重新覆盖素材名、素材编号和关键词回复对象
		int fodderid=keyres.getFodderid();
		Fodder fodder=fodderService.loadById(fodderid);
		session.put("sucainame", fodder.getTitle());
		session.put("fodderid", fodderid);
		session.put("keyres", keyres);
		session.put("pkid", pkid);
		return "load";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		pkid = (Integer)session.get("pkid");
		keyresService.update(keyres);
		arg[0]="keyresAction!list?pkid="+pkid;
		arg[1]="关键词管理";
		return SUCCESS;
	}
	
	
	
	
	//get、set-------------------------------------------
	public IKeyresService getKeyresService() {
		return keyresService;
	}
	@Resource
	public void setKeyresService(IKeyresService keyresService) {
		this.keyresService = keyresService;
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
	
	public void setKeyres(Keyres keyres) {
		this.keyres = keyres;
	}
	
	public Keyres getKeyres() {
		return keyres;
	}
	public List<Keyres> getKeyress() {
		return keyress;
	}
	public void setKeyress(List<Keyres> keyress) {
		this.keyress = keyress;
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

	
	public int getPkid() {
		return pkid;
	}
	public void setPkid(int pkid) {
		this.pkid = pkid;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
