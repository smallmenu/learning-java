package com.niuchaoqun.example.thread;

import com.niuchaoqun.example.thread.pc.EaterThread;
import com.niuchaoqun.example.thread.pc.MakeThread;
import com.niuchaoqun.example.thread.pc.TableABQ;

public class ProducerConsumer {
    public static void run(String[] args) {
        producerConsumerABQ();


    }

    public static void producerConsumerABQ() {
        TableABQ table = new TableABQ(3);
        new MakeThread("MakerThread-1", table, 3463).start();
        new MakeThread("MakerThread-2", table, 2344).start();
        new EaterThread("EaterThread-1", table, 3849).start();
        new EaterThread("EaterThread-2", table, 8473).start();
        new EaterThread("EaterThread-3", table, 3947).start();
        new EaterThread("EaterThread-4", table, 3947).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
