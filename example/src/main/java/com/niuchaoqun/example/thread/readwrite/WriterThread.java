package com.niuchaoqun.example.thread.readwrite;

import java.util.Random;

public class WriterThread extends Thread {

    public static final Random random = new Random();

    private final DataReentrant data;

    private final String filler;

    private int index = 0;

    public WriterThread(DataReentrant data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextchar();
                data.write(c);
                System.out.println(Thread.currentThread().getName() + " write " + c);
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {

        }
    }

    private char nextchar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
