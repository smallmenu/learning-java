package com.niuchaoqun.example.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 等待、通知机制
 *
 * 等待、通知机制相关方法是任意 Java 对象都具备的，
 */
public class ThreadWaitNotifyExample {
    static boolean flag = true;
    static Object lock = new Object();

    public static void run(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Wait implements Runnable {
        @Override
        public void run() {

            // 获取锁
            synchronized (lock) {

                // 条件不满足的时候，继续 wait
                while (flag) {
                    try {
                        String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH时mm分ss秒"));
                        System.out.println(Thread.currentThread() + "flag is true, wait @" + thisTime);

                        // 调用该方法的线程进入 WAITING 状态，只有等待线程的通知或中断才会返回，调用 wait() 会释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 条件满足时，完成工作
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH时mm分ss秒"));
                System.out.println(Thread.currentThread() + "flag is false, running @" + thisTime);
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {

            // 获取锁
            synchronized (lock) {
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH时mm分ss秒"));
                System.out.println(Thread.currentThread() + "hold lock start notify @" + thisTime);

                // 通知所有等待在该对象上的线程
                // 通知不会释放锁，直到当前线程释放了 lock 以后，WaitThread 才能从 wait 中返回
                lock.notifyAll();
                flag = false;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock) {
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH时mm分ss秒"));
                System.out.println(Thread.currentThread() + "hold lock again @" + thisTime);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
