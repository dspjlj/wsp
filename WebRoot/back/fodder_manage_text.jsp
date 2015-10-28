<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" href="css/admin/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin/appmsg.css">
		<style>
body {
	padding-bottom: 20px;
}

.pagination {
	margin: 0 70px;
	float: right;
}

#first_col {
	display: inline-block;
	zoom: 1; *
	display: inline;
}

#second_col {
	margin-left: 15px;
	display: inline-block;
	zoom: 1; *
	display: inline;
}

.add-btn {
	height: 90px;
	margin: 0 18px;
	color: #b5b5b5;
	background: transparent url('media/images/qadmin/appmsg-icon.png')
		no-repeat 50% -242px;
}

.multi-access {
	background-position: 50% -342px;
}

ul {
	padding: 0;
	margin: 0;
}

li {
	list-style-type: none;
}

.sub-msg-item {
	padding: 12px 14px;
	overflow: hidden;
	zoom: 1;
	border-top: 1px solid #c6c6c6;
}

.thumb {
	float: right;
	font-size: 0;
}

.thumb .default-tip {
	font-size: 16px;
	color: #c0c0c0;
	width: 70px;
	line-height: 70px;
	border: 1px solid #b2b8bd;
}

.thumb img {
	width: 70px;
	height: 70px;
	border: 1px solid #b2b8bd;
}

.sub-msg-item .msg-t {
	margin-left: 0;
	margin-right: 85px;
	margin-top: 0;
	padding-left: 4px;
	padding-top: 12px;
	line-height: 24px;
	max-height: 48px;
	font-size: 14px;
	overflow: hidden;
}
</style>
		<title>图文素材管理页面</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<script>
//删除单图文素材
function deldsc(id,o){
	if(confirm('确定删除此素材信息吗？')){
		ajax('contresourceone-del.html',{ id:id},function(m){
			if(m=='ok'){
				$('#dsc_'+id).remove();
			}
		});
	}
}
function delddsc(id,o){
	if(confirm('确定删除此素材信息吗？')){
		ajax('contresourcemore-del.html',{ id:id},function(m){
			if(m=='ok'){
				$('#dsc_'+id).remove();
			}
		});
	}	
}

$(function() {
	$("#gotonext").click(function(){
		window.parent.$('#shouciguanzhu').trigger('click');
	});
	});



function delfodder(){
	if(confirm('您确认删除该素材吗？')){
		if(confirm('该素材将无法恢复，您确定？')){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}
</script>
	</head>

	<body>
		<img src="res/daduihao.png"
			style="display: none; position: absolute; z-index: 999999"
			id="ddhpng">
		<div class="container">
			
			<div class="containerBox" style="float: left;">
				<div id="gotonext">
					<img src="media/images/admin/v3/shouciguanzhu.png"></img>
				</div>
				<div class="boxHeader">
					<h4>
						素材管理
					</h4>

				</div>
				<div class="content">
					<h3 class="page-sub-hd">
						文本列表
					</h3>
					<div class="group page-nav">
						<div class="pagination">
							<button class="btn-large btn-primary"
								style="margin-top: -30px; visibility: hidden;" id="qdxzdbtn">
								确定选择
							</button>
						</div>
						<div class="clr"></div>
					</div>
					<div class="page-bd">
						<div class="tj msg-list">
							<!-- 偶数内容 -->
							<div id="first_col" class="b-dib vt msg-col">
								<div id="addAppmsg" class="tc add-access">
									<a href="fodder_add_text.jsp" class="dib vm add-btn">+文本消息</a>
								</div>
								
								
								<s:iterator value="fodders" var="fodder" status="index">
								<s:if test="#index.count%2==0">
										<!-- 偶数列文本 -->
										<div class="msg-item-wrapper">
											<div class="msg-item">
												<h4 class="msg-t">
													<a href="javascript:;" class="i-title"><s:property value="title" /></a>
												</h4>
												<p class="msg-meta">
													<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
												</p>
												
												<!-- 
												<p class="msg-text">
													点击进入微官网【演示版，请修改】
												</p>
												 -->
											</div>
											<div class="msg-opr">
												<ul class="f0 msg-opr-list">
													<li class="b-dib opr-item">
														<a data-mul="false" class="block tc opr-btn edit-btn"
															href="fodderAction!loadtext?id=<s:property value="id" />&page=<s:property value="page" />" data-rid="20330"><span
															class="th vm dib opr-icon edit-icon">编辑</span>
														</a>
													</li>
													<li class="b-dib opr-item">
														<a class="block tc opr-btn del-btn" href="fodderAction!deletetext?id=<s:property value="id" />&page=<s:property value="page" />"
															data-rid="20330" onclick="return delfodder();"><span
															class="th vm dib opr-icon del-icon">删除</span>
														</a>
													</li>
												</ul>
											</div>
										</div>
									
								
								</s:if>
								</s:iterator>
								
								
							</div>
							<!-- 奇数内容 -->
							<div id="second_col" class="b-dib vt msg-col">
								<s:if test="%{fodders.size()==0}">
									<div id="addAppmsg" class="tc add-access">
										暂无素材
									</div>
								</s:if>
								
								<s:iterator value="fodders" var="fodder" status="index">
								<s:if test="#index.count%2==1">
										<!-- 奇数列单图文 -->
										<div class="msg-item-wrapper">
											<div class="msg-item">
												<h4 class="msg-t">
													<a href="javascript:;" class="i-title"><s:property value="title" /></a>
												</h4>
												<p class="msg-meta">
													<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
												</p>
												
												<!-- 
												<p class="msg-text">
													点击进入微官网【演示版，请修改】
												</p>
												 -->
											</div>
											<div class="msg-opr">
												<ul class="f0 msg-opr-list">
													<li class="b-dib opr-item">
														<a data-mul="false" class="block tc opr-btn edit-btn"
															href="fodderAction!loadtext?id=<s:property value="id" />&page=<s:property value="page" />" data-rid="20330"><span
															class="th vm dib opr-icon edit-icon">编辑</span>
														</a>
													</li>
													<li class="b-dib opr-item">
														<a class="block tc opr-btn del-btn" href="fodderAction!deletetext?id=<s:property value="id" />&page=<s:property value="page" />"
															data-rid="20330" onclick="return delfodder();"><span
															class="th vm dib opr-icon del-icon">删除</span>
														</a>
													</li>
												</ul>
											</div>
										</div>
								
								</s:if>
								</s:iterator>

								
								
								
								
							</div>
						</div>

					</div>



				</div>
				 
			
			

				<div class="clr">
				</div>
			</div>

			<div class="sideBar" style="float: left;width: 86px;height: 78px;margin-top: 20px;">
			   	<div class="menu">
			   		<ul class="nav nav-list">
			   		  <li class="active"><a href="fodderAction!textlist" target="mainFrame">文本</a></li>
			   		  <li><a href="fodderAction!imagelist" target="mainFrame">图片</a></li>
			   		  <li><a href="fodderAction!voicelist" target="mainFrame">语音</a></li>
					  <li><a href="fodderAction!videolist" target="mainFrame">视频</a></li>
					  <li><a href="fodderAction!musiclist" target="mainFrame">音乐</a></li>
					  <li><a href="fodderAction!list" target="mainFrame">图文消息</a></li>
					</ul>
			   	</div>
			</div>
		</div>



		<br />
		<br />
		<br />
	</body>
</html>