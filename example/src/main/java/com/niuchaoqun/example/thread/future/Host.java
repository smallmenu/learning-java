package com.niuchaoqun.example.thread.future;

import java.util.concurrent.Callable;

public class Host {

    public Data request(final int count, final char c) {
        System.out.println("request " + count + ", " + c + " Begin ");

        // 创建 FutureData 实例，构造函数传递 Callable<RealData>
        FutureData future = new FutureData(
                new Callable<RealData>() {
                    @Override
                    public RealData call() throws Exception {
                        return new RealData(count, c);
                    }
                }
        );

        // 启动新线程
        new Thread(future).start();

        System.out.println("request " + count + ", " + c + " End ");

        return future;
    }
}
