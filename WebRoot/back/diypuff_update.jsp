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
		<title>第三屏—国内免费的微信公众服务平台</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<link rel="shortcut icon" href="favicon.ico" />
		<style type="text/css">
.yulan {
	background: url(res/erweima/erweimabg.png) repeat scroll 0 0 #4E5359;
	color: #666666;
	font: 14px/ 1.5 Microsoft YaHei, Helvitica, Verdana, Tohoma, Arial,
		san-serif;
	margin: 0;
	padding: 0;
	color: #666666;
}

.yulan .main {
	margin: 0;
}

.yulan h1 {
	font-size: 20px;
	color: #f5f5f5;
	font-weight: normal;
	margin: 20px 100px 10px 80px;
	text-shadow: 0 1px 3px #111111;
}

.yulan .erweima {
	height: 250px;
	width: 250px;
}

.yulan .erweima img {
	border: medium none;
	-moz-box-shadow: 0 4px 3px 2px #333333;
	-webkit-box-shadow: 0 4px 3px 2px #333333;
	box-shadow: 0 4px 3px 2px #333333;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	width: 100%;
}

.yulan .beizhu {
	margin: 15px auto 5px;
	text-align: center;
}

.yulan .beizhu p {
	line-height: 48px;
}

.yulan .beizhubg {
	color: #B4B7BC;
	background: url(res/erweima/erweima_bg2.png) repeat-x scroll 0 0
		transparent;
	font-size: 12px;
	height: 48px;
	margin: 10px auto;
	width: 230px;
	text-shadow: 0 -1px 0 #111112;
	line-height: 48px;
	display: inline-block;
	position: relative;
}

.yulan .beizhuleft {
	background: url(res/erweima/erweima_bg2_left.png) no-repeat scroll 0 0
		transparent;
	display: block;
	float: left;
	height: 48px;
	margin-left: -26px;
	width: 26px;
}

.yulan .beizhuright {
	background: url(res/erweima/erweima_bg2_right.png) no-repeat scroll 0 0
		transparent;
	display: block;
	float: right;
	height: 48px;
	margin-right: -26px;
	width: 26px;
}

.yulan .content {
	color: #B4B7BC;
	font-size: 14px;
	padding: 5px;
	width: 300px;
	margin: 0 auto;
	text-shadow: 0 -1px 0 #111112;
	float: none;
	background-color: transparent;
	min-height: 40px;
	border: 0;
}

.yulan .footer {
	background: url(res/erweima/erweimabg.png) repeat scroll 0 0 transparent
		;
	color: #AAAAAA;
	margin: 20px auto 0;
	text-shadow: 0 -1px 0 #111111;
	text-align: center;
	line-height: 48px;
	width: 100%;
	padding: 0;
}

.yulan .footer p {
	background: url(res/erweima/erweima_footer.png) no-repeat scroll center
		top transparent;
	font-size: 12px;
	line-height: 48px;
}
</style>
<script type="text/javascript">
	//改变上传图片的页面预览图片
function changePreImg() {
    var pic = document.getElementById("myimage"),pic2 = document.getElementById("myimage2"),
        file = document.getElementById("myfile");
 
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
            pic2.src = reallocalpath;
         }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
             
             // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic2.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic2.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
         }
     }else {
        html5Reader(file);
     }
     pic.alt = '图片';
     pic2.alt = '图片';
}
 
 function html5Reader(file){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById("myimage");
         var pic2 = document.getElementById("myimage2");
         pic.src=this.result;
         pic2.src=this.result;
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
									<h3>
										<i class="icon-cog"></i>宣传页设置
									</h3>
								</div>
							</div>
							<div class="box-content">
								<table class="userinfoArea" style="margin: 0;" border="0"
									cellspacing="0" cellpadding="0" width="100%">
									<tbody>
										<tr>
											<td width="50%">
												<form action="diypuffAction!update" method="post"
													class="form-horizontal form-validate" enctype="multipart/form-data">
													<s:hidden name="diypuff.id"></s:hidden>
													<s:hidden name="diypuff.ewmimg"></s:hidden>
													<s:hidden name="diypuff.linkurl"></s:hidden>
													<s:hidden name="diypuff.publicaccount"></s:hidden>
													
													<div class="control-group">
														<label class="control-label" for="title">
															宣传页标题：
														</label>
														<div class="controls">
																<s:textfield name="diypuff.title" cssClass="input-xlarge" required="required" onkeyup="document.getElementById('adtitle').innerHTML=this.value"></s:textfield>
															<span class="maroon">*</span>
														</div>
													</div>



													<div class="control-group">
														<label class="control-label" for="cover">
															二维码设置
														</label>
														<div class="controls">
															<img class="thumb_img" src="../<s:property value="diypuff.ewmimg"/>" id="myimage"
																style="max-height: 100px;" />
															<span class="help-inline">
																<s:file name="picture" onchange="changePreImg();" id="myfile"></s:file>
																 <span class="help-inline">到公众平台下载二维码边长为 12 CM，大小为 344×344 px,图片大小不超过300K</span>
															</span>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="brief">
															功能介绍
														</label>
														<div class="controls">
															<s:textarea name="diypuff.funinfo" cssClass="input-large" cssStyle="height: 80px; width: 380px;" onkeyup="document.getElementById('adfuninfo').innerHTML=this.value"></s:textarea>
															<span class="maroon">*</span>
															<span class="help-block">150文字以内</span>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="brief">
															版权信息
														</label>
														<div class="controls">
															<s:textarea name="diypuff.copyright" cssClass="input-large" cssStyle="height: 40px; width: 380px;" onkeyup="document.getElementById('gzhcopyright').innerHTML=this.value"></s:textarea>
																
															<span class="maroon">*</span>
															<span class="help-block">15文字以内</span>
														</div>
													</div>
													<s:if test="diypuff.id!=null&&diypuff.id!=0">
													<div class="control-group">
														<label class="control-label" for="brief">
															链接地址
														</label>
														<div class="controls">
															<s:property value="diypuff.linkurl"/>
														</div>
													</div>
													</s:if>
													<div class="form-actions">
														<s:token></s:token>
														<button type="submit"
															data-loading-text="提交中..." class="btn btn-primary">
															保存
														</button>
														<s:if test="diypuff.id!=null&&diypuff.id!=0">
														<a href="<s:property value="diypuff.linkurl"/>"
															target="_blank" class="btn btn-primary ">查看推广页</a>
														</s:if>
													</div>
												</form>

											</td>

											<td rowspan="6" valign="top" class="yulan" style="text-align: center;width: 300px;height: auto;">
												<div class="content" id="gzhinfo">
													<h1 id="adtitle" align="center"><s:property value="diypuff.title"/></h1>
													<div class="erweima" style="text-align: center;margin: 20px;">
														<img id="myimage2" src="../<s:property value="diypuff.ewmimg"/>" />
													</div>
													<div class="beizhu">
														<div class="beizhubg">
															<div class="beizhuleft"></div>
															<div class="beizhuright"></div>
															<p>
																请使用微信扫描二维码关注此公众号
															</p>
														</div>
													</div>
													<span id="adfuninfo"><s:property value="diypuff.funinfo"/></span>
												</div>
												<div class="clr"></div>
												<div class="footer">
													<p id="gzhcopyright"><s:property value="diypuff.copyright"/></p>
												</div>
											</td>
										<tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript" src="js/comm.js"></script>