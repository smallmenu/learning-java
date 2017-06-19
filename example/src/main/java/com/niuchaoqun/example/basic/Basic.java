package com.niuchaoqun.example.basic;

import com.niuchaoqun.driver.ExampleDriver;

import com.niuchaoqun.example.basic.SyntaxExample;
import com.niuchaoqun.example.basic.StringExample;
import com.niuchaoqun.example.basic.CollectionExample;
import com.niuchaoqun.example.basic.DateExample;
import com.niuchaoqun.example.basic.IoExample;
import com.niuchaoqun.example.basic.PropertiesExample;
import com.niuchaoqun.example.basic.NetExample;
import com.niuchaoqun.example.basic.RandomNumberExample;
import com.niuchaoqun.example.basic.RuntimeExample;
import com.niuchaoqun.example.basic.SystemExample;

public class Basic {
	public static void run(String[] args) {
		int exitCode = -1;
		ExampleDriver pd = new ExampleDriver();
		try {
			pd.addClass("syntax", SyntaxExample.class, "syntax example");
			pd.addClass("string", StringExample.class, "string example");
			pd.addClass("collection", CollectionExample.class, "collection example");
			pd.addClass("date", DateExample.class, "date example");
			pd.addClass("date8", Date8Example.class, "date example");
			pd.addClass("io", IoExample.class, "io example");
			pd.addClass("properties", PropertiesExample.class, "properties example");
			pd.addClass("net", NetExample.class, "net example");
			pd.addClass("random", RandomNumberExample.class, "random and number example");
			pd.addClass("runtime", RuntimeExample.class, "runtime example");
			pd.addClass("system", SystemExample.class, "system example");
			pd.addClass("array", ArrayExample.class, "array example");
			pd.addClass("math", MathExample.class, "math example");

			exitCode = pd.run(args, 1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.exit(exitCode);
	}
}
