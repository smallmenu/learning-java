package com.niuchaoqun.example.thread;

/**
 * 演示了线程的几种常用的状态
 * 可通过 jstack pid 进行监控
 */
public class ExampleThreadState {
    public static void run(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        // 第一次获得了锁，然后sleep使其进入了 TIME_WAITING 状态
        new Thread(new Blocked(), "BlockedThread-1").start();
        // 获取不到锁，是 BLOCKED 状态
        new Thread(new Blocked(), "BlockedThread-2").start();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * TIME_WAITING 状态，表示超时等待
     * 不同于Waiting，可以在一定的时间自行返回
     */
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * WAITING 状态，表示等待状态
     * 表示该线程进入等待状态，需要等待其他线程做出特定动作（通知或中断）
     * 使用 wait() 必须先获取锁
     */
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * BLOCKED 状态，阻塞状态，表示线程阻塞于锁
     */
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
