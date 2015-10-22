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
                                <h3><i class="icon-edit"></i>添加用户</h3>
                            </div>
                            <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                        </div>

                        <div class="box-content">


                            <form id="dspuserform" action="dspuserAction!add" method="post" class="form-horizontal form-validate" novalidate="novalidate">
                                <div class="control-group">
                                    <label for="name" class="control-label">用户名 :</label>
                                    <div class="controls">
                                    	<s:textfield name="dspuser.username" id="username" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">初始密码 :</label>
                                    <div class="controls">
                                    	默认为123456
                                    	<s:hidden name="dspuser.password" value="123456"></s:hidden>
                                    	<s:hidden name="dspuser.ison" value="1"></s:hidden>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="mobile" class="control-label">手机号码：</label>
                                    <div class="controls">
                                    	<s:textfield name="dspuser.phone" id="phone" cssClass="input-large"></s:textfield>                                   
                                    	<span class="maroon">*</span><span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="qq" class="control-label">常用QQ号码：</label>
                                    <div class="controls">
                                     	<s:textfield name="dspuser.qq" id="qq" cssClass="input-large"></s:textfield>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label for="email" class="control-label">常用email：</label>
                                    <div class="controls">
                                    	<s:textfield name="dspuser.email" id="email" cssClass="input-large"></s:textfield>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="mobile" class="control-label">真实姓名：</label>
                                    <div class="controls">
                                    	<s:textfield name="dspuser.realname" id="realname" cssClass="input-large"></s:textfield>                                   
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="email" class="control-label">详细地址：</label>
                                    <div class="controls">
                                    	<s:textfield name="dspuser.address" id="address" cssClass="input-xlarge"></s:textfield>
                                    </div>
                                </div>
								<s:if test="#session.dspuser.limits==0">
									<div class="control-group">
	                                    <label for="email" class="control-label">用户权限：</label>
										<div class="controls">
											<s:select list="#{2:'普通用户',1:'高级用户',0:'管理员'}" name="dspuser.limits" id="limits"></s:select>
	                                    
	                                        <span class="maroon">*</span>
	                                        <span class="help-inline"></span>
	                                    </div>
	                                </div>
	                                <div class="control-group">
	                                    <label for="name" class="control-label">用户配额 :</label>
	                                    <div class="controls">
	                                    	<s:textfield name="dspuser.usernum" id="usernum" cssClass="input-medium" value="0"></s:textfield>
	                                    	<span class="maroon">*</span><span class="help-inline"></span>
										</div>
	                                </div>
	                                <div class="control-group">
	                                    <label for="name" class="control-label">公众号配额 :</label>
	                                    <div class="controls">
	                                    	<s:textfield name="dspuser.pubnum" id="pubnum" cssClass="input-medium" value="1"></s:textfield>
	                                    	<span class="maroon">*</span><span class="help-inline"></span>
										</div>
	                                </div>
								</s:if>
								<s:else>
									<!-- 高级用户创建的普通用户 -->
									<s:hidden name="dspuser.limits" value="2"></s:hidden>
									<s:hidden name="dspuser.usernum" value="0"></s:hidden>
									<s:hidden name="dspuser.pubnum" value="1"></s:hidden>
								</s:else>
								<s:hidden name="dspuser.upuser" value="%{#session.dspuser.id}"></s:hidden>
                                <div class="form-actions">
                                	<s:token></s:token>
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