package com.agile.ecloud.sdk.util;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.AccessController;
import java.security.PrivilegedAction;

import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUtil {

    /**
     * ���ļ�ת��base64 �ַ�
     * 
     * @param path
     *            path�ļ�·��
     * @return *
     * @throws Exception
     */

    public static String encodeBase64File(String path) throws Exception {
        byte[] buffer = toByteArray3(path);
        return new BASE64Encoder().encode(buffer);

    }

    public static long getSize(String sFileName) {

        long lSize = 0;

        try {
            File f = new File(sFileName);

            // exist
            if (f.exists()) {
                if (f.isFile() && f.canRead()) {
                    lSize = f.length();
                } else {
                    lSize = -1;
                }
                // not exist
            } else {
                lSize = 0;
            }
        } catch (Exception e) {
            lSize = -1;
        }
        /* return */
        return lSize;
    }
    
    /**
     * ��base64�ַ���뱣���ļ�
     * 
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        if (out != null) {
            out.close();
        }

    }

    /**
     * ��base64�ַ���ı��ļ�
     * 
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static void toFile(String base64Code, String targetPath) throws Exception {

        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * Mapped File way MappedByteBuffer �����ڴ�����ļ�ʱ����������
     * 
     * @param filename
     * @return
     * @throws IOException
     */
    private static byte[] toByteArray3(String filename) throws IOException {

        FileChannel fc = null;
        MappedByteBuffer byteBuffer = null;
        try {
            fc = new RandomAccessFile(filename, "r").getChannel();
            byteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();

            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {

                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fc != null) {
                try {
                    fc.close();
                    // �ͷ��ļ�
                    clean(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int ByteIndexOf(byte[] searched, byte[] find, int start) {
        boolean matched = false;
        int end = find.length - 1;
        int skip = 0;
        for (int index = start; index <= searched.length - find.length; ++index) {
            matched = true;
            if (find[0] != searched[index] || find[end] != searched[index + end])
                continue;
            else
                skip++;
            if (end > 10)
                if (find[skip] != searched[index + skip] || find[end - skip] != searched[index + end - skip])
                    continue;
                else
                    skip++;
            for (int subIndex = skip; subIndex < find.length - skip; ++subIndex) {
                if (find[subIndex] != searched[index + subIndex]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return index;
            }
        }
        return -1;
    }

    /**
     * ����MappedByteBuffer���
     * 
     * @param buffer
     */
    public static void clean(final MappedByteBuffer buffer) {
        if (buffer == null) {
            return;
        }
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                try {
                    Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
                    if (getCleanerMethod != null) {
                        getCleanerMethod.setAccessible(true);
                        Object cleaner = getCleanerMethod.invoke(buffer, new Object[0]);
                        Method cleanMethod = cleaner.getClass().getMethod("clean", new Class[0]);
                        if (cleanMethod != null) {
                            cleanMethod.invoke(cleaner, new Object[0]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public static void ecloudToFile(ECloudDomain eCloudDomain,String targetPath) {
        JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
        JSONArray arr = (JSONArray) o2.get("bytes");
        byte[] b1 = JSON.parseObject(arr.toString(), byte[].class);
        FileUtil.writeFile(targetPath, b1);
    }

    public static void ecloudToImage(ECloudDomain eCloudDomain,String targetPath) throws Exception {
        JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
        JSONArray arr = (JSONArray) o2.get("base64");
        for (int i = 0; i <arr.size(); i++) {
            decoderBase64File(arr.getString(i),targetPath+i+".png");
        }
    }

    public static String readTextFile(String realPath) throws Exception {
        File file = new File(realPath);
        if (!file.exists()) {
            System.out.println("File not exist!");
            return null;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(realPath), "UTF-8"));
        String temp = "";
        String txt = "";
        while ((temp = br.readLine()) != null) {
            txt += temp;
        }
        br.close();
        return txt;
    }

    /**
     * 输出文件
     * 
     * @param path
     *            文件目录
     * @param bytes
     *            字节数组
     */
    public static void writeFile(String path, byte[] bytes) {
        int n = 1024;
        FileOutputStream os = null;
        try {
            // 创建文件输出流对象
            File file = new File(path);
            os = new FileOutputStream(file);
            // 写入输出流
            int length = bytes.length;
            int start = 0;
            while (length > start + n) {
                os.write(bytes, start, n);
                start = start + n;
            }
            if (length != start + n) {
                n = length - start;
                os.write(bytes, start, n);
            }
        } catch (IOException e) {
        } finally {
            // 关闭输出流
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
            }
        }
    }
}