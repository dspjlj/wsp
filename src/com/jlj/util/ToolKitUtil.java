package com.jlj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
/**
 * 工具类
 * @author JLJ
 *
 */
public class ToolKitUtil {
	
	//字符串相关==============================================================start
	/**
	 * 生成指定长度的随机字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz" +
	    			  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
	    			  "0123456789";
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  
	
	/**
	 * 将字符串中所有特殊字符替换成html能识别的字符串
	 * @param str
	 * @return
	 */
	private static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	//字符串相关==============================================================end
	
	//文件相关==============================================================start
	/**
	 * 上传图片
	 * @param floderName 文件夹名称
	 * @param imageName 图片名称
	 * @param picture 图片file类
	 * @throws Exception
	 */
	public static void upload(String floderName,String imageName,File picture) throws Exception{
		File saved=new File(ServletActionContext.getServletContext().getRealPath("res/"+floderName),imageName);
		InputStream ins=null;
		OutputStream ous=null;
		try {
			saved.getParentFile().mkdirs();
			ins=new FileInputStream(picture);
			ous=new FileOutputStream(saved);
			byte[] b=new byte[1024];
			int len = 0;
			while((len=ins.read(b))!=-1){
				ous.write(b,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ous!=null)
				ous.close();
			if(ins!=null) 
				ins.close();
		}
	}
	/** 
	 * 删除文件、文件夹 
	 */  
	public static void deleteFile(String path) {  
	    File file = new File(path);  
	    if (!file.exists()) {  // 不存在返回 false  
	    	return; 
	    }
	    if (file.isDirectory()) {  
	        File[] ff = file.listFiles();  
	        for (int i = 0; i < ff.length; i++) {  
	            deleteFile(ff[i].getPath());  
	        }  
	    }  
	    file.delete();  
	}  
	
	
	/**
	 * 上传照片
	 * @param imageName：图片名称
	 * @param picture：文件对象
	 * @param floderUrl：文件夹路径
	 * @throws Exception
	 */
//	public static void upload(String imageName,File picture,String floderUrl) throws Exception{
//		File saved=new File(floderUrl,imageName);
//		InputStream ins=null;
//		OutputStream ous=null;
//		try {
//			saved.getParentFile().mkdirs();
//			ins=new FileInputStream(picture);
//			ous=new FileOutputStream(saved);
//			byte[] b=new byte[1024];
//			int len = 0;
//			while((len=ins.read(b))!=-1){
//				ous.write(b,0,len);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if(ous!=null)
//				ous.close();
//			if(ins!=null) 
//				ins.close();
//		}
//	}
	//文件相关==============================================================end
}
