package com.niuchaoqun.example.thread.readwrite;

public final class ReadWriteLock {
    // 正在读取的线程个数
    private int readingReaders = 0;
    // 正在写入的线程个数
    private int writingWriters = 0;
    // 正在等待写入的线程个数
    private int waitingWriters = 0;
    // 若写入优先，则为 true
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        // 正在读取的线程个数+1
        readingReaders++;
    }

    public synchronized void readUnlock() {
        // 正在读取的线程个数-1
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        // 正在等待写入的线程个数+1
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            // 正在等待写入的线程个数-1
            waitingWriters--;
        }
        // 正在写入的线程个数+1
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        // 正在写入的线程个数-1
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }


}
