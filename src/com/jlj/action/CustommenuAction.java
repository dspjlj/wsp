package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jlj.menu.MenuManager;
import com.jlj.model.Custommenu;
import com.jlj.model.Fodder;
import com.jlj.model.Pubclient;
import com.jlj.service.ICustommenuService;
import com.jlj.service.IFodderService;
import com.jlj.util.CommonUtil;
import com.jlj.util.MenuUtil;
import com.jlj.util.Token;
import com.jlj.vo.MenuVo;
import com.jlj.vo.MenusonData;
import com.opensymphony.xwork2.ActionSupport;

@Component("custommenuAction")
@Scope("prototype")
public class CustommenuAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private ICustommenuService custommenuService;
	private IFodderService fodderService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Custommenu custommenu;
	//分页显示
	private String[] arg=new String[2];
	private List<Custommenu> custommenus;
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
	
	
	/**
	 * 自定义菜单管理-给管理员
	 */
//	public String list() throws Exception{
//		if(convalue!=null&&!convalue.equals("")){
//			convalue=URLDecoder.decode(convalue, "utf-8");
//		}
//		if(page<1){
//			page=1;
//		}
//		//总页数
//		pageCount=custommenuService.getPageCount(con,convalue,status,publicaccount,size);
//		if(page>pageCount&&pageCount!=0){
//			page=pageCount;
//		}
//		//所有当前页记录对象
//		custommenus=custommenuService.queryList(con,convalue,status,publicaccount,page,size);
//		//总记录数
//		totalCount=custommenuService.getTotalCount(con,convalue,status,publicaccount);
//		return "list";
//	}
	
	/**
	 * 删除
	 * @return
	 */
