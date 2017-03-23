package com.niuchaoqun.example.basic;

import java.io.IOException;

public class RuntimeExample {

	public static void run(String[] args) {
		example();
	}

	public static void example() {
		Runtime runtime = Runtime.getRuntime();

		// 获取 Java 虚拟机试图使用的最大内存量。
		System.out.println(runtime.maxMemory());
		// 获取 Java 虚拟机中的空闲内存量
		System.out.println(runtime.freeMemory());
		// 获取 Java 虚拟机中的内存总量
		System.out.println(runtime.totalMemory());

		String string = "Runtime";
		for (int i = 0; i < 10000; i++) {
			string += i;
		}

		// 手动GC
		System.out.println(runtime.freeMemory());
		runtime.gc();
		System.out.println(runtime.freeMemory());

		// 执行外部程序
//		try {
//			String command = "cmd.exe";
//			Process process = runtime.exec(command);
//			System.out.println(process);
//
//			Thread.sleep(10);
//
//			process.destroy();
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
