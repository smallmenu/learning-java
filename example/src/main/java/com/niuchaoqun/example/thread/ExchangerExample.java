package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.exchanger.ConsumerThread;
import com.niuchaoqun.example.thread.exchanger.ProducerThread;

import java.util.concurrent.Exchanger;

/**
 * java.util.concurrent.Exchanger 类用于让两个线程安全的交换对象，实现了 Producer-Consumer 模式
 */
public class ExchangerExample {
    public static void run(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerThread(exchanger, buffer1, 1234).start();
        new ConsumerThread(exchanger, buffer2, 2343).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
