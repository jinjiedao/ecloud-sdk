package com.agile.ecloud.sdk.http;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ContractInfoSignApiParam;
import com.agile.ecloud.sdk.common.Pagination;
import com.agile.ecloud.sdk.http.result.*;
import com.agile.ecloud.sdk.util.FileUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.List;

public class EcloudClient {
	/**
	 * 申请CA证书
	 *
	 * @param type
	 *            类型 1：个人 、2：企业
	 * @param cardType
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            、8:三证合一
	 * @param idCardNum
	 *            证件号码
	 * @param name
	 *            企业或者个人真实名称
	 * @param mobilePhone
	 *            企业或者个人联系手机号
	 * @return
	 */
	public static ECloudDomain applyCert(String type, String cardType, String idCardNum, String name,
			String mobilePhone) {
		return AccountResult.applyCert(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone);
	}

	/**
	 *
	 * @param type
	 * @param cardType
	 * @param idCardNum
	 * @param name
	 * @param mobilePhone
	 * @param isSign	是否使用姓名生成默认签名
	 * @return
	 */
	public static ECloudDomain applyCert(String type, String cardType, String idCardNum, String name,
										 String mobilePhone,boolean isSign) {
		return AccountResult.applyCert(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone,isSign);
	}

	public static ECloudDomain smsBatchSigning(String signInfo,String dynamicCode,String serialNumber,
											   String mobilePhone)  {
		return ContractResult.smsBatchSigning(EcloudPublicKey.instance, signInfo, dynamicCode, serialNumber, mobilePhone);
	}

	public static ECloudDomain sealByKeywordForNum(String contractNum, String signerInfo, int i, String ruleInfo,
												   String signImageInfo) {
		return ContractResult.sealByKeywordForNum(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo, signImageInfo);
	}

	/**
	 * 更新证书
	 * <p>Title: updateCert</p>  
	 * <p>Description: </p>  
	 * @param cardType
	 * @param idCardNum
	 * @param name
	 * @param mobilePhone
	 * @return
	 */
	public static ECloudDomain updateCert(String type,String cardType, String idCardNum, String name,
			String mobilePhone) {
		return AccountResult.updateCert(EcloudPublicKey.instance,type, cardType, idCardNum, name, mobilePhone);
	}
	
	/**
	 * 申请CA证书
	 *
	 * @param type
	 *            类型 1：个人 、2：企业
	 * @param cardType
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            、8:三证合一
	 * @param idCardNum
	 *            证件号码
	 * @param name
	 *            企业或者个人真实名称
	 * @param mobilePhone
	 *            企业或者个人联系手机号
	 * @return
	 */
	public static ECloudDomain applyCertForSaas(String type, String cardType, String idCardNum, String name,
			String mobilePhone) {
		return AccountResult.applyCertForSaas(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone);
	}

	/**
	 * 申请证书v2.1 后台自动生成唯一标识 代替原数据库手机号字段 数据库中新增real_mobile 真实手机号存储用户手机号信息
	 *
	 * @param type
	 *            类型 1：个人 、2：企业
	 * @param cardType
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            、8:三证合一
	 * @param idCardNum
	 *            证件号码
	 * @param name
	 *            企业或者个人真实名称
	 * @param mobilePhone
	 *            企业或者个人联系手机号
	 * @return
	 */
	public static ECloudDomain applyCertString(String type, String cardType, String idCardNum, String name,
			String mobilePhone) {
		return AccountResult.applyCertString(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone);
	}

	public static ECloudDomain applyCertString(String type, String cardType, String idCardNum, String name,
											   String mobilePhone,boolean isSign) {
		return AccountResult.applyCertString(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone,isSign);
	}

	/**
	 * 证件号申请证书
	 *
	 * @param type
	 *            类型 1：个人 、2：企业
	 * @param cardType
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            、8:三证合一
	 * @param idCardNum
	 *            证件号码
	 * @param name
	 *            企业或者个人真实名称
	 * @return
	 */
	public static ECloudDomain applyCertCardNum(String type, String cardType, String idCardNum, String name) {
		return AccountResult.applyCertCardNum(EcloudPublicKey.instance, type, cardType, idCardNum, name);
	}

	/**
	 * 申请CA证书 12位虚拟手机号
	 *
	 * @param type
	 *            类型 1：个人 、2：企业
	 * @param cardType
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            、8:三证合一
	 * @param idCardNum
	 *            证件号码
	 * @param name
	 *            企业或者个人真实名称
	 * @param mobilePhone
	 *            企业或者个人联系手机号
	 * @return
	 */
	public static ECloudDomain applyCertMobile(String type, String cardType, String idCardNum, String name,
			String mobilePhone) {
		return AccountResult.applyCertMobile(EcloudPublicKey.instance, type, cardType, idCardNum, name, mobilePhone);
	}

	/**
	 * 申请CA证书 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
	 * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"", //
	 * 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
	 *
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain applyCert(String info) {
		return AccountResult.applyCert(EcloudPublicKey.instance, info);
	}
	
	/**
	 * 签署人更换手机 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
	 * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"", //
	 * 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
	 *
	 * @param mobilePhone
	 *            申请者新手机号码
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain changeMobile(String info, String newMobile) {
		return AccountResult.changeMobile(EcloudPublicKey.instance, info, newMobile);
	}

	public static ECloudDomain changeMobile(String type,String cardType,String idCardNum,String name, String newMobile) {
		JSONObject obj= new JSONObject();
		obj.put("type",type);
		obj.put("cardType",cardType);
		obj.put("idCardNum",idCardNum);
		obj.put("name",name);
		return AccountResult.changeMobile(EcloudPublicKey.instance, JSONObject.toJSONString(obj), newMobile);
	}
	
	public static ECloudDomain makeCertInfoToBuf(String makeCertVo, String password, String accType) {
		return AccountResult.makeCertInfoToBuf(EcloudPublicKey.instance, makeCertVo, password, accType);
	}
	
	/**
	 * @param realName
	 *            真实姓名
	 * @param mobile
	 *            手机号
	 * @param bankNumber
	 *            银行卡号
	 * @param idCardNumber
	 *            身份证号
	 * @param verifyType
	 *            认证类型
	 * @return
	 */
	public static ECloudDomain bankVerify(String realName, String mobile, String bankNumber, String idCardNumber,
			Integer verifyType) {
		return AuthResult.bankVerify(EcloudPublicKey.instance, realName, mobile, bankNumber, idCardNumber, verifyType);
	}

	/**
	 * 吊销用户 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型 0：身份证
	 * 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"", // 证件号码
	 * "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
	 *
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain unwrap(String info) {
		return AccountResult.unwrap(EcloudPublicKey.instance, info);
	}

	/**
	 * @param mobilePhone用户手机
	 * @param signType签名类型
	 *            (1签名 2印章)
	 * @return"meta":{ "message":"操作成功", "code":0 }， "data":{ "list": [ {
	 *                 "signId":239, "ctime":"2016-09-05", "isDefault":1,
	 *                 "signImg":"XXXX", "signType":1 } { …… } ] } }
	 */
	public static ECloudDomain getsignList(String mobilePhone, String signType) {
		return SignInfoResult.getsignList(EcloudPublicKey.instance, mobilePhone, signType);
	}
	
	
	public static ECloudDomain getsignListForImage(String idCardNum, String signType) {
		return SignInfoResult.getsignListForImage(EcloudPublicKey.instance, idCardNum, signType);
	}

