package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.tpm.Host2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread-Per-Message 模式（2）
 *
 * ThreadFactory 接口隐藏了线程创建的细节，并未隐藏线程创建的操作
 * Executor 接口提供将线程执行抽象化的接口
 *
 * ExecutorService 接口是 Executor 子接口，对可以反复 execute 的服务进行了抽象化
 *
 */
public class ThreadPerMessage2 {
    public static void run(String[] args) {
        System.out.println("main begin");

        /*
        * 使用 Executors.newCachedThreadPool 创建可复用线程 ExecutorService 对象
        *
        * new Executor() {
        *     @Override
        *     public void execute(Runnable command) {
        *         new Thread(command).start();
        *     }
        * }
        */
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host2 host = new Host2(executorService);

        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main End");
        }
    }
}
