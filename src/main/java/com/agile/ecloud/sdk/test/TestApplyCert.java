package com.agile.ecloud.sdk.test;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.alibaba.fastjson.JSONObject;

public  class  TestApplyCert {

    public static void main(String[] args) {
        //测试环境地址
        String url = "https://testapi.ecloudsign.cn";
        //生产环境地址
        //String url = "https://api.ecloudsign.cn/";

        //开放平台获得   参考接入流程 https://easydoc.net/doc/49148953/yvpGV16E/lbjZEat8
        String appKey = "xxx";
        String secrept = "xxx";

        //初始化应用配置
        EcloudPublicKey.init(appKey, secrept, "1.0", url);

        JSONObject param= new JSONObject();
        param.put("cardType","0");
        param.put("idCardNum","430000000000000000");
        param.put("mobilePhone","13000000000");
        param.put("name","黎明");
        param.put("type","1");

        //请求结果统一封装到 ECloudDomain对象中
        ECloudDomain out = EcloudClient.applyCert(JSONObject.toJSONString(param));
        System.out.println(JSONObject.toJSONString(out));
    }
}