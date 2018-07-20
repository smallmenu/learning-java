package com.niuchaoqun.example.thread;

import com.niuchaoqun.driver.ExampleDriver;

public class Threads {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("thread1", Thread1Example.class, "extend and interface");
            pd.addClass("thread2", Thread2Example.class, "extend and interface");
            pd.addClass("threadlocal", ThreadLocalExample.class, "threadlocal example");
            pd.addClass("thread_sync", ThreadSyncExample.class, "thread example，synchronized");
            pd.addClass("thread_state", ThreadStateExample.class, "thread state example");
            pd.addClass("thread_shutdown", ThreadShutdownExample.class, "thread state example");
            pd.addClass("thread_waitnotify", ThreadWaitNotifyExample.class, "thread state example");
            pd.addClass("thread_pool", ThreadPoolExample.class, "thread pool example");
            pd.addClass("connection_pool", ConnectionPoolExample.class, "thread state example");
            pd.addClass("semaphore", SemaphoreExample.class, "thread semaphore example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.exit(exitCode);
    }
}
