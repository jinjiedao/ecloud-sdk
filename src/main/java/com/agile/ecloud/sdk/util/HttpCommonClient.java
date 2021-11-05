package com.agile.ecloud.sdk.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpCommonClient {
    private static final Logger log = LoggerFactory.getLogger("httpclient");

    public static String doPost(String url, NameValuePair[] param) {
        log.debug("post url::" + url);
        for (int i = 0; i < param.length; i++) {
            if (i == param.length - 2) {
                log.debug("HttpUtil::doPost:::Param.NAME::base64::VALUE::base64");
                continue;
            }
            log.debug("HttpUtil::doPost::::Param...NAME" + param[i].getName() + "VALUE" + param[i].getValue());
        }
        // HttpResult<String> result = new HttpResult<String>();
        String result = "";
        PostMethod postMethod = new PostMethod(url);
        HttpClient httpclient = new HttpClient();
        try {
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            // httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            if (param != null) {
                postMethod.setRequestBody(param);
            }
            postMethod.releaseConnection();
            int statusCode = httpclient.executeMethod(postMethod);
            log.debug("post url  statusCode::" + statusCode);
            if (statusCode == 200) {
                result = postMethod.getResponseBodyAsString();
            } else {
                // result.setState(false);
                // result.setErrorCode(statusCode + "");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            postMethod.releaseConnection();
        }
        return result;
    }

    public static void main(String[] args) {

        NameValuePair[] param = new NameValuePair[] { new NameValuePair("appKey", "yyzy98ceued55559i2"),
                new NameValuePair("nonce", "998208"),
                new NameValuePair("signature", "7F127371ACA7F6D36B083740996E1FAC"),
                new NameValuePair("templateName", "中文..."), new NameValuePair("timestamp", "2016-11-08 14:22:23"),
                new NameValuePair("v", "1.0"), new NameValuePair("html", "<html><bod></body></html>") };
        doPost("https://testapi.ecloudsign.com/ecs/template/addHtmlTemplate.jspa", param);
    }
}
