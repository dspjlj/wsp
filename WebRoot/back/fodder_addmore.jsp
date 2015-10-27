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
		<link rel="stylesheet" href="css/admin/appmsg-mul.css">
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
$(function(){
	$('body').delegate('.appmsgItem','mouseenter',function(){
		$(this).addClass('sub-msg-opr-show');
		window.curedt = $(this);
	});
	$('body').delegate('.appmsgItem','mouseleave',function(){
		$(this).removeClass('sub-msg-opr-show');
	});
	
});

//存贮校验
function czjy(){
	//window.dqdiv.find('.m-con').html(window.kindeditor_fg.html());
	var tit = $.trim(window.dqdiv.find('.m-title').text());
	var img = window.dqdiv.find('img').attr('src');
	var url = $.trim(window.dqdiv.find('.m-url').text());
	var con = $.trim(window.dqdiv.find('.m-con').text());
	var imgurl = $.trim(window.dqdiv.find('.m-imgurl').text());
	/*
	console.log("title:"+tit);
	console.log("img:"+img);
	console.log("con:"+con);
	console.log("url:"+url);
	console.log("imgurl:"+imgurl);
	*/
	
	if(tit==''||tit=='标题'){
		alert('请填写标题');
		return false;
	}
	if(imgurl==''){
		alert('请上传图片');
		return false;
	}
	if(con==''){
		alert('请编辑正文');
		return false;
	}
	if(url==''){
		alert('请编辑链接地址');
		return false;
	}
	return true;
}
function edititem(o,first){
	//console.log("edititem(o,first) is in "+o);
	if(first || czjy()) {
		if(first){
			window.dqdiv = $('#appmsgItem1');
			$('.msg-editer-wrapper').css('marginTop','40px');
		}else{
			$('.msg-editer-wrapper').css('marginTop',($(o).offset().top-99)+'px');
		}
			
		window.dqdiv = window.curedt;	
		//把历史设置好的值传入文本框
		$('#title').val(window.dqdiv.find('.m-title').text());
		$('#url').val(window.dqdiv.find('.m-url').text());
		$('#con').val(window.dqdiv.find('.m-con').text());
		$('#imgurl').val(window.dqdiv.find('.m-imgurl').text());
		//console.log("1="+$('#title').val());
		//console.log("2="+window.dqdiv.find('img').attr('src'));
		window.dqdiv.find('.m-img').attr('src',window.dqdiv.find('.m-imgurl').text());
		//window.kindeditor_fg.html(window.dqdiv.find('.m-con').html());
	}	
}

function addaline(){
	var theitem = $('.msg-item-wrapper').find('.appmsgItem').eq(1);
	var bzitem = theitem.clone();
	bzitem.find('.m-title').text('标题');
	bzitem.find('.m-url').text('');
	bzitem.find('.m-con').text('');
	bzitem.find('.m-imgurl').text('');
	bzitem.find('.m-img').attr('src','res/ddspic.png');
	$('.sub-add').before(bzitem);
}

function delitem(o){
	if(window.dqdiv[0] == window.curedt[0]){
		console.log('mainedit');
		//edititem(document.getElementById('mainedit'),true);
		//document.getElementById('mainedit').keydown();
		window.dqdiv = $('#appmsgItem1');
		$('.msg-editer-wrapper').css('marginTop','40px');
		//把历史设置好的值传入文本框
		$('#title').val(window.dqdiv.find('.m-title').text());
		$('#url').val(window.dqdiv.find('.m-url').text());
		$('#con').val(window.dqdiv.find('.m-con').text());
		$('#imgurl').val(window.dqdiv.find('.m-imgurl').text());
		//console.log("1="+$('#title').val());
		//console.log("2="+window.dqdiv.find('img').attr('src'));
		window.dqdiv.find('.m-img').attr('src',window.dqdiv.find('.m-imgurl').text());
		//window.kindeditor_fg.html(window.dqdiv.find('.m-con').html());
	}else{
		//$('.msg-editer-wrapper').css('marginTop',($(o).offset().top-99)+'px');
		window.dqdiv = $('#appmsgItem1');
		$('.msg-editer-wrapper').css('marginTop','40px');
		//把历史设置好的值传入文本框
		$('#title').val(window.dqdiv.find('.m-title').text());
		$('#url').val(window.dqdiv.find('.m-url').text());
		$('#con').val(window.dqdiv.find('.m-con').text());
		$('#imgurl').val(window.dqdiv.find('.m-imgurl').text());
		//console.log("1="+$('#title').val());
		//console.log("2="+window.dqdiv.find('img').attr('src'));
		window.dqdiv.find('.m-img').attr('src',window.dqdiv.find('.m-imgurl').text());
		//window.kindeditor_fg.html(window.dqdiv.find('.m-con').html());
		
	}
	if($('.appmsgItem').size()>2){
		//判断是否从最后那篇开始删除，若不是，提示并无法删除
		console.log($('.appmsgItem').size());
		alert('请依次从最后那篇开始删除！');
		
		$(o).parent().parent().parent().remove();
		return true;
	}else{
		alert('多图文最少不得少于两篇，请依次从最后那篇开始删除！');
		return false;
	}
	
		
}

