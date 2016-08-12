package com.cxocx.guguji.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PM25 {
	/**
	 * 查询指定城市空气质量
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果 Map集合
	 * @throws JSONException 
	 */
	public static Map request( String httpArg) throws JSONException {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	   String httpUrl = "http://apis.baidu.com/apistore/aqiservice/aqi" + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("apikey",  "59967c51d54d84fed2e1ad355560573b");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
			JSONObject json=new JSONObject(new JSONObject(result).getString("retData"));
//			System.out.println(json.getString("city")); //城市
//			System.out.println(json.getString("time")); //数据采集时间
//			System.out.println(json.getInt("aqi"));//空气质量指数
//			System.out.println(json.getString("level"));//空气等级
//			System.out.println(json.getString("core")); //首要污染物
			Map map=new HashMap();
			map.put("city", json.getString("city"));
			map.put("time", json.getString("time"));
			map.put("aqi",json.getInt("aqi"));
			map.put("level", json.getString("level"));
			map.put("core",json.getString("core"));
	    return map;
	}
}
