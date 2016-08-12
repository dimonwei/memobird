package com.cxocx.guguji.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
import com.cxocx.guguji.entity.openKey;
import com.cxocx.guguji.entity.printStatus;

/**
 * 本类主要查询打印纸条的打印状态
 * @author DIMON
 *
 */
public class print_Status {
	
	/**
	 * 本方法传入打印内容的唯一 ID 返回打印状态对象
	 * @throws Exception 
	 */
	public static printStatus printStatus(String printcontentid) throws Exception{
		String result = "";
		printStatus ps=new printStatus();
		URL url = new URL("http://open.memobird.cn/home/getprintstatus");
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.print("ak="+openKey.getKey()+"&timestamp="+openKey.getTimestamp()+"&printcontentid="+printcontentid);
		out.flush();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		if (out != null) {
			out.close();
		}
		if (in != null) {
			in.close();
		}
		JSONObject jb=new JSONObject(result);
		ps.setPrintcontentid(printcontentid);
		ps.setShowapi_res_code(jb.getInt("showapi_res_code"));
		ps.setShowapi_res_error(jb.getString("showapi_res_error"));
		ps.setPrintflag(jb.getInt("printflag"));
		ps.setPrintcontentID(jb.getString("printcontentid"));
		return ps; //返回处理后的对象
	}
}
