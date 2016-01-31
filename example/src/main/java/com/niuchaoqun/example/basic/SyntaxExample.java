package com.niuchaoqun.example.basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxExample {
	public static void run(String[] args) {
		array();
		string();
		regex();
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
	}

	public static void string() {
		// String 匿名对象
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
		System.out.println("=====");

		byte[] bytes = "name0123".getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
		System.out.println("=====");

		String string = "abcd,efg,hij";
		String[] split = string.split(",");
		for (String s : split) {
			System.out.println(s);
		}

		String str = "1abcdefghij5";
		String replace = str.replace("a", "#");
		String regx1 = str.replaceAll("de", "##");
		String regx2 = str.replaceAll("[d|f]", "#");
		String regx3 = str.replaceAll("\\d", "#");
		System.out.println(replace);
		System.out.println(regx1);
		System.out.println(regx2);
		System.out.println(regx3);
		System.out.println("=====");

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
