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
  <title>第三屏—国内免费的微信公众服务平台!</title>
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
              <div class="span6">
                <h3> <i class="icon-table"></i>
                  微信公众帐号管理
                </h3>
              </div>

              <div>
                <marquee onMouseOut="this.start()" onMouseOver="this.stop()" align="middle"> <font size=+3 color=red>为了您使用本系统畅快无阻，请勿使用360浏览器及IE的8.0以下版本。推荐：谷歌浏览器&nbsp;&nbsp;</font>
                  <a href="http://w.x.baidu.com/alading/anquan_soft_down_ub/14744" target="_blank">点此处下载</a>
                </marquee>
              </div>

            </div>

            <div class="box-content nozypadding">
              <div class="row-fluid">
                <div class="span8 control-group">
                  <a class="btn" href="pubclient_add.jsp"> <i class="icon-plus"></i>
                    添加公众帐号
                  </a>
                  <a href="http://wpa.qq.com/msgrd?v=3&uin=793495478&site=qq&menu=yes" target="_blank" class="btn btn-warning" style="cursor:pointer">在线咨询</a>
                </div>

              </div>

              <div class="row-fluid dataTables_wrapper">
                <div class="alert"> <strong>温馨提示</strong>
                  ：您还有0个微信公众号配额，请珍惜使用名额！
                  <span class="line">第三屏助手QQ：793495478&nbsp;&nbsp;&nbsp;全国招商加盟火热进行中</span>
                </div>
                
                  <table id="listTable" class="table table-hover table-nomargin table-bordered usertable dataTable">
                    <thead>
                      <tr>

                        <th width="290">公众号名称</th>
                        <th width="150">公众号类型</th>
                        <th>创建时间/到期时间</th>
                        <th>会员套餐</th>
                        <th>已定义/上限</th>
                        <th>请求数</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator value="pubclients" var="pubclient" status="index">
                      <tr>
                        <td style="text-align:center;">
                        	<s:if test="imgurl!=null&&imgurl!=''">
                        		<img class="thumb_img" src="../<s:property value="imgurl"/>" id="pic_apartpic" style="max-width:80px" />
                        	</s:if>
                        	<s:else>
                        		<i class="icon-user"></i>
                        	</s:else>
                          	<s:property value="publicname"/>
                          <br />
                        </td>
                        <td>
                        	<s:if test="accounttype==0">
                        		订阅号
                        	</s:if>
                        	<s:elseif test="accounttype==1">
                        		已认证订阅号
                        	</s:elseif>
                        	<s:elseif test="accounttype==2">
                        		服务号
                        	</s:elseif>
                        	<s:elseif test="accounttype==3">
                        		已认证服务号
                        	</s:elseif>
                        </td>
                        <td style="text-align:left;" width="160">
	                          创建时间:<s:date name="createdate" format="yyyy-MM-dd"/>
	                          <br/>
	                          到期时间:<s:date name="deaddate" format="yyyy-MM-dd"/>
                        </td>
                        <td align="center">
                        	<s:if test="protype==1">
                        		基础版会员
                        	</s:if>
                        	<s:elseif test="protype==2">
                        		升级版会员
                        	</s:elseif>
                        </td>
                        <td>
	                          文本：不限
	                          <br />
	                          图文：不限
	                          <br />
	                          语音：不限
	                          <br />
	                       LBS : 不限
	                          <br />
                        </td>

                        <td>不限</td>
                        <td>
                          <a href="pubclientAction!load?id=<s:property value="id"/>" class="btn" rel="tooltip" title="编辑" style="display: block;width: 70px;">
                            <i class="icon-edit"></i>
                            编辑
                          </a>
                          <a href="pubclientAction!loadbind?id=<s:property value="id"/>" class="btn" rel="tooltip" title="绑定" style="display: block;margin-top: 10px;width: 70px;">
                            <i class="icon-edit"></i>
                            绑定
                          </a>
                          
                          <a  href="javascript:;" onClick="parent.location.href='pubclientAction!loadpubfun?id=<s:property value="id"/>'" class="btn" rel="tooltip" title="管理" style="display: block;margin-top: 10px;width: 70px;">
                            <i class="icon-cog"></i>
                            管理
                          </a>
                          
                          <a href="pubclientAction!delete?id=<s:property value="id"/>&page=<s:property value="page"/>" onclick="return delpubclient();" class="btn" rel="tooltip" title="删除" style="display: block;margin-top: 10px;width: 70px;">
                            <i class="icon-remove"></i>
                            删除
                          </a>
                        </td>
                      </tr>
					</s:iterator>
                    </tbody>

                  </table>
                  <div class="dataTables_paginate paging_full_numbers">
                    <span></span>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
    <script type="text/javascript">
function delchat(uid,o){
  if(confirm('您确定要删除此公众帐号吗?')){
    ajax('delete?publicid='+uid+'',null,function(m){
      if(m=='ok'){
        tusi('公众号删除成功');
        setTimeout(function(){
          goto(location.href);
        },1500);
      }
    });
  }
}

function delpubclient(){
	if(confirm('您确认删除该公众号吗？')){
		if(confirm('公众号将无法恢复，您确定？')){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}
</script>
    

</body>
  </html>