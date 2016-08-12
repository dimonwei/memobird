package com.cxocx.guguji.api;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 本类获取服务器时间
 * @author DIMON
 */
public class now_Time {
	public static String now_Time(){
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			return 	format.format(new Date().getTime());
	}
}
