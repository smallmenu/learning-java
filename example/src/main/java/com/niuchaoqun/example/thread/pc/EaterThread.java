package com.niuchaoqun.example.thread.pc;

import java.util.Random;

public class EaterThread extends Thread {

    private final Random random;

    private final TableABQ table;

    public EaterThread(String name, TableABQ table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {

        }
    }
}
