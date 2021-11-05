package com.agile.ecloud.sdk.test;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ContractInfoSignApiParam;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.util.Base64Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UnitDemo {
    protected String appKey = "yyzd5b541e0zpxznp1";
    protected String secrept = "a96c58ff47d5e41d771dc375bcac108a";
    protected String secret = secrept;
    protected String aesKey = "647rbw8mjackpdq4";

    //本地环境
  /*  protected String url = "http://localhost:8080";
    protected String h5url = "https://fat-yss-h5.myrrx.com/signFilePage";
*/
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
        ECloudDomain eCloudDomain = EcloudClient.applyCert("{\"cardType\":\"1\",\"idCardNum\":\"632156199911240789\",\"mobilePhone\":\"13120003068\",\"name\":\"xxxxx\",\"type\":\"1\"}");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void addSign() throws Exception {
        String fname = "D:\\1.png";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        ECloudDomain eCloudDomain = EcloudClient.addSign("13400003068","3",fdata);
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void createSeal() {
        ECloudDomain seal = EcloudClient.createSeal("13120003068",
                "中天祥焱国际货运代理（北京）有限公司上海天祥国际货代分看哈哈公司",
                "合同专用章",
                 "90908998767856780Y");
        System.out.println(JSONObject.toJSONString(seal));
    }

    @Test
    public void createSign() {
        ECloudDomain seal = EcloudClient.createSign("13400003068","李华",1,32,2,"#FF0000");
        System.out.println(JSONObject.toJSONString(seal));
    }


    @Test
    public void getsignList() {
        ECloudDomain seal = EcloudClient.getsignList("13400003068", "1");
        System.out.println(JSONObject.toJSONString(seal));
    }



    @Test
    public void getSignImg() {
        ECloudDomain seal = EcloudClient.getSignImg("13400003068","281150");
        System.out.println(JSONObject.toJSONString(seal));
    }


    @Test
    public void handWriting() {
        ECloudDomain seal = EcloudClient.handWriting("13400003068","https://www.baidu.com/");
        System.out.println(JSONObject.toJSONString(seal));
    }

    @Test
    public void handWritingAddSign() throws Exception {
        String fname = "D:\\1.png";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        ECloudDomain seal = EcloudClient.handWritingAddSign("dcc776928111764cb03dc7dcd0d3eb76",fdata,"1");
        System.out.println(JSONObject.toJSONString(seal));
    }



    @Test
    public void setDefaultSign() {
        ECloudDomain seal = EcloudClient.setDefaultSign("13120003068","280142");
        System.out.println(JSONObject.toJSONString(seal));
    }

    @Test
    public void delSign() {
        ECloudDomain seal = EcloudClient.delSign("13400003068","275984");
        System.out.println(JSONObject.toJSONString(seal));
    }



    @Test
    public void uploadTemplate() throws Exception {
        JSONObject obj = new JSONObject();
        String fname = "D:\\合同模板.docx";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        obj.put("fileData", fdata);
        obj.put("fileMd5", DigestUtils.md5Hex(bdata));
        obj.put("fileType", "docx");
        obj.put("fileName", "合同模板");
        obj.put("fileSize", Base64Util.getSize(fname));
        ECloudDomain eCloudDomain = EcloudClient.uploadTemplate(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void addComponents() {
        JSONObject obj= new JSONObject();
        JSONObject s= new JSONObject();
        obj.put("templateNumber","C30BADC8407537CE");
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
    public void delComponents() {
        JSONObject obj= new JSONObject();
        obj.put("templateNumber","0E7D4DD8FDE01E65");
        obj.put("componentId","963ae920fdef7644");
        ECloudDomain ecloudClient = EcloudClient.delComponents(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(ecloudClient));
    }


    @Test
    public void getTemplateInfo() {
        ECloudDomain ecloudClient = EcloudClient.getTemplateInfo("0E7D4DD8FDE01E65");
        System.out.println(JSONObject.toJSONString(ecloudClient));
    }



    @Test
    public void getTemplateList() {
        ECloudDomain ecloudClient = EcloudClient.getTemplateList("1","10");
        System.out.println(JSONObject.toJSONString(ecloudClient));
    }


    @Test
    public void uploadImage() throws Exception {
        JSONObject obj = new JSONObject();
        String fname = "D:\\tu.jpg";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        obj.put("fileData", fdata);
        obj.put("fileMd5", DigestUtils.md5Hex(bdata));
        obj.put("fileType", "jpg");
        obj.put("fileName", "tu");
        obj.put("fileSize", Base64Util.getSize(fname));
        obj.put("mobilePhone", "13400003068");
        ECloudDomain eCloudDomain = EcloudClient.uploadImage(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void uploadContract() throws Exception {
        JSONObject obj = new JSONObject();
        String fname = "D:\\api合同文档.docx";
        FileInputStream file = new FileInputStream(fname);
        byte[] bdata = IOUtils.toByteArray(file);
        String fdata = Base64.encodeBase64String(bdata);
        obj.put("fileData", fdata);
        obj.put("fileMd5", DigestUtils.md5Hex(bdata));
        obj.put("fileType", "docx");
        obj.put("fileName", "api合同文档");
        obj.put("fileSize", Base64Util.getSize(fname));
        obj.put("mobilePhone", "13400003068");
        ECloudDomain eCloudDomain = EcloudClient.uploadContract(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void uploadContractUrl() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("mobilePhone", "13400003068");
        obj.put("fileType", "docx");
        obj.put("fileName", "api合同文档");
        obj.put("fileUrl", "D:\\api合同文档.docx");
        ECloudDomain eCloudDomain = EcloudClient.uploadContractUrl(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void createByTemplateComponents() {
        JSONObject obj= new JSONObject();
        obj.put("mobilePhone","13400003068");
        obj.put("templateNumber","C30BADC8407537CE");
        obj.put("name","合同模板");
        JSONObject json = new JSONObject();
        json.put("contextId","fffce3cad373b1b9");
        json.put("contextValue","文件");
        JSONArray arr = new JSONArray();
        arr.add(json);
        obj.put("simpleFormFields", arr);
        ECloudDomain eCloudDomain = EcloudClient.createByTemplateComponents(JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void getContractList() {
        ECloudDomain eCloudDomain = EcloudClient.getContractList("13691386720","1","10");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void getContractDetail() {
        ECloudDomain eCloudDomain = EcloudClient.getContractDetail("13691386720","789B82E2A6ABD219");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void getContractImgs() {
        ECloudDomain eCloudDomain = EcloudClient.getContractImgs("13400003068","82E23431E4E007C4");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void downloadContractBase64() {
        ECloudDomain eCloudDomain = EcloudClient.downloadContractBase64("82E23431E4E007C4");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void downloadContract() {
        ECloudDomain eCloudDomain = EcloudClient.downloadContract("3656AC57F9EF865C");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void getDownloadEvidenceUrl() {
        ECloudDomain eCloudDomain = EcloudClient.getDownloadEvidenceUrl("82E23431E4E007C4","13400003068");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void contractCancel() {
        ECloudDomain eCloudDomain = EcloudClient.contractCancel("789B82E2A6ABD219","13691386720");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void verify() {
        ECloudDomain eCloudDomain = EcloudClient.verify(new File("D:\\8.pdf"));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    /**
     * h5批量签署生成路径
     */

    @Test
    public void getSignUrl() {
        String telephone="13400003068";
        String cardType="1";
        String idCardNum="632156198611240789";
        String callBack="https://www.baidu.com";
        String wxCallBack="";
        String type="1";
        ArrayList<ContractInfoSignApiParam> cons = new ArrayList<>();
        cons.add(new ContractInfoSignApiParam("FDB38450FEE3D212","qsq",1,100,100,0));
        cons.add(new ContractInfoSignApiParam("82E23431E4E007C4",null,null,null,null,0));
        ECloudDomain out = EcloudClient.getBatchSignUrl(telephone,cardType,idCardNum,callBack,wxCallBack,type,cons);
        System.out.println(JSONObject.toJSONString(out));
    }





    @Test
    public void addHtmlTemplate() {
       String html="<html>\n" +
               "<head>\n" +
               "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
               "    <meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n" +
               "    <meta name=\"generator\" content=\"Aspose.Words for .NET 17.1.0.0\">\n" +
               "\t<link rel=\"bookmark\"  type=\"image/x-icon\"  href=\"favicon.ico\"/>\n" +
               "    <title>配送承揽服务协议</title>\n" +
               "\t\n" +
               "</head>\n" +
               "<body>\n" +
               "   \n" +
               "<div style=\"width: 676px; margin: 0 auto;\">\n" +
               "    <p style=\"margin-top:20pt; margin-bottom:15.6pt; text-align:center; line-height:150%; widows:0; orphans:0; font-size:22pt\">\n" +
               "        <span style=\"font-weight:bold\">配送承揽服务协议</span>\n" +
               "    </p>\n" +
               "   \n" +
               "    <p style=\"margin-top:10pt; margin-left:21pt; margin-bottom:2.5pt; text-indent:-21pt; text-align:justify; line-height:150%; widows:0; orphans:0; font-size:10.5pt\">\n" +
               "        <span style=\"font-weight:bold\">2</span>\n" +
               "        <span style=\"font:7pt &#39;Times New Roman&#39;\">&nbsp;&nbsp;&nbsp;</span>\n" +
               "        <span style=\"font-weight:bold\">乙方应保质保量完成服务项目</span>\n" +
               "    </p>\n" +
               "    <p style=\"margin-top:10pt; margin-left:21pt; margin-bottom:2.5pt; text-indent:-21pt; text-align:justify; line-height:150%; widows:0; orphans:0; font-size:10.5pt\">\n" +
               "        <span style=\"font-weight:bold\">3</span>\n" +
               "        <span style=\"font:7pt &#39;Times New Roman&#39;\">&nbsp;&nbsp;&nbsp;</span>\n" +
               "        <span style=\"font-weight:bold\">费用结算</span>\n" +
               "    </p>\n" +
               "   \n" +
               "\n" +
               "        <div style=\"width: 49%; display: inline-block; margin-top:10pt; margin-bottom:7.8pt;  font-size:10.5pt\">\n" +
               "\t\t<br/><br/><br/><br/><br/>\n" +
               "            <p style=\"width: 100%\">\n" +
               "                <span>甲&nbsp; 方：</span>\n" +
               "                <span style=\"text-decoration:underline\">{姓名}</span>\n" +
               "            </p>\n" +
               "\t\t\t\n" +
               "\t\t\t<br/><br/><br/><br/><br/>\n" +
               "            <p style=\"width: 100%\">\n" +
               "                <span>电&nbsp; 话：</span>\n" +
               "                <span style=\"text-decoration:underline\">{手机号}</span>\n" +
               "            </p>\n" +
               "        </div>\n" +
               "   \n" +
               "</div>\n" +
               "\n" +
               "</body>\n" +
               "\n" +
               "</html>";
        JSONObject obj1 = new JSONObject();
        obj1.put("positionName","name1");
        obj1.put("page",1);
        obj1.put("x",200);
        obj1.put("y",200);
        JSONObject obj2 = new JSONObject();
        obj2.put("positionName","name2");
        obj2.put("page",1);
        obj2.put("x",300);
        obj2.put("y",300);
        JSONArray arr = new JSONArray();
        arr.add(obj1);
        arr.add(obj2);
        String signPosition = JSONObject.toJSONString(arr);
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate("html测试",html,null,signPosition);
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void editHtmlTemplate() {
        String html="<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n" +
                "    <meta name=\"generator\" content=\"Aspose.Words for .NET 17.1.0.0\">\n" +
                "\t<link rel=\"bookmark\"  type=\"image/x-icon\"  href=\"favicon.ico\"/>\n" +
                "    <title>配送承揽服务协议</title>\n" +
                "\t\n" +
                "</head>\n" +
                "<body>\n" +
                "   \n" +
                "<div style=\"width: 676px; margin: 0 auto;\">\n" +
                "    <p style=\"margin-top:20pt; margin-bottom:15.6pt; text-align:center; line-height:150%; widows:0; orphans:0; font-size:22pt\">\n" +
                "        <span style=\"font-weight:bold\">配送承揽服务协议</span>\n" +
                "    </p>\n" +
                "   \n" +
                "    <p style=\"margin-top:10pt; margin-left:21pt; margin-bottom:2.5pt; text-indent:-21pt; text-align:justify; line-height:150%; widows:0; orphans:0; font-size:10.5pt\">\n" +
                "        <span style=\"font-weight:bold\">2</span>\n" +
                "        <span style=\"font:7pt &#39;Times New Roman&#39;\">&nbsp;&nbsp;&nbsp;</span>\n" +
                "        <span style=\"font-weight:bold\">乙方应保质保量完成服务项目</span>\n" +
                "    </p>\n" +
                "    <p style=\"margin-top:10pt; margin-left:21pt; margin-bottom:2.5pt; text-indent:-21pt; text-align:justify; line-height:150%; widows:0; orphans:0; font-size:10.5pt\">\n" +
                "        <span style=\"font-weight:bold\">100</span>\n" +
                "        <span style=\"font:7pt &#39;Times New Roman&#39;\">&nbsp;&nbsp;&nbsp;</span>\n" +
                "        <span style=\"font-weight:bold\">费用结算(元)</span>\n" +
                "    </p>\n" +
                "   \n" +
                "\n" +
                "        <div style=\"width: 49%; display: inline-block; margin-top:10pt; margin-bottom:7.8pt;  font-size:10.5pt\">\n" +
                "\t\t<br/><br/><br/><br/><br/>\n" +
                "            <p style=\"width: 100%\">\n" +
                "                <span>甲&nbsp; 方1：</span>\n" +
                "                <span style=\"text-decoration:underline\">{姓名}</span>\n" +
                "            </p>\n" +
                "\t\t\t\n" +
                "\t\t\t<br/><br/><br/><br/><br/>\n" +
                "            <p style=\"width: 100%\">\n" +
                "                <span>电&nbsp; 话2：</span>\n" +
                "                <span style=\"text-decoration:underline\">{手机号}</span>\n" +
                "            </p>\n" +
                "        </div>\n" +
                "   \n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        JSONObject obj1 = new JSONObject();
        obj1.put("positionName","name11");
        obj1.put("page",1);
        obj1.put("x",200);
        obj1.put("y",200);
        JSONObject obj2 = new JSONObject();
        obj2.put("positionName","name22");
        obj2.put("page",1);
        obj2.put("x",300);
        obj2.put("y",300);
        JSONArray arr = new JSONArray();
        arr.add(obj1);
        arr.add(obj2);
        String signPosition = JSONObject.toJSONString(arr);
        ECloudDomain eCloudDomain = EcloudClient.editHtmlTemplate("8F5E67689327DAFC","html测试模板编辑",html,signPosition);
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void createContractByTemplate() {
        JSONObject obj = new JSONObject();
        obj.put("姓名","name1");
        obj.put("手机号","13030000033");
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplate("8F5E67689327DAFC",JSONObject.toJSONString(obj));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void getTemplateCont() {
        ECloudDomain eCloudDomain = EcloudClient.getTemplateCont("8F5E67689327DAFC");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void delHtmlTemplate() {
        ECloudDomain eCloudDomain = EcloudClient.delHtmlTemplate("4C205F4EE6BED3CB");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void createContract() {
        ECloudDomain eCloudDomain = EcloudClient.createContract("","13000003068",new File("D:\\测试.pdf"));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }

    @Test
    public void autoSign() {
        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",2);
        signerInfo.put("cardType","0");
        signerInfo.put("idCardNum","632156199911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","131200003068");

        JSONObject signInfo = new JSONObject();
        /*signInfo.put("signType","2");
        signInfo.put("positionName","qsq");*/

        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(signerInfo),"F15CA0DD933ADAF6",
                0,null);
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void multipleSeal() {
        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");

        JSONObject ruleInfo = new JSONObject();
        ruleInfo.put("signType",2);
        ruleInfo.put("signId","279062");
        ruleInfo.put("sealType",1);
        ruleInfo.put("beginPage",1);
        ruleInfo.put("endPage",1);
        ruleInfo.put("firstSeal",50);
        ruleInfo.put("straddleMode","R");

        ECloudDomain eCloudDomain = EcloudClient.multipleSeal("B007E1835A55FC4D",JSONObject.toJSONString(signerInfo),0,JSONObject.toJSONString(ruleInfo));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void sealByKeyword() {

        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");


        JSONObject ruleInfo = new JSONObject();
        ruleInfo.put("signType",2);
        ruleInfo.put("signId","279062");
        ruleInfo.put("keyWord","甲方");
        ruleInfo.put("sealType",1);
        ruleInfo.put("beginPage",1);
        ruleInfo.put("endPage",1);
        ruleInfo.put("orderBy","DESC");
        ruleInfo.put("sealNum",1);
        ruleInfo.put("x",0);
        ruleInfo.put("y",0);

        ECloudDomain eCloudDomain = EcloudClient.sealByKeyword("3406DCFCD9C7EE73",JSONObject.toJSONString(signerInfo),0,JSONObject.toJSONString(ruleInfo));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }


    @Test
    public void sealByKeywordForNum() {

        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");


        JSONObject ruleInfo = new JSONObject();
        ruleInfo.put("signType",2);
        ruleInfo.put("signId","279062");
        ruleInfo.put("keyWord","甲方");
        ruleInfo.put("sealType",1);
        ruleInfo.put("beginPage",1);
        ruleInfo.put("endPage",1);
        ruleInfo.put("orderBy","DESC");
        ruleInfo.put("sealNum",1);
        ruleInfo.put("x",0);
        ruleInfo.put("y",0);
        JSONArray arr = new JSONArray();
        arr.add(ruleInfo);

        JSONObject signImageInfo = new JSONObject();
        signImageInfo.put("signType",1);
        signImageInfo.put("positionName","张三");
        signImageInfo.put("keyWord","甲方");
        signImageInfo.put("sealType",1);
        signImageInfo.put("beginPage",1);
        signImageInfo.put("endPage",1);
        signImageInfo.put("orderBy","DESC");
        signImageInfo.put("sealNum",1);
        signImageInfo.put("x",0);
        signImageInfo.put("y",0);
        signImageInfo.put("fontName","1");
        signImageInfo.put("color","#FF0000");
        signImageInfo.put("fontSize",16);
        signImageInfo.put("style",0);
        JSONArray arr2 = new JSONArray();
        arr2.add(signImageInfo);

        ECloudDomain eCloudDomain = EcloudClient.sealByKeywordForNum("E59B715135C0BF05",JSONObject.toJSONString(signerInfo),
                0,JSONObject.toJSONString(arr),JSONObject.toJSONString(arr2));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }




    @Test
    public void autoSignByPoistion() {

        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");


        JSONObject position = new JSONObject();
        position.put("page",1);
        position.put("x","200");
        position.put("y","200");
        position.put("signId","279258");
        JSONArray arr = new JSONArray();
        arr.add(position);


        ECloudDomain eCloudDomain = EcloudClient.autoSignByPoistion(JSONObject.toJSONString(signerInfo),"37A9F8426D0FABA6",
                0,JSONObject.toJSONString(arr));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }





    @Test
    public void autoSignByPoistionForDateImage() {

        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");


        JSONObject position = new JSONObject();
        position.put("page",1);
        position.put("signId","279258");
        position.put("fontName","1");
        position.put("color","#FF0000");
         position.put("fontSize","16");
        position.put("style","0");
         position.put("type","1");
        position.put("x","200");
        position.put("y","200");
        JSONArray arr = new JSONArray();
        arr.add(position);


        ECloudDomain eCloudDomain = EcloudClient.autoSignByPoistionForDateImage(JSONObject.toJSONString(signerInfo),"11D028BC35439C85",
                0,JSONObject.toJSONString(arr));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }




    @Test
    public void sendSms() {
        ECloudDomain eCloudDomain = EcloudClient.sendSms("8D350EC4CB5F0CC0","13100003068","1");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void authorizeSign() {

        JSONObject signerInfo = new JSONObject();
        signerInfo.put("type",1);
        signerInfo.put("cardType",0);
        signerInfo.put("idCardNum","632156198911240789");
        signerInfo.put("name","xxx");
        signerInfo.put("mobilePhone","13100003068");


     JSONObject signInfo = new JSONObject();
        signInfo.put("signType",2);
        signInfo.put("signId","279258");
        signInfo.put("positionName","qsq");


        ECloudDomain eCloudDomain = EcloudClient.authorizeSign(JSONObject.toJSONString(signerInfo),"F36EA7D7F9FE272A",
                0,JSONObject.toJSONString(signInfo),"500993");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void batchSigning() {

        JSONObject signInfo1 = new JSONObject();
        signInfo1.put("contractNum","B25492A80BD8EBFB");
        signInfo1.put("type",1);
        signInfo1.put("cardType",0);
        signInfo1.put("idCardNum","632156198911240789");
        signInfo1.put("name","xxx");
        signInfo1.put("mobilePhone","13100003068");
        signInfo1.put("isFinish",0);
        signInfo1.put("signType",2);
        signInfo1.put("signId","279258");
        signInfo1.put("positionName","qsq");

        JSONObject signInfo2 = new JSONObject();
        signInfo2.put("contractNum","EACF0254AAE2FFEB");
        signInfo2.put("type",1);
        signInfo2.put("cardType",0);
        signInfo2.put("idCardNum","632156198911240789");
        signInfo2.put("name","xxx");
        signInfo2.put("mobilePhone","13100003068");
        signInfo2.put("isFinish",0);
        signInfo2.put("signType",2);
        signInfo2.put("signId","279258");
        signInfo2.put("positionName","qsq");
        JSONArray array = new JSONArray();
        array.add(signInfo1);
        array.add(signInfo2);

        ECloudDomain eCloudDomain = EcloudClient.batchSigning(JSONObject.toJSONString(array));
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }



    @Test
    public void smsBatchSigning() {

        JSONObject signInfo1 = new JSONObject();
        signInfo1.put("contractNum","8D350EC4CB5F0CC0");
        signInfo1.put("type",1);
        signInfo1.put("cardType",0);
        signInfo1.put("idCardNum","632156198911240789");
        signInfo1.put("name","xxx");
        signInfo1.put("mobilePhone","13100003068");
        signInfo1.put("isFinish",1);
        signInfo1.put("signType",2);
        signInfo1.put("signId","279258");
        signInfo1.put("positionName","qsq");

        JSONObject signInfo2 = new JSONObject();
        signInfo2.put("contractNum","8D350EC4CB5F0CC0");
        signInfo2.put("type",1);
        signInfo2.put("cardType",0);
        signInfo2.put("idCardNum","632156198911240789");
        signInfo2.put("name","xxx");
        signInfo2.put("mobilePhone","13100003068");
        signInfo2.put("isFinish",0);
        signInfo2.put("signType",2);
        signInfo2.put("signId","279258");
        signInfo2.put("positionName","qsq");
        JSONArray array = new JSONArray();
        array.add(signInfo1);
        array.add(signInfo2);

        ECloudDomain eCloudDomain = EcloudClient.smsBatchSigning(JSONObject.toJSONString(array),"596698","5DFD5348F15B69A0","13100003068");
        System.out.println(JSONObject.toJSONString(eCloudDomain));
    }





  ArrayList list = new ArrayList();


























}
