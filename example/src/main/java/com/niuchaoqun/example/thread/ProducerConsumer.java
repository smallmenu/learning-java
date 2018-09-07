package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.pc.EaterThread;
import com.niuchaoqun.example.thread.pc.MakeThread;
import com.niuchaoqun.example.thread.pc.TableABQ;

/**
 * 生产者消费者模式，基于 ArrayBlockingQueue 实现通道
 *
 * 生产者是生成数据的线程，消费者是使用数据的线程
 * 生产者和消费者处理速度可能有差异，所以这个模式之间加入了一个桥梁角色（通道），用于消除处理速度的差异
 *
 */
public class ProducerConsumer {
    public static void run(String[] args) {
        TableABQ table = new TableABQ(3);
        new MakeThread("MakerThread-1", table, 3463).start();
        new MakeThread("MakerThread-2", table, 2344).start();
        new EaterThread("EaterThread-1", table, 3849).start();
        new EaterThread("EaterThread-2", table, 8473).start();
        new EaterThread("EaterThread-3", table, 3947).start();
        new EaterThread("EaterThread-4", table, 3947).start();
    }
}
