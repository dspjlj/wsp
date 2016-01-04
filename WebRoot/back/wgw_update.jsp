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
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-status-bar-style"
			content="black-translucent" />
		<base target="mainFrame" />
		<link rel="stylesheet" type="text/css" href="css/wm/index.css"
			media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css"
			media="all" />
		<link rel="stylesheet" type="text/css"
			href="css/wm/bootstrap_responsive_min.css" media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/style.css"
			media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/themes.css"
			media="all" />
		<link rel="stylesheet" type="text/css"
			href="css/wm/todc_bootstrap.css" media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/inside.css"
			media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/album.css"
			media="all" />
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
									<h3>
										<i class="icon-cog"></i>微官网--设置修改
									</h3>
								</div>
							</div>
							<div class="box-content">
								<form action="wgwAction!update" method="post"
									class="form-horizontal form-validate">
									
									<s:hidden name="wgw.id"></s:hidden>
									<s:hidden name="wgw.template1"></s:hidden>
									<s:hidden name="wgw.template2"></s:hidden>
									<s:hidden name="wgw.template3"></s:hidden>
									<s:hidden name="wgw.template4"></s:hidden>
									<s:hidden name="wgw.publicaccount"></s:hidden>
									<s:hidden name="wgw.linkurl"></s:hidden>
									
									
									<div class="control-group">
										<label class="control-label" for="title">
											标题：
										</label>
										<div class="controls">
											<s:textfield name="wgw.title" id="title" cssClass="input-xlarge"></s:textfield>
											<span class="maroon">*</span>
										</div>
									</div>



									
									<div class="control-group">
										<label class="control-label" for="brief">
											备注
										</label>
										<div class="controls">
											<s:textarea name="wgw.info" id="info" cssClass="input-large"
												cssStyle="height: 80px; width: 380px;"></s:textarea>
											<span class="help-block">150文字以内</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="brief">
											链接地址
										</label>
										<div class="controls">
											<%=basePath %><s:property value="wgw.linkurl"/>
										</div>
									</div>
									<div class="form-actions">
										<s:token></s:token>
										<button id="bsubmit" type="submit" data-loading-text="提交中..."
											class="btn btn-primary">
											保存
										</button>
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
