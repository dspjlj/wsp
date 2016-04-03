<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String front = basePath + "front/temp3/";
%>
<!DOCTYPE html PUBLIC "-/W3C/DTD XHTML 1.0 Transitional/EN" "http:/www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http:/www.w3.org/1999/xhtml">
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title><s:property value="pagearticle.name" /></title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<link href="<%=front%>tpl/Wap/default/common/css/yl/news.css" rel="stylesheet" type="text/css" />
<script src="<%=front%>tpl/Wap/default/common/js/yl/audio.min.js" type="text/javascript"></script>   

    <script>

      audiojs.events.ready(function() {

        audiojs.createAll();

      });

    </script>

</head> 
<script>
window.onload = function ()
{
	var oWin = document.getElementById("win");
	var oLay = document.getElementById("overlay");	
	var oBtn = document.getElementById("popmenu");
	var oClose = document.getElementById("close");
	oBtn.onclick = function ()
	{
		oLay.style.display = "block";
		oWin.style.display = "block"	
	};
	oLay.onclick = function ()
	{
		oLay.style.display = "none";
		oWin.style.display = "none"	
	}
};
</script>
<body id="news">

<div id="ui-header">
<div class="fixed">
	<a class="ui-title" id="popmenu">选择分类</a>
	<a class="ui-btn-left_pre" href="javascript:history.go(-1)"></a>
	<a class="ui-btn-right_home" href="wgwAction!frontindex?frontpa=<s:property value="#session.frontpa" />"></a>

</div>

</div>

<div id="overlay"></div>

<div id="win">

<ul class="dropdown"> 
<s:action name="bigtypeAction!frontShowBigtypes">
	<s:param name="frontpa" value="#session.frontpa"/>
</s:action>
<s:iterator value="#request.bigtypes" var="bigtype">
	<li>
		<a href='
				<s:if test="isend==1">
               		bigtypeAction!frontBigtypes?wgwid=<s:property value="#request.wgw.id"/>&bigtypeid=<s:property value="id"/>
               	</s:if>
               	<s:else>
               		pagearticleAction!frontPages?wgwid=<s:property value="#request.wgw.id"/>&bigtypeid=<s:property value="id"/>
               	</s:else>
				'>
			<span><s:property value="name"/></span>
		</a>
	</li>
</s:iterator>
 	

<div class="clr"></div>

</ul>

</div>

<div class="Listpage">

<div class="top46"></div>

<div class="page-bizinfo">

<div class="header" style="position: relative;">

<h1 id="activity-name">
	<s:property value="pagearticle.name" />
</h1>

<span id="post-date">
	<s:date name="pagearticle.createtime" format="yyyy-MM-dd HH:mm:ss" />
</span>

</div>
<!-- 首页链接 -->
<s:action name="pubclientAction!getfrontpubclient">
	<s:param name="frontpa" value="#session.frontpa"/>
</s:action>

<a id="biz-link" class="btn" href="wgwAction!frontindex?frontpa=<s:property value="#session.frontpa" />"  data-transition="slide" >
	<div class="arrow">
		<div class="icons arrow-r"></div>
	</div>
	<div class="logo">
		<div class="circle"></div>
		<img id="img" src="<%=front%>tpl/User/default/common/images/portrait.jpg">
	</div>
	<div id="nickname">
		<s:property value="#request.pubclient.publicname"/>
	</div>
	<div id="weixinid">
		微信号:<s:property value="#request.pubclient.publicno"/>
	</div>
</a>

<div class="showpic">
	<img alt="没有封面图片" src="<%=basePath %><s:property value="pagearticle.imageurl"/>" />
</div>
<div class="text" id="content">

	<s:property value="pagearticle.description" escapeHtml="false"/>

</div>

 <script>
function dourl(url){
	location.href= url;
}
</script>

</div>	



    <div class="list">

<div id="olload">

<span>往期回顾</span>

</div>



<div id="oldlist">
	<ul>
	  <li class="newsmore">
			<!--在整合列表页和分类也的时候，这里修改过模板
			<a href="#文章链接">
				<div class="olditem">
					<div class="title">文章标题</div> 
				</div>
			</a>
			-->
		</li>
	</ul>
   	<a class="more" href="pagearticleAction!frontPages?wgwid=<s:property value="pagearticle.bigtype.wgw.id"/>&bigtypeid=<s:property value="pagearticle.bigtype.id"/>">更多精彩内容</a>	</div>
</div>

