package com.cxocx.guguji.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
public class image_fanzhuan {
	/**
	 * 图片翻转 0 为上下反转 1 为左右反转
	 * @param fangxiang
	 * @throws IOException
	 */
	public static BufferedImage fanzhuan_image(BufferedImage bi,int fangxiang) throws IOException{
		int [][] xz;
		try {
		int width = bi.getWidth();
		int height = bi.getHeight();
		int [][]datas = new int[width][height];
		int [][]datastmp = new int[width][height];
		for(int i = 0;i< height;i++){
			for(int j = 0 ;j<width;j++){
				datas[j][i]= bi.getRGB(j, i);
				datastmp[j][i]= bi.getRGB(j, i);
			}
		}
		 xz= XZ(datas,width,height,fangxiang);//翻转方向
		for(int i = 0;i< height;i++){
			for(int j = 0 ;j<width;j++){
			bi.setRGB(j, i, xz[j][i]);
			}
		}
		//ImageIO.write(bi, "JPEG", new File("D:\\bing.bmp"));
		return bi;
		}finally{
			
		}
	}
	
	/***
	 * 图片翻转 0 为上下反转 1 为左右反转
	 * @param datas
	 * @param width
	 * @param height
	 * @param FX 0 为上下反转 1 为左右反转
	 * @return
	 */
	public static int[][] XZ(int[][] datas, int width, int height, int FX) {
		try {
			int[][] tmps = new int[width][height];
			if (FX == 0) {
				for (int i = 0, a = height - 1; i < height; i++, a--) {
					for (int j = 0, b = width - 1; j < width; j++, b--) {
						tmps[b][a] = datas[j][i];
					}
				}
			} else if (FX == 1) {
				for (int i = 0; i < height; i++) {
					for (int j = 0, b = width - 1; j < width; j++, b--) {
						tmps[b][i] = datas[j][i];
					}
				}
			}else{
				System.out.println("翻转处理失败!");
				return null;
			}
			return tmps;
		} catch (Exception e) {
			System.out.println("ex:" + e.getMessage());
			return null;
		}
	}
	
	
}