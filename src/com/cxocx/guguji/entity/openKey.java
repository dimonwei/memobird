package com.cxocx.guguji.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 开发者_开发信息,系统时间获取类
 * 
 * @author DIMON
 */
public class openKey {
	private static String key; //用户密匙
	private static String timestamp; //系统时间

	/**
	 * 获取key返回key
	 * 
	 * @return key
	 */
	public static String getKey() {
		key = "###################";
		return key;
	}

	/**
	 * 
	 * 获取系统时间返回格式:2001-01-01 11:11:11
	 * 
	 * @return
	 */
	public static String getTimestamp() {
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timestamp = sdf.format(data.getTime());
		return timestamp;
	}
}
