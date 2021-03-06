<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
<base target="mainFrame" />
<link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/album.css" media="all" />
<title>第三屏—国内免费的微信公众服务平台</title>
<script type="text/javascript">var yyuc_jspath = "";</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<script type="text/javascript">
//改变上传图片的页面预览图片
function changePreImg(myimage,myfile) {
    var pic = document.getElementById(myimage),
        file = document.getElementById(myfile);
 
    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
 
     // gif在IE浏览器暂时无法显示
     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
         return;
     }
     var isIE = navigator.userAgent.match(/MSIE/)!= null,
         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
 
     if(isIE) {
        file.select();
        var reallocalpath = document.selection.createRange().text;
 
        // IE6浏览器设置img的src为本地路径可以直接显示图片
         if (isIE6) {
            pic.src = reallocalpath;
         }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
         }
     }else {
        html5Reader(file,myimage);
     }
     pic.alt = '图片';
}
 
 function html5Reader(file,myimage){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById(myimage);
         pic.src=this.result;
     }
 }
 
 function isShowScreenImg(radiovalue){
 	var divScreenImg = document.getElementById("div_screen_img");
 	if(radiovalue==1){
 		divScreenImg.style.display="";
 	}else{
 		divScreenImg.style.display="none";
 	}
 }
</script>
</head>
<body class="theme-blue">
	<div id="main">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="box">
						<div class="box-title">
							<div class="span12">
								<h3><i class="icon-cog"></i>微官网背景轮播图配置</h3>
							</div>
						</div>
						<form action="screenimgAction!add" method="post" id="lbsForm" class="form-horizontal form-validate" enctype="multipart/form-data">
							<div class="box-content">
								
								<s:hidden name="screenimg.wgw.id" value="%{wgw.id}"></s:hidden>
								
								<s:hidden name="screenimg.imginterval" value="2000"></s:hidden>
								<div class="control-group">
										<label for="title" class="control-label">说明：</label>
										<div class="controls">
										    1-设置的微官网模板必须支持背景轮播显示<br>
										    2-请开启背景轮播并且配置好轮播图片
											<span class="maroon"></span>
											 <span class="help-inline"></span> 
										</div>
									</div><BR>
									
									<div class="control-group">
	                                        <label for="title" class="control-label">是否开启背景轮播：</label>
	                                        <div class="controls">
	                                        	<input type="radio" name="screenimg.ison" value="0" checked="checked"  onclick="isShowScreenImg(this.value)"/>关闭&nbsp;&nbsp;<input type="radio" name="screenimg.ison" value="1"  onclick="isShowScreenImg(this.value)" />开启&nbsp;&nbsp;
	                    						
	                                        </div>
	                                </div>
									
	                                <div class="control-group">
										<label class="control-label">背景图片：</label>
										<div class="controls">
											<img class="thumb_img" src="images/noimg.jpg"  id="myimage0" style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture0" cssStyle="width:80%" onchange="changePreImg('myimage0','myfile0');" title="上传" id="myfile0"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
									</div>
									<!-- 
	                                <div id="div_screen_img" style="display: none;">
									<div class="control-group">
										<label for="title" class="control-label">轮播间隔时间：</label>
										<div class="controls">
											<s:textfield name="screenimg.imginterval" value="3000" cssClass="input-small" required="required"></s:textfield>
											<span class="maroon">*</span>
											 <span class="help-inline">单位毫秒，默认3000毫秒，值越大，速度越慢！</span> 
										</div>
									</div>
									 -->								
									<div class="control-group">
										<label class="control-label">轮播1：</label>
										<div class="controls">
											<img class="thumb_img" src="images/noimg.jpg"  id="myimage1" style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture1" cssStyle="width:80%" onchange="changePreImg('myimage1','myfile1');" title="上传" id="myfile1"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
									</div>
									<div class="control-group">
										<label for="title" class="control-label">轮播1链接：</label>
										<div class="controls">
											<s:textfield name="screenimg.linkurl1" cssClass="input-xxlarge"></s:textfield>
											<br>
											<span class="help-inline">示例:http://www.di3p.com</span>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">轮播2：</label>
										<div class="controls">
										<img class="thumb_img" src="images/noimg.jpg" id="myimage2"  style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture2" cssStyle="width:80%" onchange="changePreImg('myimage2','myfile2');" title="上传" id="myfile2"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
									</div>
									
									<div class="control-group">
										<label for="title" class="control-label">轮播2链接：</label>
										<div class="controls">
											<s:textfield name="screenimg.linkurl2" cssClass="input-xxlarge" ></s:textfield>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">轮播3：</label>
										<div class="controls">
										<img class="thumb_img" src="images/noimg.jpg" id="myimage3"  style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture3" cssStyle="width:80%" onchange="changePreImg('myimage3','myfile3');" title="上传" id="myfile3"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
									</div>
								
									<div class="control-group">
										<label for="title" class="control-label">轮播3链接：</label>
										<div class="controls">
											<s:textfield name="screenimg.linkurl3" cssClass="input-xxlarge" ></s:textfield>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">轮播4：</label>
										<div class="controls">
										
										<img class="thumb_img" src="images/noimg.jpg" id="myimage4" style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture4" cssStyle="width:80%" onchange="changePreImg('myimage4','myfile4');" title="上传" id="myfile4"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
									</div>
									
									<div class="control-group">
										<label for="title" class="control-label">轮播4链接：</label>
										<div class="controls">
											<s:textfield name="screenimg.linkurl4" cssClass="input-xxlarge"></s:textfield>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">轮播5：</label>
										<div class="controls">
										<img class="thumb_img" src="images/noimg.jpg" id="myimage5" style="max-height:100px;" />
											<span class="help-inline">
												<s:file name="picture5" cssStyle="width:80%" onchange="changePreImg('myimage5','myfile5');" title="上传" id="myfile5"></s:file>
												<span class="help-inline">建议尺寸：宽400像素，高720像素</span>
											</span>
										</div>
	                                    								
							
									</div>
									<div class="control-group">
										<label for="title" class="control-label">轮播5链接：</label>
										<div class="controls">
											<s:textfield name="screenimg.linkurl5" cssClass="input-xxlarge"></s:textfield>
										</div>
									</div>
									
									</div>
									
									<div class="form-actions">
										<s:token></s:token>
										<button type="submit" id="bsubmit" data-loading-text="提交中..." class="btn btn-primary">保存</button>
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
<br/><br/><br/></body>
	<script type="text/javascript">
	function setpic(imgid,hideid){
		window.piccbk = function(m){
			$('#'+imgid).attr('src',m);
			$('#'+hideid).val(m);
			window.piccbk = null;
		}
		window.curpic = null;
		openpicset();	
	} 
	function openpicset(){
		pophtml('<iframe src="wspicif.html" style="width:630px;height:470px;border:none;background-color: #dfdfdf;" width="630px" height="475px"></iframe>',670,510,true);
	}


	$(function(){
		
		 $("#lbsForm").submit(function(){
			var cansv= true;
			$(this).find('input[type="text"],select,textarea').filter('[required="required"]').each(function(){
				if($.trim($(this).val())==''){
					cansv = false;
					$(this).css('backgroundColor','yellow');
					$(this).one('focus',function(){
						$(this).css('backgroundColor','transparent');
					});
				}
			});
			if(!cansv){
				tusi('请将信息填写完整');
			}
	    	return cansv;
	    });
	});
	</script>
</html>