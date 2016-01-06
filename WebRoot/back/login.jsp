<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>back/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="第三屏、微信营销、微信代运营、微信托管、微网站、微商城、微营销、微信定制开发">
<meta name="description" content="第三屏,国内免费的微信公众智能服务平台,主流微体系:微菜单、微官网、微相册、微会员、微活动、微商城、微团购、微客服,企业微营销必备。">
<title>登录-第三屏管理平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="static/login.css" rel="stylesheet">
<link rel="alternate stylesheet" type="text/css" media="screen" title="green-theme" href="static/green.css">
<link rel="alternate stylesheet" type="text/css" media="screen" title="blue-theme" href="static/blue.css">
<link rel="alternate stylesheet" type="text/css" media="screen" title="orange-theme" href="static/orange.css">

<style type="text/css">
html, body

        {

/*此部分支持chrome，应该也支持firefox*/

            background: rgb(246,248,249);

            background: url('') no-repeat center fixed #333;

            background-attachment: fixed;

            background-size: 100% 100%;

}	

</style>
</head>
<body onload="loadthis()">
<div id="wrapper" >
	<form action="dspuserAction!login" class="form-login" method="post" onsubmit="return checkIsUp()">
		<div class="header">
			<a href="http://www.di3p.com" class="link-head-left" target="_blank"> <i class="icon-home"></i>
			</a>
			<span>登陆</span>
			<a href="javascript:void(0);" tabindex="1" class="link-head-right main-item"> <i class="icon-config"></i>
			</a>

			<div class="config-box">
				<div class="colors">
					<a href="javascript:chooseStyle('blue-theme', 30)">
						<img src="static/blue.png" ></a>
					<a href="javascript:chooseStyle('orange-theme', 30)">
						<img src="static/orange.png" ></a>
					<a href="javascript:chooseStyle('green-theme', 30)">
						<img src="static/green.png" ></a>
					<a href="javascript:chooseStyle('none', 30)">
						<img src="static/red.png" ></a>
					<div class="clear"></div>
				</div>
				<div class="style-bg">
					<a href="login.html" class="active">黑色</a>
				</div>
			</div>
		</div>
		<div class="avatar">
			<img src="static/avatar.png" ></div>
		<div class="inputs">
			<input type="text" name="username" id="username" tabindex="1" type="text" placeholder="用户名" autocomplete="off" onFocus="this.value=''"/>

			<input type="password"  name="password" id="password" tabindex="2" type="password" placeholder="请输入您的密码" autocomplete="off" onFocus="this.select()"/>
			<div class="link-1">

				<label for="c2">
					<input type="checkbox" checked="checked" name="checkup" id="checkup"/>
					<!--<span></span>
				--> 记住我&nbsp;&nbsp;&nbsp;&nbsp;<font color="#ba3c30">${loginFail }</font>
			</label>

		</div>

		<div class="link-2">
<!-- 
			<a href="findpwd.html">忘记密码</a>
 -->
		</div>

		<div class="clear"></div>

		<div class="button-login">

			<input type="submit" id="btn-login" value="登 陆"></div>

	</div>

	<div class="footer-login">

		<!--<ul class="social-links">

		<li class="twitter">
			<a href="#">
				<span>twitter</span>
			</a>
		</li>

		<li class="google-plus">
			<a href="#">
				<span>google</span>
			</a>
		</li>

		<li class="facebook">
			<a href="#">
				<span>facebook</span>
			</a>
		</li>

	</ul>
	-->
</div>

</form>

<div class="clear"></div>

<div class="link-to-page">
<!-- 
还没有账号?
<a href="reg.html">立即注册!</a>
 -->
</div>

</div>

<!-- Placed at the end of the document so the pages load faster -->

<script type="text/javascript">
 
 //设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//清除cookie  
function clearCookie(name) {  
    setCookie(name, "", -1);  
    
}  
function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}
//checkCookie(); 


function loadthis(){
	var checkup = getCookie("checkup");
	if(checkup=='on'){
		document.getElementById("username").value=getCookie("username");
		document.getElementById("password").value=getCookie("password");
		document.getElementById("checkup").checked=true;
	}else{
		document.getElementById("username").value="";
		document.getElementById("password").value="";
		document.getElementById("checkup").checked=false;
	}
}

function checkIsUp(){
	 if(document.getElementById("checkup").checked==true){
	 	console.log("checked");
		setCookie('username', document.getElementById("username").value, 365);	 
		setCookie('password', document.getElementById("password").value, 365);	 
		setCookie('checkup', document.getElementById("checkup").value, 365);	 
	 }else{
	 	console.log("unchecked");
	 	clearCookie("username");
		clearCookie("password");
		clearCookie("checkup");
	 }
	 return true;
 }
 </script>
</body>
</html>