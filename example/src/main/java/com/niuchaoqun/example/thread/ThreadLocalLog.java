package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.threadlocal.ClientThread;

public class ThreadLocalLog {
    public static void run(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
