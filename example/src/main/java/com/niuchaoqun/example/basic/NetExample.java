package com.niuchaoqun.example.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class NetExample {
	
	public static void run(String[] args) {
		host();
		get();
		post();
	}
	
	public static void host() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost.getHostAddress());

			InetAddress remoteHost = InetAddress.getByName("www.niuchaoqun.com");
			System.out.println(remoteHost.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		System.out.println("=====");
	}

	public static void get() {
		try {
			// URL GET
			URL url = new URL("http://www.niuchaoqun.com/");
			// connection
			URLConnection connection = url.openConnection();
			// 获取字节流
			InputStream is = connection.getInputStream();
			// 转成字符流 InputStreamReader 是字节流转换字符流桥梁
			InputStreamReader isr = new InputStreamReader(is);
			// 缓冲区
			BufferedReader br = new BufferedReader(isr);

			System.out.println(connection.getContentLength());
			System.out.println(connection.getContentType());
			System.out.println(connection.getContentEncoding());

			String line;
			StringBuilder string = new StringBuilder();
			while ((line = br.readLine()) != null) {
				string.append(line);
			}
			br.close();
			isr.close();
			is.close();

			System.out.println(string);
			System.out.println("=====");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void post() {
		try {
			URL url = new URL("http://www.niuchaoqun.com/phpinfo.php");
			// POST 必须使用HttpURLConnection对象
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestProperty("encoding", "UTF-8");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("aaa=xxx&bbb=xxx");
			bw.flush();
			
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			StringBuilder string = new StringBuilder();
			while ((line = br.readLine()) != null) {
				string.append(line);
			}
			
			bw.close();
			osw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			
			System.out.println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
