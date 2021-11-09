package com.agile.ecloud.sdk.http.result;

import com.agile.ecloud.sdk.bean.Account;
import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.common.Pagination;
import com.agile.ecloud.sdk.common.SdkApiAction;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.agile.ecloud.sdk.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.*;


/**
 * 合同
 *
 * @author sjh
 */
public class ContractResult {

    public static ECloudDomain sealByKeywordForNum(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo,String signImageInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        map.put("signImageInfo", signImageInfo);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.SEALBRKEYWORD_FORNUM_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 获取合同列表
     *
     * @param mobilePhone 用户手机
     * @param currentPage 当前页数
     *                    ，默认为1
     * @param pageSize    每页的记录数
     *                    ，最大为100
     * @return
     */
    public static ECloudDomain getContractList(EcloudPublicKey config, String mobilePhone, String currentPage, String pageSize) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (!ClassUtil.isBlank(currentPage)) {
            map.put("currentPage", currentPage);
        }
        if (!ClassUtil.isBlank(pageSize)) {
            map.put("pageSize", pageSize);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCONTRACTLIST_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain smsBatchSigning(EcloudPublicKey config, String signInfo,String dynamicCode,String serialNumber,
                                               String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signInfo", signInfo);

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(dynamicCode)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DYNAMIC_CODE_ERR.getCode(), ErrorMessage.DYNAMIC_CODE_ERR.getMessage());
        }
        map.put("dynamicCode", dynamicCode);

        if (ClassUtil.isBlank(serialNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SERUAL_NUMBER.getCode(), ErrorMessage.SERUAL_NUMBER.getMessage());
        }
        map.put("serialNumber", serialNumber);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.SMS_CONTRACT_BATCHSIGN, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * @param mobilePhone 用户手机号码
     * @param contractNum 合同编号唯一标识
     * @return
     */
    public static ECloudDomain getContractDetail(EcloudPublicKey config, String mobilePhone, String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCONTRACTDETAIL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * @param mobilePhone 用户手机号码
     * @param contractNum 合同编号唯一标识
     * @return
     */
    public static ECloudDomain getContractImageList(EcloudPublicKey config, String mobilePhone, String contractNum, String signPosition) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        map.put("signPosition", signPosition);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCONTRACTDETAIL_SAAS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * @param mobilePhone 用户手机号码
     * @param contractNum 合同编号唯一标识
     * @return
     */
    public static ECloudDomain getContractDetailUp(EcloudPublicKey config, String mobilePhone, String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCONTRACTDETAIL_UP_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * @param mobilePhone 用户手机号码
     * @param contractNum 合同编号唯一标识
     * @return
     */
    public static ECloudDomain getContractImgs(EcloudPublicKey config, String mobilePhone, String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GET_CONTRACT_IMGS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 自动签署合同
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     * "contractNum": "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain autoSign(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 自动签署合同
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param signInfo    签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
     *                    "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
     *                    //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
     *                    //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     * "contractNum": "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain autoSign(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (ClassUtil.isBlank(signInfo)) {
            // map.put("signPosition", null);
        } else {
            map.put("signInfo", signInfo);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 自动签署合同
     * 字符申请证书
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param signInfo    签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
     *                    "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
     *                    //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
     *                    //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     * "contractNum": "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain autoSignForString(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (ClassUtil.isBlank(signInfo)) {
            // map.put("signPosition", null);
        } else {
            map.put("signInfo", signInfo);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGNFORSTRING_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 身份证件签署合同
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param signInfo    签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
     *                    "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
     *                    //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
     *                    //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     * "contractNum": "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain autoSignForCardNum(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (ClassUtil.isBlank(signInfo)) {
            // map.put("signPosition", null);
        } else {
            map.put("signInfo", signInfo);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTO_SIGN_FOR_CARDNUM_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 无效签章
     * <p>Title: autoSignInvalidSeal</p>
     * <p>Description: </p>
     *
     * @param signerInfo
     * @param contractNum
     * @param isFinish
     * @param signInfo
     * @return
     */
    public static ECloudDomain autoSignInvalidSeal(EcloudPublicKey config, String signType, String pdfPath, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signType)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGN_TYPE_ERR.getCode(), ErrorMessage.SIGN_TYPE_ERR.getMessage());
        }
        map.put("signType", signType);

        if (ClassUtil.isBlank(pdfPath)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.PDF_PATH_ERR.getCode(), ErrorMessage.PDF_PATH_ERR.getMessage());
        }
        map.put("pdfPath", pdfPath);

        if (ClassUtil.isBlank(signInfo)) {
            // map.put("signPosition", null);
        } else {
            map.put("signInfo", signInfo);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTO_SIGN_INVALID_SEAL, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 发起合同
     *
     * @param keyWord      合同关键字
     * @param contractName 合同名称
     * @param days         合同有效天数
     *                     ，最大180天
     * @param mobilePhone  发起方手机
     * @param toMobile     合同签署人手机号码
     *                     ，签署顺序必须按照传入顺序， 否则签署不了
     * @param position     坐标信息jason
     *                     { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
     *                     "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名
     *                     2印章} 、 { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
     *                     "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名
     *                     2印章} { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
     *                     "mobilePhone":"18518251317" //手机号 "signType":"1"//类型 签名类型，1签名
     *                     2印章} ...
     * @return
     */
    public static ECloudDomain launchContractAutoSignAndSendSms(EcloudPublicKey config,
                                                                String keyWord,
                                                                String contractName,
                                                                Integer days,
                                                                String contractNum,
                                                                String[] signerInfos) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(keyWord)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.KEY_WORD_ERR.getCode(), ErrorMessage.KEY_WORD_ERR.getMessage());
        }
        map.put("keyWord", keyWord);

