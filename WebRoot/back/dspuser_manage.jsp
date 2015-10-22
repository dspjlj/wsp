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
                  用户管理
                </h3>
              </div>

              

            </div>

            <div class="box-content nozypadding">
              <div class="row-fluid">
                <div class="span8 control-group">
                  <a class="btn" href="dspuser_add.jsp"> <i class="icon-plus"></i>
                    添加用户
                  </a>
                  <a href="http://wpa.qq.com/msgrd?v=3&uin=793495478&site=qq&menu=yes" target="_blank" class="btn btn-warning" style="cursor:pointer">在线咨询</a>
                </div>

              </div>

              <div class="row-fluid dataTables_wrapper">
                <div class="alert"> <strong>温馨提示</strong>
                  ：您还有0个用户配额，请珍惜使用名额！
                  <span class="line">&nbsp;&nbsp;&nbsp;全国招商加盟火热进行中</span>
                </div>
                
                  <table id="listTable" class="table table-hover table-nomargin table-bordered usertable dataTable">
                    <thead>
                      <tr>

                        <th>账号名称</th>
                        <th>真实姓名</th>
                        <th>手机号码</th>
                        <th>QQ</th>
                        <th>注册日期</th>
                        <th>账号状态</th>
                        <th>权限级别</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="dspusers" var="dspuser" status="index">
                      <tr>
                        <td>
                          	<s:property value="username"/>
                        </td>
                        <td>
                        	<s:property value="realname"/>
                        </td>
                        <td>
                          	<s:property value="phone"/>
                        </td>
                        <td>
                        	<s:property value="qq"/>
                        </td>
                        <td>
                          	<s:date name="regdate" format="yyyy-MM-dd"/>
                        </td>
                        <td>
                        	<s:if test="ison==0">
								冻结
							</s:if>
							<s:elseif test="ison==1">
								正常
							</s:elseif>
							<s:elseif test="ison==2">
								体验模式
							</s:elseif>
                        </td>
                        <td>
							<s:if test="limits==0">
								管理员
							</s:if>
							<s:elseif test="limits==1">
								高级用户
							</s:elseif>
							<s:elseif test="limits==2">
								普通用户
							</s:elseif>
						</td>

                        <td>
                          <a href="dspuserAction!load?id=<s:property value="id"/>" class="btn" rel="tooltip" title="编辑" style="display: block;margin: 5px;width: 70px;float: left;">
                            <i class="icon-edit"></i>
                            编辑
                          </a>
                          <a href="dspuserAction!freeze?id=<s:property value="id"/>&status=0&page=<s:property value="page"/>" onclick="return confirm('您确认冻结该用户吗？')" class="btn" rel="tooltip" title="冻结" style="display: block;margin: 5px;width: 70px;float: left;">
                            <i class="icon-remove"></i>
                            冻结
                          </a>
                          <!-- 
                          <a  href="javascript:;" onClick="parent.location.href='main2.html'" class="btn" rel="tooltip" title="管理" style="display: block;margin: 5px;width: 70px;float: left;">
                            <i class="icon-cog"></i>
                            管理
                          </a>
                           -->
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
</script>
    

</body>
  </html>