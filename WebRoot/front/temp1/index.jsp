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
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta name="format-detection" content="telephone=no">
  <meta content="telephone=no" name="format-detection">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title><s:property value="#request.wgw.title"/></title>

  <link type="text/css" rel="stylesheet" href="<%=front %>stylesheets/vweisiteV01.css"/>
  <link type="text/css" rel="stylesheet" href="<%=front %>stylesheets/font-awesome.css"/>
  <link href="<%=front %>stylesheets/vweisiteV01/index/index93.css" media="screen" rel="stylesheet" type="text/css" />

  <script src="<%=front %>assets/mobile/vweisiteV01-e2ea5a80772cd54559b36cf747bc391d.js" type="text/javascript"></script>
  <meta content="authenticity_token" name="csrf-param" />
  <meta content="uu4elJjeyZd8k/ARutXFPy7LP4D5o+kT1gTnvZ8OwRo=" name="csrf-token" />
  <script src="<%=front %>assets/mobile/lib/iscroll-cecd28ae7bd05946cc2efbf28ef43a74.js" type="text/javascript"></script>
</head>

<body>

  <div class="html" style="background-image: url(<%=basePath %><s:property value="#request.screenimg.bgimg"/>)">
  	<s:action name="bgmusicAction!frontBgmusic">
  		<s:param name="wgwid" value="#request.wgw.id"></s:param>
  	</s:action>
  	<s:if test="#request.bgmusic!=null&&#request.bgmusic.ison==1">
	  	<audio autoplay="autoplay">
			<source src="<s:property value="#request.bgmusic.musicurl"/>" type="audio/mpeg">
		</audio>
	</s:if>
    <div class="stage" id="stage">
      <section id="sec-index">

        <div class="body">

          
          <div class="index" id="indexList">
            <ul class="index-wrap">
            	<s:if test="#request.bigtypes.size()==0">
              		<li>
		                <a href='javascript:void(0);' class="box mod-index">
		                  <div class="index-name">没有类别</div>
		                  <div class="index-line"></div>
		                  <div class="index-icon">
		                  		<i class="fa fa-heart-o"></i>
		                  </div>
		                  <div class="index-summary">亲！掌柜的太忙！没有设置类别！</div>
		                </a>
		            </li>
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
	                ' class="box mod-index">
	                  <div class="index-name"><s:property value="name"/></div>
	                  <div class="index-line"></div>
	                  <div class="index-icon">
	                  <s:if test="#index.count%2==0">
	                  		<i class="fa fa-heart"></i>
	                  </s:if>
	                  <s:else>
	                  		<i class="fa fa-heart-o"></i>
	                  </s:else>
	                  
	                  </div>
	                  <div class="index-summary"><s:property value="enname"/></div>
	                </a>
	              </li>
	            </s:iterator>
              
            </ul>
          </div>

          <script type="text/javascript">
    $(function(){
        vcScroll();
        // 静态背景图
        //$(".html").css("background-image", "url(pictures/FsughMLV_Qobvz6d7GGFj69R2PVD)");
    });
    function vcScroll (id) {
        var myScroll = new IScroll("#indexList", {
            scrollX: true,
            scrollY: false,
            mouseWheel: true,
            scrollbars: false,
            mouseWheel: true,
            interactiveScrollbars: true,
            shrinkScrollbars: 'scale',
            fadeScrollbars: true,
            click: true
        });
        document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
    }
</script>

        </div>
      </section>

    </div>
    <!--.stage end--> </div>
  <!--.html end-->

  <div class="alert J-guanzhu" style="display:none">
    <div class="alert-m">
      <div class="alert-img"></div>
      <div class="alert-c">
        <p>请先关注公众帐号</p>
        <p>
          <span class="alert-num">1</span>
          点击右上角
          <span class="alert-text">分享按钮</span>
          查看公众号
        </p>
        <p>
          <span class="alert-num">2</span>
          在【添加朋友】—【查找公众号】中搜索
        </p>
        <p>
          <span class="alert-btn">我的面包</span>
          （长按可复制）
        </p>
        <p>
          如果已关注，请打开该公众帐号回复
          <span class="alert-text"></span>
          ，参与此活动
        </p>
      </div>
      <div class="alert-f">
        <a href="javascript:;" class="alert-f-btn J-close">我知道了</a>
      </div>
    </div>
  </div>
  <div class="alert J-register" style="display:none">
    <div class="alert-m">
      <div class="alert-img"></div>
      <div class="alert-c text-center"></div>
      <div class="alert-btn-box">
        <div class="alert-cell cell-4">
          <a href="javascript:;" class="alert-f-btn btn-gray J-close">我知道了</a>
        </div>
      </div>
    </div>
  </div>
	<s:action name="footerAction!frontFooter">
		<s:param name="wgwid" value="%{#request.wgw.id}"></s:param>
	</s:action>
	<s:if test="#request.footer!=null">
		<footer>技术支持：<s:property value="#request.footer.foottitle"/></footer>
	</s:if>
  	<s:else>
		技术支持：第三屏
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

  <a href="javascript:scroll(0,0)" class="btn-up btn-up-1">
    <i class="fa fa-arrow-up"></i>
  </a>
  <div class="loading fixed-top"></div>

  <div class="mod-pop" id="pop-share" onclick="hidePop('#pop-share')">
    <span class="text-share"></span>
  </div>

  

</body>
</html>