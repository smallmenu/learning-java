package com.niuchaoqun.example.thread.tpm;

public class Helper {
    public void handle(int count, char c) {
        System.out.println("handle (" + count + " , " + c + ") begin");
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(c);
        }
        System.out.println("handle (" + count + " , " + c + ") end");
    }
}
