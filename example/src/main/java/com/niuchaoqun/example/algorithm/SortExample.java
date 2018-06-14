package com.niuchaoqun.example.algorithm;

import java.util.Arrays;

public class SortExample {
    public static int[] source = {32, 17, 19, 11, 55, 43, 98, 73, 47};

    public static void run(String[] args) {
        //bubble();
        //select();
        insert();
    }

    /**
     * 冒泡排序，稳定
     * 时间 O(n^2)，空间 O(1)
     *
     * 通过交换相邻值，每次排出最小的
     * 通过设置flag，该轮无交换，提前结束循环
     *
     */
    public static void bubble() {
        int[] list = new int[source.length];
        System.arraycopy(source, 0, list, 0, source.length);

        int temp;
        for (int i = 0; i < list.length; i++) {
            boolean flag = false;
            for (int j = list.length - 1; j >= i + 1; j--) {
                if (list[j] < list[j-1]) {
                    temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    flag = true;
                }
                System.out.println(Arrays.toString(list));
            }
            System.out.println(i + "-----");
            if (!flag) {
                break;
            }
        }

        System.out.println("----- bubble -----");
    }

    /**
     * 选择排序，不稳定
     * 时间 O(n^2)，空间 O(1)
     *
     * 每次先找出最小值，与队首交换，稍微优势的地方是每次只要交换一次
     */
    public static void select() {
        int[] list = new int[source.length];
        System.arraycopy(source, 0, list, 0, source.length);

        int temp;
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                // 找到最小值
                if (list[j] < list[min]) {
                    min = j;
                }
            }

            // 交换
            temp = list[min];
            list[min] = list[i];
            list[i] = temp;

            System.out.println(Arrays.toString(list));
        }

        System.out.println("----- select -----");
    }

    /**
     * 插入排序
     * 时间 O(n^2)，空间 O(1)
     *
     * 相当于两个指针一起移动，每次把后面小的数据，再前面已经排好序的数据中找到位置插入进去
     */
    public static void insert() {
        int[] list = new int[source.length];
        System.arraycopy(source, 0, list, 0, source.length);

        int temp;
        for (int i = 1; i < list.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[j+1] < list[j]) {
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
                System.out.println(Arrays.toString(list));
            }
            System.out.println(i + "-----");
        }

        System.out.println(Arrays.toString(list));

        System.out.println("----- insert -----");
    }
}
