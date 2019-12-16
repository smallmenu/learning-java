package com.niuchaoqun.example.advance;

import com.niuchaoqun.driver.ExampleDriver;


public class Advance {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("fastjson", FastjsonExample.class, "fastjson example");
			pd.addClass("gson", GsonExample.class, "gson example");
			pd.addClass("hash", HashExample.class, "hash example");
			pd.addClass("slf4j", Slf4jExample.class, "slf4j example");
			pd.addClass("okhttp", OkhttpExample.class, "slf4j example");
			pd.addClass("quartz", QuartzExample.class, "quartz example");
			pd.addClass("useragent", UseragentExample.class, "useragent example");
            pd.addClass("js", JsExample.class, "js example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(exitCode);
	}
}
