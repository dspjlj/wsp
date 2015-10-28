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
		<script type="text/javascript">


$(function() {
	$("#gotonext").click(function(){
		window.parent.$('#shouciguanzhu').trigger('click');
	});
		$('.msg-item').click(function(){
		$('.msg-item').unmask();
		var o = this;
		window.selitemid = $(o).attr('itemid'); 
		setTimeout(function(){
			$(o).mask();
			$('#qdxzdbtn').show().css('visibility','visible');
			$('#ddhpng').css('left',($(o).offset().left+$(o).width()/2-37)+'px');
			$('#ddhpng').css('top',($(o).offset().top+$(o).height()/2-30)+'px').show();
		},288);
	});
	$('.msg-item').dblclick(function(){
		parent.setselid(window.selitemid);
		parent.yyucpopclose();
	});
	$('#qdxzdbtn').click(function(){
		console.log("id="+window.selitemid);
		//parent.setselid(window.selitemid);
		//parent.yyucpopclose();
		window.parent.location.href = "fodderAction!refreshSessionAs?fodderid="+window.selitemid;
		window.parent.location.target ="mainFrame";
		
	});
	});



function player(isplay,id){
		if(isplay=="play"){
			document.getElementById('bgaudio'+id).play();
			document.getElementById('myimg'+id).innerHTML='<a href=# onclick=player("stop",'+id+');><img id=conimage'+id+' src=images/stop.jpg width=20px height=20px/></a>';
			//conimage.src="stop.jpg";
		}else{
			document.getElementById('bgaudio'+id).pause();
			document.getElementById('myimg'+id).innerHTML='<a href=# onclick=player("play",'+id+');><img id=conimage'+id+' src=images/play.jpg width=20px height=20px/></a>';
		}
		
	}
