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
<script type="text/javascript">
function logout(){
	if(confirm("你确定退出管理系统吗？")){
		parent.location.href = "login.jsp";
	}
	
	
}

</script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> &nbsp;第三屏微信公众服务平台 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>对不起，由于您长时间不操作，会话已失效，请重新登录！&nbsp;&nbsp;<a href="javascript:void(0)" onClick="logout()">点击登录</a></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">感谢您的使用：</td>
    <td width="75%" bgcolor="#FFFFFF">
		尊敬的客户
	</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>系统版本信息：</td>
    <td>wsp_v2.0</td>
  </tr>
</table>
</body>
</html>