<a class="footer" href="#news" target="_self"><span class="top">返回顶部</span></a>

</div>

<div style="display:none"></div>

<div class="copyright">
		<s:action name="footerAction!frontFooter">
			<s:param name="wgwid" value="%{#request.wgw.id}"></s:param>
		</s:action>
		<s:if test="#request.footer!=null">
			技术支持：<s:property value="#request.footer.foottitle"/>
		</s:if>
		<s:else>
			<a href="http://www.di3p.com/mo/index.html">技术支持：第三屏</a>
		</s:else>
</div> 

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js" type="text/javascript"></script>
<script>
function displayit(n){
	for(i=0;i<4;i++){
		if(i==n){
			var id='menu_list'+n;
			if(document.getElementById(id).style.display=='none'){
				document.getElementById(id).style.display='';
				document.getElementById("plug-wrap").style.display='';
			}else{
				document.getElementById(id).style.display='none';
				document.getElementById("plug-wrap").style.display='none';
			}
		}else{
			if($('#menu_list'+i)){
				$('#menu_list'+i).css('display','none');
			}
		}
	}
}
function closeall(){
	var count = document.getElementById("top_menu").getElementsByTagName("ul").length;
	for(i=0;i<count;i++){
		document.getElementById("top_menu").getElementsByTagName("ul").item(i).style.display='none';
	}
	document.getElementById("plug-wrap").style.display='none';
}

document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
});
</script> <style type="text/css">
body { margin-bottom:60px !important; }
ul, li { list-style:none; margin:0; padding:0 }
#plug-wrap { position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0); z-index:800; }
.top_bar { position:fixed; bottom:0; left:0px; z-index:900; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: Helvetica, Tahoma, Arial, Microsoft YaHei, sans-serif; }
.plug-menu { -webkit-appearance:button; display:inline-block; width:36px; height:36px; border-radius:36px; position: absolute; bottom:17px; left: 17px; z-index:999; box-shadow: 0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25); background-color: #B70000; -webkit-transition: -webkit-transform 200ms; -webkit-transform:rotate(1deg); color:#fff; background-image:url('tpl/Wap/default/common/images/plug.png'); background-repeat: no-repeat; -webkit-background-size: 80% auto; background-size: 80% auto; background-position: center center; }
.plug-menu:before { font-size:20px; margin:9px 0 0 9px; }
.plug-menu:checked { -webkit-transform:rotate(135deg); }
.top_menu { margin-left: -175px; }
.top_menu>li { min-width: 86px; padding: 0 10px; height:32px; border-radius:32px; box-shadow: 0 0 0 3px #FFFFFF, 0 2px 5px 3px rgba(0, 0, 0, 0.25); background:#B70000; margin-bottom: 23px; margin-left: 23px; z-index:900; transition: all 200ms ease-out; -webkit-transition: all 200ms ease-out; }
.top_menu>li:last-child { margin-bottom: 80px; }
.top_menu>li a { color:#fff; font-size:20px; display: block; height: 100%; line-height: 33px; text-indent:26px; text-decoration:none; position:relative; font-size:16px; text-overflow:ellipsis; white-space:nowrap; overflow:hidden; }
.top_menu>li a img { display: block; width: 24px; height: 24px; text-indent: -999px; position: absolute; top: 50%; left: 10px; margin-top: -13px; margin-left: -12px; }
.top_menu>li.on:nth-of-type(1) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 700ms ease-out;
-webkit-transition: all 700ms ease-out;width: 130px;
}
.top_menu>li.on:nth-of-type(2) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 600ms ease-out;
-webkit-transition: all 600ms ease-out;width: 130px;
}
.top_menu>li.on:nth-of-type(3) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 500ms ease-out;
-webkit-transition: all 500ms ease-out;width: 130px;
}
.top_menu>li.on:nth-of-type(4) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 400ms ease-out;
-webkit-transition: all 400ms ease-out;width: 130px;
}
.top_menu>li.on:nth-of-type(5) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 300ms ease-out;
-webkit-transition: all 300ms ease-out;width: 130px;
}
.top_menu>li.on:nth-of-type(6) {
-webkit-transform: translate(175px, 0) rotate(0deg);
transition: all 200ms ease-out;
-webkit-transition: all 200ms ease-out;width: 130px;
}
 .top_menu>li.out:nth-of-type(1) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 600ms ease-out;
