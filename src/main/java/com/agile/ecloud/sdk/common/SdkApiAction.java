package com.agile.ecloud.sdk.common;

public class SdkApiAction {

    // 用户信息
    /**
     * 申请CA证书
     */
    public static final String APPLYCERT_ACTION                       = "/ecs/account/applyCert.jspa";
    public static final String SMS_CONTRACT_BATCHSIGN               = "/ecs/contractInfo/smsBatchSigning.jspa";
    public static final String SEALBRKEYWORD_FORNUM_ACTION                = "/ecs/seal/sealByKeywordForNum.jspa";
    /**
     * 更新CA证书
     */
    public static final String UPDATECERT_ACTION                       = "/ecs/certificate/updateCert.jspa";
    
    /**
     * 申请CA证书saas_api
     */
    public static final String APPLYCERT_SAAS_ACTION                       = "/ecs/certificate/applyCert.jspa";
    
    /**
     * 12位虚拟手机号
     */
    public static final String APPLYCERTMOBILE_ACTION                       = "/ecs/account/applyCertMobile.jspa";

    /**
     * 字符申请证书
     */
    public static final String APPLYCERTSTRING_ACTION                       = "/ecs/account/applyCertString.jspa";

    /**
     * 字符申请证书
     */
    public static final String APPLY_CERT_CARDNUM_ACTION                       = "/ecs/account/applyCertCardNum.jspa";

    /**
     * 签署人更换手机
     */
    public static final String CHANGEMOBILE_ACTION                    = "/ecs/account/changeMobile.jspa";

    /**
     * 吊销用户 6.1.3 已取消
     */
    public static final String UNWRAP_ACTION                          = "/ecs/account/unwrap.jspa";

    /**
     * 用户的证书信息 6.1.3
     */
    public static final String GETCERTINFO_ACTION                     = "/ecs/account/getCertInfo.jspa";


    /**
     * 用户的证书信息
     */
    public static final String GETCERTINFOSTRING_ACTION                     = "/ecs/account/getCertInfoString.jspa";

    /**
     * 用户证书延期 6.1.4
     */
    public static final String RENEWCERT_ACTION                       = "/ecs/account/renewCert.jspa";

    /**
     * 用户证书延期
     */
    public static final String REVOKECERT_ACTION                       = "/ecs/account/revokeCert.jspa";

    /**
     * 银行卡实名认证
     */
    public static final String BANK_VERIFY_ACTION                       = "/ecs/auth/bankVerify.jspa";
    /**
     * 签章机远程申请证书
     */
    public static final String REMOTE_APPLY_SEAL_ACTION               = "/ecs/account/remoteApplySeal.jspa";

    // 签名签章
    /**
     * 签名/签章列表
     */
    public static final String GETSIGNLIST_ACTION                     = "/ecs/signInfo/getsignList.jspa";
    
    
    /**
     * 签名/签章列表返回图片
     */
    public static final String GETSIGNLISTFORIMAGE_ACTION                     = "/ecs/signInfo/getsignListForImage.jspa";

    /**
     * 设置默认 签名/签章
     */
    public static final String SETDEFAULTSIGN_ACTION                  = "/ecs/signInfo/setDefaultSign.jspa";

    /**
     * 添加 签名/签章
     */
    public static final String ADDSIGN_ACTION                         = "/ecs/signInfo/addSign.jspa";
    
    
    public static final String CREATENEWSIGN_ACTION                         = "/ecs/signInfo/createNewSign.jspa";
    
    
    
    /**
     * 添加 签名/签章新saas
     */
    public static final String ADDSIGNFORSAAS_ACTION                         = "/ecs/signInfo/addSignForSaas.jspa";
    
    /**
     * 创建 签名/签章
     */
    public static final String CREATESIGN_ACTION                      = "/ecs/signInfo/createSign.jspa";
    /**
     * 删除 签名/签章
     */
    public static final String DELSIGN_ACTION                         = "/ecs/signInfo/delSign.jspa";
    
    public static final String APPLYCERT_BUF                       = "/ecs/account/makeCertInfoToBuf.jspa";

