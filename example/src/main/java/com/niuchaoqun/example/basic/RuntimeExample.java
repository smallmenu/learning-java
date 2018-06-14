package com.niuchaoqun.example.basic;

import java.io.IOException;

public class RuntimeExample {

	public static void run(String[] args) {
		Runtime runtime = Runtime.getRuntime();

		// 获取可用的CPU数量
		int cpus = runtime.availableProcessors();
		System.out.println(cpus);

		// 获取 Java 虚拟机试图使用的最大内存量。
		System.out.println(runtime.maxMemory());
		// 获取 Java 虚拟机中的空闲内存量
		System.out.println(runtime.freeMemory());
		// 获取 Java 虚拟机中的内存总量
		System.out.println(runtime.totalMemory());

		String string = "Runtime";
		for (int i = 0; i < 50000; i++) {
			string += i;
		}
		System.out.println("----- Memory -----");

		// 手动GC
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.totalMemory());
		runtime.gc();
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.totalMemory());

		// 执行外部程序
		try {
			Process exec = runtime.exec("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加载外部动态库
		runtime.load("");
	}
}
