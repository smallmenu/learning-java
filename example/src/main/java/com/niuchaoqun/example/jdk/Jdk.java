package com.niuchaoqun.example.jdk;

import com.niuchaoqun.driver.ExampleDriver;

public class Jdk {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("date", DateExample.class, "date example");
            pd.addClass("date8", Date8Example.class, "jdk 8 date example");
            pd.addClass("list", ListExample.class, "list example");
            pd.addClass("set", SetExample.class, "set example");
            pd.addClass("map", MapExample.class, "map example");
            pd.addClass("collection", CollectionExample.class, "collection example");
            pd.addClass("io", IoExample.class, "io example");
            pd.addClass("uuid", UuidExample.class, "uuid example");
            pd.addClass("format", FormatExample.class, "format example");
            pd.addClass("net", NetExample.class, "net example");
            pd.addClass("atomic", AtomicExample.class, "atomic example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println(exitCode);
    }
}
