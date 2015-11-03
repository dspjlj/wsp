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
		<link rel="stylesheet" href="css/admin/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin/admin.css">
		<script type="text/javascript">var yyuc_jspath = "";</script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<title>自定义菜单</title>
		<style>
body {
	background-color: #ffffff;
}

.left {
	position: absolute;
	top: 140px;
	left: 20px;
	width: 258px;
	border-right: 1px solid #CCC;
	overflow-y: auto;
}

.right {
	position: absolute;
	top: 140px;
	left: 280px;
	width: 600px;
	overflow: auto;
}

.tree-menu {
	float: right;
}

.tree-menu span {
	margin-left: 6px;
}

.tree-menu span i {
	cursor: pointer;
}

.icon-plus {
	background-position: -408px -96px;
}

.icon-remove {
	background-position: -312px 0;
}

.icon-edit {
	background-position: -96px -72px;
}

#menu_tree {
	margin-right: 20px;
}

.right iframe {
	height: 100%;
	width: 100%;
	z-index: 20;
	border: 0;
	margin: 0 auto;
	display: block;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
}

li {
	line-height: 16px;
}

.om-tree-node a {
	display: inline-block; *
	display: inline; *
	zoom: 1;
	width: 115px;
	overflow: hidden;
	text-overflow: ellipsis;
}

#vip_tip {
	text-align: center;
}

.actions {
	position: absolute;
	bottom: 20px;
	left: 10px;
	width: 268px;
	border-right: 1px solid #CCC;
	height: 60px;
}

.actions .btn {
	position: relative;
	top: 30px;
}

.szcjbt,#czselarea,.zizicd {
	display: none;
}

.maincd {
	cursor: pointer;
}

.zizicd {
	width: 82px;
	height: 38px;
	border: 1px solid gray;
	margin-bottom: -1px;
	line-height: 38px;
	text-align: center;
	cursor: pointer;
	position: relative;
}
</style>

		<script type="text/javascript">
$(function(){
	$('.maincd').click(function(){
		suitdata();
		window.curcd = this;
		window.curctyp = '1';
		backdata();		
	});
	
	$('.zizicd').click(function(){
		suitdata();
		window.curcd = this;
		window.curctyp = '2';
		backdata();		
	});
	$('#answertype').change(function(){
		$('.szcjbt').hide();
		$('#'+$(this).val()).show();
	});
	
	$('.szcjbt').find('input,textarea,.editArea').on('keyup click change mouseup',function(){
		suitdata();
	});
	$(".editArea textarea").on("contentValueChange",suitdata);
	$('#cdmcinpo').on('keyup click change mouseup',function(){
		suitdata();
	});
	
	initthedata();
	$('.maincd').eq(0).trigger('click');
	
	$('.zizicd,.maincd').click(function(){
		$('.zizicd,.maincd').unmask();
		$(this).mask();
	});
});
//把菜单信息转化为控制信息
function backdata(){
	$('#res_ejcd').find('input[type="text"]').val('');
	$(".editArea div").html('');
	$('#xsejcdopt').remove();
	if(window.curctyp == '1'){
		$('#answertype').prepend('<option value="res_ejcd" id="xsejcdopt">显示二级菜单</option>');
	}
	var cdid = $(window.curcd).attr('id');
	var cddata = $.trim($(window.curcd).attr('reldata'));
	if(cddata!=''){
		cddata = $.evalJSON(cddata);
		$('#answertype').val(cddata.typ);
		$('#answertype').trigger('change');
		if(cddata.typ=='res_ejcd'){
			//回填菜单
			var zcddiv = $('div[zcdrel="'+cdid+'"]');
			if($.trim(cddata.data) !=''){
				var ds = cddata.data.split('@');
				zcddiv.find('.zizicd').hide();
				for(var i=0;i<ds.length;i++){
					$('#res_ejcd').find('input[type="text"]').eq(parseInt(ds[i])-1).val(zcddiv.find('.zizicd').eq(parseInt(ds[i])-1).show().text());
				}
			}			
		}else if($('#'+cddata.typ).find('input[type="radio"]').size()>0){
			 $('#'+cddata.typ).find('input[value="'+cddata.data+'"]').prop('checked',true);
		}else{
			$('#'+cddata.typ).find('input[type="text"]').val(cddata.data);
		}
		
	}else{
		cddata = {};
		if(window.curctyp == '1'){
			$('#answertype').val('res_ejcd');
		}else{
			$('#answertype').val('res_wb');
		}
		$('#answertype').trigger('change');
	}
	
	$('#czselarea').show();
	$('#cdmcinpo').val($(window.curcd).text());
}

