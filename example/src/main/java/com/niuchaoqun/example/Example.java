package com.niuchaoqun.example;

import com.niuchaoqun.driver.ExampleDriver;
import com.niuchaoqun.example.advance.Advance;
import com.niuchaoqun.example.algorithm.Algorithm;
import com.niuchaoqun.example.apache.Apache;
import com.niuchaoqun.example.basic.Basic;
import com.niuchaoqun.example.database.Database;
import com.niuchaoqun.example.jdk.Jdk;
import com.niuchaoqun.example.thread.Threads;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Example 启动器
 *
 * @author niuchaoqun
 */
@Slf4j
public class Example {

    public static void main(String[] args) {
        // just for debug
        String[] argv = {"basic", "reference"};
        args = argv;

        if (args.length < 2) {
            System.err.println("Usage: example sub-example");
        }

        log.info(ArrayUtils.toString(args));

        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();

        try {
            // Java 基础示例
            pd.addClass("basic", Basic.class, "Java Basic Example:");
            // Java JDK 示例
            pd.addClass("jdk", Jdk.class, "Java Jdk Example:");

            pd.addClass("advance", Advance.class, "advance group:");
            pd.addClass("algorithm", Algorithm.class, "algorithm example:");
            pd.addClass("database", Database.class, "database example: such as mysql, redis etc. ");
            pd.addClass("apache", Apache.class, "apache common example: such as lang, codec etc. ");
            pd.addClass("thread", Threads.class, "thread example:");

            exitCode = pd.run(args, 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("SubExample exit with " + exitCode);
    }
}
