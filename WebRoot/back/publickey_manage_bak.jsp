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
										<i class="icon-edit"></i>首页类别管理 ( 1 条记录 1/1 页 )
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
										<a href="wgw_bigtype_add.html" title="新增分类" class="btn"
											id="add_menu"> <i class="icon-plus"></i>新增分类 </a>
									</div>
									<div class="clr"></div>
								</div>
								<div class="msgWrap">
									<form method="post" action="#" id="info">
										<table class="table table-bordered table-hover dataTable">
											<thead>
												<tr>
													<th>
														分类名称
													</th>
													<th class="norightborder">
														操作
													</th>
												</tr>
											</thead>
											<tbody style="text-align: center;">
												<tr></tr>
												<tr>
													<td>
														分类1
													</td>
													<td class="norightborder">
														<a href="wgw_sontype_manage.html" class="btn">子分类</a>&nbsp;
														<a href="shop_cate_add.html" class="btn"><i
															class="icon-edit"></i> </a> &nbsp;
														<a href="#" onclick="return confirm('你确定要删除吗？');"
															class="btn"><i class="icon-remove"></i> </a>
													</td>
												</tr>
											</tbody>
										</table>
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