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

  <title>糕点展</title>

  <link type="text/css" rel="stylesheet" href="stylesheets/vweisiteV01.css"/>
  <link type="text/css" rel="stylesheet" href="stylesheets/font-awesome.css"/>
  <link href="stylesheets/vweisiteV01/list/list7.css" media="screen" rel="stylesheet" type="text/css" />

  <script src="assets/mobile/vweisiteV01-e2ea5a80772cd54559b36cf747bc391d.js" type="text/javascript"></script>
  <meta content="authenticity_token" name="csrf-param" />
  <meta content="uu4elJjeyZd8k/ARutXFPy7LP4D5o+kT1gTnvZ8OwRo=" name="csrf-token" />
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
                  <img alt="Fopmvbdnsgxg3dpel5ht_iltpmnl" src="pictures/template2_list_1.jpg" />
                </a>
              </li>
            </ul>
            <div class="slider-text">
              <span class="fl slider-span" id="slider-span">糕点展</span>
            </div>
          </div>

          <div class="list">
            <ul>
              <li>
                <a href="2_article.jsp">
                  <div class="list-img"> <b><img alt="Ftvtpds6ike2hxedy6fxzxy9_mfi" src="pictures/template2_list_2.jpg" /></b> 
                  </div>

                  <div class="list-text">
                    <h1>面包展</h1>
                    <h2>2014-06-25 10:57</h2>
                  </div>
                </a>
              </li>
              <li>
                <a href="2_article.jsp">
                  <div class="list-img"> <b><img alt="Frg37risas7ih1kasqwmiam8ytxr" src="pictures/template2_list_3.jpg" /></b> 
                  </div>

                  <div class="list-text">
                    <h1>蛋糕展</h1>
                    <h2>2014-06-23 13:13</h2>
                  </div>
                </a>
              </li>
            </ul>
          </div>

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
          <span class="alert-btn">麦香村蛋糕</span>
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

  <footer>第三屏</footer>

  <style type="text/css">
        /*pop*/
    .pop-zoom{display:none;width:100%;height:100%;color:#fff;position:fixed;left:0;top:0;background:rgba(0,0,0,0.5);z-index:10000;}
    .pop-zoom-img{background:#000;text-align:center;overflow:hidden;}
    .show-img{width:100%;height:100%;overflow:hidden;position:relative;}
    .show-img img{max-width:100%;}
    .zoom-close{position:fixed;right:5px;top:5px;display:block;z-index:99999;}
    .zoom-close .fa{width:30px;height:30px;font-size:25px;line-height:30px;border-radius:50%;color:#fff;background:#999;}
</style>
  <script src="assets/mobile/lib/iScroll-4.2.5.js"></script>
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
        document.write('<link rel="stylesheet" href="assets/font/font-awesome.min.css">')
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
  <div class="mod-navPop navPop-1">
    <div class="navPop-wrap hide" id="navPop-wrap">
      <b class="navPop-btn" id="navPop-btn"> <i class="fa fa-plus" id="fa-btn" onclick="toggleToClass('#navPop-btn','active')"></i>
      </b>
      <div>
        <a href="tel:15861521065" class=""> <i class="fa fa-phone"></i>
        </a>
      </div>
      <div>
        <a href="#location" class="">
          <i class="fa fa-location-arrow"></i>
        </a>
      </div>
    </div>
  </div>
  <!-- 快捷菜单 End -->

  <link type="text/css" rel="stylesheet" href="stylesheets/vweisiteV01/animateBg/snower1.css"/>
  <div class="mod-snower snower1" id="snower1">
    <script type="text/javascript">var urls = ["assets/mobile/vweisiteV01/animateBg/snower9.png"]</script>
    <script type="text/javascript" src="javascripts/vweisiteV01/animateBg/snower1.js"></script>
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

        $("a.dev-prev").click(function(){
            history.back();
        });

        $("a.dev-next").click(function(){
          history.go(1);
        });

        $("a.dev-index").click(function(){
          location.href = "6_index_dangao.html";
        });

        $("a.dev-refresh").click(function(){
          location.reload();
        });

        $("a.dev-tel").attr("href", "tel:15861521065");

        $("a.dev-member").click(function(){
          $(this).attr("href", "#")
        });

        $("a.dev-location").click(function(){
          $(this).attr("href", "#")
        });
      });
    </script>

</body>
</html>