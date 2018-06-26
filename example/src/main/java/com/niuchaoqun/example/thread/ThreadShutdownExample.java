package com.niuchaoqun.example.thread;

/**
 * 安全终止线程的两种方法
 */
public class ThreadShutdownExample {
    public static void run(String[] args) {
        Runner one = new Runner();
        Thread countThread1 = new Thread(one, "CountThread");
        countThread1.start();

        // 主线程睡眠 1 秒，让 one 充分运行 1 秒后，然后对其中断
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countThread1.interrupt();

        // 主线程睡眠 1 秒，让 two 充分运行 1 秒后，然后通过类标识变量对其终止
        Runner two = new Runner();
        Thread countThread2 = new Thread(two, "CountThread");
        countThread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        two.stop();

        try {
            Thread.sleep(100);
            System.out.println("Stopped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Runner implements Runnable {
        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void stop() {
            on = false;
        }
    }
}
