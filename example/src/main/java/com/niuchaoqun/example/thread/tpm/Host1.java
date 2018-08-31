package com.niuchaoqun.example.thread.tpm;

import java.util.concurrent.ThreadFactory;

public class Host1 {
    private final Helper helper = new Helper();

    private final ThreadFactory threadFactory;

    public Host1(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println("request (" + count + " , " + c + ") begin");

        threadFactory.newThread(
            new Runnable() {
                @Override
                public void run() {
                    helper.handle(count, c);
                }
            }
        ).start();

        System.out.println("request (" + count + " , " + c + ") end");
    }
}
