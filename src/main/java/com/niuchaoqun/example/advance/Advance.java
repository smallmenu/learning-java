package com.niuchaoqun.example.advance;

import com.niuchaoqun.driver.ExampleDriver;
import com.niuchaoqun.example.advance.FastjsonExample;
import com.niuchaoqun.example.advance.GsonExample;
import com.niuchaoqun.example.advance.HashExample;
import com.niuchaoqun.example.advance.Slf4jExample;


public class Advance {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("fastjson", FastjsonExample.class, "fastjson example");
			pd.addClass("gson", GsonExample.class, "gson example");
			pd.addClass("hash", HashExample.class, "hash example");
			pd.addClass("slf4j", Slf4jExample.class, "slf4j example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
