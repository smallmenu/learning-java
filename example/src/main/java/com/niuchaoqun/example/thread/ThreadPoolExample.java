package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.threadpool.MyThreadPool;

import java.util.concurrent.CountDownLatch;

/**
 * 一个简单的线程池技术
 *
 * 线程池的应用场景为，需要处理的任务多，执行时间短，需要服务端快速处理并返回结果
 * 这种情况频繁的创建销毁线程会带来额外的消耗，并且线程过多也会带来过多的上下文切换
 *
 * 该线程池演示计算密集型任务，共执行200个任务，当前CPU 15个线程已经是极限（16核CPU）
 *
 * 5 个线程 耗时 11457ms  30%
 * 10个线程 耗时 8019ms   65%
 * 15个线程 耗时 7427ms   95%
 * 20个线程 耗时 7290ms   99%
 * 30个线程 耗时 7390ms   99%
 * 50个线程 耗时 7358ms   99%
 */
public class ThreadPoolExample {
    // 监控运行状态
    public static CountDownLatch monitor;

    public static void run(String[] args) {
        int taskNum = 200;
        monitor = new CountDownLatch(taskNum);

        long start = System.currentTimeMillis();

        MyThreadPool<Runnable> myThreadPool = new MyThreadPool<>(100);
        for (int i = 0; i < taskNum; i++) {
            Task task = new Task(i+1);
            myThreadPool.execute(task);
        }

        try {
            // 先阻塞在这里，直到所有线程执行完毕，即 end 的 count = 0
            monitor.await();
            System.out.println("Total: " + (System.currentTimeMillis() - start) + " ms");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        private int id;

        public Task(int i) {
            id = i;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (long i = 0; i < 1000000000; i++) {
            }
            long time = System.currentTimeMillis() - start;
            System.out.println(Thread.currentThread().getName() + " Run No." + id + " "+ time + "ms");

            // 执行完一个
            monitor.countDown();
        }
    }
}