    // 模板
    /**
     * 添加模板
     */
    public static final String ADDHTMLTEMPLATE_ACTION                 = "/ecs/template/addHtmlTemplate.jspa";

    public static final String ADDHTMLTEMPLATEBYVAR_ACTION            = "/ecs/template/addHtmlTemplateByVar.jspa";

    /**
     * 修改模板
     */
    public static final String EDITHTMLTEMPLATE_ACTION                = "/ecs/template/editHtmlTemplate.jspa";

    public static final String EDITHTMLTEMPLATEBYVAR_ACTION           = "/ecs/template/editHtmlTemplateByVar.jspa";

    /**
     * 获得模板变量
     */
    public static final String GETTEMPLATEVARS_ACTION                 = "/ecs/template/getTemplateVars.jspa";

    /**
     * 获取模板列表
     */
    public static final String GETTEMPLATELIST_ACTION                 = "/ecs/template/getTemplateList.jspa";

    /**
     * 获取模板内容
     */
    public static final String GETTEMPLATECONT_ACTION                 = "/ecs/template/getTemplateCont.jspa";

    /**
     * 删除模板
     */
    public static final String DELHTMLTEMPLATE_ACTION                 = "/ecs/template/delHtmlTemplate.jspa";

    /**
     * 生成电子合同
     */
    public static final String CREATECONTRACTBYTEMPLATE_ACTION        = "/ecs/template/createContractByTemplate.jspa";

    public static final String CREATECONTRACTBYTEMPLATEBYVAR_ACTION   = "/ecs/template/createContractByTemplateByVar.jspa";

    // 合同
    /**
     * 获取合同列表合同
     */
    public static final String GETCONTRACTLIST_ACTION                 = "/ecs/contract/getContractList.jspa";

    /**
     * 获取合同列表合同
     */
    public static final String GETCONTRACTDETAIL_ACTION               = "/ecs/contract/getContractDetail.jspa";
    
    
    /**
     * 获取合同图片
     */
    public static final String GETCONTRACTDETAIL_SAAS_ACTION               = "/ecs/contractInfo/getContractImgs.jspa";
    

    /**
     * 获取合同详情-实时更新
     */
    public static final String GETCONTRACTDETAIL_UP_ACTION               = "/ecs/contract/getContractDetailUp.jspa";
    /**
     * 获取合同图片
     */
    public static final String GET_CONTRACT_IMGS_ACTION               = "/ecs/contract/getContractImgs.jspa";


    /**
     * 自动签署合同
     */
    public static final String AUTOSIGN_ACTION                        = "/ecs/contract/autoSign.jspa";
    
    public static final String DELREDIS_ACTION                        = "/ecs/contract/delRedis.jspa";

    /**
     * 自动签署合同 身份信息申请证书
     */
    public static final String AUTO_SIGN_FOR_CARDNUM_ACTION                        = "/ecs/contract/autoSignForCardNum.jspa";
    
    /**
     * 自动签署合同 身份信息申请证书 新saas使用无效印章
     */
    public static final String AUTO_SIGN_INVALID_SEAL                        = "/ecs/contract/autoSignInvalidSeal.jspa";

    /**
     * 自动签署合同 字符申请证书
     */
    public static final String AUTOSIGNFORSTRING_ACTION                        = "/ecs/contract/autoSignForString.jspa";

    /**
     * 自动签署合同 12位虚拟手机号
     */
    public static final String AUTOSIGNMOBILE_ACTION                        = "/ecs/contract/autoSignForMobile12.jspa";

    /**
     * 发起合同
     */
    public static final String LAUNCHCONTRACT_ACTION                  = "/ecs/contract/launchContract.jspa";
    /**
     * 发起合同带发送短信提醒功能
     */
    public static final String LAUNCHCONTRACT_WITHSHORTMESSAGE_ACTION = "/ecs/contract/launchContractSendSms.jspa";
    /**
     * 发起合同带发送短信提醒功能
     */
    public static final String LAUNCHCONTRACT_AutoSign_SendSms_ACTION = "/ecs/contract/launchContractAutoSignAndSendSms.jspa";

