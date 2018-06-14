package com.niuchaoqun.example.jdk;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicExample {
    /**
     * 类似 AtomicLong 这些类提供了原子操作方法，支持多线程
     * 其主要借助于CAS(Compare And Swap)算法，一种需要依赖CPU的CAS指令，提供的无锁算法
     * 这是一种乐观锁，也就是假设冲突不会发生，在提交时检查数据准确性
     *
     * 语义：内存值V，预期值A，新值B。线程认为V的值应该是A，如果是，将V更新为B，否则再次尝试（循环下去）
     *
     * @param args
     */
    public static void run(String[] args) {
        simple();
        atomic();
    }

    public static void simple() {
        SimpleCounter counter = new SimpleCounter();
        SimpleThread simpleThread = new SimpleThread(counter);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(simpleThread);
            thread.start();
        }

        // 主线程等待，让其执行一会看结果
        try {
            Thread.sleep(3000);
            System.out.println(counter.getCounter());
            System.out.println("----- simple -----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void atomic() {
        AtomicCounter counter = new AtomicCounter();
        AtomicThread atomicThread = new AtomicThread(counter);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(atomicThread);
            thread.start();
        }

        // 主线程等待，让其执行一会看结果
        try {
            Thread.sleep(3000);
            System.out.println(counter.getCounter());
            System.out.println("----- atomic -----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计数器
     */
    public static class SimpleCounter {
        private long counter = 0;

        public long getCounter() {
            return counter;
        }

        // 如果不使用同步，在多线程情况下，得不到正确计数器结果
        public void increment() {
            counter++;
        }
    }

    public static class AtomicCounter {
        private AtomicLong counter = new AtomicLong(0);

        public long getCounter() {
            return counter.get();
        }

        public void increment() {
            counter.incrementAndGet();
        }
    }

    /**
     *  模拟一个线程执行10000次任务
     */
    public static class SimpleThread implements Runnable {
        private SimpleCounter counter;

        public SimpleThread(SimpleCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                this.counter.increment();
            }
        }
    }

    public static class AtomicThread implements Runnable {
        private AtomicCounter counter;

        public AtomicThread(AtomicCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                this.counter.increment();
            }
        }
    }
}
