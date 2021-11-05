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
		params["info"] = $("#info2").val();
		params["newMobile"] = $("#newMobile2").val();
	}else if(type==3){
		params["info"] = $("#info3").val();
	}else if(type==4){
		params["info"] = $("#info4").val();
	}else if(type==21){
		params["mobilePhone"] = $("#mobilePhone21").val();
		params["signType"] = $("#signType21").val();
		params["signImg"] = $("#signImg21").val();
	}else if(type==22){
		params["mobilePhone"] = $("#mobilePhone22").val();
		params["signId"] = $("#signId22").val();
	}else if(type==23){
		params["mobilePhone"] = $("#mobilePhone23").val();
		params["signType"] = $("#signType23").val();
	}else if(type==24){
		params["mobilePhone"] = $("#mobilePhone24").val();
		params["signId"] = $("#signId24").val();
	}else if(type==41){
		params["templateName"] = $("#templateName41").val();
		params["html"] = $("#html41").val();
		params["templateNumber"] = $("#templateNumber41").val();
		params["vars"] = $("#vars41").val();
		params["signPositio"] = $("#signPositio41").val();
	}else if(type==42){
		params["templateName"] = $("#templateName42").val();
		params["html"] = $("#html42").val();
		params["templateNumber"] = $("#templateNumber42").val();
		params["vars"] = $("#vars42").val();
		params["signPositio"] = $("#signPositio42").val();
		
	}else if(type==43){
		params["currentPage"] = $("#currentPage43").val();
		params["pageSize"] = $("#pageSize43").val();
	}else if(type==44){
		params["templateNumber"] = $("#templateNumber44").val();
	}else if(type==45){
		params["templateNumber"] = $("#templateNumber45").val();
		params["replaceVal"] = $("#replaceVal45").val();
		params["contractNum"] = $("#contractNum45").val();
		params["vars"] = $("#vars45").val();
	}else if(type==48){
		params["templateNumber"] = $("#templateNumber48").val();
	}else if(type==50){
		params["templateNumber"] = $("#templateNumber50").val();
	}else if(type==71){
		params["mobilePhone"] = $("#mobilePhone71").val();
		params["currentPage"] = $("#currentPage71").val();
		params["pageSize"] = $("#pageSize71").val();
	}else if(type==72){
		params["mobilePhone"] = $("#mobilePhone72").val();
		params["contractNum"] = $("#contractNum72").val();
	}else if(type==73){
		params["signerInfo"] = $("#signerInfo73").val();
		params["contractNum"] = $("#contractNum73").val();
		params["isFinish"] = $("#isFinish73").val();
		params["signInfo"] = $("#signInfo73").val();
		params["dynamicCode"] = $("#dynamicCode73").val();
	}else if(type==74){
		params["contractNum"] = $("#contractNum74").val();
		params["keyWord"] = $("#keyWord74").val();
		params["contractName"] = $("#contractName74").val();
		params["days"] = $("#days74").val();
		params["mobilePhone"] = $("#mobilePhone74").val();
		params["toMobile"] = $("#toMobile74").val();
		params["position"] = $("#position74").val();
	}else if(type==75){
		params["contractNum"] = $("#contractNum75").val();
		params["mobilePhone"] = $("#mobilePhone75").val();
		params["position"] = $("#position75").val();
	}else if(type==76){
		params["targetPath"] = $("#targetPath").val();
		params["contractNum"] = $("#contractNum76").val();
// 		window.location.href="myServletParamTest?actionType=7&contractNum="+$("#contractNum7").val();
		var url="testSdkApiServlet?actionType=76&contractNum="+$("#contractNum76").val();
		window.open(url,"_blank") ;
		return false;
	}else if(type==77){
		params["contractNum"] = $("#contractNum77").val();
		params["mobilePhone"] = $("#mobilePhone77").val();
		params["smsTemplate"] = $("#smsTemplate77").val();
	}
		$.post("testSdkApiServlet",params,
			   function(data){
				   var json=eval("("+data+")");
				   if(json.code!=201){
			   			if(type==41){
//							$("#templateNumShow").val(json.data.templateNumber);
							$("#templateNumShow").html("当前模板编号为："+json.data.templateNumber);
						}else if(type==45){
							$("#contractNumShow").html("当前合同编号为："+json.data.contractNum);
						}else if(type==74){
							$("#contractNumShow").val(json.data.contractNum);
							$("#type9").html("当前合同编号为："+json.data.contractNum);
						}else if(type==4){
//							$("#templateNumber").val(null);
//							$("#type8").html("当前模板已经被删除，请重新创建模板，如未创建则使用默认模板d1f80e9ac2e5877f。");
						}
			   			createResultHtml(type,json);
				   }
				   
					var enddate = new Date();				   	
				   	var d=enddate-begindate;
				   	var html=createHtml(json);
				   	html+="<span>共花费:"+d+"毫秒</span>";
				   	$("#type"+type).html(html);
			   }
		);
}

