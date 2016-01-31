package com.niuchaoqun.example.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisExample {
	public static void run(String[] args) {
		single();
		pool();
	}

	public static void single() {
		// A single Jedis instance is not threadsafe!
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);

		System.out.println("=====");
	}

	public static void pool() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = null;

		try {
			jedis = pool.getResource();
			jedis.set("foo", "bar");
			String foobar = jedis.get("foo");
			System.out.println(foobar);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		pool.destroy();
	}
}
