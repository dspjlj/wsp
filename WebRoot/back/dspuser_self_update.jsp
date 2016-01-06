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
                                <h3><i class="icon-edit"></i>请如实填写您的个人信息</h3>
                            </div>
                        </div>

                        <div class="box-content">


                            <form id="dspuserform" action="dspuserAction!updateself" method="post" class="form-horizontal form-validate" novalidate="novalidate">
                                <div class="control-group">
                                    <label for="name" class="control-label">用户名 :</label>
                                    <div class="controls">
                                        ${dspuser.username }                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="mobile" class="control-label">手机号码：</label>
                                    <div class="controls">
                                    <input type="text"   value="${dspuser.phone }" name="phone" id="usertelephone" class="input-medium"/>                                    <span class="maroon">*</span><span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="qq" class="control-label">常用QQ号码：</label>
                                    <div class="controls">
                                     <input type="text"   value="${dspuser.qq }" name="qq" id="userqq"  noneed="1" class="input-medium"/>                                     <span class="maroon">*</span>
                                    </div>
                                </div>
								  <div class="control-group">
                                    <label for="email" class="control-label">常用email：</label>
                                    <div class="controls">
                                    <input type="email"   value="${dspuser.email }" name="email" id="useremail" class="input-medium"/>                                    <span class="maroon">*</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="email" class="control-label">开户日期 :</label>
                                    <div class="controls">
                                        <b class="text-warning">${dspuser.regdate }</b><p></p>
                                    </div>
                                </div>
								<!-- 
								<div class="control-group">
                                    <label for="email" class="control-label">会员级别 :</label>
                                    <div class="controls">
                                        <b class="text-warning">普通用户</b>
                                        <p>到期时间 :          2015-02-12 00:00:00          </p>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label for="email" class="control-label">升级级别 :</label>
                                    <div class="controls">
                                        <b class="text-warning">行业版会员</b>
                                        <p>到期时间 :	                       [暂无]
	       </p>
                                    </div>
                                </div>
 -->
                                <div class="form-actions">
                                    <button type="submit" class="btn btn-primary">保存</button>
                                    <a class="btn" href="Javascript:document.getElementById('pubform').reset();">取消</a>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

<div id="fallr-overlay"></div>
<script type="text/javascript">
$(function(){
	$("#dspuserform").submit(function(){
		var cansv= true;
		$(this).find('input[type="text"]').each(function(){
			if($.trim($(this).val())=='' && $(this).attr('noneed')!='1'){
				cansv = false;
				$(this).css('backgroundColor','yellow');
				$(this).one('focus',function(){
					$(this).css('backgroundColor','transparent');
				});
			}
		});
		if(!cansv){
			tusi('请将信息填写完整');
			return false;
		}
	});
});
</script>

<br/><br/><br/></body>
</html>