package com.niuchaoqun.example.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionExample {

    public static void run(String[] args) {
        collections();
    }

    public static void collections() {
        // 给集合批量添加数据
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "Hello", "World", "Java");
        System.out.println(arrayList);

        // 另一种方法
        List<String> lists =  Arrays.asList("test1", "test2", "test3");
        ArrayList<String> strings = new ArrayList<>(lists);
        System.out.println(strings);

        // 交换
        Collections.swap(strings, 0, 1);
        System.out.println(strings);

        // 反转集合
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        // 排序
        Collections.sort(arrayList);
        System.out.println(arrayList);

        // 二分查找，返回索引值
        int index = Collections.binarySearch(arrayList, "World");
        System.out.println(index);

        // 替换
        Collections.replaceAll(arrayList, "Java", "PHP");
        System.out.println(arrayList);

        // 来自一个面试题，展示一下shuffle方法，随机排列
        ArrayList<Integer> numbers = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        Collections.shuffle(numbers);
        List<Integer> result = numbers.subList(0, 90);
        System.out.println(result);
    }
}
