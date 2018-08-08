package com.niuchaoqun.example.thread.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread {
    private final Exchanger<char[]> exchanger;

    private char[] buffer = null;

    private final Random random;

    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                // 交换缓冲区
                System.out.println(Thread.currentThread().getName() + " : Before exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + " : After exchange");

                // 从缓冲区取字符
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName() + " : -> " + buffer[i]);
                    Thread.sleep(random.nextInt(500));
                }
            }

        } catch (InterruptedException e) {

        }
    }
}
