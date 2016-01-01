<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css" href="css/wm/album.css" media="all" />
<title>第三屏—国内免费的微信公众服务平台</title>
<script type="text/javascript">var yyuc_jspath = "";</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue">
    <div id="main">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span12">
                                <h3><i class="icon-cog"></i>微官网--菜单导航设置</h3>
                            </div>
                        </div>
                        <div class="box-content">
                            <form action="wgwmenuAction!add" method="post" class="form-horizontal form-validate">
                            
                            	<s:hidden name="wgwmenu.wgw.id" value="%{wgw.id}"></s:hidden>
                            	
                                <div class="control-group">
                                    <label class="control-label" for="keyword">菜单1:</label>
                                    <div class="controls">
										<s:textfield name="wgwmenu.menu1" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">菜单1地址：</label>
                                    <div class="controls">
		 							 	<s:textfield name="wgwmenu.menu1url" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label" for="keyword">菜单2:</label>
                                    <div class="controls">
	                                    <s:textfield name="wgwmenu.menu2" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">菜单2地址：</label>
                                    <div class="controls">
		 							 	<s:textfield name="wgwmenu.menu2url" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="keyword">菜单3:</label>
                                    <div class="controls">
                                    	<s:textfield name="wgwmenu.menu3" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">菜单3地址：</label>
                                    <div class="controls">
		 							 	<s:textfield name="wgwmenu.menu3url" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="keyword">菜单4:</label>
                                    <div class="controls">
                                    	<s:textfield name="wgwmenu.menu4" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">菜单4地址：</label>
                                    <div class="controls">
		 							 	<s:textfield name="wgwmenu.menu4url" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                    </div>
                                </div>
                                 
                                <div class="form-actions">
                                	<s:token></s:token>
                                    <button id="bsubmit" type="submit" data-loading-text="提交中..." class="btn btn-primary">保存</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<script type="text/javascript" src="js/comm.js"></script>