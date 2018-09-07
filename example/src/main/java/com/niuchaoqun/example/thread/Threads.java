package com.niuchaoqun.example.thread;

import com.niuchaoqun.driver.ExampleDriver;

public class Threads {
    public static void run(String[] args) {
        int exitCode = -1;
        ExampleDriver pd = new ExampleDriver();
        try {
            pd.addClass("thread1", Thread1Example.class, "extend and interface");
            pd.addClass("thread2", Thread2Example.class, "extend and interface");
            pd.addClass("thread_pool", ExampleThreadPool.class, "thread pool example");
            pd.addClass("connection_pool", ExampleConnectionPool.class, "thread state example");
            pd.addClass("threadlocal", ExampleThreadLocal.class, "threadlocal example");
            pd.addClass("thread_sync", ExampleThreadSync.class, "thread example，synchronized");
            pd.addClass("thread_state", ExampleThreadState.class, "thread state example");
            pd.addClass("thread_shutdown", ExampleThreadShutdown.class, "thread state example");
            pd.addClass("thread_waitnotify", ThreadWaitNotifyExample.class, "thread state example");
            pd.addClass("semaphore", SemaphoreExample.class, "thread semaphore example");
            pd.addClass("producer_consumer", ProducerConsumer.class, "thread semaphore example");
            pd.addClass("exchanger", ExchangerExample.class, "exchanger example");
            pd.addClass("read_write", ReadWrite.class, "readwrite lock example");
            pd.addClass("thread_per_message1", ThreadPerMessage1.class, "thread per message example");
            pd.addClass("thread_per_message2", ThreadPerMessage2.class, "thread per message example");
            pd.addClass("worker_thread", WorkerThread.class, "worker-thread example");

            exitCode = pd.run(args, 1);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println(exitCode);
    }
}
