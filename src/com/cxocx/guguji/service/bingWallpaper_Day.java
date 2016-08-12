package com.cxocx.guguji.service;
import java.io.File;

import com.cxocx.guguji.api.bing_Wallpaper_Json;
import com.cxocx.guguji.api.now_Time;
import com.cxocx.guguji.entity.bingWallpaper;
import com.cxocx.guguji.entity.printPaper;
import com.cxocx.guguji.entity.user;
import com.cxocx.guguji.util.Image_Compression;
import com.cxocx.guguji.util.base64;
import com.cxocx.guguji.util.image_change_grey_weitu;
import com.cxocx.guguji.util.image_fanzhuan;
import com.cxocx.guguji.util.save_image_local;
/**
 * 获取当天bing壁纸,并发送至打印机
 * @author DIMON
 *
 */
public class bingWallpaper_Day {
	
	public static printPaper  bingWallpaper(String memobirdID) throws Exception{
		bingWallpaper bw=bing_Wallpaper_Json.get_Bing_Wallpaper("0"); //获取图片JSON数据对象
		
		byte[] img=save_image_local.saveImage(bw.getUrl()); //传入获取的图片地址,下载到本地,保存为BMP格式
		
		Image_Compression.resize(img,384,1f);//将图片压缩至384比例
		image_fanzhuan.fanzhuan_image(img,0); //上下翻转
		image_fanzhuan.fanzhuan_image(img,1); //左右翻转
		image_change_grey_weitu.Image_gray(img); //转灰色
		image_change_grey_weitu.grayImage_weitu(img); //转位图
		String bas64_img=base64.image_Base64(img);//bing每日图片转base64
		String bas64_text=base64.String_base64("现在北京时间:"+now_Time.now_Time()+"\n"+bw.getCopyright()+"\n");//bing每日壁纸简介文字转base64
		String ct=bas64_text;
		String ig=bas64_img;
		user user_ms=userLinked.sendPost(memobirdID,now_Time.now_Time());//获取用关联ID
		printPaper pp=Print.print_image_AND_text(ct, ig, memobirdID, user_ms.getShowapi_userid());
		return pp;
	}
	public static void main(String[] args) throws Exception {
		printPaper a=bingWallpaper("9a9416dfb3e5f26f");
		System.out.println(a.getResult());
	}
}
