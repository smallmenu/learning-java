package com.niuchaoqun.example.database;

import redis.clients.jedis.Jedis;

public class RedisExample {
	public static void run(String[] args) {
		System.out.println("redis");
	}
	
	public static void RedisExample() {		
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}
}
