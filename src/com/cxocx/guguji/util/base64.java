package com.cxocx.guguji.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 本类功能String和base64互转 image和base64互转[无其他功能]
 * @author DIMON
 */
public class base64 {
	private static final Base64 BASE64 = new Base64();
	private static final Charset DEFAULT_CHARSET = Charset.forName("GBK");
	private static final String PREFIX = "";
	
	
	/**
	 * @Descriptionmap 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * @author temdy
	 * @Date 2015-01-26
	 * @param path 图片路径
	 * @return
	 * @throws IOException 
	 */
	public static String image_Base64(BufferedImage image) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		if(image==null){
			return null;
		}
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ImageIO.write(image,"BMP", bos);
		BASE64Encoder encoder = new BASE64Encoder();
		return (encoder.encode(bos.toByteArray()));// 返回Base64编码过的字节数组字符串
	}

	/**
	 * @Descriptionmap 对字节数组字符串进行Base64解码并生成图片
	 * @author temdy
	 * @Date 2015-01-26
	 * @param base64
	 *            图片Base64数据
	 * @param path
	 *            图片路径
	 * @return
	 */
	public static boolean base64_Image(String base64, String path) {// 对字节数组字符串进行Base64解码并生成图片
		if (base64 == null) { // 图像数据为空
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(base64);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(path);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * String转BASE64
	 * 
	 * @param source
	 * @return base64
	 */
	public static String String_base64(String source) {
		if (!isEmpty(source)) {
			new Base64();
			String target = PREFIX + source;
			byte[] bytes = BASE64.encode(target.getBytes(DEFAULT_CHARSET));
			return new String(bytes, DEFAULT_CHARSET);
		}
		return  replaceBlank(source);
	}

	/**
	 * base64转String
	 * 
	 * @param source
	 * @return string
	 */
	public static String base64_String(String source) {
		if (!isEmpty(source)) {
			byte[] bytes = BASE64.decode(source.getBytes(DEFAULT_CHARSET));
			String target = new String(bytes, DEFAULT_CHARSET);
			return target.startsWith(PREFIX) ? target
					.substring(PREFIX.length()) : target;
		}
		return source;
	}

	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	private static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	/**
	 * 去掉换行和空格
	 * @param str
	 * @return
	 */
	private static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
