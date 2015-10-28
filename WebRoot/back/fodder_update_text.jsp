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
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改文本</title>
<script type="text/javascript">var yyuc_jspath = "";</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all" />


<style type="text/css">
	.art_table{
		width: 80%;
	}
	.tb-toolbar {
		height: 30px;
		padding: 0 10px;
		text-align: right;
		line-height: 30px;
	}
	
	#myModal{
		width: 700px;
	}
	#sel_resource .controls {
		margin-left: 100px;
	}
	#sel_resource .control-label {
		width: 70px;
	}
	
	
</style>
</head>

<body>
<div id="main">
        <div class="container-fluid">

            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span10">
                                <h3><i class="icon-edit"></i>修改文本</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
		pophtml('<iframe src="contresource-tosel.html" style="width:880px;height:470px;border:none;background-color: #dfdfdf;" width="880px" height="475px"></iframe>',920,510,true);
	}
    
    function setselid(id){
    	$('input[relval="'+id+'"]').prop('checked',true);
    	$('#multiArticle11if').attr('src','/admin/baseService/contresourceshowone-'+id+'.html');
    	
    }
    </script>
	<form class="form-horizontal" id="reply_form" style="margin-left: 10px;margin-top:10px;" action="fodderAction!updatetext" method="post">	        
			<input type="hidden" name="fodderid" value="<s:property value="fodder.id"/>"/>
			<div class="control-group">
			  <label class="control-label" for="answertype" style="text-align: right;margin-top: -4px;">标题:</label>
			    <div class="controls">
			    <input type="text" name="title" value="<s:property value="fodder.title"/>" id="ppgjz"/>
				 <div>
			  	<span class="maroon">*</span> 必填
	      	     </div>
			   </div>
			  
		  	</div>
	        <div style="display: none;" class="control-group" id="textreply">
	            <label class="control-label" for="reply"  style="text-align: right;margin-top: -4px;">文本内容:</label>
	            <div class="controls">
	           		


