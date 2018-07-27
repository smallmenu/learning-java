package com.niuchaoqun.example.thread.pc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 基于 ArrayBlockingQueue 实现的 Table
 */
public class TableABQ extends ArrayBlockingQueue<String> {
    public TableABQ(int count) {
        super(count);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }
}
