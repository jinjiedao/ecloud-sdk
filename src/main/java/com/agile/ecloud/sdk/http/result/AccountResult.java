package com.agile.ecloud.sdk.http.result;

import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.common.SdkApiAction;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 用户信息
 *
 * @author sjh
 */
public class AccountResult {


    public static ECloudDomain applyCert(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone) {
        return applyCert( config,  type,  cardType,  idCardNum,  name,  mobilePhone, false);
    }
	/**
     * 申请CA证书
     *
     * @param type        类型 1：个人 、2：企业
     * @param cardType    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     * @param idCardNum   证件号码
     * @param name        企业或者个人真实名称
     * @param mobilePhone 企业或者个人联系手机号
     * @return
     */
    public static ECloudDomain applyCert(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone,boolean isSign) {
        Map<String, String> map = new TreeMap<String, String>();
        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("type", type);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("mobilePhone", mobilePhone);

        Map<String, String> map1 = new TreeMap<String, String>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        if (isSign){
            map1.put("isSign", "true");
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERT_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 更新证书
     * <p>Title: updateCert</p>  
     * <p>Description: </p>  
     * @param config
     * @param cardType
     * @param idCardNum
     * @param name
     * @param mobilePhone
     * @return
     */
    public static ECloudDomain updateCert(EcloudPublicKey config,
                                          String type,
                                          String cardType, String idCardNum, String name, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();

        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("mobilePhone", mobilePhone);

        Map<String, String> map1 = new TreeMap<String, String>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPDATECERT_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    
    
    
    /**
     * 申请CA证书
     *
     * @param type        类型 1：个人 、2：企业
     * @param cardType    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     * @param idCardNum   证件号码
     * @param name        企业或者个人真实名称
     * @param mobilePhone 企业或者个人联系手机号
     * @return
     */
    public static ECloudDomain applyCertForSaas(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();
        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("type", type);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("mobilePhone", mobilePhone);

        Map<String, String> map1 = new TreeMap<String, String>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERT_SAAS_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain applyCertString(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone){
       return applyCertString( config,  type,  cardType,  idCardNum,  name,  mobilePhone, false);
    }
    /**
     * 申请证书v2.1
      后台自动生成唯一标识  代替原数据库手机号字段  数据库中新增real_mobile 真实手机号存储用户手机号信息
     * @param type        类型 1：个人 、2：企业
     * @param cardType    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     * @param idCardNum   证件号码
     * @param name        企业或者个人真实名称
     * @param mobilePhone 企业或者个人联系手机号
     * @return
     */
    public static ECloudDomain applyCertString(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone,boolean isSign) {
        Map<String, String> map = new TreeMap<String, String>();
        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("type", type);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("mobilePhone", mobilePhone);

        Map<String, String> map1 = new TreeMap<String, String>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        if (isSign){
            map1.put("isSign", "true");
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERTSTRING_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 证件号申请证书
      手机号用证件号替代
     * @param type        类型 1：个人 、2：企业
     * @param cardType    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     * @param idCardNum   证件号码
     * @param name        企业或者个人真实名称
     * @return
     */
    public static ECloudDomain applyCertCardNum(EcloudPublicKey config, String type, String cardType, String idCardNum, String name) {
        Map<String, String> map = new TreeMap<String, String>();
        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("type", type);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);


        Map<String, String> map1 = new TreeMap<>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLY_CERT_CARDNUM_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 申请CA证书
     *12位虚拟手机号
     * @param type        类型 1：个人 、2：企业
     * @param cardType    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     * @param idCardNum   证件号码
     * @param name        企业或者个人真实名称
     * @param mobilePhone 企业或者个人联系手机号
     * @return
     */
    public static ECloudDomain applyCertMobile(EcloudPublicKey config, String type, String cardType, String idCardNum, String name, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();
        if (type == null || "".equals(type)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("type", type);

        if (cardType == null || "".equals(cardType)) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }
        map.put("cardType", cardType);

        if (idCardNum == null || "".equals(idCardNum)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("idCardNum", idCardNum);

        if (name == null || "".equals(name)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("name", name);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("mobilePhone", mobilePhone);

        Map<String, String> map1 = new TreeMap<String, String>();
        String info = JSONObject.toJSONString(map);
        map1.put("info", info);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERTMOBILE_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 申请CA证书 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
     *
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain applyCert(EcloudPublicKey config, String info) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        if (obj.get("name") == null || "".equals(obj.get("name"))) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }

        if (obj.get("mobilePhone") == null || "".equals(obj.get("mobilePhone"))) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), null);
        }
        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERT_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    
    /**
     * 申请CA证书 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
     *
     * @param newMobile 申请者新手机号码
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain changeMobile(EcloudPublicKey config, String info, String newMobile) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        if (obj.get("name") == null || "".equals(obj.get("name"))) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }

        // if (obj.get("mobilePhone") == null ||
        // "".equals(obj.get("mobilePhone"))) {
        // return new ECloudDomain("201", "mobilePhone不能为空", null);
        // }
        if (ClassUtil.isBlank(newMobile)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.NEW_MOBILE_ERR.getCode(), ErrorMessage.NEW_MOBILE_ERR.getMessage());
        }
        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        map1.put("newMobile", newMobile);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CHANGEMOBILE_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    
    public static ECloudDomain makeCertInfoToBuf(EcloudPublicKey config, String makeCertVo, String password, String accType) {
        Map<String, String> requestMap = new TreeMap<String, String>();
        requestMap.put("makeCertVo", makeCertVo);
        requestMap.put("password", password);
        requestMap.put("accType", accType);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.APPLYCERT_BUF, SdkApiAction.METHODPOST, requestMap);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    
    
    /**
     * 吊销用户 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
     *
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain unwrap(EcloudPublicKey config, String info) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        if (obj.get("name") == null || "".equals(obj.get("name"))) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }

        if (obj.get("mobilePhone") == null || "".equals(obj.get("mobilePhone"))) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), null);
        }
        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UNWRAP_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 签署人更换手机 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
     *
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain getCertInfo(EcloudPublicKey config, String info) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCERTINFO_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 签署人更换手机 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 "name":"", //企业或者个人真实名称 "mobilePhone":"" //企业或者个人联系手机号 }
     *
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain getCertInfoString(EcloudPublicKey config, String info) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCERTINFOSTRING_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 用户证书延期 数据json格式说明： { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", // 证件类型
     * 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件 "idCardNum":"",
     * // 证件号码 }
     *
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain renewCert(EcloudPublicKey config, String info) {
        JSONObject obj = JSONObject.parseObject(info);
        if (obj.get("type") == null || "".equals(obj.get("type"))) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }

        if (obj.get("cardType") == null || "".equals(obj.get("cardType"))) {
            return new ECloudDomain(ErrorMessage.CARD_TYPE_ERR.getCode(), ErrorMessage.CARD_TYPE_ERR.getMessage(), "");
        }

        if (obj.get("idCardNum") == null || "".equals(obj.get("idCardNum"))) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }

        Map<String, String> map = new TreeMap<String, String>();
        for (Map.Entry entry : obj.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
            // System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("info", JSONObject.toJSONString(map));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.RENEWCERT_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 6.6.1 用户身份认证信息
     *
     * @param cardImg1 身份证正面
     * @param cardImg2 身份证正面
     * @return { "data": { "cardImg1": { "name":"xx" //姓名
     * "birthday":"1994年09月18日", //出生日期 "sex":"男", //性别 "folk": "汉",
     * //民族 "cardno":"110111199999990987", //身份证
     * "birthday":"1994年09月18日", //出生年月 "address":"北京市朝阳区XXX" //住址 },
     * "cardImg2": { "authority":"北京市公安局朝阳分局", //发证机关
     * "validdate1":"20120130", //有效期 "validdate2":"20320130", //有效期 },
     * }, "meta": { "message": "操作成功", "code": 0 } }
     */
    public static ECloudDomain idCard(EcloudPublicKey config, File cardImg1, File cardImg2) {
        Map<String, String> map = new TreeMap<String, String>();

        if (cardImg1 == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.ACARD_IMAGE1_ERR.getCode(), ErrorMessage.ACARD_IMAGE1_ERR.getMessage());
        }
        if (cardImg2 == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.ACARD_IMAGE2_ERR.getCode(), ErrorMessage.ACARD_IMAGE2_ERR.getMessage());
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.IDCARD_ACTION, SdkApiAction.METHODPOST, map);
        Map<String, File> files = new HashMap<String, File>();
        files.put("cardImg1", cardImg1);
        files.put("cardImg2", cardImg2);
        eClioudBean.setFiles(files);
        ECloudDomain sealDomain = eClioudBean.executeMethod();

        return sealDomain;
    }

    public static ECloudDomain remoteApplySeal(EcloudPublicKey config, String jsonInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("info", jsonInfo);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.REMOTE_APPLY_SEAL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain ed = eCloudBean.executeMethod();
        System.out.println(ed);

        return ed;
    }
    
    
    public static ECloudDomain register(EcloudPublicKey config, String mobile, String password) {
    	 if (ClassUtil.isBlank(mobile) || ClassUtil.isBlank(password)) {

             return ClassUtil.returnECloudDomain(ErrorMessage.EXECUTE_METHOD_PARAMETER.getCode(), ErrorMessage.EXECUTE_METHOD_PARAMETER.getMessage());
         }

         Map<String, String> param = new HashMap<>();
         param.put("password", password);
         param.put("mobile", mobile);

         ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.API_LOGIN_REGISTER, SdkApiAction.METHODPOST, param);
         return eCloudBean.executeMethod();
    }

    
}
