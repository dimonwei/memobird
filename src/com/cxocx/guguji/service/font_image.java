package com.cxocx.guguji.service;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.cxocx.guguji.entity.printPaper;
import com.cxocx.guguji.entity.user;
import com.cxocx.guguji.util.image_fanzhuan;
public class font_image {
	/**
	 * @throws Exception 
	 */
	public static printPaper fontimage(String title,String content,user us) throws Exception{
        int width=384, height=100;
        Color c=new Color	(255,255,255);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g =image.createGraphics();
        g.fillRect(0, 384, width, height);//设置宽高
		Font f = new Font("等线", Font.PLAIN, 60);
		g.setFont(f);
		g.setColor(c);
		g.drawString(title, 15, 68);//限制6个字以内
		g.dispose();
		image=image_fanzhuan.fanzhuan_image(image,0);//上下翻转图片
		image=image_fanzhuan.fanzhuan_image(image,1);//左右翻转图片
		printPaper ppr=Print.print_image_AND_text(content,image, us.getMemobirdID(), us.getShowapi_userid());//发起图片打印
		//测试将图片保存到本地
//		if(image!=null){
//			File a=new File("D:/AA.bmp");
//			ImageIO.write(image, "bmp", a);
//		}
		return ppr;    //返回打印回执对象
	}
}
