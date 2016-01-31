package com.niuchaoqun.example;

import com.niuchaoqun.driver.ExampleDriver;
import com.niuchaoqun.example.advance.Advance;
import com.niuchaoqun.example.basic.Basic;
import com.niuchaoqun.example.database.Database;
import com.niuchaoqun.example.pattern.Pattern;

public class Example {
	public static void main(String[] args) {
		// just for debug
		String[] argv = {"database", "redis"};args = argv;
		
		if (args.length < 2) {
			System.err.println("Usage: example sub-example");
		}

		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("basic", Basic.class, "basic example group: such as syntax, string, date, io etc. ");
			pd.addClass("advance", Advance.class, "advance example group: such as thread, json, slf4j etc. ");
			pd.addClass("database", Database.class, "database example group: such as mysql, redis etc. ");
			pd.addClass("pattern", Pattern.class, "pattern example group: such singleton etc. ");
			
			exitCode = pd.run(args, 0);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
