package com.cxocx.guguji.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.IOException;
/**
 * 本类是图片转灰色和转位图方法[不做其他处理]
 * @author DIMON
 */
public class image_change_grey_weitu {
	/**
	 * 将图片转为灰色
	 * @throws Exception
	 */
	public static BufferedImage Image_gray(BufferedImage image) throws IOException {
		//File file = new File("D:/bing.bmp");  //获取图片
		//BufferedImage image = ImageIO.read(file); //读取图片
		int width = image.getWidth(); 
		int height = image.getHeight();
		BufferedImage grayImage = new BufferedImage(width, height,BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		//File newFile = new File("D:/bing.bmp");
		//return ImageIO.write(grayImage, "bmp", newFile);
		return grayImage;
	}
	/**
	 * 图片转为位图 
	 * @throws IOException
	 */
	public static BufferedImage grayImage_weitu(BufferedImage sourceImg) throws IOException{
		  int h = sourceImg.getHeight();
		  int w = sourceImg.getWidth();
		  int[] pixels = new int[w * h]; // 定义一数组，用来存储图片的象素
		  int gray;
		  PixelGrabber pg = new PixelGrabber(sourceImg, 0, 0, w, h, pixels,0, w);
		  try {
		   pg.grabPixels(); // 读取像素值
		  } catch (InterruptedException e) {
			  System.err.println("处理被异常中断！请重试！");
		  }
		// 扫描列
		  for (int j = 0; j < h; j++)   {
			  // 扫描行
			   for (int i = 0; i < w; i++) { // 由红，绿，蓝值得到灰度值
				    gray = (int) (((pixels[w * j + i] >> 16) & 0xff) * 0.8);
				    gray += (int) (((pixels[w * j + i] >> 8) & 0xff) * 0.1);
				    gray += (int) (((pixels[w * j + i]) & 0xff) * 0.1);
				    pixels[w * j + i] = (255 << 24) | (gray << 16) | (gray << 8)| gray;
			   }
		  }
		  MemoryImageSource s= new   MemoryImageSource(w,h,pixels,0,w);
		  Image img =Toolkit.getDefaultToolkit().createImage(s);
		  BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
		  buf.createGraphics().drawImage(img, 0, 0, null);
		  //ImageIO.write(buf, "BMP", new File("D:/bing.bmp"));
		  return buf;
	}

	/**
	 * 合并转换
	 * @param bi
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage gray_weitu_hebingzhuanhuan(BufferedImage bi) throws IOException{
		System.out.println("灰度位图转换完成");
		return grayImage_weitu(Image_gray(bi));
	}
}
