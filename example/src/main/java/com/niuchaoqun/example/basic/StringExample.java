package com.niuchaoqun.example.basic;

public class StringExample {
	
	public static void run(String[] args) {
		StringBufferExample();
		StringBuilderExample();
	}

	public static void StringBufferExample() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello");
		buffer.insert(buffer.length(), " World");

		StringBuffer buffer2 = new StringBuffer();
		buffer2.append("Hello中文");
		System.out.println(buffer);
		System.out.println(buffer2);

		// length 
		System.out.println(buffer.length());
		System.out.println(buffer2.length());

		// indexOf
		System.out.println(buffer2.indexOf("中"));

		// replace
		buffer.replace(0, 5, "XXXXX");
		System.out.println(buffer);

		// substring
		String substring = buffer.substring(0, 5);
		System.out.println(substring);

		// reverse
		String reverse = buffer.reverse().toString();
		System.out.println(reverse);
		
		System.out.println("=====");
		
		// StringBuilder 功能与 StringBuffer类似，不支持多线程性能更好
		StringBuilderExample();
	}
	
	public static void StringBuilderExample() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hello");
		builder.insert(builder.length(), " World");

		StringBuffer builder2 = new StringBuffer();
		builder2.append("Hello中文");
		System.out.println(builder);
		System.out.println(builder2);

		// length 
		System.out.println(builder.length());
		System.out.println(builder2.length());

		// indexOf
		System.out.println(builder2.indexOf("中"));

		// replace
		builder.replace(0, 5, "XXXXX");
		System.out.println(builder);

		// substring
		String substring = builder.substring(0, 5);
		System.out.println(substring);

		// reverse
		String reverse = builder.reverse().toString();
		System.out.println(reverse);
	}
}
