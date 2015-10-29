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
		<title>地理位置定位</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<link rel="stylesheet" href="css/admin/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin/admin.css">
		<style type="text/css">
table td {
	min-width: 50px;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>

		<script>

$(function() {
	$("#gotonext").click(function(){
		window.parent.$('.menu-youhui').trigger('click');
	});
});


function dellbs(id,o){
	if(id=='a'){
		if(confirm('确定删除这些lbs信息吗？')){
			var ids = [];
			$('td').find('input[type="checkbox"]:checked').each(function(){
				ids[ids.length] = $(this).val();
			});
			ajax('lbsAction!deleteids',{ id:ids.join(',')},function(){
				$('td').find('input[type="checkbox"]:checked').each(function(){
					$(this).parent().parent().remove();
				});
			});	
		}
	}else{
		if(confirm('确定删除此条lbs信息吗？')){
			ajax('lbsAction!delete',{ id:id},function(){
				$(o).parent().parent().parent().remove();
			});	
		}
	}	
}

function selallck(o){
	if($(o).prop('checked')){
		$('td').find('input[type="checkbox"]').prop('checked',true);
	}else{
		$('td').find('input[type="checkbox"]').prop('checked',false);
	}
}
</script>
		<title>商家位置设置</title>
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
	</head>
	<body>
		<div id="questionsContainer">
			<h3>
				商家位置设置
			</h3>
			<div class="tb-toolbar">
				<button class="btn btn-small btn-primary"
					onclick="goto('lbs_add.jsp')" id="add">
					新增
				</button>
				<button class="btn btn-small" onclick="dellbs('a',this)" id="del">
					删除
				</button>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="width: 10px;">
							<input type="checkbox" onclick="selallck(this);">
						</th>
						<th>
							商家名称
						</th>
						<th>
							商家类别
						</th>
						<th>
							商家地址
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="%{lbss.size()==0}">
						<tr>
							<td colspan="5" style="text-align: center;">
								暂无信息
							</td>
						</tr>
					</s:if>
					<s:iterator value="lbss" var="lbs" status="index">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="<s:property value="id"/>">
						</td>
						<td>
							<s:property value="name"/>
						</td>
						<td botid="19979">
							<s:property value="bigtype"/>-<s:property value="sontype"/>
						</td>
						<td>
							<s:property value="address"/>
						</td>
						<td>
							<span> [ <a href="lbsAction!load?id=<s:property value="id"/>">修改</a> ] </span>
							<span> [ <a href="lbsAction!delete?id=<s:property value="id"/>&page=<s:property value="page"/>"
								onclick="return confirm('你确定删除该信息吗？');">删除</a> ] </span>
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>


		<br />
		<br />
		<br />
	</body>
</html>