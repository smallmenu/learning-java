package com.niuchaoqun.example.basic;

public class SystemExample {

	public static void run(String[] args) {
		example();
	}

	public static void example() {
		// 运行毫秒
		long start = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		// 系统Properties 通过-D参数传递
		System.getProperties().list(System.out);
	}
}
