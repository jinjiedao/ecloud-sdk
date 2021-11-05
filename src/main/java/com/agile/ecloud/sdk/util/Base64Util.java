package com.agile.ecloud.sdk.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Base64Util {

	/**  

	 * <p>将文件转成base64 字符串</p>  

	 * @param path 文件路径  

	 * @return  

	 * @throws Exception  

	 */

	public static String encodeBase64File(String path) throws Exception {

		/*File file = new File(path);

		FileInputStream inputFile = new FileInputStream(file);

		byte[] buffer = new byte[(int) file.length()];

		inputFile.read(buffer);

		inputFile.close();

		return new BASE64Encoder().encode(buffer);*/

		FileInputStream file = new FileInputStream(path);
		byte[] bdata = IOUtils.toByteArray(file);
		return Base64.encodeBase64String(bdata);

	}
	/**  

	 * <p>将文件转成base64 字节数组</p>  

	 * @param path 文件路径  

	 * @return  

	 * @throws Exception  

	 */

	public static byte [] encodeBase64ByteFile(String path) throws Exception {

		File file = new File(path);

		FileInputStream inputFile = new FileInputStream(file);

		byte[] buffer = new byte[(int) file.length()];

		inputFile.read(buffer);

		inputFile.close();

		return buffer;

	}

	/**  

	 * <p>将base64字符解码保存文件</p>  

	 * @param base64Code  

	 * @param targetPath  

	 * @throws Exception  

	 */

	public static void decoderBase64File(String base64Code, String targetPath)
			throws Exception {

		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);

		FileOutputStream out = new FileOutputStream(targetPath);

		out.write(buffer);

		out.close();

	}
	/**  

	 * <p>将base64解码保存文件</p>  

	 * @param base64Code  

	 * @param targetPath  

	 * @throws Exception  

	 */

	public static void decoderBase64File(byte [] buffer, String targetPath)
			throws Exception {


		FileOutputStream out = new FileOutputStream(targetPath);

		out.write(buffer);

		out.close();

	}
	/**  

	 * <p>将base64字符保存文本文件</p>  

	 * @param base64Code  

	 * @param targetPath  

	 * @throws Exception  

	 */

	public static void toFile(String base64Code, String targetPath)
			throws Exception {

		byte[] buffer = base64Code.getBytes();

		FileOutputStream out = new FileOutputStream(targetPath);

		out.write(buffer);

		out.close();

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
		return lSize;
	}


	public static void main(String[] args) {

		try {

			String base64Code = encodeBase64File("E:\\中国印.jpg");

			//System.out.println(base64Code);

			//decoderBase64File(base64Code, "E:\\中国印2.jpg");

			toFile(base64Code, "E:\\three.txt");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}



}
