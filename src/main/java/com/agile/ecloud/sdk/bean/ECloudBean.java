package com.agile.ecloud.sdk.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.util.DateUtil;
import com.agile.ecloud.sdk.util.HttpClientUtil;
import com.agile.ecloud.sdk.util.HttpUtil;
import com.agile.ecloud.sdk.util.HttpsClient;
import com.agile.ecloud.sdk.util.MD5Util;
import com.alibaba.fastjson.JSONObject;

public class ECloudBean {
    private String              appKey;
    
    private String              signature;
    
    private String              timestamp;
    
    private String              v;
    
    private String              nonce;
    
    private String              action;
    
    private String              method;
    
    private File                file;
    
    private HttpServletRequest request;
    
//    private String              scope;
    
    private Map<String, File>   files    = new HashMap<String, File>();
    
    private Map<String, String> paramMap = new TreeMap<String, String>();
    
    private Map<String, Object> fileMap  = new TreeMap<String, Object>();
    
    /**
     * @param action
     *            接口url
     * @param method
     *            请求方式：POST ,GET
     * @param paramMap
     *            接口参数
     */
//    public ECloudBean(String action, String method, Map<String, String> paramMap) {
//        this.appKey = EcloudPublicKey.app_key;
//        this.timestamp = DateUtil.getTime();
//        this.v = EcloudPublicKey.v;
//        this.nonce = this.getRandomNonce();
//        this.action = EcloudPublicKey.url + action;
//        this.method = method;
//        Map<String, Object> map = new HashMap<String, Object>();
//        paramMap.put("appKey", EcloudPublicKey.app_key);
//        paramMap.put("timestamp", this.timestamp);
//        paramMap.put("v", EcloudPublicKey.v);
//        paramMap.put("nonce", this.nonce);
//        // paramMap.put("scope", this.scope);
//
//        String signature = getSignature(paramMap, EcloudPublicKey.secret).toUpperCase();
//        paramMap.put("signature", signature);
//        this.paramMap = paramMap;
//    }
    
    
    public ECloudBean(EcloudPublicKey config, String action, String method, Map<String, String> paramMap) {
        this.appKey = config.getApp_key();
        this.timestamp = DateUtil.getTime();
        this.v = config.getV();
        this.nonce = this.getRandomNonce();
        this.action = config.getUrl() + action;
        this.method = method;
        Map<String, Object> map = new HashMap<String, Object>();
        paramMap.put("appKey", config.getApp_key());
        paramMap.put("timestamp", this.timestamp);
        paramMap.put("v", config.getV());
        paramMap.put("nonce", this.nonce);

        String signature = getSignature(paramMap, config.getSecret()).toUpperCase();
        paramMap.put("signature", signature);
        this.paramMap = paramMap;
    }
    
    public static String getSignature(Map<String, String> paramMap, String secret) {
        List<String> paramList = new ArrayList<String>();
        for (Map.Entry entry : paramMap.entrySet()) {
            paramList.add(entry.getKey().toString());
        }
        // 对paramNameList进行排序
        Collections.sort(paramList);
        StringBuffer sb = new StringBuffer(secret);
        if (paramList.size() > 0) {
            for (String paramName : paramList) {
                if (!"signature".equals(paramMap.get(paramName))) {
                    String value = paramMap.get(paramName);
                    if (value != null && !"".equals(value)) {
                        sb.append(value);
                    }
                }
            }
        }
        sb.append(secret);
//        System.out.println("signature="+sb);
        String verifySign = MD5Util.encode(sb.toString());
        return verifySign;
    }
    
    private String getRandomNonce() {
        Random r = new Random();
        Integer random = r.nextInt(899999) + 100000;
        return random.toString();
    }
    
    public ECloudDomain executeMethod() {
        String result = null;
        try {
            if (this.getMethod().equals("post")) {
                NameValuePair[] param = new NameValuePair[this.getParamMap().size()];
                
                List<org.apache.http.NameValuePair> params = new ArrayList<org.apache.http.NameValuePair>();
                
                int i = 0;
                for (Map.Entry entry : this.getParamMap().entrySet()) {
                    param[i] = new NameValuePair(entry.getKey().toString(), entry.getValue().toString());
                    org.apache.http.NameValuePair pair = new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString());
        			params.add(pair);
                    i++;
                }
                if (this.file != null) {
                    result = HttpsClient.doPostFile(this.getAction(), params, this.file);
                } else if (!this.files.isEmpty()) {
                    result = HttpClientUtil.doPost(this.getAction(), param, this.files);
                } else {
                    result = HttpsClient.doPost(this.getAction(), params);
//                    result = HttpClientUtil.doPost(this.getAction(), param);
                }
//                 System.out.println(result);
            } else {
                result = HttpUtil.get(this.getAction(), this.getParamMap(), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ECloudDomain(ErrorMessage.HTTP_REQUEST_ERR.getCode(), ErrorMessage.HTTP_REQUEST_ERR.getMessage()+e.getMessage(), e.getMessage());
        }
        ECloudDomain eCloudDomain = new ECloudDomain(result);
        return eCloudDomain;
    }
    
    public String toJson() {
        return JSONObject.toJSONString(this);
    }
    
    public String getAppKey() {
        return appKey;
    }
    
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    
    public String getSignature() {
        return signature;
    }
    
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getV() {
        return v;
    }
    
    public void setV(String v) {
        this.v = v;
    }
    
    public String getNonce() {
        return nonce;
    }
    
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public Map<String, String> getParamMap() {
        return paramMap;
    }
    
    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }
    
    public Map<String, Object> getFileMap() {
        return fileMap;
    }
    
    public void setFileMap(Map<String, Object> fileMap) {
        this.fileMap = fileMap;
    }
    
    public File getFile() {
        return file;
    }
    
    public void setFile(File file) {
        this.file = file;
    }
    
    public Map<String, File> getFiles() {
        return files;
    }
    
    public void setFiles(Map<String, File> files) {
        this.files = files;
    }
    
//    public String getScope() {
//        return scope;
//    }
//    
//    public void setScope(String scope) {
//        this.scope = scope;
//    }

}
