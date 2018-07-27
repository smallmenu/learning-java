package com.niuchaoqun.example.thread.pc;

import java.util.Random;

public class MakeThread extends Thread {
    // 蛋糕的流水号
    private static int id = 0;

    private final Random random;

    private final TableABQ table;

    public MakeThread(String name, TableABQ table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(500));
                String cake = "[Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
