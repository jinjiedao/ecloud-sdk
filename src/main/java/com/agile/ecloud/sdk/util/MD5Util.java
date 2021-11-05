package com.agile.ecloud.sdk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class MD5Util {

    /** 十六进制数字字符数组 */
    private static final char[] HEX_DIGIT = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f' };

    /**
     * 对给定的字符串进行MD5变换
     * 
     * @param src
     *            要进行MD5变换的字符串
     * @return 变换后的十六进制ASCII表示结果
     * @throws RuntimeException
     *             如果当前JDK中不存在MD5变换算法，抛出运行时异常�?
     */
    public static String MD5(String src) {
        if (src == null)
            return null;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }

        StringBuffer sb = new StringBuffer();
        byte[] b = md.digest(src.getBytes());
        for (int i = 0, m = b.length; i < m; i++) {
            sb.append(HEX_DIGIT[(b[i] >>> 4) & 0X0F]);
            sb.append(HEX_DIGIT[b[i] & 0X0F]);
        }
        return sb.toString();
    }

    /**
     * 
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encode(final String password) {
        byte[] digest;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            digest = md5.digest(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported!");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 not supported!");
        }
        return new String(Hex.encodeHex(digest));
    }
}
