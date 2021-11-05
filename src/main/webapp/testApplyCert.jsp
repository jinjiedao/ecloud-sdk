<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<title>爱知之星</title>
		<script src="js/jquery-1.11.2.js"></script>
	</head>
	<body>
		<div>
    	<br>
    	<label>类型<input type="text" id="type"></label>1：个人 、2：企业<br>
    	<label>证件类型 <input type="text" id="cardType"></label>0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件<br>
    	<label>证件号码<input type="text" id="idCardNum"></label>证件号码<br>
    	<label>名称<input type="text" id="name"></label>企业或者个人真实名称<br>
    	<label>手机号<input type="text" id="mobilePhone"></label>企业或者个人联系手机号<br>
		<label>appid<input type="text" id="appid" value="yyz5on287d79347c13"></label><br>
		<label>随机6位数字<input type="text" id="nonce" value=></label><br>
		<label>时间戳<input type="text" id="timestamp"></label><br>
		<label>签名<input type="text" id="signature" value="123"></label><br>
    	<input type="button" value="申请CA证书" onclick="doServlet(1)"><label style="color:red" id="type1"></label>
    </div><br>
		
	</body>
	<script>
	function doServlet(type){
	var begindate = new Date();
	var params = {};
	var datas=new Object();
	datas.type=$("#type").val();
	datas.cardType=$("#cardType").val();
	datas.idCardNum = $("#idCardNum").val();
	datas.name = $("#name").val();
	datas.mobilePhone = $("#mobilePhone").val();
	var info =JSON.stringify(datas);
	var params1 = {};
	params1["info"]=info;	
	params1["appid"] = "yyz5on287d79347c13";
	params1["nonce"] = "123456";
	params1["timestamp"] =  new Date().getTime();
	params1["signature"] = "123";
	var url="https://www.ecloudsign.com/cloudWeb/api/account/applyCert.jspa";
	
	

	
		$.ajax({
			type : "post",
			async : false,
			url : url,
			data : params1,
			dataType : "json",
			success : function(data) {
				alert(data);
			},
			error : function() {
				alert(1);
			}
		});
	
	
	}
	
	</script>
	
</html>
