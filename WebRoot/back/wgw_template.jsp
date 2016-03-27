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
<html><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
		<base target="mainFrame">
		<link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/official.css" media="all">
		<link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all">
		<title>第三屏—国内免费的微信公众服务平台</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<link rel="shortcut icon" href="/favicon.ico">
		<script type="text/javascript">
			function initcheck(){
				var template1value = <s:property value="wgw.template1"/>;
				var template2value = <s:property value="wgw.template2"/>;
				var template3value = <s:property value="wgw.template3"/>;
				var template4value = <s:property value="wgw.template4"/>;
				var template1 = document.getElementsByName("template1"); 
				for(var i=0;i<template1.length;i++){ 
					if(template1[i].value==template1value) { 
						template1[i].checked = true;
					} 
				} 
				var template2 = document.getElementsByName("template2"); 
				for(var i=0;i<template2.length;i++){ 
					if(template2[i].value==template2value) { 
						template2[i].checked = true;
					} 
				} 
				var template3 = document.getElementsByName("template3"); 
				for(var i=0;i<template3.length;i++){ 
					if(template3[i].value==template3value) { 
						template3[i].checked = true;
					} 
				} 
				var template4 = document.getElementsByName("template4"); 
				for(var i=0;i<template4.length;i++){ 
					if(template4[i].value==template4value) { 
						template4[i].checked = true;
					} 
				} 
			}
		</script>
	</head>
	<body class="theme-blue" style="overflow: hidden;" onload="initcheck();">
		<div id="main">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-title">
								<div class="span12">
									<h3>
										<i class="icon-edit"></i>模板管理
									</h3>
								</div>
							</div>
							<form action="wgwAction!updatetemplate" method="post">
							<div class="box-content" style="overflow: auto; height: 865px;">
								<ul class="nav nav-tabs" id="liclickli">
									<li class="active">
										<a href="javascript:;" did="#relli0" data-toggle="tab">首页风格</a>
									</li>
									<li>
										<a href="javascript:;" did="#relli1" data-toggle="tab">分类频道风格</a>
									</li>
									<li>
										<a href="javascript:;" did="#relli2" data-toggle="tab">图文列表风格</a>
									</li>
									<li>
										<a href="javascript:;" did="#relli3" data-toggle="tab">文章详细风格</a>
									</li>
									<li>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<button id="bsubmit" type="submit" class="btn btn-primary">
											保存
										</button>
										
									</li>
								</ul>
								
								<div class="tab-content">
									<div class="tab-pane active in" id="relli0">
										<ul class="nav nav-tabs nav-tabs-google" style="border-bottom: none"></ul>
										<ul class="cateradio unstyled">
										<li class="phoneareali"><label><img src="res/mbpic/1_index.png"><input type="radio" name="template1" value="1">模板1</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/2_index.png"><input type="radio" name="template1" value="2">模板2</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/3_index.png"><input type="radio" name="template1" value="3">模板3</label></li>
										</ul>
									</div>
									<div class="tab-pane" id="relli1">
										<ul class="nav nav-tabs nav-tabs-google" style="border-bottom: none"></ul>
										<ul class="cateradio unstyled">
										<li class="phoneareali"><label><img src="res/mbpic/1_type.png"><input type="radio" name="template2" value="1">模板1</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/2_type.png"><input type="radio" name="template2" value="2">模板2</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/3_type.png"><input type="radio" name="template2" value="3">模板3</label></li>
										
										</ul>
									</div>
									<div class="tab-pane" id="relli2">
										<ul class="nav nav-tabs nav-tabs-google" style="border-bottom: none"></ul>
										<ul class="cateradio unstyled">
										<li class="phoneareali"><label><img src="res/mbpic/1_list.png"><input type="radio" name="template3" value="1">模板1</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/2_list.png"><input type="radio" name="template3" value="2">模板2</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/3_list.png"><input type="radio" name="template3" value="3">模板3</label></li>
										
										</ul>
									</div>
									<div class="tab-pane" id="relli3">
										<ul class="nav nav-tabs nav-tabs-google" style="border-bottom: none"></ul>
										<ul class="cateradio unstyled">
										<li class="phoneareali"><label><img src="res/mbpic/1_article.png"><input type="radio" name="template4" value="1">模板1</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/2_article.png"><input type="radio" name="template4" value="2">模板2</label></li>
										<li class="phoneareali"><label><img src="res/mbpic/3_article.png"><input type="radio" name="template4" value="3">模板3</label></li>
										
										</ul>
									</div>
									<!-- 
								<div class="tab-pane" id="relli0">
									
								</div>
								 -->
								</div>
								
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
$(function(){
	$('.box-content').height($(window).height()-90);
	
	$('#liclickli').children('li').click(function(){
		var divid = $(this).find('a').attr('did');
		$('.tab-pane').hide();
		$(divid).fadeIn();
		$('#liclickli').children('li').removeClass('active');
		$(this).addClass('active');
	});
	
	
	$('.phoneareali').click(function(){
		$('.phoneareali').removeClass('active');
		$(this).addClass('active');
	});
	
	
});
function setthisone(){
	var rad = $('input[type="radio"]:checked');
	if(rad.size<=0){
		return;
	}
	var tdind = rad.val();
	var commonhtm = $('#mainxztr').children('td').eq(parseInt(tdind)).find('.ppdiv').html();
	if(parent.endmbxz){
		parent.endmbxz(commonhtm);
	}	
}
function closethisone(){
	if(parent.endmbxz){
		parent.endmbxz('0');
	}	
}
</script>
		<br>
		<br>
		<br>


		
	
</body></html>