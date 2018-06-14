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


        // 加强型的随机数，还可以通过特定的算法初始化
        SecureRandom random3 = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(random3.nextInt(1000));
        }
        System.out.println("----- SecureRandom1 -----");

        SecureRandom random4 = null;
        try {
            random4 = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i < 10; i++) {
                System.out.println(random4.nextInt(1000));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("----- SecureRandom2 -----");

    }

    public static void example() {

        // 格式化
//		NumberFormat numberFormat1 = NumberFormat.getInstance();
//		System.out.println(numberFormat1.format(1234567890));
//		System.out.println(numberFormat1.format(12345.67890));
//		System.out.println("=====");
//
//		// 自定义格式化
//		System.out.println(new DecimalFormat("###,###,###.##").format(123456789));
//		System.out.println(new DecimalFormat("###,###,###.#").format(1234567.89));
//		System.out.println(new DecimalFormat("$###,###,###.#").format(123456789));
//		System.out.println(new DecimalFormat("###,###,###.##%").format(0.0345));
    }
}
