package test;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.http.result.ContractResult;
import com.agile.ecloud.sdk.util.Base64Util;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.agile.ecloud.sdk.util.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

import sun.misc.BASE64Decoder;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import javax.imageio.ImageIO;

//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;

public class TestEcloudClient {


    public static String templateNumber = "3AD7729D31C3C8E5"; //    44189159438AA97A

    public static String contractNum = "4E0B90E5AD9ADD4B"; // fda6bc82996fd19f


//    public static String mobilePhone = "15001372210";                //
      public static String mobilePhone = "13001156426";    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
//    	String url = "https://testapi.ecloudsign.cn";
        // EcloudPublicKey.init(appKey, secrept, "1.0", url);
//    	try {
//			pdf2NewImg("C:\\Users\\shiyuezeng\\Desktop\\7b9c3497-f849-44ec-afd8-a202fcb02744 (1).pdf");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
         String url = "https://api.ecloudsign.cn/";
//        String url = "https://api.ecloudsign.cn";//200的机器，197的数据库
//         String url = "http://192.168.1.182:9081/"; //
//
//        String appKey = "yyz750vw83ua416k73";// 如需此参数，请联系公司工作人员线上
//        String secrept = "eea67680f8a833fdf18832ac4379fc61";
//        String appKey = "yyzzsn07i1o1v2fui6d0";// 如需此参数，请联系公司工作人员
//        String secrept = "74740dfe5d933a25de02cb310e7fd549";
//3 | yyzzstesttc8pgk1s50qc598     | cc433f8a37633b160fe09a9b333811c5 正式环境测试号
//////         测试关键字图片签署
//       String appKey = "yyzzs8j459r6x9l623xp";// 如需此参数，请联系公司工作人员 -------------
//       String secrept = "fefdce0eca8818162804ffb30f56e964";

//        String appKey = "yyzzs6j4vy081071200s";// 如需此参数，请联系公司工作人员线上易云章
//        String secrept = "baef47975fe242584ec2ee40850a9c03";
        
//        // 正式环境测试号
//         String appKey = "yyzzs711rjr0687b39um";// 如需此参数，请联系公司工作人员
//        String secrept = "de8772e2016f0262809b2f62e90df296";
//        String url = "https://testapi.ecloudsign.com/";//200的机器，197的数据库

        // 迁移测试号
//        APPID:yyzzs711rjr0687b39um; 平台密钥:de8772e2016f0262809b2f62e90df296

        // 正式环境 安东石油短信签测试
//        String appKey = "yyzzsiwxqn485l6fu590";// 如需此参数，请联系公司工作人员
//        String secrept = "5a595649de583726e69f09252e869303";
        // 今借到正式号
//        String appKey = "yyzzsy322d307i6vk92i";// 如需此参数，请联系公司工作人员
//        String secrept = "e415ae8d072f2484f0a823bd7857c3f5";
// yyzzsy322d307i6vk92i e415ae8d072f2484f0a823bd7857c3f5 今借到正式号

        // 正式环境测试号
        String appKey = "yyzzs5v3z02fji9of7j4";// 如需此参数，请联系公司工作人员
        String secrept = "352d753cf7609f1a3c470bfef15a0680";
//        APPID:yyzzs711rjr0687b39um; 平台密钥:de8772e2016f0262809b2f62e90df296

         EcloudPublicKey.init(appKey, secrept, "1.0", url);
//        String url = "https://testapi.ecloudsign.com/";
        // String url = "http://192.168.1.182:9081/";
        // EcloudPublicKey.init(appKey, secrept, "1.0", url);
//         ECloudDomain result = applyCertSeal(url, appKey, secrept, "123456");
        // System.out.println(result);
        // 测试2
        // ECloudDomain result = applyCertSeal(url, appKey, secrept, "asfdas");
        // System.out.println(result.getMessage());
        // System.out.println("------------------------------------------");
			
	    ECloudDomain eCloudDomain = EcloudClient.applyCertString("2", "8", "91110108MA01C3NF0U", "北京无忧节奏传媒有限公司", "");
			
       
//        JSONObject jo1 = JSONObject.parseObject(JSONObject.toJSONString(eCloudDomain.getData()));
//        byte[] bytes = null;
//        bytes = jo1.getString("bytes").getBytes();
//          downloadContractByPath("2020101600079", "D://789456.pdf");
        
        
//        		applyCert("2", "8", "239005198004293428", "张斌", "17717291187");
//        		busThreeElementsIdentification("吕珍珍", "北京易云章科技有限公司", "91110108MA01D7G504");
//        autoSign();
//        ECloudDomain eCloudDomain = EcloudClient.signPage("15810664505", "3", "www.baidu.com");
//         ECloudDomain result1 = downloadContract("WUYICONTRACTNUM20200706171115404918");
//         JSONObject jo1 = JSONObject.parseObject(JSONObject.toJSONString(result1.getData()));
//         byte[] bytes = null;
//         bytes = jo1.getString("bytes").getBytes();
//         writeFile("D://123456.doc", bytes);
//         writeNewFile("D://", bytes, "123456.pdf");
      
         
        // System.out.println(result1.getMessage());
          
//         ECloudDomain result = applyCertMobile();
//        ECloudDomain result = getCertInfo();
//         ECloudDomain result = unwrap();

//        银行卡认证
//        ECloudDomain result = bankVerify("刘博", "15001372210", "12345678", "210727199503024211", 4);

        // 签署人更换手机
//         ECloudDomain result = changeMobile();
        /******************************* 签名/签章 *************************************/
        // 添加 签名/签章//{"signId":659}
//         ECloudDomain result = addSign();
        // 创建 签名/签章//{"signId":659}
//        ECloudDomain result = createSign();
        // 设置默认 签名/签章
//         ECloudDomain result = setDefaultSign();

        // 签名/签章列表
//         ECloudDomain result = getsignList();

        // 删除签名/签章列表
//         ECloudDomain result = delSign();
        /******************************* 模板 *************************************/
        // 添加模板
//         ECloudDomain result = addHtmlTemplate("C:\\Users\\shiyuezeng\\Desktop\\071415182954_20200917185034.html");
         
//           createContractByTemplate(templateNumber);
         
        // System.out.println(result);
        // 司机宝新修改接口
//        ECloudDomain result = addHtmlTemplateHaveSignPosition();// 新增模板
        // 更新模板
//         ECloudDomain result = editHtmlTemplate(templateNumber);

        // 获取模板列表
//         ECloudDomain result = getTemplateList();

        // 获取模板内容

//         ECloudDomain result = getTemplateCont();
        // System.out.println(result);

        // 添加模板和变量
        // ECloudDomain result = addHtmlTemplateVars();

        // 更新模板和变量
//         ECloudDomain result = editHtmlTemplateVars();

        // 获得模板变量
//         ECloudDomain result = getTemplateVars(templateNumber);

        // 根据模板生成合同文档BY VARS
//         ECloudDomain result = createContractByTemplateByVar(templateNumber);
        /******************************* 合同 *************************************/
        // 获取合同列表合同
//         ECloudDomain result = getContractList();

        // 获取合同详情
//         ECloudDomain result = getContractDetail();
         
