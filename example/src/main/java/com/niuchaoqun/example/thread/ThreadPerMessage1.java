package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.tpm.Host1;
import java.util.concurrent.Executors;

/**
 * Thread-Per-Message 模式（1）
 *
 * ThreadFactory 接口，声明了 newThread 方法，提供了将线程创建抽象化的接口，避免了在 Host1 中 new Thread 的硬编码
 * 即：Host1 怎样创建线程，取决于构造函数传入的 ThreadFactory 对象
 *
 */
public class ThreadPerMessage1 {
    public static void run(String[] args) {
        System.out.println("main begin");

        /**
         * Executors.defaultThreadFactory()，返回了一个默认的 ThreadFactory 实现，用于替代：
         *
         * new ThreadFactory(
         *      public Thread newThread(Runnable r) {
         *          return new Thread(r);
         *      }
         * )
         */
        Host1 host = new Host1(Executors.defaultThreadFactory());

        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main End");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
