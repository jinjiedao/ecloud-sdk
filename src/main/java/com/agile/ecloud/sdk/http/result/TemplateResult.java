package com.agile.ecloud.sdk.http.result;

import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.common.ErrorMessage;
import com.agile.ecloud.sdk.common.SdkApiAction;
import com.agile.ecloud.sdk.util.ClassUtil;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * 模板
 * 
 * @author sjh
 * 
 */
public class TemplateResult {

    /**
     *  添加模板
     * 
     * @param templateName
     *            模板调用名称
     * @param html
     *            模板html内容
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     *         "templateNumber": "K4rFtSuQSBcdobf6" } }
     */
    public static ECloudDomain addHtmlTemplate(EcloudPublicKey config, String templateName, String html) {
        Map<String, String> map = new TreeMap<String, String>();
        if (ClassUtil.isBlank(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (ClassUtil.isBlank(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  添加模板
     * 
     * @param templateName
     *            模板调用名称
     * @param html
     *            模板html内容
     * @param templateNumber
     *            模板编号 （非必填）
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     *         "templateNumber": "K4rFtSuQSBcdobf6" } }
     */
    public static ECloudDomain addHtmlTemplate(EcloudPublicKey config, String templateName, String html, String templateNumber) {
        Map<String, String> map = new TreeMap<String, String>();
        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        if (templateNumber == null || "".equals(templateNumber)) {
            // map.put("templateNumber", null);
        } else {
            map.put("templateNumber", templateNumber);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  添加模板
     * 
     * @param templateName
     *            模板调用名称
     * @param html
     *            模板html内容
     * @param templateNumber
     *            模板编号 （非必填）
     * @param signPosition
     *            签章位置列表,json字符串 非必填
     * 
     *            { "positionName":"name1", //签章位置名称1 "page": 1, //页数，从1开始 "x":
     *            200, //X坐标 "y": 200, //Y坐标 }, { "positionName":"name1",
     *            //签章位置名称2 "page": 2, //页数，从1开始 "x": 300, //X坐标 "y": 300, //Y坐标
     *            } ]
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": {
     *         "templateNumber": "K4rFtSuQSBcdobf6" } }
     */
    public static ECloudDomain addHtmlTemplate(EcloudPublicKey config, String templateName, String html, String templateNumber,
            String signPosition) {
        Map<String, String> map = new TreeMap<String, String>();
        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        if (templateNumber == null || "".equals(templateNumber)) {
            // map.put("templateNumber", null);
        } else {
            map.put("templateNumber", templateNumber);
        }
        if (signPosition == null || "".equals(signPosition)) {
            // map.put("signPosition", null);
        } else {
            map.put("signPosition", signPosition);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 添加模板和变量
     * 
     * @param templateNumber 模板编号
     * @param templateName 模板名称
     * @param html 模板html内容
     * @param vars 模板变量jason
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": {
     *          "templateNumber": "K4rFtSuQSBcdobf6" } }
     */
    public static ECloudDomain addHtmlTemplateByVar(EcloudPublicKey config, String templateNumber, String templateName, String html, String vars) {
        Map<String, String> map = new TreeMap<String, String>();
        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        if (vars == null || "".equals(vars)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.VARS_ERR.getCode(), ErrorMessage.VARS_ERR.getMessage());
        }
        map.put("vars", vars);

        if (templateNumber == null || "".equals(templateNumber)) {
            // map.put("templateNumber", null);
        } else {
            map.put("templateNumber", templateNumber);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.ADDHTMLTEMPLATEBYVAR_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  更新模板
     * 
     * @param templateNumber
     *            模板编号
     * @param templateName
     *            模板名称
     * @param html
     *            模板html内容
     * @param signPosition
     *            签章位置列表,json字符串 非必填
     * 
     *            格式{ "positionName":"name1", //签章位置名称1 "page": 1, //页数，从1开始
     *            "x": 200, //X坐标 "y": 200, //Y坐标 }, { "positionName":"name1",
     *            //签章位置名称2 "page": 2, //页数，从1开始 "x": 300, //X坐标 "y": 300, //Y坐标
     *            } ]
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain editHtmlTemplate(EcloudPublicKey config, String templateNumber, String templateName, String html,
            String signPosition) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);
        if (signPosition == null || "".equals(signPosition)) {
            // map.put("signPosition", null);
        } else {
            map.put("signPosition", signPosition);
        }
        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.EDITHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  更新模板
     * 
     * @param templateNumber
     *            模板编号
     * @param templateName
     *            模板名称
     * @param html
     *            模板html内容
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain editHtmlTemplate(EcloudPublicKey config, String templateNumber, String templateName, String html) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.EDITHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  更新模板和变量
     * 
     * @param templateNumber
     *            模板编号
     * @param templateName
     *            模板名称
     * @param html
     *            模板html内容
     * @param vars
     *            变量内容
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain editHtmlTemplateByVar(EcloudPublicKey config, String templateNumber, String templateName, String html,
            String vars) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (templateName == null || "".equals(templateName)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPLATE_NAME_ERR.getCode(), ErrorMessage.TEMPLATE_NAME_ERR.getMessage());
        }
        map.put("templateName", templateName);