    /**
     * 签署合同
     */
    public static final String SEALCONTRACT_ACTION                    = "/ecs/contract/sealContract.jspa";


    /**
     * 6.5.2 合同文件下载
     */
    public static final String DOWNLOADCONT_ACTION                    = "/ecs/contract/downloadCont.jspa";

    /**
     * 查看存证页
     */
    public static final String VIEW_EVIDENCE                    = "/ecs/contract/viewEvidence.jspa";

    public static final String DOWNLOAD_EVIDENCE_URL            = "/ecs/contract/getDownloadEvidenceUrl.jspa";


    /**
     * 签章合同文档下载
     */
    public static final String DOWNLOADCONTRACT_ACTION  =  "/ecs/contract/downloadContract.jspa ";


    /**
     * 签章合同文档下载
     */
    public static final String DOWNLOADCONTRACTBASE64_ACTION  =  "/ecs/contract/downloadContractBase64.jspa ";


    /**
     * 签章合同文档下载（接收二进制流）
     */
    public static final String DOWNLOADCONTRACTBIN_ACTION                = "/ecs/contract/downloadContractBin.jspa ";
    /**
     * 下载合同证据链
     */
    public static final String DOWNLOADCONTRACT_DETAIL_ACTION         = "/ecs/downContractDetail/getContractDetailByContractIdForPdf.jspa ";

    /**
     * 验签报告
     */
    public static final String GETCONTRACTEVIDENCEURL_ACTION  =  "/ecs/contract/getContractEvidenceUrl.jspa ";

    /**
     * 合同签署动态验证码发送
     */
    public static final String SENDSMS_ACTION                         = "/ecs/contract/sendSms.jspa ";

    /**
     * 用户授权验证签署合同
     */
    public static final String AUTHORIZESIGN_ACTION                   = "/ecs/contract/authorizeSign.jspa ";

    /**
     * 合同作废
     */
    public static final String CANCELCONTRACT_ACTION                  = "/ecs/contract/cancelContract.jspa";

    /**
     * 合同验真：
     */
    public static final String VERIFY_ACTION                          = "/ecs/signCheck/verify.jspa";

    /**
     * 自动生成印章：
     */
    public static final String CREATESEAL_ACTION                      = "/ecs/signInfo/createSeal.jspa";

    /**
     * 自动生成印章：
     */
    public static final String CREATESEALLONG_ACTION                      = "/ecs/signInfo/createSealLong.jspa";

    /**
     * 自动签署合同：根据盖章位置
     */
    public static final String AUTOSIGNBYPOISTION_ACTION              = "/ecs/contract/autoSignByPoistion.jspa";

    public static final String AUTOSIGNBYPOISTION_ACTION_OLD              = "/ecs/contractInfo/autoSignByPoistion.jspa";


    public static final String AUTOSIGNBYPOISTION_ACTION_NOSMS              = "/ecs/contractInfo/autoSignByPoistionNoSms.jspa";

    /**
     * 自动签署合同：根据盖章位置
     */
    public static final String AUTOSIGNBYPOISTIONFORMOBILE12_ACTION              = "/ecs/contract/autoSignByPoistionForMobile12.jspa";

    /**
     * 6.5.1 上传文件创建合同
     */
    public static final String CREATECONTRACT_ACTION                  = "/ecs/contract/createContract.jspa";
    
    
    /**
     * 6.5.1 上传文件创建无效合同
     */
    public static final String CREATEINVALIDCONTRACT_ACTION                  = "/ecs/invalidContract/createinvalidContract.jspa";


    /**
     * 6.6.1 用户身份认证信息
     */
    public static final String IDCARD_ACTION                          = "/ecs/auth/idCard.jspa";

    /**
     * 撤销合同合同其他人未签署，才可以撤回
     */
    public static final String CONTRACTREVOKE_ACTION                  = "/ecs/contract/contractRevoke.jspa";

    /**
     * 退回合同
     */
    public static final String REJECTCONTRACT_ACTION                  = "/ecs/contract/contractRevoke.jspa";

    /**
     * 关键字签章
     */
    public static final String SEALKEYWORD_ACTION                     = "/ecs/seal/sealByKeyword.jspa";

