package com.niuchaoqun.example.advance;

public class ThreadExample {
    public static void run(String[] args) {
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            new Thread("" + i) {
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread:" + getName() + " running");
                }
            }.start();
        }

    }
}
