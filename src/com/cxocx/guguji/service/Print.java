package com.cxocx.guguji.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
import com.cxocx.guguji.entity.openKey;
import com.cxocx.guguji.entity.printPaper;
import com.cxocx.guguji.util.base64;
/**
 *咕咕机打印类,主要是打印东西
 */
public class Print {
	/**
	 * 传入参数,发送请求至咕咕机打印,然后返回打印回执对象
	 *	@param String ct[文本内容],String ig,String memobirdID ,String userID
	 * @return printPaper
	 * @throws Exception
	 */
	public static printPaper print_image_AND_text(String ct,BufferedImage image1,String memobirdID ,int userID) throws Exception{
		printPaper pap=new printPaper();//创建打印反馈对象
		String result = "";
		String content="T:"+base64.String_base64(ct);
		String image="P:"+base64.image_Base64(image1);
		String contentANDimage="";
		if("".equals(ct)&&image1!=null){ //文字空的,图片不空
			contentANDimage=image;
		}else if(image1==null&&!"".equals(ct)){ //图片空的,文字不空
			contentANDimage=content;
		}else if(image1!=null&&!"".equals(ct)){ //图片文字都不空
			contentANDimage=image+"|"+content;
			System.out.println(contentANDimage);
		}else{ //都空 没有内容
			contentANDimage="T:"+base64.String_base64("对不起空的!");
		}
		URL url = new URL("http://open.memobird.cn/home/printpaper");
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.print("ak="+openKey.getKey()+"&timestamp="+openKey.getTimestamp()+"&printcontent="+contentANDimage+"&memobirdID="+memobirdID+"&userID="+userID);
		Thread.sleep(1000);
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
		pap.setShowapi_res_code(jb.getInt("showapi_res_code"));
		pap.setShowapi_res_error(jb.getString("showapi_res_error"));
		pap.setResult(jb.getInt("result"));
		pap.setSmartGuid((String) jb.get("smartGuid"));
		pap.setPrintcontentID(jb.getString("printcontentid"));
		return pap; //返回处理后的对象
	}
}