</script>
	</head>

	<body>
		<img src="res/daduihao.png"
			style="display: none; position: absolute; z-index: 999999"
			id="ddhpng">
		<div class="container">
			<div class="containerBox">
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
						图文列表
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
								<s:iterator value="fodders" var="fodder" status="index">
								<s:if test="#index.count%2==0">
									<s:if test="savetype==1">
										<!-- 偶数列-文本 -->
										<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
												</div>
												
										</div>
									</s:if>
									<s:elseif test="savetype==5">
										<!-- 偶数列-音乐 -->
										<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
														<audio id="bgaudio<s:property value="id" />" src="<s:property value="musicurl" />"></audio>
														<span id="myimg<s:property value="id" />"> 
														<a href="#" onclick="player('play',<s:property value="id" />);"><img id="conimage<s:property value="id" />"
																	src="images/play.jpg" width="20px" height="20px" />
														</a> </span>
														
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
													
													<p class="msg-text">
														<s:if test="description!=null&&description!=''">
															<s:property value="description" />
														</s:if>
														<s:else>
															没有描述
														</s:else>
													</p>
												</div>
												
										</div>
									</s:elseif>
									<s:elseif test="savetype==6">
										<s:if test="articlecount==1">
											<!-- 偶数单图文 -->
											<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
													<div class="cover">
														<p class="default-tip" style="display: none">
															封面图片
														</p>
														<s:if test="picurl!=null&&picurl!=''">
															<img src="../<s:property value="picurl" />" class="i-img">
														</s:if>
														<s:else>
															<img src="images/noimg2.png" class="i-img">
														</s:else>
													</div>
													<!-- 
													<p class="msg-text">
														点击进入微官网【演示版，请修改】
													</p>
													 -->
												</div>
												
											</div>
										</s:if>
										<s:else>
											<!-- 偶数多图文 -->
											<div class="msg-item-wrapper" id="dsc_24845">
												<div class="msg-item multi-msg" itemid="<s:property value="id"/>">
													<div class="appmsgItem">
														<h4 class="msg-t">
															<a href="javascript:;" class="i-title"><s:property value="title"/></a>
														</h4>
														<p class="msg-meta">
															<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
														</p>
														<div class="cover">
															<s:if test="picurl!=null&&picurl!=''">
																<img src="<s:property value="picurl" />" class="i-img">
															</s:if>
															<s:else>
																<img src="images/noimg2.png" class="i-img">
															</s:else>
														</div>
														<!-- 
														<p class="msg-text">
															欢迎关注微信公众账号，点击进入微官网【演示版，请修改】
														</p>
														 -->
													</div>
													<s:iterator value="fodderarticles" var="fodderarticle" status="index2">
														<s:if test="#index2.count!=1">
															<div class="rel sub-msg-item appmsgItem">
																<span class="thumb"> <img
																		src="<s:property value="picurl" />" class="i-img" style="">
																</span>
																<h4 class="msg-t">
																	<a href="javascript:;" target="_blank" class="i-title"><s:property value="title" /></a>
																</h4>
															</div>
														</s:if>
													</s:iterator>
												</div>
												
											</div>
										</s:else>
									</s:elseif>
								</s:if>
								</s:iterator>
							</div>
							<!-- 奇数内容 -->
							<div id="second_col" class="b-dib vt msg-col">

								<s:iterator value="fodders" var="fodder" status="index">
									<s:if test="#index.count%2==1">
									<s:if test="savetype==1">
										<!-- 奇数列-文本 -->
										<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
												</div>
												
										</div>
									</s:if>
									<s:elseif test="savetype==5">
										<!-- 奇数列-音乐 -->
										<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
														<audio id="bgaudio<s:property value="id" />" src="<s:property value="musicurl" />"></audio>
														<span id="myimg<s:property value="id" />"> 
														<a href="#" onclick="player('play',<s:property value="id" />);"><img id="conimage<s:property value="id" />"
																	src="images/play.jpg" width="20px" height="20px" />
														</a> </span>
														
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
													
													<p class="msg-text">
														<s:if test="description!=null&&description!=''">
															<s:property value="description" />
														</s:if>
														<s:else>
															没有描述
														</s:else>
													</p>
												</div>
												
										</div>
									</s:elseif>
									<s:elseif test="savetype==6">
										<s:if test="articlecount==1">
											<!-- 奇数单图文 -->
											<div class="msg-item-wrapper" id="dsc_24844">
												<div class="msg-item" itemid="<s:property value="id"/>">
													<h4 class="msg-t">
														<a href="javascript:;" class="i-title"><s:property value="title"/></a>
													</h4>
													<p class="msg-meta">
														<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
													</p>
													<div class="cover">
														<p class="default-tip" style="display: none">
															封面图片
														</p>
														<s:if test="picurl!=null&&picurl!=''">
															<img src="../<s:property value="picurl" />" class="i-img">
														</s:if>
														<s:else>
															<img src="images/noimg2.png" class="i-img">
														</s:else>
													</div>
													<!-- 
													<p class="msg-text">
														点击进入微官网【演示版，请修改】
													</p>
													 -->
												</div>
												
											</div>
										</s:if>
										<s:else>
											<!-- 奇数多图文 -->
											<div class="msg-item-wrapper" id="dsc_24845">
												<div class="msg-item multi-msg" itemid="<s:property value="id"/>">
													<div class="appmsgItem">
														<h4 class="msg-t">
															<a href="javascript:;" class="i-title"><s:property value="title"/></a>
														</h4>
														<p class="msg-meta">
															<span class="msg-date"><s:date name="createdate" format="yyyy-MM-dd"/></span>
														</p>
														<div class="cover">
															<s:if test="picurl!=null&&picurl!=''">
																<img src="<s:property value="picurl" />" class="i-img">
															</s:if>
															<s:else>
																<img src="images/noimg2.png" class="i-img">
															</s:else>
														</div>
														<!-- 
														<p class="msg-text">
															欢迎关注微信公众账号，点击进入微官网【演示版，请修改】
														</p>
														 -->
													</div>
													<s:iterator value="fodderarticles" var="fodderarticle" status="index2">
														<s:if test="#index2.count!=1">
															<div class="rel sub-msg-item appmsgItem">
																<span class="thumb"> <img
																		src="<s:property value="picurl" />" class="i-img" style="">
																</span>
																<h4 class="msg-t">
																	<a href="javascript:;" target="_blank" class="i-title"><s:property value="title" /></a>
																</h4>
															</div>
														</s:if>
													</s:iterator>
												</div>
												
											</div>
										</s:else>
									</s:elseif>
								</s:if>
								</s:iterator>
							</div>
						</div>

					</div>



				</div>
				

				<div class="clr">
				</div>
			</div>


		</div>



	</body>
</html>