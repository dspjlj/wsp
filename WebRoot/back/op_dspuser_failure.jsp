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
                                <h5><i class="icon-user"></i>&nbsp;${session.dspuser.username },o(╯□╰)o${failInfo }!&nbsp;<span id="jumpTo">5</span>秒后跳转到<a href="welcome.jsp">&nbsp;[主页]&nbsp;</a>页面</h5>
                                <script type="text/javascript">countDown(5,'welcome.jsp');</script>
                                <table class="table noborder">
                                    <tbody>
                                        <tr>
                                            <td>系统版本：wsp_v2.0</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
</body>
</html>