	/**
	 * @param mobilePhone
	 *            用户手机
	 * @param signId
	 *            签名ID
	 * @return"meta":{ "message":"操作成功", "code":0 }
	 */
	public static ECloudDomain setDefaultSign(String mobilePhone, String signId) {
		return SignInfoResult.setDefaultSign(EcloudPublicKey.instance, mobilePhone, signId);
	}

	/**
	 * @param mobilePhone用户手机
	 * @param signId签名ID
	 * @return"meta":{ "message":"操作成功", "code":0 }
	 */
	public static ECloudDomain delSign(String mobilePhone, String signId) {
		return SignInfoResult.delSign(EcloudPublicKey.instance, mobilePhone, signId);
	}

	/**
	 * 添加
	 *
	 * @param mobilePhone用户手机
	 * @param signId签名ID
	 * @param signImg签名
	 *            /印章图片(base64编码)
	 * @return"meta":{ "message":"操作成功", "code":0 }
	 */


	/**
	 *
	 * @param mobilePhone	用户手机
	 * @param signType	类型：1签名 2印章
	 * @param signImg 签名/印章图片(base64编码)，建议用背景透明的png图片
	 * @return
	 */
	public static ECloudDomain addSign(String mobilePhone, String signType, String signImg) {
		return SignInfoResult.addSign(EcloudPublicKey.instance, mobilePhone, signType, signImg);
	}


	public static ECloudDomain addSign(String mobilePhone, String signType, String signImg,int signWidth ) {
		return SignInfoResult.addSign(EcloudPublicKey.instance, mobilePhone, signType, signImg,signWidth);
	}
	
	/**
	 * 添加
	 *
	 * @param mobilePhone用户手机
	 * @param signId签名ID
	 * @param signImg签名
	 *            /印章图片(base64编码)
	 * @return"meta":{ "message":"操作成功", "code":0 }
	 */
	public static ECloudDomain createNewSign(String mobilePhone, String signId,String width,String heigth) {
		return SignInfoResult.createNewSign(EcloudPublicKey.instance, mobilePhone, signId, width, heigth);
	}
	
	/**
	 * 添加
	 *
	 * @param mobilePhone用户手机
	 * @param signId签名ID
	 * @param signImg签名
	 *            /印章图片(base64编码)
	 * @return"meta":{ "message":"操作成功", "code":0 }
	 */
	public static ECloudDomain addSignForSaas(String mobilePhone, String signType, String signImg) {
		return SignInfoResult.addSignForSaas(EcloudPublicKey.instance, mobilePhone, signType, signImg);
	}

	/**
	 * 创建印章
	 *
	 * @param mobilePhone
	 *            用户手机号 ，必填mobilePhone
	 * @param signName
	 *            签名内容 ，必填 signName
	 * @param fontFamily
	 *            签名字体 ，非必填，默认为宋体（1楷体，2隶书，3宋体，4黑体，5幼圆，6微软雅黑）
	 * @param fontSize
	 *            签名字号 ，非必填，默认32fontSize
	 * @param border
	 *            边框大小 ，非必填，默认值为2，如不需要边框，可设置为0或负数
	 * @param color
	 *            颜色16进制代码 ，非必填，默认为"#FF0000",如需改变颜色，设置对应的颜色值即可
	 */
	public static ECloudDomain createSign(String mobilePhone, String signName, Integer fontFamily, Integer fontSize,
			Integer border, String color) {
		return SignInfoResult.createSign(EcloudPublicKey.instance, mobilePhone, signName, fontFamily, fontSize, border, color);
	}

	/**
	 *  添加模板
	 *
	 * @param templateName
	 *            模板调用名称
	 * @param html
	 *            模板html内容
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "templateNumber":
	 *         "K4rFtSuQSBcdobf6" } }
	 */
	public static ECloudDomain addHtmlTemplate(String templateName, String html) {
		return TemplateResult.addHtmlTemplate(EcloudPublicKey.instance, templateName, html);
	}

	/**
	 *  添加模板
	 *
	 * @param templateName
	 *            模板调用名称
	 * @param html
	 *            模板html内容
	 * @param templateNumber
	 *            模板编号 （非必填）
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "templateNumber":
	 *         "K4rFtSuQSBcdobf6" } }
	 */
	public static ECloudDomain addHtmlTemplate(String templateName, String html, String templateNumber) {
		return TemplateResult.addHtmlTemplate(EcloudPublicKey.instance, templateName, html, templateNumber);
	}

	/**
	 *  添加模板
	 *
	 * @param templateName
	 *            模板调用名称
	 * @param html
	 *            模板html内容
	 * @param templateNumber
	 *            模板编号 （非必填）
	 * @param signPosition
	 *            签章位置列表,json字符串 非必填
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "templateNumber":
	 *         "K4rFtSuQSBcdobf6" } }
	 */
	public static ECloudDomain addHtmlTemplate(String templateName, String html, String templateNumber,
			String signPosition) {
		return TemplateResult.addHtmlTemplate(EcloudPublicKey.instance, templateName, html, templateNumber, signPosition);
	}

	/**
	 * 添加模板和变量
	 *
	 * @param templateNumber模板编号
	 * @param templateName模板名称
	 * @param html模板html内容
	 * @param vars模板变量jason
	 * 			@return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
	 *            "templateNumber": "K4rFtSuQSBcdobf6" } }
	 */
	public static ECloudDomain addHtmlTemplateByVar(String templateNumber, String templateName, String html,
			String vars) {
		return TemplateResult.addHtmlTemplateByVar(EcloudPublicKey.instance, templateNumber, templateName, html, vars);
	}

	/**
	 *  更新模板
	 *
	 * @param templateNumber
	 *            模板编号
	 * @param templateName
	 *            模板名称
	 * @param html
	 *            模板html内容
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain editHtmlTemplate(String templateNumber, String templateName, String html) {
		return TemplateResult.editHtmlTemplate(EcloudPublicKey.instance, templateNumber, templateName, html);
	}

	public static ECloudDomain editHtmlTemplate(String templateNumber, String templateName, String html,
			String signPosition) {
		return TemplateResult.editHtmlTemplate(EcloudPublicKey.instance, templateNumber, templateName, html, signPosition);
	}

	/**
	 *  更新模板和变量
	 *
	 * @param templateNumber
	 *            模板编号
	 * @param templateName
	 *            模板名称
	 * @param html
	 *            模板html内容
	 * @param vars
	 *            变量内容
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain editHtmlTemplateByVar(String templateNumber, String templateName, String html,
			String vars) {
		return TemplateResult.editHtmlTemplateByVar(EcloudPublicKey.instance, templateNumber, templateName, html, vars);
	}

	/**
	 * 删除模板
	 *
	 * @param templateNumber
	 *            模板编号
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain delHtmlTemplate(String templateNumber) {
		return TemplateResult.delHtmlTemplate(EcloudPublicKey.instance, templateNumber);
	}

	/**
	 * 获取模板列表
	 *
	 * @param currentPage当前页数
	 *            ，默认为1
	 * @param pageSize每页的记录数
	 *            ，最大为100
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "pageInfo":{
	 *         "currentPage":1, "pageSize":10, "totalPage":1, "totalRecord":5 },
	 *         "list":[ { "templateNumber": "XXX", "templateName":"XXX", }, ...... ]
	 *         } }
	 */
	public static ECloudDomain getTemplateList(String currentPage, String pageSize) {
		return TemplateResult.getTemplateList(EcloudPublicKey.instance, currentPage, pageSize);
	}