//	public String delete(){
//		Pubclient pubclient = (Pubclient)session.get("pubclient");
//		String paccount=pubclient.getPublicaccount();
//		custommenuService.deleteById(id);
//		
//		arg[0]="custommenuAction!list?publicaccount="+paccount;
//		arg[1]="自定义菜单管理";
//		return SUCCESS;
//	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
//	public String load(){
//		custommenu=custommenuService.loadById(id);
//		return "load";
//	}
	
	//公众号运营者操作-----------------start
	/**
	 * 查看信息-入口
	 * @return
	 */
	private String initjson;
	public String view(){
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		//判断该公众号的自定菜单是否存在，不存在跳转到add；存在跳转到view
		custommenu=custommenuService.queryCustommenuByPublicAccount(paccount);
		if(custommenu!=null){
			//获取素材列表
			fodders = fodderService.getFoddersByPublicAccount(paccount);
			//获取所有自定义菜单的设置内容，并组装成json数据
			return "load";
		}else{
			return this.goToAdd();
		}
		
	}
	
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	private List<Fodder> fodders;
	public String goToAdd(){
		//获取素材列表
		String paccount=((Pubclient)session.get("pubclient")).getPublicaccount();
		fodders = fodderService.getFoddersByPublicAccount(paccount);
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	private String data;
	public String muladd() throws Exception{
		String[] menuarray= new String[94];
		menuarray[0]="添加菜单";
		System.out.println("add data=\n"+data);
		//gson解析
		Gson gson = new Gson();
		List<MenuVo> menuvos =gson.fromJson(data, new TypeToken<List<MenuVo>>() { }.getType());
//		for (MenuVo menuVo : menuvos) {
//			System.out.println(menuVo.getTyp()+","+menuVo.getData()+","+menuVo.getTit());//res_tw,18,微官网
//			Map<String,MenusonData> subdata = menuVo.getSubdata();
//			if(subdata==null){
//				continue;
//			}
//			for (Entry<String,MenusonData> subdataEntry : subdata.entrySet()) {
//				System.out.println("subdataEntry:"+subdataEntry.getKey());//subdataEntry:zizicd1
//				MenusonData menusonData = subdataEntry.getValue();
//				
//				//menusonData:{活动2,res_music,17}
//				//menusonData:{活动3,res_url,www.baidu.com}
//				System.out.println("menusonData:"+menusonData);
//			}
//		}
		
		for (int i = 1; i <= menuvos.size(); i++) {
			MenuVo menuVo = menuvos.get(i-1);
			System.out.println(menuVo.getTyp()+","+menuVo.getData()+","+menuVo.getTit());//res_tw,18,微官网
			menuarray[i]=menuVo.getTit();//1-2-3位置：主菜单大菜单名
			Map<String,MenusonData> subdata = menuVo.getSubdata();
			if(subdata==null){
				menuarray[i+3] = "1";//4-5-6位置：主菜单是子节点
				//7-8-9 ~ 10-11-12 ~ 13-14-15位置：menu1type、menu1key、menu1url、menu2type、menu2key、menu2url、menu3type、menu3key、menu3url
				//76-77-78 菜单大菜单回复素材
				if(i==1){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[7] = "view";
						menuarray[8] = "menuarray8";
						menuarray[9] = menuVo.getData();//url
					}else{
						menuarray[7] = "click";
						menuarray[8] = "menuarray8";
						menuarray[76] = menuVo.getData();//resid
					}
				}else if(i==2){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[10] = "view";
						menuarray[11] = "menuarray11";
						menuarray[12] = menuVo.getData();
					}else{
						menuarray[10] = "click";
						menuarray[11] = "menuarray11";
						menuarray[77] = menuVo.getData();
					}
				}else if(i==3){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[13] = "view";
						menuarray[14] = "menuarray14";
						menuarray[15] = menuVo.getData();
					}else{
						menuarray[13] = "click";
						menuarray[14] = "menuarray14";
						menuarray[78] = menuVo.getData();
					}
				}
				
				continue;
			}else{
				menuarray[i+3] = "0";//4-5-6位置：主菜单不是子节点
			}
			int j=1;
			for (Entry<String,MenusonData> subdataEntry : subdata.entrySet()) {
				System.out.println("subdataEntry:"+subdataEntry.getKey());//subdataEntry:zizicd1
				MenusonData menusonData = subdataEntry.getValue();//menusonData:{活动2,res_music,17}//menusonData:{活动3,res_url,www.baidu.com}
				System.out.println("menusonData:"+menusonData.getTit()+","+menusonData.getTyp()+","+menusonData.getData());
				
				if(i==1){
					//16~20 menu1son1、menu1son2、menu1son3、menu1son4、menu1son5
					menuarray[15+j]=menusonData.getTit();
					//31~45 menuXsonXtype key url
					//79~83 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[31] = "view";
							menuarray[32] = "menuarray32";
							menuarray[33] = menusonData.getData();
						}else if(j==2){
							menuarray[34] = "view";
							menuarray[35] = "menuarray35";
							menuarray[36] = menusonData.getData();
						}else if(j==3){
							menuarray[37] = "view";
							menuarray[38] = "menuarray38";
							menuarray[39] = menusonData.getData();
						}else if(j==4){
							menuarray[40] = "view";
							menuarray[41] = "menuarray41";
							menuarray[42] = menusonData.getData();
						}else if(j==5){
							menuarray[43] = "view";
							menuarray[44] = "menuarray44";
							menuarray[45] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[31] = "click";
							menuarray[32] = "menuarray32";
							menuarray[79] = menusonData.getData();
						}else if(j==2){
							menuarray[34] = "click";
							menuarray[35] = "menuarray35";
							menuarray[80] = menusonData.getData();
						}else if(j==3){
							menuarray[37] = "click";
							menuarray[38] = "menuarray38";
							menuarray[81] = menusonData.getData();
						}else if(j==4){
							menuarray[40] = "click";
							menuarray[41] = "menuarray41";
							menuarray[82] = menusonData.getData();
						}else if(j==5){
							menuarray[43] = "click";
							menuarray[44] = "menuarray44";
							menuarray[83] = menusonData.getData();
						}
					}
				}else if (i==2) {
					//21~25 menu2son1、menu2son2、menu2son3、menu2son4、menu2son5
					menuarray[20+j]=menusonData.getTit();
					//46~60 menuXsonXtype key url
					//84~88 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[46] = "view";
							menuarray[47] = "menuarray47";
							menuarray[48] = menusonData.getData();
						}else if(j==2){
							menuarray[49] = "view";
							menuarray[50] = "menuarray50";
							menuarray[51] = menusonData.getData();
						}else if(j==3){
							menuarray[52] = "view";
							menuarray[53] = "menuarray53";
							menuarray[54] = menusonData.getData();
						}else if(j==4){
							menuarray[55] = "view";
							menuarray[56] = "menuarray56";
							menuarray[57] = menusonData.getData();
						}else if(j==5){
							menuarray[58] = "view";
							menuarray[59] = "menuarray59";
							menuarray[60] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[46] = "click";
							menuarray[47] = "menuarray47";
							menuarray[84] = menusonData.getData();
						}else if(j==2){
							menuarray[49] = "click";
							menuarray[50] = "menuarray50";
							menuarray[85] = menusonData.getData();
						}else if(j==3){
							menuarray[52] = "click";
							menuarray[53] = "menuarray53";
							menuarray[86] = menusonData.getData();
						}else if(j==4){
							menuarray[55] = "click";
							menuarray[56] = "menuarray56";
							menuarray[87] = menusonData.getData();
						}else if(j==5){
							menuarray[58] = "click";
							menuarray[59] = "menuarray59";
							menuarray[88] = menusonData.getData();
						}
					}
				}else if(i==3){
					//26~30 menu3son1、menu3son2、menu3son3、menu3son4、menu3son5
					menuarray[25+j]=menusonData.getTit();
					//61~75 menuXsonXtype key url
					//89~93 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[61] = "view";
							menuarray[62] = "menuarray62";
							menuarray[63] = menusonData.getData();
						}else if(j==2){
							menuarray[64] = "view";
							menuarray[65] = "menuarray65";
							menuarray[66] = menusonData.getData();
						}else if(j==3){
							menuarray[67] = "view";
							menuarray[68] = "menuarray68";
							menuarray[69] = menusonData.getData();
						}else if(j==4){
							menuarray[70] = "view";
							menuarray[71] = "menuarray71";
							menuarray[72] = menusonData.getData();
						}else if(j==5){
							menuarray[73] = "view";
							menuarray[74] = "menuarray74";
							menuarray[75] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[61] = "click";
							menuarray[62] = "menuarray62";
							menuarray[89] = menusonData.getData();
						}else if(j==2){
							menuarray[64] = "click";
							menuarray[65] = "menuarray65";
							menuarray[90] = menusonData.getData();
						}else if(j==3){
							menuarray[67] = "click";
							menuarray[68] = "menuarray68";
							menuarray[91] = menusonData.getData();
						}else if(j==4){
							menuarray[70] = "click";
							menuarray[71] = "menuarray71";
							menuarray[92] = menusonData.getData();
						}else if(j==5){
							menuarray[73] = "click";
							menuarray[74] = "menuarray74";
							menuarray[93] = menusonData.getData();
						}
					}
				}
				
				j++;
			}
		}
		System.out.println(Arrays.asList(menuarray));
		Custommenu custommenu = new Custommenu();
		custommenu.setMenu1(menuarray[1]);
		custommenu.setMenu2(menuarray[2]);
		custommenu.setMenu3(menuarray[3]);
		custommenu.setIsend1(Integer.parseInt(menuarray[4]));
		custommenu.setIsend2(Integer.parseInt(menuarray[5]));
		custommenu.setIsend3(Integer.parseInt(menuarray[6]));
		custommenu.setMenu1type(menuarray[7]);
		custommenu.setMenu1key(menuarray[8]);
		custommenu.setMenu1url(menuarray[9]);
		custommenu.setMenu2type(menuarray[10]);
		custommenu.setMenu2key(menuarray[11]);
		custommenu.setMenu2url(menuarray[12]);
		custommenu.setMenu3type(menuarray[13]);
		custommenu.setMenu3key(menuarray[14]);
		custommenu.setMenu3url(menuarray[15]);
		custommenu.setMenu1son1(menuarray[16]);
		custommenu.setMenu1son2(menuarray[17]);
		custommenu.setMenu1son3(menuarray[18]);
		custommenu.setMenu1son4(menuarray[19]);
		custommenu.setMenu1son5(menuarray[20]);
		custommenu.setMenu2son1(menuarray[21]);
		custommenu.setMenu2son2(menuarray[22]);
		custommenu.setMenu2son3(menuarray[23]);
		custommenu.setMenu2son4(menuarray[24]);
		custommenu.setMenu2son5(menuarray[25]);
		custommenu.setMenu3son1(menuarray[26]);
		custommenu.setMenu3son2(menuarray[27]);
		custommenu.setMenu3son3(menuarray[28]);
		custommenu.setMenu3son4(menuarray[29]);
		custommenu.setMenu3son5(menuarray[30]);
		
		custommenu.setMenu1son1type(menuarray[31]);
		custommenu.setMenu1son1key(menuarray[32]);
		custommenu.setMenu1son1url(menuarray[33]);
		custommenu.setMenu1son2type(menuarray[34]);
		custommenu.setMenu1son2key(menuarray[35]);
		custommenu.setMenu1son2url(menuarray[36]);
		custommenu.setMenu1son3type(menuarray[37]);
		custommenu.setMenu1son3key(menuarray[38]);
		custommenu.setMenu1son3url(menuarray[39]);
		custommenu.setMenu1son4type(menuarray[40]);
		custommenu.setMenu1son4key(menuarray[41]);
		custommenu.setMenu1son4url(menuarray[42]);
		custommenu.setMenu1son5type(menuarray[43]);
		custommenu.setMenu1son5key(menuarray[44]);
		custommenu.setMenu1son5url(menuarray[45]);
		
		custommenu.setMenu2son1type(menuarray[46]);
		custommenu.setMenu2son1key(menuarray[47]);
		custommenu.setMenu2son1url(menuarray[48]);
		custommenu.setMenu2son2type(menuarray[49]);
		custommenu.setMenu2son2key(menuarray[50]);
		custommenu.setMenu2son2url(menuarray[51]);
		custommenu.setMenu2son3type(menuarray[52]);
		custommenu.setMenu2son3key(menuarray[53]);
		custommenu.setMenu2son3url(menuarray[54]);
		custommenu.setMenu2son4type(menuarray[55]);
		custommenu.setMenu2son4key(menuarray[56]);
		custommenu.setMenu2son4url(menuarray[57]);
		custommenu.setMenu2son5type(menuarray[58]);
		custommenu.setMenu2son5key(menuarray[59]);
		custommenu.setMenu2son5url(menuarray[60]);
		
		custommenu.setMenu3son1type(menuarray[61]);
		custommenu.setMenu3son1key(menuarray[62]);
		custommenu.setMenu3son1url(menuarray[63]);
		custommenu.setMenu3son2type(menuarray[64]);
		custommenu.setMenu3son2key(menuarray[65]);
		custommenu.setMenu3son2url(menuarray[66]);
		custommenu.setMenu3son3type(menuarray[67]);
		custommenu.setMenu3son3key(menuarray[68]);
		custommenu.setMenu3son3url(menuarray[69]);
		custommenu.setMenu3son4type(menuarray[70]);
		custommenu.setMenu3son4key(menuarray[71]);
		custommenu.setMenu3son4url(menuarray[72]);
		custommenu.setMenu3son5type(menuarray[73]);
		custommenu.setMenu3son5key(menuarray[74]);
		custommenu.setMenu3son5url(menuarray[75]);
		if(menuarray[76]!=null){
			custommenu.setMenu1resid(Integer.parseInt(menuarray[76]));
		}
		if(menuarray[77]!=null){
			custommenu.setMenu2resid(Integer.parseInt(menuarray[77]));
		}
		if(menuarray[78]!=null){
			custommenu.setMenu3resid(Integer.parseInt(menuarray[78]));
		}
		if(menuarray[79]!=null){
			custommenu.setMenu1son1resid(Integer.parseInt(menuarray[79]));
		}
		if(menuarray[80]!=null){
			custommenu.setMenu1son2resid(Integer.parseInt(menuarray[80]));
		}
		if(menuarray[81]!=null){
			custommenu.setMenu1son3resid(Integer.parseInt(menuarray[81]));
		}
		if(menuarray[82]!=null){
			custommenu.setMenu1son4resid(Integer.parseInt(menuarray[82]));
		}
		if(menuarray[83]!=null){
			custommenu.setMenu1son5resid(Integer.parseInt(menuarray[83]));
		}
		if(menuarray[84]!=null){
			custommenu.setMenu2son1resid(Integer.parseInt(menuarray[84]));
		}
		if(menuarray[85]!=null){
			custommenu.setMenu2son2resid(Integer.parseInt(menuarray[85]));
		}
		if(menuarray[86]!=null){
			custommenu.setMenu2son3resid(Integer.parseInt(menuarray[86]));
		}
		if(menuarray[87]!=null){
			custommenu.setMenu2son4resid(Integer.parseInt(menuarray[87]));
		}
		if(menuarray[88]!=null){
			custommenu.setMenu2son5resid(Integer.parseInt(menuarray[88]));
		}
		if(menuarray[89]!=null){
			custommenu.setMenu3son1resid(Integer.parseInt(menuarray[89]));
		}
		if(menuarray[90]!=null){
			custommenu.setMenu3son2resid(Integer.parseInt(menuarray[90]));
		}
		if(menuarray[91]!=null){
			custommenu.setMenu3son3resid(Integer.parseInt(menuarray[91]));
		}
		if(menuarray[92]!=null){
			custommenu.setMenu3son4resid(Integer.parseInt(menuarray[92]));
		}
		if(menuarray[93]!=null){
			custommenu.setMenu3son5resid(Integer.parseInt(menuarray[93]));
		}
		
		custommenu.setCreatedate(new Date());
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		custommenu.setPublicaccount(publicaccount);
		custommenu.setAlldata(data);
		custommenuService.add(custommenu);
		
		arg[0]="custommenuAction!view";
		arg[1]="自定义菜单";
		return SUCCESS;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String mulupdate() throws Exception{
		String[] menuarray= new String[94];
		menuarray[0]="修改菜单";
		System.out.println("update data=\n"+data);
		//gson解析
		Gson gson = new Gson();
		List<MenuVo> menuvos =gson.fromJson(data, new TypeToken<List<MenuVo>>() { }.getType());
		
		for (int i = 1; i <= menuvos.size(); i++) {
			MenuVo menuVo = menuvos.get(i-1);
			System.out.println(menuVo.getTyp()+","+menuVo.getData()+","+menuVo.getTit());//res_tw,18,微官网
			menuarray[i]=menuVo.getTit();//1-2-3位置：主菜单大菜单名
			Map<String,MenusonData> subdata = menuVo.getSubdata();
			if(subdata==null){
				menuarray[i+3] = "1";//4-5-6位置：主菜单是子节点
				//7-8-9 ~ 10-11-12 ~ 13-14-15位置：menu1type、menu1key、menu1url、menu2type、menu2key、menu2url、menu3type、menu3key、menu3url
				//76-77-78 菜单大菜单回复素材
				if(i==1){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[7] = "view";
						menuarray[8] = "menuarray8";
						menuarray[9] = menuVo.getData();//url
					}else{
						menuarray[7] = "click";
						menuarray[8] = "menuarray8";
						menuarray[76] = menuVo.getData();//resid
					}
				}else if(i==2){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[10] = "view";
						menuarray[11] = "menuarray11";
						menuarray[12] = menuVo.getData();
					}else{
						menuarray[10] = "click";
						menuarray[11] = "menuarray11";
						menuarray[77] = menuVo.getData();
					}
				}else if(i==3){
					if(menuVo.getTyp()!=null&&menuVo.getTyp().equals("res_url")){
						menuarray[13] = "view";
						menuarray[14] = "menuarray14";
						menuarray[15] = menuVo.getData();
					}else{
						menuarray[13] = "click";
						menuarray[14] = "menuarray14";
						menuarray[78] = menuVo.getData();
					}
				}
				
				continue;
			}else{
				menuarray[i+3] = "0";//4-5-6位置：主菜单不是子节点
			}
			int j=1;
			for (Entry<String,MenusonData> subdataEntry : subdata.entrySet()) {
				System.out.println("subdataEntry:"+subdataEntry.getKey());//subdataEntry:zizicd1
				MenusonData menusonData = subdataEntry.getValue();//menusonData:{活动2,res_music,17}//menusonData:{活动3,res_url,www.baidu.com}
				System.out.println("menusonData:"+menusonData.getTit()+","+menusonData.getTyp()+","+menusonData.getData());
				
				if(i==1){
					//16~20 menu1son1、menu1son2、menu1son3、menu1son4、menu1son5
					menuarray[15+j]=menusonData.getTit();
					//31~45 menuXsonXtype key url
					//79~83 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[31] = "view";
							menuarray[32] = "menuarray32";
							menuarray[33] = menusonData.getData();
						}else if(j==2){
							menuarray[34] = "view";
							menuarray[35] = "menuarray35";
							menuarray[36] = menusonData.getData();
						}else if(j==3){
							menuarray[37] = "view";
							menuarray[38] = "menuarray38";
							menuarray[39] = menusonData.getData();
						}else if(j==4){
							menuarray[40] = "view";
							menuarray[41] = "menuarray41";
							menuarray[42] = menusonData.getData();
						}else if(j==5){
							menuarray[43] = "view";
							menuarray[44] = "menuarray44";
							menuarray[45] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[31] = "click";
							menuarray[32] = "menuarray32";
							menuarray[79] = menusonData.getData();
						}else if(j==2){
							menuarray[34] = "click";
							menuarray[35] = "menuarray35";
							menuarray[80] = menusonData.getData();
						}else if(j==3){
							menuarray[37] = "click";
							menuarray[38] = "menuarray38";
							menuarray[81] = menusonData.getData();
						}else if(j==4){
							menuarray[40] = "click";
							menuarray[41] = "menuarray41";
							menuarray[82] = menusonData.getData();
						}else if(j==5){
							menuarray[43] = "click";
							menuarray[44] = "menuarray44";
							menuarray[83] = menusonData.getData();
						}
					}
				}else if (i==2) {
					//21~25 menu2son1、menu2son2、menu2son3、menu2son4、menu2son5
					menuarray[20+j]=menusonData.getTit();
					//46~60 menuXsonXtype key url
					//84~88 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[46] = "view";
							menuarray[47] = "menuarray47";
							menuarray[48] = menusonData.getData();
						}else if(j==2){
							menuarray[49] = "view";
							menuarray[50] = "menuarray50";
							menuarray[51] = menusonData.getData();
						}else if(j==3){
							menuarray[52] = "view";
							menuarray[53] = "menuarray53";
							menuarray[54] = menusonData.getData();
						}else if(j==4){
							menuarray[55] = "view";
							menuarray[56] = "menuarray56";
							menuarray[57] = menusonData.getData();
						}else if(j==5){
							menuarray[58] = "view";
							menuarray[59] = "menuarray59";
							menuarray[60] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[46] = "click";
							menuarray[47] = "menuarray47";
							menuarray[84] = menusonData.getData();
						}else if(j==2){
							menuarray[49] = "click";
							menuarray[50] = "menuarray50";
							menuarray[85] = menusonData.getData();
						}else if(j==3){
							menuarray[52] = "click";
							menuarray[53] = "menuarray53";
							menuarray[86] = menusonData.getData();
						}else if(j==4){
							menuarray[55] = "click";
							menuarray[56] = "menuarray56";
							menuarray[87] = menusonData.getData();
						}else if(j==5){
							menuarray[58] = "click";
							menuarray[59] = "menuarray59";
							menuarray[88] = menusonData.getData();
						}
					}
				}else if(i==3){
					//26~30 menu3son1、menu3son2、menu3son3、menu3son4、menu3son5
					menuarray[25+j]=menusonData.getTit();
					//61~75 menuXsonXtype key url
					//89~93 resid
					if(menusonData.getTyp()!=null&&menusonData.getTyp().equals("res_url")){
						if(j==1){
							menuarray[61] = "view";
							menuarray[62] = "menuarray62";
							menuarray[63] = menusonData.getData();
						}else if(j==2){
							menuarray[64] = "view";
							menuarray[65] = "menuarray65";
							menuarray[66] = menusonData.getData();
						}else if(j==3){
							menuarray[67] = "view";
							menuarray[68] = "menuarray68";
							menuarray[69] = menusonData.getData();
						}else if(j==4){
							menuarray[70] = "view";
							menuarray[71] = "menuarray71";
							menuarray[72] = menusonData.getData();
						}else if(j==5){
							menuarray[73] = "view";
							menuarray[74] = "menuarray74";
							menuarray[75] = menusonData.getData();
						}
						
					}else{
						if(j==1){
							menuarray[61] = "click";
							menuarray[62] = "menuarray62";
							menuarray[89] = menusonData.getData();
						}else if(j==2){
							menuarray[64] = "click";
							menuarray[65] = "menuarray65";
							menuarray[90] = menusonData.getData();
						}else if(j==3){
							menuarray[67] = "click";
							menuarray[68] = "menuarray68";
							menuarray[91] = menusonData.getData();
						}else if(j==4){
							menuarray[70] = "click";
							menuarray[71] = "menuarray71";
							menuarray[92] = menusonData.getData();
						}else if(j==5){
							menuarray[73] = "click";
							menuarray[74] = "menuarray74";
							menuarray[93] = menusonData.getData();
						}
					}
				}
				
				j++;
			}
		}
		System.out.println(Arrays.asList(menuarray));
		Custommenu custommenu = new Custommenu();
		custommenu.setMenu1(menuarray[1]);
		custommenu.setMenu2(menuarray[2]);
		custommenu.setMenu3(menuarray[3]);
		custommenu.setIsend1(Integer.parseInt(menuarray[4]));
		custommenu.setIsend2(Integer.parseInt(menuarray[5]));
		custommenu.setIsend3(Integer.parseInt(menuarray[6]));
		custommenu.setMenu1type(menuarray[7]);
		custommenu.setMenu1key(menuarray[8]);
		custommenu.setMenu1url(menuarray[9]);
		custommenu.setMenu2type(menuarray[10]);
		custommenu.setMenu2key(menuarray[11]);
		custommenu.setMenu2url(menuarray[12]);
		custommenu.setMenu3type(menuarray[13]);
		custommenu.setMenu3key(menuarray[14]);
		custommenu.setMenu3url(menuarray[15]);
		custommenu.setMenu1son1(menuarray[16]);
		custommenu.setMenu1son2(menuarray[17]);
		custommenu.setMenu1son3(menuarray[18]);
		custommenu.setMenu1son4(menuarray[19]);
		custommenu.setMenu1son5(menuarray[20]);
		custommenu.setMenu2son1(menuarray[21]);
		custommenu.setMenu2son2(menuarray[22]);
		custommenu.setMenu2son3(menuarray[23]);
		custommenu.setMenu2son4(menuarray[24]);
		custommenu.setMenu2son5(menuarray[25]);
		custommenu.setMenu3son1(menuarray[26]);
		custommenu.setMenu3son2(menuarray[27]);
		custommenu.setMenu3son3(menuarray[28]);
		custommenu.setMenu3son4(menuarray[29]);
		custommenu.setMenu3son5(menuarray[30]);
		
		custommenu.setMenu1son1type(menuarray[31]);
		custommenu.setMenu1son1key(menuarray[32]);
		custommenu.setMenu1son1url(menuarray[33]);
		custommenu.setMenu1son2type(menuarray[34]);
		custommenu.setMenu1son2key(menuarray[35]);
		custommenu.setMenu1son2url(menuarray[36]);
		custommenu.setMenu1son3type(menuarray[37]);
		custommenu.setMenu1son3key(menuarray[38]);
		custommenu.setMenu1son3url(menuarray[39]);
		custommenu.setMenu1son4type(menuarray[40]);
		custommenu.setMenu1son4key(menuarray[41]);
		custommenu.setMenu1son4url(menuarray[42]);
		custommenu.setMenu1son5type(menuarray[43]);
		custommenu.setMenu1son5key(menuarray[44]);
		custommenu.setMenu1son5url(menuarray[45]);
		
		custommenu.setMenu2son1type(menuarray[46]);
		custommenu.setMenu2son1key(menuarray[47]);
		custommenu.setMenu2son1url(menuarray[48]);
		custommenu.setMenu2son2type(menuarray[49]);
		custommenu.setMenu2son2key(menuarray[50]);
		custommenu.setMenu2son2url(menuarray[51]);
		custommenu.setMenu2son3type(menuarray[52]);
		custommenu.setMenu2son3key(menuarray[53]);
		custommenu.setMenu2son3url(menuarray[54]);
		custommenu.setMenu2son4type(menuarray[55]);
		custommenu.setMenu2son4key(menuarray[56]);
		custommenu.setMenu2son4url(menuarray[57]);
		custommenu.setMenu2son5type(menuarray[58]);
		custommenu.setMenu2son5key(menuarray[59]);
		custommenu.setMenu2son5url(menuarray[60]);
		
		custommenu.setMenu3son1type(menuarray[61]);
		custommenu.setMenu3son1key(menuarray[62]);
		custommenu.setMenu3son1url(menuarray[63]);
		custommenu.setMenu3son2type(menuarray[64]);
		custommenu.setMenu3son2key(menuarray[65]);
		custommenu.setMenu3son2url(menuarray[66]);
		custommenu.setMenu3son3type(menuarray[67]);
		custommenu.setMenu3son3key(menuarray[68]);
		custommenu.setMenu3son3url(menuarray[69]);
		custommenu.setMenu3son4type(menuarray[70]);
		custommenu.setMenu3son4key(menuarray[71]);
		custommenu.setMenu3son4url(menuarray[72]);
		custommenu.setMenu3son5type(menuarray[73]);
		custommenu.setMenu3son5key(menuarray[74]);
		custommenu.setMenu3son5url(menuarray[75]);
		if(menuarray[76]!=null){
			custommenu.setMenu1resid(Integer.parseInt(menuarray[76]));
		}
		if(menuarray[77]!=null){
			custommenu.setMenu2resid(Integer.parseInt(menuarray[77]));
		}
		if(menuarray[78]!=null){
			custommenu.setMenu3resid(Integer.parseInt(menuarray[78]));
		}
		if(menuarray[79]!=null){
			custommenu.setMenu1son1resid(Integer.parseInt(menuarray[79]));
		}
		if(menuarray[80]!=null){
			custommenu.setMenu1son2resid(Integer.parseInt(menuarray[80]));
		}
		if(menuarray[81]!=null){
			custommenu.setMenu1son3resid(Integer.parseInt(menuarray[81]));
		}
		if(menuarray[82]!=null){
			custommenu.setMenu1son4resid(Integer.parseInt(menuarray[82]));
		}
		if(menuarray[83]!=null){
			custommenu.setMenu1son5resid(Integer.parseInt(menuarray[83]));
		}
		if(menuarray[84]!=null){
			custommenu.setMenu2son1resid(Integer.parseInt(menuarray[84]));
		}
		if(menuarray[85]!=null){
			custommenu.setMenu2son2resid(Integer.parseInt(menuarray[85]));
		}
		if(menuarray[86]!=null){
			custommenu.setMenu2son3resid(Integer.parseInt(menuarray[86]));
		}
		if(menuarray[87]!=null){
			custommenu.setMenu2son4resid(Integer.parseInt(menuarray[87]));
		}
		if(menuarray[88]!=null){
			custommenu.setMenu2son5resid(Integer.parseInt(menuarray[88]));
		}
		if(menuarray[89]!=null){
			custommenu.setMenu3son1resid(Integer.parseInt(menuarray[89]));
		}
		if(menuarray[90]!=null){
			custommenu.setMenu3son2resid(Integer.parseInt(menuarray[90]));
		}
		if(menuarray[91]!=null){
			custommenu.setMenu3son3resid(Integer.parseInt(menuarray[91]));
		}
		if(menuarray[92]!=null){
			custommenu.setMenu3son4resid(Integer.parseInt(menuarray[92]));
		}
		if(menuarray[93]!=null){
			custommenu.setMenu3son5resid(Integer.parseInt(menuarray[93]));
		}
		
		custommenu.setCreatedate(new Date());
		String publicaccount = ((Pubclient)session.get("pubclient")).getPublicaccount();
		custommenu.setPublicaccount(publicaccount);
		custommenu.setAlldata(data);
		custommenu.setId(id);
		custommenuService.update(custommenu);
		
		arg[0]="custommenuAction!view";
		arg[1]="自定义菜单";
		return SUCCESS;
	}
	
	
	
	/**
	 * 发布自定义菜单
	 * @return
	 * @throws Exception 
	 */
	public String deploy() throws Exception{
		PrintWriter out = response.getWriter();
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		String paccount=pubclient.getPublicaccount();
		custommenu=custommenuService.queryCustommenuByPublicAccount(paccount);
		//生成菜单并发布
		Logger log = LoggerFactory.getLogger(CustommenuAction.class);
//		String appId = "wx0ea5802468b284a6";//第三方用户唯一凭证
//		String appSecret = "edb152956778e3ab6b12d0a47b51ecfe";//第三方用户唯一凭证秘钥
		String appId = pubclient.getAppid();
		String appSecret = pubclient.getAppsecret();
		if(appId==null||appId.equals("")||appSecret==null||appSecret.equals("")){
			log.info("菜单创建失败！授权未配置");
			out.print("菜单创建失败！授权未配置");
		}
		Token token = CommonUtil.getToken(appId, appSecret);//调用接口获取凭证
		if(null!= token){
			//创建菜单
			boolean result = MenuUtil.createMenu(MenuManager.createMenu(custommenu), token.getAccessToken());
			//判断菜单创建结果
			if(result){
				log.info("菜单创建成功！");
				out.print("ok");
				
			}else{
				log.info("菜单创建失败！配置不正确");
				out.print("nosec");
			}
		}else{
			log.info("菜单创建失败！请检查appid和appscret是否填写正确！");
			out.print("菜单创建失败！请检查appid和appscret是否填写正确！");
		}
		
		return NONE;
		 
	}
	
	//get、set-------------------------------------------
	public ICustommenuService getCustommenuService() {
		return custommenuService;
	}
	@Resource
	public void setCustommenuService(ICustommenuService custommenuService) {
		this.custommenuService = custommenuService;
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
	
	public void setCustommenu(Custommenu custommenu) {
		this.custommenu = custommenu;
	}
	
	public Custommenu getCustommenu() {
		return custommenu;
	}
	public List<Custommenu> getCustommenus() {
		return custommenus;
	}
	public void setCustommenus(List<Custommenu> custommenus) {
		this.custommenus = custommenus;
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
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
	}
	public List<Fodder> getFodders() {
		return fodders;
	}
	public void setFodders(List<Fodder> fodders) {
		this.fodders = fodders;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInitjson() {
		return initjson;
	}

	public void setInitjson(String initjson) {
		this.initjson = initjson;
	}
	
	
}
