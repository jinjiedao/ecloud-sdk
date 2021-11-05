package com.agile.ecloud.sdk.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * HttpsClient is for HTTPS connection, this connection used for getting message
 * from weixin server
 * 
 * @author
 *
 */
@SuppressWarnings({ "finally" })
public class HttpsClient {
	private static ThreadLocal<CloseableHttpClient> threadHttpsClient = new ThreadLocal<CloseableHttpClient>();
	private static ThreadLocal<HttpPost> threadPost = new ThreadLocal<HttpPost>();
	private static ThreadLocal<HttpGet> threadGet = new ThreadLocal<HttpGet>();
	private static ThreadLocal<HttpPut> threadPut = new ThreadLocal<HttpPut>();
	private static ThreadLocal<StringBuilder> threadStringBuilder = new ThreadLocal<StringBuilder>();

	private static String NL = System.getProperty("line.separator");

	public static String doGet(String url) {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;

		// 实例化HTTP方法
		HttpGet httpGet = getGetMethod();
		try {
			// 定义HttpClient
			CloseableHttpClient client = getSSLClient();
			httpGet.setURI(URI.create(url));
			response = client.execute(httpGet);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder sb = getStringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			respBody = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpGet.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	/**
	 * 添加post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @author
	 */
	// JSONObject jsonObject
	public static String doPost(String url, List<NameValuePair> params) {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;
		// HttpPost httpPost = new HttpPost(url);//post方式
		HttpPost httpPost = getPostMethod();
		try {

			// 定义HttpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 实例化HTTP方法
			httpPost.setURI(URI.create(url.trim()));

			httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			// httpPost.setEntity(new StringEntity(jsonObject.toString(),"utf-8"));

			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			response = client.execute(httpPost);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder sb = getStringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			respBody = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpPost.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	public static String doPostFile(String url, List<NameValuePair> params, File file) {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// 把一个普通参数和文件上传给下面这个api接口
			HttpPost httpPost = new HttpPost(url);
			// 设置传输参数,设置编码。设置浏览器兼容模式，解决文件名乱码问题
			MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
			FileBody fundFileBin = new FileBody(file, ContentType.MULTIPART_FORM_DATA);

			// 相当于<input type="file" name="media"/>
			multipartEntity.addPart("file", fundFileBin);
			// 把文件转换成流对象FileBody
			// Set<String> keySet = params.keySet();

			for (NameValuePair nameValuePair : params) {
				ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));
				StringBody stringBody = new StringBody(nameValuePair.getValue(), contentType);
				multipartEntity.addPart(nameValuePair.getName(), stringBody);
			}

			HttpEntity reqEntity = multipartEntity.build();
			httpPost.setEntity(reqEntity);
			// 发起请求 并返回请求的响应
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuilder sb = getStringBuilder();
				String line = "";
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
				respBody = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return respBody;

	}

	/**
	 * 添加post请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @author
	 */
	public static String doPostWxCode(String url, Map params) {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;
		HttpPost httpPost = getPostMethod();
		try {
			// 定义HttpClient
			CloseableHttpClient client = getSSLClient();
			// 实例化HTTP方法
			httpPost.setURI(URI.create(url));
			StringEntity se = new StringEntity(JSON.toJSONString(params), "UTF-8");
			httpPost.setEntity(se);
			response = client.execute(httpPost);

			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			byte[] bytes = InputStreamToByte(content);
			respBody = Base64.encodeBase64String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpPost.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	/**
	 * 输入流转字节流
	 */
	private static byte[] InputStreamToByte(InputStream in) throws IOException {
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int ch;
		while ((ch = in.read(buffer)) != -1) {
			bytestream.write(buffer, 0, ch);
		}
		byte data[] = bytestream.toByteArray();
		bytestream.close();
		return data;
	}

	public static String doAuthGet(String url, String requestJson, String Authorization) {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;

		// 实例化HTTP方法
		HttpGet httpGet = getGetMethod();
		try {
			// 定义HttpClient
			CloseableHttpClient client = getSSLClient();
			httpGet.setURI(URI.create(url));
			httpGet.setHeader("Authorization", Authorization);
			httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
			response = client.execute(httpGet);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder sb = getStringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			respBody = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpGet.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	public static String doAuthPost(String url, String requestJson, String Authorization) throws Exception {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;
		HttpPost httpPost = getPostMethod();
		try {
			// 定义HttpClient
			CloseableHttpClient client = getSSLClient();
			// 实例化HTTP方法
			httpPost.setURI(URI.create(url));
			httpPost.setHeader("Authorization", Authorization);
			httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
			StringEntity se = new StringEntity(requestJson, "UTF-8");
			httpPost.setEntity(se);
			response = client.execute(httpPost);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder sb = getStringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			respBody = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpPost.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	public static String doAuthPut(String url, String requestJson, String Authorization) throws Exception {
		BufferedReader in = null;
		String respBody = null;
		CloseableHttpResponse response = null;
		HttpPut httpPut = getPutMethod();
		try {
			// 定义HttpClient
			CloseableHttpClient client = getSSLClient();
			// 实例化HTTP方法
			httpPut.setURI(URI.create(url));
			httpPut.setHeader("Authorization", Authorization);
			httpPut.setHeader("Content-Type", "application/json;charset=utf-8");
			StringEntity se = new StringEntity(requestJson, "UTF-8");
			httpPut.setEntity(se);
			response = client.execute(httpPut);

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuilder sb = getStringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			respBody = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();// 最后要关闭BufferedReader
				}
				if (response != null) {
					response.close();
				}
				httpPut.abort();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return respBody;
		}
	}

	private static CloseableHttpClient getSSLClient() {
		CloseableHttpClient client = threadHttpsClient.get();
		if (client == null) {
			try {
				javax.net.ssl.SSLContext sslContext = new SSLContextBuilder()
						.loadTrustMaterial(null, new TrustStrategy() {
							// 信任所有
							@Override
							public boolean isTrusted(X509Certificate[] chain, String authType)
									throws CertificateException {
								return true;
							}
						}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
				client = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			client = HttpClients.createDefault();
			threadHttpsClient.set(client);
		}
		return client;
	}

	private static HttpPost getPostMethod() {
		HttpPost post = threadPost.get();
		if (post == null) {
			post = new HttpPost();
			threadPost.set(post);
		}
		post.reset();
		return post;
	}

	private static HttpGet getGetMethod() {
		HttpGet get = threadGet.get();
		if (get == null) {
			get = new HttpGet();
			threadGet.set(get);
		}
		get.reset();
		return get;
	}

	private static HttpPut getPutMethod() {
		HttpPut put = threadPut.get();
		if (put == null) {
			put = new HttpPut();
			threadPut.set(put);
		}
		put.reset();
		return put;
	}

	private static StringBuilder getStringBuilder() {
		StringBuilder strBuilder = threadStringBuilder.get();
		if (strBuilder == null) {
			strBuilder = new StringBuilder();
			threadStringBuilder.set(strBuilder);
		}
		if (strBuilder.length() > 0) {
			strBuilder.delete(0, strBuilder.length());
		}
		return strBuilder;
	}

	// private static HttpPost postForm(String url, Map<String, String> params) {
	// HttpPost httpost = new HttpPost(url);
	// StringEntity se = new StringEntity(JSONObject.toJSONString(params), "UTF-8");
	// httpost.setEntity(se);
	// return httpost;
	// }

	// public static InputStream doGetImg(String url)
	// {
	// try
	// {
	// // 定义HttpClient
	// CloseableHttpClient client = HttpsClient.getInstance();
	// // 实例化HTTP方法
	// HttpGet request = new HttpGet();
	// request.setURI(new URI(url));
	// HttpResponse response = client.execute(request);
	// return response.getEntity().getContent();
	// }
	// catch (ClientProtocolException e)
	// {
	// e.printStackTrace();
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	// catch (URISyntaxException e)
	// {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }
	//
	// /**
	// * 添加post请求
	// *
	// * @param url
	// * @param params
	// * @return
	// * @author
	// */
	//
	// public static String doPost(String url, List<Map> params)
	// {
	// BufferedReader in = null;
	// String respBody = null;
	// CloseableHttpResponse response = null;
	//
	// try
	// {
	// // 定义HttpClient
	// CloseableHttpClient client = HttpsClient.getInstance();
	// // 实例化HTTP方法
	// HttpPost request = postForm(url, params);
	// request.setHeader("Content-Type", "application/json;charset=utf-8");
	// response = client.execute(request);
	//
	// in = new BufferedReader(new
	// InputStreamReader(response.getEntity().getContent()));
	// StringBuffer sb = new StringBuffer("");
	// String line = "";
	// String NL = System.getProperty("line.separator");
	// while ((line = in.readLine()) != null)
	// {
	// sb.append(line + NL);
	// }
	// in.close();
	// respBody = sb.toString();
	// }
	// finally
	// {
	// try
	// {
	// if(in != null) in.close();// 最后要关闭BufferedReader
	// if(response != null) response.close();
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// return respBody;
	// }
	// }
	//
	// /**
	// * 添加post请求
	// *
	// * @param url
	// * @param params
	// * @return
	// * @author
	// */
	// public static String doPostJson(String url, Map<String, Object> params)
	// {
	// BufferedReader in = null;
	// String respBody = null;
	// CloseableHttpResponse response = null;
	//
	// try
	// {
	// // 定义HttpClient
	// CloseableHttpClient client = HttpsClient.getInstance();
	// // 实例化HTTP方法
	// HttpPost httpost = new HttpPost(url);
	// StringEntity se = new StringEntity(JSONObject.toJSONString(params), "UTF-8");
	// httpost.setEntity(se);
	// HttpPost request = httpost;
	// request.setHeader("Content-Type", "application/json;charset=utf-8");
	// response = client.execute(request);
	//
	// in = new BufferedReader(new
	// InputStreamReader(response.getEntity().getContent()));
	// StringBuffer sb = new StringBuffer("");
	// String line = "";
	// String NL = System.getProperty("line.separator");
	// while ((line = in.readLine()) != null)
	// {
	// sb.append(line + NL);
	// }
	// in.close();
	// respBody = sb.toString();
	// }
	// finally
	// {
	// try
	// {
	// if(in != null) in.close();// 最后要关闭BufferedReader
	// if(response != null) response.close();
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// return respBody;
	// }
	// }

	// private static HttpPost postForm(String url, List<Map> params)
	// {
	// HttpPost httpost = new HttpPost(url);
	// StringEntity se = new StringEntity(JSONObject.toJSONString(params), "UTF-8");
	// httpost.setEntity(se);
	// return httpost;
	// }
}
