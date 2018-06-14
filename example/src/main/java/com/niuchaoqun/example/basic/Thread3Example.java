package com.niuchaoqun.example.basic;

public class Thread3Example {
    public static void run(String[] args) {
        Runnable runnable = new RunnableThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        // 启用同步的多线程
        RsyncThread rsyncThread = new RsyncThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(rsyncThread);
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class RunnableThread implements Runnable {
        private int ticket = 5;

        @Override
        public void run() {
            System.out.println("RunnableThread:" + Thread.currentThread().getName() + " running");
            for (int i = 0; i < 100; i++) {
                if (ticket > 0) {
                    // 加入延迟，会导致ticket出现负值
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable ticket=" + ticket--);
                }
            }
        }
    }

    public static class RsyncThread implements Runnable {
        private int ticket = 5;

        @Override
        public void run() {
            System.out.println("RsyncThread:" + Thread.currentThread().getName() + " running");
            for (int i = 0; i < 100; i++) {
                this.sale();
            }
        }

        public synchronized void sale() {
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("rsync ticket=" + ticket--);
            }
        }
    }
}