    /**
     *  6.2.5 获取签名/印章
     */
    public static final String GETSIGNIMG_ACTION                         = "/ecs/signInfo/getSignImg.jspa";
    /**
     *  6.2.6 页面手写签名
     */
    public static final String SIGNPAGE_ACTION                         = "/ecs/signApiPage/signPage.jspa";


    // 骑缝章、多页签章
    public static final String MULTIPLESEAL_ACTION                       = "/ecs/seal/multipleSeal.jspa";
    
    // 骑缝章、多页签章-SAAS-API
    public static final String MULTIPLESEAL_SAAS_API_ACTION             = "/ecs/contractInfo/multipleSeal.jspa";
    
    //根据坐标签署-saas-api
    public static final String CONTRACT_AUTOSIGN_API_IMAGE                  = "/ecs/contractInfo/autoSignByPoistion.jspa";
    
    
    // 骑缝章、多页签章 新saas
    public static final String MULTIPLENEWSEAL_ACTION                       = "/ecs/seal/multipleNewSeal.jspa";
    
    // 盖章填图片
    public static final String SEALBRKEYWORD_FORIMAGE_ACTION                = "/ecs/seal/sealByKeywordForImage.jspa";
    
    public static final String CONTRACTINFOTOHTML_ACTION                 ="/ecs/contractToHtml/docUpload.jspa";

    // 电子数据存证
    public static final String SAVE_FILE_HASH_ACTION                       = "/ecs/evidence/saveFile.jspa";
    // PDF增加图片
    public static final String PDF_ADD_IMAGE_ACTION                       = "/ecs/contract/pdfAddImage.jspa";
    // 企业圆形公章
    public static final String GEN_CIRCLE_SEAL_ACTION                       = "/ecs/signApiPage/genCircleSeal.jspa";
    //个人姓名矩形章
    public static final String GEN_PERSON_RECTANGLE_SEAL_ACTION             = "/ecs/signApiPage/genPersonRectangleSeal.jspa";
    //动态生成印章
    public static final String DYN_CIR_SEAL_ACTION                              = "/ecs/signApiPage/dynCirSeal.jspa";
    
    //api用户注册接口
    public static final String API_LOGIN_REGISTER                              = "/ecs/login/register.jspa";

    //生成灰色无效印章
    public static final String GRAY_SEAL_ACTION                              = "/ecs/signApiPage/graySeal.jspa";

    /*
    * Html转PDF
    * */
    public static final String HTML_TO_PDF_ACTION                             = "/ecs/convert/htmlToPdf.jspa";

    /*
    * Html转Word
    * */
    public static final String HTML_TO_WORD_ACTION                             = "/ecs/convert/html2Word.jspa";
 /*
    *pdf 分割 image
    * */
    public static final String PDF_TO_IMAGE_ACTION                             = "/ecs/convert/pdf2Img.jspa";

    /*
     * word转PDF
     * */
    public static final String WORD_TO_PDF_ACTION                               = "/ecs/convert/wordToPdf.jspa";
    /**
     * 三要素识别
     */
    public static final String THREE_ELEMENTS_INDENT                            = "/ecs/face/threeElementsIdentification.jspa";
    
    /**
     * 四要素识别
     */
    public static final String FOUR_ELEMENTS_INDENT                            = "/ecs/face/fourElementsIdentification.jspa";
    
    /**
     * 企业三要素识别
     */
    public static final String BUS_THREE_ELEMENTS_INDENT                            = "/ecs/face/busThreeElementsIdentification.jspa";
    
    /**
     * 二要素识别
     */
    public static final String IDENTITY_AUTH_URL                            = "/ecs/face/identityAuthUrl.jspa";
    /**
     * 活体认证第一步
     */
    public static final String GET_TASKID_URL                             ="/ecs/face/getTaskId.jspa";
    
    /**
     * 活体认证第二步
     */
    public static final String OCR_VERIFY_URL                             ="/ecs/face/ocrVerify.jspa";
    
