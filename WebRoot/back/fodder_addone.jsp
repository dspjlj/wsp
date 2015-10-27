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
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/admin/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin/appmsg.css">
		<style>
body {
	padding: 20px;
	border-radius: 10px;
}

label {
	display: inline-block;
}

.help-inline {
	vertical-align: top;
}

.row {
	padding-top: 20px;
	padding-bottom: 20px;
}

.control-group img {
	max-width: 600px;
}

.jcbtncls {
	background: blue;
	border-radius: 8px;
	color: #fff;
	padding: 5px 12px;
	line-height: 30px;
	font-size: 16px;
	font-family: 'Microsoft Yahei';
}
</style>
		<title>图文素材管理页面</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>


		<script>
var UEDITOR_HOME_URL = '/res/ueditor/';
function hidepicname(url,jo,name){
	$('#'+name+'_name').html('');
	$('#'+name+'_bfb').html('');
	cutok();
}
$(function(){
	window.dqdiv = $('#nrdiv1');
	$('#title').on('change keyup blur',function(){
		window.dqdiv.find('.m-title').text($(this).val());
	});
	$('#desc').on('change keyup blur',function(){
		window.dqdiv.find('.m-desc').text($(this).val());
	});
	$('#url').on('change keyup blur',function(){
		window.dqdiv.find('.m-url').text($(this).val());
	});   
});

//图片剪裁成功后调用
function cutok(){
	var timg = $('#picsethere').find('img');
	var url = timg.attr('src');
	window.dqdiv.find('.m-img').attr('src',url);
	timg.remove();
}

//存贮校验
function czjy(){
	window.dqdiv.find('.m-con').html(window.kindeditor_fg.html());
	var tit = $.trim(window.dqdiv.find('.m-title').text());
	var img = window.dqdiv.find('img').attr('src');
	var desc = window.dqdiv.find('.m-desc').text();
	var url = $.trim(window.dqdiv.find('.m-url').text());
	var con = $.trim(window.dqdiv.find('.m-con').html());
	if(tit==''){
		alert('请填写标题');
		return false;
	}
	if(url=='' && con==''){
		alert('请编辑正文或者链接地址');
		return false;
	}
	return true;
}

function savedate(){
	if(czjy()){
		var id = $.trim($('.msg-item-wrapper').attr('relid'));
		var tit = $.trim(window.dqdiv.find('.m-title').text());
		var img = window.dqdiv.find('img').attr('src');
		var desc = window.dqdiv.find('.m-desc').text();
		var url = $.trim(window.dqdiv.find('.m-url').text());
		var con = $.trim(window.dqdiv.find('.m-con').html());
		loading('数据保存中...');
		ajaxjson('contresourceone.html',{ id:id,tit:tit,pic:img,des:desc,url:url,con:con},function(m){
			goto('contresource.html');
		});
	}
}

YYUC(function(){
	var ysdata = $.trim($('#ysdata').val());
	if(ysdata!=''){
		var jcon = $.evalJSON(ysdata);
		$('#title').val(jcon.tit).trigger('keyup');
		$('#desc').val(jcon.des).trigger('keyup');
		$('#url').val(jcon.url).trigger('keyup');
		$('.m-img').attr('src',jcon.pic);
		//需要ready后执行，否则可能报错
	    window.kindeditor_fg.html(jcon.content);
	}
	
});
</script>
	<script type="text/javascript" src="js/toolKit.js"></script>
</head>

	<body>
		<textarea id="ysdata" style="display: none;">
