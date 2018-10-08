package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.cyclic.MyTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    private final static int THREADS = 3;

    public static void run(String[] args) {
        System.out.println("main: Begin");

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        // 屏障被解除时的操作
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action");
            }
        };

        // 用于使线程步调一致
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS, barrierAction);

        // CountDownLatch 用于确认工作是否结束
        CountDownLatch countDownLatch = new CountDownLatch(THREADS);

        try {
            for (int i = 0; i < THREADS; i++) {
                executorService.execute(new MyTask(cyclicBarrier, countDownLatch, i));
            }

            System.out.println("Await");

            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            System.out.println("main: End");
        }


    }
}
