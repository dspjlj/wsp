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
    <link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all" />
    <title>第三屏—国内免费的微信公众服务平台</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/yyucadapter.js"></script>
    <link rel="shortcut icon" href="/favicon.ico" />
</head>
<body class="theme-lightgrey">
    <div id="main">
        <div class="row-fluid">
            <div class="span12">
                <div class="box ">
                    <div class="box-title">
                        <h3> <i class="icon-user"></i>
                            账户信息
                        </h3>
                    </div>
                    <div class="box-content">

                        <dl class="dl-horizontal">
                            <!--<dt>
                                   <img src="http://img.weimob.com/static/2d/f4/76/image/20131125/20131125093622_45962.png" style="width: 88px; height: 88px" class="img-rounded"></dt>
                            -->
                            <dd style="margin-left: 20px;">
                                <p> <strong>${session.dspuser.username}</strong>
                                    ： <b class="text-warning">套餐级别：
                                    <s:if test="#session.pubclient.protype==1">
                                    	基础版会员
                                    </s:if>
                                    <s:else>
                                    	升级版会员
                                    </s:else>
                                    </b>
                                    <a href="#"> <i class="icon-arrow-up" title="充值"></i>
                                        充值
                                    </a>

                                </p>

                                <table class="table noborder">
                                    <tbody>
                                        <tr>
											<td>公众号名称：${session.pubclient.publicname }</td>
                                            <td>公众号微信号：${session.pubclient.publicno }</td>
                                            <td>开户时间：${session.pubclient.createdate }</td>
                                            <td>到期时间：${session.pubclient.deaddate }</td>
                                            
                                        </tr>
                                        <!-- 
                                        <tr>
                                            <td>今日关注数 : 0</td>
                                            <td>今日请求数 : 0</td>
                                            <td>本月关注总数：0</td>
                                            <td>本月请求总数：0</td>
                                        </tr>
                                         -->
                                        <tr>
                                            <td>文本自定义: 不限</td>
                                            <td>图文自定义 : 不限</td>
                                            <td>语音自定义：不限</td>
                                            <td>每月可请求数：不限</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <!-- 
                                <p> <strong>接口地址：</strong>
                                    http://www.di3p.com/mpapi.html?appid=10652&nbsp;&nbsp;&nbsp;&nbsp;
                                    <strong>TOKEN：</strong>
                                    618fe8ab86030cf742616705140ea046
                                </p>
                                 -->
                            </dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div class="box">

                <div class="box-title">
                    <h3>
                        <i class="icon-rocket"></i>
                        快捷操作 <font color="#FF0000">&nbsp;&nbsp;&nbsp;下方内容如无法正常显示，请您更换浏览器。向您推荐：谷歌浏览器</font>
                        <a target="_blank" href="http://w.x.baidu.com/alading/anquan_soft_down_ub/14744">&nbsp;点此下载&nbsp;</a>
                    </h3>
                </div>
                <div class="box-content">
                    <div class="block block-tiles block-tiles-animated clearfix">
                        <a href="/admin/businessModule/wsite.html" target="mainFrame" class="tile tile-themed">
                            <i class="icon-globe "></i>
                            <div class="tile-info">
                                <strong>微官网</strong>
                            </div>
                        </a>
                        <!-- 
                        <a href="/admin/weiqishop/shopkeyword.html" class="tile not tile-themed">
                            <i class="icon-shopping-cart"></i>
                            <div class="tile-info">
                                <strong>微商城</strong>
                            </div>
                        </a>
                        <a href="/admin/businessModule/microMemberCard.html" class="tile tile-themed">
                            <i class="icon-credit-card"></i>
                            <div class="tile-info">
                                <strong>会员卡</strong>
                            </div>
                        </a>
                        <a href="/admin/xiangce/set.html" class="tile tile-themed">
                            <i class="icon-picture"></i>
                            <div class="tile-info">
                                <strong>微相册</strong>
                            </div>
                        </a>
                        
                        
                        <a href="/admin/marketingPromotion/ggk.html" class="tile tile-themed">
                            <i class="icon-hand-up"></i>
                            <div class="tile-info">
                                <strong>刮刮卡</strong>
                            </div>
                        </a>
                        <a href="/admin/marketingPromotion/xydzp.html" class="tile tile-themed">
                            <i class="icon-dashboard "></i>
                            <div class="tile-info">
                                <strong>大转盘</strong>
                            </div>
                        </a>
                        <a href="/admin/marketingPromotion/discountCoupon.html" class="tile tile-themed">
                            <i class="icon-money "></i>
                            <div class="tile-info">
                                <strong>优惠券</strong>
                            </div>
                        </a>
                        <a href="/admin/marketingPromotion/yzdd.html" class="tile not tile-themed">
                            <i class="icon-female"></i>
                            <div class="tile-info">
                                <strong>一战到底</strong>
                            </div>
                        </a>
                        <a href="/admin/businessModule/microGroupBuy.html" class="tile not tile-themed">
                            <i class="icon-group"></i>
                            <div class="tile-info">
                                <strong>微团购</strong>
                            </div>
                        </a>
                        <a href="/admin/businessModule/onlineBooking.html" class="tile tile-themed">
                            <i class="icon-phone-sign"></i>
                            <div class="tile-info">
                                <strong>微预约</strong>
                            </div>
                        </a>
                        
                        <a href="/admin/marketingPromotion/weibaht.html" class="tile tile-themed">
                            <i class="icon-edit"></i>
                            <div class="tile-info">
                                <strong>微留言</strong>
                            </div>
                        </a>
                        <a href="/admin/businessModule/microSurvey.html" class="tile tile-themed">
                            <i class="icon-pencil"></i>
                            <div class="tile-info">
                                <strong>微调研</strong>
                            </div>
                        </a>
                        <a href="/admin/businessModule/microVote.html" class="tile tile-themed">
                            <i class="icon-thumbs-up"></i>
                            <div class="tile-info">
                                <strong>微投票</strong>
                            </div>
                        </a>

                        <a href="/admin/baseService/customMenu.html" class="tile tile-themed">
                            <i class="icon-reorder"></i>
                            <div class="tile-info">
                                <strong>自定义菜单</strong>
                            </div>
                        </a>
                        <a href="/admin/baseService/keyWordReply.html" class="tile tile-themed">
                            <i class="icon-comments-alt "></i>
                            <div class="tile-info">
                                <strong>关键词回复</strong>
                            </div>
                        </a>
                         -->
                        
                        <!--
                        <a href="/admin/userCenter/sysapp.html" class="tile not tile-themed">
                            <i class="icon-magic"></i>
                            <div class="tile-info">
                                <strong>微服务</strong>
                            </div>
                        </a>
                        
                        <a href="/admin/weiqidt/dongtai.html" class="tile not tile-themed">
                            <i class="icon-tumblr-sign"></i>
                            <div class="tile-info">
                                <strong>微动态</strong>
                            </div>
                        </a>
                        
                        <a href="/admin/meirong/loupanjianjie.html" class="tile tile-themed">
                            <i class="icon-user-md"></i>
                            <div class="tile-info">
                                <strong>微美容</strong>
                            </div>
                        </a>
                        <a href="/admin/fangchan/loupanjianjie.html" class="tile not tile-themed">
                            <i class="icon-home"></i>
                            <div class="tile-info">
                                <strong>微房产</strong>
                            </div>
                        </a>
                        <a href="/admin/lvyou/loupanjianjie.html" class="tile not tile-themed">
                            <i class="icon-plane"></i>
                            <div class="tile-info">
                                <strong>微旅游</strong>
                            </div>
                        </a>

                        <a href="/admin/xitie/index.html" class="tile tile-themed">
                            <i class="icon-gift"></i>
                            <div class="tile-info">
                                <strong>微喜帖</strong>
                            </div>
                        </a>
                        <a href="/admin/weiqicy/canyinkeyword.html" class="tile not tile-themed">
                            <i class="icon-food"></i>
                            <div class="tile-info">
                                <strong>微餐饮</strong>
                            </div>
                        </a>
                        
                        <a href="/admin/car/keyword.html" class="tile tile-themed">
                            <i class="icon-truck"></i>
                            <div class="tile-info">
                                <strong>微汽车</strong>
                            </div>
                        </a>
                        <a href="/admin/shipin/loupanjianjie.html" class="tile not tile-themed">
                            <i class="icon-apple"></i>
                            <div class="tile-info">
                                <strong>微食品</strong>
                            </div>
                        </a>
                        <a href="/admin/jiudian/set.html" class="tile not tile-themed">
                            <i class="icon-columns"></i>
                            <div class="tile-info">
                                <strong>微酒店</strong>
                            </div>
                        </a>
                        <a href="/admin/jianshen/loupanjianjie.html" class="tile not tile-themed">
                            <i class="icon-smile"></i>
                            <div class="tile-info">
                                <strong>微健身</strong>
                            </div>
                        </a>
                        <a href="/admin/zhengwu/loupanjianjie.html" class="tile not tile-themed">
                            <i class="icon-umbrella"></i>
                            <div class="tile-info">
                                <strong>微政务</strong>
                            </div>
                        </a>
                        -->
                        
                    </div>
                    
                </div>
            </div>

        </div>
    </div>

    
</body>
</html>