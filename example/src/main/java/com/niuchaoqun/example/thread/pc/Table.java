package com.niuchaoqun.example.thread.pc;

/**
 * 基于 wait 和 notify 实现的 Table
 */
public class Table {
    // 缓冲区
    private final String[] buffer;
    // 下次 put 的位置
    private int tail;
    // 下次 take 的位置
    private int head;
    // buffer中的个数
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /**
     * 放置蛋糕
     *
     * @param cake
     * @throws InterruptedException
     */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);

        while (count >buffer.length) {
            wait();
        }

        buffer[tail] = cake;
        tail = (tail +1) % buffer.length;
        count++;

        notifyAll();
    }

    /**
     * 获取蛋糕
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }

        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;

        notifyAll();

        System.out.println(Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }
}
