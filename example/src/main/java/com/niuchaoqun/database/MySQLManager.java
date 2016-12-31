package com.niuchaoqun.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;

public final class MySQLManager {

	public static String[] option = { "url", "user", "password" };
	public static HashMap<String, String> options = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class MysqlHolder {
		private static final MySQLManager INSTANCE = new MySQLManager();
	}

	private MySQLManager() {
		options = new HashMap<String, String>();

		String userDir = System.getProperties().getProperty("user.dir");
		File mysqlConfig = new File(userDir + File.separator + "config" + File.separator + "mysql.properties");
		if (mysqlConfig.exists()) {
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(mysqlConfig));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < option.length; i++) {
				options.put(option[i], properties.getProperty(option[i]));
			}
		}
	}

	public static final void setOptions(HashMap<String, String> op) {
		for (int i = 0; i < option.length; i++) {
			options.put(option[i], op.get(option[i]));
		}
	}

	public static final void setOptions(String mysql_url, String mysql_user, String mysql_password) {
		options.put("url", mysql_url);
		options.put("user", mysql_user);
		options.put("password", mysql_password);
	}

	public static final void setOptions(MySQLConnection ob) {
		options.put("url", ob.getUrl());
		options.put("user", ob.getUser());
		options.put("password", ob.getPassword());
	}

	public static final MySQLManager getSingleton() {
		return MysqlHolder.INSTANCE;
	}

	public static final Connection getConnection() throws Exception {
		Connection connection = null;
		String url = options.get("url");
		String user = options.get("user");
		String password = options.get("password");
		if (url == null || user == null || password == null) {
			throw new Exception("connection null");
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
