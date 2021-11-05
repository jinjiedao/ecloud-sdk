package com.agile.ecloud.sdk.test;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ContractInfoSignApiParam;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.util.AESUtils;
import com.agile.ecloud.sdk.util.Base64Util;
import com.agile.ecloud.sdk.util.DateUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.*;

public class CookBookForApiCommon extends CookBookForApi {

    @Before
    public void init() {
        EcloudPublicKey.init(appKey, secrept, "1.0", url);
    }

    @Test
    public void applyCert() {
        //type 1，cardType 0
        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", "210105192102032211", "xxx",
                "15010961260",true);
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    //公共部分

    //账户板块
    //1.1申请证书 /ecs/account/applyCert.jspa
    //1.2生成证书(虚拟手机号) /ecs/account/applyCertString.jspa
    //1.3更新用户证书  /ecs/certificate/updateCert.jspa
    //1.4用户证书详情  /ecs/account/getCertInfo.jspa
    //1.5更换用户手机号    /ecs/account/changeMobile.jspa
    //1.6解绑用户手机号（不推荐使用）  /ecs/account/unwrap.jspa
    //签名印章
    //2.1添加签名/印章  /ecs/signInfo/addSign.jspa
    //2.2生成圆形印章 /ecs/signInfo/createSeal.jspa
    //2.3生成姓名矩形章   /ecs/signInfo/createSign.jspa
    //2.4调启手写签字板


    //模板管理
    //3.1   上传方式创建模板
    @Test
    public void uploadTemplate() throws Exception {
        long start = System.currentTimeMillis();
        String fname = "C:\\Users\\rob\\Documents\\WeChat Files\\wxid_sotyvm3ebod821\\FileStorage\\File\\2021-08\\ht.pdf";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        JSONObject obj = new JSONObject();
        obj.put("fileData", fdata);
        obj.put("fileMd5", DigestUtils.md5Hex(bdata));
        obj.put("fileType", "pdf");
        obj.put("fileName", "ht.pdf 模板.pdf");
        obj.put("fileSize", Base64Util.getSize(fname));

        ECloudDomain out = EcloudClient.uploadTemplate(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }


    //1.2生成证书(虚拟手机号) /ecs/account/applyCertString.jspa
    @Test
    public void applyCertString() {
        long start = System.currentTimeMillis();

        JSONObject o= new JSONObject();
//        o.put("type",1);
//        o.put("cardType",0);
//        o.put("idCardNum","210105198202032215");
//        o.put("name","赵为");
//        o.put("mobilePhone","lihongtao@renrenxin.com");
//        ECloudDomain unwrap = EcloudClient.unwrap(JSONObject.toJSONString(o));
//        System.out.println(JSONObject.toJSONString(unwrap));
        ECloudDomain out=  EcloudClient.applyCert("1", "0", "210105198202032215", "赵为",
                "210105198202032215");
        System.out.println(JSONObject.toJSONString(out));

//        ECloudDomain out = EcloudClient.applyCertString("1",
//                "0", "513901198806241432",
//                "hailong", "lihongtao@renrenxin.com");

       /* ECloudDomain out = EcloudClient.applyCertString("1",
                "0", "513901198806241432",
                "hailong", "15010961260");*/
       /* ECloudDomain out=  EcloudClient.applyCert("1", "0", "210105198202032215", "赵为",
                "lihongtao@renrenxin.com");



        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));*/


       /* ECloudDomain out=  EcloudClient.addSign("2981109403","1",
                "data:image/png;base64,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");
        */
    }

    /**
     * 2.1添加签名/印章  /ecs/signInfo/addSign.jspa
     *
     * @throws Exception
     */
    @Test
    public void addSign() throws Exception {
        //EcloudClient.createContract()
        //类型：1签名 2印章
        ECloudDomain eCloudDomain = EcloudClient.addSign("15001012210", "2",
                Base64Util.encodeBase64File("C:\\Users\\rob\\Downloads\\qianzhang_demo.png"));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    //5.4 关键字带日期
    @Test
    public void sealByKeywordForNum() {
        long start = System.currentTimeMillis();
        JSONObject s = new JSONObject();
        s.put("type", 1);
        s.put("cardType", 0);
        s.put("idCardNum", "330182199301234087");
        s.put("name", "小静");
        s.put("mobilePhone", "18267129585");

        JSONObject r = new JSONObject();
        r.put("signType", 1);
        r.put("signId", 9582118);
        r.put("keyWord", "1");
        r.put("beginPage", 2);
        r.put("endPage", -1);
        r.put("orderBy", "");
        r.put("signNum", 1);
        r.put("sealNum", 1);
        r.put("x", 30);
        r.put("y", -13);

        JSONObject img = new JSONObject();
        img.put("signType", 0);
        img.put("positionName", "");
        img.put("keyWord", "签署日期");
        img.put("beginPage", 1);
        img.put("endPage", -1);
        img.put("orderBy", "DESC");
        img.put("sealNum", 1);
        img.put("signNum", 1);
        img.put("x", 50);
        img.put("y", -12);
        img.put("fontName", 1);
        img.put("color", "#000000");
        img.put("fontSize", "12");
        img.put("style", "0");

        //D7CC8449454FD4CE

//        ECloudDomain faa840BA9B28FB2E = EcloudClient.sealByKeyword("FAA840BA9B28FB2E", JSONObject.toJSONString(s), 0, JSONObject.toJSONString(r));
//        System.out.println(JSONObject.toJSONString(faa840BA9B28FB2E));
        ECloudDomain out = EcloudClient.sealByKeywordForImage("D7CC8449454FD4CE",


                JSONObject.toJSONString(s),
                0,
                JSONObject.toJSONString(r),
//                "[{\"signType\":\"1\",\"signId\":\"9582118\",\"keyWord\":\"\\u4e59\\u65b9\\uff08\\u63a5\\u53d7\\u57f9\\u8bad\\u65b9\\uff0c\\u7b7e\\u5b57\\uff09\\uff1a\",\"beginPage\":1,\"endPage\":-1,\"signNum\":\"1\",\"orderBy\":\"DESC\",\"sealNum\":1,\"x\":30,\"y\":-20}]",
                JSONObject.toJSONString(Arrays.asList(img)));
        System.out.println(DateUtil.fomatString(new Date()));
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));


    }