         //获取合同图片SYGZ01-XFXS-DZ-202000047
//         ECloudDomain result = getContractImgs();
         
         
//         if(result!=null) {
//	    	JSONObject jo1 = JSONObject.parseObject(JSONObject.toJSONString(result.getData()));
//	    	List<String> list = (List<String>) JSONArray.parseArray(jo1.getString("contractImgs"),String.class);
//	    	for (int i = 0; i <list.size(); i++) {
//				GenerateImage(list.get(i), i+".jpg", "D://");
//				
//			}
//	     }
        
        // 申请CA证书
//            ECloudDomain result = applyCert();
           // 根据模板生成合同文档
 
           // 自动签署合同
//         ECloudDomain result = autoSign();
        
        // 根据模板生成合同文档BY VARS
//      ECloudDomain result = createContractByTemplateByVar(templateNumber);
         
           // 上传合同
//          ECloudDomain result = createContract();

          //关键字签署过程中盖图片
//          ECloudDomain result = sealByKeywordForImage();
        //获取合同图片SYGZ01-XFXS-DZ-202000047
//        ECloudDomain result = getContractImgs();
          
        // 发起合同
        // ECloudDomain result = launchContract();

        // 发起带通知短信的合同
//         ECloudDomain result = launchContractSendSms();
        // 发起合同自动签或网签
//         ECloudDomain result = launchContractAutoSignAndSendSms();

        // 签署合同
//         ECloudDomain result = sealContract();

     // 自动生成印章
//        ECloudDomain result = createSeal();
        
        // 关键字签署
//         ECloudDomain result = sealByKeyword();

        // 下载
//         ECloudDomain result = downloadContract("8C17BBD02C738ACE");
//         downloadContractByPath("483340A8D765FD02", "/home/bob/Desktop/8.pdf");// 直接下载到本地

        // 下载合同二进制流
//        ECloudDomain result =downloadContractBin(contractNum, "d:/1.pdf");
//        ECloudDomain result = ContractResult.downloadContractBin(contractNum, "1");


        // ECloudDomain result =
//        ECloudDomain result =  editHtmlTemplateHaveSignPosition(templateNumber);// 修改模板
//         ECloudDomain result = createContractByTemplate(templateNumber);
//         ECloudDomain result = autoSignHaveSignInfo();// 自动签署含签章信息
        // 12月1日新增接口
        // ECloudDomain result = getCertInfo();
//         ECloudDomain result = sendSms();// 发送验证码
//         ECloudDomain result = authorizeSign("089567");// 通过验证码自动签署合同

        // 2017年2月13日新增接口
        // ECloudDomain result = renewCert();

        // 2017年3月1日新增接口
        // 作废合同
        // ECloudDomain result = cancelContract();
        // 合同验真
        // ECloudDomain result = verify();
        // 2017年3月6日新增接口
        

        // 2017年3月8日
        // 生成合同
//           ECloudDomain result = createContractByTemplate(templateNumber);
//           autoSignForString();
        // 签署合同
//         ECloudDomain result = autoSignByPoistion();
//         ECloudDomain result = autoSignByPoistionForMobile12();
        
//           ECloudDomain result = createInvalidContract();
        // 下载合同
//         ECloudDomain result1 = downloadCont();
        // ECloudDomain result1 = idCard();

        // downloadContractByPath(contractNum, "d:/5.pdf");// 直接下载到本地
        //

        // System.out.println("code:" + result.getCode() + ",message:" +
        // result.getMessage());
//        String endDate = DateUtil.getTime();
//        System.out.println("startDate=" + startDate + ":::" + "endDate=" + endDate);
//        System.out.println(result.toJson());

