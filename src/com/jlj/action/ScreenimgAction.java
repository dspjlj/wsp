package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

import com.jlj.model.Pubclient;
import com.jlj.model.Screenimg;
import com.jlj.model.Wgw;
import com.jlj.service.IScreenimgService;
import com.jlj.service.IWgwService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.ToolKitUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("screenimgAction")
@Scope("prototype")
public class ScreenimgAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	//序列化
	private static final long serialVersionUID = 1L;
	//service
	private IWgwService wgwService;
	private IScreenimgService screenimgService;
	//全局请求、会话
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Screenimg screenimg;
	private Wgw wgw;
	//分页显示
	private String[] arg=new String[2];
	private List<Screenimg> screenimgs;
	private String publicaccount;//公众号原始ID
	private int imgtype;
	//上传图片0
	private File picture0;
	private String picture0ContentType;
	private String picture0FileName;
	//上传图片1
	private File picture1;
	private String picture1ContentType;
	private String picture1FileName;
	//上传图片2
	private File picture2;
	private String picture2ContentType;
	private String picture2FileName;
	//上传图片3
	private File picture3;
	private String picture3ContentType;
	private String picture3FileName;
	//上传图片4
	private File picture4;
	private String picture4ContentType;
	private String picture4FileName;
	//上传图片5
	private File picture5;
	private String picture5ContentType;
	private String picture5FileName;
	
	private int isdelpic0;
	private int isdelpic1;
	private int isdelpic2;
	private int isdelpic3;
	private int isdelpic4;
	private int isdelpic5;
	//=========前台显示=================================================
	/**
	 * 前台-获取某种类型、某个公众账号的图片列表
	 * @return
	 */
	public String frontimglist(){
		screenimgs = screenimgService.getScreenimgsByCondition(imgtype,publicaccount);
		request.put("screenimgs", screenimgs);
		return null;
	}
	
	//=========后台管理=================================================
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(picture0!=null){
			String imageName0=DateTimeKit.getDateRandom()+picture0FileName.substring(picture0FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName0,picture0);
			screenimg.setBgimg("res/"+paccount+"/screenimg/"+imageName0);
		}
		if(picture1!=null){
			String imageName1=DateTimeKit.getDateRandom()+picture1FileName.substring(picture1FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName1,picture1);
			screenimg.setImageurl1("res/"+paccount+"/screenimg/"+imageName1);
		}
		if(picture2!=null){
			String imageName2=DateTimeKit.getDateRandom()+picture2FileName.substring(picture2FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName2,picture2);
			screenimg.setImageurl2("res/"+paccount+"/screenimg/"+imageName2);
		}
		if(picture3!=null){
			String imageName3=DateTimeKit.getDateRandom()+picture3FileName.substring(picture3FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName3,picture3);
			screenimg.setImageurl3("res/"+paccount+"/screenimg/"+imageName3);
		}
		if(picture4!=null){
			String imageName4=DateTimeKit.getDateRandom()+picture4FileName.substring(picture4FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName4,picture4);
			screenimg.setImageurl4("res/"+paccount+"/screenimg/"+imageName4);
		}
		if(picture5!=null){
			String imageName5=DateTimeKit.getDateRandom()+picture5FileName.substring(picture5FileName.indexOf("."));
			ToolKitUtil.upload(paccount+"/screenimg",imageName5,picture5);
			screenimg.setImageurl5("res/"+paccount+"/screenimg/"+imageName5);
		}
		screenimg.setPublicaccount(paccount);
		screenimgService.add(screenimg);
		
		arg[0]="screenimgAction!view";
		arg[1]="背景轮播设置";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		if(isdelpic0==0){
			if(picture0!=null){
				String imageName0=DateTimeKit.getDateRandom()+picture0FileName.substring(picture0FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName0,picture0);
				//删除原文件
				File photofile0=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getBgimg());
				photofile0.delete();
				//设置新图片地址
				screenimg.setBgimg("res/"+paccount+"/screenimg/"+imageName0);
			}
		}else{
			//删除原文件
			File photofile0=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getBgimg());
			photofile0.delete();
			screenimg.setBgimg(null);
		}
		
		if(isdelpic1==0){
			if(picture1!=null){
				String imageName1=DateTimeKit.getDateRandom()+picture1FileName.substring(picture1FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName1,picture1);
				//删除原文件
				File photofile1=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl1());
				photofile1.delete();
				//设置新图片地址
				screenimg.setImageurl1("res/"+paccount+"/screenimg/"+imageName1);
			}
		}else{
			//删除原文件
			File photofile1=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl1());
			photofile1.delete();
			screenimg.setImageurl1(null);
		}
		
		if(isdelpic2==0){
			if(picture2!=null){
				String imageName2=DateTimeKit.getDateRandom()+picture2FileName.substring(picture2FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName2,picture2);
				//删除原文件
				File photofile2=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl2());
				photofile2.delete();
				//设置新图片地址
				screenimg.setImageurl2("res/"+paccount+"/screenimg/"+imageName2);
			}
		}else{
			//删除原文件
			File photofile2=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl2());
			photofile2.delete();
			screenimg.setImageurl2(null);
		}
		
		if(isdelpic3==0){
			if(picture3!=null){
				String imageName3=DateTimeKit.getDateRandom()+picture3FileName.substring(picture3FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName3,picture3);
				//删除原文件
				File photofile3=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl3());
				photofile3.delete();
				//设置新图片地址
				screenimg.setImageurl3("res/"+paccount+"/screenimg/"+imageName3);
			}
		}else{
			//删除原文件
			File photofile3=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl3());
			photofile3.delete();
			//设置新图片地址
			screenimg.setImageurl3(null);
		}
			
		if(isdelpic4==0){
			if(picture4!=null){
				String imageName4=DateTimeKit.getDateRandom()+picture4FileName.substring(picture4FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName4,picture4);
				//删除原文件
				File photofile4=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl4());
				photofile4.delete();
				//设置新图片地址
				screenimg.setImageurl4("res/"+paccount+"/screenimg/"+imageName4);
			}
		}else{
			//删除原文件
			File photofile4=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl4());
			photofile4.delete();
			//设置新图片地址
			screenimg.setImageurl4(null);
		}
			
		if(isdelpic5==0){
			if(picture5!=null){
				String imageName5=DateTimeKit.getDateRandom()+picture5FileName.substring(picture5FileName.indexOf("."));
				ToolKitUtil.upload(paccount+"/screenimg",imageName5,picture5);
				//删除原文件
				File photofile5=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl5());
				photofile5.delete();
				//设置新图片地址
				screenimg.setImageurl5("res/"+paccount+"/screenimg/"+imageName5);
			}
		}else{
			//删除原文件
			File photofile5=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl5());
			photofile5.delete();
			//设置新图片地址
			screenimg.setImageurl5(null);
		}
		
		screenimg.setPublicaccount(paccount);
		
		screenimgService.update(screenimg);
		
		arg[0]="screenimgAction!view";
		arg[1]="背景轮播设置";
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
			screenimg=screenimgService.queryScreenimgByPublicAccount(paccount);
			if(screenimg!=null){
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
	public IScreenimgService getScreenimgService() {
		return screenimgService;
	}
	@Resource
	public void setScreenimgService(IScreenimgService screenimgService) {
		this.screenimgService = screenimgService;
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
	
	public void setScreenimg(Screenimg screenimg) {
		this.screenimg = screenimg;
	}
	
	public Screenimg getScreenimg() {
		return screenimg;
	}
	public List<Screenimg> getScreenimgs() {
		return screenimgs;
	}
	public void setScreenimgs(List<Screenimg> screenimgs) {
		this.screenimgs = screenimgs;
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
	
	public int getImgtype() {
		return imgtype;
	}

	public void setImgtype(int imgtype) {
		this.imgtype = imgtype;
	}

	public Wgw getWgw() {
		return wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	public File getPicture1() {
		return picture1;
	}

	public void setPicture1(File picture1) {
		this.picture1 = picture1;
	}

	public String getPicture1ContentType() {
		return picture1ContentType;
	}

	public void setPicture1ContentType(String picture1ContentType) {
		this.picture1ContentType = picture1ContentType;
	}

	public String getPicture1FileName() {
		return picture1FileName;
	}

	public void setPicture1FileName(String picture1FileName) {
		this.picture1FileName = picture1FileName;
	}

	public File getPicture2() {
		return picture2;
	}

	public void setPicture2(File picture2) {
		this.picture2 = picture2;
	}

	public String getPicture2ContentType() {
		return picture2ContentType;
	}

	public void setPicture2ContentType(String picture2ContentType) {
		this.picture2ContentType = picture2ContentType;
	}

	public String getPicture2FileName() {
		return picture2FileName;
	}

	public void setPicture2FileName(String picture2FileName) {
		this.picture2FileName = picture2FileName;
	}

	public File getPicture3() {
		return picture3;
	}

	public void setPicture3(File picture3) {
		this.picture3 = picture3;
	}

	public String getPicture3ContentType() {
		return picture3ContentType;
	}

	public void setPicture3ContentType(String picture3ContentType) {
		this.picture3ContentType = picture3ContentType;
	}

	public String getPicture3FileName() {
		return picture3FileName;
	}

	public void setPicture3FileName(String picture3FileName) {
		this.picture3FileName = picture3FileName;
	}

	public File getPicture4() {
		return picture4;
	}

	public void setPicture4(File picture4) {
		this.picture4 = picture4;
	}

	public String getPicture4ContentType() {
		return picture4ContentType;
	}

	public void setPicture4ContentType(String picture4ContentType) {
		this.picture4ContentType = picture4ContentType;
	}

	public String getPicture4FileName() {
		return picture4FileName;
	}

	public void setPicture4FileName(String picture4FileName) {
		this.picture4FileName = picture4FileName;
	}

	public File getPicture5() {
		return picture5;
	}

	public void setPicture5(File picture5) {
		this.picture5 = picture5;
	}

	public String getPicture5ContentType() {
		return picture5ContentType;
	}

	public void setPicture5ContentType(String picture5ContentType) {
		this.picture5ContentType = picture5ContentType;
	}

	public String getPicture5FileName() {
		return picture5FileName;
	}

	public void setPicture5FileName(String picture5FileName) {
		this.picture5FileName = picture5FileName;
	}

	public File getPicture0() {
		return picture0;
	}

	public void setPicture0(File picture0) {
		this.picture0 = picture0;
	}

	public String getPicture0ContentType() {
		return picture0ContentType;
	}

	public void setPicture0ContentType(String picture0ContentType) {
		this.picture0ContentType = picture0ContentType;
	}

	public String getPicture0FileName() {
		return picture0FileName;
	}

	public void setPicture0FileName(String picture0FileName) {
		this.picture0FileName = picture0FileName;
	}

	public int getIsdelpic0() {
		return isdelpic0;
	}

	public void setIsdelpic0(int isdelpic0) {
		this.isdelpic0 = isdelpic0;
	}

	public int getIsdelpic1() {
		return isdelpic1;
	}

	public void setIsdelpic1(int isdelpic1) {
		this.isdelpic1 = isdelpic1;
	}

	public int getIsdelpic2() {
		return isdelpic2;
	}

	public void setIsdelpic2(int isdelpic2) {
		this.isdelpic2 = isdelpic2;
	}

	public int getIsdelpic3() {
		return isdelpic3;
	}

	public void setIsdelpic3(int isdelpic3) {
		this.isdelpic3 = isdelpic3;
	}

	public int getIsdelpic4() {
		return isdelpic4;
	}

	public void setIsdelpic4(int isdelpic4) {
		this.isdelpic4 = isdelpic4;
	}

	public int getIsdelpic5() {
		return isdelpic5;
	}

	public void setIsdelpic5(int isdelpic5) {
		this.isdelpic5 = isdelpic5;
	}
	
	
}
