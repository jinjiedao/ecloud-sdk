package com.agile.ecloud.sdk.http.result;

import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ContractInfoSignApiParam;
import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.common.SdkApiAction;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名/签章
 *
 * @author sjh
 */
public class SignInfoResult {

    /**
     * 签名/签章列表
     *
     * @param mobilePhone b用户手机
     * @param signType    签名类型
     *                    (1签名 2印章)
     * @return"meta":{ "message":"操作成功", "code":0 }， "data":{ "list": [ {
     * "signId":239, "ctime":"2016-09-05", "isDefault":1,
     * "signImg":"XXXX", "signType":1 } { …… } ] } }
     */
    public static ECloudDomain getsignList(EcloudPublicKey config, String mobilePhone, String signType) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETSIGNLIST_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain getsignListForImage(EcloudPublicKey config, String idCardNum, String signType) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(idCardNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage());
        }
        map.put("idCardNum", idCardNum);

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETSIGNLISTFORIMAGE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 设置默认
     *
     * @param mobilePhone 用户手机
     * @param signId      签名ID
     * @return"meta":{ "message":"操作成功", "code":0 }
     */
    public static ECloudDomain setDefaultSign(EcloudPublicKey config, String mobilePhone, String signId) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signId)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_ID_ERR.getCode(), ErrorMessage.SIGN_ID_ERR.getMessage());
        }
        map.put("signId", signId);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.SETDEFAULTSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 删除
     *
     * @param mobilePhone 用户手机
     * @param signId      签名ID
     * @return"meta":{ "message":"操作成功", "code":0 }
     */
    public static ECloudDomain delSign(EcloudPublicKey config, String mobilePhone, String signId) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signId)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_ID_ERR.getCode(), ErrorMessage.SIGN_ID_ERR.getMessage());
        }
        map.put("signId", signId);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DELSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 添加
     *
     * @param mobilePhone 用户手机
     * @param signId      签名ID
     * @param signImg     签名
     *                    /印章图片(base64编码)
     * @return"meta":{ "message":"操作成功", "code":0 }
     */
    public static ECloudDomain addSign(EcloudPublicKey config, String mobilePhone, String signType, String signImg) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        if (ClassUtil.isBlank(signImg)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_IMG_ERR.getCode(), ErrorMessage.SIGN_IMG_ERR.getMessage());
        }
        map.put("signImg", signImg);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *
     * @param config
     * @param mobilePhone
     * @param signType
     * @param signImg
     * @return
     */
    public static ECloudDomain addSign(EcloudPublicKey config, String mobilePhone, String signType, String signImg,int signWidth) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);
        map.put("signWidth", String.valueOf(signWidth));

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        if (ClassUtil.isBlank(signImg)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_IMG_ERR.getCode(), ErrorMessage.SIGN_IMG_ERR.getMessage());
        }
        map.put("signImg", signImg);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }



    /**
     * 创建新的签章
     *
     * @param mobilePhone 用户手机
     * @param signId      签名ID
     * @param signImg     签名
     *                    /印章图片(base64编码)
     * @return"meta":{ "message":"操作成功", "code":0 }
     */
    public static ECloudDomain createNewSign(EcloudPublicKey config, String mobilePhone, String signId, String width, String heigth) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signId)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_ID_ERR.getCode(), ErrorMessage.SIGN_ID_ERR.getMessage());
        }
        map.put("signId", signId);

        if (ClassUtil.isBlank(width)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_WIDTH.getCode(), ErrorMessage.SIGN_WIDTH.getMessage());
        }
        map.put("width", width);

        if (ClassUtil.isBlank(heigth)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_HEIGTH.getCode(), ErrorMessage.SIGN_HEIGTH.getMessage());
        }
        map.put("heigth", heigth);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATENEWSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 添加
     *
     * @param mobilePhone 用户手机
     * @param signId      签名ID
     * @param signImg     签名
     *                    /印章图片(base64编码)
     * @return"meta":{ "message":"操作成功", "code":0 }
     */
    public static ECloudDomain addSignForSaas(EcloudPublicKey config, String mobilePhone, String signType, String signImg) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        if (ClassUtil.isBlank(signImg)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_IMG_ERR.getCode(), ErrorMessage.SIGN_IMG_ERR.getMessage());
        }
        map.put("signImg", signImg);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDSIGNFORSAAS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 创建印章
     *
     * @param mobilePhone 用户手机号
     *                    ，必填mobilePhone
     * @param signName    签名内容
     *                    ，必填 signName
     * @param fontFamily  签名字体
     *                    ，非必填，默认为宋体（1楷体，2隶书，3宋体，4黑体，5幼圆，6微软雅黑）
     * @param fontSize    签名字号
     *                    ，非必填，默认32fontSize
     * @param border      边框大小
     *                    ，非必填，默认值为2，如不需要边框，可设置为0或负数
     * @param color       颜色16进制代码
     *                    ，非必填，默认为"#FF0000",如需改变颜色，设置对应的颜色值即可
     */
    public static ECloudDomain createSign(EcloudPublicKey config, String mobilePhone, String signName, Integer fontFamily, Integer fontSize, Integer border, String color) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_NAME_ERR.getCode(), ErrorMessage.SIGN_NAME_ERR.getMessage());
        }
        map.put("signName", signName);

        if (fontFamily != null) {
            if (fontFamily >= 1 && fontFamily <= 6) {
                map.put("fontFamily", fontFamily + "");
            } else {
                return ClassUtil.returnECloudDomain(ErrorMessage.FONT_FAMILY_ERR.getCode(), ErrorMessage.FONT_FAMILY_ERR.getMessage());
            }
        }
        if (fontSize != null) {
            if (fontSize > 0) {
                map.put("fontSize", fontSize + "");
            } else {
                return ClassUtil.returnECloudDomain(ErrorMessage.FONT_SIZE_ERR.getCode(), ErrorMessage.FONT_SIZE_ERR.getMessage());
            }
        }
        if (border != null) {
            map.put("border", border + "");
        }
        if (color != null) {
            map.put("color", color);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATESIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 自动生成印章
     *
     * @param mobilePhone 用户手机
     * @param unitName    印章单位名称 ，如北京爱知之星科技股份有限公司，建议在16个 汉子之内
     * @param sealName    印章名称 ，如合同专用章
     * @param sealNumber  印章序列号 ，如 127920
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data":{
     * "signId":1234}}
     */
    public static ECloudDomain createSeal(EcloudPublicKey config, String mobilePhone, String unitName, String sealName, String sealNumber) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(unitName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.UNIT_NAME_ERR.getCode(), ErrorMessage.UNIT_NAME_ERR.getMessage());
        }
        map.put("unitName", unitName);

        if (!ClassUtil.isBlank(sealName)) {
            map.put("sealName", sealName);
        }
        if (!ClassUtil.isBlank(sealNumber)) {
            map.put("sealNumber", sealNumber);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATESEAL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 自动生成印章
     *
     * @param mobilePhone 用户手机
     * @param unitName    印章单位名称 ，如北京爱知之星科技股份有限公司，建议在24个 汉子之内
     * @param sealName    印章名称 ，如合同专用章
     * @param sealNumber  印章序列号 ，如 127920   20字符以内
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data":{
     * "signId":1234}}
     */
    public static ECloudDomain createSealLong(EcloudPublicKey config, String mobilePhone, String unitName, String sealName, String sealNumber) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(unitName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.UNIT_NAME_ERR.getCode(), ErrorMessage.UNIT_NAME_ERR.getMessage());
        }
        map.put("unitName", unitName);

        if (!ClassUtil.isBlank(sealName)) {
            map.put("sealName", sealName);
        }
        if (!ClassUtil.isBlank(sealNumber)) {
            map.put("sealNumber", sealNumber);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATESEALLONG_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 6.2.5 获取签名/印章
     *
     * @param mobilePhone 发起人手机，此手机必须为原合同的合同创建者、合同签署人
     * @param signId      签名/印章 id
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain getSignImg(EcloudPublicKey config, String mobilePhone, String signId) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signId)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_ID_ERR.getCode(), ErrorMessage.SIGN_ID_ERR.getMessage());
        }
        map.put("signId", signId);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETSIGNIMG_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 6.2.6 页面手写签名
     *
     * @param mobilePhone 用户手机号
     * @param signType    签章类型
     * @param returnUrl   跳转地址
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain signPage(EcloudPublicKey config, String mobilePhone, String signType, String returnUrl) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_ID_ERR.getCode(), ErrorMessage.SIGN_ID_ERR.getMessage());
        }
        map.put("signType", signType);

        map.put("returnUrl", returnUrl);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.SIGNPAGE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 生成公司圆形公章
     *
     * @param companyName 企业名称
     * @param sealType    公章类型：合同专用章，财务专用章
     * @param sealNumber  公章编号
     * @return
     */
    public static ECloudDomain genCircleSeal(EcloudPublicKey config, String companyName, String sealType, String sealNumber) {
        if (ClassUtil.isBlank(companyName) || ClassUtil.isBlank(sealType) || ClassUtil.isBlank(sealNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.GEN_CIRCLE_SEAL_ERR.getCode(), ErrorMessage.GEN_CIRCLE_SEAL_ERR.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        param.put("companyName", companyName);
        param.put("sealType", sealType);
        param.put("sealNumber", sealNumber);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GEN_CIRCLE_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * 生成个人姓名矩形公章
     *
     * @param personName 个人姓名
     * @return
     * @throws IOException
     */
    public static ECloudDomain genPersonRectangleSeal(EcloudPublicKey config, String personName) {

        if (ClassUtil.isBlank(personName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getCode(), ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("personName", personName);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GEN_PERSON_RECTANGLE_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 生成个人姓名矩形公章
     * @param config
     * @param personName 个人姓名
     * @return
     */
    public static ECloudDomain genPersonRectangleSeal(EcloudPublicKey config, String personName,int fontSize) {

        if (ClassUtil.isBlank(personName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getCode(), ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("personName", personName);
        param.put("fontSize", String.valueOf(fontSize));

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GEN_PERSON_RECTANGLE_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * 生成个人姓名矩形公章
     *
     * @param personName 个人姓名
     * @return
     * @throws IOException
     */
    public static ECloudDomain genPersonRectangleSeal(EcloudPublicKey config, String personName, int width, int height) {

        if (ClassUtil.isBlank(personName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getCode(), ErrorMessage.GEN_PERSON_RECTANGLE_SEAL_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("personName", personName);
        param.put("width", String.valueOf(width));
        param.put("height", String.valueOf(height));

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GEN_PERSON_RECTANGLE_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 动态生成矩形印章
     *
     * @param firm        公司名称
     * @param type        印章类型
     * @param number      印章编号
     * @param isPentagram 是否生成五角星
     * @param size        印章尺寸
     * @return
     */
    public static ECloudDomain dynCirSeal(EcloudPublicKey config, String firm, String type, String number, String isPentagram, String size, String signType) {

        if (ClassUtil.isBlank(firm) || size == null) {

            return ClassUtil.returnECloudDomain(ErrorMessage.EXECUTE_METHOD_PARAMETER.getCode(), ErrorMessage.EXECUTE_METHOD_PARAMETER.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("firm", firm);
        param.put("type", type);
        param.put("number", number);
        param.put("isPentagram", isPentagram);
        param.put("size", size);
        param.put("signType", signType);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.DYN_CIR_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    public static ECloudDomain graySeal(EcloudPublicKey config, String subject, String extraInfo, String type) {

        if (ClassUtil.isBlank(subject) || type == null || extraInfo == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.EXECUTE_METHOD_PARAMETER.getCode(), ErrorMessage.EXECUTE_METHOD_PARAMETER.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        param.put("subject", subject);
        param.put("extraInfo", extraInfo);
        param.put("type", type);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GRAY_SEAL_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    public static ECloudDomain contractSign(EcloudPublicKey config, String flowId, String signInfo) {

        if (ClassUtil.isBlank(flowId) || signInfo == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.EXECUTE_METHOD_PARAMETER.getCode(), ErrorMessage.EXECUTE_METHOD_PARAMETER.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        param.put("signInfo", signInfo);
        param.put("flowId", flowId);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.CONTRACT_SIGN_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /*public static ECloudDomain getBatchSignUrl(EcloudPublicKey config,String telephone, String cardType, String idCardNum, String callBack, String contractInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("telephone", telephone);
        map.put("cardType", cardType);
        map.put("idCardNum", idCardNum);
        map.put("callBack", callBack);
        map.put("contractInfo", contractInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.TEMPLATE_INFO, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
*/

    public static ECloudDomain getBatchSignUrl(EcloudPublicKey config,String telephone, String cardType, String idCardNum, String callBack,String wxCallBack,String type, List<ContractInfoSignApiParam> contracts) {

        Map<String, String> map = new HashMap<>();
        map.put("telephone", telephone);
        map.put("cardType", cardType);
        map.put("idCardNum", idCardNum);
        map.put("callBack", callBack);
        map.put("wxCallBack", wxCallBack);
        map.put("type", type);
        map.put("contractSignInfo", JSONObject.toJSONString(contracts));
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.BATCH_SIGNURL, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;

    }

    public static ECloudDomain sendMobileSms(EcloudPublicKey instance, String flowId, String telephone) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", telephone);
        map.put("flowId", flowId);
        ECloudBean eClioudBean = new ECloudBean(instance, SdkApiAction.sendMobileSms, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain handWriting(EcloudPublicKey config, String mobilePhone, String returnUrl, Integer signWidth) {

        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        map.put("returnUrl", returnUrl);
        map.put("signWidth", String.valueOf(signWidth));


        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADD_SIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;

    }

    public static ECloudDomain handWriting(EcloudPublicKey config, String mobilePhone, String returnUrl) {

        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        map.put("returnUrl", returnUrl);


        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADD_SIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;

    }



    public static ECloudDomain handWritingAddSign(EcloudPublicKey config, String flowId, String signImg, String signType) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("flowId", flowId);

        map.put("signImg", signImg);
        map.put("signType", signType);


        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.HAND_ADD_SIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
}