    //合同文件
    //4.6获取图片/ecs/contract/getContractImgs.jspa
    @Test
    public void getContractImgs() {
        long start = System.currentTimeMillis();
        ECloudDomain out = EcloudClient.getContractImgs("18500052727", "C07B04C8B95EB326");
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }


    //


    //实名认证
    //6.2 个人二要素识别
    @Test
    public void identityAuthUrl() {
        long start = System.currentTimeMillis();
        ECloudDomain out = EcloudClient.identityAuthUrl("阳顶天", "513901198806241431");
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }

    //6.企业四要素识别 /ecs/face/fourElementsIdentification.jspa
    @Test
    public void fourElementsIdentification() {
        long start = System.currentTimeMillis();
        ECloudDomain out = EcloudClient.busThreeElementsIdentification("林笑平", "龙岩市森建工贸有限公司", "91350802MA32YX261U");
//        ECloudDomain out = EcloudClient.fourElementsIdentification("林笑平",
//                "龙岩市森建工贸有限公司","352601196707110034","91350800553213962D");
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }


    //6.企业四要素识别 genPersonRectangleSeal
    @Test
    public void genPersonRectangleSeal() {
//       EcloudClientMuti.genPersonRectangleSeal()
//        ECloudDomain hl = EcloudClient.genPersonRectangleSeal("海龙",64);
//        System.out.println(JSONObject.toJSONString(hl));

       /* long start = System.currentTimeMillis();
        ECloudDomain out = EcloudClient.busThreeElementsIdentification("林笑平","龙岩市森建工贸有限公司","91350802MA32YX261U");
//        ECloudDomain out = EcloudClient.fourElementsIdentification("林笑平",
//                "龙岩市森建工贸有限公司","352601196707110034","91350800553213962D");
        System.out.println(JSONObject.toJSONString(out));
        System.out.println("用时："+(System.currentTimeMillis()-start));*/
    }


    @Test
    public void createByTemplateComponents() {
        JSONObject o= new JSONObject();
        o.put("mobilePhone","15001012210");
        o.put("templateNumber","44041A2B298702F1");
        o.put("name","测试");

        JSONObject zj= new JSONObject();
        zj.put("contextId","4de9868fd56e3ee9");
        zj.put("contextValue","小黑");
        List<JSONObject> jsonObjects = Arrays.asList(zj);
        o.put("simpleFormFields",jsonObjects);

        ECloudDomain out = EcloudClient.createByTemplateComponents(JSONObject.toJSONString(o));
        System.out.println(JSONObject.toJSONString(out));
    }



