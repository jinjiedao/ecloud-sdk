package com.agile.ecloud.sdk.test;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.http.EcloudClientMuti;
import com.alibaba.fastjson.JSONObject;

public class TestAboutContract {

	public static String templateNumber = "7325892EF969DBF0"; // 44189159438AA97A

	public static void main(String[] args) {
		//测试环境地址
		String url = "https://testapi.ecloudsign.cn";
		//生产环境地址
//		 String url = "https://api.ecloudsign.cn/";
		String appKey = "xxxxx";// 如需此参数，请联系公司工作人员
		String secrept = "xxxxx";
		 //单应用
		 EcloudPublicKey.init(appKey, secrept, "1.0", url);
		 ECloudDomain eCloudDomain = EcloudClient.applyCert("{\"cardType\":\"0\",\"idCardNum\":\"430581199110246017\",\"mobilePhone\":\"13049857690\",\"name\":\"黎明\",\"type\":\"1\"}");
	     JSONObject.toJSONString(eCloudDomain);
	     //多应用
	     EcloudClientMuti.applyCert(EcloudPublicKey.instance, "{\"cardType\":\"0\",\"idCardNum\":\"430581199110246017\",\"mobilePhone\":\"13049857690\",\"name\":\"黎明\",\"type\":\"1\"}");
	     JSONObject.toJSONString(eCloudDomain);
	     
	}

}
