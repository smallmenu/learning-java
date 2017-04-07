package com.niuchaoqun.example.basic;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateExample {
	
	public static void run(String[] args) {
		example();
	}
	
	public static void example() {
		/**
		 * JDK 1.1 开始，应该使用 Calendar 类实现日期和时间字段之间转换
		 * 使用 DateFormat 类来格式化和解析日期字符串
		 * Date 中的相应方法已废弃
		 */
		Date date = new Date();
		
		// Calendar
		Calendar calendar = new GregorianCalendar();
		System.out.println(calendar.get(calendar.YEAR)); // 2017
		
		DateFormat df1 = DateFormat.getInstance();
		DateFormat df2 = DateFormat.getDateInstance();
		DateFormat df3 = DateFormat.getDateTimeInstance();
		
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		System.out.println("=====");
		
		// 中文格式
		DateFormat df11 = DateFormat.getDateInstance(DateFormat.YEAR_FIELD, new Locale("zh", "CN"));
		DateFormat df21 = DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD, DateFormat.ERA_FIELD, new Locale("zh", "CN"));
		System.out.println(df11.format(date));
		System.out.println(df21.format(date));
		System.out.println("=====");
		
		// 自定义解析、格式化
		String strDateTime = "2005-10-19 10:20:30.345";
		String input = "yyyy-MM-dd HH:mm:ss.SSS";
		String output = "yyyy年MM月dd日 HH时mm分ss秒";
		SimpleDateFormat sdf1 = new SimpleDateFormat(input);
		SimpleDateFormat sdf2 = new SimpleDateFormat(output);
		Date d = null;
		try {
			d = sdf1.parse(strDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf2.format(d));
		System.out.println("=====");
		
		// 字符串转换时间戳
		String dateTimeString = "2016-10-19 10:20:36.923";
		SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			Date date1 = sdf11.parse(dateTimeString);
			long timestamp = date1.getTime();
			System.out.println(timestamp/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("=====");
		
		// 时间戳转换字符串
		long timestamp = 1476843636;
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp * 1000));
		System.out.println("=====");
		
		// 获取当前时间戳, 获取的是毫秒
		long currentTime1 = System.currentTimeMillis();
		long currentTime2 = new Date().getTime();
		Timestamp timestamp2 = new Timestamp(currentTime2);
		long currentTime3 =  timestamp2.getTime();
		
		// 今日凌晨00:00:00时间戳
		long currentTime4 = 0;
		try {
			Date today = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			currentTime4 = today.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(currentTime1);
		System.out.println(currentTime1);
		System.out.println(currentTime3);
		System.out.println(currentTime4);
		System.out.println("=====");
		
		// 获取昨日、上月、去年	
		Calendar now = GregorianCalendar.getInstance();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(now.getTime()));
		Calendar today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
		today.add(Calendar.DATE, -1);
		Date yesterday = today.getTime();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(yesterday));
		today.add(Calendar.MONTH, -1);
		Date lastMonth = today.getTime();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(lastMonth));
		today.add(Calendar.YEAR, -1);
		Date lastYear = today.getTime();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(lastYear));
		System.out.println("=====");
	
		// 时区
		TimeZone timeZone = TimeZone.getDefault();
		System.out.println(timeZone);
		SimpleDateFormat zoneFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		zoneFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		System.out.println(zoneFormat.format(new Date()));
		zoneFormat.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		System.out.println(zoneFormat.format(new Date()));
	}
}