	/**
	 * 获取模板内容
	 *
	 * @param templateNumber
	 *            模板ID @return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
	 *            "cont": "xxx" } }
	 */
	public static ECloudDomain getTemplateCont(String templateNumber) {
		return TemplateResult.getTemplateCont(EcloudPublicKey.instance, templateNumber);
	}

	/**
	 * 获得模板变量
	 *
	 * @param templateNumber
	 *            模板编号
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "list":[ {
	 *         "name": "变量名称", "nameDisplay": "变量显示名称", "textAlign": "0", // 对齐方式
	 *         ,0:居中,1:左对 齐，2：右对齐 "type": "1", // 数据类型 1：文本，2：日期，3：数字 "minLen": "0",
	 *         // 最小长度 "maxLen": "10", // 最大长度 "required": "0", // 是否必填 0非必填 1必填
	 *         "underline": "0", // 是否有下划线 0有划线 1无下划线 "defaultValue": "变量值",
	 *         "autoGenDate": "0", // 是否自动生成日期 0不生成 1生 成 }, { ..... } ] } }
	 */
	public static ECloudDomain getTemplateVars(String templateNumber) {
		return TemplateResult.getTemplateVars(EcloudPublicKey.instance, templateNumber);
	}

	/**
	 *  根据模板生成合同文档
	 *
	 * @param templateNumber模板编号
	 * @param replaceVal
	 *            模板变量值 @return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
	 *            "contractNum": "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain createContractByTemplate(String templateNumber, String replaceVal) {
		return TemplateResult.createContractByTemplate(EcloudPublicKey.instance, templateNumber, replaceVal);
	}

	/**
	 *  根据模板生成合同文档
	 *
	 * @param templateNumber模板编号
	 * @param replaceVal
	 *            模板变量值
	 * @param contractNum
	 *            合同编号 @return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
	 *            "contractNum": "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain createContractByTemplate(String templateNumber, String replaceVal, String contractNum) {
		return TemplateResult.createContractByTemplate(EcloudPublicKey.instance, templateNumber, replaceVal, contractNum);
	}

	public static ECloudDomain createContractByTemplate(String templateNumber, String replaceVal, String contractNum,
			String orientation) {
		return TemplateResult.createContractByTemplate(EcloudPublicKey.instance, templateNumber, replaceVal, contractNum, orientation);
	}

	/**
	 *  根据模板生成合同文档
	 *
	 * @param templateNumber模板编号
	 * @param vars
	 *            模板变量值 @return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
	 *            "contractNum": "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain createContractByTemplateByVar(String templateNumber, String vars) {
		return TemplateResult.createContractByTemplateByVar(EcloudPublicKey.instance, templateNumber, vars, "V");
	}

	public static ECloudDomain createContractByTemplateByVar(String templateNumber, String vars, String orientation) {
		return TemplateResult.createContractByTemplateByVar(EcloudPublicKey.instance, templateNumber, vars, orientation);
	}

	/**
	 * 获取合同列表
	 *
	 * @param mobilePhone用户手机
	 * @param currentPage当前页数
	 *            ，默认为1
	 * @param pageSize每页的记录数
	 *            ，最大为100
	 * @return
	 */
	public static ECloudDomain getContractList(String mobilePhone, String currentPage, String pageSize) {
		return ContractResult.getContractList(EcloudPublicKey.instance, mobilePhone, currentPage, pageSize);
	}

	/**
	 * @param mobilePhone用户手机号码
	 * @param contractNum合同编号唯一标识
	 * @return
	 */
	public static ECloudDomain getContractDetail(String mobilePhone, String contractNum) {
		return ContractResult.getContractDetail(EcloudPublicKey.instance, mobilePhone, contractNum);
	}

	/**
	 * 下载存证页
	 * @param mobilePhone
	 * @param contractNum
	 * @return
	 */
	/*public static ECloudDomain getDownloadEvidenceUrl(String mobilePhone, String contractNum) {
		return ContractResult.getDownloadEvidenceUrl(EcloudPublicKey.instance, mobilePhone, contractNum);
	}*/
	
	
	/**
	 * @param mobilePhone用户手机号码
	 * @param contractNum合同编号唯一标识
	 * @return
	 */
	public static ECloudDomain getContractImageList(String mobilePhone, String contractNum,String signPosition) {
		return ContractResult.getContractImageList(EcloudPublicKey.instance, mobilePhone, contractNum,signPosition);
	}

	/**
	 * @param mobilePhone
	 *            用户手机号码
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return
	 */
	public static ECloudDomain getContractDetailUp(String mobilePhone, String contractNum) {
		return ContractResult.getContractDetailUp(EcloudPublicKey.instance, mobilePhone, contractNum);
	}

	/**
	 * 获取合同图片
	 * 
	 * @param mobilePhone
	 *            用户手机号码
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return
	 */
	public static ECloudDomain getContractImgs(String mobilePhone, String contractNum) {
		return ContractResult.getContractImgs(EcloudPublicKey.instance, mobilePhone, contractNum);
	}

	/**
	 * 自动签署合同
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
	 *         "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain autoSign(String signerInfo, String contractNum, Integer isFinish) {
		return ContractResult.autoSign(EcloudPublicKey.instance, signerInfo, contractNum, isFinish);
	}

	/**
	 * 自动签署合同-新saas无效签章
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
	 *         "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain autoSignInvalidSeal(String signType, String pdfPath, String signInfo) {
		return ContractResult.autoSignInvalidSeal(EcloudPublicKey.instance, signType, pdfPath, signInfo);
	}

	/**
	 * 自动签署合同
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @param signInfo
	 *            签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
	 *            "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
	 *            //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
	 *            //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
	 *         "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain autoSign(String signerInfo, String contractNum, Integer isFinish, String signInfo) {
		return ContractResult.autoSign(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, signInfo);
	}

	/**
	 * 自动签署合同 字符申请证书
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @param signInfo
	 *            签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
	 *            "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
	 *            //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
	 *            //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
	 *         "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain autoSignForString(String signerInfo, String contractNum, Integer isFinish,
			String signInfo) {
		return ContractResult.autoSignForString(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, signInfo);
	}

	public static ECloudDomain autoSignForCardNum(String signerInfo, String contractNum, Integer isFinish,
			String signInfo) {
		return ContractResult.autoSignForCardNum(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, signInfo);
	}

	/**
	 * 发起合同
	 *
	 * @param keyWord合同关键字
	 * @param contractName合同名称
	 * @param days合同有效天数
	 *            ，最大180天
	 * @param mobilePhone发起方手机
	 * @param toMobile合同签署人手机号码
	 *            ，签署顺序必须按照传入顺序， 否则签署不了
	 * @param position坐标信息jason
	 *            [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标 "signId":23
	 *            //签章/签名id } ]
	 * @return
	 */
	public static ECloudDomain launchContract(String keyWord, String contractName, Integer days, String mobilePhone,
			String[] toMobile, String position, String contractNum) {
		return ContractResult.launchContract(EcloudPublicKey.instance, keyWord, contractName, days, mobilePhone, toMobile, position, contractNum);
	}

