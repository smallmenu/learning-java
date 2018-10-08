package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.future.Data;
import com.niuchaoqun.example.thread.future.Host;

/**
 * Future 模式基于 FutureTask 实现
 *
 */
public class Future {
    public static void run(String[] args) {
        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("data1=" +data1.getContent());
        System.out.println("data2=" +data2.getContent());
        System.out.println("data3=" +data3.getContent());
    }
}
