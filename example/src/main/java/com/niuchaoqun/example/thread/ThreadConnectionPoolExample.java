package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.cp.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一个简单的具有获取连接等待超时的数据库连接池
 *
 *
 * CountDownLatch 可以实现类似计数器的功能
 * 构造函数 new CountDownLatch(1)
 *
 */
public class ThreadConnectionPoolExample {
    // 初始化具有10个连接的连接池
    static ConnectionPool pool = new ConnectionPool(10);

    // 保证所有 ConnectionRunner 线程能够同时开始
    static CountDownLatch start = new CountDownLatch(1);

    // main线程将会等待所有 ConnectionRunner 结束后才能继续执行
    static CountDownLatch end;

    public static void run(String[] args) {
        // 模拟并发从连接池获取连接的线程总数
        int threadCount = 50;
        // 每个线程从连接池中获取连接总次数
        int count = 20;

        end = new CountDownLatch(threadCount);

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection:" + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;

        AtomicInteger got;

        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;

            this.got = got;

            this.notGot = notGot;
        }

        @Override
        public void run() {

            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 模拟 count 次从连接池中获取连接
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {

                } finally {
                    count--;
                }

            }
            end.countDown();
        }
    }
}
