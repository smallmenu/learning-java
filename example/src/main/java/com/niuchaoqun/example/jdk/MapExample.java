package com.niuchaoqun.example.jdk;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {
    public static void run(String[] args) {
        hashmap();
        hashmap_function();
        treemap();
        linkedHashMap();
    }

    /**
     * Hash表的实现，最好能预估容量
     * 默认Hash桶是16，当数量达到桶数量75%时，hash冲突比较严重，会成倍扩容，并重新分配所有原来的数据
     * 当产生hash冲突时，JDK是使用链表法，JDK8新增一个默认8的阈值，超过阈值转换成红黑树
     * HashMap数据是乱序的
     */
    public static void hashmap() {
        // HashMap为新的操作类，HashTable 是旧的操作类，HashTable性能低但线程安全
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value3");

        System.out.println(hashMap);

        // 遍历所有的key
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        // 遍历所有的value
        Collection<String> values = hashMap.values();
        for (String value : values) {
            System.out.println(value);
        }
        // 遍历所有的key和value
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        System.out.println("----- hashmap -----");
    }

    public static void hashmap_function () {
        // 初始容量
        HashMap<String, String> hashMap = new HashMap<String, String>(100);
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value3");

        if (hashMap.containsKey("key2")) {
            System.out.println(hashMap.get("key2"));
        }

        System.out.println(hashMap.isEmpty());

        System.out.println(hashMap.size());

        hashMap.remove("key3");

        System.out.println(hashMap);

        System.out.println("----- hashmap function -----");
    }

    /**
     * 红黑树实现，又叫平衡二叉树
     * 插入、删除元素的代价大
     */
    public static void treemap() {
        // 有序Map，基于红黑树实现自动排序的Map，并且提供一些比较方法
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("k1", "value1");
        treeMap.put("k2", "value2");
        treeMap.put("k3", "value3");
        treeMap.put("a3", "value4");
        treeMap.put("a2", "value5");
        treeMap.put("a1", "value6");
        System.out.println(treeMap);

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 键值 <a2的集合
        SortedMap<String, String> aMap = treeMap.headMap("a2");
        System.out.println(aMap);

        // 键值 >= a2 的集合
        SortedMap<String, String> bMap = treeMap.tailMap("a2");
        System.out.println(bMap);

        // 键值 a2 <= map < k2 的集合
        SortedMap<String, String> cMap = treeMap.subMap("a2", "k2");
        System.out.println(cMap);

        System.out.println("----- treemap -----");
    }

    public static void linkedHashMap() {
        // LinkedHashMap 维护了一个双链表，定义了迭代顺序，即插入顺序
        HashMap<String, String> hashmap = new HashMap<String, String>();


        hashmap.put("key2", "value2");
        hashmap.put("key1", "value1");
        hashmap.put("key3", "value3");
        hashmap.put("key4", "value4");
        for (Map.Entry<String, String> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println(hashmap);

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(hashmap);
        System.out.println(linkedHashMap);

        System.out.println("----- linkedHashMap -----");
    }

    /**
     * 线程安全的 HashMap
     * JDK8 之前，默认16把写锁，有效分散阻塞的概率，即锁分段技术，
     * JDK8 之后，改为精心设计的，只在需要加锁的时候加锁
     */
    public static void concurrentHashmap() {
        ConcurrentHashMap<String, String> hashmap = new ConcurrentHashMap<>();
        hashmap.put("concurrent1", "value1");
        hashmap.put("concurrent2", "value2");
        hashmap.put("concurrent3", "value3");
        hashmap.put("concurrent4", "value4");
    }
}