	/**
	 * 发起合同 自动签或网签
	 *
	 * @param keyWord合同关键字
	 * @param contractName合同名称
	 * @param days合同有效天数
	 *            ，最大180天
	 * @param contractNum合同号
	 * @param position坐标信息数组jason
	 *            { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
	 *            "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名 2印章}
	 *            、 { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
	 *            "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名 2印章}
	 *            { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
	 *            "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名 2印章}
	 *            ...
	 * @return
	 */
	public static ECloudDomain launchContractAutoSignAndSendSms(String keyWord, String contractName, Integer days,
			String contractNum, String[] signerInfos) {
		return ContractResult.launchContractAutoSignAndSendSms(EcloudPublicKey.instance, keyWord, contractName, days, contractNum, signerInfos);
	}

	/**
	 * 发起合同并短信通知
	 *
	 * @param keyWord合同关键字
	 * @param contractName合同名称
	 * @param days合同有效天数
	 *            ，最大180天
	 * @param mobilePhone发起方手机
	 * @param toMobile合同签署人手机号码
	 *            ，签署顺序必须按照传入顺序， 否则签署不了
	 * @param position坐标信息jason
	 *            [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标 "signId":23
	 *            //签章/签名id } ]
	 * @return
	 */
	public static ECloudDomain launchContractSendSms(String keyWord, String contractName, Integer days,
			String mobilePhone, String[] toMobile, String position, String contractNum) {
		return ContractResult.launchContractSendSms(EcloudPublicKey.instance, keyWord, contractName, days, mobilePhone, toMobile, position,
				contractNum);
	}

	/**
	 * 合同签署
	 *
	 * @param contractNum合同编号
	 * @param mobilePhone发起方手机
	 * @param position坐标信息jason
	 *            [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标 "signId":23
	 *            //签章/签名id } ]
	 * @return
	 */
	public static ECloudDomain sealContract(String contractNum, String mobilePhone, String position) {
		return ContractResult.sealContract(EcloudPublicKey.instance, contractNum, mobilePhone, position);
	}

	/**
	 * 签章合同文档下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static ECloudDomain downloadContract(String contractNum) {
		return ContractResult.downloadContract(EcloudPublicKey.instance, contractNum);
	}

	/**
	 * 签章合同文档下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static ECloudDomain downloadContractBase64(String contractNum) {
		return ContractResult.downloadContractBase64(EcloudPublicKey.instance, contractNum);
	}

	/**
	 * 签章合同文档下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param targetPath
	 *            下载路径
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static void downloadContract(String contractNum, String targetPath) {
		ContractResult.downloadContract(EcloudPublicKey.instance, contractNum, targetPath);
	}

	/**
	 * 用户授权验证签署合同 6.4.4
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @param signInfo
	 *            签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
	 *            "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
	 *            //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
	 *            //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
	 * @param dynamicCode动态验证码
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
	 *         "Y90GVbAB1bN1tvn9" } }
	 */
	public static ECloudDomain authorizeSign(String signerInfo, String contractNum, Integer isFinish, String signInfo,
			String dynamicCode) {
		return ContractResult.authorizeSign(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, signInfo, dynamicCode);
	}

	/**
	 * 合同签署动态验证码发送6.4.7
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param mobilePhone
	 *            必须是用户签署所用手机号码，发送验证码后，在用户签署的时 候需要进行验证
	 * @param smsTemplate可不填
	 *            ，默认安装易云章通用格式进行发送，如果需要定制，需 要申请
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain sendSms(String contractNum, String mobilePhone, String smsType) {
		return ContractResult.sendSms(EcloudPublicKey.instance, contractNum, mobilePhone, smsType);
	}

	/**
	 * 签署人更换手机 6.1.3 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 * 证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 * "idCardNum":"", // 证件号码 }
	 *
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain getCertInfo(String info) {
		return AccountResult.getCertInfo(EcloudPublicKey.instance, info);
	}

	public static ECloudDomain getCertInfo(String type,String cardType, String idCardNum) {
		JSONObject object= new JSONObject();
		object.put("type",type);
		object.put("cardType",cardType);
		object.put("idCardNum",idCardNum);
		return AccountResult.getCertInfo(EcloudPublicKey.instance, JSONObject.toJSONString(object));
	}

	/**
	 * 签署人更换手机 6.1.3 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 * 证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 * "idCardNum":"", // 证件号码 }
	 *
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain getCertInfoString(String info) {
		return AccountResult.getCertInfoString(EcloudPublicKey.instance, info);
	}

	/**
	 * 用户证书延期 6.1.4 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 * 证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 * "idCardNum":"", // 证件号码 }
	 *
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain renewCert(String info) {
		return AccountResult.renewCert(EcloudPublicKey.instance, info);
	}

	/**
	 * 合同作废
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param mobilePhone
	 *            作废发起人手机
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain cancelContract(String contractNum, String mobilePhone) {
		return ContractResult.cancelContract(EcloudPublicKey.instance, contractNum, mobilePhone);
	}
	
	
	/**
	 * 合同作废
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param mobilePhone
	 *            作废发起人手机
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain contractCancel(String contractNum, String mobilePhone) {
		return ContractResult.contractCancel(EcloudPublicKey.instance, contractNum, mobilePhone);
	}

	/**
	 * 合同验真
	 *
	 * @param file
	 *            pdf文件
	 * @param mobilePhone
	 *            作废发起人手机
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain verify(File file) {
		return ContractResult.verify(EcloudPublicKey.instance, file);
	}

	/**
	 * 自动生成印章
	 *
	 * @param mobilePhone
	 *            用户手机
	 * @param unitName
	 *            印章单位名称 ，如北京爱知之星科技股份有限公司，建议在16个 汉子之内
	 * @param sealName
	 *            印章名称 ，如合同专用章
	 * @param sealNumber
	 *            印章序列号 ，如 127920
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data":{ "signId":1234}}
	 */
	public static ECloudDomain createSeal(String mobilePhone, String unitName, String sealName, String sealNumber) {
		return SignInfoResult.createSeal(EcloudPublicKey.instance, mobilePhone, unitName, sealName, sealNumber);
	}

