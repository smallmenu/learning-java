package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.tpm.Host;

import java.util.concurrent.Executor;

public class ThreadPerMessage {
    public static void run(String[] args) {
        System.out.println("main begin");

        Host host = new Host(
                new Executor() {
                    @Override
                    public void execute(Runnable command) {
                        new Thread(command).start();
                    }
                }
        );

        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main End");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