//把控制信息回填到菜单中
function suitdata(){
	//console.log('hide1');
	if(window.curcd){
		var cdid = $(window.curcd).attr('id');
		var cddata = $.trim($(window.curcd).attr('reldata'));
		if(cddata!=''){
			//console.log('hide2');
			cddata = $.evalJSON(cddata);
		}else{
			//console.log('hide3');
			cddata = {};
		}
		cddata.typ = $('#answertype').val();
		
		var zcddiv = $('div[zcdrel="'+cdid+'"]');
		if(cddata.typ=='res_ejcd'){	
			//console.log('hide4');
			zcddiv.show();		
			//填充菜单
			var sjarr = [];
			$('#res_ejcd').find('input[type="text"]').each(function(i){
				//console.log('hide5');
				var temp_zcd = zcddiv.find('.zizicd').eq(i);
				if($.trim($(this).val())!=''){
					//console.log('hide6');					
					temp_zcd.text($.trim($(this).val())).show();
					sjarr[sjarr.length] = i+1;
				}else{
					//console.log('hide7');
					temp_zcd.hide();
				}
			});
			cddata.data = sjarr.join('@');
		}else{
			//console.log('hide8');
			zcddiv.hide();
			if($('#'+cddata.typ).find('input:checked').size()>0){
				//console.log('hide9');
				cddata.data = $('#'+cddata.typ).find('input:checked').val();
			}else{
				//console.log('hide10');
				cddata.data = $('#'+cddata.typ).find('input[type="text"]').val();
			}
			
		}
		$(window.curcd).text($('#cdmcinpo').val());
		$(window.curcd).attr('reldata',$.toJSON(cddata));
	}
}

function savedata(fun){
	var alldata = [];
	$('.maincd').each(function(i){
		var cddata = $.evalJSON($.trim($(this).attr('reldata')));
		var cdid = $(this).attr('id');
		cddata.tit = $.trim($(this).text());
		if(cddata.typ=='res_ejcd'){
			//回填菜单
			var zcddiv = $('div[zcdrel="'+cdid+'"]');
			if($.trim(cddata.data) !=''){
				var ds = cddata.data.split('@');
				cddata.subdata = {};
				for(var i=0;i<ds.length;i++){
					var ind = parseInt(ds[i])-1;
					var zcd = zcddiv.find('.zizicd').eq(ind);
					var ttstr = $.trim(zcd.attr('reldata'));
					var ssdata = {};
					if(ttstr != ''){
						ssdata = $.evalJSON(zcd.attr('reldata'));
					}
					 
					ssdata.tit = $.trim(zcd.text());
					cddata.subdata['zizicd'+ds[i]] = ssdata;
				}
			}			
		}
		alldata[alldata.length] = cddata;
	});
	loading('数据保存中...');
	console.log($.toJSON(alldata));
	
	ajax('custommenuAction!muladd',{ id:$('body').attr('menuid'),data:$.toJSON(alldata)},function(m){
		alert('保存成功');
		loading(false);
		if(fun){
			fun();
		}
	});
}