	public static ECloudDomain getBatchSignUrl(String telephone, String cardType, String idCardNum, String callBack,String wxCallBack,String type, List<ContractInfoSignApiParam> contracts) {
		return SignInfoResult.getBatchSignUrl( EcloudPublicKey.instance,telephone, cardType,idCardNum,callBack,wxCallBack,type, contracts);
	}



	/**
	 * 自动生成印章
	 *
	 * @param mobilePhone
	 *            用户手机
	 * @param unitName
	 *            印章单位名称 ，如北京爱知之星科技股份有限公司，建议在24个 汉子之内
	 * @param sealName
	 *            印章名称 ，如合同专用章
	 * @param sealNumber
	 *            印章序列号 ，如 127920 20字符以内
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data":{ "signId":1234}}
	 */
	public static ECloudDomain createSealLong(String mobilePhone, String unitName, String sealName, String sealNumber) {
		return SignInfoResult.createSealLong(EcloudPublicKey.instance, mobilePhone, unitName, sealName, sealNumber);
	}

	/**
	 * 自动签署合同：根据盖章位置
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @param position
	 *            签章位置
	 * @return
	 */
	public static ECloudDomain autoSignByPoistion(String signerInfo, String contractNum, Integer isFinish,
			String position) {
		return ContractResult.autoSignByPoistion(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position);
	}

	/**
	 *
	 * @param signerInfo
	 * @param contractNum
	 * @param isFinish
	 * @param position
	 * @return
	 */
	public static ECloudDomain autoSignByPoistionOld(String signerInfo, String contractNum, Integer isFinish,
												  String position) {
		return ContractResult.autoSignByPoistionOld(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position);
	}


	public static ECloudDomain autoSignByPoistionNoSms(String signerInfo, String contractNum, Integer isFinish,
												  String position) {
		return ContractResult.autoSignByPoistionNoSms(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position);
	}
	
	/**
	 * 自动签署合同带日期
	 * <p>Title: autoSignByPoistion</p>  
	 * <p>Description: </p>  
	 * @param signerInfo
	 * @param contractNum
	 * @param isFinish
	 * @param position
	 * @return
	 */
	
	public static ECloudDomain autoSignByPoistionForDateImage(String signerInfo, String contractNum, Integer isFinish,
			String position) {
		return ContractResult.autoSignByPoistionForDateImage(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position);
	}
	
	/**
	 * pdf签署不存储
	 * <p>Title: autoSignForPdfBase64</p>  
	 * <p>Description: </p>  
	 * @param signerInfo
	 * @param pdfBase64
	 * @param contractNum
	 * @param isFinish
	 * @param signInfo
	 * @return
	 */
	public static ECloudDomain autoSignForPdfBase64(String signerInfo,  String pdfBase64,String contractNum,
			 Integer isFinish, String signInfo) {
		return ContractResult.autoSignForPdfBase64(EcloudPublicKey.instance, signerInfo, pdfBase64, contractNum, isFinish, signInfo);
	}
	
	/**
	 * 获取上链编号
	 * <p>Title: contractEvidence</p>  
	 * <p>Description: </p>  
	 * @param contractNum
	 * @return
	 */
	public static ECloudDomain contractEvidence(String contractNum) {
		return ContractResult.contractEvidence(EcloudPublicKey.instance, contractNum);
	}
	
	/**
	 * 批量签署
	 * <p>Title: autoSignByPoistion</p>  
	 * <p>Description: </p>  
	 * @param signerInfo
	 * @param contractNum
	 * @param isFinish
	 * @param position
	 * @return
	 */
	public static ECloudDomain batchSigning(String signInfo) {
		return ContractResult.batchSigning(EcloudPublicKey.instance, signInfo);
	}
	
	
	/**
	 * 自动签署合同带日期
	 * <p>Title: autoSignByPoistion</p>  
	 * <p>Description: </p>  
	 * @param signerInfo
	 * @param contractNum
	 * @param isFinish
	 * @param position
	 * @return
	 */
	public static ECloudDomain autoSignByPoistionApiSaas(String signerInfo, String contractNum, Integer isFinish,
			String position,String dynamicCode) {
		return ContractResult.autoSignByPoistionApiSaas(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position, dynamicCode);
	}

	/**
	 * 自动签署合同：根据盖章位置
	 *
	 * @param signerInfo
	 *            签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
	 *            证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
	 *            idCardNum ":"", // 证件号码 "name":"", //企业或者个人真实名称 " mobilePhone":""
	 *            //企业或者个人联系手机号 } 4
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param isFinish
	 *            合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
	 *            个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
	 * @param position
	 *            签章位置
	 * @return
	 */
	public static ECloudDomain autoSignByPoistionForMobile12(String signerInfo, String contractNum, Integer isFinish,
			String position) {
		return ContractResult.autoSignByPoistionForMobile12(EcloudPublicKey.instance, signerInfo, contractNum, isFinish, position);
	}

	/**
	 * 6.5.1 上传文件创建合同
	 *
	 * @param file
	 *            pdf文件
	 * @param mobilePhone
	 *            发起人手机
	 * @param contractNum
	 *            合同编号
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain createContract(String contractNum, String mobilePhone, File file) {

		return ContractResult.createContract(EcloudPublicKey.instance, contractNum, mobilePhone, file);
	}

	/**
	 * 6.5.1 上传文件创建无效合同
	 *
	 * @param file
	 *            pdf文件
	 * @param mobilePhone
	 *            发起人手机
	 * @param contractNum
	 *            合同编号
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain createInvalidContract(File file) {

		return ContractResult.createInvalidContract(EcloudPublicKey.instance, file);
	}

	/**
	 * 6.5.2 合同文件下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static ECloudDomain downloadCont(String contractNum, String mobilePhone) {
		return ContractResult.downloadCont(EcloudPublicKey.instance, contractNum, mobilePhone);
	}

	/**
	 *
	 * @param contractNum
	 * @param mobilePhone
	 * @return
	 */
	public static ECloudDomain viewEvidence(String contractNum, String mobilePhone) {
		return ContractResult.viewEvidence(EcloudPublicKey.instance, contractNum, mobilePhone);
	}

	/**
	 * 获取下载存证链接
	 * @param contractNum
	 * @param mobilePhone
	 * @return
	 */
	public static ECloudDomain getDownloadEvidenceUrl(String contractNum, String mobilePhone) {
		return ContractResult.getDownloadEvidenceUrl(EcloudPublicKey.instance, contractNum, mobilePhone);
	}

	/**
	 * 6.5.2 合同文件下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static ECloudDomain downloadCont(int i ,String contractNum, String mobilePhone, String targetPath) {
		return ContractResult.downloadCont(EcloudPublicKey.instance, i,contractNum, mobilePhone, targetPath);
	}
	
	/**
	 * 6.5.2 合同文件下载
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
	 *         "字节数组字符串，请用utf-8编码转换为byte[]" } }
	 */
	public static ECloudDomain downloadCont(String contractNum, String mobilePhone, String targetPath) {
		return ContractResult.downloadCont(EcloudPublicKey.instance, contractNum, mobilePhone, targetPath);
	}



