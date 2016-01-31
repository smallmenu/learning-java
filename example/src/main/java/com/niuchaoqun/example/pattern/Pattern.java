package com.niuchaoqun.example.pattern;

import com.niuchaoqun.driver.ExampleDriver;

public class Pattern {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("singleton", SingletonExample.class, "singleton example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
