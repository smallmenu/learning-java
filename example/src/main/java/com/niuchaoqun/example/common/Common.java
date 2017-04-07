package com.niuchaoqun.example.common;

import com.niuchaoqun.driver.ExampleDriver;

public class Common {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("lang", LangExample.class, "lang3 example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.exit(exitCode);
    }
}
