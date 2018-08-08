package com.niuchaoqun.example.thread.wt;

import java.util.Random;

public class RequestWithRunnable implements Runnable {
    // 委托者
    private final String name;
    // 请求编号
    private final int number;

    private static final Random random = new Random();

    public RequestWithRunnable(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {

        }
    }



    public String toString() {
        return "[ Request from " + name + " No." + number +"]";
    }
}
