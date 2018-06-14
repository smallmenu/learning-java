package com.niuchaoqun.example.basic;

import com.niuchaoqun.driver.ExampleDriver;

public class Basic {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("type", TypeExample.class, "date type example");
			pd.addClass("string", StringExample.class, "string example");
			pd.addClass("array", ArrayExample.class, "array example");
			pd.addClass("math", MathExample.class, "math example");
			pd.addClass("regular", RegularExample.class, "syntax example");
			pd.addClass("properties", PropertiesExample.class, "properties example");
			pd.addClass("random", RandomExample.class, "random and number example");
			pd.addClass("runtime", RuntimeExample.class, "runtime example");
			pd.addClass("system", SystemExample.class, "system example");
			pd.addClass("thread1", Thread1Example.class, "thread example");
			pd.addClass("thread2", Thread2Example.class, "thread example");
			pd.addClass("thread3", Thread3Example.class, "thread example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