var UEDITOR_HOME_URL = '/res/ueditor/';
function hidepicname(url,jo,name){
	$('#'+name+'_name').html('');
	$('#'+name+'_bfb').html('');
	cutok();
}
$(function(){
	window.dqdiv = $('#appmsgItem1');
	$('#title').on('change keyup blur',function(){
		window.dqdiv.find('.m-title').text($(this).val());
		//console.log("change:"+window.dqdiv.find('.m-title').text());
	});
	$('#url').on('change keyup blur',function(){
		window.dqdiv.find('.m-url').text($(this).val());
		//console.log("change:"+window.dqdiv.find('.m-url').text());
	});
	$('#con').on('change keyup blur',function(){
		window.dqdiv.find('.m-con').text($(this).val());
		//console.log("change:"+window.dqdiv.find('.m-con').text());
	});
	/*
	$('#imgurl').on('change',function(){
		window.dqdiv.find('.m-imgurl').text($(this).val());
		window.dqdiv.find('.m-img').attr('src',$(this).val());
		console.log("change:"+window.dqdiv.find('.m-imgurl').text());
	});
	*/
    
    
    
    
    YYUC(function(){
    	window.curedt = $('body').find('.appmsgItem').eq(0);
		var ysdata = $.trim($('#ysdata').val());
		if(ysdata!=''){
			var jcon = $.evalJSON(ysdata);
			for(var i=0;i<jcon.length;i++){
				//console.log(jcon+":"+i);
				if(i>1){
					addaline();
				}
				var itm = $('.appmsgItem').eq(i);
				itm.find('.m-title').text(jcon[i].tit);
				itm.find('.m-url').text(jcon[i].url);
				itm.find('img').attr('src',jcon[i].pic);
				itm.find('.m-con').text(jcon[i].con);			
				//itm.find('.m-imgurl').text(jcon[i].imgurl);				
			}
		}
		edititem(null,true);
	});
});

//图片剪裁成功后调用
function cutok(){
	var timg = $('#picsethere').find('img');
	var url = timg.attr('src');
	window.dqdiv.find('.m-img').attr('src',url);
	timg.remove();
}



function savedate(){
	if(czjy()){
		//var id = $.trim($('.msg-item-wrapper').attr('relid'));
		var data = [];
		var isenter = true;
		$('.appmsgItem').each(function(){
			var sd = {};
			sd.tit = $.trim($(this).find('.m-title').text());
			sd.pic = $(this).find('img').attr('src');
			sd.con = $.trim($(this).find('.m-con').text());
			sd.url = $.trim($(this).find('.m-url').text());
			//sd.imgurl = $.trim($(this).find('.m-imgurl').text());
			if(sd.tit==''|| sd.pic=='res/ddspic.png'|| sd.con==''){
				var i=data.length;
				alert('请编辑完整子图文'+i+'信息');
				isenter = false;
				return false;
			}
			data[data.length] = sd;
		});
		//console.log(data);
		if(isenter){
			loading('数据保存中...');
			ajaxjson('fodderAction!muladd',{ data:data},function(m){
				goto('fodderAction!list');
			});
		}
		
	}
}
$(function(){
	
});
</script>
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
		<script src="kindeditor/kindeditor-min.js"></script>
		<script>
			KindEditor.ready(function(K) {
				var uploadbutton = K.uploadbutton({
					button : K('#uploadButton')[0],
					fieldName : 'imgFile',
					url : 'kindeditor/jsp/upload_json.jsp?dir=image',
					afterUpload : function(data) {
						if (data.error === 0) {
							var url = K.formatUrl(data.url, 'absolute');
							K('#imgurl').val(url);
							window.dqdiv.find('.m-imgurl').text(url);
							window.dqdiv.find('.m-img').attr('src',url);
							//document.getElementById("coverimg").src=url;
						} else {
							alert(data.message);
						}
					},
					afterError : function(str) {
						alert('自定义错误信息: ' + str);
					}
				});
				uploadbutton.fileBox.change(function(e) {
					uploadbutton.submit();
				});
			});
		</script>
	</head>

	<body>
		<textarea id="ysdata" style="display: none;">
