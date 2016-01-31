package com.niuchaoqun.example.database;

import com.niuchaoqun.driver.ExampleDriver;

import com.niuchaoqun.example.database.MySQLSimpleExample;
import com.niuchaoqun.example.database.RedisExample;

public class Database {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("mysqlsimple", MySQLSimpleExample.class, "mysqlsimple example");
			pd.addClass("redis", RedisExample.class, "redis example");
			
			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
