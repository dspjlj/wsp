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

#picsethere {
	width: 510px;
	display: block;
}

#picsethere img {
	max-width: 500px;
	display: block;
}
</style>

		<script
			src="http://api.map.baidu.com/api?v=1.5&ak=1b0ace7dde0245f796844a06fb112734"></script>
		<script type="text/javascript" src="js/jsAddress.js"></script>
		<script type="text/javascript" src="js/toolKit.js"></script>
	</head>
	<body>
		<h3>
			商家LBS修改
		</h3>
		<div class="alert alert-info">
			<p>
				<span class="bold">说明：</span>开启LBS功能后用户可在微信上发送地理位置获取商家的地理位置信息。
			</p>
			<p>
				<span class="bold">地图地址(参数可自行替换)：</span>
				<br />
			</p>
		</div>
		<form class="form-horizontal" id="lbsForm" action="lbsAction!add" method="post" enctype="multipart/form-data">
			<s:hidden name="lbs.xylocation" id="xylocation"></s:hidden>
			<div class="control-group">
				<label class="control-label" for="keyword">
					商家名称
				</label>
				<div class="controls">
					<s:textfield name="lbs.name" id="lbsname" cssClass="span4"></s:textfield>
					<span class="maroon">*</span>
					<span class="help-inline">最多只能输入30个字符。</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="location_p">
					商家所在地区
				</label>
				<div class="controls">
						<select id="cmbProvince" name="lbs.province"></select>  
                        <select id="cmbCity" name="lbs.city"></select>  
                        <select id="cmbArea" name="lbs.area"></select>  
  
  
		               <script type="text/javascript">  
		                    addressInit('cmbProvince', 'cmbCity', 'cmbArea','江苏','无锡市','宜兴市');  
		               </script> 
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="category_f">
					商家类别
				</label>
				<div class="controls">
					<s:select list="#{'请选择':'请选择','金融业':'金融业','教育':'教育','企业':'企业','建筑':'建筑','旅游':'旅游','餐饮':'餐饮','娱乐':'娱乐','商超':'商超','物流':'物流','汽车':'汽车','事业机构':'事业机构','其他':'其他'}" name="lbs.bigtype" listKey="key" listValue="value"></s:select>
					<s:textfield name="lbs.sontype" id="sontype" placeholder="详细分类，如：电影院"></s:textfield>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="address">
					地址:
				</label>
				<div class="controls">
					<s:textfield name="lbs.address" id="lbsaddress" cssClass="span5"></s:textfield>
					<button id="locate-btn" class="btn btn-primary">定位</button>
					
					<span class="maroon">*</span>
					<br>
					<span class="help-inline">输入地址后，点击“自动定位”按钮可以在地图上定位。</span>
					<br>
					<span class="help-inline">（如果输入地址后无法定位，请在地图上直接点击选择地点）</span>
				</div>
			</div>
			<div class="control-group">
				<div id="map"
					style="width: 600px; height: 300px; margin-left: 100px;"></div>
			</div>
			<div class="control-group">
				<label class="control-label" for="address">
					电话:
				</label>
				<div class="controls">
					<s:textfield name="lbs.phone" id="lbstel" cssClass="span5"></s:textfield>
					<span class="maroon">*</span>
					<br>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="">
					商家展示图片:
				</label>
				<div class="controls">
					<div class="cover-area">
						<table style="height: 30px; overflow: hidden;">
							<tr>
								<td>
									<s:file name="picture" onchange="changePreImg();" id="myfile"></s:file><br/>
                                    	<img alt="暂无图片" src="images/noimg.jpg" id="myimage" width="480" height="240" />
								</td>
								<td valign="top" style="line-height: 30px; color: gray;">
									建议尺寸：700像素 * 380像素
								</td>
							</tr>
						</table>
						<p class="img-area cover-bd" id="picsethere">
						</p>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="detail">
					门店简介:
				</label>
				<div class="controls">
					<s:textarea name="lbs.info" id="lbscontent" cssClass="span5" cssStyle="height: 90px; width: 520px;"></s:textarea>
					<span class="maroon">*</span>
					<br>
					<span class="help-inline">最多为1000个字符。</span>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<s:token></s:token>
					<button type="submit"
						class="btn btn-primary btn-large">
						保存并开启
					</button>

				</div>
			</div>
		</form>

		<script type="text/javascript">
