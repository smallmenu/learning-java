package com.niuchaoqun.example.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 等待、通知机制（Guarded Suspension 模式）
 *
 * 等待wait()、通知notify()机制相关方法是任意 Java 对象都具备的
 *
 * 使用 wait()、notify() 时需要先对对象加锁，调用 wait() 后会释放对象的锁
 * notify() 时不会释放锁，会运行直到当前线程释放锁
 * notify() 时线程选择是不可靠的，和 wait 先后没有关系
 * 一般来说notify()唤醒的线程较少，处理速度和性能要快一些， 但 notifyAll() 要更健壮。
 *
 * 等待方遵循原则：
 * 1. 获取对象的锁
 * 2. 如果条件不满足，则调用对象的 wait() 方法，被通知后仍然要检查条件
 * 3. 条件满足执行对应的逻辑
 * synchronized (对象) {
 *     while (条件不满足) {
 *         对象.wait()
 *     }
 *     执行对应的逻辑
 * }
 *
 * 通知方遵循的原则：
 * 1. 获取对象的锁
 * 2. 改变条件
 * 3. 通知（所有）等待在对象上的线程
 * synchronized (对象) {
 *     改变条件
 *     对象.notify()/notifyAll()
 * }
 *
 *
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
                        String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                        System.out.println(Thread.currentThread() + "flag is true, start wait, release lock @" + thisTime);

                        // 调用该方法的线程进入 WAITING 状态，只有等待线程的通知或中断才会返回，调用 wait() 会释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 条件满足时，完成工作
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println(Thread.currentThread() + "flag is false, running @" + thisTime);
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {

            // 获取锁
            synchronized (lock) {
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println(Thread.currentThread() + "hold lock, start notify @" + thisTime);

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

            // 再次获取锁占用，wait 可能因为获取不到锁而具有执行的不确定性
            synchronized (lock) {
                String thisTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
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
