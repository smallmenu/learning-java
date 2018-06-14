package com.niuchaoqun.example.basic;

import java.util.Arrays;
import java.util.Map;

public class SystemExample {

	public static void run(String[] args) {
		// 复制数组
		String[] srcAry = {"a", "b", "c"};
		String[] destAry = new String[srcAry.length];
		System.arraycopy(srcAry, 0, destAry, 0, srcAry.length);
		System.out.println(Arrays.toString(destAry));

		// 毫秒
		long start = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		Map<String, String> getenv = System.getenv();
		System.out.println(getenv);

		// 系统Properties 通过-D参数传递
		//System.getProperties().list(System.out);


		System.exit(-1);
	}

	public static void example() {

	}
}
