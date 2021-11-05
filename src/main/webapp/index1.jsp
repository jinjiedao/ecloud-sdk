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
    <div>
    	<label style="color:red">填写真实数据模拟测试提交</label><br>
    	<label>类型<input type="text" id="type"></label>1：个人 、2：企业<br>
    	<label>证件类型 <input type="text" id="cardType"></label>0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件<br>
    	<label>证件号码<input type="text" id="idCardNum"></label>证件号码<br>
    	<label>名称<input type="text" id="name"></label>企业或者个人真实名称<br>
    	<label>手机号<input type="text" id="mobilePhone"></label>企业或者个人联系手机号<br>
    	<input type="button" value="申请CA证书" onclick="doServlet(1)"><label style="color:red" id="type1"></label>
    </div><br>
    
    <div>
	    <br>
    	<label>模板调用名称<input type="text" id="templateName"></label><br>
    	<label>模板html内容 <textarea id="html" rows="20" cols="80%" placeholder="模拟真实html内容提交"></textarea></label><br>
	    <input type="button" value="添加模板" onclick="doServlet(2)">
	    <label style="color:red" id="type2"></label>
    
    </div><br>
    <div>
    	<label>模板编号<input type="text" id="templateNumber3"></label><br>
    	<label>模板名称<input type="text" id="templateName3"></label><br>
    	<label>模板html内容 <textarea id="html3" rows="20" cols="80%" placeholder="模拟真实html内容提交"></textarea></label><br>
	    <input type="button" value="更新模板" onclick="doServlet(3)">
	    <label style="color:red" id="type3"></label>
    </div><br>
    <div>
    	<label>模板编号<input type="text" id="templateNumber4"></label><br>
    	<input type="button" value="删除模板" onclick="doServlet(4)">
    	<label style="color:red" id="type4"></label>
   	</div><br>
    <div>
	    <label>模板编号<input type="text" id="templateNumber5"></label><br>
	    <label>合同编号<input type="text" id="contractNum5"></label><br>
	    <label>模板变量值 <input type="text" id="replaceVal"></label>{a:1312}<br>
	    <input type="button" value="根据模板生成合同文档" onclick="doServlet(5)">
	    <label style="color:red" id="type5"></label>
    </div><br>
    <div>
    	<label>签署人信息<textarea id="signerInfo" rows="5" cols="50%" placeholder="请输入真实签署人信息"></textarea></label>{"mobilePhone":"15811236215","name":"手机宝宝","type":1,"cardType":0,"idCardNum":"110105198710097533"}<br>
	    <label>合同编号 <input type="text" id="contractNum6"></label><br>
	    <label>是否完成 <input type="text" id="isFinish"></label>0:是,1:否<br>
	    <input type="button" value="自动签署合同" onclick="doServlet(6)">
	    <label style="color:red" id="type6"></label>
    </div><br>
    <div>
	    <label>合同编号 <input type="text" id="contractNum7"></label><br>
<!-- 	    <label>下载地址 <input type="text" id="targetPath" placeholder="d://teggetPath.pdf"></label>选填，如填写会调用自动下载接口<br> -->
	    <input type="button" value="签章合同文档下载" onclick="doServlet(7)">
	    <label style="color:red" id="type7"></label>
    </div><br>
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
	if(type==1){
		params["type"] = $("#type").val();
		params["cardType"] = $("#cardType").val();
		params["idCardNum"] = $("#idCardNum").val();
		params["name"] = $("#name").val();
		params["mobilePhone"] = $("#mobilePhone").val();
	}else if(type==2){
		params["templateName"] = $("#templateName").val();
		params["html"] = $("#html").val();
	}else if(type==3){
		params["templateNumber"] = $("#templateNumber3").val();
		params["templateName"] = $("#templateName3").val();
		params["html"] = $("#html3").val();
	}else if(type==4){
		params["templateNumber"] = $("#templateNumber4").val();
	}else if(type==5){
		params["templateNumber"] = $("#templateNumber5").val();
		params["replaceVal"] = $("#replaceVal").val();
		params["contractNum"] = $("#contractNum5").val();
	}else if(type==6){
		params["signerInfo"] = $("#signerInfo").val();
		params["contractNum"] = $("#contractNum6").val();
		params["isFinish"] = $("#isFinish").val();
	}else if(type==7){
		params["targetPath"] = $("#targetPath").val();
		params["contractNum"] = $("#contractNum7").val();
// 		window.location.href="myServletParamTest?actionType=7&contractNum="+$("#contractNum7").val();
var url="myServletParamTest?actionType=7&contractNum="+$("#contractNum7").val();
		window.open(url,"_blank") ;
		return false;
	}
		$.post("myServletParamTest",params,
			   function(data){
				   var json=eval("("+data+")");
				   if(json.code!=201){
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
				   
					var enddate = new Date();				   	
				   	var d=enddate-begindate;
				   	var html=createHtml(json);
				   	html+="<span>共花费:"+d+"毫秒</span>";
		   			$("#type"+type).html(html);
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
