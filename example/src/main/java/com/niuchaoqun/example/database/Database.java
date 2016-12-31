package com.niuchaoqun.example.database;

import com.niuchaoqun.driver.ExampleDriver;

import com.niuchaoqun.example.database.MySQLSimpleExample;
import com.niuchaoqun.example.database.MySQLManagerExample;
import com.niuchaoqun.example.database.RedisExample;
import com.niuchaoqun.example.database.MemcacheExample;

public class Database {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("mysqlsimple", MySQLSimpleExample.class, "mysqlsimple example");
			pd.addClass("mysqlmanager", MySQLManagerExample.class, "mysqlmanager example");
			pd.addClass("redis", RedisExample.class, "redis example");
			pd.addClass("memcache", RedisExample.class, "memcache example");
			
			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
