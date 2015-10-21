package com.jlj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 日期、时间工具类
 * @author JLJ&LQ
 *
 */
public class DateTimeKit {
	/**
	 * 得到当前日期与时间,精确到[时:分:秒]
	 * @return
	 */
	public static String getLocalTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString=sdf.format(date);
		return dateString;
	}
	/**
	 * 根据日期获得随即字符串
	 */
	public static String getDateRandom() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString=sdf.format(date);
		Random random=new Random();
		int rand=random.nextInt(1000);
		dateString=dateString+rand;
		return dateString;
	}
	
}
