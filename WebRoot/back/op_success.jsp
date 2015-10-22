<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>第三屏—国内免费的微信公众服务平台</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
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
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;第三屏微信公众服务平台 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>恭喜您，操作成功！&nbsp;<span id="jumpTo">5</span>秒后跳转到<a href="<s:property value="arg[0]"/>"><s:property value="arg[1]"/></a>页面&nbsp;</td>
  	<script type="text/javascript">countDown(5,'<s:property value="arg[0]"/>');</script>
  </tr>
</table>

<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">感谢您的使用：</td>
    <td width="75%" bgcolor="#FFFFFF">
		${pubclient.username }
	</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>系统版本信息：</td>
    <td>wsp_v2.0</td>
  </tr>
</table>
</body>
</html>