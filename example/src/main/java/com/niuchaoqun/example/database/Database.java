package com.niuchaoqun.example.database;

import com.niuchaoqun.driver.ExampleDriver;

public class Database {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("mysql", MySQLExample.class, "mysqlsimple example");
			pd.addClass("redis", RedisExample.class, "redis example");
			pd.addClass("memcache", RedisExample.class, "memcache example");
			
			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
