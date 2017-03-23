package com.niuchaoqun.example.basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.fabric.xmlrpc.base.Array;

public class SyntaxExample {
	public static void run(String[] args) {
		type();
		array();
		string();
		regex();
	}

	public static void type() {
		// long 8字节
		long ilong;
		
		// int 4字节
		int iint;
		
		// short 2字节
		short ishort;
		
		// byte 1字节
		byte b;
		
		// float 4字节
		float f;
		
		// double 8字节
		double d;
		
		// 包装类
		int maxi = Integer.MAX_VALUE;
		byte maxb = Byte.MAX_VALUE;
		
		System.out.println(maxi);
		System.out.println(maxb);
		
		// 字符类型，2字节，属于整型的一种
		char ch1 = 'a';
		char ch2 = 97;
		char ch3 = '\'';
			
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		
		// bool
		boolean flag = true;
		System.out.println(flag);
		
		// 类型转换，常量计算使用强制类型转换，输出：3.3333333
		System.out.println((float)10/3);
		
		System.out.println("=====");		
	}

	public static void array() {
		int[] array1 = null;

		array1 = new int[10];
		int[] array2 = { 1, 2, 3, 4, 5 };

		int[][] array3 = null;
		array3 = new int[3][4];

		for (int v : array2) {
			System.out.println(v);
		}

		Arrays.sort(array2);
		System.out.println(Arrays.toString(array2));
		
		System.out.println("=====");
	}

	public static void string() {		
		// String 匿名对象，创建了字符串name在字符串池中，string1与string2都是对该字符串的引用
		String string1 = "name";
		String string2 = "name";
		// String 对象
		String string3 = new String("Name");

		String string4 = string3;
		System.out.println(string1 == string2);
		System.out.println(string1 == string3);
		System.out.println(string3 == string4);
		System.out.println(string1.equals(string3));
		System.out.println(string1.equalsIgnoreCase(string3));
		// 判断是否等于字符串更严谨的写法，可避免空指针异常
		System.out.println("name".equals(string3));
		System.out.println("=====");
		
		System.out.println(" adsf ".trim());
		System.out.println(string1.toUpperCase());
		System.out.println(string1.startsWith("n"));
		System.out.println("=====");

		byte[] bytes = "name0123".getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
		
		// 任何类型的数据都向String转型，输出：test30
		String test = "test";
		int x = 30;
		System.out.println(test + x);
		
		System.out.println("=====");

		// split、replaceAll 支持正则表达式
		String string = "abcd,efg,hij";
		String[] split = string.split(",");
		for (String s : split) {
			System.out.println(s);
		}

		String str = "1abcdefghidej5a";
		String replace = str.replace("a", "#");
		String regx1 = str.replaceAll("de", "##");
		String regx2 = str.replaceAll("[d|f]", "#");
		String regx3 = str.replaceAll("\\d", "#");
		System.out.println(replace);
		System.out.println(regx1);
		System.out.println(regx2);
		System.out.println(regx3);
		System.out.println("=====");

		// 字符串matches支持正则，仅用于是否匹配
		String source1 = "2015-02-03";
		boolean match = source1.matches("\\d{4}-\\d{2}-\\d{2}");
		System.out.println(match);
		String source2 = "2015-02|03";
		String[] regsplit = source2.split("[|-]");
		for (String string5 : regsplit) {
			System.out.println(string5);
		}
	}

	public static void regex() {
		String string1 = "2015-05-06";
		Pattern pattern1 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher1 = pattern1.matcher(string1);
		System.out.println(matcher1.matches());

		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d{4})(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (m.find()) {
			int groupCount = m.groupCount();
			for (int i = 0; i < groupCount + 1; i++) {
				System.out.println("Found value: " + m.group(i));
			}
		} else {
			System.out.println("NO MATCH");
		}
	}
}
