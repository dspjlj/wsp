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
                                <h3><i class="icon-edit"></i>添加公众账号</h3>
                            </div>
                            <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                        </div>

                        <div class="box-content">


                            <form id="pubclientform" action="pubclientAction!add" method="post" class="form-horizontal form-validate" novalidate="novalidate" enctype="multipart/form-data">
                                <div class="control-group">
                                    <label for="name" class="control-label">公众号名称 :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.publicname" id="publicname" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">公众号微信号 :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.publicno" id="publicno" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">原始ID :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.publicaccount" id="publicaccount" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
	                                    <label for="email" class="control-label">公众号类型：</label>
										<div class="controls">
											<s:select list="#{0:'未认证订阅号',1:'已认证订阅号',2:'未认证服务号',3:'已认证服务号'}" name="pubclient.accounttype" id="accounttype"></s:select>
	                                    
	                                        <span class="maroon">*</span>
	                                        <span class="help-inline"></span>
	                                    </div>
	                            </div>
	                            <div class="control-group">
                                    <label for="name" class="control-label">AppID(应用ID) :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.appid" id="appid" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">AppSecret(应用密钥) :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.appsecret" id="appsecret" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
	                                    <label for="email" class="control-label">会员套餐类型：</label>
										<div class="controls">
											<s:select list="#{1:'基础版会员',2:'升级版会员'}" name="pubclient.protype" id="protype"></s:select>
	                                    
	                                        <span class="maroon">*</span>
	                                        <span class="help-inline"></span>
	                                    </div>
	                            </div>
                                <div class="control-group">
                                    <label for="name" class="control-label">座机号码 :</label>
                                    <div class="controls">
                                    	<s:textfield name="pubclient.comtel" id="comtel" cssClass="input-large"></s:textfield>
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label for="email" class="control-label">二维码：</label>
                                    <div class="controls">
                                    	<s:file name="picture" onchange="changePreImg();" id="myfile"></s:file><br/>
                                    	<img alt="暂无图片" src="images/noimg.jpg" id="myimage" width="100" height="100" />
                                    </div>
                                </div>
								
                                <div class="form-actions">
                                	<s:token></s:token>
                                    <button type="submit" class="btn btn-primary">保存</button>
                                    <a class="btn" href="Javascript:document.getElementById('pubclientform').reset();">取消</a>

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
<script type="text/javascript">
/*
$(function(){
	$("#pubclientform").submit(function(){
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
*/
</script>
<script type="text/javascript" src="js/toolKit.js"></script>
</body>
</html>