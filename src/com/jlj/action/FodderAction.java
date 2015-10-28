package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Fodder;
import com.jlj.model.Fodderarticle;
import com.jlj.model.Pubclient;
import com.jlj.service.IFodderService;
import com.jlj.service.IFodderarticleService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.jlj.vo.NewVo;
import com.opensymphony.xwork2.ActionSupport;

@Component("fodderAction")
@Scope("prototype")
public class FodderAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IFodderService fodderService;
	private IFodderarticleService fodderarticleService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Fodder fodder;
	//分页显示
	private String[] arg=new String[2];
	private List<Fodder> fodders;
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
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	
	//查询列表===============================================start
	/**
	 * 后台-素材管理-多图文列表
	 */
	public String list() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 6;//图文news
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "list";
	}
	/**
	 * 后台-素材管理-文本列表
	 */
	public String textlist() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 1;//文字text
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "textlist";
	}
	/**
	 * 后台-素材管理-图片列表
	 */
	public String imagelist() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 2;//图片image
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "imagelist";
	}
	/**
	 * 后台-素材管理-语音列表
	 */
	public String voicelist() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 3;//语音voice
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "voicelist";
	}
	/**
	 * 后台-素材管理-视频列表
	 */
	public String videolist() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 4;//视频video
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "videolist";
	}
	/**
	 * 后台-素材管理-音乐列表
	 */
	public String musiclist() throws Exception{
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		status = 5;//音乐music
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
		//总页数
		pageCount=fodderService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		
		return "musiclist";
	}
	//查询列表===============================================end
	
	//操作图文===============================================start
	/**
	 * 添加-单图文
	 * @return
	 * @throws Exception
	 */
	private String musicdes;
	private String newsdes;
	public String add() throws Exception{
		//保存图片以及图片链接
		if(picture!=null){
			String paccount=fodder.getPublicaccount();//获取原始ID
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(paccount,imageName,picture);
			fodder.setPicurl("res/"+paccount+"/"+imageName);//设置图片地址全称
			
		}
		//保存正文描述
		if(newsdes!=null&&!newsdes.equals("")){
			fodder.setDescription(newsdes);
		}
//		else if(musicdes!=null&&!musicdes.equals("")){
//			fodder.setDescription(musicdes);
//		}
		//保存素材类型
//		int savetype= fodder.getSavetype();
		int savetype= 6;
		fodder.setSavetype(savetype);//保存类型6、news
//		if(savetype==1){
//			fodder.setMsgtype("text");
//		}else if(savetype==5){
//			fodder.setMsgtype("music");
//		}else if(savetype==6){
			fodder.setMsgtype("news");//用于取数据回复到微信服务器
//			//保存图文消息个数
//			if(fodder.getFuncflag()==0){
//				fodder.setArticlecount(1);
//			}else{
//				fodder.setArticlecount(0);
//			}
//			
//		}
		//保存创建日期
		fodder.setCreatedate(new Date());
		
		fodderService.add(fodder);
		
		arg[0]="fodderAction!list";
		arg[1]="素材管理";
		return SUCCESS;
	}
	
	/**
	 * 多图文添加
	 * @return
	 * @throws Exception
	 */
	private List<Fodderarticle> fodderarticles;
	private int fodderid;//供子图文页面显示
	String data;
	public String muladd() throws Exception{
		System.out.println("muladd start");
//		for (int i = 0; i < data.length; i++) {
//			System.out.println(data[i].toString());
//		}
//		System.out.println(data);
		String jsondata=data.substring(data.indexOf(":")+1, data.lastIndexOf("]")+1);
//		System.out.println(jsondata);
		JSONArray json =JSONArray.fromObject(jsondata);
		List<NewVo> newvos =(List<NewVo>)JSONArray.toCollection(json,NewVo.class);
		int articlecount = newvos.size();
		String newstitle = newvos.get(0).getTit();
		String coverurl = newvos.get(0).getPic();
		fodder = new Fodder();
		fodder.setArticlecount(articlecount);//保存文章数量
//		fodder.setContent(content);
		fodder.setCreatedate(new Date());//保存创建日期
//		fodder.setDescription(description)
//		fodder.setFodderarticles(fodderarticles)
		fodder.setFuncflag(1);//单图文0、多图文1
		fodder.setMsgtype("news");//保存消息类型
		fodder.setPicurl(coverurl);
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		fodder.setPublicaccount(publicaccount);
		fodder.setSavetype(6);//6:news
		fodder.setTitle(newstitle);//图文总标题
//		fodder.setUrl(url);
		fodderid = fodderService.addreturn(fodder);//保存图文素材
		
		
		//保存各个子图文的资源
		for (int i = 0; i < articlecount; i++) {
			NewVo newvo = newvos.get(i);
			//解析data并获取每个数组中的值
			String title = newvo.getTit();
			String picurl = newvo.getPic();
			String description = newvo.getCon();
			String linkurl = newvo.getUrl();
			Fodderarticle fodderarticle = new Fodderarticle();
			fodderarticle.setDescription(description);
			fodderarticle.setFodder(fodder);//父级news素材
			fodderarticle.setPicurl(picurl);
			fodderarticle.setTitle(title);
			fodderarticle.setUrl(linkurl);
			fodderarticleService.add(fodderarticle);
			
		}
		return NONE;
	}
	
	/**
	 * 删除-单图文或多图文
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		Fodder fodder=fodderService.loadById(id);
		//删除图片
		//如果是单图文，删除该记录中的图片即可，若是多图文，循环删除子图文的图；
		if(fodder==null){
			return this.list();
		}
		int savetype = fodder.getSavetype();
		int funcflag = fodder.getFuncflag();
		if(savetype==6&&funcflag==0){
//			System.out.println(ServletActionContext.getServletContext().getRealPath("/")+fodder.getPicurl());
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodder.getPicurl());
			photofile.delete();
		}else if(savetype==6&&funcflag==1){
			List<Fodderarticle> fodderarticles = fodderarticleService.queryFodderarticlesByFodderid(id);
			for (Fodderarticle fodderarticle : fodderarticles) {
				String sonpicurl = fodderarticle.getPicurl();
				sonpicurl = ServletActionContext.getServletContext().getRealPath("/")+sonpicurl.substring(sonpicurl.indexOf("res/"));
//				System.out.println(sonpicurl);
				File photofile=new File(sonpicurl);
				photofile.delete();
			}
		}
		
		fodderService.delete(fodder);
		
		return this.list();
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		fodder=fodderService.loadById(id);
		int savetype=fodder.getSavetype();
		if(savetype==5){
			musicdes = fodder.getDescription();
		}else if(savetype==6){
			newsdes = fodder.getDescription();
		}
		return "load";
	}
	
	/**
	 * 跳转到单图文/多图文修改页面
	 * @return
	 */
	public String loadnews() throws Exception{
		fodder=fodderService.loadById(id);
		int articlecount=fodder.getArticlecount();
		if(articlecount==1){
			//单图文
			return "loadone";
		}else{
			//多图文
			fodderarticles = fodder.getFodderarticles();
			return "loadmore"; 
		}
		
	}
	
	/**
	 * 修改-单图文
	 * @return
	 */
	public String updateone() throws Exception{
		//保存图片以及图片链接
		if(picture!=null){
			String paccount=fodder.getPublicaccount();//获取原始ID
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));//获取图片文件名称
			ToolKitUtil.upload(paccount,imageName,picture);
			fodder.setPicurl("res/"+paccount+"/"+imageName);//设置图片地址全称
			
		}
		//保存正文描述
		if(newsdes!=null&&!newsdes.equals("")){
			fodder.setDescription(newsdes);
		}
		
		fodderService.update(fodder);
		arg[0]="fodderAction!list";
		arg[1]="素材管理";
		return SUCCESS;
	}
	/**
	 * 修改-多图文
	 * @return
	 */
	public String updatemore() throws Exception{
		System.out.println("updatemore start");
//		System.out.println(data);
		String fodderidstr = data.substring(data.indexOf("fodderid\":")+10,data.indexOf(",\"data\":"));
//		System.out.println(fodderidstr);
		String jsondata=data.substring(data.indexOf("data\":")+6, data.lastIndexOf("]")+1);
//		System.out.println(jsondata);
		
		JSONArray json =JSONArray.fromObject(jsondata);
		List<NewVo> newvos =(List<NewVo>)JSONArray.toCollection(json,NewVo.class);
		
		int fodderid = Integer.parseInt(fodderidstr);
		Fodder afodder = fodderService.loadById(fodderid);
		int oldarticlecount = afodder.getArticlecount();//原图文数量
		int articlecount = newvos.size();//图文数量
		//若删除某子图文，则需要删除该子图文
		if(oldarticlecount>articlecount){
			//存储可以删除的子图文id
			List<Integer> canDelIds = new ArrayList<Integer>();
			
			List<Fodderarticle> fodderarticles = afodder.getFodderarticles();
			for(int i = 0; i < oldarticlecount; i++) {
				int farticleid = fodderarticles.get(i).getId();//循环获取旧的子图文的id
				boolean isCanDel = false;
				//循环匹配json字符串，找是否在里面，若没在里面，则标记
				for (int j = 0; j < articlecount; j++) {
					NewVo newvo = newvos.get(j);
					//解析data并获取每个数组中的值
					int articleid = newvo.getId();
					if(farticleid==articleid){
						//找到
						break;
					}
					if(j==articlecount-1){
						//本次循环都没找到该ID，说明已经被删除
						isCanDel=true;
					}
				}
				if(isCanDel){
					canDelIds.add(farticleid);
					
				}
				
			}
			
			//循环删除这些子图文
			for (Integer canDelId : canDelIds) {
				System.out.println("canDelId="+canDelId);
				Fodderarticle fodderarticle = fodderarticleService.loadById(canDelId);
				afodder.getFodderarticles().remove(fodderarticle);
				fodderarticle.setFodder(null);
				fodderarticleService.delete(fodderarticle);
			}
			
		}
		
		//修改各个子图文的资源
		for (int i = 0; i < articlecount; i++) {
			NewVo newvo = newvos.get(i);
			//解析data并获取每个数组中的值
			int articleid = newvo.getId();
			String title = newvo.getTit();
			String picurl = newvo.getPic();
			String description = newvo.getCon();
			String linkurl = newvo.getUrl();
			//若已存在改id，修改；若不存在id，新增子图文
			if(articleid!=0){
				fodderarticleService.updateSomethingById(title,description,picurl,linkurl,articleid);
				
			}else{
				
				Fodderarticle fodderarticle = new Fodderarticle();
				fodderarticle.setDescription(description);
				fodderarticle.setPicurl(picurl);
				fodderarticle.setTitle(title);
				fodderarticle.setUrl(linkurl);
				fodderarticle.setFodder(afodder);
				fodderarticleService.add(fodderarticle);
			}
			
		}
		
		
		String newstitle = newvos.get(0).getTit();//大图文标题
		String coverurl = newvos.get(0).getPic();//大图文图片地址
		//修改大图文
		fodderService.updateSomethingById(articlecount,newstitle,coverurl,fodderid);
		return NONE;
		
	}
	//操作图文===============================================end
	
	
	//操作文本===============================================start
	/**
	 * 添加-单图文
	 * @return
	 * @throws Exception
	 */
	private String title;
	private String content;
	public String addtext() throws Exception{
		fodder = new Fodder();
		fodder.setMsgtype("text");//用于取数据回复到微信服务器
		fodder.setSavetype(1);//保存类型1、text
		fodder.setContent(content);
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		fodder.setPublicaccount(paccount);
		fodder.setTitle(title);
		//保存创建日期
		fodder.setCreatedate(new Date());
		
		fodderService.add(fodder);
		
		arg[0]="fodderAction!textlist";
		arg[1]="素材管理";
		return SUCCESS;
	}
	
	/**
	 * 跳转到文本修改页面
	 * @return
	 */
	public String loadtext() throws Exception{
		fodder=fodderService.loadById(id);
		return "loadtext";
		
	}
	
	public String updatetext() throws Exception{
		
		
		arg[0]="fodderAction!textlist";
		arg[1]="素材管理";
		return SUCCESS;
	}
	//操作文本===============================================end
	
	
	private String currentpage;
	public String choosefodder(){
		//所有当前页记录对象[根据条件、条件值、类型id、公众号原始ID]
		fodders=fodderService.querySavetypeList(con,convalue,status,publicaccount);
		//总记录数
		totalCount=fodderService.getSavetypeTotalCount(con,convalue,status,publicaccount);
		return "fodderchooselist";
	}
	
	public String refreshSessionAs(){
		Fodder thisfodder = fodderService.loadById(fodderid);
		if(thisfodder!=null){
			String sucainame = thisfodder.getTitle();
			session.put("sucainame", sucainame);
			session.put("fodderid", fodderid);
		}
		arg[0]=currentpage+".jsp";
		arg[1]="素材选定";
		return SUCCESS;
	}
	
	
	
	
	//get、set-------------------------------------------
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
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
	
	public void setFodder(Fodder fodder) {
		this.fodder = fodder;
	}
	
	public Fodder getFodder() {
		return fodder;
	}
	public List<Fodder> getFodders() {
		return fodders;
	}
	public void setFodders(List<Fodder> fodders) {
		this.fodders = fodders;
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
	public IFodderarticleService getFodderarticleService() {
		return fodderarticleService;
	}
	@Resource
	public void setFodderarticleService(IFodderarticleService fodderarticleService) {
		this.fodderarticleService = fodderarticleService;
	}
	public List<Fodderarticle> getFodderarticles() {
		return fodderarticles;
	}
	public void setFodderarticles(List<Fodderarticle> fodderarticles) {
		this.fodderarticles = fodderarticles;
	}
	public int getFodderid() {
		return fodderid;
	}
	public void setFodderid(int fodderid) {
		this.fodderid = fodderid;
	}
	public String getMusicdes() {
		return musicdes;
	}
	public void setMusicdes(String musicdes) {
		this.musicdes = musicdes;
	}
	public String getNewsdes() {
		return newsdes;
	}
	public void setNewsdes(String newsdes) {
		this.newsdes = newsdes;
	}
	public String getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(String currentpage) {
		this.currentpage = currentpage;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
