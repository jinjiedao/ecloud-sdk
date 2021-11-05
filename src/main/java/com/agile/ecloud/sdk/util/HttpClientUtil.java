package com.agile.ecloud.sdk.util;

import java.io.*;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {
    /**
     * 日志处理类
     */
    private static final Logger                logger             = LoggerFactory.getLogger("httpclient");
    
    // 读取超时
    private final static int                   SOCKET_TIMEOUT     = 12000000;
//    private final static int                   SOCKET_TIMEOUT     = 110000;

    // 连接超时 单位毫秒
    private final static int                   CONNECTION_TIMEOUT = 12000000;
    
    // 每个HOST的最大连接数量
    private final static int                   MAX_CONN_PRE_HOST  = 500;
    
    // 连接池的最大连接数
    private final static int                   MAX_CONN           = 500;
    
    // 连接池
    private final static HttpConnectionManager httpConnectionManager;
    
    static {
        httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(CONNECTION_TIMEOUT);
        params.setSoTimeout(SOCKET_TIMEOUT);
        params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);
        params.setMaxTotalConnections(MAX_CONN);
    }
    
    public static String doPost(String url, NameValuePair[] param) {
        logger.debug("post url::" + url);
        // HttpResult<String> result = new HttpResult<String>();
        String result = "";
        PostMethod postMethod = new PostMethod(url);
        HttpClient httpclient = new HttpClient(httpConnectionManager);
        // httpclient.getParams().setContentCharset("UTF-8");
        // httpclient.getParams().setHttpElementCharset("UTF-8");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            // httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            if (param != null) {
                postMethod.setRequestBody(param);
            }
            postMethod.releaseConnection();
            Integer statusCode = httpclient.executeMethod(postMethod);
            logger.debug("post url  statusCode::" + statusCode);
            if (statusCode == 200) {
//                result = postMethod.getResponseBodyAsString();
                inputStream = postMethod.getResponseBodyAsStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while ((result = bufferedReader.readLine()) != null) {
                    stringBuffer.append(result);
                }
                result = stringBuffer.toString();
                System.out.print(result);
            } else if (statusCode == 502) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("code", statusCode);
                map1.put("message", "服务器暂时无法连接，请联系服务人员");
                map.put("meta", map1);
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
            } else if (statusCode == 500) {
                JSONObject.toJSONString(new ECloudDomain(statusCode.toString(), "参数错误，请对照文档查看参数类型", ""));
            } else {
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
                // result.setState(false);
                // result.setErrorCode(statusCode + "");
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
                if(inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            postMethod.releaseConnection();
        }
        // logger.debug("result::" + result);
        return result;
    }
    
    /**
     * 传file文件post
     * 
     * @param url
     * @param param
     * @param file
     * @return
     */
    public static String doPost(String url, NameValuePair[] param, File file) {
        logger.debug("post url::" + url);
        // HttpResult<String> result = new HttpResult<String>();
        String result = "";
        MultipartPostMethod postMethod = new MultipartPostMethod(url);
        HttpClient httpclient = new HttpClient(httpConnectionManager);
        try {
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            
            if (param != null) {
                postMethod.setQueryString(param);
            }
            
            postMethod.addParameter("file", file.getName(), file);
            
//            postMethod.addParameter("file", file);
//            ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8); 
//            Part part = new FilePart("file", file, "application/x-www-form-urlencoded", "UTF-8");
//            postMethod.addPart(part);
            httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            Integer statusCode = httpclient.executeMethod(postMethod);
            logger.debug("post url  statusCode::" + statusCode);
            if (statusCode == 200) {
                result = postMethod.getResponseBodyAsString();
            } else if (statusCode == 502) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("code", statusCode);
                map1.put("message", "服务器暂时无法连接，请联系服务人员");
                map.put("meta", map1);
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
            } else if (statusCode == 500) {
                JSONObject.toJSONString(new ECloudDomain(statusCode.toString(), "参数错误，请对照文档查看参数类型", ""));
            } else {
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
                // result.setState(false);
                // result.setErrorCode(statusCode + "");
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            postMethod.releaseConnection();
        }
        // logger.debug("result::" + result);
        return result;
    }
    
    /**
     * 发送主要方法,异常捕获
     * 
     * @param post
     * @param code
     * @return
     */
    public static String doHttpRequest(PostMethod post, String code) {
        HttpClient httpClient = new HttpClient(httpConnectionManager);
        resetRequestHeader(httpClient, "10.0.23.178");
        // 设置读取超时时间(单位毫秒)
        // httpClient.getParams().setParameter("http.socket.timeout",socket_timeout);
        // 设置连接超时时间(单位毫秒)
        // httpClient.getParams().setParameter("http.connection.timeout",connection_timeout);
        // httpClient.getParams().setParameter("http.connection-manager.timeout",100000000L);
        BufferedReader in = null;
        String resultString = "";
        try {
            httpClient.executeMethod(post);
            in = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream(), code));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            resultString = buffer.toString();
        } catch (SocketTimeoutException e) {
            logger.info("连接超时" + e.toString());
            // throw new CustomException(
            // TmallConstants.TmallExceptionType.CONNECTION_EXCEPTION,
            // "连接超时:" + e.getMessage(), e);
            resultString = returnError("连接超时");
        } catch (HttpException e) {
            logger.info("读取外部服务器数据失败" + e.toString());
            // throw new CustomException(
            // TmallConstants.TmallExceptionType.SOCKET_EXCEPTION,
            // "读取天猫服务器数据失败:" + e.getMessage(), e);
            resultString = returnError("读取外部服务器数据失败");
        } catch (UnknownHostException e) {
            logger.info("请求的主机地址无效" + e.toString());
            // throw new CustomException(
            // TmallConstants.TmallExceptionType.CONNECTION_EXCEPTION,
            // "请求的主机地址无效：" + e.getMessage(), e);
            resultString = returnError("请求的主机地址无效");
        } catch (IOException e) {
            logger.info("向外部接口发送数据失败" + e.toString());
            // throw new CustomException(
            // TmallConstants.TmallExceptionType.INNER_EXCEPTION,
            // "向天猫发送数据失败", e);
            resultString = returnError("向外部接口发送数据失败");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            post.releaseConnection();
        }
        return resultString;
    }
    
    /**
     * 传file文件post
     * 
     * @param url
     * @param param
     * @param file
     * @return
     */
    public static String doPost(String url, NameValuePair[] param, Map<String, File> files) {
        logger.debug("post url::" + url);
        // HttpResult<String> result = new HttpResult<String>();
        String result = "";
        MultipartPostMethod postMethod = new MultipartPostMethod(url);
        HttpClient httpclient = new HttpClient(httpConnectionManager);
        try {
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            if (param != null) {
                postMethod.setQueryString(param);
            }
            
            for (Map.Entry<String, File> entry : files.entrySet()) {
                postMethod.addParameter(entry.getKey().toString(), entry.getValue());
            }
            
            httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            Integer statusCode = httpclient.executeMethod(postMethod);
            logger.debug("post url  statusCode::" + statusCode);
            if (statusCode == 200) {
                result = postMethod.getResponseBodyAsString();
            } else if (statusCode == 502) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("code", statusCode);
                map1.put("message", "服务器暂时无法连接，请联系服务人员");
                map.put("meta", map1);
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
            } else if (statusCode == 500) {
                JSONObject.toJSONString(new ECloudDomain(statusCode.toString(), "参数错误，请对照文档查看参数类型", ""));
            } else {
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
                // result.setState(false);
                // result.setErrorCode(statusCode + "");
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            postMethod.releaseConnection();
        }
        // logger.debug("result::" + result);
        return result;
    }
    
    /**
     * 传file文件post
     * 
     * @param url
     * @param param
     * @param file
     * @return
     */
    public static String doPostBytes(String url, NameValuePair[] param, Map<String, byte[]> files) {
        logger.debug("post url::" + url);
        // HttpResult<String> result = new HttpResult<String>();
        String result = "";
        MultipartPostMethod postMethod = new MultipartPostMethod(url);
        HttpClient httpclient = new HttpClient(httpConnectionManager);
        try {
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            if (param != null) {
                postMethod.setQueryString(param);
            }
            
            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
            	ByteArrayPartSource partSource = new ByteArrayPartSource(entry.getKey().toString(), entry.getValue() );
            	Part filePart = new FilePart(entry.getKey().toString(), partSource);
                postMethod.addPart(filePart);
            }
            
            httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            Integer statusCode = httpclient.executeMethod(postMethod);
            logger.debug("post url  statusCode::" + statusCode);
            if (statusCode == 200) {
                result = postMethod.getResponseBodyAsString();
            } else if (statusCode == 502) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("code", statusCode);
                map1.put("message", "服务器暂时无法连接，请联系服务人员");
                map.put("meta", map1);
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
            } else if (statusCode == 500) {
                JSONObject.toJSONString(new ECloudDomain(statusCode.toString(), "参数错误，请对照文档查看参数类型", ""));
            } else {
                result = ClassUtil.returnStatusCodeMsg("服务器暂时无法连接，请联系服务人员", statusCode);
                // result.setState(false);
                // result.setErrorCode(statusCode + "");
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            postMethod.releaseConnection();
        }
        // logger.debug("result::" + result);
        return result;
    }
    
    /**
     * 设置一下返回错误的通用提示,可以自定义格式.
     * 
     * @param reason
     * @return
     */
    public static String returnError(String reason) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
        buffer.append("<Response>");
        buffer.append("<Success>false</Success>");
        buffer.append("<reason>");
        buffer.append(reason);
        buffer.append("</reason>");
        buffer.append("</Response>");
        return buffer.toString();
    }
    
    public final static String REQUEST_HEADER = "x-forwarded-for";
    
    /**
     * 将客户IP写入请求头 这个设置可以伪装IP请求,注意使用
     * 
     * @param client
     * @param ip
     * @return
     */
    public static void resetRequestHeader(HttpClient client, String ip) {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header(REQUEST_HEADER, ip));
        client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
    }
    
}