</textarea>
		<div class="row">
			<div class="span5 msg-preview" id="nrdiv1">

				<div class="msg-item-wrapper" relid="">
					<div id="appmsgItem1" class="appmsgItem msg-item">
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
							<img class="i-img m-img" src="res/fmdtp.jpg"
								style="width: 440px; height: 176px;" id="coverimg">
							<h4 class="msg-t">
								<span class="i-title m-title">标题</span>
							</h4>
							<ul class="abs tc sub-msg-opr">
								<li class="b-dib sub-msg-opr-item">
									<a href="javascript:;" onclick="edititem(this,true);"
										class="th opr-icon edit-icon" id="mainedit">编辑</a>
								</li>
							</ul>
							<img class="i-img" style="">
						</div>
						<p class="msg-text"></p>
						<div rel="con" class="m-con" style="display: none;"></div>
						<div rel="url" class="m-url" style="display: none;"></div>
						<div rel="imgurl" class="m-imgurl" style="display: none;"></div>
					</div>

					<div class="rel sub-msg-item appmsgItem">
						<span class="thumb"> <img class="i-img m-img"
								src="res/ddspic.png" style="width: 72px; height: 72px;"> </span>
						<h4 class="msg-t">
							<span class="i-title m-title">标题</span>
						</h4>
						<ul class="abs tc sub-msg-opr">
							<li class="b-dib sub-msg-opr-item">
								<a href="javascript:;" onclick="edititem(this,false);"
									class="th opr-icon edit-icon">编辑</a>
							</li>
							<li class="b-dib sub-msg-opr-item">
								<a href="javascript:;" onclick="delitem(this);"
									class="th opr-icon del-icon">删除</a>
							</li>
						</ul>
						<div rel="con" class="m-con" style="display: none;"></div>
						<div rel="url" class="m-url" style="display: none;"></div>
						<div rel="imgurl" class="m-imgurl" style="display: none;"></div>
					</div>

					<div class="sub-add">
						<a href="javascript:;" class="block tc sub-add-btn"
							onclick="addaline();"> <span class="vm dib sub-add-icon"></span>增加一条</a>
					</div>
				</div>
			</div>
			<div class="span7">
				<div class="msg-editer-wrapper">
					<div class="msg-editer">
						<form id="appmsg-form" class="form">
							<div class="control-group">
								<label class="control-label">
									标题
								</label>
								<span class="maroon">*</span><span class="help-inline">(必填,不能超过64个字)</span>
								<div class="controls">
									<input type="text" value="标题" id="title" class="span5"
										style="width: 482px;" name="title">
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
											<iframe name="YYUC_89b64f3467874b2d4bfb6ab15564983a_if"
												style="position: absolute; left: -10000px;"></iframe>
											<table
												style="border: none; padding: 0; margin: 0; width: auto; display: inline-block;">
												<tr style="border: none; padding: 0; margin: 0;">
													<td style="border: none; padding: 0; margin: 0; width: auto;">
																
																<div class="upload">
																	<input class="ke-input-text" type="text" name="imgurl" id="imgurl" style="width: 280px;" readonly="readonly"/> <input type="button" id="uploadButton" value="上传" />
																</div>
																
													</td>
													<td
														style="border: none; padding: 0; margin: 0; width: auto;">
														<span id="YYUC_89b64f3467874b2d4bfb6ab15564983a_span"
															style="display: -moz-inline-box; display: inline-block; width: 100px; height: 32px;">
														</span>
													</td>
													<td
														style="border: none; padding: 0; margin: 0; width: auto;">
														<span id="YYUC_89b64f3467874b2d4bfb6ab15564983a_loadpic"
															style="display: none;"><img src="res/18.gif" />
														</span>
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
							<div class="control-group">
								<label class="control-label">
									正文
								</label>
								<span class="maroon">*</span><span class="help-inline">(正文为空时则直接跳转到来源地址)</span>
								<div class="controls">
									<textarea style="width: 498px; height: 360px;" width="498px"
										height="360px" name="description" id="con"></textarea>
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
									<input type="text" id="url" class="span5" value=""
										style="width: 482px;" name="source_url">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button id="save-btn" type="button" onclick="savedate();"
										class="btn btn-primary btn-large">
										保存
									</button>
									<button id="cancel-btn" type="button" class="btn btn-large">
										取消
									</button>
								</div>
							</div>

							<input id="action" name="action" type="hidden" value="add">
						</form>
					</div>
					<span class="abs msg-arrow a-out" style="margin-top: 0px;"></span>
					<span class="abs msg-arrow a-in" style="margin-top: 0px;"></span>
				</div>
			</div>
		</div>
		<br />
		<br />
		<br />
	</body>
</html>