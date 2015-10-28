<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base target="mainFrame" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>第三屏—国内免费的微信公众服务平台</title>
		<link href="weiqiwx/tpl/User/default/common/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="weiqiwx/tpl/User/default/common/css/stylet.css"
			rel="stylesheet" type="text/css" />

		<link rel="stylesheet" type="text/css"
			href="css/wm/bootstrap_min.css?dddf" media="all" />
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
		<link rel="stylesheet" type="text/css"
			href="weiqiwx/tpl/User/default/common/css/cymain.css" />
			<link rel="stylesheet" type="text/css" href="css/wm/index.css"
				media="all" />
			
	</head>


	<body class="{Session::get('maintheme')}">
		<div id="main">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-title">
								<div class="span10">
									<h3>
										<i class="icon-edit"></i>关键字回复分组管理 ( <s:property value="totalCount"/> 条记录 <s:property value="page"/>/<s:property value="pageCount"/> 页 )
									</h3>
								</div>
								<div class="span2">
									<a class="btn" href="javascript:history.go(-1);">返回</a>
								</div>
							</div>
							<div class="box-content">
								<!--tab end-->
								<div class="cLine">
									<div class="pageNavigator left">
										<a href="publickey_add.jsp" title="新增分组" class="btn"
											id="add_menu"> <i class="icon-plus"></i>新增分组 </a>
									</div>
									<div class="clr"></div>
								</div>
								<div class="msgWrap">
									<form method="post" action="#" id="info">
										<table class="table table-bordered table-hover dataTable">
											<thead>
												<tr>
													<th>
														分组名称
													</th>
													<th class="norightborder">
														操作
													</th>
												</tr>
											</thead>
											<tbody style="text-align: center;">
												<s:if test="%{publickeys.size()==0}">
													<tr>
														<td colspan="2" style="text-align: center;">暂无信息</td>
													</tr>
												</s:if>
												<s:iterator value="publickeys" var="publickey" status="index">
												<tr>
													<td>
														<s:property value="title"/>
													</td>
													<td class="norightborder">
														<a href="keyresAction!list?pkid=<s:property value="id"/>" class="btn">关键字管理</a>&nbsp;
														<a href="publickeyAction!load?id=<s:property value="id"/>" class="btn"><i
															class="icon-edit"></i> </a> &nbsp;
														<a href="publickeyAction!delete?id=<s:property value="id"/>&page=<s:property value="page"/>" onclick="return confirm('你确定要删除吗？');"
															class="btn"><i class="icon-remove"></i> </a>
													</td>
												</tr>
												</s:iterator>
											</tbody>
										</table>
										<div class="pagination" style="text-align: center;">
										  <ul>
										
										    <li style="float: left;"><a href="publickeyAction!list?page=1" target="mainFrame"><span>首&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="publickeyAction!list?page=<s:property value="page-1"/>" target="mainFrame"><span>上&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="publickeyAction!list?page=<s:property value="page+1"/>" target="mainFrame"><span>下&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="publickeyAction!list?page=<s:property value="pageCount"/>" target="mainFrame"><span>尾&nbsp;&nbsp;页</span></a></li>
										  </ul>
										  
										</div>
									</form>
								</div>
								<div class="cLine">
									<div class="pageNavigator"></div>
									<div class="clr"></div>
								</div>
							</div>
							<div style="clear: both;"></div>
						</div>
						<!--end Frame-->
	</body>
</html>