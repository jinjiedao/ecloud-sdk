package test;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.util.Base64Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;

public class UnitDemo {
    protected String appKey = "yyzd5b541e0zpxznp1";
    protected String secrept = "a96c58ff47d5e41d771dc375bcac108a";
    protected String secret = secrept;
    protected String aesKey = "647rbw8mjackpdq4";

    //本地环境
//    protected String url = "http://localhost:8080";
//    protected String h5url = "https://fat-yss-h5.myrrx.com/signFilePage";

    //测试环境
    protected String url = "http://testapi.ecloudsign.cn";
    protected String h5url = "https://fat-yss-h5.myrrx.com/signFilePage";

    //正式环境
    //protected String url = "https://api.ecloudsign.cn";
    //protected String h5url = "https://h5.ecloudsign.com/signFilePage";

    @Before
    public void init() {
        EcloudPublicKey.init(appKey, secrept, "1.0", url);
    }

    @Test
    public void applyCert() {
        //EcloudClient.applyCert("","","","","");
        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", "210105182102032210", "xxx",
                "15000000021");

        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void updateCert() {
        //type 1，cardType 0
        ECloudDomain eCloudDomain = EcloudClient.updateCert("1","0", "210105182102032210", "xxx", "15000000021");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void changeMobile() {
        ECloudDomain eCloudDomain = EcloudClient.changeMobile("1", "0", "210105182102032210", "xxx","15000000022");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void getCertInfo() {
        //type 1，cardType 0
        ECloudDomain eCloudDomain = EcloudClient.getCertInfo("1","0","210105182102032210");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void uploadContract() throws Exception {
        JSONObject obj = new JSONObject();
        String fname = "e:\\intro.pdf";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        obj.put("mobilePhone", "15000000001");
        obj.put("fileData", fdata);
        obj.put("fileMd5", DigestUtils.md5Hex(bdata));
        obj.put("fileType", "pdf");//注意小写
        obj.put("fileName", "ht.pdf 模板.pdf");
        obj.put("fileSize", Base64Util.getSize(fname));
        ECloudDomain eCloudDomain = EcloudClient.uploadContract(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void addComponents() {
        JSONObject obj= new JSONObject();
        JSONObject s= new JSONObject();
        obj.put("templateNumber","D96F3076323ABE7B");
        s.put("type",6);
        JSONObject t= new JSONObject();
        t.put("positionName","qsq");
        t.put("page",1);
        t.put("label","xx");
        t.put("required","true");
        t.put("width","15");
        t.put("height","15");
        t.put("font","2");
        t.put("fontSize","15");
        t.put("textColor","1");
        t.put("x",100);
        t.put("y",100);
        s.put("context",t);
        obj.put("structComponent",s);
        ECloudDomain eCloudDomain = EcloudClient.addComponents(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void addSign() {
        ECloudDomain seal = EcloudClient.createSeal("15000000001", "人人信", "合同章", "123456");
        System.out.println(JSONObject.toJSONString(seal));
    }

    @Test
    public void getSignImg() {
        ECloudDomain seal = EcloudClient.getSignImg("15000000001","2297");
        System.out.println(JSONObject.toJSONString(seal));
    }


    @Test
    public void createByTemplateComponents() {
       //EcloudClient.createByTemplateComponents();
    }




}