	/**
	 * 下载合同 （接收二进制流保存文件）
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param localFileName
	 *            文件保存路径及名称 （d://ceshi.pdf）需包括文件格式后缀
	 * @return { "meta":{ "code":"0", "message":"操作成功" }
	 */
	public static ECloudDomain downloadContractBin(String contractNum, String localFileName) {
		return ContractResult.downloadContractBin(EcloudPublicKey.instance, contractNum, localFileName);
	}

	/**
	 * 6.6.1 用户身份认证信息
	 *
	 * @param cardImg1
	 *            身份证正面
	 * @param cardImg2
	 *            身份证正面
	 * @return { "data": { "cardImg1": { "name":"xx" //姓名 "birthday":"1994年09月18日",
	 *         //出生日期 "sex":"男", //性别 "folk": "汉", //民族
	 *         "cardno":"110111199999990987", //身份证 "birthday":"1994年09月18日", //出生年月
	 *         "address":"北京市朝阳区XXX" //住址 }, "cardImg2": { "authority":"北京市公安局朝阳分局",
	 *         //发证机关 "validdate1":"20120130", //有效期 "validdate2":"20320130", //有效期
	 *         }, }, "meta": { "message": "操作成功", "code": 0 } }
	 */
	public static ECloudDomain idCard(File cardImg1, File cardImg2) {
		return AccountResult.idCard(EcloudPublicKey.instance, cardImg1, cardImg2);
	}

	/**
	 * 撤销合同合同其他人未签署，才可以撤回
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param mobilePhone
	 *            发起人手机，此手机必须为原合同的合同创建者、合同签署人
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain contractRevoke(String contractNum, String mobilePhone) {
		return ContractResult.contractRevoke(EcloudPublicKey.instance, contractNum, mobilePhone);
	}

	/**
	 * 退回合同
	 *
	 * @param contractNum
	 *            合同编号唯一标识
	 * @param mobilePhone
	 *            发起人手机，此手机必须为原合同的合同创建者、合同签署人
	 * @param remark
	 *            退回理由，(50个汉字内)
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain rejectContract(String contractNum, String mobilePhone, String remark) {
		return ContractResult.rejectContract(EcloudPublicKey.instance, contractNum, mobilePhone, remark);
	}

	/**
	 * @param contractNum
	 *            合同编号
	 * @param signerInfo
	 *            签署人信息 signerInfo格式： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0",
	 *            // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商 登记证、5：税务登记证、6：组织机构代码、7：其他证件
	 *            idCardNum":"", // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":""
	 *            //企业或者个人联系手机号 }
	 * @param i
	 *            是否完成标志 0:是,1:否
	 * @param ruleInfo
	 *            签章规则 （关键字） ruleInfo格式： { "signType":"1", //类型 签名类型，1签名 2印章
	 *            "signId":"0", //签章或者签字ID，如果不指定，则用户默认设置 "keyWord":"甲方" //关键字
	 *            "beginPage": 1, // 关键字查找开始页，大于等于1 "endPage": -1, //
	 *            关键字查找结束页，大于等于-3小于等于beginPage，-1、-2、-3 分别代表倒数第一、第二、第三页 "orderBy":
	 *            "DESC", // 排序，正序ASC，倒序DESC "sealNum": 1, // 盖章个数，大于等于1 "x": 0, //
	 *            盖章位置偏移，负数向左移动，正数向右移动 "y": 0 // 盖章位置偏移，负数向下移动，正数向上移动 }
	 * @return
	 */
	public static ECloudDomain sealByKeyword(String contractNum, String signerInfo, int i, String ruleInfo) {
		return ContractResult.sealByKeyword(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo);
	}

	/**
	 * 关键字签署盖图片字体
	 * <p>
	 * Title: sealByKeywordForImage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param contractNum
	 * @param signerInfo
	 * @param i
	 * @param ruleInfo
	 * @param signImageInfo
	 * @return
	 */
	public static ECloudDomain sealByKeywordForImage(String contractNum, String signerInfo, int i, String ruleInfo,
			String signImageInfo) {
		return ContractResult.sealByKeywordForImage(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo, signImageInfo);
	}

	/**
	 * public static ECloudDomain remoteApplySeal(String jsonInfo) { Map<String,
	 * String> map = new TreeMap<String, String>(); map.put("info", jsonInfo);
	 * ECloudBean eCloudBean = new ECloudBean(SdkApiAction.REMOTE_APPLY_SEAL_ACTION,
	 * SdkApiAction.METHODPOST, map); ECloudDomain ed = eCloudBean.executeMethod();
	 * System.out.println(ed); return ed; } 远程生情证书
	 *
	 * @param jsonInfo
	 * @return
	 */
	public static ECloudDomain remoteApplySeal(String jsonInfo) {
		return AccountResult.remoteApplySeal(EcloudPublicKey.instance, jsonInfo);
	}

	/**
	 * 6.2.5 获取签名/印章
	 *
	 * @param mobilePhone
	 *            发起人手机，此手机必须为原合同的合同创建者、合同签署人
	 * @param signId
	 *            签名/印章 id
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain getSignImg(String mobilePhone, String signId) {
		return SignInfoResult.getSignImg(EcloudPublicKey.instance, mobilePhone, signId);
	}

	/**
	 *
	 * 【特别注意，该请求直接使用web前端跳转即可，不用调用】
	 * 6.2.6 页面手写签名
	 *
	 * @param mobilePhone
	 *            用户手机号
	 * @param signType
	 *            签章类型
	 * @param returnUrl
	 *            跳转地址
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	@Deprecated
	public static ECloudDomain signPage(String mobilePhone, String signType, String returnUrl) {
		//throw new RuntimeException("该请求直接使用web前端跳转即可,参考接口文档说明https://easydoc.net/doc/38059461/yYlVvFl2/TqQDgQKX");
		return SignInfoResult.signPage(EcloudPublicKey.instance, mobilePhone, signType, returnUrl);
	}

	/**
	 * @param contractNum
	 *            合同编号
	 * @param signerInfo
	 *            签署人信息 signerInfo格式： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0",
	 *            // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商 登记证、5：税务登记证、6：组织机构代码、7：其他证件
	 *            idCardNum":"", // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":""
	 *            //企业或者个人联系手机号 }
	 * @param i
	 *            是否完成标志 0:是,1:否
	 * @param ruleInfo
	 *            签章规则 （关键字） ruleInfo格式： { "signType":"1", //类型 签名类型，1签名 2印章
	 *            "signId":"0", //签章或者签字ID，如果不指定，则用户默认设置 "sealType":"1"
	 *            //签署类型，1骑缝章，2多页相同位置批量签 "firstSeal": 30, // 骑缝章第一个切图百分比，20到80之间
	 *            "straddleMode": "R", //骑缝模式：L左骑缝 R右骑缝 "beginPage": "DESC", //
	 *            起始页（页码翻译， 0=1， 小于1=-1=最后一页） "endPage": 1, //结束页（页码翻译， 0=1，
	 *            小于1=-1=最后一页，大于pdf实际页码=最后一页，比beginPage小与其进行交换） "x": 200, //
	 *            签署位置x坐标，如果是骑缝章，该值不用传 "y": 25000
	 *            //签署位置y坐标，如果是骑缝章，该值单位不是像素，而是将页面高度分割成50000份后，盖章位置占50000的比例，比如盖在中间，该值为25000；该值默认为25000
	 *            盖章位置偏移，负数向下移动，正数向上移动 }
	 * @return
	 */
	public static ECloudDomain multipleSeal(String contractNum, String signerInfo, int i, String ruleInfo) {
		return ContractResult.multipleSeal(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo);
	}
	
