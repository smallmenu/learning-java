package com.niuchaoqun.example.thread.threadpool;

public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job需要实现 Runnable
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 增加工作者线程
    void addWorkers(int num);

    // 减少工作者线程
    void removeWorkers(int num);

    // 获取正在等待执行的任务数量
    int getJobSize();
}
