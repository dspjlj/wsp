<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <!-- Apple devices fullscreen -->
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <!-- Apple devices fullscreen -->
  <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
  <base target="mainFrame" />
  <link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all" />
  <link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all" />
  <link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all" />
  <link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all" />
  <link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all" />
  <style type="text/css">
.main-nav, .icon-nav{
height: 56px;
}
.main-nav li, .icon-nav li,.dropdown{
height: 56px;
}

.icon-nav li.subtitle{
height: 16px;
}
.main-nav li a,#navigation .user .dropdown a,.icon-nav li a,.toggle-nav{
line-height: 36px;
padding: 10px;
}
#navigation .main-nav li a .caret,#navigation .icon-nav li a .caret,#navigation .user .dropdown a .caret{
margin-top: 14px;
}
</style>
  <title>第三屏—国内免费的微信公众服务平台</title>
  
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/yyucadapter.js"></script>
  <link rel="shortcut icon" href="faviconmy.ico" />
  <script type="text/javascript">
$(function(){
  if(window.parent && window.parent != window){
    window.parent.location.href = location.href;
  }
  $('#maincolor').find('span').click(function(){
    var col = 'theme-'+$(this).attr('class');
    $('body').removeAttr('class').addClass(col);
    $('#maincolor').hide();
    ajax('ind-setcolor.html',{ col:col},function(){
      $('#mainFrame').contents().find("body").removeAttr('class').addClass(col);
    });
  });
  
  
});


</script>
</head>
<body class="theme-grey">
  <div id="navigation">
    <div class="container-fluid" style="position:relative;">
      <div>
        <a href="javascript:;" target="_self" id="brand">
          <img src="media/images/reg/logo2.png" style="margin-top: 6px;"/>
        </a>
        <a href="javascript:;" target="_self" class="toggle-nav" rel="tooltip" data-placement="bottom" title="Toggle navigation"> <i class="icon-reorder"></i>
        </a>
      </div>
      <ul class='main-nav'>
        <li class='active'>
          <a href="javascript:;">
            <span>公众号功能</span>
          </a>
        </li>
        <li>
          <a href="main1.jsp" target="_self">账号管理</a>
        </li>

</ul>
<div class="user">
<ul class="icon-nav">
<li class='dropdown'>
<a href="javascript:;" class='dropdown-toggle' data-toggle="dropdown" title="消息" style="display:none;"> <i class="icon-envelope"></i>
  <span class="label label-lightred">4</span>
</a>
</li>
<li class="dropdown sett" style="display:none;">
<a href="javascript:;" class='dropdown-toggle' data-toggle="dropdown" title="系统设置">
  <i class="icon-cog"></i>
</a>
</li>
<li class='dropdown colo'>
<a href="javascript:;" class='dropdown-toggle' data-toggle="dropdown" title="选择颜色">
  <i class="icon-tint"></i>
</a>
<ul class="dropdown-menu pull-right theme-colors" id="maincolor">
  <li class="subtitle">请选择系统颜色</li>
  <li>
    <span class='red'></span>
    <span class='orange'></span>
    <span class='green'></span>
    <span class="brown"></span>
    <span class="blue"></span>
    <span class='lime'></span>
    <span class="teal"></span>
    <span class="purple"></span>
    <span class="pink"></span>
    <span class="magenta"></span>
    <span class="grey"></span>
    <span class="darkblue"></span>
    <span class="lightred"></span>
    <span class="lightgrey"></span>
    <span class="satblue"></span>
    <span class="satgreen"></span>
  </li>
</ul>
</li>
</ul>
<div class="dropdown">
<a href="javascript:;" class='dropdown-toggle'  target="_self" data-toggle="dropdown" style="width:127px;">
<nobr>
  ${dspuser.username }
  <span class="caret"></span>
  <img class="thumb_img" src="" id="pic_apartpic" style="max-width:40px" />
</nobr>
</a>
<ul class="dropdown-menu pull-right">
<li>
  <a href="main1.jsp">管理帐号</a>
</li>
<li>
  <a href="login.jsp" target="_self">退出</a>
</li>
</ul>
</div>