<link rel="stylesheet" href="css/admin/emotion.css">
<script type="text/javascript" src="js/emotion.js"></script>
<script type="text/javascript" src="js/html_helper.js"></script>
<div class="txtArea">
	<div class="functionBar">
		<div class="opt">
			<a class="icon18C iconEmotion block" href="javascript:;">表情</a>
		</div>
		<div class="tip"></div>
		<div class="emotions">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td><div class="eItem" style="background-position: 0px 0;" data-title="微笑" data-gifurl="media/images/admin/emotion/0.gif"></div></td>
						<td><div class="eItem" style="background-position: -24px 0;" data-title="撇嘴" data-gifurl="media/images/admin/emotion/1.gif"></div></td>
						<td><div class="eItem" style="background-position: -48px 0;" data-title="色" data-gifurl="media/images/admin/emotion/2.gif"></div></td>
						<td><div class="eItem" style="background-position: -72px 0;" data-title="发呆" data-gifurl="media/images/admin/emotion/3.gif"></div></td>
						<td><div class="eItem" style="background-position: -96px 0;" data-title="得意" data-gifurl="media/images/admin/emotion/4.gif"></div></td>
						<td><div class="eItem" style="background-position: -120px 0;" data-title="流泪" data-gifurl="media/images/admin/emotion/5.gif"></div></td>
						<td><div class="eItem" style="background-position: -144px 0;" data-title="害羞" data-gifurl="media/images/admin/emotion/6.gif"></div></td>
						<td><div class="eItem" style="background-position: -168px 0;" data-title="闭嘴" data-gifurl="media/images/admin/emotion/7.gif"></div></td>
						<td><div class="eItem" style="background-position: -192px 0;" data-title="睡" data-gifurl="media/images/admin/emotion/8.gif"></div></td>
						<td><div class="eItem" style="background-position: -216px 0;" data-title="大哭" data-gifurl="media/images/admin/emotion/9.gif"></div></td>
						<td><div class="eItem" style="background-position: -240px 0;" data-title="尴尬" data-gifurl="media/images/admin/emotion/10.gif"></div></td>
						<td><div class="eItem" style="background-position: -264px 0;" data-title="发怒" data-gifurl="media/images/admin/emotion/11.gif"></div></td>
						<td><div class="eItem" style="background-position: -288px 0;" data-title="调皮" data-gifurl="media/images/admin/emotion/12.gif"></div></td>
						<td><div class="eItem" style="background-position: -312px 0;" data-title="呲牙" data-gifurl="media/images/admin/emotion/13.gif"></div></td>
						<td><div class="eItem" style="background-position: -336px 0;" data-title="惊讶" data-gifurl="media/images/admin/emotion/14.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -360px 0;" data-title="难过" data-gifurl="media/images/admin/emotion/15.gif"></div></td>
						<td><div class="eItem" style="background-position: -384px 0;" data-title="酷" data-gifurl="media/images/admin/emotion/16.gif"></div></td>
						<td><div class="eItem" style="background-position: -408px 0;" data-title="冷汗" data-gifurl="media/images/admin/emotion/17.gif"></div></td>
						<td><div class="eItem" style="background-position: -432px 0;" data-title="抓狂" data-gifurl="media/images/admin/emotion/18.gif"></div></td>
						<td><div class="eItem" style="background-position: -456px 0;" data-title="吐" data-gifurl="media/images/admin/emotion/19.gif"></div></td>
						<td><div class="eItem" style="background-position: -480px 0;" data-title="偷笑" data-gifurl="media/images/admin/emotion/20.gif"></div></td>
						<td><div class="eItem" style="background-position: -504px 0;" data-title="可爱" data-gifurl="media/images/admin/emotion/21.gif"></div></td>
						<td><div class="eItem" style="background-position: -528px 0;" data-title="白眼" data-gifurl="media/images/admin/emotion/22.gif"></div></td>
						<td><div class="eItem" style="background-position: -552px 0;" data-title="傲慢" data-gifurl="media/images/admin/emotion/23.gif"></div></td>
						<td><div class="eItem" style="background-position: -576px 0;" data-title="饥饿" data-gifurl="media/images/admin/emotion/24.gif"></div></td>
						<td><div class="eItem" style="background-position: -600px 0;" data-title="困" data-gifurl="media/images/admin/emotion/25.gif"></div></td>
						<td><div class="eItem" style="background-position: -624px 0;" data-title="惊恐" data-gifurl="media/images/admin/emotion/26.gif"></div></td>
						<td><div class="eItem" style="background-position: -648px 0;" data-title="流汗" data-gifurl="media/images/admin/emotion/27.gif"></div></td>
						<td><div class="eItem" style="background-position: -672px 0;" data-title="憨笑" data-gifurl="media/images/admin/emotion/28.gif"></div></td>
						<td><div class="eItem" style="background-position: -696px 0;" data-title="大兵" data-gifurl="media/images/admin/emotion/29.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -720px 0;" data-title="奋斗" data-gifurl="media/images/admin/emotion/30.gif"></div></td>
						<td><div class="eItem" style="background-position: -744px 0;" data-title="咒骂" data-gifurl="media/images/admin/emotion/31.gif"></div></td>
						<td><div class="eItem" style="background-position: -768px 0;" data-title="疑问" data-gifurl="media/images/admin/emotion/32.gif"></div></td>
						<td><div class="eItem" style="background-position: -792px 0;" data-title="嘘" data-gifurl="media/images/admin/emotion/33.gif"></div></td>
						<td><div class="eItem" style="background-position: -816px 0;" data-title="晕" data-gifurl="media/images/admin/emotion/34.gif"></div></td>
						<td><div class="eItem" style="background-position: -840px 0;" data-title="折磨" data-gifurl="media/images/admin/emotion/35.gif"></div></td>
						<td><div class="eItem" style="background-position: -864px 0;" data-title="衰" data-gifurl="media/images/admin/emotion/36.gif"></div></td>
						<td><div class="eItem" style="background-position: -888px 0;" data-title="骷髅" data-gifurl="media/images/admin/emotion/37.gif"></div></td>
						<td><div class="eItem" style="background-position: -912px 0;" data-title="敲打" data-gifurl="media/images/admin/emotion/38.gif"></div></td>
						<td><div class="eItem" style="background-position: -936px 0;" data-title="再见" data-gifurl="media/images/admin/emotion/39.gif"></div></td>
						<td><div class="eItem" style="background-position: -960px 0;" data-title="擦汗" data-gifurl="media/images/admin/emotion/40.gif"></div></td>
						<td><div class="eItem" style="background-position: -984px 0;" data-title="抠鼻" data-gifurl="media/images/admin/emotion/41.gif"></div></td>
						<td><div class="eItem" style="background-position: -1008px 0;" data-title="鼓掌" data-gifurl="media/images/admin/emotion/42.gif"></div></td>
						<td><div class="eItem" style="background-position: -1032px 0;" data-title="糗大了" data-gifurl="media/images/admin/emotion/43.gif"></div></td>
						<td><div class="eItem" style="background-position: -1056px 0;" data-title="坏笑" data-gifurl="media/images/admin/emotion/44.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -1080px 0;" data-title="左哼哼" data-gifurl="media/images/admin/emotion/45.gif"></div></td>
						<td><div class="eItem" style="background-position: -1104px 0;" data-title="右哼哼" data-gifurl="media/images/admin/emotion/46.gif"></div></td>
						<td><div class="eItem" style="background-position: -1128px 0;" data-title="哈欠" data-gifurl="media/images/admin/emotion/47.gif"></div></td>
						<td><div class="eItem" style="background-position: -1152px 0;" data-title="鄙视" data-gifurl="media/images/admin/emotion/48.gif"></div></td>
						<td><div class="eItem" style="background-position: -1176px 0;" data-title="委屈" data-gifurl="media/images/admin/emotion/49.gif"></div></td>
						<td><div class="eItem" style="background-position: -1200px 0;" data-title="快哭了" data-gifurl="media/images/admin/emotion/50.gif"></div></td>
						<td><div class="eItem" style="background-position: -1224px 0;" data-title="阴险" data-gifurl="media/images/admin/emotion/51.gif"></div></td>
						<td><div class="eItem" style="background-position: -1248px 0;" data-title="亲亲" data-gifurl="media/images/admin/emotion/52.gif"></div></td>
						<td><div class="eItem" style="background-position: -1272px 0;" data-title="吓" data-gifurl="media/images/admin/emotion/53.gif"></div></td>
						<td><div class="eItem" style="background-position: -1296px 0;" data-title="可怜" data-gifurl="media/images/admin/emotion/54.gif"></div></td>
						<td><div class="eItem" style="background-position: -1320px 0;" data-title="菜刀" data-gifurl="media/images/admin/emotion/55.gif"></div></td>
						<td><div class="eItem" style="background-position: -1344px 0;" data-title="西瓜" data-gifurl="media/images/admin/emotion/56.gif"></div></td>
						<td><div class="eItem" style="background-position: -1368px 0;" data-title="啤酒" data-gifurl="media/images/admin/emotion/57.gif"></div></td>
						<td><div class="eItem" style="background-position: -1392px 0;" data-title="篮球" data-gifurl="media/images/admin/emotion/58.gif"></div></td>
						<td><div class="eItem" style="background-position: -1416px 0;" data-title="乒乓" data-gifurl="media/images/admin/emotion/59.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -1440px 0;" data-title="咖啡" data-gifurl="media/images/admin/emotion/60.gif"></div></td>
						<td><div class="eItem" style="background-position: -1464px 0;" data-title="饭" data-gifurl="media/images/admin/emotion/61.gif"></div></td>
						<td><div class="eItem" style="background-position: -1488px 0;" data-title="猪头" data-gifurl="media/images/admin/emotion/62.gif"></div></td>
						<td><div class="eItem" style="background-position: -1512px 0;" data-title="玫瑰" data-gifurl="media/images/admin/emotion/63.gif"></div></td>
						<td><div class="eItem" style="background-position: -1536px 0;" data-title="凋谢" data-gifurl="media/images/admin/emotion/64.gif"></div></td>
						<td><div class="eItem" style="background-position: -1560px 0;" data-title="示爱" data-gifurl="media/images/admin/emotion/65.gif"></div></td>
						<td><div class="eItem" style="background-position: -1584px 0;" data-title="爱心" data-gifurl="media/images/admin/emotion/66.gif"></div></td>
						<td><div class="eItem" style="background-position: -1608px 0;" data-title="心碎" data-gifurl="media/images/admin/emotion/67.gif"></div></td>
						<td><div class="eItem" style="background-position: -1632px 0;" data-title="蛋糕" data-gifurl="media/images/admin/emotion/68.gif"></div></td>
						<td><div class="eItem" style="background-position: -1656px 0;" data-title="闪电" data-gifurl="media/images/admin/emotion/69.gif"></div></td>
						<td><div class="eItem" style="background-position: -1680px 0;" data-title="炸弹" data-gifurl="media/images/admin/emotion/70.gif"></div></td>
						<td><div class="eItem" style="background-position: -1704px 0;" data-title="刀" data-gifurl="media/images/admin/emotion/71.gif"></div></td>
						<td><div class="eItem" style="background-position: -1728px 0;" data-title="足球" data-gifurl="media/images/admin/emotion/72.gif"></div></td>
						<td><div class="eItem" style="background-position: -1752px 0;" data-title="瓢虫" data-gifurl="media/images/admin/emotion/73.gif"></div></td>
						<td><div class="eItem" style="background-position: -1776px 0;" data-title="便便" data-gifurl="media/images/admin/emotion/74.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -1800px 0;" data-title="月亮" data-gifurl="media/images/admin/emotion/75.gif"></div></td>
						<td><div class="eItem" style="background-position: -1824px 0;" data-title="太阳" data-gifurl="media/images/admin/emotion/76.gif"></div></td>
						<td><div class="eItem" style="background-position: -1848px 0;" data-title="礼物" data-gifurl="media/images/admin/emotion/77.gif"></div></td>
						<td><div class="eItem" style="background-position: -1872px 0;" data-title="拥抱" data-gifurl="media/images/admin/emotion/78.gif"></div></td>
						<td><div class="eItem" style="background-position: -1896px 0;" data-title="强" data-gifurl="media/images/admin/emotion/79.gif"></div></td>
						<td><div class="eItem" style="background-position: -1920px 0;" data-title="弱" data-gifurl="media/images/admin/emotion/80.gif"></div></td>
						<td><div class="eItem" style="background-position: -1944px 0;" data-title="握手" data-gifurl="media/images/admin/emotion/81.gif"></div></td>
						<td><div class="eItem" style="background-position: -1968px 0;" data-title="胜利" data-gifurl="media/images/admin/emotion/82.gif"></div></td>
						<td><div class="eItem" style="background-position: -1992px 0;" data-title="抱拳" data-gifurl="media/images/admin/emotion/83.gif"></div></td>
						<td><div class="eItem" style="background-position: -2016px 0;" data-title="勾引" data-gifurl="media/images/admin/emotion/84.gif"></div></td>
						<td><div class="eItem" style="background-position: -2040px 0;" data-title="拳头" data-gifurl="media/images/admin/emotion/85.gif"></div></td>
						<td><div class="eItem" style="background-position: -2064px 0;" data-title="差劲" data-gifurl="media/images/admin/emotion/86.gif"></div></td>
						<td><div class="eItem" style="background-position: -2088px 0;" data-title="爱你" data-gifurl="media/images/admin/emotion/87.gif"></div></td>
						<td><div class="eItem" style="background-position: -2112px 0;" data-title="NO" data-gifurl="media/images/admin/emotion/88.gif"></div></td>
						<td><div class="eItem" style="background-position: -2136px 0;" data-title="OK" data-gifurl="media/images/admin/emotion/89.gif"></div></td>
					</tr>
					<tr>
						<td><div class="eItem" style="background-position: -2160px 0;" data-title="爱情" data-gifurl="media/images/admin/emotion/90.gif"></div></td>
						<td><div class="eItem" style="background-position: -2184px 0;" data-title="飞吻" data-gifurl="media/images/admin/emotion/91.gif"></div></td>
						<td><div class="eItem" style="background-position: -2208px 0;" data-title="跳跳" data-gifurl="media/images/admin/emotion/92.gif"></div></td>
						<td><div class="eItem" style="background-position: -2232px 0;" data-title="发抖" data-gifurl="media/images/admin/emotion/93.gif"></div></td>
						<td><div class="eItem" style="background-position: -2256px 0;" data-title="怄火" data-gifurl="media/images/admin/emotion/94.gif"></div></td>
						<td><div class="eItem" style="background-position: -2280px 0;" data-title="转圈" data-gifurl="media/images/admin/emotion/95.gif"></div></td>
						<td><div class="eItem" style="background-position: -2304px 0;" data-title="磕头" data-gifurl="media/images/admin/emotion/96.gif"></div></td>
						<td><div class="eItem" style="background-position: -2328px 0;" data-title="回头" data-gifurl="media/images/admin/emotion/97.gif"></div></td>
						<td><div class="eItem" style="background-position: -2352px 0;" data-title="跳绳" data-gifurl="media/images/admin/emotion/98.gif"></div></td>
						<td><div class="eItem" style="background-position: -2376px 0;" data-title="挥手" data-gifurl="media/images/admin/emotion/99.gif"></div></td>
						<td><div class="eItem" style="background-position: -2400px 0;" data-title="激动" data-gifurl="media/images/admin/emotion/100.gif"></div></td>
						<td><div class="eItem" style="background-position: -2424px 0;" data-title="街舞" data-gifurl="media/images/admin/emotion/101.gif"></div></td>
						<td><div class="eItem" style="background-position: -2448px 0;" data-title="献吻" data-gifurl="media/images/admin/emotion/102.gif"></div></td>
						<td><div class="eItem" style="background-position: -2472px 0;" data-title="左太极" data-gifurl="media/images/admin/emotion/103.gif"></div></td>
						<td><div class="eItem" style="background-position: -2496px 0;" data-title="右太极" data-gifurl="media/images/admin/emotion/104.gif"></div></td>
					</tr>
				</tbody>
			</table>
			<div class="emotionsGif"></div>
		</div>
		<div class="clr"></div>
	</div>
	<div class="editArea">
		<textarea id="welcome" name="content" style="display: none;"></textarea>
		<div style="overflow-y: auto; overflow-x: hidden;" contenteditable="true">
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	
});