function fbcaidan(){
	savedata(function(){
		loading('菜单发布中...');
		ajax('custommenuAction!deploy',null,function(m){
			if(m=='nosec'){
				alert('授权配置不正确');
			}else if(m=='ok'){
				alert('菜单发布成功');				
			}else{
				alert(m);				
			}
			loading(false);
		});
	});
}

function initthedata(){
	var idata = $.trim($('#initdatat').val());
	if(idata !=''){
		var csdata = $.evalJSON(idata);
		for(var i=0;i<csdata.length;i++){
			var mcd = $('.maincd').eq(i);
			var zcddiv = $('div[zcdrel="'+mcd.attr('id')+'"]');
			var cdjda = csdata[i];
			if(cdjda.typ=='res_ejcd'){
				for(var ejcd in cdjda.subdata){
					zcddiv.find('[rel="'+ejcd+'"]').attr('reldata',$.toJSON(cdjda.subdata[ejcd])).text(cdjda.subdata[ejcd].tit).show();
				}
			}
			cdjda.subdata = null;
			mcd.attr('reldata',$.toJSON(cdjda));
			mcd.text(cdjda.tit);			
		}
	}
}
</script>
	</head>

	<body menuid="3599">
		<textarea style="display: none;" id="initdatat">
		[{"typ":"res_ejcd","data":"","tit":"菜单一","subdata":null},{"typ":"res_ejcd","data":"","tit":"菜单二","subdata":null},{"typ":"res_ejcd","data":"","tit":"菜单三","subdata":null}]
		</textarea>
		<div class="main-title">
			<h3>
				自定义菜单设置
			</h3>
		</div>
		<div id="top" class="alert alert-info" style="margin: 0 0;">
			1.使用本模块，必须在微信公众平台
			<strong>申请</strong>自定义菜单使用的
			<strong>AppId和AppSecret</strong>，然后在【授权设置】中设置。
			<br />
			2.最多创建
			<span class="red bold">3 个一级菜单</span>，每个一级菜单下最多可以创建
			<span class="red bold">5 个二级菜单</span>，菜单
			<span class="red bold">最多支持两层</span>。
		</div>
		<div>
			<table>
				<tr>
					<td>
						<div
							style="background-image: url('media/images/cusmenu/3CustomLt.png'); width: 344px; height: 623px; position: relative;">

							<div
								style="position: absolute; bottom: 170px; left: 46px; width: 82px;"
								zcdrel="maincd1">
								<div class="zizicd" rel="zizicd1">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd2">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd3">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd4">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd5">
									子菜单
								</div>
							</div>

							<div
								style="position: absolute; bottom: 170px; left: 131px; width: 83px;"
								zcdrel="maincd2">
								<div class="zizicd" rel="zizicd1">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd2">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd3">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd4">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd5">
									子菜单
								</div>
							</div>

							<div
								style="position: absolute; bottom: 170px; left: 216px; width: 83px;"
								zcdrel="maincd3">
								<div class="zizicd" rel="zizicd1">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd2">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd3">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd4">
									子菜单
								</div>
								<div class="zizicd" rel="zizicd5">
									子菜单
								</div>
							</div>
							<div style="position: absolute; bottom: 122px; left: 43px;">
								<table style="border: none;" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<div
												style="height: 45px; width: 85px; line-height: 45px; text-align: center;"
												id="maincd1" reldata="" class="maincd">
												菜单一
											</div>
										</td>
										<td>
											<div
												style="height: 45px; width: 87px; line-height: 45px; text-align: center;"
												id="maincd2" reldata="" class="maincd">
												菜单二
											</div>
										</td>
										<td>
											<div
												style="height: 45px; width: 85px; line-height: 45px; text-align: center;"
												id="maincd3" reldata="" class="maincd">
												菜单三
											</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</td>
					<td valign="top">
						<br />
						<div style="position: relative; width: 100%">
							<button class="btn btn-big btn-primary" id="sync"
								onclick="fbcaidan()">
								发布菜单
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-big btn-primary" id="stop">
								停用菜单
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-big btn-primary" id="saveOrder"
								onclick="savedata()">
								保存菜单数据
							</button>
						</div>
						<br />
						<div id="czselarea">
							<div id="top" class="alert alert-info"
								style="line-height: 16px; padding-bottom: 0px;">
								菜单名称：
								<input type="text" id="cdmcinpo" style="margin-top: 6px;">
							</div>
							<div class="control-group">
								<label class="control-label" for="answertype">
									菜单点击事件:
								</label>
								<div class="controls">
									<select class="span2" id="answertype" name="answertype">
										<option value="res_ejcd" id="xsejcdopt">
											显示二级菜单
										</option>
										<option value="res_wb">
											文本
										</option>
										<option value="res_music">
											音乐
										</option>
										<option value="res_tw">
											图文
										</option>
										<option value="res_url">
											地址链接
										</option>

									</select>
								</div>
							</div>
						</div>


						

						<!-- 二级菜单 -->
						<div class="szcjbt" id="res_ejcd">
							<div id="top" class="alert alert-info">
								至少填写一项子菜单
							</div>

							<span class="res_ejcd_1"> <label class="control-label"
									for="answertype">
									菜单一:
								</label> <input type="text"> </span>
							<br />
							<span class="res_ejcd_2"> <label class="control-label"
									for="answertype">
									菜单二:
								</label> <input type="text"> </span>
							<br />
							<span class="res_ejcd_3"> <label class="control-label"
									for="answertype">
									菜单三:
								</label> <input type="text"> </span>
							<br />
							<span class="res_ejcd_4"> <label class="control-label"
									for="answertype">
									菜单四:
								</label> <input type="text"> </span>
							<br />
							<span class="res_ejcd_5"> <label class="control-label"
									for="answertype">
									菜单五:
								</label> <input type="text"> </span>
							<br />
						</div>
						<!-- 文本 -->
						<div class="szcjbt" id="res_wb">
							<table class="table table-bordered">
								<tr>
									<th style="width: 50px;">
										请选择
									</th>
									<th>
										文本标题
									</th>
								</tr>
								<s:iterator value="fodders" var="fodder" status="index1">
									<s:if test="savetype==1">
									<tr>
										<td>
											<input type="radio" name="rad_wb" value="<s:property value="id"/>">
										</td>
										<td>
											<s:property value="title"/>
										</td>
									</tr>
									</s:if>
								</s:iterator>
							</table>
						</div>

						<!-- 音乐 -->
						<div class="szcjbt" id="res_music">
							<table class="table table-bordered">
								<tr>
									<th style="width: 50px;">
										请选择
									</th>
									<th>
										音乐标题
									</th>
								</tr>
								<s:iterator value="fodders" var="fodder" status="index2">
									<s:if test="savetype==5">
										<tr>
											<td>
												<input type="radio" name="rad_music" value="<s:property value="id"/>">
											</td>
											<td>
												<s:property value="title"/>
											</td>
										</tr>
									</s:if>
								</s:iterator>
							</table>
						</div>

						<!-- 图文 -->
						<div class="szcjbt" id="res_tw">
							<table class="table table-bordered">
								<tr>
									<th style="width: 50px;">
										请选择
									</th>
									<th>
										图文标题
									</th>
								</tr>
								<s:iterator value="fodders" var="fodder" status="index3">
									<s:if test="savetype==6">
										<tr>
											<td>
												<input type="radio" name="rad_tw" value="<s:property value="id"/>">
											</td>
											<td>
												<s:property value="title"/>
											</td>
										</tr>
									</s:if>
								</s:iterator>
							</table>
						</div>

						<!-- URL  -->
						<div class="szcjbt" id="res_url">
							要链接到的URL地址：
							<input type="text" name="event_url">
						</div>
						
					</td>
				</tr>
			</table>


		</div>




		<br />
		<br />
		<br />
	</body>
</html>