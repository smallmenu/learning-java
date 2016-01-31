package com.niuchaoqun.example.advance;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jExample {
	private static final Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

	public static void run(String[] args) {
		example();
	}

	public static void example() {
		String config = System.getProperty("user.dir") + File.separator + "config" + File.separator;

		PropertyConfigurator.configure(config + "log4j.properties");

		String string1 = "string1";
		String string2 = "string2";

		logger.trace("trace log {} {}", string1, string2);
		logger.debug("debug log {}", string1);
		logger.info("info log");
		logger.warn("warn log");
		logger.error("error log");
	}
}