function createResultHtml(type,json){
		if(type==43){
			 var tablehtml="";
			   for (x in json.data.list) {
				tablehtml+="<tr>" +
						"<td>"+json.data.list[x].templateNumber+"</td>" +
						"<td>"+json.data.list[x].templateName+"</td>" +
						"</tr>";
			   }
			   $("#templateList").html(tablehtml);
		}else if(type=='71'){
		   var tablehtml="";
		   for (x in json.data.list) {
			tablehtml+="<tr>" +
					"<td>"+json.data.list[x].contractInfo.contractNumber+"</td>" +
					"<td>"+json.data.list[x].contractInfo.name+"</td>" +
					"<td>"+json.data.list[x].contractInfo.days+"</td>" +
					"<td>"+json.data.list[x].contractInfo.leftValDays+"</td>" +
					"</tr>";
		   }
		   $("#contractList").html(tablehtml);
	   }else if(type=='23'){
		   var tablehtml="";
		   for (x in json.data.list) {
			tablehtml+="<tr>" +
					"<td>"+json.data.list[x].signId+"</td>" +
					"<td>"+json.data.list[x].isDefault+"</td>" +
					"</tr>";
		   }
		   $("#signList").html(tablehtml);
	   }else if(type=='72'){
		   var tablehtml="<ul>";
			tablehtml+="<li>发起人"+json.data.contractSendSigner.realName+"，发起人电话"+json.data.contractSendSigner.mobile+"</li>";
//					"<li>发起人电话"+json.data.contractSendSigner.mobile+"</li>" ;
			for (x in json.data.otherSigners) {
				tablehtml+="<li>签署人"+json.data.otherSigners[x].realName+",签署人电话"+json.data.otherSigners[x].mobile+"</li>";
			}		
			tablehtml+="</ul>";
		   $("#result72").html(tablehtml);
	   }else if(type=='44'){
		   var tablehtml="<ul>";
			tablehtml+="<li>模板内容:"+json.data.cont;
		   $("#result44").html(tablehtml);
	   }else if(type=='48'){
		   var bl=eval(json.data.vars);
		   var tablehtml="";
		   for (x in bl) {
			tablehtml+="<tr>" +
					"<td>"+bl[x].name+"</td>" +
					"<td>"+bl[x].defaultValue+"</td>" +
					"</tr>";
		   }
		   $("#tempVarsList").html(tablehtml);
	   }else if(type=='4'){
		   var tablehtml="<ul>";
			tablehtml+="<li>certNotAfter:"+json.data.certNotAfter+"</li>";
			tablehtml+="<li>issuer:"+json.data.issuer+"</li>";
			tablehtml+="<li>serialNumber:"+json.data.serialNumber+"</li>";
			tablehtml+="<li>certNotBefore:"+json.data.certNotBefore+"</li>";
		   $("#result4").html(tablehtml);
	   }else if(type=='1'){
		   var tablehtml="<ul>";
			tablehtml+="<li>certNotAfter:"+json.data.certNotAfter+"</li>";
			tablehtml+="<li>issuer:"+json.data.issuer+"</li>";
			tablehtml+="<li>serialNumber:"+json.data.serialNumber+"</li>";
			tablehtml+="<li>certNotBefore:"+json.data.certNotBefore+"</li>";
		   $("#result1").html(tablehtml);
	   }
}

function createHtml(json){
	
	var html="";
   	
   	var code=json.code;
   	var msg=json.message;
   	var datas=json.data;
	html+="<span>code:"+code+"</span>&nbsp;&nbsp;";
   	html+="<span>message:"+msg+"</span>&nbsp;&nbsp;";
//   	html+="<span>data:"+datas+"</span>&nbsp;&nbsp;";
   	
   	return html;
}