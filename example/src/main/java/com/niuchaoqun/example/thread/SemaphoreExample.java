package com.niuchaoqun.example.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *  计数信号量 Semaphore
 *
 *  Single Threaded Execution 的模式扩展
 *  假设能够使用的资源个数有 N 个，而需要这些资源的线程个数又多于 N 个
 *
 *  Semaphore 的 acquire 方法用于确保存在可用资源，当存在可用资源时，线程会立即从 acquire 返回，同时信号量内部资源个数减1
 *  如无可用资源，线程则阻塞在 acquire 方法内，直到出现可用资源
 *
 *  Semaphore 的 release 方法用于释放资源，释放资源后，信号量内部资源个数加1
 *  另外，如果 acquire 中存在等待的线程，那么其中一个资源会唤醒，并从 acquire 方法返回
 */
public class SemaphoreExample {
    public static void run(String[] args) {
        // 设置 3 个资源
        BoundedResource resource = new BoundedResource(3);

        // 10 个线程使用资源
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class BoundedResource {
        private final Semaphore semaphore;
        private final int permits;
        private final Random random = new Random(314159);

        public BoundedResource(int permits) {
            this.semaphore = new Semaphore(permits);
            this.permits = permits;
        }

        public void use() throws InterruptedException {
            // 用于确认是否确实存在可用资源，当所有资源已被使用时，线程会阻塞在改方法中
            // 如果返回，则一定存在可用资源
            semaphore.acquire();
            try {
                doUse();
            } finally {
                // 最后一定要释放资源（Before/After模式）
                semaphore.release();
            }

        }

        // 模拟执行操作
        protected void doUse() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " BEGIN used = " + (permits - semaphore.availablePermits()));
            Thread.sleep(random.nextInt(500));
            System.out.println(Thread.currentThread().getName() + " END used = " + (permits - semaphore.availablePermits()));
        }
    }

    public static class UserThread extends Thread {
        private final Random random = new Random(26535);
        private final BoundedResource resource;

        public UserThread(BoundedResource resource) {
            this.resource = resource;
        }

        public void run() {
            try {
                while (true) {
                    resource.use();
                    Thread.sleep(random.nextInt(3000));
                }
            } catch (InterruptedException e) {

            }
        }
    }
}
