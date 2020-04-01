package com.niuchaoqun.example.basic;

/**
 * Java Math 类
 *
 * @author niuchaoqun
 */
public class MathExample {
    public static void run(String[] args) {
        int a = 5;
        int b = 8;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        System.out.println(max);
        System.out.println(min);

        // 进位取整
        double d1 = 4.4;
        double d2 = 4.5;
        double ceil1 = Math.ceil(d1);
        double ceil2 = Math.ceil(d2);

        // 舍位取整
        double floor1 = Math.floor(d1);
        double floor2 = Math.floor(d2);

        // 四舍五入
        long round1 = Math.round(d1);
        long round2 = Math.round(d2);

        System.out.println(ceil1);
        System.out.println(ceil2);
        System.out.println(floor1);
        System.out.println(floor2);
        System.out.println(round1);
        System.out.println(round2);

        double pow = Math.pow(2, 5);
        System.out.println(pow);
    }
}
