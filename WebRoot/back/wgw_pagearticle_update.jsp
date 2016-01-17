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

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="pagearticle.description"]', {
                cssPath : 'kindeditor/plugins/code/prettify.css',
                uploadJson : 'kindeditor/jsp/upload_json.jsp',
                fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>

<script type="text/javascript" src="js/toolKit.js"></script>
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
                                <h3><i class="icon-cog"></i>微官网--文章管理--修改文章</h3>
                            </div>
                        </div>
                        <div class="box-content">
                            <form action="pagearticleAction!update" method="post" class="form-horizontal form-validate" enctype="multipart/form-data">						
                                <s:hidden name="pagearticle.id"></s:hidden>
                                <s:hidden name="pagearticle.imageurl"></s:hidden>
                                <s:hidden name="pagearticle.createtime"></s:hidden>
                                
                                <div class="control-group">
                                    <label class="control-label" for="keyword">所属子类别:</label>
                                    <div class="controls">
                                    	<s:select list="bigtypes" name="pagearticle.bigtype.id" listKey="id" listValue="name"></s:select>
                                        <span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="keyword">文章标题:</label>
                                    <div class="controls">
										<s:textfield name="pagearticle.name" cssClass="input-xlarge" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">标题简称：</label>
                                    <div class="controls">
		 							 	<s:textfield name="pagearticle.shortname" cssClass="input-xlarge" ></s:textfield>
                                    </div>
                                </div>
                             
                                <div class="control-group">
                                    <label class="control-label" for="keyword">文章类型:</label>
                                    <div class="controls">
                                    	<s:select list="#{1:'产品介绍',2:'新闻活动',0:'其他'}" name="pagearticle.articletype" listKey="key" listValue="value"></s:select>
                                        <span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="cover">封面图片：</label>
									  <div class="controls">
										<s:if test="pagearticle.imageurl!=null&&pagearticle.imageurl!=''">
									  		<img class="thumb_img" src="<%=basePath %><s:property value="pagearticle.imageurl"/>" id="myimage" style="max-height:100px;" />
									  		
									  	</s:if>
									  	<s:else>
									  		<img class="thumb_img" src="images/noimg.jpg" id="myimage" style="max-height:100px;" />
									  	</s:else>
											<span class="help-inline">
											<s:file name="picture" cssStyle="width:80%" onchange="changePreImg();" title="上传" id="myfile"></s:file>
											<span class="help-inline">建议尺寸：宽720像素，高400像素,图片大小不超过300K</span>
										</span>
									</div>
                                </div>
                                

                                
                                <div class="control-group">
                                    <label class="control-label" for="brief">文章正文</label>
                                    <div class="controls">
                                          
                                        <textarea name="pagearticle.description" id="pagearticle_description" class="input-large" style="height:320px;width:700px;visibility:hidden;">
                                        <s:property value="pagearticle.description"/>
                                        </textarea>
                                        <span class="help-block">500文字以内</span>
                                    </div>
                                </div>

								<div class="control-group">
                                    <label class="control-label" for="title">视频代码：</label>
                                    <div class="controls">
                                     <s:textfield name="pagearticle.videourl" cssClass="input-xxlarge"></s:textfield>
                                     <span class="maroon">提示：请先上传视频到优酷、土豆,再复制代码到这里;说明：高度height、宽度width</span>
                                    </div>
                                </div>

								<div class="control-group">
                                    <label class="control-label" for="title">友情链接：</label>
                                    <div class="controls">
                                     	<s:textfield name="pagearticle.linkurl" cssClass="input-xxlarge"></s:textfield>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="title">是否启用：</label>
                                    <div class="controls">
	                                    <s:if test="pagearticle.ison==1">
	                                    	<input type="radio" name="pagearticle.ison" value="1" checked="checked"/>启用&nbsp;&nbsp;<input type="radio" name="pagearticle.ison" value="0"/>不启用
	                                    </s:if>
                                     	<s:else>
                                     		<input type="radio" name="pagearticle.ison" value="1" />启用&nbsp;&nbsp;<input type="radio" name="pagearticle.ison" value="0" checked="checked"/>不启用
                                     	</s:else>
                                    </div>
                                </div>

								<div class="control-group">
                                    <label class="control-label" for="title">友情链接：</label>
                                    <div class="controls">
                                     	<%=basePath %>pagearticleAction!frontView?id=<s:property value="pagearticle.id"/>&wgwid=<s:property value="pagearticle.bigtype.wgw.id"/>
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