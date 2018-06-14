package com.niuchaoqun.example.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void run(String[] args) {
		example();
	}

	public static void example() {
		// 打印
		Properties properties = new Properties();
		properties.put("prop1", "value1");
		properties.put("prop2", "value2");
		properties.put("prop3", "value3");
		properties.list(System.out);

		// 保存
		File output = new File("data/test.properties");
		try {
			properties.store(new FileOutputStream(output), "Comment");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 读取
		Properties loadProperties = new Properties();
		File input = new File("data/test.properties");
		try {
			loadProperties.load(new FileInputStream(input));
			System.out.println(loadProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