</script>
		      		<span class="maroon">*</span><span class="help-inline">必填</span>
		        </div>
	        </div>
	        
	         <div class="control-group" style="margin-top: 20px;">
	            <div class="controls">
	           		<button type="submit" class="btn-large btn-primary" id="submitbtn">保存</button>
		        </div>
	        </div>
	</form>
	
  
  
<script>
var itemRow = 0;
var auto_reply_id = '10865';   //autoreply table id
	
$(function(){
	

	var $textarea = $(".editArea textarea");
	var $contentDiv = $(".editArea div");
	$(".functionBar .iconEmotion").click(function(){
		//Emotion.saveRange();
		$(".emotions").show();
	});
	$(".emotions").hover(function(){
		
	},function(){
		$(".emotions").fadeOut();
	});
	$(".emotions .eItem").mouseenter(function(){
		$(".emotionsGif").html('<img src="'+$(this).attr("data-gifurl")+'">');
	}).click(function(){
		Emotion.insertHTML('<img src="' + $(this).attr("data-gifurl") + '"' + 'alt="mo-' + $(this).attr("data-title") + '"' + "/>");
		$(".emotions").fadeOut();
		$textarea.trigger("contentValueChange");
	});
	$contentDiv.bind("keyup",function(){
		$textarea.trigger("contentValueChange");
		Emotion.saveRange();
	}).bind("keydown",function(e){
	    switch (e.keyCode) {
	    case 8:
	        var t = Emotion.getSelection();
	        t.type && t.type.toLowerCase() === "control" && (e.preventDefault(), t.clear());
	        break;
	    case 13:
	        e.preventDefault(),
	        Emotion.insertHTML("<br/>");
	        Emotion.saveRange();
	    }
	}).bind("mouseup",function(e){
	    Emotion.saveRange();
	    if (!$.support.boxModel && />$/.test($contentDiv.html())) {
	        var n = Emotion.getSelection();
	        n.extend && (n.extend(cursorNode, cursorNode.length), n.collapseToEnd()),
	        Emotion.saveRange();
	        Emotion.insertHTML(" ");
	    }
	});
	$textarea.bind("contentValueChange",function(){
		$(this).val(Emotion.replaceInput($contentDiv.html()));
	});
	$contentDiv.html(Emotion.replaceEmoji($.trim($contentDiv.html())));
	
	
	
	//content (string)回复内容
	var itemData = {"id":"10865","wid":"10652","typ":"0","content":"<s:property value="fodder.content"/>"};
	var articleData = null;
	var wuid = 10652;
	
	//初始化数据
	if(itemData && itemData.wid){
		//alert($.toJSON(itemData));
		$("textarea[name='welcome']").val($.trim(itemData.content));
		$contentDiv.html(Emotion.replaceEmoji($.trim(itemData.content)));
		$('input[value="'+itemData.resource_id+'-'+itemData.typ+'"]').prop('checked',true);
		if(itemData.typ == 0){
			 $("#answertype").val("0");
			 $('#answertype0').prop('checked',true);
			 $("div#textreply").show();
		 }else if(itemData.typ != 0){
			 $("#answertype").val('1');
			 $('#answertype1').prop('checked',true);
			 $("div#textreply").hide();
			 setselid(itemData.resource_id)
		 }
	}else{
		 $("#answertype").val("0");
		 $('#answertype0').prop('checked',true);
		 $("div#textreply").show();
	}
	
	
	
	
});
</script>


 
	        
	        
<br/><br/><br/></body></html>