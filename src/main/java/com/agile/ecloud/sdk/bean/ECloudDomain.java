package com.agile.ecloud.sdk.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * @explain 返回数据模型
 * 
 */
public class ECloudDomain {
    private String code;

    private String message;

    private Object data;

    public ECloudDomain() {

    }

    public ECloudDomain(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ECloudDomain(String json) {
        if (json != null && !"".equals(json)) {
            JSONObject o = JSONObject.parseObject(json);
            JSONObject o1 = JSONObject.parseObject(o.get("meta").toString());
            this.code = o1.get("code").toString();
            this.message = o1.get("message").toString();
            this.data = o.get("data");

        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
