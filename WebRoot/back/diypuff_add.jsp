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
<link rel="shortcut icon" href="favicon.ico" />
<style type="text/css">
.yulan {
    background: url(res/erweima/erweimabg.png) repeat scroll 0 0 #4E5359;
    color: #666666;
    font:14px/1.5  Microsoft YaHei,Helvitica,Verdana,Tohoma,Arial,san-serif;
    margin: 0;
    padding: 0;
color: #666666;
}
.yulan .main{ margin:0 ; }
.yulan h1{ font-size:20px; color:#f5f5f5; font-weight:normal;  margin:20px 100px 10px 80px; text-shadow:0 1px 3px #111111;}
.yulan .erweima{height: 250px;
    margin-left: 100px ;
    width: 250px;}
.yulan .erweima img{border: medium none;
-moz-box-shadow: 0 4px 3px 2px #333333;
-webkit-box-shadow: 0 4px 3px 2px #333333;
    box-shadow: 0 4px 3px 2px #333333;
-webkit-border-radius:6px;
-moz-border-radius:6px;
border-radius:6px;
    width: 100%;}
.yulan .beizhu{ margin:15px auto 5px;text-align: center;}
.yulan .beizhu p{ line-height: 48px;}
.yulan .beizhubg{color: #B4B7BC;background: url(res/erweima/erweima_bg2.png) repeat-x scroll 0 0 transparent;
    font-size: 12px;
    height: 48px;
    margin: 10px auto;
    width: 230px;text-shadow: 0 -1px 0 #111112;
line-height: 48px;display: inline-block;position: relative;}
.yulan .beizhuleft{background: url(res/erweima/erweima_bg2_left.png) no-repeat scroll 0 0 transparent;
    display: block;
    float: left;
    height: 48px;
    margin-left: -26px;
    width: 26px;}
.yulan .beizhuright{ background: url(res/erweima/erweima_bg2_right.png) no-repeat scroll 0 0 transparent;
    display: block;
    float: right;
    height: 48px;
    margin-right: -26px;
    width: 26px;}
.yulan .content{color: #B4B7BC; font-size:14px;padding:5px;width:300px; margin:0 auto;text-shadow: 0 -1px 0 #111112;
float:none; background-color:transparent;min-height:40px;border:0;
}
.yulan .footer {
background: url(res/erweima/erweimabg.png) repeat scroll 0 0  transparent;
    color: #AAAAAA;
    margin:20px auto 0;
    text-shadow: 0 -1px 0 #111111;
text-align:center;
line-height: 48px;
width: 100%;
padding:0;
}
.yulan .footer p{
    background: url(res/erweima/erweima_footer.png) no-repeat scroll center top transparent;
font-size:12px;line-height: 48px;
}
</style>
</head>
<body class="theme-blue">
    <div id="main">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span12">
                                <h3><i class="icon-cog"></i>宣传页设置</h3>
                            </div>
                        </div>
                        <div class="box-content">
						    <table class="userinfoArea" style=" margin:0;" border="0" cellspacing="0" cellpadding="0" width="100%"><tbody>
<tr>
<td width="50%">
                            <form action="" method="post" class="form-horizontal form-validate"><input type="hidden" value="54d867788a4cf" name="YYUC_FORM_TOKEN"/><input type="hidden" value = "" name="TgRbQ1k+AQgcPV5QThJeR1c2C10=" id="weiqi_diy_keywordid" />								<input type="hidden" name="aid" id="aid" value="33260"/>
                                <div class="control-group">
                                    <label class="control-label" for="title">宣传页标题：</label>
                                    <div class="controls">
		 							 <input type="text"   value="" name="TgRbQ1k+AQgcPV5QThJeR1c2DFgMUw==" id="weiqi_diy_keywordname" class="input-xlarge" required="required"/>                                     <span class="maroon">*</span>
                                    </div>
                                </div>
                             
                                

                                <div class="control-group">
                                    <label class="control-label" for="cover">二维码设置</label>
									  <div class="controls">
										<img class="thumb_img" src="" id="pic_pic" style="max-height:100px;" />
										<input type="hidden" value = "" name="TgRbQ1k+AQgcPV5QThJeR1c2ElAC" id="weiqi_diy_keywordpic" />										<span class="help-inline">
											<button class="btn select_img" type="button" onClick="setpic('pic_pic','weiqi_diy_keywordpic');">选择二维码</button>
											<span class="help-inline">到公众平台下载二维码边长为12CM，大小为344×344PX,图片大小不超过300K</span>
										</span>
									</div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="brief">功能介绍</label>
                                    <div class="controls">
										<textarea name="TgRbQ1k+AQgcPV5QThJeR1c2D0o="   id="weiqi_diy_keywordms" class="input-large" style="height:80px;width:380px;"></textarea>	
                                        <span class="maroon">*</span>
                                        <span class="help-block">150文字以内</span>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label" for="brief">版权信息</label>
                                    <div class="controls">
										<textarea name="TgRbQ1k+AQgcPV5QThJeR1c2AFgPR0VTCw=="   id="weiqi_diy_keywordbanquan" class="input-large" style="height:40px;width:380px;"></textarea>	
                                        <span class="maroon">*</span>
                                        <span class="help-block">15文字以内</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="brief">链接地址</label>
                                    <div class="controls">
									http://www.di3p.com/weiqidiy/diy.html?wid=10652                                    </div>
                                </div>
                                <input type="hidden" name="id" value="47">
                                <div class="form-actions">
                                    <button id="bsubmit" type="submit" data-loading-text="提交中..." class="btn btn-primary">保存</button>         <a href="http://www.di3p.com/weiqidiy/diy.html?wid=10652" target="_blank"  class="btn btn-primary ">查看推广页</a>
                                </div>
                            </form>
							
							</td>
					
							<td rowspan="6" valign="top" class="yulan" width="38%">
<div class="main1">
<h1 id="adtitle" align="center"></h1>
<div class="erweima"><img id="gzhewm" src=""></div>
<div class="beizhu">
<div class="beizhubg">
<div class="beizhuleft"></div>
<div class="beizhuright"></div>
<p>请使用微信扫描二维码关注此公众号</p>
</div>
</div>
</div>
<div class="content" id="gzhinfo">
       </div>
<div class="clr"></div>
<div class="footer"><p id="gzhcopyright"></p></div>
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