	/**
	 * @param contractNum
	 *            合同编号
	 * @param signerInfo
	 *            签署人信息 signerInfo格式： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0",
	 *            // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商 登记证、5：税务登记证、6：组织机构代码、7：其他证件
	 *            idCardNum":"", // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":""
	 *            //企业或者个人联系手机号 }
	 * @param i
	 *            是否完成标志 0:是,1:否
	 * @param ruleInfo
	 *            签章规则 （关键字） ruleInfo格式： { "signType":"1", //类型 签名类型，1签名 2印章
	 *            "signId":"0", //签章或者签字ID，如果不指定，则用户默认设置 "sealType":"1"
	 *            //签署类型，1骑缝章，2多页相同位置批量签 "firstSeal": 30, // 骑缝章第一个切图百分比，20到80之间
	 *            "straddleMode": "R", //骑缝模式：L左骑缝 R右骑缝 "beginPage": "DESC", //
	 *            起始页（页码翻译， 0=1， 小于1=-1=最后一页） "endPage": 1, //结束页（页码翻译， 0=1，
	 *            小于1=-1=最后一页，大于pdf实际页码=最后一页，比beginPage小与其进行交换） "x": 200, //
	 *            签署位置x坐标，如果是骑缝章，该值不用传 "y": 25000
	 *            //签署位置y坐标，如果是骑缝章，该值单位不是像素，而是将页面高度分割成50000份后，盖章位置占50000的比例，比如盖在中间，该值为25000；该值默认为25000
	 *            盖章位置偏移，负数向下移动，正数向上移动 }
	 * @return
	 */
	public static ECloudDomain multipleSealApiSaas(String contractNum, String signerInfo, int i, String ruleInfo,String dynamicCode) {
		return ContractResult.multipleSealApiSaas(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo, dynamicCode);
	}

	/**
	 * 新saas骑缝章
	 * <p>
	 * Title: MULTIPLENEWSEAL_ACTION
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param contractNum
	 * @param signerInfo
	 * @param i
	 * @param ruleInfo
	 * @return
	 */
	public static ECloudDomain multipleNewSeal(String contractNum, String signerInfo, int i, String ruleInfo) {
		return ContractResult.multipleNewSeal(EcloudPublicKey.instance, contractNum, signerInfo, i, ruleInfo);
	}

	/**
	 * 电子数据存证
	 *
	 * @param thirdPartId
	 *            平台用户id
	 * @param fileHash
	 *            文件hash
	 * @return
	 */
	public static ECloudDomain saveFileHash(String thirdPartId, String fileHash) {
		return ContractResult.saveFileHash(EcloudPublicKey.instance, thirdPartId, fileHash);
	}

	public static ECloudDomain pdfAddImage(File pdfFile, File imageFile, String width, String height, String page) {
		return ContractResult.pdfAddImage(EcloudPublicKey.instance, pdfFile, imageFile, width, height, page);
	}

	public static ECloudDomain genCircleSeal(String companyName, String sealType, String sealNumber) {
		return SignInfoResult.genCircleSeal(EcloudPublicKey.instance, companyName, sealType, sealNumber);
	}

	public static ECloudDomain genPersonRectangleSeal(String name) {
		return SignInfoResult.genPersonRectangleSeal(EcloudPublicKey.instance, name);
	}
	public static ECloudDomain genPersonRectangleSeal(String name,int fontSize) {
		return SignInfoResult.genPersonRectangleSeal(EcloudPublicKey.instance, name);
	}

	public static ECloudDomain genPersonRectangleSeal(String name,int width,int height) {
		return SignInfoResult.genPersonRectangleSeal(EcloudPublicKey.instance, name,width,height);
	}

	public static ECloudDomain dynCirSeal(String firm, String type, String number, String isPentagram, String size,
			String signType) {
		return SignInfoResult.dynCirSeal(EcloudPublicKey.instance, firm, type, number, isPentagram, size, signType);
	}

	public static ECloudDomain graySeal(String subject, String extraInfo, String type) {
		return SignInfoResult.graySeal(EcloudPublicKey.instance, subject, extraInfo, type);
	}

	public static ECloudDomain register(String mobile, String password) {
		return AccountResult.register(EcloudPublicKey.instance, mobile, password);
	}

	/**
	 * word、excel 转PDF
	 * 
	 * @param wFile
	 *            word文件
	 * @return
	 */
	public static ECloudDomain wordToPdf(File wFile) {
		return ContractResult.wordToPdf(EcloudPublicKey.instance, wFile);
	}

	/**
	 * word、excel 转PDF
	 * 
	 * @param wFile
	 *            word文件
	 * @param targetPath
	 *            输出路径
	 * @return
	 */
	public static void wordToPdfForPath(File wFile, String targetPath) {
		ECloudDomain result = ContractResult.wordToPdf(EcloudPublicKey.instance, wFile);
		FileUtil.ecloudToFile(result, targetPath);
	}

	/**
	 * html转PDF
	 * 
	 * @param content
	 *            html 内容
	 * @return
	 */
	public static ECloudDomain htmlToPdf(String content) {
		return ContractResult.htmlToPdf(EcloudPublicKey.instance, content);

	}

	/**
	 * html转PDF
	 * 
	 * @param content
	 *            html 内容
	 * @return
	 */
	public static ECloudDomain html2Word(String content) {
		return ContractResult.html2Word(EcloudPublicKey.instance, content);

	}

	/**
	 * html转PDF
	 * 
	 * @param file
	 *            pdf文件
	 * @return
	 */
	public static ECloudDomain pdf2Img(File file) {
		return ContractResult.pdf2Img(EcloudPublicKey.instance, file);

	}

	/**
	 * html转PDF
	 * 
	 * @param content
	 *            html 内容
	 * @param targetPath
	 *            输出路径
	 * @return
	 */
	// public static void htmlToPdfForPath(String content,String targetPath) throws
	// Exception {
	// ECloudDomain result = ContractResult.htmlToPdf(content);
	// FileUtil.ecloudToFile(result, targetPath);
	// JSONObject o2 = JSONObject.parseObject(result.getData().toString());
	// JSONArray arr = o2.getJSONArray("base64");
	// for (int i = 0; i < arr.size(); i++) {
	// FileUtil.decoderBase64File(arr.getString(i),"/Users/Bob/Desktop/testHTml"+i+".png");
	// }
	// }
	public static void html2WordPath(String content, String targetPath) {
		ECloudDomain result = ContractResult.html2Word(EcloudPublicKey.instance, content);
		FileUtil.ecloudToFile(result, targetPath);
	}