</div>
</div>
</div>
<!--菜单栏-->
<div class="container-fluid" id="content">
  <div id="left">
    <div class="subnav">
      <div class="subnav-title">
        <a href="javascript:void(0);" class='toggle-subnav'> <i class="icon-angle-right"></i>
          <span>
            素材库
            <!--
            <img id="strong" src="res/xiaobai/jian.png">
            -->
            </span>
        </a>
      </div>
      <ul class="subnav-menu" style="display: none">
        <li>
          <a href="guanzhuresAction!view">首次关注</a>
        </li>
        <li>
          <a href="autoresAction!view">自动回复</a>
        </li>
        <li>
          <a href="publickeyAction!list">关键字回复</a>
        </li>
        <li>
          <a href="fodderAction!list">素材管理</a>
        </li>
        <li>
          <a href="diypuffAction!view">DIY宣传页</a>
        </li>
        <li>
          <a href="lbsAction!list">LBS设置</a>
        </li>
      </ul>
    </div>

    
    <div class="subnav">
      <div class="subnav-title">
        <a href="javascript:void(0);" class='toggle-subnav'>
          <i class="icon-angle-right"></i>
          <span>
            自定义菜单
          </span>
        </a>
      </div>
      <ul class="subnav-menu" style="display: none">
        <li>
          <a href="pubclientAction!loadappauth">授权设置</a>
        </li>
        <li>
          <a href="custommenuAction!view">菜单设置</a>
        </li>
      </ul>
    </div>
    <div class="subnav">
      <div class="subnav-title">
        <a href="javascript:void(0);" class='toggle-subnav'>
          <i class="icon-angle-right"></i>
          <span>
            微官网&nbsp;&nbsp;
          </span>
        </a>
      </div>
      <ul class="subnav-menu" style="display: none">
        
          <li>
            <a href="wgwAction!view">微官网设置</a>
          </li>
		
		  <li>
            <a href="wgwAction!template">模板预览</a>
          </li>
        
	      <li>
	        <a href="wgw_bgmusic_set.html">背景音乐设置</a>
	      </li>
		  <li>
	        <a href="wgw_lunbo.html">背景轮播设置</a>
	      </li>
		  
		  <li>
	        <a href="wgw_bigtype_manage.html">首页类别管理</a>
	      </li>
		  
		  
		  <li>
	        <a href="wgw_pagearticle_manage.html">文章管理</a>
	      </li>
		  
	      <li>
	        <a href="wgw_menu_set.html">菜单导航设置</a>
	      </li>
	      
	      <li>
	        <a href="wgw_version.html">底部版权设置</a>
	      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微商城</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="shop_add.html">关键字设置</a>
      </li>
      <li>
        <a href="shop_slide.html">幻灯片配置</a>
      </li>
      <li>
        <a href="shop_cate_manage.html">分类管理</a>
      </li>
      <li>
        <a href="shop_product_manage.html">商品管理</a>
      </li>
      <li>
        <a href="shop_order_manage.html">订单管理</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>
          微会员&nbsp;&nbsp;
        </span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="membercard_manage.html">会员卡管理</a>
      </li>
      <li>
        <a href="membercard_add.html">会员卡添加</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微相册</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="album_set.html">相册设置</a>
      </li>
      <li>
        <a href="album_manage.html">相册管理</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>
          微活动
        </span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="activity_coupon_manage.html">优惠券</a>
      </li>
      <li>
        <a href="activity_ggcard_manage.html">刮刮卡</a>
      </li>
      <li>
        <a href="activity_luckyma_manage.html">幸运机</a>
      </li>
      <li>
        <a href="activity_turntable_manage.html">大转盘</a>
      </li>
      <li>
        <a href="activity_glodegg_manage.html">砸金蛋</a>
      </li>
	  <li>
        <a href="activity_standingtk_manage.html">一站到底题库管理</a>
      </li>
      <li>
        <a href="activity_standing_manage.html">一站到底</a>
      </li>
      
    </ul>
  </div>

  
  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微客服</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="customer_add.html">微客服设置</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微团购</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="groupbuy_manage.html">微团购管理</a>
      </li>
      <li>
        <a href="groupbuy_add.html">微团购新增</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>
          微预约
          <!--
          <img id="strong" src="res/xiaobai/re.gif">
          -->
          </span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="appointment_manage.html">预约管理</a>
      </li>

    </ul>
  </div>

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微留言</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="message_add.html">留言板设置</a>
      </li>
      <li>
        <a href="message_manage.html">留言管理</a>
      </li>
      <li>
        <a href="message_blacklist.html">黑名单管理</a>
      </li>
    </ul>
  </div>

  

  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>
          微调研&nbsp;&nbsp;
        </span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="survey_manage.html">调研管理</a>
      </li>
      <li>
        <a href="survey_add.html">调研新增</a>
      </li>
    </ul>
  </div>
  
  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>
          微贺卡
          <!--
          <img id="strong" src="res/xiaobai/xin1.gif">
          -->
          </span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="greetcard_add.html">微贺卡设置</a>
      </li>
    </ul>
  </div>
  <div class="subnav">
    <div class="subnav-title">
      <a href="javascript:void(0);" class='toggle-subnav'>
        <i class="icon-angle-right"></i>
        <span>微投票</span>
      </a>
    </div>
    <ul class="subnav-menu" style="display: none">
      <li>
        <a href="vote_manage.html">微投票管理</a>
      </li>
      <li>
        <a href="vote_add.html">微投票新增</a>
      </li>
    </ul>
  </div>

  <div class="subnav">
      <div class="subnav-title">
        <a href="javascript:void(0);" class='toggle-subnav'>
          <i class="icon-angle-right"></i>
          <span>
            微游戏
            <!--
            <img id="strong" src="res/new.gif">
            -->
            </span>
        </a>
      </div>
      <ul class="subnav-menu" style="display: none">
        <li>
          <a href="game_list.html">
            游戏和功能
            <!--
            <img id="strong" src="res/hot.gif">
            -->
          </a>
        </li>
      </ul>
    </div>
