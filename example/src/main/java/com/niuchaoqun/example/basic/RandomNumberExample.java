package com.niuchaoqun.example.basic;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RandomNumberExample {

	public static void run(String[] args) {
		example();
	}

	public static void example() {
		// 随机数
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(100));
		}

		// 格式化
		NumberFormat numberFormat1 = NumberFormat.getInstance();
		System.out.println(numberFormat1.format(1234567890));
		System.out.println(numberFormat1.format(12345.67890));
		System.out.println("=====");

		// 自定义格式化
		System.out.println(new DecimalFormat("###,###,###.##").format(123456789));
		System.out.println(new DecimalFormat("###,###,###.#").format(1234567.89));
		System.out.println(new DecimalFormat("$###,###,###.#").format(123456789));
		System.out.println(new DecimalFormat("###,###,###.##%").format(0.0345));
	}
}