        if (vars == null || "".equals(vars)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.VARS_ERR.getCode(), ErrorMessage.VARS_ERR.getMessage());
        }
        map.put("vars", vars);

        if (html == null || "".equals(html)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.HTML_ERR.getCode(), ErrorMessage.HTML_ERR.getMessage());
        }
        map.put("html", html);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.EDITHTMLTEMPLATEBYVAR_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 删除模板
     * 
     * @param templateNumber
     *            模板编号
     * 
     * @return { "meta":{ "code":"0", "message":"操作成功" } }
     */
    public static ECloudDomain delHtmlTemplate(EcloudPublicKey config, String templateNumber) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.DELHTMLTEMPLATE_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 获取模板列表
     * 
     * @param currentPage 当前页数
     *            ，默认为1
     * @param pageSize 每页的记录数
     *            ，最大为100
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": { "pageInfo":{
     *          "currentPage":1, "pageSize":10, "totalPage":1, "totalRecord":5
     *          }, "list":[ { "templateNumber": "XXX", "templateName":"XXX", },
     *          ...... ] } }
     */
    public static ECloudDomain getTemplateList(EcloudPublicKey config, String currentPage, String pageSize) {
        Map<String, String> map = new TreeMap<String, String>();

        if (currentPage == null || "".equals(currentPage)) {
        } else {
            map.put("currentPage", currentPage);
        }

        if (pageSize == null || "".equals(pageSize)) {
        } else {
            map.put("pageSize", pageSize);
        }

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETTEMPLATELIST_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 获取模板内容
     * 
     * @param templateNumber
     *            模板ID
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": { "cont": "xxx"
     *          } }
     */
    public static ECloudDomain getTemplateCont(EcloudPublicKey config, String templateNumber) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETTEMPLATECONT_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  根据模板生成合同文档
     * 
     * @param templateNumber 模板编号
     * 
     * @param replaceVal
     *            模板变量值
     * 
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
     *          "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain createContractByTemplate(EcloudPublicKey config, String templateNumber, String replaceVal) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(),ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (replaceVal == null || "".equals(replaceVal)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.REPLACE_VAL_ERR.getCode(), ErrorMessage.REPLACE_VAL_ERR.getMessage());
        }
        map.put("replaceVal", replaceVal);


        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATECONTRACTBYTEMPLATE_ACTION, SdkApiAction.METHODPOST,
                map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  根据模板生成合同文档
     * 
     * @param templateNumber 模板编号
     * 
     * @param replaceVal
     *            模板变量值
     * @param contractNum
     *            合同编号
     * 
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
     *          "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain createContractByTemplate(EcloudPublicKey config, String templateNumber, String replaceVal, String contractNum) {
        return createContractByTemplate(config, templateNumber, replaceVal, contractNum, "V");
    }
    
    public static ECloudDomain createContractByTemplate(EcloudPublicKey config, String templateNumber, String replaceVal, String contractNum, String orientation) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (replaceVal == null || "".equals(replaceVal)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.REPLACE_VAL_ERR.getCode(), ErrorMessage.REPLACE_VAL_ERR.getMessage());
        }
        map.put("replaceVal", replaceVal);

        if (contractNum == null || "".equals(contractNum)) {
            // map.put("contractNum", null);
        } else {
            map.put("contractNum", contractNum);
        }

        map.put("orientation", orientation);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATECONTRACTBYTEMPLATE_ACTION, SdkApiAction.METHODPOST,
                map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     *  根据模板生成合同文档
     * 
     * @param templateNumber 模板编号
     * 
     * @param vars
     *            模板变量值
     * 
     * @return{ "meta":{ "code":"0", "message":"操作成功" } "data": { "contractNum":
     *          "Y90GVbAB1bN1tvn9" } }
     */
    public static ECloudDomain createContractByTemplateByVar(EcloudPublicKey config, String templateNumber, String vars) {
        return createContractByTemplateByVar(config, templateNumber, vars, "V");
    }

    public static ECloudDomain createContractByTemplateByVar(EcloudPublicKey config, String templateNumber, String vars, String orientation) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        if (vars == null || "".equals(vars)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.VARS_ERR.getCode(), ErrorMessage.VARS_ERR.getMessage());
        }
        map.put("vars", vars);

        map.put("orientation", orientation);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CREATECONTRACTBYTEMPLATEBYVAR_ACTION,
                SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }

    /**
     * 获得模板变量
     * 
     * @param templateNumber
     *            模板编号
     * 
     * @return { "meta":{ "code":"0", "message":"操作成功" } "data": { "list":[ {
     *         "name": "变量名称", "nameDisplay": "变量显示名称", "textAlign": "0", //
     *         对齐方式 ,0:居中,1:左对 齐，2：右对齐 "type": "1", // 数据类型 1：文本，2：日期，3：数字
     *         "minLen": "0", // 最小长度 "maxLen": "10", // 最大长度 "required": "0",
     *         // 是否必填 0非必填 1必填 "underline": "0", // 是否有下划线 0有划线 1无下划线
     *         "defaultValue": "变量值", "autoGenDate": "0", // 是否自动生成日期 0不生成 1生 成
     *         }, { ..... } ] } }
     */
    public static ECloudDomain getTemplateVars(EcloudPublicKey config, String templateNumber) {
        Map<String, String> map = new TreeMap<String, String>();

        if (templateNumber == null || "".equals(templateNumber)) {
            return ClassUtil.returnECloudDomain(ErrorMessage.TEMPlATE_NUMBER_ERR.getCode(), ErrorMessage.TEMPlATE_NUMBER_ERR.getMessage());
        }
        map.put("templateNumber", templateNumber);

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.GETTEMPLATEVARS_ACTION, SdkApiAction.METHODPOST, map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    
    /**
     * 文档转换
     * <p>Title: docUpload</p>  
     * <p>Description: </p>  
     * @return
     */
    public static ECloudDomain docUpload(EcloudPublicKey config, File file) {
        Map<String, String> map = new TreeMap<String, String>();

        ECloudBean eClioudBean = new ECloudBean(config, SdkApiAction.CONTRACTINFOTOHTML_ACTION, SdkApiAction.METHODPOST, map);
        eClioudBean.setFile(file);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        return eCloudDomain;
    }
    
}
