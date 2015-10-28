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
		<link rel="stylesheet" type="text/css" href="css/wm/uploadify_t.css"
			media="all" />
		<title>第三屏—国内免费的微信公众服务平台</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<script
			src="http://api.map.baidu.com/api?v=1.5&ak=1b0ace7dde0245f796844a06fb112734"></script>
	</head>
	<body class="theme-blue">
		<div id="main">

			<div class="container-fluid">

				<div class="row-fluid">
					<div class="span12">

						<div class="box">
							<div class="box-title">
								<div class="span8">
									<h3>
										<i class="icon-table"></i>关键字（自定义文本）回复管理
									</h3>
								</div>
								<div class="span4">
									<!-- <div class="form-horizontal">
                                    <input type="text" id="keyword-input" class="input-small-z" placeholder="请输入关键词">
                                    <select name="type" class="input-small" id="select_type">
                                        <option selected="selected" value="0">全部</option>
                                        <option value="1">完全匹配</option>
                                        <option value="2">包含匹配</option>
                                    </select>
                                    <button class="btn" id="btn_search">查询</button>
									<input type="hidden" name="aid" id ="aid" value="42538">

                                </div> -->
								</div>
							</div>

							<div class="box-content nozypadding">
								<div class="row-fluid">
									<div class="span8 control-group">
										<div class="span3">
											<a class="btn" href="material_keyword_add.html"><i
												class="icon-plus"></i>添加</a>
											<a class="btn" href="javascript:location.reload();"><i
												class="icon-refresh"></i>
											</a>
											<a class="btn" id="del" attr="BatchDel" title="删除"><i
												class="icon-trash"></i>
											</a>
										</div>

										<div class="span9 datatabletool">

											<div class="btn-group">
												<a class="btn" style="display: none;" title="批量导入文本"><i
													class="icon-upload-alt"></i>
												</a>
												<a class="btn" style="display: none;" title="批量导出本页文本结果"><i
													class="icon-download-alt"></i>
												</a>
												<a class="btn" attr="BatchDel" style="display: none;"
													title="删除"><i class="icon-trash"></i>
												</a>
											</div>

										</div>

									</div>


								</div>

								<div class="row-fluid dataTables_wrapper">
									<table id="listTable"
										class="table table-hover table-nomargin table-bordered usertable dataTable">
										<thead>
											<tr>
												<th class='with-checkbox'>
													<input type="checkbox" class="check_all"
														onclick="selallck(this);">
												</th>
												<th>
													关键词
												</th>
												<th>
													回复素材
												</th>
												<th>
													匹配类型
												</th>
												<th>
													操作
												</th>
											</tr>

										</thead>
										<tbody>
											<s:if test="%{keyress.size()==0}">
													<tr>
														<td colspan="5" style="text-align: center;">
															暂无信息
														</td>
													</tr>
											</s:if>
											<s:iterator value="keyress" var="keyres" status="index">
												
												<tr>
													<td class="with-checkbox">
														<input type="checkbox" name="keyresids"
															value="<s:property value="id"/>">
													</td>
													<td>
														<s:property value="keytitle" />
													</td>
													<td width="350">
														<s:property value="fodderid" />
													</td>
													<td>
														<span class="label label-satgreen"><s:if test="1">模糊</s:if>
															<s:else>全匹配</s:else>
														</span>
													</td>
													<td class='hidden-480'>
														<a
															href="keyresAction!load?id=<s:property value="id"/>&pkid=<s:property value="pkid"/>"
															class="btn" rel="tooltip" title="Edit"><i
															class="icon-edit"></i>
														</a>
														<a href="javascript:void(0);" class="btn" rel="tooltip"
															title="Delete" attr="deltext_42538_55181"
															onclick="if(confirm('确定要删除吗？')){ goto('keyresAction!delete?id=<s:property value="id"/>&pkid=<s:property value="pkid"/>&page=<s:property value="page"/>');}"><i
															class="icon-remove"></i>
														</a>
													</td>
												</tr>
											</s:iterator>
										</tbody>

									</table>
									<div class="pagination" style="text-align: center;">
										  <ul>
										
										    <li style="float: left;"><a href="keyresAction!list?pkid=<s:property value="pkid"/>&page=1" target="mainFrame"><span>首&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="keyresAction!list?pkid=<s:property value="pkid"/>&page=<s:property value="page-1"/>" target="mainFrame"><span>上&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="keyresAction!list?pkid=<s:property value="pkid"/>&page=<s:property value="page+1"/>" target="mainFrame"><span>下&nbsp;&nbsp;页</span></a></li>
										    <li style="float: left;"><a href="keyresAction!list?pkid=<s:property value="pkid"/>&page=<s:property value="pageCount"/>" target="mainFrame"><span>尾&nbsp;&nbsp;页</span></a></li>
										  </ul>
										  
									</div>
<!-- 
									<div class="dataTables_paginate paging_full_numbers">
										<span> 
											<a class="paginate_active">1</a> 
											<a class="paginate_active">2</a>3
										</span>
									</div>
 -->
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/comm.js"></script>
		<script>
	//批量删除关键字 
	 $("#del").click(function() {
		 var checkeds = $("table tbody input[type='checkbox']:checked");
		 if(checkeds.length) {
			 if(confirm("您确定要删除所选的关键词(将同时删除回复)?")) {
				 $(this).attr("disabled", true);
				 var idsArray = [];
				 checkeds.each(function() {
					idsArray.push($(this).val());
				 });
				 if (idsArray.length > 0) {
					 var qids = idsArray.join(','); 
					 $.get("keyword.html", { type:'dels', ids:qids}, function (data){
						 if(data == 1){
							 tusi('删除成功！');
						 }else{
							 tusi('操作异常！');
						 }
						 location.reload(true);
					 },'text');
				 }
			 }
		 } else {
			 alert("请先选中需要删除的关键词");
		 }
	 });
	</script>
	</body>
</html>