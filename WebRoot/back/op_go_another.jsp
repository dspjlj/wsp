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
    <script type="text/javascript">     
		function countDown(secs,surl){     
		 //alert(surl);     
		 surl = surl.replace("&amp;","&");
		 var jumpTo = document.getElementById('jumpTo');
		 jumpTo.innerHTML=secs;  
		 if(--secs>0){
		     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
		     }
		 else{       
		     location.href=surl;     
		     }     
		 }     
	</script>
</head>
<body class="theme-lightgrey">
    <div id="main">
        <div class="row-fluid">
            <div class="span12">
                <div class="box ">
                    <div class="box-title">
                        <h3> <i class="icon-cog"></i>
                            操作提示信息
                        </h3>
                    </div>
                    <div class="box-content">

                        <dl class="dl-horizontal">
                            <dd style="margin-left: 20px;">
                                <h5><i class="icon-user"></i>&nbsp;${session.dspuser.username },O(∩_∩)O${goInfo }!&nbsp;<span id="jumpTo">5</span>秒后跳转到<a href="<s:property value="arg[0]"/>">&nbsp;[<s:property value="arg[1]"/>]&nbsp;</a>页面</h5>
                                <script type="text/javascript">countDown(5,'<s:property value="arg[0]"/>');</script>
                                <table class="table noborder">
                                    <tbody>
                                        <tr>
											<td>公众号名称：${session.pubclient.publicname }</td>
                                            <td>公众号微信号：${session.pubclient.publicno }</td>
                                            <td>开户时间：${session.pubclient.createdate }</td>
                                            <td>到期时间：${session.pubclient.deaddate }</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>文本自定义: 不限</td>
                                            <td>图文自定义 : 不限</td>
                                            <td>语音自定义：不限</td>
                                            <td>每月可请求数：不限</td>
                                        </tr>
                                        <tr>
                                            <td>系统版本：wsp_v2.0</td>
                                            <td colspan="3"></td>
                                        </tr>
                                    </tbody>
                                </table>
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
                        快捷操作 
                    </h3>
                </div>
                <div class="box-content">
                    <div class="block block-tiles block-tiles-animated clearfix">
                        <a href="wgwAction!view" target="mainFrame" class="tile tile-themed">
                            <i class="icon-globe "></i>
                            <div class="tile-info">
                                <strong>微官网</strong>
                            </div>
                        </a>
                        
                    </div>
                    
                </div>
            </div>

        </div>
    </div>

    
</body>
</html>