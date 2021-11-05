package com.agile.ecloud.sdk.util;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import javax.servlet.ServletInputStream;

public class ClassUtil {
    // private static Map<String, Object> params;

    public static Map<String, Object> toMap(String[] keys, Object... values) {
        Map<String, Object> params = new HashMap<String, Object>();
        /*
         * if(params == null){ params = new HashMap<String,Object>(); } else{
         * params.clear(); }
         */
        if (keys.length == values.length) {

            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                Object value = values[i];
                params.put(key, value);
            }
        } else if (keys.length == 1) {
            params.put(keys[0], values);
        } else {
            try {
                throw new Exception("key和value的个数不一致，无法转成map格式");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }

//    public static String requestToJson(ServletInputStream inStream) {
//        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//        String result = null;
//        try {
//            byte[] buff = new byte[8192]; // buff用于存放循环读取的临时数据
//            int rc = 0;
//            while ((rc = inStream.read(buff, 0, 1024)) > 0) {
//                swapStream.write(buff, 0, rc);
//            }
//            byte[] in_b = swapStream.toByteArray(); // in_b为转换之后的结果?
//            String payload = new String(in_b);
//            System.out.println(payload);
//            result = payload.substring(payload.indexOf(":") + 1, payload.length() - 1);
//            if (result.startsWith("{")) {
//                result = "[" + result + "]";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                swapStream.flush();
//                swapStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return result;
//    }

    public static String string2json(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '/':
                sb.append("\\/");
                break;
            default:
                if (ch >= '\u0000' && ch <= '\u001F') {
                    String ss = Integer.toHexString(ch);
                    sb.append("\\u");
                    for (int k = 0; k < 4 - ss.length(); k++) {
                        sb.append('0');
                    }
                    sb.append(ss.toUpperCase());
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /**
     * <p>
     * Checks if a String is whitespace, empty ("") or null.
     * </p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

//    public static ECloudDomain returnECloudDomain(String paramname, String code) {
//        return new ECloudDomain("201", paramname + "不能为空", "");
//    }
    public static ECloudDomain returnECloudDomain(String code, String paramname) {
        return new ECloudDomain(code, paramname , "");
    }

    public static String returnStatusCodeMsg(String codeMsg, Integer code) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("code", code);
        map1.put("message", codeMsg);
        map.put("meta", map1);
        String result = JSONObject.toJSONString(map);
        return result;
    }
}