</textarea>
		<div class="row">
			<div class="span5 msg-preview" id="nrdiv1">
				<div class="msg-item-wrapper" relid="">
					<div id="appmsgItem1" class="msg-item">
						<h4 class="msg-t">
							<span class="i-title m-title" rel="title"></span>
						</h4>
						<p class="msg-meta">
							<span class="msg-date">
								<script language="javascript">
								   var cur = new Date();
								   var y = cur.getFullYear();
								   var m = cur.getMonth()+1;
								   var d = cur.getDate();
								   document.write(y+"-"+m+"-"+d);
								</script>
							</span>
						</p>
						<div class="cover">
							<img class="i-img m-img" src="res/fmdtp.jpg" id="myimage"
								style="width: 440px; height: 180px;">
							
						</div>
						<p class="msg-text m-desc" rel="desc"></p>
						<div rel="con" class="m-con" style="display: none;"></div>
						<div rel="url" class="m-url" style="display: none;"></div>
					</div>
					<div class="msg-hover-mask"></div>
					<div class="msg-mask">
						<span class="dib msg-selected-tip"></span>
					</div>
				</div>
			</div>
			<div class="span7">
				<div class="msg-editer-wrapper">
					<div class="msg-editer">
						<form id="appmsg-form" class="form" action="fodderAction!add" enctype="multipart/form-data" method="post">
							<s:hidden name="fodder.publicaccount"
								value="%{#session.pubclient.publicaccount}"></s:hidden>
							<s:hidden name="fodder.funcflag"
								value="0"></s:hidden>
							<s:hidden name="fodder.articlecount"
								value="1"></s:hidden>
							
							<div class="control-group">
								<label class="control-label">
									标题
								</label>
								<span class="maroon">*</span><span class="help-inline">(必填,不能超过64个字)</span>
								<div class="controls">
									<s:textfield name="fodder.title" id="title" cssStyle="width: 482px;" cssClass="span5"></s:textfield>
								</div>
							</div>
							<div class="control-group" id="picsethere"></div>
							<div class="control-group">
								<label class="control-label">
									封面
								</label>
								<span class="maroon">*</span><span class="help-inline">(必须上传一张图片)</span>
								<div class="controls">
									<div class="cover-area" style="height: 40px; overflow: hidden;">
										<div class="cover-hd">
											<iframe name="YYUC_312dab87a9b6a172c8691254aaaf3730_if"
												style="position: absolute; left: -10000px;"></iframe>
											<table
												style="border: none; padding: 0; margin: 0; width: auto; display: inline-block;">
												<tr style="border: none; padding: 0; margin: 0;">
													<td
														style="border: none; padding: 0; margin: 0; width: auto;">
														<s:file name="picture" cssStyle="width:80%" onchange="changePreImg();" title="上传" id="myfile"></s:file>
													</td>
													<td
														style="border: none; padding: 0; margin: 0; width: auto;">
														<span id="YYUC_312dab87a9b6a172c8691254aaaf3730_span"
															style="display: -moz-inline-box; display: inline-block; width: 100px; height: 32px;">
														</span>
													</td>
													<td
														style="border: none; padding: 0; margin: 0; width: auto;">
														<span id="YYUC_312dab87a9b6a172c8691254aaaf3730_loadpic"
															style="display: none;"><img src="res/18.gif" /> </span>
													</td>
												</tr>
											</table>
										</div>
										<p id="upload-tip" class="upload-tip">
											请事先调整好图片尺寸
										</p>
										<p id="imgArea" class="cover-bd" style="display: none;">
											<img src="" id="img">
											<a href="javascript:;" class="vb cover-del" id="delImg">删除</a>
										</p>
									</div>
								</div>
							</div>
							<a id="desc-block-link" href="javascript:void(0);"
								class="url-link block" style="display: none;">添加摘要</a>
							<div id="desc-block" style="" class="control-group">
								<label class="control-label">
									摘要
								</label>
								<span class="help-inline">(不能超过120个字)</span>
								<div class="controls">
									<textarea name="summary" id="desc" class="msg-txta"
										placeholder="摘要可以为空"></textarea>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">
									正文
								</label>
								<span class="maroon">*</span><span class="help-inline">(正文和链接地址至少填写一项)</span>
								<div class="controls">
									<s:textarea name="newsdes" cssStyle="width: 498px; height: 360px;" id="fg"/>
								</div>
							</div>
							<a id="url-block-link" href="javascript:void(0);"
								class="url-link block" style="display: none;">添加来源</a>
							<div id="url-block" style="" class="control-group">
								<label class="control-label">
									地址
								</label>
								<span class="help-inline">(请输入正确的URL链接格式)</span>
								<div class="controls">
									
									<s:textfield name="fodder.url" cssStyle="width: 482px;" id="url" cssClass="span5"></s:textfield>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<s:token></s:token>
									<button id="save-btn" type="submit"
										class="btn btn-primary btn-large">
										保存
									</button>
									<button id="cancel-btn" type="button" onclick="document.getElementById('appmsg-form').reset();" class="btn btn-large">
										取消
									</button>
								</div>
							</div>

							<input id="uid" name="uid" type="hidden" value="15065">
							<input id="action" name="action" type="hidden" value="add">
						</form>
					</div>
					<span class="abs msg-arrow a-out" style="margin-top: 0px;"></span>
					<span class="abs msg-arrow a-in" style="margin-top: 0px;"></span>
				</div>
			</div>
		</div>
	</body>
</html>