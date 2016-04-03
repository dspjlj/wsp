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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><s:property value="bigtype.name" /></title>
		<meta name="viewport"
			content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="format-detection" content="telephone=no" />
		<meta charset="utf-8" />
		<link href="<%=front %>tpl/Wap/default/common/css/ktv/style.css"
			rel="stylesheet" type="text/css" />
		<link type="text/css" rel="stylesheet"
			href="<%=front %>tpl/Wap/default/common/css/ktv/style01.css" />
		
		<style type="text/css" id="LB_ADBLOCK_0">
[src *="&sourcesuninfo=ad-"],.adarea,.adarea_top,#lovexin1,#lovexin2,.m_ad,#topBanner,.ad1,.ad2,.ad3,.ad4,.ad5,.ad6,.ad7,.ad8,.ad9,.adSpace,.ad_240_h,.side-Rad,.ol_ad_xiala,iframe[src
	^="http://a.cntv.cn"],[id ^="youku_ad_"],#bd1,#bd2,#bd3,.h8r.font0,.topbod>.topbodr,.topbodr>table[width="670"][height="70"],.widget_ad_slot_wrapper,.gg01,.gg02,.gg03,.gg04,.gg05,.gg06,.gg07,.gg08,.gg09,#_SNYU_Ad_Wrap,[id
	^="snyu_slot_"],.random-box>.random-banner,.gonglue_rightad,iframe[src
	^="http://www.37cs.com/html/click/"],#AdZoneRa,#AdZoneRb,#AdZoneRc,#AdZoneRd,#AdZoneRe,#AdZoneRf,#AdZoneRg,div[id="adAreaBbox"],.absolute.a_cover,#QQCOM_Width3,#auto_gen_6,.l_qq_com,#cj_ad,[href
	^="http://c.l.qq.com/adsclick?oid="],.right_ad_lefttext,.right_ad_righttext,.AdTop-Article-QQ,.business-Article-QQ,.qiye-Article-QQ,.AdBox-Article-QQ,td[width="960"][height="90"][align="center"],.adclass,.ad1,[id
	^="tonglan_"],.ads5,.adv,.ads220_60,.ad-h60,.ad-h65,.ggs,[class ^="ads360"],.news_ad_box,#XianAd,.Ad3Top-Article-QQ,.AdTop2-Article-QQ,.adbutton-Aritcle-QQ,#AdRight-Article-QQ,[id
	^=ad-block],.sidBoxNoborder.mar-b8,#ent_ad,[class="ad"][id="ad_bottom"],[class="ad"][id="ad_top"],.plrad,.ad300,#top_ad1,#top_ad2,#top_ad3,#top_ad4,#top_ad5,#top_ad6,#top_ad7,#top_ad8,#top_ad9,#mid_ad1,#mid_ad2,#mid_ad3,#mid_ad4,#mid_ad5,#mid_ad6,#mid_ad7,#mid_ad8,#mid_ad9,#ads1,#ads2,#ads3,#ads4,#ads5,#ads6,#ads7,#ads8,#ads9,.dlAd,.changeAd,.unionCpv,#Advertisement,iframe[src
	*="/advertisement."],img[src *="/advertisement."],.ad_headerbanner,#ad_headerbanner,div[class
	^=ad_textlink],iframe[src *="guanggao"],img[src *="guanggao"],#ads-top,#ads-bot,.adBanner,#topAd,.top_ad,.topAds,.topAd,.ad_column,#ad1,#ad2,#ad3,#ad4,#ad5,#ad6,#ad7,#ad8,#ad9,.ad_footerbanner,#adleft,#adright,.advleft,.advright,.ad980X60,.banner-ad,.top-ad,#adright,#AdLayer1,#AdLayer2,#AdLayer3,div[href
	*="click.mediav.com"],div[class=top_ad],div[class ^="headads"],div[class="ads"],.txtad,.guanggao,#guanggao,.adclass,div[id
	*="AdsLayer"],.ad950,.guangg,.header-ads-top,#adleft,#adright,#ad_show,.ad_pic,#fullScreenAd,div[class
	^="adbox"],#topADImg,div[class ^="ad_box"],div[id ^="adbox"],div[class
	^="ads_"],div[alt *="￥ﾹ﾿￥ﾑﾊ￤ﾽﾍ"],div[id ^="ads_"],div[src *="/adfile/"],.delayadv,#vplayad,.jadv,div[src
	*="/ads/"],div[src *="/advpic/"],div[id *="_adbox"],div[id *="-adbox"],div[class
	^="showad"],div[id ^="adshow"],#bottomads,.ad_column,div[id ^="_AdSame"],iframe[src
	^="http://drmcmm.baidu.com"],div[src ^="http://drmcmm.baidu.com"],frame[src
	^="http://drmcmm.baidu.com"],div[href ^="http://www.baidu.com/cpro.php?"],iframe[href
	^="http://www.baidu.com/cpro.php?"],div[src ^="http://cpro.baidu.com"],div[src
	^="http://eiv.baidu.com"],div[href ^="http://www.baidu.com/baidu.php?url="],div[href
	^="http://www.baidu.com/adrc.php?url="],.ad_text,div[href ^="http://click.cm.sandai.net"],div.adA.area,div[src
	*=".qq937.com"],iframe[src *=".qq937.com"],div[src *=".88210212.com"],iframe[src
	*=".88210212.com"],.adBox,.adRight,.adLeft,.banner-ads,.right_ad,.left_ad,.content_ad,.post-top-gg,div[class
	*="_ad_slot"],.col_ad,.block_ad,div[class ^="adList"],.adBlue,.mar_ad,div[id
	^="ArpAdPro"],.adItem,.ggarea,.adiframe,iframe[src *="/adiframe/"],#bottom_ad,.bottom_ad,.crumb_ad,.topadna,.topadbod,div[src
	*="qq494.cn"],iframe[src *="qq494.cn"],.topadbod,embed[src *="gamefiles.qq937.com"],embed[src
	*="17kuxun.com"],.crazy_ad_layer,#crazy_ad_layer,.bannerad,iframe[src *="/ads/"],img[src
	*="/ads/"],embed[src *="/ads/"],#crazy_ad_float,.crazy_ad_float,.main_ad,.topads,div[class
	^="txtadsblk"],.head-ad,div[src *="/728x90."],img[src *="/728x90."],embed[src
	*="/728x90."],iframe[src *="/gg/"],img[src *="/gg/"],iframe[src ^="http://www.460.com.cn"],#bg_ad,.ad_pic,iframe[src
	*="gg.yxdown.com"],.ad_top,#baiduSpFrame,.flashad,#flashad,#ShowAD,[onclick
	^="ad_clicked"],[class ^="ad_video_"],#ad_240,.wp.a_f,.a_mu,#hd_ad,#top_ads,#header_ad,#adbanner,#adbanner_1,#Left_bottomAd,#Right_bottomAd,#ad_alimama,#vipTip,.ad_pip,#show-gg,.ad-box,.advbox,.widget-ads.banner,.a760x100,.a200x375,.a760x100,.a200x100,.ad_left,.ad_right
	{
	display: none !important;
}
</style>
		<style type="text/css"></style>
		<style>
