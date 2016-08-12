package com.cxocx.guguji.service;

import java.util.Date;
import java.util.Map;

import org.json.JSONException;

import com.cxocx.guguji.api.PM25;
import com.cxocx.guguji.entity.user;

public class time_Task {
		static Map pm2;
		//9a9416dfb3e5f26f 我的设备ID
		static user us=userLinked.get_user("9a9416dfb3e5f26f","DIMON");
	public static void main(String[] args) throws Exception {
						font_image.fontimage("空气质量 [优]","",us);
						//Print.print_image_AND_text("打印测试时间:"+new Date().getTime(),null, us.getMemobirdID(),us.getShowapi_userid());
	}
}