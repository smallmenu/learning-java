package com.niuchaoqun.example.thread.tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MyThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    // 线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最大限制
    private static final int MAX_WORKER_NUMBERS = 100;
    // 线程池最小限制
    private static final int MIN_WORKER_NUMBERS = 1;
    // 工作列表
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    // 工作者线程数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public MyThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public MyThreadPool(int workerNum) {
        this.workerNum = workerNum > MAX_WORKER_NUMBERS
                ? MAX_WORKER_NUMBERS
                : (workerNum < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : workerNum);
        initializeWorkers(this.workerNum);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);

                // 使用 notify() 将比 notifyAll() 获得更小的开销
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum >MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            if (num > 0) {
                initializeWorkers(num);
                this.workerNum += num;
            }
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("Beyond WorkerNum");
            }
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start run");
            while (running) {
                Job job = null;

                synchronized (jobs) {

                    // 如果工作列表是空的，没有任务需要执行，就进行 wait
                    while (jobs.isEmpty()) {

                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 能够感知到外部对 WorkerThread 的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }

                    }

                    // 取出一个 Job
                    job = jobs.removeFirst();
                }
                // 执行一个 Job
                if (job != null) {
                    job.run();
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }
}
