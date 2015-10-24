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
<script type="text/javascript">var yyuc_jspath = "";</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue" data-theme="theme-blue">
	
    <div id="main">
        <div class="container-fluid">

            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span10">
                                <h3><i class="icon-edit"></i>绑定公众账号</h3>
                            </div>
                            <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                        </div>

                        <div class="box-content">


                            <form id="pubclientform" action="#" method="post" class="form-horizontal form-validate" novalidate="novalidate">
                                <div class="control-group">
                                    <label for="name" class="control-label">公众号名称 :</label>
                                    <div class="controls">
                                    	<s:property value="pubclient.publicname"/>
                                    	<a href="public_bangding.html"><strong>[手动绑定]</strong></a>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">URL(服务器地址) :</label>
                                    <div class="controls">
                                    	<s:property value="pubclient.url"/>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">Token(令牌) :</label>
                                    <div class="controls">
                                    	<s:property value="pubclient.token"/>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">EncodingAESKey<br/>(消息加解密密钥) :</label>
                                    <div class="controls">
                                    	<s:property value="pubclient.encodingaeskey"/>
									</div>
                                </div>
								
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

<div id="fallr-overlay"></div>
<br/><br/><br/>
</body>
</html>