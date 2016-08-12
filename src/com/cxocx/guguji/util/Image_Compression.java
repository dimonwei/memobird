package com.cxocx.guguji.util;

import com.sun.image.codec.jpeg.JPEGImageEncoder;  
import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGEncodeParam;  
import javax.swing.*;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.awt.*;  
import java.awt.image.BufferedImage;  
import java.awt.image.Kernel;  
import java.awt.image.ConvolveOp;  
  /**
   * 图片尺寸压缩:图片质量需要选择 0 和 1之间
   * @author DIMON
   *
   */
public class Image_Compression {  
    public static BufferedImage resize(BufferedImage originalFile, int newWidth, float quality) throws IOException {  
        if (quality > 1) {  
            throw new IllegalArgumentException("图片质量需要选择 0 和 1之间");  
        }  
        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());  
        Image i = ii.getImage();  
        Image resizedImage = null;  
        int iWidth = i.getWidth(null);  
        int iHeight = i.getHeight(null);  
        if (iWidth > iHeight) {  
            resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)/ iWidth, Image.SCALE_SMOOTH);  
        } else {  
            resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,newWidth, Image.SCALE_SMOOTH);  
        }  
        // 此代码可以确保在图像中的所有像素被加载。
        Image temp = new ImageIcon(resizedImage).getImage();  
        //创建的BufferedImage。
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),  
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);  
        // 复制图像的BufferedImage。
        Graphics g = bufferedImage.createGraphics();  
        // 清除背景和绘制图像。
        g.setColor(Color.white);  
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));  
        g.drawImage(temp, 0, 0, null);  
        g.dispose();  
        // 软化.  
        float softenFactor = 0.05f;  
        float[] softenArray = { 0, softenFactor, 0, softenFactor,  
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };  
        Kernel kernel = new Kernel(3, 3, softenArray);  
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        bufferedImage = cOp.filter(bufferedImage, null);  
        return   bufferedImage;
//        // 写JPEG到一个文件中。
//        FileOutputStream out = new FileOutputStream(resizedFile);  
//        // 编码图像为JPEG数据流
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);  
//        param.setQuality(quality, true);  
//        encoder.setJPEGEncodeParam(param);  
//        encoder.encode(bufferedImage);  
    }
}  