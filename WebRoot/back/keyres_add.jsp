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
<title>第三屏—国内免费的微信公众服务平台</title>
<script type="text/javascript">var yyuc_jspath = "";</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue" data-theme="theme-blue">
	
    <div id="main">
        <div class="container-fluid">

            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span10">
                                <h3><i class="icon-edit"></i>添加关键字</h3>
                            </div>
                            <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                        </div>

                        <div class="box-content">

							<script type="text/javascript">
    $(function(){
    	$('input[name="hflx"]').click(function(){
    		var val = $('input[name="hflx"]:checked').val();
    		$('#answertype').val(val).trigger('change');
    		if(val=='1'){
    			 openscset();
    		}
    	});
    });
    
    function openscset(){
		pophtml('<iframe src="fodderAction!choosefodder?currentpage=keyres_add" style="width:880px;height:470px;border:none;background-color: #dfdfdf;" width="880px" height="475px"></iframe>',920,510,true);
	}
    
    function setselid(id){
    	$('input[relval="'+id+'"]').prop('checked',true);
    	$('#multiArticle11if').attr('src','/admin/baseService/contresourceshowone-'+id+'.html');
    	
    }
    </script>
                            <form id="keyresform" action="keyresAction!add" method="post" class="form-horizontal form-validate" novalidate="novalidate">
                                <s:hidden name="keyres.publickey.id" value="%{#session.pkid}"></s:hidden>
                                
                                <div class="control-group">
                                    <label for="name" class="control-label" style="text-align: right;margin-top: -4px;">选择素材 :</label>
                                    <div class="controls">
                                    	<s:textfield name="sucainame" value="%{#session.sucainame}" cssClass="input-xlarge" readonly="true" />
	  									
	  									<input type='button' class="coolbg np" onClick="openscset();" value='选择' style="width:80" />
      									<s:hidden name="keyres.fodderid" value="%{#session.fodderid}"></s:hidden>
      									
                                    	<span class="maroon">*</span><span class="help-inline"></span>
									</div>
                                </div>
                                
                                <div class="control-group">
								  <label class="control-label" for="answertype" style="text-align: right;margin-top: -4px;">关键字 :</label>
								    <div class="controls">
								    <s:textfield name="keyres.keytitle"></s:textfield>
									 <div>
								  	<span class="maroon">*</span> 必填
						      	     </div>
								   </div>
								  
							  	</div> 
								<div class="control-group">
								  <label class="control-label" for="answertype" style="text-align: right;margin-top: -4px;">匹配类型 :</label>
								    <div class="controls">
								    <s:select list="#{1:'模糊匹配',2:'全匹配'}" name="keyres.matchtype" cssClass="span2"></s:select>
									 <div>全匹配是对话完全一致才能触发，模糊匹配是是要包含就触发。</div>
								   </div>
								  
							  	</div>   
                                
                                
                                
                                
								
                                <div class="form-actions">
                                	<s:token></s:token>
                                    <button type="submit" class="btn btn-primary">保存</button>
                                    <a class="btn" href="Javascript:document.getElementById('keyresform').reset();">取消</a>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

<div id="fallr-overlay"></div>
<br/><br/><br/>
</body>
</html>