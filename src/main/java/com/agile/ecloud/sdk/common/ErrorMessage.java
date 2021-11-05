package com.agile.ecloud.sdk.common;

/*******************************************************************************
 * Copyright 2017 agilestar, Inc. All Rights Reserved
 * Agile_ECloud_SDK
 * com.agile.ecloud.sdk.common
 * Created by bob on 2017/9/1.
 * Description: 错误提示信息
 *******************************************************************************/
public enum ErrorMessage {


    MOBILE_PHONE_ERR("202", "mobilePhone 不能为空"),
    SIGN_TYPE_ERR("203", "signType 不能为空"),
    SIGN_ID_ERR("204", "signId 不能为空"),
    SIGN_IMG_ERR("205", "signImg 不能为空"),
    SIGN_NAME_ERR("206", "signName 不能为空"),
    FONT_FAMILY_ERR("207", "fontFamily must is >=1 & <= 6"),
    FONT_SIZE_ERR("208", "fontSize must is > 0"),
    UNIT_NAME_ERR("209", "unitName 不能为空"),
    CONTRACT_NUM_ERR("210", "contractNum 不能为空"),
    IS_FINISH_ERR("211", "isFinish 只能为1或0"),
    SIGNER_INFO_ERR("212", "signerInfo 不能为空"),
    KEY_WORD_ERR("214", "keyWord 不能为空"),
    CONTRACT_NAME_ERR("215", "contractName 不能为空"),
    DAYS_ERR("216", "days 不能为空"),//合同有效天数
    SIGNER_INFOS_ERR("217", "signerInfos 不能为空"),//签章坐标信息
    POSITION_ERR("218", "position 不能为空"),//坐标信息
    TO_Mobile_ERR("219", "toMobile 不能为空"),//签署人手机号
    DYNAMIC_CODE_ERR("220", "dynamicCode 不能为空"),//动态验证码
    FILE_ERR("221", "file 不能为空"),//pdf 文件
    REMARK_ERR("222", "remark 最多50个字符"),
    RULE_INFO_ERR("223", "ruleInfo 不能为空"),//
    TYPE_ERR("224", "type 不能为空"),
    CARD_TYPE_ERR("225", "cardType 不能为空"),
    ID_CARD_NUM_ERR("226", "idCardNum 不能为空"),
    NAME_ERR("227", "name 不能为空"),
    TEMPLATE_NAME_ERR("228", "templateName 不能为空"),//模板名称
    HTML_ERR("229", "html不能为空"),//模板内容
    VARS_ERR("230", "vars 不能为空"),//模板变量
    TEMPlATE_NUMBER_ERR("231", "templateNumber 不能为空"),//模板编号
    REPLACE_VAL_ERR("232", "replaceVal 不能为空"),//模板变量值
    IS_FINISH_NULL_ERR("233", "isFinish 不能为空"),
    NEW_MOBILE_ERR("234", "newMobile 不能为空"),
    ACARD_IMAGE1_ERR("235", "cardImg1 不能为空"),
    ACARD_IMAGE2_ERR("236", "cardImg2 不能为空"),
    LOCAL_FILE_NAME_ERR("237","localFileName 不能为空"),
    EXECUTE_METHOD_PARAMETER("238","请求参数不能为空"),
    FILE_NOT_FOUND("239","文件不能为空"),
    HTTP_REQUEST_ERR("240","http请求处理异常"),
    PDF_ADD_IMAGE_ERR("241","pdfAddImage接口参数错误"),
    GEN_CIRCLE_SEAL_ERR("242", "genCircleSeal接口参数错误"),
    GEN_PERSON_RECTANGLE_SEAL_ERR("243","genPersonRectangleSeal 接口参数错误"),
    HTML_CONTENT_NOT_EXIST_ERR("244","html内容不存在"),
	PDF_PATH_ERR("245","PDF路径不能为空"),
	IMAGE_BASE64_ERR("246","图片不能为空"),
	INDENTIFICATION_NAME_ERR("247","姓名不能为空"),
	INDENTIFICATION_TELEPHONE_ERR("248","手机号不能为空"),
	INDENTIFICATION_IDCARDNO_ERR("249","身份证号码不能为空"),
	USERID_ERR("250","USERID不能为空"),
	TASKID_ERR("251","TASKID不能为空"),
	FRONTIMAGE_ERR("252","身份证正面不能为空"),
	BACKIMAGE_ERR("253","身份证反面不能为空"),
	VIDEOBASE64_ERR("254","视频不能为空"),
	VIDEOTYPE_ERR("255","视频类型不能为空"),
	ENGINETYPE_ERR("256","证件类型不能为空"),
	DATAVASEINAGE_CONTENT_ERR("257","证件图片不能为空"),
	COMNAME_TELEPHONE_ERR("258","公司名称不能为空"),
	COMNO_TELEPHONE_ERR("259","企业标识不能为空"),
	APP_SAASUSER_CONTENT_ERR("260","关联用户不能为空"),
	SIGN_WIDTH("261","图片宽度不能为空"),
	SIGN_HEIGTH("262","图片高度不能为空"),
	FACE_FROM("263","启动来源不能为空"),
	FACE_URL("264","回调URL不能为空"),
	FACE_ORDER("265","orderNo不能为空"),
	FILE_INFO("267","fileInfo不能为空"),
	COMPONENTS_INFO("268","components不能为空"),
	COMPONENTS_IDS("269","componentIds不能为空"),
	CREATECONTRACT_PARAM("270","createContractParam不能为空"),
	SERUAL_NUMBER("271","serialNumber不能为空"),
	PDF_BASE64("266","pdf内容不能为空");


    private String code;
    private String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}




