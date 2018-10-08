package com.niuchaoqun.example.thread.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    private final CountDownLatch countDownLatch;

    private final int context;

    private static final Random random = new Random(1234);

    public MyTask(CountDownLatch countDownLatch, int context) {
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        countDownLatch.countDown();
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " :MyTask:Begin:context = " + context);

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " :MyTask:End:context = " + context);
        }
    }
}
