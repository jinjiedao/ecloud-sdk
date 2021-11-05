<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>E云章压力测试页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.11.2.js"></script>
  </head>
  
  <body>
    <div><input type="button" value="申请CA证书" onclick="doServlet(1)"><label style="color:red" id="type1"></label></div><br>
    <div><input type="button" value="添加模板" onclick="doServlet(2)"><label style="color:red" id="type2"></label></div><br>
    <div><input type="button" value="更新模板" onclick="doServlet(3)"><label style="color:red" id="type3"></label></div><br>
    <div><input type="button" value="删除模板" onclick="doServlet(4)"><label style="color:red" id="type4"></label></div><br>
    <div><input type="button" value="根据模板生成合同文档" onclick="doServlet(5)"><label style="color:red" id="type5"></label></div><br>
    <div><input type="button" value="自动签署合同" onclick="doServlet(6)"><label style="color:red" id="type6"></label></div><br>
    <div><input type="button" value="签章合同文档下载" onclick="doServlet(7)"><label style="color:red" id="type7"></label></div><br>
    <div>
     <input type="hidden" id="templateNumber"><label style="color:red" id="type8"></label>
     <input type="hidden" id="contractNum"><label style="color:red" id="type9"></label>
    </div>
  </body>
 <script>
	function doServlet(type){
	var begindate = new Date();
	var params = {};
	params["actionType"] = type;
	
	if(type==3||type==4||type==5){
		params["templateNumber"] = $("#templateNumber").val();
	}else if(type==6||type==7){
		params["contractNum"] = $("#contractNum").val();
	}
		$.get("servletTest",params,
			   function(data){
			   var json=eval("("+data+")");
				var enddate = new Date();				   	
			   	var d=enddate-begindate;
			   	var html=createHtml(json);
			   	html+="<span>共花费:"+d+"毫秒</span>";
	   			$("#type"+type).html(html);
	   			
	   			if(type==2){
					$("#templateNumber").val(json.data.templateNumber);
					$("#type8").html("当前模板编号为："+json.data.templateNumber);
				}else if(type==5){
					$("#contractNum").val(json.data.contractNum);
					$("#type9").html("当前合同编号为："+json.data.contractNum);
				}else if(type==4){
					$("#templateNumber").val(null);
					$("#type8").html("当前模板已经被删除，请重新创建模板，如未创建则使用默认模板d1f80e9ac2e5877f。");
				}
			   }
		);
	}
	function createHtml(json){
		
		var html="";
	   	
	   	var code=json.code;
	   	var msg=json.message;
	   	var datas=json.data;
		html+="<span>code:"+code+"</span>&nbsp;&nbsp;";
	   	html+="<span>message:"+msg+"</span>&nbsp;&nbsp;";
	   	html+="<span>data:"+datas+"</span>&nbsp;&nbsp;";
	   	
	   	return html;
	}
	</script>
</html>
