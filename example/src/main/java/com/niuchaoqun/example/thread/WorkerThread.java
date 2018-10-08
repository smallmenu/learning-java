package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.wt.Channel;
import com.niuchaoqun.example.thread.wt.ClientThread;
import com.niuchaoqun.example.thread.wt.ClientThreadWithExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Worker Thread 模式基于 ExecutorService 实现线程池
 */
public class WorkerThread {
    public static void run(String[] args) {
        threadpool();
    }

    public static void channel() {
        // 工人线程的个数
        Channel channel = new Channel(10);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }

    public static void threadpool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            new ClientThreadWithExecutor("Alice", executorService).start();
            new ClientThreadWithExecutor("Bobby", executorService).start();
            new ClientThreadWithExecutor("Chris", executorService).start();

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
