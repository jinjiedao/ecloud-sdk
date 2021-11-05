package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.http.result.ContractResult;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.alibaba.fastjson.JSONObject;

public class TestAuto {
    private static final Logger logger = LoggerFactory.getLogger(TestAuto.class);

    public static void main(String[] args) {
        String url = "https://ttapi.ecloudsign.com/";
        String appKey = "";//如需此参数，请联系公司工作人员
        String secrept = "";//如需此参数，请联系公司工作人员
        EcloudPublicKey.init(appKey, secrept, "1.0", url);
        // 添加模板------根据模板生成合同------自动签署合同
        // for (int i = 0; i < 10; i++) {
        autoAddTmpAndAddConAndAutoSign();
        // }

        // 添加模板------根据模板生成合同------自动签署合同带参数ByVar
        // autoAddTmpAndAddConAndAutoSignByVar();
        // 添加模板------根据模板生成合同------自动签署合同 带签章信息BySignPosition
        // autoAddTmpAndAddConAndAutoSignBySignPosition();

        // 申请ca证书-----修改手机号-----延期ca证书
        // autoCreateCaAndUpdateMobileAndRenewCeat();

    }

    /**
     * 添加模板------根据模板生成合同------自动签署合同 带签章信息BySignPosition
     */
    public static void autoAddTmpAndAddConAndAutoSignBySignPosition() {
        // 添加模板和变量
        ECloudDomain tmpResult = addHtmlTemplateHaveSignPosition();
        JSONObject tmpObj = (JSONObject) tmpResult.getData();
        String templateNumber = tmpObj.get("templateNumber").toString();
        if (ClassUtil.isBlank(templateNumber)) {
            logger.debug("autoAddTmpAndAddConAndAutoSignBySignPosition: templateNumber is null");
            return;
        } else {
            logger.debug("autoAddTmpAndAddConAndAutoSignBySignPosition: templateNumber=" + templateNumber);
        }

        // 根据模板生成合同文档BY VARS
        ECloudDomain conResult = createContractByTemplate(templateNumber);
        JSONObject conObj = (JSONObject) conResult.getData();
        String contract = conObj.get("contractNum").toString();

        if (ClassUtil.isBlank(templateNumber)) {
            logger.debug("autoAddTmpAndAddConAndAutoSignBySignPosition: contractNum is null");
            return;
        } else {
            logger.debug("autoAddTmpAndAddConAndAutoSignBySignPosition: contractNum=" + contract);
        }
        // 自动签署合同
        ECloudDomain result = autoSignHaveSignInfo(contract);
        if (!result.getCode().equals("0")) {
            logger.debug("erromsg:" + result.getMessage());
            return;
        } else {
            downloadContractByPath(contract, "d:/888888.pdf");// 直接下载到本地
            logger.debug("code:" + result.getCode() + ",message:" + result.getMessage());
        }
    }

    /**
     * 添加模板------根据模板生成合同------自动签署合同 带参数ByVar
     */
    public static void autoAddTmpAndAddConAndAutoSignByVar() {
        // 添加模板和变量
        ECloudDomain tmpResult = addHtmlTemplateVars();
        JSONObject tmpObj = (JSONObject) tmpResult.getData();
        String templateNumber = tmpObj.get("templateNumber").toString();

        // 根据模板生成合同文档BY VARS
        ECloudDomain conResult = createContractByTemplateByVar(templateNumber);
        JSONObject conObj = (JSONObject) conResult.getData();
        String contract = conObj.get("contractNum").toString();

        // 自动签署合同
        ECloudDomain result = autoSign(contract);
        downloadContractByPath(contract, "d:/999999.pdf");// 直接下载到本地
        System.out.println("code:" + result.getCode() + ",message:" + result.getMessage());
    }

    public static void downloadContractByPath(String contractNum, String targetPath) {
        ContractResult.downloadContract(EcloudPublicKey.instance, contractNum, targetPath);
    }

    /**
     * 添加模板------根据模板生成合同------自动签署合同
     */
    public static void autoAddTmpAndAddConAndAutoSign() {
        // 添加模板
        ECloudDomain tmpResult = addHtmlTemplate();
        JSONObject tmpObj = (JSONObject) tmpResult.getData();
        String templateNumber = tmpObj.get("templateNumber").toString();

        // 根据模板生成合同文档
        ECloudDomain conResult = createContractByTemplate(templateNumber);
        JSONObject conObj = (JSONObject) conResult.getData();
        String contract = conObj.get("contractNum").toString();

        // 自动签署合同
        ECloudDomain result = autoSign(contract);

        System.out.println("code:" + result.getCode() + ",message:" + result.getMessage());
    }

    public static ECloudDomain addHtmlTemplate() {
        String testHtmlString = "html";
        // 添加模板
        System.out.println("正在执行添加模板操作。");
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate("测试", testHtmlString);
        return eCloudDomain;
    }

