package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.countup.CountupThread;

public class Countup {
    public static void run(String[] args) {
        System.out.println("main Begin");

        try {
            // 启动线程
            CountupThread t = new CountupThread();
            t.start();

            Thread.sleep(10000);

            // 终止线程
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");

            // 等待线程终止
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main: End");
    }
}
