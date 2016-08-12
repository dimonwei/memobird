package com.cxocx.guguji.api;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cxocx.guguji.entity.bingWallpaper;
/**
 * bing每日图json类,返回url,描述等
 * @author DIMON
 */
public class bing_Wallpaper_Json {
	/**
	 * 解析bing壁纸JSON数据方法
	 * @param 传入String 必应壁纸读取日期.0:本日  1:昨天  -1:明天  默认为0
	 * @return bingWallpaper实体对象
	 * @throws Exception 
	 */
	public static bingWallpaper get_Bing_Wallpaper(String image_day) throws Exception{
		bingWallpaper bing = new bingWallpaper();// 创建一个bing对象.用于获取和设置参数
		PrintWriter out = null;
		BufferedReader in = null;
		String result = ""; // 保存返回的JSON字符串
		try {
			URL url = new URL(bing.setBing_url(image_day)); // 创建一个URL连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // 获取URL内容
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST"); // 设定请求未POST
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type","application/json; charset=UTF-8"); // 设定请求编码为UTF-8
			out = new PrintWriter(connection.getOutputStream());
			out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			// 获取到的json对象解析出来
			JSONObject json = new JSONObject(result);
			JSONArray jsonArray = json.getJSONArray("images");
			String[] url1 = { jsonArray.getString(0) };
			JSONObject json1 = new JSONObject(url1[0]);
			bing.setStartdate(json1.getString("startdate"));
			bing.setFullstartdate(json1.getString("fullstartdate"));
			bing.setEnddate(json1.getString("enddate"));
			bing.setUrl(json1.getString("url"));
			bing.setCopyright(json1.getString("copyright"));
			bing.setCopyrightlink(json1.getString("copyrightlink"));
			bing.setHsh(json1.getString("hsh"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out!=null){
				out.close();
			}
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bing;
	}
}