        // 骑缝章、多页相同位置批量签
//        ECloudDomain result = multipleSeal();
    }

    /**
     * 远程申请证书
     *
     * @param url
     * @param appKey
     * @param secrept
     * @param jsonInfo
     * @return
     */
    public static ECloudDomain applyCertSeal(String url, String appKey, String secrept, String jsonInfo) {
        EcloudPublicKey.init(appKey, secrept, "1.0", url);

        ECloudDomain eCloudDomain = EcloudClient.remoteApplySeal(jsonInfo);
        return eCloudDomain;
    }

    public static ECloudDomain applyCert() {
//        System.out.println("start date:::" + DateUtil.getTime());
//        Random r = new Random();
//        Integer random = r.nextInt(899999) + 100000;
//        String cardNum = "110105198710" + random.toString();
//        String randomName = "";
//        for (int i = 0; i < 10; i++) {
//            randomName = randomName + (char) (Math.random() * 26 + 'A');
//        }
//        String mobilePhoneRandomNum = "1581";// "15818322868";
//        for (int i = 0; i < 7; i++) {
//            mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
//        }

//        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", "210727199409024217", "测试7号", "15001372218" +
//                "");
        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", "342125197304205625", "戴林嫒", "18257136675");

        // ECloudDomain eCloudDomain = EcloudClient.applyCert("2", "8",
        // "1341444141414441", "xlma", "18618192052");
        System.out.println("end date:::" + DateUtil.getTime());

        return eCloudDomain;
    }

    public static ECloudDomain applyCertMobile() {
        System.out.println("start date:::" + DateUtil.getTime());
        Random r = new Random();
        Integer random = r.nextInt(899999) + 100000;
        String cardNum = "110105198710" + random.toString();
        String randomName = "";
        for (int i = 0; i < 10; i++) {
            randomName = randomName + (char) (Math.random() * 26 + 'A');
        }
        String mobilePhoneRandomNum = "1581";// "15818322868";
        for (int i = 0; i < 7; i++) {
            mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
        }

//        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", "210727199409024217", "测试7号", "15001372218" +
//                "");
        ECloudDomain eCloudDomain = EcloudClient.applyCertMobile("1", "0", "210727199409024218", "bob3", "150013722111" +
                "");

        // ECloudDomain eCloudDomain = EcloudClient.applyCert("2", "8",
        // "1341444141414441", "xlma", "18618192052");
        System.out.println("end date:::" + DateUtil.getTime());

        return eCloudDomain;
    }

    public static ECloudDomain unwrap() {
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "210727199409024219",
                "jjd测试",
                "15001372211");
        ECloudDomain eCloudDomain = EcloudClient.unwrap(JSONObject.toJSONString(map));
        return eCloudDomain;
    }

    public static ECloudDomain bankVerify(String realName, String mobile, String bankNumber, String idCardNumber, Integer verifyType) {

        return EcloudClient.bankVerify(realName, mobile, bankNumber, idCardNumber, verifyType);
    }

    public static ECloudDomain changeMobile() {
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "210727199409024218",
                "刘春肖",
                "15001372210");
        Random r = new Random();
        String mobilePhoneRandomNum = "1581";
        for (int i = 0; i < 7; i++) {
            mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
        }
        ECloudDomain eCloudDomain = EcloudClient.changeMobile(JSONObject.toJSONString(map), "13691270147");
        return eCloudDomain;
    }

    public static ECloudDomain getsignList() {
        ECloudDomain eCloudDomain = EcloudClient.getsignList(mobilePhone, "2");
        return eCloudDomain;
    }

    public static ECloudDomain setDefaultSign() {
        ECloudDomain eCloudDomain = EcloudClient.setDefaultSign(mobilePhone, "8283");
        return eCloudDomain;
    }

    public static ECloudDomain addSign() {
        // String mobilePhone = mobilePhone;
        String signImg = "";
        try {
            signImg = Base64Util.encodeBase64File("D://1235.png");
            System.out.println(signImg);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ECloudDomain eCloudDomain = EcloudClient.addSign("18612363313", "1", signImg);
        return eCloudDomain;
    }

    public static ECloudDomain createSign() {
        ECloudDomain eCloudDomain = EcloudClient.createSign("150013722111", "bob3", 5, 50, 1, "");
        return eCloudDomain;
    }

    public static ECloudDomain delSign() {
        ECloudDomain eCloudDomain = EcloudClient.delSign(mobilePhone, "117924");
        return eCloudDomain;
    }

    @SuppressWarnings("unused")
    public static ECloudDomain addHtmlTemplate(String pathHtml) {
        String testHtmlString = "html123123";
        StringBuffer sb = new StringBuffer("");
        try {
            File file = new File(pathHtml);
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 添加模板
        System.out.println("正在执行添加模板操作。");
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate("测试上传模板", sb.toString(), null, "[{\r\n" + 
        		"	\"positionName\": \"位置1\",\r\n" + 
        		"	\"page\": \"5\",\r\n" + 
        		"	\"x\": \"308\",\r\n" + 
        		"	\"y\": \"220\"\r\n" + 
        		"}, {\r\n" + 
        		"	\"positionName\": \"位置2\",\r\n" + 
        		"	\"page\": \"5\",\r\n" + 
        		"	\"x\": \"116\",\r\n" + 
        		"	\"y\": \"250\"\r\n" + 
        		"}]");
//        		("测试上传模板", sb.toString());
        System.out.println(eCloudDomain.getData());
        return eCloudDomain;
    }

    public static ECloudDomain addHtmlTemplate() {
        String testHtmlString = "html123123";
        // 添加模板
        System.out.println("正在执行添加模板操作。");
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate("测试01", testHtmlString);
        return eCloudDomain;
    }

    public static ECloudDomain addHtmlTemplateHaveSignPosition() {
        StringBuffer sb = new StringBuffer("");
        try {
            File file = new File("/home/bob/Desktop/personTest.html");
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = "html";
        String templateName = "jjd测试名称";
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[]{"positionName", "page", "x", "y"},
                "name1",
                2,
                77,
                59);
        Map<String, Object> signInfoMap1 = ClassUtil.toMap(new String[]{"positionName", "page", "x", "y"},
                "name2",
                1,
                106,
                72);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(signInfoMap);
        list.add(signInfoMap1);
        // 添加模板
        System.out.println("正在执行添加模板操作。");

        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate(templateName, sb.toString(), "", JSONObject.toJSONString(list));
        return eCloudDomain;
    }

    public static ECloudDomain downloadContract(String contractNum) {
        return ContractResult.downloadContract(EcloudPublicKey.instance, contractNum);
    }

    public static void downloadContractByPath(String contractNum, String targetPath) {
        ContractResult.downloadContract(EcloudPublicKey.instance, contractNum, targetPath);
    }


    public static ECloudDomain downloadContractBin(String contractNum, String localFileName) {
        return EcloudClient.downloadContractBin(contractNum, localFileName);
    }

    public static ECloudDomain editHtmlTemplate(String templateNumber) {
        if (templateNumber == null || "".equals(templateNumber)) {
            templateNumber = "d1f80e9ac2e5877f";
        }
        System.out.println("正在执行更新模板操作。模板id为：" + templateNumber);
        // 更新模板
        ECloudDomain eCloudDomain = EcloudClient.editHtmlTemplate(templateNumber,
                "测试模板编号 :templateNumber",
                "测试模板编号:" + templateNumber + ".html修改内容");
        return eCloudDomain;
    }

    public static ECloudDomain editHtmlTemplateHaveSignPosition(String templateNumber) {
        if (templateNumber == null || "".equals(templateNumber)) {
            templateNumber = "d1f80e9ac2e5877f";
        }
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[]{"positionName", "page", "x", "y"},
                "posit1",
                1,
                77,
                59);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(signInfoMap);
        System.out.println("正在执行更新模板操作。模板id为：" + templateNumber);
        // 更新模板
        ECloudDomain eCloudDomain = EcloudClient.editHtmlTemplate(templateNumber,
                "测试模板编号 :templateNumber",
                "测试模板编号:" + templateNumber + ".html修改内容",
                JSONObject.toJSONString(list));
        return eCloudDomain;
    }

    public static ECloudDomain delHtmlTemplate(String templateNumber) {
        System.out.println("正在执行删除模板操作。模板id为：" + templateNumber);
        if (templateNumber == null || "".equals(templateNumber)) {
            return new ECloudDomain("201", "请先添加模板", "");
        }
        // 删除模板
        ECloudDomain eCloudDomain = EcloudClient.delHtmlTemplate(templateNumber);
        return eCloudDomain;
    }

    public static ECloudDomain getTemplateList() {
        System.out.println("获取模板列表");
        ECloudDomain eCloudDomain = EcloudClient.getTemplateList(null, null);
        return eCloudDomain;
    }

    public static ECloudDomain getTemplateCont() {
        System.out.println("获取模板内容");
        ECloudDomain eCloudDomain = EcloudClient.getTemplateCont(templateNumber);
        return eCloudDomain;
    }

    public static ECloudDomain createContractByTemplate(String templateNumber) {
        if (templateNumber == null || "".equals(templateNumber)) {
            templateNumber = "d1f80e9ac2e5877f";
        }
        System.out.println("正在执行根据模板生成合同文档。模板id为：" + templateNumber);
        // 根据模板生成合同文档
//        String jsonString = "[{\"y\": 683, \"x\": 124, \"positionName\": \"寿春涛\", \"page\": 1}]";
        String jsonString = JSONObject.toJSONString(ClassUtil.toMap(new String[]{"enterprisePositionOne"},
                "1111"));
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplate(templateNumber,
        		"{}");
        System.out.println(eCloudDomain.getData().toString());
        return eCloudDomain;

    }

    // [
    // {
    // "name": "变量名称",
    // "nameDisplay": "变量显示名称",
    // "textAlign": "0",
    // "type": "1",
    // "minLen": "0",
    // "maxLen": "10",
    // "required": "0",
    // "underline": "0",
    // "defaultValue": "变量值",
    // "autoGenDate": "0",
    // }
    // ]
    public static ECloudDomain addHtmlTemplateVars() {
        String testHtmlString = "添加模板和变量测试html";
        // 添加模板和变量
        System.out.println("正在执行添加模板操作。");
        String templateName = "添加模板和变量测试名称";
        String vars = "";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "测试变量名称1");
        map.put("nameDisplay", "变量显示名称");
        map.put("textAlign", "0");
        map.put("type", "1");
        map.put("minLen", "0");
        map.put("maxLen", "10");
        map.put("required", "0");
        map.put("underline", "0");
        map.put("defaultValue", "0");
        map.put("autoGenDate", "0");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        vars = JSONObject.toJSONString(list);
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplateByVar("", templateName, testHtmlString, vars);
        return eCloudDomain;
    }

    public static ECloudDomain editHtmlTemplateVars() {
        String testHtmlString = "更新模板和变量测试html";
        // 更新模板和变量
        System.out.println("正在执行更新模板和变量操作。");
        String templateName = "更新模板和变量测试名称";
        String vars = "";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "测试变量名称2");
        map.put("nameDisplay", "变量显示名称2");
        map.put("textAlign", "0");
        map.put("type", "1");
        map.put("minLen", "0");
        map.put("maxLen", "10");
        map.put("required", "0");
        map.put("underline", "0");
        map.put("defaultValue", "0");
        map.put("autoGenDate", "0");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        vars = JSONObject.toJSONString(list);
        ECloudDomain eCloudDomain = EcloudClient.editHtmlTemplateByVar(templateNumber,
                templateName,
                testHtmlString,
                vars);
        return eCloudDomain;
    }

    public static ECloudDomain getTemplateVars(String templateNumber) {
        System.out.println("正在执行获得模板变量。模板id为：" + templateNumber);
        ECloudDomain eCloudDomain = EcloudClient.getTemplateVars(templateNumber);
        return eCloudDomain;

    }

    public static ECloudDomain createContractByTemplateByVar(String templateNumber) {
        System.out.println("正在执行根据模板生成合同文档。模板id为：" + templateNumber);
        String vars = "";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("detailHtmlDiv", "<!DOCTYPE html>\r\n" + 
        		"<html lang=\"en\">\r\n" + 
        		" <head>\r\n" + 
        		"  <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8”>\r\n" + 
        		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
        		"  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\r\n" + 
        		"  <title>销售货物或者提供应税劳务、服务清单</title>\r\n" + 
        		"  <style>body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, p, blockquote, th, td {margin: 0;padding: 0;}body {background: #fff;font-size: 14px;font-family: 'Arial', 'Microsoft YaHei', 'SimHei', 'SimSun', sans-serif;line-height: 24px;}.clearfix:before,.clearfix:after {content: ' ';display: inline-block;height: 0;clear: both;visibility: hidden;}.clearfix {*zoom: 1;}.warp {width: 1600px;margin:0 auto;padding-top: 20px;}h1 {font-size: 20px;}.title {text-align: center;margin-bottom: 10px;}.fl{float: left;}.fr{float: right;}.text-left {width: 400px;}.mt20 {margin-top: 5px;}.table-con {text-align: center;word-wrap:break-word; word-break:break-all;}table td {padding:5px;}.footer {margin-top: 15px;}</style>\r\n" + 
        		" </head>\r\n" + 
        		" <body>\r\n" + 
        		"  <div class=\"warp\">\r\n" + 
        		"   <h1 class=\"title\">销售货物或者提供应税劳务、服务清单</h1>\r\n" + 
        		"   <div style=\"font-size: large;\">\r\n" + 
        		"    <b>购买方名称：<span>新余迦顺商贸有限公司</span></b>\r\n" + 
        		"   </div>\r\n" + 
        		"   <div style=\"font-size: large;\">\r\n" + 
        		"    <b>销售方名称：<span>物易云通（海南）信息技术有限公司</span></b>\r\n" + 
        		"   </div>\r\n" + 
        		"   <div class=\"clearfix mt20\">\r\n" + 
        		"    <div class=\"fl text-left\" style=\"font-size: large;\">\r\n" + 
        		"     所属增值税专用发票代码：\r\n" + 
        		"     <span>4600193130</span>\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fl\" style=\"font-size: large;\">\r\n" + 
        		"     号码：\r\n" + 
        		"     <span>04371772</span>\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fr\">\r\n" + 
        		"     共 \r\n" + 
        		"     <span>2</span> 页 / 第 \r\n" + 
        		"     <span>1</span> 页\r\n" + 
        		"    </div>\r\n" + 
        		"   </div>\r\n" + 
        		"   <table class=\"table-con\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
        		"    <tbody>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <th>序号</th>\r\n" + 
        		"      <th>货物（劳务）名称</th>\r\n" + 
        		"      <th>规格型号</th>\r\n" + 
        		"      <th>单位</th>\r\n" + 
        		"      <th>数量</th>\r\n" + 
        		"      <th>单价</th>\r\n" + 
        		"      <th>金额</th>\r\n" + 
        		"      <th>税率</th>\r\n" + 
        		"      <th>税额</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>1</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BC6746</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.5</th>\r\n" + 
        		"      <th>111.05971014</th>\r\n" + 
        		"      <th>3831.55</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>344.85</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>2</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BB4045</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.36</th>\r\n" + 
        		"      <th>110.09720605</th>\r\n" + 
        		"      <th>3782.93</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>340.47</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>3</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HQ2302</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.5</th>\r\n" + 
        		"      <th>110.49623188</th>\r\n" + 
        		"      <th>3812.11</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>343.09</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>4</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BG1029</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.84</th>\r\n" + 
        		"      <th>110.25516648</th>\r\n" + 
        		"      <th>3841.28</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>345.72</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>5</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HQ6891</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.72</th>\r\n" + 
        		"      <th>110.63623272</th>\r\n" + 
        		"      <th>3841.28</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>345.72</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>6</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BM8145</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.5</th>\r\n" + 
        		"      <th>110.21420290</th>\r\n" + 
        		"      <th>3802.38</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>342.22</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>7</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HS8327</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.84</th>\r\n" + 
        		"      <th>110.81343284</th>\r\n" + 
        		"      <th>3860.73</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>347.47</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>8</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HM5275</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.94</th>\r\n" + 
        		"      <th>110.21780195</th>\r\n" + 
        		"      <th>3851.00</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>346.60</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>9</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HS9306</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>35.08</th>\r\n" + 
        		"      <th>110.33238312</th>\r\n" + 
        		"      <th>3870.45</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>348.35</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>10</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HE9460</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>33.64</th>\r\n" + 
        		"      <th>110.14090369</th>\r\n" + 
        		"      <th>3705.13</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>333.47</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>11</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BB4087</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>33.48</th>\r\n" + 
        		"      <th>110.37694146</th>\r\n" + 
        		"      <th>3695.41</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>332.59</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>12</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>冀A928DS</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.04</th>\r\n" + 
        		"      <th>110.84665100</th>\r\n" + 
        		"      <th>3773.21</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>339.59</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>13</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>冀FM1277</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.82</th>\r\n" + 
        		"      <th>110.03905801</th>\r\n" + 
        		"      <th>3831.55</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>344.85</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>14</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>冀FM1828</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.4</th>\r\n" + 
        		"      <th>110.53459302</th>\r\n" + 
        		"      <th>3802.38</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>342.22</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>15</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>冀FP6058</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.78</th>\r\n" + 
        		"      <th>111.28407131</th>\r\n" + 
        		"      <th>3870.45</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>348.35</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>16</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋H81818</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.68</th>\r\n" + 
        		"      <th>110.76384083</th>\r\n" + 
        		"      <th>3841.29</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>345.71</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>17</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HZ2880</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.66</th>\r\n" + 
        		"      <th>110.26658973</th>\r\n" + 
        		"      <th>3821.84</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>343.96</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>18</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HE0772</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.72</th>\r\n" + 
        		"      <th>111.75662442</th>\r\n" + 
        		"      <th>3880.19</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>349.21</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>19</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BL5227</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.08</th>\r\n" + 
        		"      <th>111.57247653</th>\r\n" + 
        		"      <th>3802.39</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>342.21</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>20</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BY1240</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>35</th>\r\n" + 
        		"      <th>111.69600000</th>\r\n" + 
        		"      <th>3909.36</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>351.84</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>21</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BN2765</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34</th>\r\n" + 
        		"      <th>111.83500000</th>\r\n" + 
        		"      <th>3802.39</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>342.21</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>22</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BT0455</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.26</th>\r\n" + 
        		"      <th>111.27028605</th>\r\n" + 
        		"      <th>3812.12</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>343.08</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>23</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HZ0452</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>35.14</th>\r\n" + 
        		"      <th>109.86738759</th>\r\n" + 
        		"      <th>3860.74</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>347.46</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>24</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HC1793</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.76</th>\r\n" + 
        		"      <th>111.34810127</th>\r\n" + 
        		"      <th>3870.46</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>348.34</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>25</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BG3282</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>35.18</th>\r\n" + 
        		"      <th>110.84820921</th>\r\n" + 
        		"      <th>3899.64</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>350.96</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>小计</td>\r\n" + 
        		"      <td colspan=\"5\"></td>\r\n" + 
        		"      <td>95672.26</td>\r\n" + 
        		"      <td></td>\r\n" + 
        		"      <td>8610.54</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>合计</td>\r\n" + 
        		"      <td colspan=\"5\"></td>\r\n" + 
        		"      <td>95672.26</td>\r\n" + 
        		"      <td></td>\r\n" + 
        		"      <td>8610.54</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td rowspan=\"2\">备注</td>\r\n" + 
        		"      <td colspan=\"8\" align=\"left\">收货人：青岛奥山海事技术服务有限公司起运地：后背到达地：献县龙腾煤场车种车号：重型半挂车冀FQ3849晋BC6746晋BB4045等33车车船吨位：汽运34.44吨<br />&nbsp;</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"    </tbody>\r\n" + 
        		"   </table>\r\n" + 
        		"   <div class=\"footer\">\r\n" + 
        		"    <div class=\"fl\">\r\n" + 
        		"     销售方（章）\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fr\">\r\n" + 
        		"     日期：\r\n" + 
        		"     <span>2020-07-15</span>\r\n" + 
        		"    </div>\r\n" + 
        		"   </div>\r\n" + 
        		"  </div>\r\n" + 
        		"  <div class=\"warp\">\r\n" + 
        		"   <h1 class=\"title\">销售货物或者提供应税劳务、服务清单</h1>\r\n" + 
        		"   <div style=\"font-size: large;\">\r\n" + 
        		"    <b>购买方名称：<span>新余迦顺商贸有限公司</span></b>\r\n" + 
        		"   </div>\r\n" + 
        		"   <div style=\"font-size: large;\">\r\n" + 
        		"    <b>销售方名称：<span>物易云通（海南）信息技术有限公司</span></b>\r\n" + 
        		"   </div>\r\n" + 
        		"   <div class=\"clearfix mt20\">\r\n" + 
        		"    <div class=\"fl text-left\" style=\"font-size: large;\">\r\n" + 
        		"     所属增值税专用发票代码：\r\n" + 
        		"     <span>4600193130</span>\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fl\" style=\"font-size: large;\">\r\n" + 
        		"     号码：\r\n" + 
        		"     <span>04371772</span>\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fr\">\r\n" + 
        		"     共 \r\n" + 
        		"     <span>2</span> 页 / 第 \r\n" + 
        		"     <span>2</span> 页\r\n" + 
        		"    </div>\r\n" + 
        		"   </div>\r\n" + 
        		"   <table class=\"table-con\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
        		"    <tbody>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <th>序号</th>\r\n" + 
        		"      <th>货物（劳务）名称</th>\r\n" + 
        		"      <th>规格型号</th>\r\n" + 
        		"      <th>单位</th>\r\n" + 
        		"      <th>数量</th>\r\n" + 
        		"      <th>单价</th>\r\n" + 
        		"      <th>金额</th>\r\n" + 
        		"      <th>税率</th>\r\n" + 
        		"      <th>税额</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>26</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HS9306</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>35.06</th>\r\n" + 
        		"      <th>110.95008557</th>\r\n" + 
        		"      <th>3889.91</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>350.09</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>27</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HS8327</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.94</th>\r\n" + 
        		"      <th>111.60961649</th>\r\n" + 
        		"      <th>3899.64</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>350.96</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>28</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>冀FQ3849</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.44</th>\r\n" + 
        		"      <th>111.81794425</th>\r\n" + 
        		"      <th>3851.01</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>346.59</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>29</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BG1029</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.94</th>\r\n" + 
        		"      <th>111.05294791</th>\r\n" + 
        		"      <th>3880.19</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>349.21</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>30</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HQ2302</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.8</th>\r\n" + 
        		"      <th>110.38189655</th>\r\n" + 
        		"      <th>3841.29</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>345.71</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>31</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋HQ6891</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.86</th>\r\n" + 
        		"      <th>111.58663224</th>\r\n" + 
        		"      <th>3889.91</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>350.09</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>32</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BB4045</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.74</th>\r\n" + 
        		"      <th>111.13241220</th>\r\n" + 
        		"      <th>3860.74</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>347.46</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>33</td>\r\n" + 
        		"      <th>运输服务*运费</th>\r\n" + 
        		"      <th>晋BC6746</th>\r\n" + 
        		"      <th>吨</th>\r\n" + 
        		"      <th>34.7</th>\r\n" + 
        		"      <th>110.98011527</th>\r\n" + 
        		"      <th>3851.01</th>\r\n" + 
        		"      <th>9%</th>\r\n" + 
        		"      <th>346.59</th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>&nbsp;</td>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"      <th></th>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>小计</td>\r\n" + 
        		"      <td colspan=\"5\"></td>\r\n" + 
        		"      <td>30963.70</td>\r\n" + 
        		"      <td></td>\r\n" + 
        		"      <td>2786.70</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td>合计</td>\r\n" + 
        		"      <td colspan=\"5\"></td>\r\n" + 
        		"      <td>126635.96</td>\r\n" + 
        		"      <td></td>\r\n" + 
        		"      <td>11397.24</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"     <tr>\r\n" + 
        		"      <td rowspan=\"2\">备注</td>\r\n" + 
        		"      <td colspan=\"8\" align=\"left\">收货人：青岛奥山海事技术服务有限公司起运地：后背到达地：献县龙腾煤场车种车号：重型半挂车冀FQ3849晋BC6746晋BB4045等33车车船吨位：汽运34.44吨<br />&nbsp;</td>\r\n" + 
        		"     </tr>\r\n" + 
        		"    </tbody>\r\n" + 
        		"   </table>\r\n" + 
        		"   <div class=\"footer\">\r\n" + 
        		"    <div class=\"fl\">\r\n" + 
        		"     销售方（章）\r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"fr\">\r\n" + 
        		"     日期：\r\n" + 
        		"     <span>2020-07-15</span>\r\n" + 
        		"    </div>\r\n" + 
        		"   </div>\r\n" + 
        		"  </div>\r\n" + 
        		" </body>\r\n" + 
        		"</html>");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        vars = JSONObject.toJSONString(list);
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplateByVar(templateNumber, vars);
        return eCloudDomain;

    }

    public static ECloudDomain getContractList() {
        ECloudDomain eCloudDomain = EcloudClient.getContractList(mobilePhone, "1", "2");
        return eCloudDomain;

    }
    
    
    public static ECloudDomain getContractImgs() {
        ECloudDomain eCloudDomain = EcloudClient.getContractImgs(mobilePhone, contractNum);
        if(eCloudDomain!=null) {
	    	 System.out.println(eCloudDomain.getData());
	    	JSONObject jo1 = JSONObject.parseObject(JSONObject.toJSONString(eCloudDomain.getData()));
	    	List<String> list = (List<String>) JSONArray.parseArray(jo1.getString("contractImgs"),String.class);
	    	for (int i = 0; i <list.size(); i++) {
				GenerateImage(list.get(i), i+".jpg", "D://");
				
			}
	     }
       return null ;
    }

    public static ECloudDomain getContractDetail() {
        ECloudDomain eCloudDomain = EcloudClient.getContractDetail(mobilePhone, contractNum);
        if(eCloudDomain!=null) {
	    	 System.out.println(eCloudDomain.getData());
	    	JSONObject jo1 = JSONObject.parseObject(JSONObject.toJSONString(eCloudDomain.getData()));
	    	List<String> list = (List<String>) JSONArray.parseArray(jo1.getString("contractImgs"),String.class);
	    	for (int i = 0; i <list.size(); i++) {
				GenerateImage(list.get(i), i+".jpg", "D://");
				
			}
	     }
       return null ;
    }

    public static ECloudDomain autoSign() {
//        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
////        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                2,
                8,
                "110105198710503642",
                "北京公司1",
                "13439575811");
