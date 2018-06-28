package com.niuchaoqun.example.thread.cp;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 一个简单的数据库连接池示例
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                // 通过动态代理模拟构造了一个 Connection 用于演示
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后进行通知，让其他消费者能够感知到连接池中已经多了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) {
        synchronized (pool) {
            // 完全超时，直接判断是否有连接，有则直接返回
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return pool.removeFirst();

            // 通过 wait 实现连接超时，在超时时间范围内如果没有可用的连接，则返回null
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    try {
                        pool.wait(remaining);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
