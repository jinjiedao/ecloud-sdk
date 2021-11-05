package com.agile.ecloud.sdk.http.result;

import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.common.SdkApiAction;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.TreeMap;

public class AuthResult {


    /**
     *
     * @param realName 真实姓名
     * @param mobile   手机号
     * @param bankNumber 银行卡号
     * @param idCardNumber 身份证号
     * @param verifyType 认证类型
     * @return
     */
    public static ECloudDomain bankVerify(EcloudPublicKey config, String realName, String mobile, String bankNumber, String idCardNumber, Integer verifyType) {
        Map<String, Object> map = new TreeMap<>();

        if (realName == null || "".equals(realName)) {
            return new ECloudDomain(ErrorMessage.TYPE_ERR.getCode(), ErrorMessage.TYPE_ERR.getMessage(), "");
        }
        map.put("realName", realName);
        map.put("mobile", mobile);

        if (bankNumber == null || "".equals(bankNumber)) {
            return new ECloudDomain(ErrorMessage.ID_CARD_NUM_ERR.getCode(), ErrorMessage.ID_CARD_NUM_ERR.getMessage(), "");
        }
        map.put("bankNumber", bankNumber);

        if (idCardNumber == null || "".equals(idCardNumber)) {
            return new ECloudDomain(ErrorMessage.NAME_ERR.getCode(), ErrorMessage.NAME_ERR.getMessage(), "");
        }
        map.put("idCardNumber", idCardNumber);

        if (verifyType == null ) {
            return new ECloudDomain(ErrorMessage.MOBILE_PHONE_ERR.getCode(), ErrorMessage.MOBILE_PHONE_ERR.getMessage(), "");
        }
        map.put("verifyType", verifyType);

        Map<String, String> map1 = new TreeMap<String, String>();
        String bankInfo = JSONObject.toJSONString(map);
        map1.put("bankInfo", bankInfo);
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.BANK_VERIFY_ACTION, SdkApiAction.METHODPOST, map1);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
}
