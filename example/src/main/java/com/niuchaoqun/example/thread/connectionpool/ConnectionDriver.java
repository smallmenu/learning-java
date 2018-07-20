package com.niuchaoqun.example.thread.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                Thread.sleep(500);
            }
            return null;
        }
    }

    // 创建一个 Connection 的代理，在执行 commit 时休眠 100 ms，用来模拟每个 commit 动作的耗时
    public static final Connection createConnection() {
        return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[]{ Connection.class},
                new ConnectionHandler()
        );
    }
}
