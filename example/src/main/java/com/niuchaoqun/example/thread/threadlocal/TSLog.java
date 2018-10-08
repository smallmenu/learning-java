package com.niuchaoqun.example.thread.threadlocal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
    private PrintWriter writer = null;

    public TSLog(String filename) {
        try {
            this.writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.print("== End Of Log ==");
        writer.close();
    }
}
