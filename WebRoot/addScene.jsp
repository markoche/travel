<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery_dev.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	var upload = "${upload}"; 
	if(upload=="" || upload==undefined ){
		
	}else{
		alert(upload);
	}
</script>

<script type="text/javascript" >
	
</script>

</head>

<body>

<form action="upLoadImage" method="post" enctype="multipart/form-data">

<!-- Popup -->
<div id="Popup">

<!-- SubPopup -->
<div id="SubPopup">
<script type="text/javascript">
$(function(){
$(".select").each(function(){
var s=$(this);
var z=parseInt(s.css("z-index"));
var dt=$(this).children("dt");
var dd=$(this).children("dd");
var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
dt.click(function(){dd.is(":hidden")?_show():_hide();});
dd.find("a").click(function(){dt.html($(this).html());_hide();});
$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
</script>
<div class="form_boxC">
<p>"<span class="f_cB">*</span>"号为必填项目</p>

<table cellpadding="0" cellspacing="0">
<tr>
<th width="100">景点名称<span class="f_cB">*</span></th>
<td><div class="txtbox floatL" style="width:100px;"><input name="sen_name" type="text" size="5" value=""></div></td>
</tr>

<tr>
<th width="100">景点联系方式<span class="f_cB">*</span></th>
<td><div class="txtbox floatL" style="width:100px;"><input name="sen_phone" type="text" size="5" value=""></div></td>
</tr>

<!-- 三级联动 -->
<tr>
<th width="100">城市选择<span class="f_cB">*</span></th>
<td>
	<div>
   <div class="form-group">
   <select id="province" class = "" onchange="chooseProvince(this)">
	<option value="1">请选择省</option>
		</select>
	<select id="city" onChange="chooseCity(this)">
	    <option value="1">请选择市</option>
	</select>
	<select id="area" onChange="aa()">
		<option value="1">请选择区</option>
	</select>
		<input type="text" id="act_city" name="act_city"/>
   </div>
</td>
</tr>

<tr>
<th width="100">图片上传(1)<span class="f_cB">*</span></th>
<td style="width: 200px"><input type="file" name="picture" value="选择图片">
</td>
</tr>
<tr>
<th width="100">图片上传(2)<span class="f_cB">*</span></th>
<td style="width: 200px"><input type="file" name="picture" value="选择图片">
</td>
</tr>
<tr>
<th width="100">图片上传(3)<span class="f_cB">*</span></th>
<td style="width: 200px"><input type="file" name="picture" value="选择图片">
</td>
</tr>

<tr>
<th>景点描述</th>
<td><div class="txtbox"><textarea name="sen_desc" cols="25" rows="5"></textarea></div><p class="f_cB pdg_t5">最多500字</p></td>
</tr>
</table>


</div>
</div>
<!-- SubPopup -->

<div id="BtmBtn">
<div class="btn_boxB floatR mag_l20"><input type="button" value="取消" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"></div>
<div class="btn_box floatR"><input type="submit" value="提交" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'" ></input></div>
</div>				
</div>

</form>

	<script src = "js/index.js"></script>
	<script src="js/bdtest.js"></script>
</body>
</html>