////        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
////                2,
////                6,
////                "35522934-9",
////                "CX测试",
////                "15001372210");
//        Map<String, Object> map2 = ClassUtil.toMap(new String[]{"positionName", "signId", "signType"},
//                "name2", "35274", "1");
        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(map),
                "ABC202007080000002",
                1,
               "{\"positionName\": \"contractNum\",\"signId\": \"170287\",\"signType\": \"2\"}");
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        return eCloudDomain;

    }
    
    
    public static ECloudDomain autoSignForString() {
//      System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
////      // 自动签署合同
      Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
              2,
              8,
              "91110108MA0043365M",
              "北京票通信息技术有限公司",
              "15601362486");
      ECloudDomain eCloudDomain = EcloudClient.autoSignForString(JSONObject.toJSONString(map), "89B30557E237CC79", 1, "{\"signId\":\"166242\",\"signType\":\"2\"}");
      return eCloudDomain;

  }
    

    public static ECloudDomain autoSignHaveSignInfo() {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "110105198710155463",
                "手机宝宝",
                "15817385106");
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[]{"signType", "signId", "positionName"},
                1,
                732,
                "name2");
        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(map),
                contractNum,
                0,
                JSONObject.toJSONString(signInfoMap));
        return eCloudDomain;

    }

    public static ECloudDomain launchContract() {
        System.out.println("正在执行发起合同。合同id为：" + contractNum);
        String keyWord = "test";
        String contractName = "C1346AFDB7D37CAE";
        String[] toMobile = new String[]{"13614066822", "15001372210"};// 676,675
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", "1");
        map.put("x", "200");
        map.put("y", "200");
//        map.put("signId", "1386");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        String position = JSONObject.toJSONString(list);

        ECloudDomain eCloudDomain = EcloudClient.launchContract(keyWord,
                contractName,
                33,
                mobilePhone,
                toMobile,
                position,
                contractNum);
        return eCloudDomain;

    }

    /**
     * 发起合同自动签或网签
     *
     * @return
     */
    public static ECloudDomain launchContractAutoSignAndSendSms() {
        System.out.println("正在执行发起有短信通知的合同。合同id为：" + contractNum);
        String keyWord = "营业执照号";// 1、合同信息
        String contractName = "测试合同名称0521";
        int days = 30;
        // String[] toMobile = new String[] {"13261572372"};//
        // 676,675//2、发送给谁，签署人
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("page", "1");// 3、签章信息
        map1.put("x", "200");
        map1.put("y", "200");
        map1.put("signType", "1");// 自动签签名类型
        map1.put("mobilePhone", "15001372211");// 第一个为发起方手机号
        String[] signerInfos = new String[2];
        signerInfos[0] = JSONObject.toJSONString(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("page", "2");// 3、签章信息
//        map2.put("x", "200");
//        map2.put("y", "200");
//        map2.put("signType", "1");// 自动签签名类型
        map2.put("mobilePhone", "15001372210");// 第2个签署方为自动签名
        signerInfos[1] = JSONObject.toJSONString(map2);

//        Map<String, Object> map3 = new HashMap<String, Object>();
//        map3.put("page", "3");// 3、签章信息
//        map3.put("x", "250");
//        map3.put("y", "250");
//        map3.put("signType", "1");// 自动签签名类型，短信签则无需填写x、y、signType
//        map3.put("mobilePhone", "13011111315");// 第3个签署方短信签
//        signerInfos[2] = JSONObject.toJSONString(map3);

        ECloudDomain eCloudDomain = EcloudClient.launchContractAutoSignAndSendSms(keyWord,
                contractName,
                days,
                contractNum,
                signerInfos);
        System.out.println(eCloudDomain.getData());
        return eCloudDomain;
    }

    public static ECloudDomain launchContractSendSms() {
        System.out.println("正在执行发起有短信通知的合同。合同id为：" + contractNum);
        String keyWord = "货物运输协议";// 1、合同信息
        String contractName = "jjd测试名称";
        String[] toMobile = new String[]{"15001372210"};// 676,675//2、发送给谁，签署人
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", "1");// 3、签章信息
        map.put("x", "200");
        map.put("y", "200");
        map.put("signId", "1773");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        String position = JSONObject.toJSONString(list);

        ECloudDomain eCloudDomain = EcloudClient.launchContractSendSms(keyWord,
                contractName,
                33,
                mobilePhone,
                toMobile,
                position,
                contractNum);
        return eCloudDomain;

    }

    public static ECloudDomain sealContract() {
        System.out.println("正在执行发起合同。合同id为：" + contractNum);
        String contractName = "测试合同名称";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", "1");
        map.put("x", "150");
        map.put("y", "100");
        map.put("signId", "119960");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        String position = JSONObject.toJSONString(list);

        ECloudDomain eCloudDomain = EcloudClient.sealContract(contractNum, "15001372211", position);
        return eCloudDomain;

    }

    public static ECloudDomain sealByKeyword() {
        System.out.println("正在执行发起合同。合同编号为：" + contractNum);
        Map<String, Object> signerInfomap = new HashMap<String, Object>();
        signerInfomap.put("type", "1");
        signerInfomap.put("cardType", "0");
        signerInfomap.put("idCardNum", "37078219930111478X");
        signerInfomap.put("name", "李菲");
        signerInfomap.put("mobilePhone", "18888888887");
        // "type":"1", //类型 1：个人 、2：企业
        // "cardType":"0", // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商
        // 登记证、5：税务登记证、6：组织机构代码、7：其他证件
        // idCardNum":"", // 证件号码
        // "name":"", //企业或者个人真实名称
        // "mobilePhone":"" //企业或者个人联系手机号
        String signerInfo = JSONObject.toJSONString(signerInfomap);

        Map<String, Object> ruleInfomap = new HashMap<String, Object>();
        ruleInfomap.put("signType", "1");
        ruleInfomap.put("signId", "1906755");
        ruleInfomap.put("keyWord","乙方：");
        ruleInfomap.put("beginPage", "1");
        ruleInfomap.put("endPage", "-1");
        ruleInfomap.put("orderBy", "ASC");
        ruleInfomap.put("sealNum", "1");
        ruleInfomap.put("x", "0");
        ruleInfomap.put("y", "0");
        // "signType":"1", //类型 签名类型，1签名 2印章
        // "signId":"0", //签章或者签字ID，如果不指定(不指定则干掉此参数)，则用户默认设置
        // "keyWord":"甲方" //关键字
        // "beginPage": 1, // 关键字查找开始页，大于等于1
        // "endPage": -1, // 关键字查找结束页，大于等于-3小于等于beginPage，-1、-2、-3
        // 分别代表倒数第一、第二、第三页
        // "orderBy": "DESC", // 排序，正序ASC，倒序DESC
        // "sealNum": 1, // 盖章个数，大于等于1
        // "x": 0, // 盖章位置偏移，负数向左移动，正数向右移动
        // "y": 0 // 盖章位置偏移，负数向下移动，正数向上移动
        String ruleInfo = JSONObject.toJSONString(ruleInfomap);
        ECloudDomain eCloudDomain = EcloudClient.sealByKeyword("B76B7E3ED6A9CBC3", signerInfo, 0, ruleInfo);
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        return eCloudDomain;
    }
    
    
    
    public static ECloudDomain sealByKeywordForImage() {
        System.out.println("正在执行发起合同。合同编号为：" + contractNum);
        Map<String, Object> signerInfomap = new HashMap<String, Object>();
        signerInfomap.put("type", "1");
        signerInfomap.put("cardType", "0");
        signerInfomap.put("idCardNum", "37078219930111478X");
        signerInfomap.put("name", "李菲");
        signerInfomap.put("mobilePhone", "18888888887");
        // "type":"1", //类型 1：个人 、2：企业
        // "cardType":"0", // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商
        // 登记证、5：税务登记证、6：组织机构代码、7：其他证件
        // idCardNum":"", // 证件号码
        // "name":"", //企业或者个人真实名称
        // "mobilePhone":"" //企业或者个人联系手机号
        String signerInfo = JSONObject.toJSONString(signerInfomap);

        Map<String, Object> ruleInfomap = new HashMap<String, Object>();
        ruleInfomap.put("signType", "1");
        ruleInfomap.put("signId", "1906755");
        ruleInfomap.put("keyWord","乙方：");
        ruleInfomap.put("beginPage", "1");
        ruleInfomap.put("endPage", "-1");
        ruleInfomap.put("orderBy", "DESC");
        ruleInfomap.put("sealNum", "1");
        ruleInfomap.put("x", "0");
        ruleInfomap.put("y", "0");
        // "signType":"1", //类型 签名类型，1签名 2印章
        // "signId":"0", //签章或者签字ID，如果不指定(不指定则干掉此参数)，则用户默认设置
        // "keyWord":"甲方" //关键字
        // "beginPage": 1, // 关键字查找开始页，大于等于1
        // "endPage": -1, // 关键字查找结束页，大于等于-3小于等于beginPage，-1、-2、-3
        // 分别代表倒数第一、第二、第三页
        // "orderBy": "DESC", // 排序，正序ASC，倒序DESC
        // "sealNum": 1, // 盖章个数，大于等于1
        // "x": 0, // 盖章位置偏移，负数向左移动，正数向右移动
        // "y": 0 // 盖章位置偏移，负数向下移动，正数向上移动
        String ruleInfo = JSONObject.toJSONString(ruleInfomap);
        
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> ruleInfoImagemap = new HashMap<String, Object>();
        ruleInfoImagemap.put("signType", "0");
        ruleInfoImagemap.put("positionName", "35162");
        ruleInfoImagemap.put("keyWord","主 题 词");
        ruleInfoImagemap.put("beginPage", "1");
        ruleInfoImagemap.put("endPage", "-1");
        ruleInfoImagemap.put("orderBy", "ASC");
        ruleInfoImagemap.put("sealNum", "50");
        ruleInfoImagemap.put("x", "0");
        ruleInfoImagemap.put("y", "0");
        ruleInfoImagemap.put("fontSize", "16");
        ruleInfoImagemap.put("style", "0");
        
        list.add(ruleInfoImagemap);
        
//        Map<String, Object> ruleInfoImagemap1 = new HashMap<String, Object>();
//        ruleInfoImagemap1.put("signType", "1");
//        ruleInfoImagemap1.put("positionName", "人民万岁");
//        ruleInfoImagemap1.put("keyWord","主 题 词");
//        ruleInfoImagemap1.put("beginPage", "16");
//        ruleInfoImagemap1.put("endPage", "-1");
//        ruleInfoImagemap1.put("orderBy", "ASC");
//        ruleInfoImagemap1.put("sealNum", "15");
//        ruleInfoImagemap1.put("x", "348");
//        ruleInfoImagemap1.put("y", "462");
//        list.add(ruleInfoImagemap1);
        
        String signImageInfo = JSONObject.toJSONString(list);
        
        ECloudDomain eCloudDomain = EcloudClient.sealByKeywordForImage(contractNum,signerInfo, 1, ruleInfo, signImageInfo);
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        return eCloudDomain;
    }
    

    public static ECloudDomain sendSms() {
        System.out.println("正在执行发送验证码。合同id为：" + contractNum);
        String contractName = "测试合同名称";

        ECloudDomain eCloudDomain = EcloudClient.sendSms(contractNum, mobilePhone, "");
        return eCloudDomain;

    }

    public static ECloudDomain authorizeSign(String dynamicCode) {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "210727199409024218",
                "jjd测试",
                "15001372210");
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[]{"signType", "signId", "positionName"},
                1,
                1773,
                "posit1");
        ECloudDomain eCloudDomain = EcloudClient.authorizeSign(JSONObject.toJSONString(map),
                contractNum,
                0,
                JSONObject.toJSONString(signInfoMap),
                dynamicCode);
        return eCloudDomain;

    }

    public static ECloudDomain getCertInfo() {
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum"},
                1,
                0,
                "210727199409024218");
        ECloudDomain eCloudDomain = EcloudClient.getCertInfo(JSONObject.toJSONString(map));
        return eCloudDomain;
    }

    public static ECloudDomain renewCert() {
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum"},
                1,
                0,
                "110105198710767166");
        ECloudDomain eCloudDomain = EcloudClient.renewCert(JSONObject.toJSONString(map));
        return eCloudDomain;
    }

    public static ECloudDomain cancelContract() {
        ECloudDomain eCloudDomain = EcloudClient.cancelContract(contractNum, mobilePhone);
        return eCloudDomain;
    }

    public static ECloudDomain verify() {
        File file = new File("d://003.pdf");
        ECloudDomain eCloudDomain = EcloudClient.verify(file);
        return eCloudDomain;
    }

    public static ECloudDomain createSeal() {
        ECloudDomain eCloudDomain = EcloudClient.createSeal("18888888838", "CX测试", "合同专属", "");
        return eCloudDomain;
    }

    public static ECloudDomain autoSignByPoistion() {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "110101199003079374",
                "余伟",
                "12345614752");

        Map<String, Object> signInfoMap1 = ClassUtil.toMap(new String[]{"positionName","page", "x", "y", "signId"},
                "史跃增",
        		1,
                368,
                269,
                35376);
