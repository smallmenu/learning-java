package com.niuchaoqun.example.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Java 对象引用值传递
 *
 * @author niuchaoqun
 */
public class ReferenceExample {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Student {
        private String name;
    }


    public static void run(String[] args) {
        swapInt();

        changeArray();

        swapObject();
    }

    private static void swapObject() {
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");

        /**
         * 方法拿到的是对象引用的拷贝，在方法中交换，只是交换了拷贝的引用，不会对原对象有影响
         */
        swapObjectFunc(s1, s2);

        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swapObjectFunc(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;

        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }


    public static void changeArray() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[0]);

        /**
         * 数组虽然改变了，是因为方法拿到了源数组引用的拷贝，传递的是引用的值
         */
        changeArrayFunc(arr);

        System.out.println(arr[0]);
        System.out.println("----- line -----");
    }

    public static void swapInt() {
        int num1 = 10;
        int num2 = 20;

        /**
         * Java 总按值调用。方法得到的是所有参数值的一个拷贝，方法不能修改传递给它的任何参数变量的内容
         *
         * num1 与 num2 的值不会改变
         */
        swapIntFunc(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("----- line -----");
    }

    public static void changeArrayFunc(int[] array){
        array[0] = 0;
    }

    public static void swapIntFunc(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