        if (ClassUtil.isBlank(contractName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NAME_ERR.getCode(), ErrorMessage.CONTRACT_NAME_ERR.getMessage());
        }
        map.put("contractName", contractName);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (days == null || "".equals(days)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DAYS_ERR.getCode(), ErrorMessage.DAYS_ERR.getMessage());
        }
        map.put("days", days.toString());

        if (signerInfos.length == 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFOS_ERR.getCode(), ErrorMessage.SIGNER_INFOS_ERR.getMessage());
        } else {
            List<String> list = new ArrayList<String>();
            StringBuffer sb = new StringBuffer();
            // sb.append("[");
            for (int i = 0; i < signerInfos.length; i++) {
                map.put("signerInfos[" + i + "]", signerInfos[i]);
                list.add(signerInfos[i]);
                sb.append(signerInfos[i]);
                if (i != signerInfos.length - 1) {
                    sb.append(",");
                }
            }
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.LAUNCHCONTRACT_AutoSign_SendSms_ACTION,
                SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 发起合同
     *
     * @param keyWord      合同关键字
     * @param contractName 合同名称
     * @param days         合同有效天数
     *                     ，最大180天
     * @param mobilePhone  发起方手机
     * @param toMobile     合同签署人手机号码
     *                     ，签署顺序必须按照传入顺序， 否则签署不了
     * @param position     坐标信息jason
     *                     [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
     *                     "signId":23 //签章/签名id } ]
     * @return
     */
    public static ECloudDomain launchContractSendSms(EcloudPublicKey config,
                                                     String keyWord,
                                                     String contractName,
                                                     Integer days,
                                                     String mobilePhone,
                                                     String[] toMobile,
                                                     String position,
                                                     String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(keyWord)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.KEY_WORD_ERR.getCode(), ErrorMessage.KEY_WORD_ERR.getMessage());
        }
        map.put("keyWord", keyWord);

        if (ClassUtil.isBlank(contractName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NAME_ERR.getCode(), ErrorMessage.CONTRACT_NAME_ERR.getMessage());
        }
        map.put("contractName", contractName);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (days == null || "".equals(days)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DAYS_ERR.getCode(), ErrorMessage.DAYS_ERR.getMessage());
        }
        map.put("days", days.toString());

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        if (toMobile.length == 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TO_Mobile_ERR.getCode(), ErrorMessage.TO_Mobile_ERR.getMessage());
        } else {
            List<String> list = new ArrayList<String>();
            StringBuffer sb = new StringBuffer();
            // sb.append("[");
            for (int i = 0; i < toMobile.length; i++) {
                list.add(toMobile[i]);
                sb.append(toMobile[i]);
                if (i != toMobile.length - 1) {
                    sb.append(",");
                }
            }
            // sb.append("]");
            //System.out.println(JSONObject.toJSONString(list));
            map.put("toMobile", sb.toString());
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.LAUNCHCONTRACT_WITHSHORTMESSAGE_ACTION,
                SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 发起合同
     *
     * @param keyWord      合同关键字
     * @param contractName 合同名称
     * @param days         合同有效天数
     *                     ，最大180天
     * @param mobilePhone  发起方手机
     * @param toMobile     合同签署人手机号码
     *                     ，签署顺序必须按照传入顺序， 否则签署不了
     * @param position     坐标信息jason
     *                     [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200, //坐标
     *                     "signId":23 //签章/签名id } ]
     * @return
     */
    public static ECloudDomain launchContract(EcloudPublicKey config,
                                              String keyWord,
                                              String contractName,
                                              Integer days,
                                              String mobilePhone,
                                              String[] toMobile,
                                              String position,
                                              String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(keyWord)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.KEY_WORD_ERR.getCode(), ErrorMessage.KEY_WORD_ERR.getMessage());
        }
        map.put("keyWord", keyWord);

        if (ClassUtil.isBlank(contractName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NAME_ERR.getCode(), ErrorMessage.CONTRACT_NAME_ERR.getMessage());
        }
        map.put("contractName", contractName);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (days == null || "".equals(days)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DAYS_ERR.getCode(), ErrorMessage.DAYS_ERR.getMessage());
        }
        map.put("days", days.toString());

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        if (toMobile.length == 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TO_Mobile_ERR.getCode(), ErrorMessage.TO_Mobile_ERR.getMessage());
        } else {
            List<String> list = new ArrayList<String>();
            StringBuffer sb = new StringBuffer();
            // sb.append("[");
            for (int i = 0; i < toMobile.length; i++) {
                list.add(toMobile[i]);
                sb.append(toMobile[i]);
                if (i != toMobile.length - 1) {
                    sb.append(",");
                }
            }
            // sb.append("]");
            //System.out.println(JSONObject.toJSONString(list));
            map.put("toMobile", sb.toString());
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.LAUNCHCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 合同签署
     *
     * @param contractNum 合同编号
     * @param mobilePhone 发起方手机
     * @param position    坐标信息jason [ { "page": 1, //页数，从1开始 "x": 200, //坐标 "y": 200,
     *                    //坐标 "signId":23 //签章/签名id } ]
     * @return
     */
    public static ECloudDomain sealContract(EcloudPublicKey config, String contractNum, String mobilePhone, String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (ClassUtil.isBlank(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.SEALCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 签章合同文档下载
     *
     * @param contractNum 合同编号唯一标识
     * @param targetPath  下载路径
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static void downloadContract(EcloudPublicKey config, String contractNum, String targetPath) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        if (eCloudDomain.getCode().equals("0")) {

            JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
            JSONArray arr = (JSONArray) o2.get("bytes");
            byte[] b1 = JSON.parseObject(arr.toString(), byte[].class);
            FileUtil.writeFile(targetPath, b1);
        }
    }

    /**
     *
     * @param config
     * @param contractNum
     * @param mobilePhone
     * @return
     */
    public static ECloudDomain getContractEvidenceUrl(EcloudPublicKey config, String contractNum,String mobilePhone) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        map.put("mobilePhone", mobilePhone);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETCONTRACTEVIDENCEURL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain getContractDetailByContractIdForPdf(EcloudPublicKey config, String contractId, String mobile, String targetPath) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractId == null || "".equals(contractId)) {
        }

        map.put("contractNum", contractId);
        map.put("mobilePhone", mobile);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONTRACT_DETAIL_ACTION, SdkApiAction.METHODPOST,
                map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        if (eCloudDomain.getCode().equals("0") && targetPath != null) {
            // System.out.println(eCloudDomain.getMessage());

            JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
            try {
                JSONArray arr = (JSONArray) o2.get("bytes");
                byte[] b1 = JSON.parseObject(arr.toString(), byte[].class);
                // 正常写文件流
                FileUtil.writeFile(targetPath, b1);
                // 如果用的protobuf则把下面注释掉的打开即可
                // RsqModelOuterClass.RsqModel rm1 =
                // RsqModelOuterClass.RsqModel.parseFrom(b1);
                // FileUtil.writeFile(targetPath,
                // rm1.getFilebytes().toByteArray());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return eCloudDomain;

    }

    /**
     * 用户授权验证签署合同 6.4.4
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param signInfo    签章信息，如果指定，则用户必须已经上传签章或者签字， 并且在对应的模板中指定位置,非必填 格式json{
     *                    "signType":"1", //类型 签名类型，1签名 2印章 "signId":"0",
     *                    //签章或者签字ID，如果不指定，则用户默认设置 "positionName":"name1"
     *                    //签章位置名称，见模板中的设置，如果不指 定，则用第一个位置 }
     * @param dynamicCode 动态验证码
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     * "contractNum": "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain authorizeSign(EcloudPublicKey config,
                                             String signerInfo,
                                             String contractNum,
                                             Integer isFinish,
                                             String signInfo,
                                             String dynamicCode) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (ClassUtil.isBlank(dynamicCode)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DYNAMIC_CODE_ERR.getCode(), ErrorMessage.DYNAMIC_CODE_ERR.getMessage());
        }
        map.put("dynamicCode", dynamicCode);

        if (ClassUtil.isBlank(signInfo)) {
            // map.put("signPosition", null);
        } else {
            map.put("signInfo", signInfo);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTHORIZESIGN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 合同签署动态验证码发送6.4.7
     *
     * @param contractNum 合同编号唯一标识
     * @param mobilePhone 必须是用户签署所用手机号码，发送验证码后，在用户签署的时 候需要进行验证
     * @param smsType 可不填
     *                    ，默认安装易云章通用格式进行发送，如果需要定制，需 要申请
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain sendSms(EcloudPublicKey config, String contractNum, String mobilePhone, String smsType) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (smsType == null || "".equals(smsType)) {
        } else {
            map.put("smsType", smsType);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.SENDSMS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 合同作废
     *
     * @param contractNum 合同编号唯一标识
     * @param mobilePhone 作废发起人手机
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain cancelContract(EcloudPublicKey config, String contractNum, String mobilePhone) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CANCELCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 合同作废
     *
     * @param contractNum 合同编号唯一标识
     * @param mobilePhone 作废发起人手机
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain contractCancel(EcloudPublicKey config, String contractNum, String mobilePhone) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACTCANCEL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 合同验真
     *
     * @param file        pdf文件
     * @param mobilePhone 作废发起人手机
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain verify(EcloudPublicKey config, File file) {
        Map<String, String> map = new TreeMap<String, String>();

        if (file == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_ERR.getCode(), ErrorMessage.FILE_ERR.getMessage());
        }
        // map.put("file", file);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.VERIFY_ACTION, SdkApiAction.METHODPOST, map);
        eClioudBean.setFile(file);
        ECloudDomain sealDomain = eClioudBean.executeMethod();

        return sealDomain;
    }

    /**
     * 自动签署合同：根据盖章位置
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param position    签章位置
     * @return
     */
    public static ECloudDomain autoSignByPoistion(EcloudPublicKey config,
                                                  String signerInfo,
                                                  String contractNum,
                                                  Integer isFinish,
                                                  String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGNBYPOISTION_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain autoSignByPoistionOld(EcloudPublicKey config,
                                                  String signerInfo,
                                                  String contractNum,
                                                  Integer isFinish,
                                                  String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        Random r = new Random();
        Integer random = r.nextInt(899999) + 100000;
        map.put("signerInfo", signerInfo);
        map.put("dynamicCode","802296");

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGNBYPOISTION_ACTION_OLD, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain autoSignByPoistionNoSms(EcloudPublicKey config,
                                                       String signerInfo,
                                                       String contractNum,
                                                       Integer isFinish,
                                                       String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGNBYPOISTION_ACTION_NOSMS, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 自动签署合同：根据盖章位置可以待日期
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param position    签章位置
     * @return
     */
    public static ECloudDomain autoSignByPoistionForDateImage(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish, String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACT_AUTOSIGN_IMAGE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * pdf签署不存储
     * <p>Title: autoSignForPdfBase64</p>
     * <p>Description: </p>
     *
     * @param signerInfo
     * @param pdfBase64
     * @param contractNum
     * @param isFinish
     * @param signInfo
     * @return
     */
    public static ECloudDomain autoSignForPdfBase64(EcloudPublicKey config, String signerInfo, String pdfBase64, String contractNum,
                                                    Integer isFinish, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (signInfo == null || "".equals(signInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("signInfo", signInfo);

        if (pdfBase64 == null || "".equals(pdfBase64)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.PDF_BASE64.getCode(), ErrorMessage.PDF_BASE64.getMessage());
        }

        map.put("pdfBase64", pdfBase64);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACT_PDFBASE64, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain contractEvidence(EcloudPublicKey config, String contractNum) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractInfo", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACT_EVIDENCE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 自动签署合同：根据盖章位置可以待日期
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param position    签章位置
     * @return
     */
    public static ECloudDomain batchSigning(EcloudPublicKey config, String signInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signInfo", signInfo);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACT_BATCHSIGN, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 自动签署合同：根据盖章位置可以待日期
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param position    签章位置
     * @return
     */
    public static ECloudDomain autoSignByPoistionApiSaas(EcloudPublicKey config, String signerInfo, String contractNum, Integer isFinish, String position, String dynamicCode) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        if (dynamicCode == null || "".equals(dynamicCode)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DYNAMIC_CODE_ERR.getCode(), ErrorMessage.DYNAMIC_CODE_ERR.getMessage());
        }
        map.put("dynamicCode", dynamicCode);
        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACT_AUTOSIGN_API_IMAGE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 自动签署合同：根据盖章位置(12位虚拟手机号)
     *
     * @param signerInfo  签署人信息  格式json { "type":"1", //类型 1：个人 、2：企业 "cardType":"0", //
     *                    证件类型 0：身份证 1：军官证 ,2：护照、 3：驾驶证、4：工商登记证、5：税务登记证、 6：组织机构代码、7：其他证件
     *                    idCardNum
     *                    ":"", // 证件号码          "name":"",   //企业或者个人真实名称          "
     *                    mobilePhone":"" //企业或者个人联系手机号 } 4
     * @param contractNum 合同编号唯一标识
     * @param isFinish    合同是否签署完成(0:是,1:否),例如合同属于双方合同，第一
     *                    个人签署时，isFinish 否，当第二个签署时候，参数isFinish 为c是
     * @param position    签章位置
     * @return
     */
    public static ECloudDomain autoSignByPoistionForMobile12(EcloudPublicKey config,
                                                             String signerInfo,
                                                             String contractNum,
                                                             Integer isFinish,
                                                             String position) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (isFinish == null || "".equals(isFinish)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_NULL_ERR.getCode(), ErrorMessage.IS_FINISH_NULL_ERR.getMessage());
        }
        map.put("isFinish", isFinish.toString());

        if (position == null || "".equals(position)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.POSITION_ERR.getCode(), ErrorMessage.POSITION_ERR.getMessage());
        }
        map.put("position", position);

        //System.out.println("-------------" + map.toString());

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.AUTOSIGNBYPOISTIONFORMOBILE12_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 6.5.1 上传文件创建合同
     *
     * @param file        pdf文件
     * @param mobilePhone 发起人手机
     * @param contractNum 合同编号
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain createContract(EcloudPublicKey config, String contractNum, String mobilePhone, File file) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        if (file == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_ERR.getCode(), ErrorMessage.FILE_ERR.getMessage());
        }
        // map.put("file", file);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATECONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        eClioudBean.setFile(file);
        ECloudDomain sealDomain = eClioudBean.executeMethod();

        return sealDomain;
    }


    /**
     * 6.5.1 上传文件创建无效合同
     *
     * @param file        pdf文件
     * @param mobilePhone 发起人手机
     * @param contractNum 合同编号
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain createInvalidContract(EcloudPublicKey config, File file) {
        Map<String, String> map = new TreeMap<String, String>();

        if (file == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_ERR.getCode(), ErrorMessage.FILE_ERR.getMessage());
        }
        // map.put("file", file);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATEINVALIDCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        eClioudBean.setFile(file);
        ECloudDomain sealDomain = eClioudBean.executeMethod();

        return sealDomain;
    }

    /**
     * 6.5.2 合同文件下载
     *
     * @param contractNum 合同编号唯一标识
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static ECloudDomain downloadCont(EcloudPublicKey config, String contractNum, String mobilePhone) {

        Map<String, String> map = new TreeMap<String, String>();

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain viewEvidence(EcloudPublicKey config, String contractNum, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.VIEW_EVIDENCE, SdkApiAction.METHODGET, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain getDownloadEvidenceUrl(EcloudPublicKey config, String contractNum, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();


        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOAD_EVIDENCE_URL, SdkApiAction.METHODGET, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 签章合同文档下载
     *
     * @param contractNum 合同编号唯一标识
     * @param targetPath  下载路径
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static ECloudDomain downloadCont(EcloudPublicKey config, int i, String contractNum, String mobilePhone, String targetPath) {

        Map<String, String> map = new TreeMap<String, String>();

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        if (eCloudDomain.getCode().equals("0")) {

            JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
            JSONArray arr = (JSONArray) o2.get("bytes");
            byte[] b1 = JSON.parseObject(arr.toString(), byte[].class);
//            System.out.print(o2.get("otherSigners"));
//            JSONArray user = (JSONArray)o2.get("otherSigners");
            List<Account> list = (List<Account>) JSON.parseArray(o2.get("otherSigners").toString(), Account.class);

            Account Account = list.get(0);

            FileUtil.writeFile(targetPath + contractNum + "-" + Account.getMobile() + "-" + Account.getRealName() + "-" + i + ".pdf", b1);
        } else {
            //System.out.println("错误合同编号："+contractNum);
        }
        return eCloudDomain;
    }


    /**
     * 签章合同文档下载
     *
     * @param contractNum 合同编号唯一标识
     * @param targetPath  下载路径
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static ECloudDomain downloadCont(EcloudPublicKey config, String contractNum, String mobilePhone, String targetPath) {

        Map<String, String> map = new TreeMap<String, String>();

        if (!ClassUtil.isBlank(contractNum)) {
            map.put("contractNum", contractNum);
        }

        if (mobilePhone == null || "".equals(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        if (eCloudDomain.getCode().equals("0")) {

            JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
            JSONArray arr = (JSONArray) o2.get("bytes");
            byte[] b1 = JSON.parseObject(arr.toString(), byte[].class);
            FileUtil.writeFile(targetPath, b1);
        } else {
            //System.out.println("错误合同编号："+contractNum);
        }
        return eCloudDomain;
    }

    /**
     * 撤销合同合同其他人未签署，才可以撤回
     *
     * @param contractNum 合同编号唯一标识
     * @param mobilePhone 发起人手机，此手机必须为原合同的合同创建者、合同签署人
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain contractRevoke(EcloudPublicKey config, String contractNum, String mobilePhone) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.CONTRACTREVOKE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 退回合同
     *
     * @param contractNum 合同编号唯一标识
     * @param mobilePhone 发起人手机，此手机必须为原合同的合同创建者、合同签署人
     * @param remark      退回理由，(50个汉字内)
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain rejectContract(EcloudPublicKey config, String contractNum, String mobilePhone, String remark) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(mobilePhone)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage());
        }
        map.put("mobilePhone", mobilePhone);

        if (!ClassUtil.isBlank(remark)) {
            if (remark.length() > 50) {
                return new ECloudDomain(ErrorMessage.REMARK_ERR.getCode(), ErrorMessage.REMARK_ERR.getMessage(), "");
            }
            map.put("remark", remark);
        }
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.REJECTCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain sealByKeyword(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.SEALKEYWORD_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 关键字签署盖图片
     * <p>Title: sealByKeyword</p>
     * <p>Description: </p>
     *
     * @param contractNum
     * @param signerInfo
     * @param isFinish
     * @param ruleInfo
     * @return
     */
    public static ECloudDomain sealByKeywordForImage(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo, String signImageInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        map.put("signImageInfo", signImageInfo);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.SEALBRKEYWORD_FORIMAGE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 签章合同文档下载
     *
     * @param contractNum 合同编号唯一标识
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static ECloudDomain downloadContract(EcloudPublicKey config, String contractNum) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONTRACT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    /**
     * 签章合同文档下载
     *
     * @param contractNum 合同编号唯一标识
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "bytes":
     * "字节数组字符串，请用utf-8编码转换为byte[]" } }
     */
    public static ECloudDomain downloadContractBase64(EcloudPublicKey config, String contractNum) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONTRACTBASE64_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    /**
     * 下载合同 （接收二进制流保存文件）
     *
     * @param contractNum   合同编号唯一标识
     * @param localFileName 文件保存路径及名称 （d://ceshi.pdf）需包括文件格式后缀
     * @return { "meta":{ "code":"0", "message":"操作成功" }
     */
    public static ECloudDomain downloadContractBin(EcloudPublicKey config, String contractNum, String localFileName) {

        Map<String, String> map = new TreeMap<String, String>();

        if (contractNum == null || "".equals(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);
        if (localFileName == null || "".equals(localFileName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.LOCAL_FILE_NAME_ERR.getCode(), ErrorMessage.LOCAL_FILE_NAME_ERR.getMessage());
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DOWNLOADCONTRACTBIN_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 多页签章，骑缝章
     *
     * @param contractNum
     * @param signerInfo
     * @param isFinish
     * @param ruleInfo
     * @return
     */
    public static ECloudDomain multipleSeal(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.MULTIPLESEAL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 多页签章，骑缝章
     *
     * @param contractNum
     * @param signerInfo
     * @param isFinish
     * @param ruleInfo
     * @return
     */
    public static ECloudDomain multipleSealApiSaas(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo, String dynamicCode) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        if (ClassUtil.isBlank(dynamicCode)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.DYNAMIC_CODE_ERR.getCode(), ErrorMessage.DYNAMIC_CODE_ERR.getMessage());
        }
        map.put("dynamicCode", dynamicCode);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.MULTIPLESEAL_SAAS_API_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 多页签章，骑缝章新saas
     *
     * @param contractNum
     * @param signerInfo
     * @param isFinish
     * @param ruleInfo
     * @return
     */
    public static ECloudDomain multipleNewSeal(EcloudPublicKey config, String contractNum, String signerInfo, int isFinish, String ruleInfo) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(contractNum)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("contractNum", contractNum);

        if (ClassUtil.isBlank(signerInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("signerInfo", signerInfo);

        if (ClassUtil.isBlank(ruleInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.RULE_INFO_ERR.getCode(), ErrorMessage.RULE_INFO_ERR.getMessage());
        }
        map.put("ruleInfo", ruleInfo);
        if (isFinish != 1 && isFinish != 0) {
            return ClassUtil.returnECloudDomain(ErrorMessage.IS_FINISH_ERR.getCode(), ErrorMessage.IS_FINISH_ERR.getMessage());
        }
        map.put("isFinish", isFinish + "");

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.MULTIPLENEWSEAL_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 电子数据存证
     *
     * @param thirdPartId 平台用户id
     * @param fileHash    文件hash
     * @return
     */
    public static ECloudDomain saveFileHash(EcloudPublicKey config, String thirdPartId, String fileHash) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(fileHash)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.CONTRACT_NUM_ERR.getCode(), ErrorMessage.CONTRACT_NUM_ERR.getMessage());
        }
        map.put("fileHash", fileHash);

        if (ClassUtil.isBlank(thirdPartId)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.SIGNER_INFO_ERR.getCode(), ErrorMessage.SIGNER_INFO_ERR.getMessage());
        }
        map.put("thirdPartId", thirdPartId);

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.SAVE_FILE_HASH_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * PDF增加图片
     *
     * @param pdfFile   PDF文件
     * @param imageFile 图片文件
     * @param width     x坐标 单位：像素
     * @param height    y坐标
     * @return
     */
    public static ECloudDomain pdfAddImage(EcloudPublicKey config, File pdfFile, File imageFile, String width, String height, String page) {

        if (width == null || height == null || pdfFile == null || imageFile == null || page == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.PDF_ADD_IMAGE_ERR.getCode(), ErrorMessage.PDF_ADD_IMAGE_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>(2);
        param.put("imgWidth", width);
        param.put("imgHeight", height);
        param.put("page", page);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.PDF_ADD_IMAGE_ACTION, SdkApiAction.METHODPOST, param);
        Map<String, File> file = new HashMap<>(2);
        file.put("pdfFile", pdfFile);
        file.put("imageFile", imageFile);
        eCloudBean.setFiles(file);

        ECloudDomain eCloudDomain = eCloudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * word、excel 转PDF spent time:7.2s
     *
     * @param wFile word文件
     * @return
     */
    public static ECloudDomain wordToPdf(EcloudPublicKey config, File wFile) {
        if (wFile == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_NOT_FOUND.getCode(), ErrorMessage.FILE_NOT_FOUND.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.WORD_TO_PDF_ACTION, SdkApiAction.METHODPOST, param);
        eCloudBean.setFile(wFile);
        return eCloudBean.executeMethod();
    }


    /**
     * html转PDF
     *
     * @param content html 内容
     * @return
     */
    public static ECloudDomain htmlToPdf(EcloudPublicKey config, String content) {
        if (content == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_CONTENT_NOT_EXIST_ERR.getCode(), ErrorMessage.HTML_CONTENT_NOT_EXIST_ERR.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        param.put("content", content);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.HTML_TO_PDF_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * html转Word
     *
     * @param content html 内容
     * @return
     */
    public static ECloudDomain html2Word(EcloudPublicKey config, String content) {
        if (content == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_CONTENT_NOT_EXIST_ERR.getCode(), ErrorMessage.HTML_CONTENT_NOT_EXIST_ERR.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        param.put("content", content);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.HTML_TO_WORD_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    public static ECloudDomain delRedis(EcloudPublicKey config) {
        Map<String, String> param = new HashMap<>();
        param.put("content", "1");
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.DELREDIS_ACTION, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * pdf 分割为 图片
     *
     * @param file PDF 文件
     * @return
     */
    public static ECloudDomain pdf2Img(EcloudPublicKey config, File file) {
        if (file == null) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_NOT_FOUND.getCode(), ErrorMessage.FILE_NOT_FOUND.getMessage());
        }
        Map<String, String> param = new HashMap<>();
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.PDF_TO_IMAGE_ACTION, SdkApiAction.METHODPOST, param);
        eCloudBean.setFile(file);
        return eCloudBean.executeMethod();
    }

    /**
     * 三要素识别
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain threeElementsIdentification(EcloudPublicKey config, String name, String telephone, String idCardNo) {
        if (ClassUtil.isBlank(name)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_NAME_ERR.getCode(), ErrorMessage.INDENTIFICATION_NAME_ERR.getMessage());
        }
        if (ClassUtil.isBlank(telephone)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_TELEPHONE_ERR.getCode(), ErrorMessage.INDENTIFICATION_TELEPHONE_ERR.getMessage());

        }
        if (ClassUtil.isBlank(idCardNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getCode(), ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("telephone", telephone);
        param.put("idCardNo", idCardNo);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.THREE_ELEMENTS_INDENT, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 四要素识别
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain fourElementsIdentification(EcloudPublicKey config, String name, String comName, String idCardNo, String comNo) {
        if (ClassUtil.isBlank(name)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_NAME_ERR.getCode(), ErrorMessage.INDENTIFICATION_NAME_ERR.getMessage());
        }
        if (ClassUtil.isBlank(comName)) {
            ClassUtil.returnECloudDomain(ErrorMessage.COMNAME_TELEPHONE_ERR.getCode(), ErrorMessage.COMNAME_TELEPHONE_ERR.getMessage());

        }
        if (ClassUtil.isBlank(idCardNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getCode(), ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getMessage());
        }

        if (ClassUtil.isBlank(comNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.COMNO_TELEPHONE_ERR.getCode(), ErrorMessage.COMNO_TELEPHONE_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("comName", comName);
        param.put("idCardNo", idCardNo);
        param.put("comNo", comNo);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.FOUR_ELEMENTS_INDENT, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 企业三要素识别
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain busThreeElementsIdentification(EcloudPublicKey config, String name, String comName, String comNo) {
        if (ClassUtil.isBlank(name)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_NAME_ERR.getCode(), ErrorMessage.INDENTIFICATION_NAME_ERR.getMessage());
        }
        if (ClassUtil.isBlank(comName)) {
            ClassUtil.returnECloudDomain(ErrorMessage.COMNAME_TELEPHONE_ERR.getCode(), ErrorMessage.COMNAME_TELEPHONE_ERR.getMessage());

        }
        if (ClassUtil.isBlank(comNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.COMNO_TELEPHONE_ERR.getCode(), ErrorMessage.COMNO_TELEPHONE_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("comName", comName);
        param.put("comNo", comNo);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.BUS_THREE_ELEMENTS_INDENT, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * 二要素识别
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain identityAuthUrl(EcloudPublicKey config, String name, String idNumber) {
        if (ClassUtil.isBlank(name)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_NAME_ERR.getCode(), ErrorMessage.INDENTIFICATION_NAME_ERR.getMessage());
        }
        if (ClassUtil.isBlank(idNumber)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getCode(), ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("idNumber", idNumber);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.IDENTITY_AUTH_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 活体认证第一步
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain getTaskId(EcloudPublicKey config) {
        Map<String, String> param = new HashMap<>();
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.GET_TASKID_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 活体认证第二步
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain ocrVerify(EcloudPublicKey config, String userId, String taskId, String frontImage, String backImage) {

        if (ClassUtil.isBlank(userId)) {
            ClassUtil.returnECloudDomain(ErrorMessage.USERID_ERR.getCode(), ErrorMessage.USERID_ERR.getMessage());
        }
        if (ClassUtil.isBlank(taskId)) {
            ClassUtil.returnECloudDomain(ErrorMessage.TASKID_ERR.getCode(), ErrorMessage.TASKID_ERR.getMessage());
        }
        if (ClassUtil.isBlank(frontImage)) {
            ClassUtil.returnECloudDomain(ErrorMessage.FRONTIMAGE_ERR.getCode(), ErrorMessage.FRONTIMAGE_ERR.getMessage());
        }
        if (ClassUtil.isBlank(backImage)) {
            ClassUtil.returnECloudDomain(ErrorMessage.BACKIMAGE_ERR.getCode(), ErrorMessage.BACKIMAGE_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("taskId", taskId);
        param.put("frontImage", frontImage);
        param.put("backImage", backImage);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.OCR_VERIFY_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 活体认证第三步
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain livenessVerify(EcloudPublicKey config, String userId, String taskId, String videoBase64, String videoType) {

        if (ClassUtil.isBlank(userId)) {
            ClassUtil.returnECloudDomain(ErrorMessage.USERID_ERR.getCode(), ErrorMessage.USERID_ERR.getMessage());
        }
        if (ClassUtil.isBlank(taskId)) {
            ClassUtil.returnECloudDomain(ErrorMessage.TASKID_ERR.getCode(), ErrorMessage.TASKID_ERR.getMessage());
        }
        if (ClassUtil.isBlank(videoBase64)) {
            ClassUtil.returnECloudDomain(ErrorMessage.VIDEOBASE64_ERR.getCode(), ErrorMessage.VIDEOBASE64_ERR.getMessage());
        }
        if (ClassUtil.isBlank(videoType)) {
            ClassUtil.returnECloudDomain(ErrorMessage.VIDEOTYPE_ERR.getCode(), ErrorMessage.VIDEOTYPE_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("taskId", taskId);
        param.put("videoBase64", videoBase64);
        param.put("videoType", videoType);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.LIVENESS_VERIFY_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * ocr识别
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain allOcrVerify(EcloudPublicKey config, String enginetype, String databaseImageContent) {

        if (ClassUtil.isBlank(enginetype)) {
            ClassUtil.returnECloudDomain(ErrorMessage.ENGINETYPE_ERR.getCode(), ErrorMessage.ENGINETYPE_ERR.getMessage());
        }
        if (ClassUtil.isBlank(databaseImageContent)) {
            ClassUtil.returnECloudDomain(ErrorMessage.DATAVASEINAGE_CONTENT_ERR.getCode(), ErrorMessage.DATAVASEINAGE_CONTENT_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("enginetype", enginetype);
        param.put("databaseImageContent", databaseImageContent);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.ALLOCR_VERIFY_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * @param config
     * @param enginetype
     * @param ocrConfig
     * @param databaseImageContent
     * @return
     */
    public static ECloudDomain allOcrVerify(EcloudPublicKey config, String enginetype, String ocrConfig, String databaseImageContent) {

        if (ClassUtil.isBlank(enginetype)) {
            ClassUtil.returnECloudDomain(ErrorMessage.ENGINETYPE_ERR.getCode(), ErrorMessage.ENGINETYPE_ERR.getMessage());
        }
        if (ClassUtil.isBlank(databaseImageContent)) {
            ClassUtil.returnECloudDomain(ErrorMessage.DATAVASEINAGE_CONTENT_ERR.getCode(), ErrorMessage.DATAVASEINAGE_CONTENT_ERR.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("enginetype", enginetype);
        param.put("databaseImageContent", databaseImageContent);
        if (ocrConfig != null && ocrConfig.length() > 0) {
            param.put("config", ocrConfig);
        }

        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.ALLOCR_VERIFY_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }

    /**
     * 腾讯人脸
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain tencentFace(EcloudPublicKey config, String name, String idCardNo, String from, String url) {

        if (ClassUtil.isBlank(name)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_NAME_ERR.getCode(), ErrorMessage.INDENTIFICATION_NAME_ERR.getMessage());
        }
        if (ClassUtil.isBlank(idCardNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getCode(), ErrorMessage.INDENTIFICATION_IDCARDNO_ERR.getMessage());
        }
        if (ClassUtil.isBlank(from)) {
            ClassUtil.returnECloudDomain(ErrorMessage.FACE_FROM.getCode(), ErrorMessage.FACE_FROM.getMessage());
        }

        if (ClassUtil.isBlank(url)) {
            ClassUtil.returnECloudDomain(ErrorMessage.FACE_URL.getCode(), ErrorMessage.FACE_URL.getMessage());
        }

        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("idCardNo", idCardNo);
        param.put("from", from);
        param.put("url", url);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.TENCENT_FACE_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 腾讯人脸
     * <p>Title: wordToPdf</p>
     * <p>Description: </p>
     *
     * @param wFile
     * @return
     */
    public static ECloudDomain getTencentFace(EcloudPublicKey config, String orderNo, String userId) {

        if (ClassUtil.isBlank(orderNo)) {
            ClassUtil.returnECloudDomain(ErrorMessage.FACE_ORDER.getCode(), ErrorMessage.FACE_ORDER.getMessage());
        }
        if (ClassUtil.isBlank(userId)) {
            ClassUtil.returnECloudDomain(ErrorMessage.USERID_ERR.getCode(), ErrorMessage.USERID_ERR.getMessage());
        }


        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("orderNo", orderNo);
        ECloudBean eCloudBean = new ECloudBean(config, SdkApiAction.SELECTTENCENT_FACE_URL, SdkApiAction.METHODPOST, param);
        return eCloudBean.executeMethod();
    }


    /**
     * 获取产品用户数据统计
     * <p>Title: getStatisticsTempData</p>
     * <p>Description: </p>
     *
     * @param saasUser
     * @return
     */

    public static ECloudDomain getStatisticsTempData(EcloudPublicKey config, String saasUser) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(saasUser)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.APP_SAASUSER_CONTENT_ERR.getCode(), ErrorMessage.APP_SAASUSER_CONTENT_ERR.getMessage());
        }
        map.put("saasUser", saasUser);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.STATIXTICS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain contactList(EcloudPublicKey config, String saasUser, String contractName, String contractNum,
                                           String startDate, String endDate, String searchMobile, Pagination pagination, Integer status) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(saasUser)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.APP_SAASUSER_CONTENT_ERR.getCode(), ErrorMessage.APP_SAASUSER_CONTENT_ERR.getMessage());
        }
        map.put("saasUser", saasUser);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.STATIXTICS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadContract(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_INFO.getCode(), ErrorMessage.FILE_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_CONTRACT, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadContractNew(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_INFO.getCode(), ErrorMessage.FILE_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_CONTRACT_NEW, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadTemplate(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.FILE_INFO.getCode(), ErrorMessage.FILE_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_TEMPLATE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain addComponents(EcloudPublicKey config, String components) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(components)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("components", components);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADD_COMPONENTS, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain delComponents(EcloudPublicKey config, String componentIds) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(componentIds)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("componentIds", componentIds);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DEL_COMPONENTS, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain createByTemplateComponents(EcloudPublicKey config, String createContractParam) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(createContractParam)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("createContractParam", createContractParam);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATECONTRACT_COMPONENTS, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadImage(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_IMAGE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain uploadFile(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_FILE, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadFileUrl(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_FILE_URL, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain uploadContractUrl(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_CONTRACT_UEL, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }


    public static ECloudDomain uploadTemplateUrl(EcloudPublicKey config, String fileInfo) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(fileInfo)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("fileInfo", fileInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.UPLOAD_TEMPLATE_UEL, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    public static ECloudDomain getTemplateInfo(EcloudPublicKey config, String templateNumber) {
        Map<String, String> map = new TreeMap<String, String>();

        if (ClassUtil.isBlank(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.COMPONENTS_INFO.getCode(), ErrorMessage.COMPONENTS_INFO.getMessage());
        }
        map.put("templateNumber", templateNumber);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.TEMPLATE_INFO, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }



}