-webkit-transition: all 600ms ease-out;width: 130px;
}
.top_menu>li.out:nth-of-type(2) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 500ms ease-out;
-webkit-transition: all 500ms ease-out;width: 130px;
}
.top_menu>li.out:nth-of-type(3) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 400ms ease-out;
-webkit-transition: all 400ms ease-out;width: 130px;
}
.top_menu>li.out:nth-of-type(4) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 300ms ease-out;
-webkit-transition: all 300ms ease-out;width: 130px;
}
.top_menu>li.out:nth-of-type(5) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 200ms ease-out;
-webkit-transition: all 200ms ease-out;width: 130px;
}
.top_menu>li.out:nth-of-type(6) {
-webkit-transform: translate(-20px, 0) rotate(0deg);
transition: all 100ms ease-out;
-webkit-transition: all 100ms ease-out;width: 130px;
}
#sharemcover { position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.7); display: none; z-index: 20000; }
#sharemcover img { position: fixed; right: 18px; top: 5px; width: 260px; height: 180px; z-index: 20001; border:0; }
</style>

<!-- 快捷菜单 Start -->
  <s:action name="wgwmenuAction!frontMenu">
  		<s:param name="wgwid" value="%{#request.wgw.id}"></s:param>
  </s:action>
<div class="top_bar" style="-webkit-transform:translate3d(0,0,0)">
		<nav>
			<ul id="top_menu" class="top_menu">
				<input type="checkbox" id="plug-btn" class="plug-menu themeStyle"
					style="background-color: ; background-image: url('<%=front %>tpl/Wap/default/common/images/plug.png'); border: 0px;" />
				<li class="themeStyle out" style="background: ">
					<a href="wgwAction!frontindex?frontpa=<s:property value="#session.frontpa" />"><img src="<%=front %>images/plugmenu4.png"/>
						<label>
							首页
						</label> </a>
				</li>
				
				<s:if test="#request.wgwmenu!=null">
					<s:if test="#request.wgwmenu.menu2url!=null&&#request.wgwmenu.menu2url!=''">
			      		<s:if test="#request.wgwmenu.menu2url.contains('tel')">
						    <li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu2url" />"><img src="<%=front %>images/plugmenu1.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu2" />
									</label>
								</a>
							</li>
			      		</s:if>
			      		<s:elseif test="#request.wgwmenu.menu2url.contains('location')">
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu2url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu2" />
									</label>
								</a>
							</li>
						     
			      		</s:elseif>
			      		<s:else>
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu2url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu2" />
									</label>
								</a>
							</li>
			      		</s:else>
			      	</s:if>
			      	
			      	<s:if test="#request.wgwmenu.menu3url!=null&&#request.wgwmenu.menu3url!=''">
			      		<s:if test="#request.wgwmenu.menu3url.contains('tel')">
						    <li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu3url" />"><img src="<%=front %>images/plugmenu1.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
			      		</s:if>
			      		<s:elseif test="#request.wgwmenu.menu3url.contains('location')">
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu3url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
						     
			      		</s:elseif>
			      		<s:else>
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu3url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
			      		</s:else>
			      	</s:if>
			      	
			      	
			      	<s:if test="#request.wgwmenu.menu4url!=null&&#request.wgwmenu.menu4url!=''">
			      		<s:if test="#request.wgwmenu.menu4url.contains('tel')">
						    <li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu4url" />"><img src="<%=front %>images/plugmenu1.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
			      		</s:if>
			      		<s:elseif test="#request.wgwmenu.menu4url.contains('location')">
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu4url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
						     
			      		</s:elseif>
			      		<s:else>
			      			<li class="themeStyle out" style="background: ">
								<a href="<s:property value="#request.wgwmenu.menu4url" />"><img src="<%=front %>images/plugmenu3.png"/>
									<label>
										<s:property value="#request.wgwmenu.menu3" />
									</label>
								</a>
							</li>
			      		</s:else>
			      	</s:if>
				</s:if>
			</ul>
			</nav>
</div>

<div id="plug-wrap" style="display: none;" ></div>
<script>
$(function(){
        $(".plug-menu").click(function(){
        var li = $(this).parents('ul').find('li');
        if(li.attr("class") == "themeStyle on"){
                li.removeClass("themeStyle on");
                li.addClass("themeStyle out");
        }else{
                li.removeClass("themeStyle out");
                li.addClass("themeStyle on");
        }
        });
});
</script>

<script type="text/javascript" src="<%=front%>tpl/Wap/default/common/js/ChatFloat.js"></script>
</body>
</html>