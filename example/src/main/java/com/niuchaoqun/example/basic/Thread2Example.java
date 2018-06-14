package com.niuchaoqun.example.basic;

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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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

            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println("runnable ticket=" + ticket--);
                }
            }
        }
    }
}
