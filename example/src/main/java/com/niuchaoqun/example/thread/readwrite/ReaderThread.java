package com.niuchaoqun.example.thread.readwrite;

public class ReaderThread extends Thread {

    private final DataReentrant data;

    public ReaderThread(DataReentrant data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() +" reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {

        }
    }
}
