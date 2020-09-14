package com.niuchaoqun.example.thread;

/**
 * ThreadLocal 即线程变量
 *
 * 以ThreaLocal为键，任意对象为值得存储结构，被附带在线程上
 * 一个线程可以根据一个 ThreadLocal 对象查询到
 */
public class ExampleThreadLocal {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(() -> System.currentTimeMillis());

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void run(String[] args) {
        ExampleThreadLocal.begin();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cost:" + ExampleThreadLocal.end());
    }
}