//是否从未保存过定位信息，如果从未保存过，并且有填地址信息，那么进入页面后自动定位
var located = true;
//定位坐标
var destPoint = new BMap.Point($('#lbsjd').val(),$('#lbswd').val());
$(function(){
	
	/**开始处理百度地图**/
	var map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(destPoint.lng, destPoint.lat), 12);//初始化地图
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	var marker = new BMap.Marker(destPoint);
	map.addOverlay(marker);//添加标注
	
	map.addEventListener("click", function(e){
		if(confirm("确认选择这个位置？")){
			destPoint = e.point;
			$('#lbsjd').val(destPoint.lng);
			$('#lbswd').val(destPoint.lat);
			var xylocation = document.getElementById("xylocation");
			xylocation.value=destPoint.lng+","+destPoint.lat;
			console.log(xylocation.value);
			map.clearOverlays();
			var marker1 = new BMap.Marker(destPoint);  // 创建标注
			map.addOverlay(marker1); 
		}
	});
	
	
	
	var myValue;

	var local;
	function setPlace(){
	    map.clearOverlays();    //清除地图上所有覆盖物
	    local = new BMap.LocalSearch(map, { //智能搜索
	      renderOptions:{ map: map}
	    });
	    located = true;
	    local.setMarkersSetCallback(callback);
	    local.search(myValue);
	}
	
	function addEventListener(marker){
		marker.addEventListener("click", function(data){
			destPoint = data.target.getPosition(0);
		});
	}
	function callback(posi){
		$("#locate-btn").removeAttr("disabled");
		for(var i=0;i<posi.length;i++){
			if(i==0){
				destPoint = posi[0].point;
			}
			posi[i].marker.addEventListener("click", function(data){
				destPoint = data.target.getPosition(0);
			});  
		}
	}
	
	$("#lbsl_xianqu").change(function(){
		$("#locate-btn").attr("disabled","disabled");
		local = new BMap.LocalSearch(map, { //智能搜索
			renderOptions:{ map: map}
		});
		located = true;
		local.setMarkersSetCallback(callback);
		local.search($("#lbsl_xianqu").find('option:selected').text());
		return false;
	});
	$("#lbsl_shi").change(function(){
		$("#locate-btn").attr("disabled","disabled");
		local = new BMap.LocalSearch(map, { //智能搜索
			renderOptions:{ map: map}
		});
		located = true;
		local.setMarkersSetCallback(callback);
		local.search($("#lbsl_shi").find('option:selected').text());
		return false;
	});
	$("#locate-btn").click(function(){
		if($("#lbsaddress").val() == ""){
			alert("请输入门店地址！");
			return false;
		}
		$("#locate-btn").attr("disabled","disabled");
		local = new BMap.LocalSearch(map, { //智能搜索
			renderOptions:{ map: map}
		});
		located = true;
		local.setMarkersSetCallback(callback);
		local.search($("#lbsaddress").val());
		return false;
	});
	/**结束百度地图处理**/
	$("#close-btn").click(function(){
    	if(confirm("你确定要停用LBS功能？")){
    		var submitData = {
    			"action":"close",
    			"wuid":19979,
    			"lid":null
    		};
    		$.post("/admin/lbsinfo",submitData,function(data){
    			if(data.success){
    				window.location.reload();
    			} else{
    				alert("停用失败");
    			}
    		},"json");
    	}
    });
    /*
	 $("#lbsForm").submit(function(){
		var cansv= true;
		$(this).find('input[type="text"],textarea').each(function(){
			if($.trim($(this).val())==''){
				cansv = false;
				$(this).css('backgroundColor','yellow');
				$(this).one('focus',function(){
					$(this).css('backgroundColor','transparent');
				});
			}
		});
		if(!cansv){
			tusi('请将信息填写完整');
		}else if($('#picsethere').find('img').size()<1){
    		cansv = false;
    		tusi('请上传商家图片');
    	}
    	return cansv;
    });
    */
});
</script>
		<br />
		<br />
		<br />
	</body>

</html>