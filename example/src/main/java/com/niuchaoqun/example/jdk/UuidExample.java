package com.niuchaoqun.example.jdk;

import java.util.UUID;

public class UuidExample {
    public static void run(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
