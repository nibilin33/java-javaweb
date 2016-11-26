package util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

public class GenImage {
	public static boolean GenerateImage(String imgStr) {
		  if (imgStr == null) // 图像数据为空
		   return false;
		  BASE64Decoder decoder = new BASE64Decoder();
		  try {
		   // Base64解码
		   byte[] b = decoder.decodeBuffer(imgStr);
		   ByteArrayInputStream bais = new ByteArrayInputStream(b);    
	        BufferedImage bi1 =ImageIO.read(bais); 
		 
	        File w2 = new File("D:\\1.jpeg");
	        ImageIO.write(bi1, "jpeg", w2);
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
		 }
}
