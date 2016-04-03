<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String front=basePath+"front/temp3/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><s:property value="#request.wgw.title"/></title>
		<meta name="viewport"
			content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="format-detection" content="telephone=no" />
		<style>
#iframe_screen {
	background: #fff;
	position: absolute;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	z-index: 300000;
	overflow: hidden;
}
</style>

		<meta charset="utf-8" />

		<link href="<%=front %>tpl/static/tpl/187/css/cate.css" rel="stylesheet"
			type="text/css" />

		<link href="<%=front %>tpl/static/tpl/com/css/iscroll.css" rel="stylesheet"
			type="text/css" />

		<style>
</style>

		<script src="<%=front %>tpl/static/tpl/com/js/iscroll.js"
			type="text/javascript"></script>

		<script type="text/javascript">

var myScroll;



function loaded() {

myScroll = new iScroll('wrapper', {

snap: true,

momentum: false,

hScrollbar: false,

onScrollEnd: function () {

document.querySelector('#indicator > li.active').className = '';

document.querySelector('#indicator > li:nth-child(' + (this.currPageX+1) + ')').className = 'active';

}

 });

 

}



document.addEventListener('DOMContentLoaded', loaded, false);

</script>



	</head>

	<body>

		<!--music-->
		<s:action name="bgmusicAction!frontBgmusic">
	  		<s:param name="wgwid" value="#request.wgw.id"></s:param>
	  	</s:action>
	  	<s:if test="#request.bgmusic!=null&&#request.bgmusic.ison==1">
		  	<audio autoplay="autoplay">
				<source src="<s:property value="#request.bgmusic.musicurl"/>" type="audio/mpeg"/>
			</audio>
		</s:if>
		
		<iframe id="iframe_screen" src="<%=front %>tpl/Wap/default/Index_an1.html"
			frameborder="0"></iframe>
			
		<s:if test="#request.screenimg.screenimgvos==null||#request.screenimg.screenimgvos.size()==0">
		</s:if>
		<s:else>
		<div class="banner">
			<div id="wrapper">
				<div id="scroller">
					<ul id="thelist">
						<s:iterator value="#request.screenimg.screenimgvos" var="screenimgvo">
							<li>
								<p>
									&nbsp;
								</p>
								<a href='<s:if test="linkurl!=null&&linkurl!=''"><s:property value="linkurl"/></s:if><s:else>#</s:else>' >
									<img src="<%=basePath %><s:property value="imageurl"/>"/>
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>

			<div id="nav">
				<div id="prev"
					onclick="myScroll.scrollToPage('prev', 0,400,2);return false">
					&larr; prev
				</div>
				<ul id="indicator">
					<s:iterator value="#request.screenimg.screenimgvos" var="screenimgvo" status="index">
		              	<s:if test="#index.count==1">
		              		<li class="active"></li>
		              	</s:if>
		                <s:else>
		                	<li></li>
		                </s:else>
	                </s:iterator>
				</ul>

				<div id="next"
					onclick="myScroll.scrollToPage('next', 0);return false">
					next &rarr;
				</div>

			</div>

			<div class="clr"></div>

		</div>
		</s:else>


		<div id="insert1"></div>

		<ul class="mainmenu">

				<s:if test="#request.bigtypes.size()==0">
	          		<a href="javascript:void(0)">
						<img alt='暂无类别' src='' />
							<p>
								<b>暂无类别</b><span>暂无类别</span><em></em>
							</p>
		            </a>
	          	</s:if>
	          	<s:iterator value="#request.bigtypes" var="bigtype" status="index">
	          		<li>
			            <a href='
			            <s:if test="ttype!=0">
		                	<s:property value="linkurl"/>
		                </s:if>
		                <s:else>
		                	<s:if test="isend==1">
		                		bigtypeAction!frontBigtypes?wgwid=<s:property value="#request.wgw.id"/>&bigtypeid=<s:property value="id"/>
		                	</s:if>
		                	<s:else>
		                		pagearticleAction!frontPages?wgwid=<s:property value="#request.wgw.id"/>&bigtypeid=<s:property value="id"/>
		                	</s:else>
		                </s:else>
			            '>
							<img src='<%=basePath %><s:property value="imageurl"/>' />
							<p>
								<b><s:property value="name"/></b><span><s:property value="enname"/></span><em></em>
							</p>
			            </a>
		            </li>
            	</s:iterator>

		</ul>



		<script>