<!--
                <div class="subnav">
<div class="subnav-title">
<a href="javascript:void(0);" class='toggle-subnav'>
<i class="icon-angle-right"></i>
<span>
微门店&nbsp;&nbsp;
<img id="strong" src="res/xiaobai/jian.png"></span>
</a>
</div>
<ul class="subnav-menu" style="display: none">
<li>
<a href="shop.html">门店管理</a>
</li>
<li>
<a href="shopadd.html">门店新增</a>
</li>
</ul>
</div>
-->
<div class="subnav bottom">
<div class="subnav-title">
<a href="javascript:alert('没有权限');" class='toggle-subnav'>
<i class="icon-angle-right"></i>
<span></span>
</a>
</div>
<ul class="subnav-menu"></ul>
</div>
</div>

<div class="right">
<div class="main">
<iframe frameborder="0" id="mainFrame" name="mainFrame" src="welcome.jsp" style="background: url('media/images/loading.gif') center no-repeat"></iframe>
</div>
</div>

</div>

<script type="text/javascript">
    $('[data-toggle="dropdown"]').each(function(){
      $(this).parent().hover(function(){
        $(this).find('ul').show();
      },function(){
        $(this).find('ul').hide();
      });
    });
    $('div.subnav > .subnav-title').click(function(){
      var pul = $(this).parent().find('ul');
      if(pul.is(':hidden')){
        var vone = $('div.subnav').find('ul:visible');
        pul.slideDown(200,function(){
          vone.slideUp();
        });
      }else{
        pul.slideUp();
      }
    });
    $('div.subnav').find('ul').children('li').click(function(){
      $('div.subnav').find('ul').children('li').removeClass('active');
      $(this).addClass('active');
    });
    $('.toggle-nav').click(function(){
      if($('.right').is('.reight_p')){
        $('.right').removeClass('reight_p');  
        $('#left').show();
      }else{
        $('.right').addClass('reight_p');
        $('#left').hide();
      }     
    });
    $('.main-nav').children('li').click(function(){
      $('.main-nav').find('li').removeClass('active');
      $(this).addClass('active');
    });
    function fresh_sys(){
      mainFrame.location.reload();
      
    }
    </script>
</body>

</html>