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
                                <h3><i class="icon-cog"></i>微官网--类别管理--修改分类</h3>
                            </div>
                        </div>
                        <div class="box-content">
                            <form action="bigtypeAction!update" method="post" class="form-horizontal form-validate" enctype="multipart/form-data">
                                <s:hidden name="bigtype.wgw.id"></s:hidden>
                                <s:if test="bigtype.bigtype!=null">
                                	<s:hidden name="bigtype.bigtype.id"></s:hidden>
                                </s:if>
                                <s:hidden name="bigtype.imageurl"></s:hidden>
                                <s:hidden name="bigtype.id"></s:hidden>
                                <div class="control-group">
                                    <label class="control-label" for="keyword">类别名:</label>
                                    <div class="controls">
                                    	<s:textfield name="bigtype.name"  cssClass="input-medium" required="required"></s:textfield>
										<span class="maroon">*</span>
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">是否子类别：</label>
                                    <div class="controls">
                                    <s:if test="bigtype.isend==1">
                                    	<input type="radio" name="bigtype.isend" value="1" checked="checked"/>是&nbsp;&nbsp;<input type="radio" name="bigtype.isend" value="0"/>不是
                                    </s:if>
                                     <s:else>
                                     	<input type="radio" name="bigtype.isend" value="1"/>是&nbsp;&nbsp;<input type="radio" name="bigtype.isend" value="0" checked="checked"/>不是
                                     </s:else>
                                     
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="title">简称：</label>
                                    <div class="controls">
		 							 <s:textfield name="bigtype.enname"  cssClass="input-medium" required="required"></s:textfield>                                     <span class="maroon">*</span>
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
											<span class="help-inline">建议尺寸：宽720像素，高400像素,图片大小不超过300K</span>
										</span>
									</div>
                                </div>
                                
                                <div class="control-group">
                                    <label class="control-label" for="title">类型作用：</label>
                                    <div class="controls">
                                    <s:if test="bigtype.ttype==0">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0" checked="checked"/>首页类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/>文章/链接地址
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="2"/>一键导航
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="3" />一键预约
                                    </s:if>
                                    <s:elseif test="bigtype.ttype==1">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0"/>首页类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/ checked="checked">文章/链接地址
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="2"/>一键导航
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="3" />一键预约
                                    </s:elseif>
                                    <s:elseif test="bigtype.ttype==2">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0"/>首页类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/>文章/链接地址
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="2" checked="checked"/>一键导航
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="3" />一键预约
                                    </s:elseif>
                                    <s:elseif test="bigtype.ttype==3">
                                    	&nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="0"/>首页类别
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="1"/>文章/链接地址
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="2"/>一键导航
                                        &nbsp;&nbsp;<input type="radio" name="bigtype.ttype" value="3"  checked="checked"/>一键预约
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