package com.cxocx.guguji.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.cxocx.guguji.api.now_Time;
import com.cxocx.guguji.entity.openKey;
import com.cxocx.guguji.entity.user;

/**
 * 本类关联用户 传入参数机器ID 和用户昵称 返回用户关联对象
 * @author DIMON
 */
public class userLinked {
	/**
	 * 传入参数机器ID 和用户昵称
	 * @return 返回用户关联对象
	 */
	public static user get_user(String memobirdID, String useridentifying) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		user u = new user();
		try {
			URL realUrl = new URL("http://open.memobird.cn/home/setuserbind");
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print("ak=" + openKey.getKey() + "&timestamp="
					+ now_Time.now_Time() + "&memobirdID=" + memobirdID
					+ "&useridentifying=" + useridentifying);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			JSONObject json=new JSONObject(result);
			u.setMemobirdID(memobirdID);
			u.setUseridentifying(useridentifying);
			u.setShowapi_res_code(json.getInt("showapi_res_code"));
			u.setShowapi_res_error(json.getString("showapi_res_error"));
			u.setShowapi_userid(json.getInt("showapi_userid"));
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return u;
	}

}
