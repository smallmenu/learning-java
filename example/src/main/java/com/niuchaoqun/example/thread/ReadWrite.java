package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.readwrite.DataReentrant;
import com.niuchaoqun.example.thread.readwrite.ReaderThread;
import com.niuchaoqun.example.thread.readwrite.WriterThread;

/**
 * Read-Write Lock 模式基于 ReentrantReadWriteLock 实现
 *
 * Read-Write 模式中，读取和写入是分开考虑的，在执行读取操作之前，线程必须获取用于读取的锁，在执行写入操作之前，线程必须获取写入的锁。
 * 当线程读取时，实例状态不会发生变化，所以多个线程可以同时读取，但读取时，不可以写入。
 * 当线程写入时，实例状态会发生变化，所以当有一个线程正在写入时，其他线程不可以读取，也不可以写入。
 *
 * 适用：
 * 适合读取操作繁重
 * 读取频率比写入频率高
 *
 *
 */
public class ReadWrite {
    public static void run(String[] args) {
        DataReentrant data = new DataReentrant(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data, "abcdefghijklmnopq").start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