    public static ECloudDomain createContractByTemplate(String templateNumber) {
        if (templateNumber == null || "".equals(templateNumber)) {
            templateNumber = "d1f80e9ac2e5877f";
        }
        System.out.println("正在执行根据模板生成合同文档。模板id为：" + templateNumber);
        // 根据模板生成合同文档
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplate(templateNumber,
                JSONObject.toJSONString(ClassUtil.toMap(new String[] { "var1", "var2", "var3" }, "变量1", "变量2", "变量3")));
        return eCloudDomain;

    }

    public static ECloudDomain autoSign(String contractNum) {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(
                new String[] { "type", "cardType", "idCardNum", "name", "mobilePhone" }, 1, 0, "110105198710097533",
                "手机宝宝", "15818322868");
        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(map), contractNum, 0);
        return eCloudDomain;

    }

    public static ECloudDomain addHtmlTemplateVars() {
        String testHtmlString = "添加模板和变量测试html[[测试变量名称1]]";
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

    public static ECloudDomain createContractByTemplateByVar(String templateNumber) {
        System.out.println("正在执行根据模板生成合同文档。模板id为：" + templateNumber);
        String vars = "";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "测试变量名称1");
        map.put("value", "变量显示名称");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map);
        vars = JSONObject.toJSONString(list);
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplateByVar(templateNumber, vars);
        return eCloudDomain;

    }

    public static ECloudDomain addHtmlTemplateHaveSignPosition() {
        String html = "html";
        String templateName = "测试名称";
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[] { "positionName", "page", "x", "y" }, "name", 1,
                200, 200);
        Map<String, Object> signInfoMap1 = ClassUtil.toMap(new String[] { "positionName", "page", "x", "y" }, "name1",
                1, 100, 100);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(signInfoMap);
        list.add(signInfoMap1);
        // 添加模板
        System.out.println("正在执行添加模板操作。");

        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate(templateName, html, "", JSONObject.toJSONString(list));
        return eCloudDomain;
    }

    public static ECloudDomain autoSignHaveSignInfo(String contractNum) {
        System.out.println("正在执行自动签署合同。合同id为：" + contractNum);
        // 自动签署合同
        Map<String, Object> map = ClassUtil.toMap(
                new String[] { "type", "cardType", "idCardNum", "name", "mobilePhone" }, 1, 0, "110105198710155463",
                "手机宝宝", "15811236215");
        Map<String, Object> signInfoMap = ClassUtil.toMap(new String[] { "signType", "signId", "positionName" }, 1,
                674, "name");
        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(map), contractNum, 0,
                JSONObject.toJSONString(signInfoMap));
        return eCloudDomain;

    }

    public static void autoCreateCaAndUpdateMobileAndRenewCeat() {
        Random r = new Random();
        Integer random = r.nextInt(899999) + 100000;
        String cardNum = "110105198710" + random.toString();
        String mobilePhoneRandomNum = "1581";// "15818322868";
        for (int i = 0; i < 7; i++) {
            mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
        }

        // 申请ca
        ECloudDomain applyDomain = applyCert(cardNum, mobilePhoneRandomNum);

        System.out.println(applyDomain.getData());

        Map<String, Object> map = ClassUtil.toMap(
                new String[] { "type", "cardType", "idCardNum", "name", "mobilePhone" }, 1, 0, cardNum, "asd",
                mobilePhoneRandomNum);
        // 修改手机号
        ECloudDomain changeDomain = changeMobile(map);
        System.out.println(changeDomain.getData());

        // 延期ca
        ECloudDomain renewDomain = renewCert(map);
        System.out.println(renewDomain.getData());

    }

    public static ECloudDomain applyCert(String cardNum, String mobilePhoneRandomNum) {
        // Random r = new Random();
        // Integer random = r.nextInt(899999) + 100000;
        // String cardNum = "110105198710" + random.toString();
        String randomName = "";
        for (int i = 0; i < 10; i++) {
            randomName = randomName + (char) (Math.random() * 26 + 'A');
        }
        // String mobilePhoneRandomNum = "1581";// "15818322868";
        // for (int i = 0; i < 7; i++) {
        // mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
        // }
        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", cardNum, randomName, mobilePhoneRandomNum);
        return eCloudDomain;
    }

    public static ECloudDomain changeMobile(Map<String, Object> map) {

        Random r = new Random();
        String mobilePhoneRandomNum = "1581";
        for (int i = 0; i < 7; i++) {
            mobilePhoneRandomNum = mobilePhoneRandomNum + r.nextInt(9);
        }
        ECloudDomain eCloudDomain = EcloudClient.changeMobile(JSONObject.toJSONString(map), mobilePhoneRandomNum);
        return eCloudDomain;
    }

    public static ECloudDomain renewCert(Map<String, Object> map)

    {
        ECloudDomain eCloudDomain = EcloudClient.renewCert(JSONObject.toJSONString(map));
        return eCloudDomain;
    }
}
