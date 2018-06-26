package com.niuchaoqun.example.basic;

import com.niuchaoqun.driver.ExampleDriver;

public class Basic {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("type", TypeExample.class, "java basic type example");
			pd.addClass("string", StringExample.class, "string simple example");
			pd.addClass("array", ArrayExample.class, "Arrays function example");
			pd.addClass("math", MathExample.class, "Math function example");
			pd.addClass("regular", RegularExample.class, "regular example");
			pd.addClass("properties", PropertiesExample.class, "properties example");
			pd.addClass("random", RandomExample.class, "random and number example");
			pd.addClass("runtime", RuntimeExample.class, "runtime example");
			pd.addClass("system", SystemExample.class, "system example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