	public static ECloudDomain delRedis() {
		return ContractResult.delRedis(EcloudPublicKey.instance);
	}

	/**
	 * 文档转换
	 * <p>
	 * Title: docUpload
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	public static ECloudDomain docUpload(File file) {
		return TemplateResult.docUpload(EcloudPublicKey.instance, file);
	}

	/**
	 * 三要素识别
	 * <p>Title: threeElementsIdentification</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param telephone
	 * @param idCardNo
	 * @return
	 */
	public static ECloudDomain threeElementsIdentification(String name, String telephone, String idCardNo) {
		return ContractResult.threeElementsIdentification(EcloudPublicKey.instance, name, telephone, idCardNo);
	}
	
	/**
	 * 四要素识别
	 * <p>Title: threeElementsIdentification</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param telephone
	 * @param idCardNo
	 * @return
	 */
	public static ECloudDomain fourElementsIdentification(String name, String comName, String idCardNo, String comNo) {
		return ContractResult.fourElementsIdentification(EcloudPublicKey.instance, name, comName, idCardNo, comNo);

	}
	
	/**
	 * 企业三要素识别
	 * <p>Title: threeElementsIdentification</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param telephone
	 * @param idCardNo
	 * @return
	 */
	public static ECloudDomain busThreeElementsIdentification(String name, String comName, String comNo) {
		return ContractResult.busThreeElementsIdentification(EcloudPublicKey.instance, name, comName, comNo);

	}

	/**
	 * 二要素识别
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain identityAuthUrl(String name, String idNumber) {
		return ContractResult.identityAuthUrl(EcloudPublicKey.instance, name, idNumber);

	}
	
	/**
	 * 获取认证第一步
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain getTaskId() {
		return ContractResult.getTaskId(EcloudPublicKey.instance);

	}
	
	/**
	 * 获取认证第二步
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain ocrVerify(String userId, String taskId, String frontImage, String backImage) {
		return ContractResult.ocrVerify(EcloudPublicKey.instance, userId, taskId, frontImage, backImage);
	}
	
	/**
	 * 获取认证第三步
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain livenessVerify(String userId, String taskId, String videoBase64, String videoType) {
		return ContractResult.livenessVerify(EcloudPublicKey.instance, userId, taskId, videoBase64, videoType);

	}
	
	/**
	 * ocr识别
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain allOcrVerify(String enginetype, String databaseImageContent) {
		return ContractResult.allOcrVerify(EcloudPublicKey.instance, enginetype, databaseImageContent);

	}

	/**
	 * ocr识别 带裁剪
	 * @param enginetype
	 * @param databaseImageContent
	 * @param ocrConfig
	 * @return
	 */
	public static ECloudDomain allOcrVerify(String enginetype,String ocrConfig, String databaseImageContent) {
		return ContractResult.allOcrVerify(EcloudPublicKey.instance, enginetype,ocrConfig, databaseImageContent);

	}




	
	
	/**
	 * 腾讯人脸
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain getTencentFace(String orderNo,String userId) {
		return ContractResult.getTencentFace(EcloudPublicKey.instance, orderNo, userId);

	}
	
	
	/**
	 * 腾讯人脸
	 * <p>Title: identityAuthUrl</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param idNumber
	 * @return
	 */
	public static ECloudDomain tencentFace(String name, String idCardNo, String from, String url) {
		return ContractResult.tencentFace(EcloudPublicKey.instance, name, idCardNo, from, url);

	}
	
	/**
	 * 获取产品用户数据统计
	 * <p>Title: getStatisticsTempData</p>  
	 * <p>Description: </p>  
	 * @param saasUser
	 * @return
	 */
	public static ECloudDomain getStatisticsTempData(String saasUser) {
		return ContractResult.getStatisticsTempData(EcloudPublicKey.instance, saasUser);
	}
	
	/**
	 * 获取产品用户数据统计
	 * <p>Title: getStatisticsTempData</p>  
	 * <p>Description: </p>  
	 * @param saasUser
	 * @return
	 */
	public static ECloudDomain contactList(String saasUser, String contractName, String contractNum,
            String startDate, String endDate, String searchMobile, Pagination pagination, Integer status) {
		return ContractResult.contactList(EcloudPublicKey.instance, saasUser, contractName, contractNum, startDate, endDate, searchMobile, pagination, status);
	}
	
	public static ECloudDomain uploadContract(String fileInfo) {
		return ContractResult.uploadContract(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadTemplate(String fileInfo) {
		return ContractResult.uploadTemplate(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain addComponents(String fileInfo) {
		return ContractResult.addComponents(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain delComponents(String fileInfo) {
		return ContractResult.delComponents(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain createByTemplateComponents(String fileInfo) {
		return ContractResult.createByTemplateComponents(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadImage(String fileInfo) {
		return ContractResult.uploadImage(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadFile(String fileInfo) {
		return ContractResult.uploadFile(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadContractUrl(String fileInfo) {
		return ContractResult.uploadContractUrl(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadTemplateUrl(String fileInfo) {
		return ContractResult.uploadTemplateUrl(EcloudPublicKey.instance, fileInfo);
	}
	
	public static ECloudDomain uploadFileUrl(String fileInfo) {
		return ContractResult.uploadFileUrl(EcloudPublicKey.instance, fileInfo);
	}
	
	
	public static ECloudDomain getTemplateInfo(String templateNumber) {
		return ContractResult.getTemplateInfo(EcloudPublicKey.instance, templateNumber);
	}
	
	
	
	/**
	 * 6.2.5 获取签名/印章
	 *
	 * @param mobilePhone
	 *            发起人手机，此手机必须为原合同的合同创建者、合同签署人
	 * @param signId
	 *            签名/印章 id
	 * @return { "meta":{ "code":"0", "message":"操作成功" } }
	 */
	public static ECloudDomain contractSign(String flowId, String signInfo) {
		return SignInfoResult.contractSign(EcloudPublicKey.instance, flowId, signInfo);
	}


	public static ECloudDomain sendMobileSms(String flowId, String telephone) {
		return SignInfoResult.sendMobileSms(EcloudPublicKey.instance, flowId, telephone);
	}

	public static ECloudDomain handWriting(String mobilePhone, String returnUrl,  Integer  signWidth) {
		return SignInfoResult.handWriting(EcloudPublicKey.instance, mobilePhone, returnUrl,signWidth);

	}
	public static ECloudDomain handWriting(String mobilePhone, String returnUrl) {
		return SignInfoResult.handWriting(EcloudPublicKey.instance, mobilePhone, returnUrl);

	}

	public static ECloudDomain handWritingAddSign(String flowId, String signImg, String signType) {
		return SignInfoResult.handWritingAddSign(EcloudPublicKey.instance, flowId, signImg,signType);

	}
}
