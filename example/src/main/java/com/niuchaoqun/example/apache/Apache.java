package com.niuchaoqun.example.apache;

import com.niuchaoqun.driver.ExampleDriver;

public class Apache {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("commons-lang", CommonsLang.class, "commons-lang example");
            pd.addClass("commons-io", CommonsIo.class, "commons-io example");
            pd.addClass("commons-codec", CommonsCodec.class, "commons-codec example");
            pd.addClass("httpclient", Httpclient.class, "commons-codec example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println(exitCode);
    }
}
