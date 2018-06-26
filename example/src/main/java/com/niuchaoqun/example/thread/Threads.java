package com.niuchaoqun.example.thread;

import com.niuchaoqun.driver.ExampleDriver;

public class Threads {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("thread1", Thread1Example.class, "extend and interface");
            pd.addClass("thread2", Thread2Example.class, "extend and interface");
            pd.addClass("threadsync", ThreadSyncExample.class, "thread example，synchronized");
            pd.addClass("threadstate", ThreadStateExample.class, "thread state example");
            pd.addClass("threadshutdown", ThreadShutdownExample.class, "thread state example");
            pd.addClass("threadwaitnotify", ThreadWaitNotifyExample.class, "thread state example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.exit(exitCode);
    }
}
