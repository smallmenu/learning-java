package com.niuchaoqun.example.jdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExample {
    public static void run(String[] args) {
        hashset();

        hashset_function();
    }

    public static void hashset() {
        // 集合
        // 是不允许加入重复的元素，如果集合的泛型是Object，那么需要覆写equals()和hashCode()方法
        // 不保证迭代顺序
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("D");
        hashSet.add("B");
        hashSet.add("A");
        hashSet.add("B");
        System.out.println(hashSet);

        // 遍历，迭代输出
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String s : hashSet) {
            System.out.println(s);
        }

        // 使用了双向链表，保证了了插入和迭代的顺序，类似：LinkedHashMap。但是代价更高
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        System.out.println(linkedHashSet);

        // 有序集合，如果容器内是泛型的Object，那么需要自己实现 Comparable 接口
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        System.out.println(treeSet);

        System.out.println("----- hashset -----");
    }

    public static void hashset_function() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("D");
        hashSet.add("B");
        hashSet.add("A");

        System.out.println(hashSet.size());

        System.out.println(hashSet.isEmpty());

        System.out.println(hashSet.contains("D"));

        System.out.println(hashSet.remove("D"));

        System.out.println(hashSet);

        hashSet.clear();

        System.out.println(hashSet);

        System.out.println("----- hashset function -----");
    }
}
