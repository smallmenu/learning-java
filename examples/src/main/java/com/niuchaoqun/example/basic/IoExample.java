package com.niuchaoqun.example.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IoExample {

	private static String userDir = System.getProperties().getProperty("user.dir");
	private static String DS = File.separator;
	private static String dirPath = userDir + DS + "data";

	public static void run(String[] args) {
		file();
		listDir();
		fileStream();
		rwStream();
	}

	public static void file() {
		// 可递归
		String subDirPath = dirPath + DS + "subdata";
		File dir = new File(subDirPath);
		dir.mkdirs();

		String filePath1 = dirPath + DS + "test.txt";
		String filePath2 = subDirPath + DS + "test.txt";
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		
		if (file1.exists()) {
			file1.delete();
		} else {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (file2.exists()) {
			file2.delete();
		} else {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 列出文件下所有文件
	public static void listDir() {
		File dir = new File(dirPath);
		prints(dir);
	}

	private static void prints(File dir) {
		if (dir.isDirectory()) {
			File[] f = dir.listFiles();
			if (f != null) {
				for (int i = 0; i < f.length; i++) {
					prints(f[i]);
				}
			}
		} else {
			System.out.println(dir);
		}
	}

	public static void fileStream() {
		File file = new File(dirPath + DS + "test1.txt");

		FileOutputStream out1, out2;
		FileInputStream input1, input2;
		try {
			out1 = new FileOutputStream(file);
			String string = "helloworld";
			byte[] bytes = string.getBytes();
			out1.write(bytes);
			out1.write(bytes);
			out1.write("\r\n".getBytes());
			out1.close();

			out2 = new FileOutputStream(file, true);
			out2.write(bytes);
			out2.write(bytes);
			out2.write("\r\n".getBytes());
			out2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			input1 = new FileInputStream(file);
			input2 = new FileInputStream(file);
			byte[] ibytes1 = new byte[(int) file.length()];
			byte[] ibytes2 = new byte[(int) file.length()];
			input1.read(ibytes1);
			System.out.println(new String(ibytes1));
			System.out.println("=====");

			for (int i = 0; i < ibytes2.length; i++) {
				ibytes2[i] = (byte) input2.read();
			}
			System.out.println(new String(ibytes2));
			input1.close();
			input2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("=====");
	}

	public static void rwStream() {
		// Java 给出的解释时使用字节流更好
		File file = new File(dirPath + DS +"test2.txt");
		try {
			FileWriter write = new FileWriter(file);
			String string = "HelloWorld";
			write.write(string);
			write.write(string);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void bufferReader() {
		// BufferedReader只接受字符流缓冲区，所以将System.in字节流转换为字符流放入内存缓冲区
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String string = null;
		try {
			string = bufferedReader.readLine();
			int a = Integer.parseInt(string);
			string = bufferedReader.readLine();
			int b = Integer.parseInt(string);
			System.out.println(a + b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void scanner() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		String pattern = "^\\d{4}-\\d{2}-\\d{2}";
		String str = null;
		System.out.println("yyyy-MM-dd");
		if (scanner.hasNext(pattern)) {
			str = scanner.next(pattern);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			System.out.println(date);
		}
	}
}
