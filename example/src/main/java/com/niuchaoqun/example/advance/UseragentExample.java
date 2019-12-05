package com.niuchaoqun.example.advance;

import com.niuchaoqun.utils.Useragent;

public class UseragentExample {

    public static void run(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Useragent.chrome());
        }
    }
}