    /**
     * 活体认证第三步
     */
    public static final String LIVENESS_VERIFY_URL                             ="/ecs/face/livenessVerify.jspa";
    
    
    /**
     * OCR识别
     */
    public static final String ALLOCR_VERIFY_URL                             ="/ecs/face/allOcrVerify.jspa";
    
    
    
    public static final String TENCENT_FACE_URL                             ="/ecs/face/tencentFace.jspa";
    
    public static final String SELECTTENCENT_FACE_URL                             ="/ecs/face/getTencentFace.jspa";
    
    
    /**手写签名*/
    public static final String SIGN_PAGE_URL                             ="/ecs/signApiPage/signPage.jspa";
    
    /**
     * 自动签署合同
     */
    public static final String STATIXTICS_ACTION                        = "/ecs/statistics/getStatisticsTempData.jspa";
    
    public static final String CONTRACTLIST_ACTION                        = "/ecs/statistics/contactList.jspa";
    
    /**
     * 自动签署合同带日期
     */
    public static final String CONTRACT_AUTOSIGN_IMAGE               = "/ecs/contractInfo/autoSignByPoistionForDateImage.jspa";
    
    
    /**
     * 批量签署
     */
    public static final String CONTRACT_BATCHSIGN               = "/ecs/contractInfo/batchSigning.jspa";
    
    /**
     * pdf签署不存服务器
     */
    public static final String CONTRACT_PDFBASE64               = "/ecs/contractInfo/autoSignForPdfBase64.jspa";
    

    public static final String CONTRACT_EVIDENCE               = "/ecs/contractInfo/contractEvidence.jspa";
    
    /*******************************模板组件**************************************************/
    
    /**上传合同**/
    public static final String UPLOAD_CONTRACT               = "/ecs/contractInfo/uploadContract.jspa";
    
    public static final String UPLOAD_CONTRACT_NEW               = "/ecs/contractInfo/uploadContractNew.jspa";
    
    /****上传模板******/
    public static final String UPLOAD_TEMPLATE               = "/ecs/contractInfo/uploadTemplate.jspa";
    
    /******添加组件********/
    public static final String ADD_COMPONENTS               = "/ecs/template/addComponents.jspa";
    
    /******删除组件********/
    public static final String DEL_COMPONENTS               = "/ecs/template/delComponents.jspa";
    
    /******根据模板组件生成合同********/
    public static final String CREATECONTRACT_COMPONENTS     = "/ecs/template/createByTemplateComponents.jspa";
    
    /******上传图片组件********/
    public static final String UPLOAD_IMAGE               = "/ecs/template/uploadImage.jspa";
    
    /******上传文件转换pdf********/
    public static final String UPLOAD_FILE               = "/ecs/template/uploadFile.jspa";
    
    
    /******上传文件URL转换pdf********/
    public static final String UPLOAD_FILE_URL               = "/ecs/template/uploadFileUrl.jspa";
    
    
    /******上传文件Url生成合同********/
    public static final String UPLOAD_CONTRACT_UEL              = "/ecs/contractInfo/uploadContractUrl.jspa";
    
    /******上传文件Url生成模板********/
    public static final String UPLOAD_TEMPLATE_UEL              = "/ecs/contractInfo/uploadTemplateUrl.jspa";
    
    /******获取模板信息********/
    public static final String TEMPLATE_INFO              = "/ecs/contractInfo/getTemplateInfo.jspa";
    
    
    /**
     * 合同作废新
     */
    public static final String CONTRACTCANCEL_ACTION                  = "/ecs/contractInfo/contractCancel.jspa";
    
    
    public static final String CONTRACT_SIGN_ACTION                              = "/ecs/contractInfo/contractSign.jspa";

    public static final String ADD_SIGN_ACTION                              = "/ecs/signApiPage/handWriting.jspa";

    public static final String HAND_ADD_SIGN_ACTION                              = "/ecs/signApiPage/handWritingAddSign.jspa";


    public static final String METHODPOST                             = "post";

    public static final String METHODGET                              = "get";

    public static final String BATCH_SIGNURL              = "/ecs/contractInfo/getSignUrl.jspa";
    public static final String sendMobileSms              = "/ecs/contractInfo/sendMobileSms.jspa";

}
