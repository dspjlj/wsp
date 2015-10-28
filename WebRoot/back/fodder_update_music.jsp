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
                                <h3><i class="icon-edit"></i>添加音乐</h3>
                            </div>
                            <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                        </div>

                        <div class="box-content">


                            <form id="foddermusicform" action="fodderAction!updatemusic" method="post" class="form-horizontal form-validate" novalidate="novalidate" enctype="multipart/form-data">
                                <s:hidden name="fodder.id"></s:hidden>
                                <s:hidden name="fodder.msgtype"></s:hidden>
                                <s:hidden name="fodder.savetype"></s:hidden>
                                <s:hidden name="fodder.publicaccount"></s:hidden>
                                <s:hidden name="fodder.createdate"></s:hidden>
                                
                                <div class="control-group">
                                    <label for="name" class="control-label">标题 :</label>
                                    <div class="controls">
                                    	<s:textfield name="fodder.title" id="publicname" cssClass="input-xlarge"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">音乐链接 :</label>
                                    <div class="controls">
                                    	<s:textfield name="fodder.musicurl" id="publicno" cssClass="input-xxlarge"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">高品质音乐链接 :</label>
                                    <div class="controls">
                                    	<s:textfield name="fodder.hqmusicurl" id="publicaccount" cssClass="input-xxlarge"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                
                                <div class="control-group">
                                    <label for="name" class="control-label">音乐描述 :</label>
                                    <div class="controls">
                                    	<s:textarea name="fodder.description" id="comtel" cssStyle="width:288px;height:160px;"></s:textarea>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                
								
                                <div class="form-actions">
                                	<s:token></s:token>
                                    <button type="submit" class="btn btn-primary">保存</button>
                                    <a class="btn" href="Javascript:document.getElementById('foddermusicform').reset();">取消</a>

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