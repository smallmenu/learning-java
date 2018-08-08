package com.niuchaoqun.example;

import com.niuchaoqun.driver.ExampleDriver;
import com.niuchaoqun.example.advance.Advance;
import com.niuchaoqun.example.algorithm.Algorithm;
import com.niuchaoqun.example.apache.Apache;
import com.niuchaoqun.example.basic.Basic;
import com.niuchaoqun.example.database.Database;
import com.niuchaoqun.example.jdk.Jdk;
import com.niuchaoqun.example.thread.Threads;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {

    private static final Logger log = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        // just for debug
        String[] argv = {"thread", "worker-thread"};
        args = argv;

        if (args.length < 2) {
            System.err.println("Usage: example sub-example");
        }

        log.info(ArrayUtils.toString(args));

        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();

        try {
            pd.addClass("basic", Basic.class, "basic example:");
            pd.addClass("thread", Threads.class, "thread example:");
            pd.addClass("jdk", Jdk.class, "jdk example:");
            pd.addClass("advance", Advance.class, "advance group:");
            pd.addClass("algorithm", Algorithm.class, "algorithm example:");
            pd.addClass("database", Database.class, "database example: such as mysql, redis etc. ");
            pd.addClass("apache", Apache.class, "apache common example: such as lang, codec etc. ");
            exitCode = pd.run(args, 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.exit(exitCode);
    }
}
