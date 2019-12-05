package com.niuchaoqun.example.algorithm;

import com.niuchaoqun.driver.ExampleDriver;


public class Algorithm {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("sort", SortExample.class, "sort example");
            pd.addClass("test-contain", TestContainExample.class, "test contain example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println(exitCode);
    }
}
