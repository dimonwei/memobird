package com.cxocx.guguji.util;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 将传入的图片url链接保存到D盘根目录[不做其他任何处理]
 * @author DIMON
 * 
 */
public class save_image_local {
	/**
	 * 图片储存到本地
	 * @param imageUrl
	 * @return 
	 */
	public static byte[] saveImage(String imageUrl) throws Exception {
		URL url = new URL(imageUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream instream = conn.getInputStream();
		byte[] data = readInputStream(instream);
//		File imageFile = new File("D:/bing.bmp");
//		FileOutputStream outStream = new FileOutputStream(imageFile);
//		outStream.write(data);
//		outStream.close();
		return data;
	}
	
	/**
	 * 图片储存到本地辅助方法
	 * @param inStream
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}
}