//        Map<String, Object> signInfoMap2 = ClassUtil.toMap(new String[]{"positionName","page", "x", "y", "signId"},
//        		"刘博",
//        		2,
//                101,
//                201,
//                35162);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(signInfoMap1);
//        list.add(signInfoMap2);

        ECloudDomain eCloudDomain = EcloudClient.autoSignByPoistion(JSONObject.toJSONString(map),
                contractNum,
                0,
                JSONObject.toJSONString(list));
        return eCloudDomain;

    }

    public static ECloudDomain autoSignByPoistionForMobile12() {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(new String[]{"type", "cardType", "idCardNum", "name", "mobilePhone"},
                1,
                0,
                "210727199409024218",
                "bob3",
                "150013722111");

        Map<String, Object> signInfoMap1 = ClassUtil.toMap(new String[]{"page", "x", "y", "signId"},
                1,
                100,
                100,
                128794);
        Map<String, Object> signInfoMap2 = ClassUtil.toMap(new String[]{"page", "x", "y", "signId"},
                2,
                300,
                300,
                732);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(signInfoMap1);
//            list.add(signInfoMap2);

        ECloudDomain eCloudDomain = EcloudClient.autoSignByPoistionForMobile12(JSONObject.toJSONString(map),
                contractNum,
                0,
                JSONObject.toJSONString(list));
        return eCloudDomain;

    }

    public static ECloudDomain createContract() {

        File file = new File("D://测试.pdf");
        ECloudDomain eCloudDomain = EcloudClient.createContract(null, mobilePhone, file);
        return eCloudDomain;
    }
    
    public static ECloudDomain createInvalidContract() {

        File file = new File("D://2020_PDF.pdf");
        ECloudDomain eCloudDomain = EcloudClient.createInvalidContract(file);
        return eCloudDomain;
    }

