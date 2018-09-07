package com.niuchaoqun.example.thread;

/**
 * 继承 Thread 与实现 Runnable 接口的区别
 *
 * 1. 继承 Thread 类，不能实现资源共享。
 * 2. 避免 Java 单继承特性带来的局限
 * 3. 增强程序健壮性
 */
public class Thread2Example {
    public static void run(String[] args) {
        // 继承Thread，不能资源共享，因为是多个不同的实例
        for (int i = 0; i < 5; i++) {
            ExtendThread extendThread = new ExtendThread();
            extendThread.start();
        }

        // 实现 Runnable 可以实现资源共享
        Runnable runnable = new RunnableThread();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public static class ExtendThread extends Thread {
        private int ticket = 5;

        private int counter = 0;

        @Override
        public void run() {
            counter++;
            System.out.println(counter + ":ExtendThread:" + getName() + " running");

            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println("extend ticket=" + ticket--);
                }
            }

        }
    }

    public static class RunnableThread implements Runnable {
        private int ticket = 5;

        private int counter = 0;

        @Override
        public void run() {
            counter++;
            System.out.println(counter + ":RunnableThread:" + Thread.currentThread().getName() + " running");

            // 按照理解，未加锁多线程运行应该会出现负值，实际可能没出现
            // 原因是因为循环次数太少，CPU 运行太快了，在一个线程中立即运行完毕
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println("runnable ticket=" + ticket--);
                }
            }
        }
    }
}