var count = document.getElementById("thelist").getElementsByTagName("img").length;	

var count2 = document.getElementsByClassName("menuimg").length;





for(i=0;i<count;i++){

 document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:"+document.body.clientWidth+"px";



}

for(i=0;i<count2;i++){

  

document.getElementsByClassName("menuimg").item(i).style.cssText = " HEIGHT:"+(document.body.clientWidth/320)*111+"px";

document.getElementsByClassName("menumesg").item(i).style.cssText = " HEIGHT:"+(document.body.clientWidth/320)*111+"px";

 

}



document.getElementById("scroller").style.cssText = " width:"+document.body.clientWidth*count+"px";





 setInterval(function(){

myScroll.scrollToPage('next', 0,400,count);

},3500 );



window.onresize = function(){ 

for(i=0;i<count;i++){

document.getElementById("thelist").getElementsByTagName("img").item(i).style.cssText = " width:"+document.body.clientWidth+"px";



}

for(i=0;i<count2;i++){

 

 

document.getElementsByClassName("menuimg").item(i).style.cssText = " HEIGHT:"+(document.body.clientWidth/320)*111+"px";

document.getElementsByClassName("menumesg").item(i).style.cssText = " HEIGHT:"+(document.body.clientWidth/320)*111+"px";

  

}



 document.getElementById("scroller").style.cssText = " width:"+document.body.clientWidth*count+"px";

} 



</script>



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
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"
			type="text/javascript"></script>
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
</script>
		<style type="text/css">
body {
	margin-bottom: 60px !important;
}

ul,li {
	list-style: none;
	margin: 0;
	padding: 0
}

#plug-wrap {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0);
	z-index: 800;
}

.top_bar {
	position: fixed;
	bottom: 0;
	left: 0px;
	z-index: 900;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	font-family: Helvetica, Tahoma, Arial, Microsoft YaHei, sans-serif;
}

.plug-menu {
	-webkit-appearance: button;
	display: inline-block;
	width: 36px;
	height: 36px;
	border-radius: 36px;
	position: absolute;
	bottom: 17px;
	left: 17px;
	z-index: 999;
	box-shadow: 0 0 0 4px #FFFFFF, 0 2px 5px 4px rgba(0, 0, 0, 0.25);
	background-color: #B70000;
	-webkit-transition: -webkit-transform 200ms;
	-webkit-transform: rotate(1deg);
	color: #fff;
	background-image: url('tpl/Wap/default/common/images/plug.png');
	background-repeat: no-repeat;
	-webkit-background-size: 80% auto;
	background-size: 80% auto;
	background-position: center center;
}

.plug-menu:before {
	font-size: 20px;
	margin: 9px 0 0 9px;
}

.plug-menu:checked {
	-webkit-transform: rotate(135deg);
}

.top_menu {
	margin-left: -175px;
}

.top_menu>li {
	min-width: 86px;
	padding: 0 10px;
	height: 32px;
	border-radius: 32px;
	box-shadow: 0 0 0 3px #FFFFFF, 0 2px 5px 3px rgba(0, 0, 0, 0.25);
	background: #B70000;
	margin-bottom: 23px;
	margin-left: 23px;
	z-index: 900;
	transition: all 200ms ease-out;
	-webkit-transition: all 200ms ease-out;
}

.top_menu>li:last-child {
	margin-bottom: 80px;
}

.top_menu>li a {
	color: #fff;
	font-size: 20px;
	display: block;
	height: 100%;
	line-height: 33px;
	text-indent: 26px;
	text-decoration: none;
	position: relative;
	font-size: 16px;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

.top_menu>li a img {
	display: block;
	width: 24px;
	height: 24px;
	text-indent: -999px;
	position: absolute;
	top: 50%;
	left: 10px;
	margin-top: -13px;
	margin-left: -12px;
}

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
		<div class="top_bar" style="-webkit-transform: translate3d(0, 0, 0)">
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

		<div id="plug-wrap" style="display: none;"></div>
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

		


		
		<!--chat-->
		<script type="text/javascript"
			src="<%=front %>tpl/Wap/default/common/js/ChatFloat.js"></script>
	</body>


</html>