@
-moz-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-webkit-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
-o-keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
@
keyframes nodeInserted {
	from {opacity: 0.99;
}

to {
	opacity: 1;
}

}
embed,object {
	animation-duration: .001s;
	-ms-animation-duration: .001s;
	-moz-animation-duration: .001s;
	-webkit-animation-duration: .001s;
	-o-animation-duration: .001s;
	animation-name: nodeInserted;
	-ms-animation-name: nodeInserted;
	-moz-animation-name: nodeInserted;
	-webkit-animation-name: nodeInserted;
	-o-animation-name: nodeInserted;
}
</style>
	</head>
	<body screen_capture_injected="true">
		<div>
			<ul class="mainmenu2 radius margin10">
			
				<s:if test="pagearticles.size()==0">
              		  <li class="radius_top border-top-none">
							<div class="menubtn">
								<a href="article1.html">
									<h2 class="menutitle">
										亲，没有文章！
									</h2>
									<p class="menudesc">
										请耐心等待！
									</p> </a>
								<span class="icon">&nbsp;</span>
							</div>
						</li>
	            </s:if>
	            <s:iterator value="pagearticles" var="pagearticle" status="index">
					<li class="radius_top border-top-none">
						<div class="menubtn">
							<a href="pagearticleAction!frontView?id=<s:property value="id" />&wgwid=<s:property value="bigtype.wgw.id" />">
								<h2 class="menutitle">
									<s:property value="name" />
								</h2>
								<p class="menudesc">
									<s:date name="createtime" format="yyyy-MM-dd HH:mm:ss" />
								</p> 
							</a>
							<span class="icon">&nbsp;</span>
						</div>
					</li>
				</s:iterator>
			</ul>



		</div>

		<div style="display: none"></div>

		<div class="copyright" style="text-align: center;">
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


		
		<script type="text/javascript"
			src="<%=front %>tpl/Wap/default/common/js/ChatFloat.js"></script>


	</body>

</html>