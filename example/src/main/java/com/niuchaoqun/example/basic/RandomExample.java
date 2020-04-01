package com.niuchaoqun.example.basic;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomExample {

    public static void run(String[] args) {
        // 使用java.util.Random实现，是线程安全的
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

        System.out.println("----- Math.random -----");

        // 种子数相同，输出相同伪随机数。可预测
        long seed = System.currentTimeMillis();
        Random random1 = new Random(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(random1.nextInt(1000));
        }
        System.out.println("----- Random1 -----");

        Random random2 = new Random(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(random2.nextInt(1000));
        }
        System.out.println("----- Random2 -----");

        // 使用seed初始化
        Random random3 = new Random(seed);
        for (int i = 0; i < 10; i++) {
            System.out.println(random3.nextInt(1000));
        }
        System.out.println("----- Random3 -----");


        // 加强型的随机数，还可以通过特定的算法初始化
        SecureRandom random4 = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(random4.nextInt(1000));
        }
        System.out.println("----- SecureRandom1 -----");

        SecureRandom random5 = null;
        try {
            random5 = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i < 10; i++) {
                System.out.println(random5.nextInt(1000));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("----- SecureRandom2 -----");
    }
}
