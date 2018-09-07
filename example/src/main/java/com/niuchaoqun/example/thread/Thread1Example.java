package com.niuchaoqun.example.thread;

/**
 * Java 实现多线程编程
 */
public class Thread1Example {
    public static void run(String[] args) {
        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());
        // 获取当前线程序号
        System.out.println(Thread.currentThread().getId());
        // 获取当前线程优先级
        System.out.println(Thread.currentThread().getPriority());

        extendThread();
        runnableThread();
    }

    public static void extendThread() {
        // 继承 Thread 类
        for (int i = 0; i < 10; i++) {
            ExtendThread extendThread = new ExtendThread();
            extendThread.setName("e" + i);
            extendThread.start();
        }

    }

    public static void runnableThread() {
        // 实现 Runnable 接口
        RunnableThread runnableThread = new RunnableThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnableThread, "r" + i);
            thread.start();
        }
    }

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("ExtendThread:" + getName() + " running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RunnableThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("RunnableThread:" + Thread.currentThread().getName() + " running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
