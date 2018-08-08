package com.niuchaoqun.example.thread.tpm;

import java.util.concurrent.Executor;

public class Host {
    private final Helper helper = new Helper();

    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println("request (" + count + " , " + c + ") begin");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        });
        System.out.println("request (" + count + " , " + c + ") end");
    }
}
