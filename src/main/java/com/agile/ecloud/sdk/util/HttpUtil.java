package com.agile.ecloud.sdk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger("httpclient");

    private static final String default_charaset = "utf-8";

    private static final int default_connect_timeout = 10000;

    private static final int default_socket_timeout = 10000;

    // 每个HOST的最大连接数量
    private final static int MAX_CONN_PRE_HOST = 20;

    // 连接池的最大连接数
    private final static int MAX_CONN = 60;

    private static final int default_retries = 1;

    private final static HttpConnectionManager httpConnectionManager;

    static {
        httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(default_connect_timeout);
        params.setSoTimeout(default_socket_timeout);
        params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);
        params.setMaxTotalConnections(MAX_CONN);
    }

    private static HttpClient makeHttpClient(int socketTimeout, int connectTimeout, int retries, String charset) {
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = client.getParams();
        clientParams.setParameter("http.socket.timeout", socketTimeout);
        clientParams.setParameter("http.connection.timeout", connectTimeout);
        // connection建立超时
        clientParams.setParameter("http.connection-manager.timeout", new Long(socketTimeout));
        clientParams.setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler(retries, false)); // 如果Http出错，三次重�?

        clientParams.setContentCharset(charset);// 设置请求编码
        return client;
    }

    public static String postByForm(String url, Map<String, String> params, int connectTimeout, int socketTimeout,
            int retries, String charset) throws Exception {
        HttpClient client = makeHttpClient(connectTimeout, socketTimeout, retries, charset);
        PostMethod post = new PostMethod(url);
        String jsonStr = "";
        InputStream ins = null;
        try {
            post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);

            if (params != null && !params.isEmpty()) {
                NameValuePair[] paramsPair = new NameValuePair[params.size()];
                Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();// 采用高效遍历�?
                int i = 0;
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                    NameValuePair jsonArry = new NameValuePair(entry.getKey(), entry.getValue());
                    paramsPair[i] = jsonArry;
                    i = i + 1;
                }
                post.setRequestBody(paramsPair);
            }
            int status = client.executeMethod(post);
            if (status == HttpStatus.SC_OK) {
                jsonStr = post.getResponseBodyAsString();
            } else {
                post.abort();// 断连�?
            }
            logger.info("url:" + url + ",post," + status);
        } catch (Exception e) {
            throw e;// 错误日志在调用层根据类型记录
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (null != post) {
                post.releaseConnection();
            }
        }
        return jsonStr;
    }

    /**
     * set encoding for params, Do Not use URLEncode.encode() when invoke this
     * method.
     * 
     * @param url
     * @param params
     * @param connectTimeout
     * @param socketTimeout
     * @param retries
     * @param charset
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> params, int connectTimeout, int socketTimeout,
            int retries, String charset, String cookie) throws Exception {
        HttpClient client = new HttpClient(httpConnectionManager);

        // Protocol myhttps = new Protocol("https", new
        // MySSLProtocolSocketFactory(), 443);
        // Protocol.registerProtocol("https", myhttps);

        PostMethod post = new PostMethod(url);
        if (cookie != null) {
            client.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
            post.setRequestHeader("cookie", cookie);
        }

        String jsonStr = "";
        InputStream ins = null;
        int status = 201;
        try {
            // post.setRequestHeader("Content-Type",
            // "application/x-www-form-urlencoded; charset=utf-8");
            post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            // post.setRequestHeader("Content-type", "text/html;charset=" +
            // charset);
            if (params != null && !params.isEmpty()) {
                NameValuePair[] paramsPair = new NameValuePair[params.size()];
                Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();// 采用高效遍历�?
                int i = 0;
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                    NameValuePair jsonArry = new NameValuePair(entry.getKey(), entry.getValue());
                    paramsPair[i] = jsonArry;
                    i = i + 1;
                }
                post.setQueryString(paramsPair);
            }
            if (params.get("file") != null) {
                FilePart fp = new FilePart("file", new File(params.get("file")));
                MultipartRequestEntity mrp = new MultipartRequestEntity(new Part[] { fp }, post.getParams());
                post.setRequestEntity(mrp);
            }

            status = client.executeMethod(post);
            if (status == HttpStatus.SC_OK) {
                if (post.getURI().toString().contains("?key")) {
                    byte[] imgByte = post.getResponseBody();
                    jsonStr = new sun.misc.BASE64Encoder().encode(imgByte);
                } else {
                    jsonStr = post.getResponseBodyAsString();
                }
            } else {
                post.abort();// 断连�?
            }
            logger.info("url:" + url + ",post," + status);
        } catch (Exception e) {
            throw e;// 错误日志在调用层根据类型记录
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (null != post) {
                post.releaseConnection();
            }
        }
        if (status != 200) {
            // return new ECloudDomain("201", "", null);
        }
        return jsonStr;
        // return jsonStr;
    }

    public static String post(String url, Map<String, String> params, String cookie) throws Exception {
        return post(url, params, default_connect_timeout, default_socket_timeout, default_retries, default_charaset,
                cookie);
    }

    public static String post(String url, Map<String, String> params, String cookie, MultipartPostMethod method)
            throws Exception {
        return post(url, params, default_connect_timeout, default_socket_timeout, default_retries, default_charaset,
                cookie, method);
    }

    /**
     * set encoding for params, Do Not use URLEncode.encode() when invoke this
     * method.
     * 
     * @param url
     * @param params
     * @param connectTimeout
     * @param socketTimeout
     * @param retries
     * @param charset
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> params, int connectTimeout, int socketTimeout,
            int retries, String charset, String cookie, MultipartPostMethod method) throws Exception {
        HttpClient client = makeHttpClient(connectTimeout, socketTimeout, retries, charset);
        MultipartPostMethod post = new MultipartPostMethod(url);
        String jsonStr = "";
        InputStream ins = null;
        try {
            post.addRequestHeader("Content-type", "multipart/form-data;text/html;charset=" + charset);

            String filePath = params.get("file");
            // params.remove("file");
            post.addParameter("file", new File(filePath));
            // 由于要上传的文件可能比较�?因此在此设置�?��的连接超时时�?
            client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            // int status = client.executeMethod(filePost);
            if (cookie != null) {
                client.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
                post.setRequestHeader("cookie", cookie);
            }

            if (params != null && !params.isEmpty()) {
                NameValuePair[] paramsPair = new NameValuePair[params.size()];
                Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();// 采用高效遍历�?
                int i = 0;
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                    NameValuePair jsonArry = new NameValuePair(entry.getKey(), entry.getValue());
                    paramsPair[i] = jsonArry;
                    i = i + 1;
                }
                post.setQueryString(paramsPair);
            }
            int status = client.executeMethod(post);
            if (status == HttpStatus.SC_OK) {
                if (post.getURI().toString().contains("?key")) {
                    byte[] imgByte = post.getResponseBody();
                    jsonStr = new sun.misc.BASE64Encoder().encode(imgByte);
                } else {
                    jsonStr = post.getResponseBodyAsString();
                }
            } else {
                post.abort();// 断连�?
            }
            logger.info("url:" + url + ",post," + status);
        } catch (Exception e) {
            throw e;// 错误日志在调用层根据类型记录
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (null != post) {
                post.releaseConnection();
            }
        }
        return jsonStr;
    }

    /**
     * 如果是中文，必须对参数进行编码才能传进来
     * 
     * @param url
     * @param path
     * @param headers
     * @param paramsMap
     * @param connectTimeout
     * @param socketTimeout
     * @param retries
     * @param charset
     * @return
     * @throws Exception
     */
    public static String get(String url, Map<String, String> headers, Map<String, String> paramsMap,
            int connectTimeout, int socketTimeout, int retries, String charset, String cookie) throws Exception {
        HttpClient client = makeHttpClient(connectTimeout, socketTimeout, retries, charset);

        if (paramsMap != null && !paramsMap.isEmpty()) {
            Set<String> it = paramsMap.keySet();
            for (String key : it) {
                String value = paramsMap.get(key);
                if (url.contains("?"))
                    url += "&";
                else
                    url += "?";
                url += key + "=" + value;
            }
        }

        GetMethod getMethod = new GetMethod(url);
        if (cookie != null) {
            client.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
            getMethod.setRequestHeader("cookie", cookie);
        }

        getMethod.addRequestHeader("Content-type", "text/html;charset=" + charset);
        if (headers != null && !headers.isEmpty()) {
            Iterator<Map.Entry<String, String>> iter = headers.entrySet().iterator();// 采用高效遍历�?
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                getMethod.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }

        String jsonStr = "";
        InputStream ins = null;
        try {
            int status = client.executeMethod(getMethod);
            if (status == HttpStatus.SC_OK) {
                // 判断如果是GZIP格式则进行解�?
                if (null != getMethod.getResponseHeader("Content-Encoding")) {
                    if (getMethod.getResponseHeader("Content-Encoding").getValue().trim().equalsIgnoreCase("gzip")) {
                        ins = getMethod.getResponseBodyAsStream();
                        jsonStr = uncompress(ins, default_charaset);
                    } else {
                        jsonStr = getMethod.getResponseBodyAsString();
                    }
                } else {
                    // InputStream respStream =
                    // getMethod.getResponseBodyAsStream();

                    if (getMethod.getURI().toString().contains("?key")) {
                        byte[] imgByte = getMethod.getResponseBody();
                        jsonStr = new sun.misc.BASE64Encoder().encode(imgByte);
                    } else {
                        jsonStr = getMethod.getResponseBodyAsString();
                    }

                }
                // responseJson = JSONObject.fromObject(jsonStr);
                // responseJson.put("code", status);
            } else {
                getMethod.abort();// 断连�?
            }
            logger.info("url:" + url + ",get," + status);
        } catch (Exception e) {
            throw e;// 错误日志在调用层根据类型记录
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (null != getMethod) {
                getMethod.releaseConnection();
            }
        }
        return jsonStr;
    }
    
    
    /**
     * 如果是中文，必须对参数进行编码才能传进来
     * 
     * @param url
     * @param path
     * @param headers
     * @param paramsMap
     * @param connectTimeout
     * @param socketTimeout
     * @param retries
     * @param charset
     * @return
     * @throws Exception
     */
    public static String getObject(String url, Map<String, String> headers, Map<String, Object> paramsMap,
            int connectTimeout, int socketTimeout, int retries, String charset, String cookie) throws Exception {
        HttpClient client = makeHttpClient(connectTimeout, socketTimeout, retries, charset);

        if (paramsMap != null && !paramsMap.isEmpty()) {
            Set<String> it = paramsMap.keySet();
            for (String key : it) {
                String value = paramsMap.get(key).toString();
                if (url.contains("?"))
                    url += "&";
                else
                    url += "?";
                url += key + "=" + value;
            }
        }

        GetMethod getMethod = new GetMethod(url);
        if (cookie != null) {
            client.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
            getMethod.setRequestHeader("cookie", cookie);
        }

        getMethod.addRequestHeader("Content-type", "text/html;charset=" + charset);
        if (headers != null && !headers.isEmpty()) {
            Iterator<Map.Entry<String, String>> iter = headers.entrySet().iterator();// 采用高效遍历�?
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                getMethod.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }

        String jsonStr = "";
        InputStream ins = null;
        try {
            int status = client.executeMethod(getMethod);
            if (status == HttpStatus.SC_OK) {
                // 判断如果是GZIP格式则进行解�?
                if (null != getMethod.getResponseHeader("Content-Encoding")) {
                    if (getMethod.getResponseHeader("Content-Encoding").getValue().trim().equalsIgnoreCase("gzip")) {
                        ins = getMethod.getResponseBodyAsStream();
                        jsonStr = uncompress(ins, default_charaset);
                    } else {
                        jsonStr = getMethod.getResponseBodyAsString();
                    }
                } else {
                    // InputStream respStream =
                    // getMethod.getResponseBodyAsStream();

                    if (getMethod.getURI().toString().contains("?key")) {
                        byte[] imgByte = getMethod.getResponseBody();
                        jsonStr = new sun.misc.BASE64Encoder().encode(imgByte);
                    } else {
                        jsonStr = getMethod.getResponseBodyAsString();
                    }

                }
                // responseJson = JSONObject.fromObject(jsonStr);
                // responseJson.put("code", status);
            } else {
                getMethod.abort();// 断连�?
            }
            logger.info("url:" + url + ",get," + status);
        } catch (Exception e) {
            throw e;// 错误日志在调用层根据类型记录
        } finally {
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
            }
            if (null != getMethod) {
                getMethod.releaseConnection();
            }
        }
        return jsonStr;
    }
    

    // public static String get(String url, Map<String, String> params, String
    // charset) throws Exception {
    // return get(url, null, null, default_connect_timeout,
    // default_socket_timeout, default_retries, charset);
    // }

    public static String get(String url, Map<String, String> params, String cookie) throws Exception {
        return get(url, null, params, cookie);
    }
    
    public static String getObject(String url, Map<String, Object> params, String cookie) throws Exception {
        return getObejct(url, null, params, cookie);
    }

    public static String get(String url, Map<String, String> params, int timeout) throws Exception {
        return get(url, null, params, timeout, timeout, default_retries, default_charaset, null);
    }

    /**
     * @return
     */
    public static String get(String url, Map<String, String> headers, Map<String, String> paramsMap, String cookie)
            throws Exception {
        return get(url, headers, paramsMap, default_connect_timeout, default_socket_timeout, default_retries,
                default_charaset, cookie);
    }
    
    /**
     * @return
     */
    public static String getObejct(String url, Map<String, String> headers, Map<String, Object> paramsMap, String cookie)
            throws Exception {
        return getObject(url, headers, paramsMap, default_connect_timeout, default_socket_timeout, default_retries,
                default_charaset, cookie);
    }

    public static String uncompress(InputStream in, String charset) throws IOException {
        GZIPInputStream gInputStream = new GZIPInputStream(in);
        byte[] by = new byte[1024];
        StringBuffer strBuffer = new StringBuffer();
        int len = 0;
        while ((len = gInputStream.read(by)) != -1) {
            strBuffer.append(new String(by, 0, len, charset));
        }
        return strBuffer.toString();
    }

    /*
     * GZIP压缩字符�?
     */
    public static String compressStr(String str, String charset) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes(charset));
        gzip.close();
        return out.toString("ISO-8859-1");
    }

    /*
     * GZIP解压字符�?
     */
    public static String uncompressStr(String str, String charset) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString(charset);
    }

}
