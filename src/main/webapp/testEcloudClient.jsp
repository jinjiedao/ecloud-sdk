<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/scroll.css" />
		<script src="<%=basePath%>/js/jquery-1.11.2.js"></script>
		<script src="<%=basePath%>/js/testEcloudClient.js"></script>
		<title></title>
	</head>
	<body>
		<div class="header" id="headerShowStatus">
			<div id="templateNumShow"></div>
			<div id="contractNumShow"></div>
		</div>
		<div class="leftMain">
			<div>
		    	<label style="color:red">填写真实数据模拟测试提交</label><br>
		    	<label>类型<input type="text" id="type"></label>1：个人 、2：企业<br>
		    	<label>证件类型 <input type="text" id="cardType"></label>0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件<br>
		    	<label>证件号码<input type="text" id="idCardNum"></label>证件号码<br>
		    	<label>名称<input type="text" id="name"></label>企业或者个人真实名称<br>
		    	<label>手机号<input type="text" id="mobilePhone"></label>企业或者个人联系手机号<br>
		    	<input type="button" value="申请CA证书" onclick="doServlet(1)"><label style="color:red" id="type1"></label>
		    	<label id="result1"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>申请者相关信息<textarea id="info2" rows="5" cols="50%" placeholder="请输入真实签署人信息，详细参数说明 见文档"></textarea></label>{"mobilePhone":"13100004176","name":"手机宝宝","type":1,"cardType":0,"idCardNum":"110105198710097533"}<br>
		    	<label>申请者新手机号码<input type="text" id="newMobile2"></label><br>
		    	<input type="button" value="签署人更换手机" onclick="doServlet(2)">
		    	<label style="color:red"  id="type2"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>用户相关信息<textarea id="info4" rows="5" cols="50%" placeholder="请输入真实签署人信息，详细参数说明 见文档"></textarea></label>{"mobilePhone":"13100004176","name":"手机宝宝","type":1,"cardType":0,"idCardNum":"110105198710097533"}<br>
		    	<input type="button" value="用户相关信息" onclick="doServlet(4)">
		    	<label style="color:red"  id="type4"></label>
		    	<label id="result4"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>用户手机<input type="text" id="mobilePhone21"></label><br>
			    <label>签章id<textarea id="signImg21"></textarea></label>签名/印章图片(base64编码)<br>
			    <label>签名类型<input type="text" id="signType21"></label>1签名 2印章<br>
		    	<input type="button" value="添加 签名/签章" onclick="doServlet(21)">
		    	<label style="color:red"  id="type21"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>用户手机<input type="text" id="mobilePhone22"></label><br>
			    <label>签章id<input type="text" id="signId22"></label><br>
		    	<input type="button" value="设置默认签章" onclick="doServlet(22)">
		    	<label style="color:red"  id="type22"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
				<label>用户手机<input type="text" id="mobilePhone23"></label><br>
			    <label>签名类型<input type="text" id="signType23"></label>1签名 2印章<br>
			    <input type="button" value="签名/签章列表" onclick="doServlet(23)">
				<label style="color:red" id="type23"></label>
				<table border="1">
					<thead>
						<tr>
							<td>签章id</td>
							<td>是否是默认签名</td>
						</tr>
					</thead>
					<tbody id="signList">
					</tbody>
				</table>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
			</div><br>
			<div>
		    	<label>用户手机<input type="text" id="mobilePhone24"></label><br>
			    <label>签章id<input type="text" id="signId24"></label><br>
		    	<input type="button" value="删除签章" onclick="doServlet(24)">
		    	<label style="color:red"  id="type24"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    
		    
		</div>
		<div class="centerMain">
			<div>
			    <br>
		    	<label>模板调用名称<input type="text" id="templateName41"></label><br>
		    	<label>模板编号<input type="text" id="templateNumber41" style="width: 350px" placeholder="选填，不填按照易云章标准生成，填写则按照填写的编号生成"></label><br>
		    	<label>模板变量<textarea id="vars41" rows="8" cols="33%" placeholder="模板变量格式见文档，选填，如果填写则按照有变量的模板进行添加"></textarea></label><br>
		    	<label>模板html内容 <textarea id="html41" rows="8" cols="33%" placeholder="必填，模拟真实html内容提交"></textarea></label><br>
		    	<label>签章位置<textarea id="signPositio41" rows="8" cols="33%" placeholder="选填，签章位置列表,json字符串,格式见文档，如填写签章位置则不能按照变量格式添加"></textarea></label>
		    	[{"positionName":"name1", "page": 1, "x": 200, "y": 200 },{"positionName":"name1","page": 2, "x": 300, "y": 300 }]
		    	<br>
			    <input type="button" value="添加模板" onclick="doServlet(41)">
			    <label style="color:red" id="type41"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
			    <br>
		    	<label>模板调用名称<input type="text" id="templateName42"></label><br>
		    	<label>模板编号<input type="text" id="templateNumber42" style="width: 350px" placeholder="选填，不填按照易云章标准生成，填写则按照填写的编号生成"></label><br>
		    	<label>模板变量<textarea id="vars42" rows="8" cols="33%" placeholder="模板变量格式见文档，选填，如果填写则按照有变量的模板进行添加"></textarea></label><br>
		    	<label>模板html内容 <textarea id="html42" rows="8" cols="33%" placeholder="必填，模拟真实html内容提交"></textarea></label><br>
		    	<label>签章位置<textarea id="signPositio42" rows="8" cols="33%" placeholder="选填，签章位置列表,json字符串,格式见文档，如填写签章位置则不能按照变量格式添加"></textarea></label><br>
			    <input type="button" value="修改模板" onclick="doServlet(42)">
			    <label style="color:red" id="type42"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
			    <label>当前页数，默认为1<input type="text" id=currentPage43></label><br>
		    	<label>每页的记录数，最大为100 <input type="text" id="pageSize43"></label><br>
				<input type="button" value="获取模板列表" onclick="doServlet(43)">
				<label style="color:red" id="type43"></label>
				<table border="1">
					<thead>
						<tr>
							<td>模板编号</td>
							<td>模板名称</td>
						</tr>
					</thead>
					<tbody id="templateList">
					</tbody>
				</table>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
			</div><br>
			 <div>
		    	<label>模板编号<input type="text" id="templateNumber50"></label><br>
		    	<input type="button" value="删除模板" onclick="doServlet(50)">
		    	<label style="color:red" id="type50"></label>
		    	<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		   	</div><br>
			<div>
			    <label>模板编号<input type="text" id="templateNumber44"></label><br>
				<input type="button" value="获取模板内容" onclick="doServlet(44)">
				<label style="color:red" id="type44"></label>
				<label id="result44"></label>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
			</div><br>
			<div>
			    <label>模板编号<input type="text" id="templateNumber45"></label><br>
			    <label>合同编号<input type="text" id="contractNum45"></label>选填<br>
			    <label>模板变量值 <input type="text" id="replaceVal45"></label>{a:1312}<br>
			    <label>模板变量<textarea id="vars45" rows="5" cols="33%" placeholder="模板变量格式见文档"></textarea>选填[{"name": "变量名称","Value": "变量值"}]</label><br>
			    <input type="button" value="根据模板生成合同文档" onclick="doServlet(45)">
			    <label style="color:red" id="type45"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
			    <label>模板编号<input type="text" id="templateNumber48"></label><br>
			    
			    <input type="button" value="获得模板变量" onclick="doServlet(48)">
			    <label style="color:red" id="type48"></label>
			    <table border="1">
					<thead>
						<tr>
							<td>变量名称</td>
							<td>变量值</td>
						</tr>
					</thead>
					<tbody id="tempVarsList">
					</tbody>
				</table>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    
		</div>
		<div class="rightMain">
			<div>
				<label>手机号码<input type="text" id="mobilePhone71"></label><br>
			    <label>当前页数，默认为1<input type="text" id="currentPage71"></label><br>
		    	<label>每页的记录数，最大为100 <input type="text" id="pageSize71"></label><br>
				<input type="button" value="获取合同列表" onclick="doServlet(71)">
				<label style="color:red" id="type71"></label>
				<table border="1">
					<thead>
						<tr>
							<td>合同编号</td>
							<td>合同名称</td>
							<td>合同有效天数</td>
							<td>合同签署剩余天数</td>
						</tr>
					</thead>
					<tbody id="contractList">
					</tbody>
				</table>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
			</div><br>
			<div>
				<label>手机号码<input type="text" id="mobilePhone72"></label><br>
			    <label>合同编号<input type="text" id="contractNum72"></label><br>
				<input type="button" value="获取合同详情" onclick="doServlet(72)">
				<label style="color:red" id="type71"></label>
				<label id="result72"></label>
				<hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
			</div><br>
			<div>
		    	<label>签署人信息<textarea id="signerInfo73" rows="5" cols="50%" placeholder="请输入真实签署人信息"></textarea></label>{"mobilePhone":"15811236215","name":"手机宝宝","type":1,"cardType":0,"idCardNum":"110105198710097533"}<br>
			    <label>合同编号 <input type="text" id="contractNum73"></label><br>
			    <label>是否完成 <input type="text" id="isFinish73"></label>0:是,1:否<br>
		     	<label>签章信息<textarea id="signInfo73" rows="5" cols="33%" placeholder="签章信息，如果指定，则用户必须已经上传签章或者签字，并且在对应的模板中指定位置"></textarea></label>{"signType":"1","signId":"0","positionName":"name1"}<br>
		     	<label>验证码 <input type="text" id="dynamicCode73" placeholder="使用验证码的方法"></label><br>
			    <input type="button" value="自动签署合同" onclick="doServlet(73)">
			    <label style="color:red" id="type73"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>合同编号 <input type="text" id="contractNum74"></label><br>
			    <label>合同关键字 <input type="text" id="keyWord74"></label><br>
			    <label>合同名称 <input type="text" id="contractName74"></label><br>
			    <label>合同有效天数，最大180天 <input type="text" id="days74"></label><br>
			    <label>发起方手机 <input type="text" id="mobilePhone74"></label><br>
			    <label>合同签署人手机号码 <input type="text" id="toMobile74"></label><br>
			    <label>坐标信息 <textarea  id="position74" rows="2" cols="33%"></textarea></label>[{"page": 1,"x": 200, "y": 200, "signId":23}]<br>
			    <input type="button" value="发起合同" onclick="doServlet(74)">
			    <label style="color:red" id="type74"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
		    	<label>合同编号 <input type="text" id="contractNum75"></label><br>
			    <label>签署人手机号码 <input type="text" id="mobilePhone75"></label><br>
			    <label>坐标信息 <textarea id="position75" rows="2" cols="33%"></textarea></label>[{"page": 1,"x": 200, "y": 200, "signId":23}]<br>
			    <input type="button" value="签署合同" onclick="doServlet(75)">
			    <label style="color:red" id="type75"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		     <div>
			    <label>合同编号 <input type="text" id="contractNum76"></label><br>
			    <input type="button" value="签章合同文档下载" onclick="doServlet(76)">
			    <label style="color:red" id="type76"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		    <div>
			    <label>合同编号 <input type="text" id="contractNum77"></label><br>
			    <label>手机号码 <input type="text" id="mobilePhone77"></label><br>
			    <label>信息模板 <input type="text" id="smsTemplate77" placeholder="可为空"></label><br>
			    <input type="button" value="发送验证码" onclick="doServlet(77)">
			    <label style="color:red" id="type77"></label>
			    <hr style="height:5px;border:none;border-top:5px ridge #0066CC;" />
		    </div><br>
		</div>
	</body>
</html>
