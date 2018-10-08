package com.niuchaoqun.example.thread.cyclic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements Runnable {
    private static final int PHASE = 5;

    private final CyclicBarrier cyclicBarrier;

    private final CountDownLatch countDownLatch;

    private final int context;

    private final static Random random = new Random(1234);

    public MyTask(CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch, int context) {
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < PHASE; i++) {
                doPhase(i);
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    protected void doPhase(int phase) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " :MyTask:Begin:context = " + context + ", phase = " + phase);

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " :MyTask:End:context = " + context + ", phase = " + phase);
        }
    }
}