  /*  @Test
    public void getSignUrl() {
        JSONObject contractInfos= new JSONObject();
        String telephone="15010961260";
        String cardType="1";
        String idCardNum="210105198202032215";
        String callBack="https://www.baidu.com";
        String type="1";
        ArrayList<ContractInfoSignApiParam> cons = new ArrayList<>();
        cons.add(new ContractInfoSignApiParam("YS-274021799631519744","ys-secondparty",null,null,null,1));
        ECloudDomain out = EcloudClient.getBatchSignUrl(telephone,cardType,idCardNum,callBack,type,cons);
        System.out.println(JSONObject.toJSONString(out));
    }
*/


    @Test
    public void sendMobileSms() {
//        JSONObject contractInfos= new JSONObject();
//        String telephone="630872837476851712";
//        String cardType="1";
//        String idCardNum="210105198202032219";
//        String callBack="https://www.baidu.com";
//        ArrayList<ContractInfoSignApiParam> cons = new ArrayList<>();
//        cons.add(new ContractInfoSignApiParam("YS-274021799631519744","ys-secondparty",null,null,null,1));
        String fid="4d21b47f126055668626a1bd5fd7491a";
        String telephone= "15010961260";
        ECloudDomain out = EcloudClient.sendMobileSms(fid,telephone);
        System.out.println(JSONObject.toJSONString(out));
    }



    @Test
    public void signFilePagec1() throws Exception {

        //https://fat-yss-h5.myrrx.com/signFilePage?telephone=XXX&amp;contractNum=XXX&amp;signPosition=XXX×tamp=XXX&amp;appKey=XXX&amp;v=1.0&amp;secret=XXX&amp;cardType=XXX&amp;idCardNum=XXX&amp;name=XXX&amp;isFinish=XXX&amp;type=XXX&amp;callBack=XXX
        //公共请求参数
        JSONObject p = new JSONObject();
        String url = mkUrl("17736038889", "1DE6BE9DBB2A2832",
                new ArrayList<String>(), "1", "513901198806241431", "李甲兴", "1", null);
        System.out.println(url);
    }

    @Test
    public void signFilePage() throws Exception {
        ECloudDomain xxxxx = EcloudClient.applyCertString("1", "0", "210105198202032218", "xxxxx",
                "210105198202032218",true);
        System.out.println(JSONObject.toJSONString(xxxxx));

        //https://fat-yss-h5.myrrx.com/signFilePage?telephone=XXX&amp;contractNum=XXX&amp;signPosition=XXX×tamp=XXX&amp;appKey=XXX&amp;v=1.0&amp;secret=XXX&amp;cardType=XXX&amp;idCardNum=XXX&amp;name=XXX&amp;isFinish=XXX&amp;type=XXX&amp;callBack=XXX
        //公共请求参数
       /* JSONObject p = new JSONObject();
        String url = mkUrl("15027730874", "YR-272207153832394752",
                new ArrayList<String>(), "0", "130103196803222127", "张春芳", "1", "");
        System.out.println(url);*/
    }

    public String mkUrl(String telephone, String contractNum,
                        List<String> signPosition, String cardType, String idCardNum, String name, String isFinish,
                        String callBack
    ) throws Exception {

        Map<String, String> map = new HashMap<>();
        //map.put("appKey", appKey);
        map.put("secret", secret);
        map.put("v", "1.0");
        map.put("timestamp", DateUtil.fomatString(new Date()));
        map.put("telephone", telephone);
        map.put("contractNum", contractNum);
        map.put("cardType", cardType);
        map.put("idCardNum", idCardNum);
        map.put("name", name);
        map.put("isFinish", isFinish);
        //map.put("callBack", "https://www.baidu.com");
        map.put("signPosition", JSONObject.toJSONString(signPosition));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> en : map.entrySet()) {
            if (sb.length() == 0) {
                sb.append(String.format("%s=%s", en.getKey(), AESUtils.aesEncrypt(en.getValue(), aesKey)));
            } else {
                sb.append(String.format("&%s=%s", en.getKey(), AESUtils.aesEncrypt(en.getValue(), aesKey)));
            }
        }
        sb.append(String.format("&%s=%s", "appKey", appKey));
        sb.append(String.format("&%s=%s", "callBack", callBack));
        return String.format(h5url + "?%s", sb.toString());
    }



}
