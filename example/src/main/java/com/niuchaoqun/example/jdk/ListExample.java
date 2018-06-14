package com.niuchaoqun.example.jdk;

import java.util.*;
import java.util.concurrent.*;

public class ListExample {
    public static void run(String[] args) {
        arrayList();
        arraylist_function();
        linkedList();
        stackList();
        copyOnWriteArrayList();
        arrayDeque();
    }

    /**
     * ArrayList 以数组实现，最好能预估容量 ensureCapacity() 方法
     * 数组有容量限制，默认是10，超出限制扩容50%，扩容操作是 System.arraycopy 复制到新数组
     * 按照索引 get,set 性能很高
     * 按照索引 add,remove 性能不高，因为需要复制移动数组，越靠前需要移动的数组越多
     * contains、indexOf、remove 需要遍历
     */
    public static void arrayList() {
        // 实现 List 接口提供了 add、get、indexOf、remove、set 等方法
        List<String> stringList = new ArrayList<String>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add(1, "Insert");
        stringList.set(2, "WorldSet");
        System.out.println(stringList);
        System.out.println(stringList.get(2));
        System.out.println(stringList.indexOf("Insert"));
        System.out.println(stringList.remove(1));
        System.out.println(stringList);
        System.out.println("-----");

        // 遍历
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        for (String string : stringList) {
            System.out.println(string);
        }

        stringList.add("Demo");
        System.out.println(stringList);
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equals("World")) {
                iterator.remove();
            }
        }
        System.out.println(stringList);
        System.out.println("-----");

        // toArray方法可以将集合变为数组，但是类集声明时已经通过泛型制定了集合的类型。所以
        // 接收时要使用泛型制定的类型
        Object[] objAry = stringList.toArray();
        for (int i = 0; i < objAry.length; i++) {
            System.out.println((String)objAry[i]);
        }
        String[] strAry = stringList.toArray(new String[] {});
        for (int i = 0; i < strAry.length; i++) {
            System.out.println(strAry[i]);
        }
        System.out.println("-----");

        // Vector 是 List 的前身，性能低但线程安全
        Vector<String> vector = new Vector<String>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        System.out.println(vector);

        System.out.println("----- ArrayList -----");
    }

    /**
     * 双向链表，无容量限制，占用了更多的空间
     * 按照索引 get、set，需要移动链表指针
     * 插入、删除，操作不需要复制移动数据，但是也要移动链表指针。在链表两头的操作能减少指针的移动
     * Apache Commons 有个 TreeNodeList 可以快速移动到位
     * contains、indexOf、remove 需要遍历
     *
     * 双向列表既是List，也是Queue
     */
    public static void linkedList() {
        // 实现List 与 Queue接口，所以必须直接使用 LinkedList 类
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");
        System.out.println(linkedList);

        // 头尾增加元素
        linkedList.addFirst("head");
        linkedList.addLast("last");
        System.out.println(linkedList);

        // 获取头尾元素
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        // 移除头尾元素
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        // 获取头部元素，如果空链表，返回null，getFirst() 会异常
        System.out.println(linkedList.peek());
        // 获取并移除头部元素
        System.out.println(linkedList.poll());

        System.out.println(linkedList);
        System.out.println("------ LinkedList ------");
    }

    public static void stackList() {
        // 栈
        Stack<String> stack = new Stack<String>();

        // 入栈
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println(stack);

        // 出栈
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("----- Stack -----");
    }

    public static void arraylist_function() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.ensureCapacity(100);

        stringList.add("Hello");
        stringList.add("World");
        stringList.add("中国");
        System.out.println(stringList);

        // 是否为空
        System.out.println(stringList.isEmpty());

        // 长度
        System.out.println(stringList.size());

        // 截取
        System.out.println(stringList.subList(0, 1));

        // 包含
        System.out.println(stringList.contains("World"));

        // 查找
        System.out.println(stringList.indexOf("Insert"));

        // 清空
        stringList.clear();

        System.out.println(stringList);
        System.out.println("----- ArrayList Function -----");
    }

    /**
     * ArrayList 多线程实现
     * 读读之间不互斥，读写之间也不互斥，只有写写之间要加锁互斥
     * 适合读多写少的场景
     */
    public static void copyOnWriteArrayList() {
        CopyOnWriteArrayList<String> stringList = new CopyOnWriteArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println(stringList);

        System.out.println("----- copyOnWriteArrayList -----");
    }

    /**
     * 以循环数组实现的双向Queue，大小是2的倍数，默认是16，会进行双倍扩容
     * 根据 Queue FIFO 先进先出规则，ArrayList在头部去除元素超慢
     * 队头队尾两个下标，如果队尾追上队头，则进行双倍的扩容
     */
    public static void arrayDeque() {
        ArrayDeque<String> stringList = new ArrayDeque<>();
        stringList.add("queue1");
        stringList.add("queue2");
        stringList.add("queue3");

        System.out.println(stringList);

        System.out.println("----- arrayDeque -----");

    }

    /**
     * 线程安全队列
     *
     * 有好多个
     *
     */
    public static void concurrentLinkedQueue() {
        // 实现了依赖 CAS 的无锁算法
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<String>();
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

        // 同步队列，JDK 线程池里用它
        SynchronousQueue<String> strings = new SynchronousQueue<String>();
    }
}
