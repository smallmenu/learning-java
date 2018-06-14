package com.niuchaoqun.example.basic;

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

        // 多线程模式下，主线程可能没有等待多线程执行完毕就会结束
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void extendThread() {
        // 继承 Thread 类
        for (int i = 0; i < 100; i++) {
            ExtendThread extendThread = new ExtendThread();
            extendThread.start();
        }

    }

    public static void runnableThread() {
        // 实现 Runnable 接口
        RunnableThread runnableThread = new RunnableThread();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnableThread, "r" + i);
            thread.start();
        }
    }

    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("ExtendThread:" + getName() + " running");
        }
    }

    public static class RunnableThread implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableThread:" + Thread.currentThread().getName() + " running");
        }
    }
}
