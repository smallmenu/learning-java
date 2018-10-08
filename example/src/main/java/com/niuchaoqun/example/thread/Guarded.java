package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.guarded.ClientThread;
import com.niuchaoqun.example.thread.guarded.RequestQueue;
import com.niuchaoqun.example.thread.guarded.ServerThread;

public class Guarded {
    public static void run(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Client", 1234L).start();
        new ServerThread(requestQueue, "Server", 8793L).start();
    }
}
