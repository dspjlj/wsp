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
//清除图片
function clearImg(myimage,myfile,isdelpic){
	var pic = document.getElementById(myimage),
		file = document.getElementById(myfile),
        isdel = document.getElementById(isdelpic);
    pic.src="images/noimg.jpg";
    isdel.value=1;
    
    // for IE, Opera, Safari, Chrome
	if (file.outerHTML) {
		file.outerHTML = file.outerHTML;
	} else { // FF(包括3.5)
		file.value = "";
	}
}

//改变上传图片的页面预览图片
function changePreImg() {
    var pic = document.getElementById("myimage"),
        file = document.getElementById("myfile"),
        isdel = document.getElementById("isdelpic");
 	//修改清除状态：不清除
 	isdel.value=0;
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
        html5Reader(file);
     }
     pic.alt = '图片';
}
 
 function html5Reader(file){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById("myimage");
         pic.src=this.result;
     }
 }
</script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue">
    <div id="main">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span12">
                                <h3><i class="icon-cog"></i>微官网--类别管理--子类别管理--【<s:property value="parentBigtype.name"/>】--修改分类</h3>
                            </div>
                        </div>
                        <div class="box-content">
                            <form action="bigtypeAction!updateson" method="post" class="form-horizontal form-validate" enctype="multipart/form-data">
                                <s:hidden name="bigtype.wgw.id"></s:hidden>
                                <s:if test="bigtype.bigtype!=null">
                                	<s:hidden name="bigtype.bigtype.id"></s:hidden>
                                </s:if>
                                <s:hidden name="bigtype.imageurl"></s:hidden>
                                <s:hidden name="bigtype.id"></s:hidden>
                                <s:hidden name="pid"></s:hidden>
                                
                                <div class="control-group">
                                    <label class="control-label" for="keyword">类别名:</label>
                                    <div class="controls">
                                    	<s:textfield name="bigtype.name"  cssClass="input-medium" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">有无子类别：</label>
                                    <div class="controls">
                                    <s:if test="bigtype.isend==1">
                                    	<input type="radio" name="bigtype.isend" value="1" checked="checked"/>有&nbsp;&nbsp;<input type="radio" name="bigtype.isend" value="0"/>没有
                                    </s:if>
                                     <s:else>
                                     	<input type="radio" name="bigtype.isend" value="1"/>有&nbsp;&nbsp;<input type="radio" name="bigtype.isend" value="0" checked="checked"/>没有
                                     </s:else>
                                     
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">简称：</label>
                                    <div class="controls">
		 							 <s:textfield name="bigtype.enname"  cssClass="input-xlarge" required="required"></s:textfield>                                     <span class="maroon">*</span>
                                    </div>
                                </div>
                             
                                

                                <div class="control-group">
                                    <label class="control-label" for="cover">图片：</label>
									  <div class="controls">
									  	<s:if test="bigtype.imageurl!=null&&bigtype.imageurl!=''">
									  		<img class="thumb_img" src="<%=basePath %><s:property value="bigtype.imageurl"/>" id="myimage" style="max-height:100px;" />
									  		
									  	</s:if>
									  	<s:else>
									  		<img class="thumb_img" src="images/noimg.jpg" id="myimage" style="max-height:100px;" />
									  	</s:else>
										
										<span class="help-inline">
											<s:file name="picture" cssStyle="width:80%" onchange="changePreImg();" title="上传" id="myfile"></s:file>
											<br/>
											<input type="button" value="删除图片" style="margin-top: 5px;" onclick="clearImg('myimage','myfile','isdelpic');">
										  	<s:hidden name="isdelpic" value="0" id="isdelpic"></s:hidden>
										  	
											<span class="help-inline">建议尺寸：宽720像素，高400像素,图片大小不超过300K</span>
										</span>
									</div>
                                </div>
                                
                                <div class="control-group">
                                    <label class="control-label" for="title">类型作用：</label>
                                    <div class="controls">
                                    <s:if test="bigtype.ttype==0">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0" checked="checked"/>分类类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/>文章/链接地址
                                    </s:if>
                                    <s:elseif test="bigtype.ttype==1">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0"/>分类类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/ checked="checked">文章/链接地址
                                    </s:elseif>
                                        
                                    
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="title">文章链接：</label>
                                    <div class="controls">
                                    	<s:textfield name="bigtype.linkurl" cssClass="input-xxlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="title">是否显示：</label>
                                    <div class="controls">
                                    <s:if test="bigtype.ison==1">
                                    	<input type="radio" name="bigtype.ison" value="1" checked="checked"/>显示&nbsp;&nbsp;<input type="radio" name="bigtype.ison" value="0"/>不显示
                                    </s:if>
                                    <s:else>
                                    	<input type="radio" name="bigtype.ison" value="1"/>显示&nbsp;&nbsp;<input type="radio" name="bigtype.ison" value="0" checked="checked"/>不显示
                                    </s:else>
                                     
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="title">排序编号：</label>
                                    <div class="controls">
                                    	<s:textfield name="bigtype.orderid" cssClass="input-mini" required="required"></s:textfield>
	                                    <span class="maroon">*</span>
                                    </div>
                                </div>

                                 
                                <div class="form-actions">
                                	<s:token></s:token>
                                    <button id="bsubmit" type="submit" data-loading-text="提交中..." class="btn btn-primary">保存</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<script type="text/javascript" src="js/comm.js"></script>