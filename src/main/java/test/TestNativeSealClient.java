//package test;
//
//import com.agile.ecloud.sdk.bean.ECloudDomain;
//import com.agile.ecloud.sdk.bean.NativeSealPublicKey;
//import com.agile.ecloud.sdk.common.RuleInfo;
//import com.agile.ecloud.sdk.common.SignParam;
//import com.agile.ecloud.sdk.http.NativeSealClient;
//import org.apache.commons.io.FileUtils;
//import sun.misc.BASE64Encoder;
//
//import java.io.File;
//import java.io.IOException;
//
//public class TestNativeSealClient {
//
//    public static void main(String[] args) {
////        String url = "http://10.33.107.16:6100";
//        String url = "http://lj.ecloudsign.com/native";
//        String appKey = "natived5b541e0zpxznp1"; //如需此参数，请联系公司工作人员
//        String secrept = "a96c58ff47d5e41d771dc375bcac108a";//如需此参数，请联系公司工作人员
//        String scope = "api";
//        NativeSealPublicKey.init(appKey, secrept, "1.0", scope, url);
//
//        // 个人签署测试-本地上传文件
////		personSign();
//
//        personSignByte();
//
//        // 个人签署测试-使用S3文件
////		personAWSSign();
//
//        // 证书列表
////         ECloudDomain result = certList();
//
//        // 证书申请
////         ECloudDomain result = certApply();
//
//        // 证书申请（File）
////         ECloudDomain result = certApplyFile();
//
//        // 证书查询
////         ECloudDomain result = certSearch();
//
//        // 证书详情
////         ECloudDomain result = certDetail();
//
//        // 更新证书（证书的审核信息）
////         ECloudDomain result = certUpdate();
//
//        // 印章列表
////         ECloudDomain result = sealList();
//
//        // 添加印章
////         ECloudDomain result = sealAdd();
//
//        // 删除印章
////         ECloudDomain result = sealDelete();
//
//        // 修改印章
////         ECloudDomain result = sealUpdate();
//
//        // 印章详情
////         ECloudDomain result = sealDetail();
//
//        // 印章查询
////         ECloudDomain result = sealSearch();
//
//        // 规则列表
////         ECloudDomain result = ruleList();
//
//        // 规则查询
////         ECloudDomain result = ruleSearch();
//
//        // 规则详情
////         ECloudDomain result = ruleDetail();
//
//        // 规则添加
////         ECloudDomain result = ruleAdd();
//
//        // 修改规则
////         ECloudDomain result = ruleUpdate();
//
//        // 删除规则
////         ECloudDomain result = ruleDelete();
//
//        // 亚马逊云签章
////         ECloudDomain result = contractAWSSign();
//
////         System.out.println(result.toJson());
//
//        // 本地文件签章
////         contractSign();
//
//    }
//
//    public static ECloudDomain certList() {
//        int currentPage = 1;
//        int pageSize = 20;
//        ECloudDomain eCloudDomain = NativeSealClient.certList(currentPage, pageSize);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain certApply() {
//        String name = "测试证书";
//        String unitName = "测试企业";
//        String unitCode = "89890809";
//        String contacts = "张三";
//        String telephone = "15010408507";
//        String idCardNo = "411722197508214014";
//        String idCardImg = "";
//        String bizLicense = "";
//        String authorization = "";
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            idCardImg = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\1.png")));
//            bizLicense = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\2.png")));
//            authorization = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\3.png")));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ECloudDomain eCloudDomain = NativeSealClient.certApply(name, unitName, unitCode,
//                contacts, telephone, idCardNo, idCardImg, bizLicense, authorization);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain certApplyFile() {
//        String name = "测试证书";
//        String unitName = "测试企业";
//        String unitCode = "89890809";
//        String contacts = "张三";
//        String telephone = "15010408507";
//        String idCardNo = "411722197508214014";
//        File idCardImg = new File("D:\\1.png");
//        File bizLicense = new File("D:\\2.png");
//        File authorization = new File("D:\\3.png");
//        ECloudDomain eCloudDomain = NativeSealClient.certApplyFile(name, unitName, unitCode,
//                contacts, telephone, idCardNo, idCardImg, bizLicense, authorization);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain certSearch() {
//        int currentPage = 1;
//        int pageSize = 20;
//        String name = "测试";
//        String unitName = "";
//        String validityBegin = "2018-01-01";
//        String validityEnd = "2017-05-01";
//        String status = "0"; // 0通过 1待审核 2未通过 ，不填全部
//        ECloudDomain eCloudDomain = NativeSealClient.certSearch(currentPage, pageSize, name, unitName, validityBegin, validityEnd, status);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain certDetail() {
//        int id = 1;
//        ECloudDomain eCloudDomain = NativeSealClient.certDetail(id);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain certUpdate() {
//        int id = 1;
//        ECloudDomain eCloudDomain = NativeSealClient.certUpdate(id);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealList() {
//        int currentPage = 1;
//        int pageSize = 20;
//        ECloudDomain eCloudDomain = NativeSealClient.sealList(currentPage, pageSize);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealAdd() {
//        String name = "测试印章";
//        String dept = "A部门";
//        String sealImgBase64 = "";
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            sealImgBase64 = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\4.png")));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ECloudDomain eCloudDomain = NativeSealClient.sealAdd(name, dept, sealImgBase64);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealDelete() {
//        int id = 1;
//        ECloudDomain eCloudDomain = NativeSealClient.sealDelete(id);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealUpdate() {
//        int id = 1;
//        String name = "测试印章";
//        String dept = "A部门";
//        String sealImgBase64 = "";
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            sealImgBase64 = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\4.png")));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ECloudDomain eCloudDomain = NativeSealClient.sealUpdate(id, name, dept, sealImgBase64);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealDetail() {
//        int id = 1;
//        ECloudDomain eCloudDomain = NativeSealClient.sealDetail(id);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain sealSearch() {
//        int currentPage = 1;
//        int pageSize = 20;
//        String name = "测试";
//        String startTime = "2017-01-01";
//        String endTime = "2017-04-30";
//        ECloudDomain eCloudDomain = NativeSealClient.sealSearch(currentPage, pageSize, name, startTime, endTime);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleList() {
//        int currentPage = 1;
//        int pageSize = 20;
//        ECloudDomain eCloudDomain = NativeSealClient.ruleList(currentPage, pageSize);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleSearch() {
//        int currentPage = 1;
//        int pageSize = 20;
//        String code = "1001";
//        String beginDate = "";
//        String endDate = "";
//        ECloudDomain eCloudDomain = NativeSealClient.ruleSearch(currentPage, pageSize, code, beginDate, endDate);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleDetail() {
//        int id = 1;
//        ECloudDomain eCloudDomain = NativeSealClient.ruleDetail(id);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleAdd() {
//        String name = "测试规则";
//        int sealId = 1;
//        int certId = 1;
//        int type = 1;
//        int page = 9;
//        int x = 25000;
//        int y = 25400;
//        int beginPage = 0;
//        int endPage = 0;
//        String searchOrder = "";
//        int signNumber = 1;
//        String keyWord = "";
//        String straddleMode = "";
//        float firstSeal = 50f;
//
//        ECloudDomain eCloudDomain = NativeSealClient.ruleAdd(name, sealId, certId, type,
//                page, x, y, beginPage, endPage, searchOrder, signNumber, keyWord,
//                straddleMode, firstSeal);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleUpdate() {
//        int id = 1001;
//        String name = "测试规则";
//        int sealId = 1;
//        int certId = 1;
//        int type = 1;
//        int page = 9;
//        int x = 25000;
//        int y = 25400;
//        int beginPage = 0;
//        int endPage = 0;
//        String searchOrder = "";
//        int signNumber = 1;
//        String keyWord = "";
//        String straddleMode = "";
//        float firstSeal = 50f;
//
//        ECloudDomain eCloudDomain = NativeSealClient.ruleUpdate(id, name, sealId, certId, type,
//                page, x, y, beginPage, endPage, searchOrder, signNumber, keyWord,
//                straddleMode, firstSeal);
//        return eCloudDomain;
//    }
//
//    public static ECloudDomain ruleDelete() {
//        int id = 1001;
//        ECloudDomain eCloudDomain = NativeSealClient.ruleDelete(id);
//        return eCloudDomain;
//    }
//
//    public static void contractSign() {
//        String ruleCode = "1";
//        File pdfFile = new File("d:\\hetong.pdf");
//        File destFile = new File("d:\\signHetong.pdf");
//        byte[] newData;
//        try {
//            newData = NativeSealClient.contractSign(ruleCode, pdfFile);
//            if (newData != null)
//                FileUtils.writeByteArrayToFile(destFile, newData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static ECloudDomain contractAWSSign() {
//        String bucket = "cp-test-file";
//        String sourceKey = "agile-test-550E8400-E29B-11D4-A716-446655440111.pdf";
//        String targetKey = "agile-test-550E8400-E29B-11D4-A716-446655440311.pdf";
//        String ruleCode = "2";
//        ECloudDomain eCloudDomain = NativeSealClient.contractAWSSign(bucket, sourceKey, targetKey, ruleCode);
//        return eCloudDomain;
//    }
//
//    public static void personSign() {
//        SignParam signParam = new SignParam();
//        signParam.setCardType("0");
//        signParam.setCardCode("612501197203035172");
//        signParam.setName("liuzuquan");
//        signParam.setMobile("13800138000");
//
//        RuleInfo ruleInfo = new RuleInfo();
//
//        // 印章图片
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            String picBase64 = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\seal.png")));
//            ruleInfo.setPicBase64(picBase64);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        // 绝对位置
//        ruleInfo.setType((short) 1);
//        ruleInfo.setPage(1);
//        ruleInfo.setX(25000);
//        ruleInfo.setY(25000);
//
////    	// 关键字
////    	ruleInfo.setType((short) 2);
////    	ruleInfo.setX(0);
////    	ruleInfo.setY(0);
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setKeyWord("甲方");
////    	ruleInfo.setSearchOrder("DESC");
////    	ruleInfo.setSignNumber(2);
//
////    	// 骑缝章
////    	ruleInfo.setType((short) 3);
////    	ruleInfo.setStraddleMode("R");
////    	ruleInfo.setFirstSeal(new BigDecimal(50));
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setY(25000);
//
//        signParam.setRuleInfo(ruleInfo);
//
//        File pdfFile = new File("d:\\hetong.pdf");
//        File destFile = new File("d:\\signHetong.pdf");
//        byte[] newData;
//        try {
//            newData = NativeSealClient.contractSign(signParam, pdfFile);
//            if (newData != null)
//                FileUtils.writeByteArrayToFile(destFile, newData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void personSignByte() {
//        SignParam signParam = new SignParam();
//        signParam.setCardType("0");
//        signParam.setCardCode("612501197203035172");
//        signParam.setName("liuzuquan");
//        signParam.setMobile("13800138000");
//
//        RuleInfo ruleInfo = new RuleInfo();
//
//        // 印章图片
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            String picBase64 = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\seal.png")));
//            ruleInfo.setPicBase64(picBase64);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        // 绝对位置
//        ruleInfo.setType((short) 1);
//        ruleInfo.setPage(1);
//        ruleInfo.setX(25000);
//        ruleInfo.setY(25000);
//
////    	// 关键字
////    	ruleInfo.setType((short) 2);
////    	ruleInfo.setX(0);
////    	ruleInfo.setY(0);
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setKeyWord("甲方");
////    	ruleInfo.setSearchOrder("DESC");
////    	ruleInfo.setSignNumber(2);
//
////    	// 骑缝章
////    	ruleInfo.setType((short) 3);
////    	ruleInfo.setStraddleMode("R");
////    	ruleInfo.setFirstSeal(new BigDecimal(50));
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setY(25000);
//
//        signParam.setRuleInfo(ruleInfo);
//
//        try {
//            File pdfFile = new File("d:\\hetong.pdf");
//            File destFile = new File("d:\\signHetong.pdf");
//            byte[] pdfData = FileUtils.readFileToByteArray(pdfFile);
//            byte[] newData = NativeSealClient.contractSign(signParam, pdfData);
//            if (newData != null)
//                FileUtils.writeByteArrayToFile(destFile, newData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static ECloudDomain personAWSSign() {
//        String bucket = "cp-test-file";
//        String sourceKey = "agile-test-550E8400-E29B-11D4-A716-446655440311.pdf";
//        String targetKey = "agile-test-550E8400-E29B-11D4-A716-446655440411.pdf";
//        SignParam signParam = new SignParam();
//        signParam.setBucket(bucket);
//        signParam.setSourceKey(sourceKey);
//        signParam.setTargetKey(targetKey);
//        signParam.setCardType("0");
//        signParam.setCardCode("612501197203035172");
//        signParam.setName("刘祖全2");
//        signParam.setMobile("13800138000");
//
//        RuleInfo ruleInfo = new RuleInfo();
//
//        // 印章图片
//        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//
//            String picBase64 = encoder.encode(FileUtils.readFileToByteArray(new File("D:\\seal.png")));
//            ruleInfo.setPicBase64(picBase64);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        // 绝对位置
//        ruleInfo.setType((short) 1);
//        ruleInfo.setPage(2);
//        ruleInfo.setX(25000);
//        ruleInfo.setY(25000);
//
////    	// 关键字
////    	ruleInfo.setType((short) 2);
////    	ruleInfo.setX(0);
////    	ruleInfo.setY(0);
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setKeyWord("甲方");
////    	ruleInfo.setSearchOrder("DESC");
////    	ruleInfo.setSignNumber(2);
//
////    	// 骑缝章
////    	ruleInfo.setType((short) 3);
////    	ruleInfo.setStraddleMode("R");
////    	ruleInfo.setFirstSeal(new BigDecimal(50));
////    	ruleInfo.setBeginPage(1);
////    	ruleInfo.setEndPage(-1);
////    	ruleInfo.setY(25000);
//
//
//        signParam.setRuleInfo(ruleInfo);
//        ECloudDomain eCloudDomain = NativeSealClient.contractAWSSign(signParam);
//        System.out.println(eCloudDomain.toJson());
//        return eCloudDomain;
//    }
//
//
//}