//    public static ECloudDomain downloadCont() {
////        ECloudDomain eCloudDomain = EcloudClient.downloadCont("fda6bc82996fd19f", mobilePhone, "d://222.pdf");
//        return eCloudDomain;
//    }

    public static ECloudDomain idCard() {
        File file1 = new File("d://cxa.jpg");
        File file2 = new File("d://cxb.jpg");
        ECloudDomain eCloudDomain = EcloudClient.idCard(file1, file2);
        return eCloudDomain;
    }


    public static ECloudDomain multipleSeal() {
        System.out.println("正在执行发起合同。合同编号为：" + contractNum);
        Map<String, Object> signerInfomap = new HashMap<String, Object>();
        signerInfomap.put("type", "2");
        signerInfomap.put("cardType", "0");
        signerInfomap.put("idCardNum", "210727199409024218");
        signerInfomap.put("name", "jjd测试");
        signerInfomap.put("mobilePhone", mobilePhone);
        // "type":"1", //类型 1：个人 、2：企业
        // "cardType":"0", // 证件类型 0：身份证 1：军官证 ,2：护照、3：驾驶证、4：工商
        // 登记证、5：税务登记证、6：组织机构代码、7：其他证件
        // idCardNum":"", // 证件号码
        // "name":"", //企业或者个人真实名称
        // "mobilePhone":"" //企业或者个人联系手机号
        String signerInfo = JSONObject.toJSONString(signerInfomap);

        Map<String, Object> ruleInfomap = new HashMap<String, Object>();
        ruleInfomap.put("signType", "2");
        ruleInfomap.put("signId", "35162");
        ruleInfomap.put("beginPage", "1");
        ruleInfomap.put("endPage", "-1");
        ruleInfomap.put("firstSeal", "50");
        ruleInfomap.put("straddleMode", "R");

        /**
         * 测试骑缝章
         */
//        ruleInfomap.put("sealType", 1);
//        ruleInfomap.put("x", "0");
//        ruleInfomap.put("y", "25000");

        /**
         * 测试多页签章
         */
        ruleInfomap.put("sealType", 1);
        ruleInfomap.put("x", "270");
        ruleInfomap.put("y", "150");

        // "signType":"1", //类型 签名类型，1签名 2印章
        // "signId":"0", //签章或者签字ID，如果不指定(不指定则干掉此参数)，则用户默认设置
        // "keyWord":"甲方" //关键字
        // "beginPage": 1, // 关键字查找开始页，大于等于1
        // "endPage": -1, // 关键字查找结束页，大于等于-3小于等于beginPage，-1、-2、-3
        // 分别代表倒数第一、第二、第三页
        // "orderBy": "DESC", // 排序，正序ASC，倒序DESC
        // "sealNum": 1, // 盖章个数，大于等于1
        // "x": 0, // 盖章位置偏移，负数向左移动，正数向右移动
        // "y": 0 // 盖章位置偏移，负数向下移动，正数向上移动
        String ruleInfo = JSONObject.toJSONString(ruleInfomap);
        ECloudDomain eCloudDomain = EcloudClient.multipleSeal(contractNum, signerInfo, 1, ruleInfo);
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        return eCloudDomain;
    }
    
    public static boolean GenerateImage(String imgStr,String photoname,String imagePath) {
        //对字节数组字符串进行Base64解码并生成图片
        //图像数据为空
        if (imgStr == null)
            return false;


        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //System.currentTimeMillis()
            //新生成的图片
            String imgFilePath = imagePath+photoname;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    
    
    public static void writeFile(String path, byte[] bytes) {
    	
        int n = 1024;
        FileOutputStream os = null;
        try {
            // 创建文件输出流对象
            File file = new File(path);
            os = new FileOutputStream(file);
            // 写入输出流
            int length = bytes.length;
            int start = 0;
            while (length > start + n) {
                os.write(bytes, start, n);
                start = start + n;
            }
            if (length != start + n) {
                n = length - start;
                os.write(bytes, start, n);
            }
        } catch (IOException e) {
        } finally {
            // 关闭输出流
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
    
    
//    public static List<String> pdf2NewImg(String path) throws IOException {
//		File file = new File(path);
//		List<String> base64Imgs = new ArrayList<>();
//		PDDocument doc = null;
//		try {
//			doc = PDDocument.load(file);
//			PDFRenderer renderer = new PDFRenderer(doc);
//			int pageCount = doc.getNumberOfPages();
//			for (int i = 0; i < pageCount; i++) {
//				BufferedImage image = renderer.renderImage(i,5f);
//				ByteArrayOutputStream os = new ByteArrayOutputStream();
//				ImageIO.write(image, "png", new File("D:\\"+(i+1)+".png"));
//				base64Imgs.add(Base64.getEncoder().encodeToString(os.toByteArray()));
//				os.close();
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
////			log.error("pdf生成图片base64错误：" + e + path);
//		} finally {
//			if (doc != null) {
//				doc.close();
//			}
//		}
//		return base64Imgs;
//	}
    
    

}
