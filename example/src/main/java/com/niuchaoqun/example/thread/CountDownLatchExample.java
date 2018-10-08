package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.countdown.MyTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    private static final int TASKS = 100;

    public static void run(String[] args) {
        System.out.println("Begin");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(TASKS);

        try {
            for (int i = 0; i < TASKS; i++) {
                executorService.execute(new MyTask(countDownLatch, i));
            }

            System.out.println("Await");

            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            System.out.println("End");
        }
    }
}