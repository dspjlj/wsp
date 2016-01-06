<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String front=basePath+"front/";
%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta name="format-detection" content="telephone=no">
  <meta content="telephone=no" name="format-detection">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title><s:property value="bigtype.name" /></title>

  <link type="text/css" rel="stylesheet" href="<%=front %>stylesheets/vweisiteV01.css"/>
  <link type="text/css" rel="stylesheet" href="<%=front %>stylesheets/font-awesome.css"/>
  <link href="<%=front %>stylesheets/vweisiteV01/list/list7.css" media="screen" rel="stylesheet" type="text/css" />

  <script src="<%=front %>assets/mobile/vweisiteV01-e2ea5a80772cd54559b36cf747bc391d.js" type="text/javascript"></script>
</head>

<body>

  <div class="html" style="">
    <div class="stage" id="stage">
      <section id="sec-index">

        <div class="body">

          <div class="mod-slider slider-hor" id="index">
            <ul class="slider-list">
              <li>
                <a>
                  <img alt="没有封面图片" src="<%=basePath %><s:property value="bigtype.imageurl" />" />
                </a>
              </li>
            </ul>
            <div class="slider-text">
              <span class="fl slider-span" id="slider-span"><s:property value="bigtype.name" /></span>
            </div>
          </div>

          <div class="list">
            <ul>
            
            	  <s:if test="pagearticles.size()==0">
              		  <li>
		                  <div class="list-text" style="padding: 10px;">
		                    <h1>亲，没有图文信息！</h1>
		                  </div>
		              </li>
	              </s:if>
	              <s:iterator value="pagearticles" var="pagearticle" status="index">
	              <li>
	                <a href="pagearticleAction!frontView?id=<s:property value="id" />&wgwid=<s:property value="bigtype.wgw.id" />">
	                  <div class="list-img"> <b><img alt="暂无图片" src="<%=basePath %><s:property value="imageurl" />" /></b> 
	                  </div>
	
	                  <div class="list-text">
	                    <h1><s:property value="name" /></h1>
	                    <h2><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss" /></h2>
	                  </div>
	                </a>
	              </li>
              	</s:iterator>
            </ul>
          </div>

        </div>
      </section>

    </div>
    <!--.stage end--> </div>
  <!--.html end-->


  <s:action name="footerAction!frontFooter">
		<s:param name="wgwid" value="%{#request.wgw.id}"></s:param>
	</s:action>
	<s:if test="#request.footer!=null">
		<footer>技术支持：<s:property value="#request.footer.foottitle"/></footer>
	</s:if>
	<s:else>
		<footer>技术支持：第三屏</footer>
	</s:else>

  <style type="text/css">
        /*pop*/
    .pop-zoom{display:none;width:100%;height:100%;color:#fff;position:fixed;left:0;top:0;background:rgba(0,0,0,0.5);z-index:10000;}
    .pop-zoom-img{background:#000;text-align:center;overflow:hidden;}
    .show-img{width:100%;height:100%;overflow:hidden;position:relative;}
    .show-img img{max-width:100%;}
    .zoom-close{position:fixed;right:5px;top:5px;display:block;z-index:99999;}
    .zoom-close .fa{width:30px;height:30px;font-size:25px;line-height:30px;border-radius:50%;color:#fff;background:#999;}
</style>
  <script src="<%=front %>assets/mobile/lib/iScroll-4.2.5.js"></script>
  <script type="text/javascript">
    var flag = true; css_reg = /^[\w]*font-awesome\.min[\w]*/;
    $.each($('link[type="text/css"]'), function(){
        var arr = $(this).attr('href').split('/');
        if(arr.length == 0){
            return true;
        }
        if(css_reg.test(arr[arr.length - 1])){
            flag = false;
            return flag;
        }
    });
    if(flag){
        document.write('<link rel="stylesheet" href="<%=front %>assets/font/font-awesome.min.css">')
    }
    var img_zoom_myscroll, img_zoom_scrollTop;

    function loaded(){
        img_zoom_myscroll = new iScroll("imgScroll",{
            hScroll: true,
            useTransition: true,
            hScrollbar: false,
            vScrollbar: false,
            zoom: true
        });
        document.addEventListener("DOMContentLoaded",loaded,false);
    }

    $(function(){
        $('body').append('<div class="pop-zoom pop-zoom-img"><div class="show-img" id="imgScroll"><div><img src=""></div></div><a href="javascript:;" class="zoom-close"><i class="fa fa-times"></i></a>')
        $('body').on('click', 'img', function(){
            if(($(this).closest('a').length > 0 && ($(this).closest('a').attr('href') != '#' && $(this).closest('a').attr('href') != 'javascript:;')) || $(this).closest('.mod-navLine').length > 0 || $(this).hasClass('website_list_21')){

            }else{
                var $this = $(this),
                    $src = null,
                    $img = $(".show-img img"),
                    $pop = $(".pop-zoom-img");
                img_zoom_scrollTop = $(document).scrollTop();
                $(document).scrollTop(0);
                if(!$this.attr('data-src')){
                  $src = $this.attr("src");
                }else{
                  $src = $this.attr("data-src");
                }
                $img.attr("src",$src);
                $pop.show();
                setTimeout(function(){
                    loaded();
                },300);
                //console.log(scrollTop);
            }
        });
        $(document).on("click",".zoom-close",function(){
            $(document).scrollTop(img_zoom_scrollTop);
            $(this).parents(".pop-zoom").hide();
            $(".show-img img").attr('src', '');
            img_zoom_myscroll.destroy();
        })
        var initTop = 0,
            isScroll = true;
        function fnAnimate(thisTop){
            $("header:not('.untoppable')").animate({top:thisTop},"500",function(){isScroll=true});
        }
        $(window).on("scroll",function(){
            var scrollTop = $(document).scrollTop();
            if(isScroll){
                if(scrollTop > initTop){
                    fnAnimate("-44px");
                }else{
                    fnAnimate("0");
                }
            }
            initTop = scrollTop;
            isScroll = false;
        });
    });
</script>

  <!-- 快捷菜单 Start -->
  <s:action name="wgwmenuAction!frontMenu">
  		<s:param name="wgwid" value="%{#request.wgw.id}"></s:param>
  </s:action>
  <div class="mod-navPop navPop-1">
    <div class="navPop-wrap hide" id="navPop-wrap">
      <b class="navPop-btn" id="navPop-btn"> <i class="fa fa-plus" id="fa-btn" onclick="toggleToClass('#navPop-btn','active')"></i>
      </b>
      <div>
        <a href='wgwAction!frontindex?frontpa=<s:property value="#session.frontpa" />' class="">
          <i class="fa fa-home"></i>
        </a>
      </div>
      <s:if test="#request.wgwmenu!=null">
      	<s:if test="#request.wgwmenu.menu2url!=null&&#request.wgwmenu.menu2url!=''">
      		<s:if test="#request.wgwmenu.menu2url.contains('tel')">
      			<div>
			        <a href='<s:property value="#request.wgwmenu.menu2url" />' class="">
			          <i class="fa fa-phone"></i>
			        </a>
			    </div>
      		</s:if>
      		<s:elseif test="#request.wgwmenu.menu2url.contains('location')">
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu2url" />" class="">
			          <i class="fa fa-location-arrow"></i>
			        </a>
			     </div>
      		</s:elseif>
      		<s:else>
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu2url" />" class="">
			          <i class="fa fa-globe"></i>
			        </a>
			      </div>
      		</s:else>
      	</s:if>
      
      
      	<s:if test="#request.wgwmenu.menu3url!=null&&#request.wgwmenu.menu3url!=''">
      		<s:if test="#request.wgwmenu.menu3url.contains('tel')">
      			<div>
			        <a href='<s:property value="#request.wgwmenu.menu3url" />' class="">
			          <i class="fa fa-phone"></i>
			        </a>
			    </div>
      		</s:if>
      		<s:elseif test="#request.wgwmenu.menu3url.contains('location')">
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu3url" />" class="">
			          <i class="fa fa-location-arrow"></i>
			        </a>
			     </div>
      		</s:elseif>
      		<s:else>
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu3url" />" class="">
			          <i class="fa fa-globe"></i>
			        </a>
			      </div>
      		</s:else>
      	</s:if>
      	
      	<s:if test="#request.wgwmenu.menu4url!=null&&#request.wgwmenu.menu4url!=''">
      		<s:if test="#request.wgwmenu.menu4url.contains('tel')">
      			<div>
			        <a href='<s:property value="#request.wgwmenu.menu4url" />' class="">
			          <i class="fa fa-phone"></i>
			        </a>
			    </div>
      		</s:if>
      		<s:elseif test="#request.wgwmenu.menu4url.contains('location')">
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu4url" />" class="">
			          <i class="fa fa-location-arrow"></i>
			        </a>
			     </div>
      		</s:elseif>
      		<s:else>
      			<div>
			        <a href="<s:property value="#request.wgwmenu.menu4url" />" class="">
			          <i class="fa fa-globe"></i>
			        </a>
			      </div>
      		</s:else>
      	</s:if>
      
      
      </s:if>
    </div>
  </div>
  <!-- 快捷菜单 End -->

  <link type="text/css" rel="stylesheet" href="<%=front %>stylesheets/vweisiteV01/animateBg/snower1.css"/>
  <div class="mod-snower snower1" id="snower1">
    <script type="text/javascript">var urls = ["<%=front %>assets/mobile/vweisiteV01/animateBg/snower9.png"]</script>
    <script type="text/javascript" src="<%=front %>javascripts/vweisiteV01/animateBg/snower1.js"></script>
    <script>
             $(function(){
                 snowsFn(16);
             });
         </script>
  </div>

  <a href="javascript:scroll(0,0)" class="btn-up btn-up-1">
    <i class="fa fa-arrow-up"></i>
  </a>
  <div class="loading fixed-top"></div>

  <div class="mod-pop" id="pop-share" onclick="hidePop('#pop-share')">
    <span class="text-share"></span>
  </div>

  <script type="text/javascript">
      $(document).ready(function(){

                indexSwipe("index", ["", "", "", "", ""]);
        bannerSet({
            background: "#000000",
            opacity: "50",
            color: "#FFFFFF"
        })
        // 静态背景图
        //$(".html").css("background-image", "url(pictures/FqJknzulpXhKRkr-uaIGRE1bg4d2)");
      navPop1("#navPop-wrap","#navPop-btn"); // 快捷菜单    
      $("#navPop-wrap").show();


        showBtnUp(100);

      });
    </script>

</body>
</html>