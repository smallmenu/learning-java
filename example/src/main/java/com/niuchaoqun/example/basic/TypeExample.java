package com.niuchaoqun.example.basic;

/**
 * Java 基本类型
 *
 * @author niuchaoqun
 */
public class TypeExample {
    public static void run(String[] args) {
        // long 8字节
        long l = 0L;

        // int 4字节
        int i = 0;

        // short 2字节
        short s = 0;

        // byte 1字节
        byte b;

        // float 4字节
        float f;

        // double 8字节
        double d;

        // 包装类
        long maxLong = Long.MAX_VALUE;
        int maxInt = Integer.MAX_VALUE;
        byte maxByte = Byte.MAX_VALUE;

        // 类型存储位数
        int intSize = Integer.SIZE;
        int longSize = Long.SIZE;
        int floatSize = Float.SIZE;
        int doubleSize = Double.SIZE;

        System.out.println(maxLong);
        System.out.println(maxInt);
        System.out.println(maxByte);
        System.out.println("----- line -----");

        System.out.println(intSize);
        System.out.println(longSize);
        System.out.println(floatSize);
        System.out.println(doubleSize);
        System.out.println("----- line -----");

        // 字符类型，2字节，属于整型的一种
        char ch1 = 'a';
        char ch2 = 97;
        char ch3 = '\'';

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println("----- line -----");

        // bool
        boolean boolFlag1 = true;
        Boolean boolFlag2 = true;
        System.out.println(boolFlag1);
        System.out.println(boolFlag2);
        System.out.println("----- line -----");

        // 自动转换
        short sVal = 127;
        int iVal = sVal;
        System.out.println(iVal);
        // 强制转换，常量计算使用强制类型转换，输出：3.3333333
        System.out.println((float) 10 / 3);
        System.out.println("----- line -----");

        // Java 中任何类型的数据都向 String 转型，输出：test30
        String testString = "test";
        int ix = 30;
        System.out.println(ix + testString);
        System.out.println("----- line -----");

        // char 数组到 String 互转
        char charArray[] = {'a', 'b', 'c'};
        String string = new String(charArray);
        final char[] toCharArray = string.toCharArray();
        System.out.println(string);
        System.out.println(toCharArray);
        System.out.println("----- line -----");

        // 字符串转整型，返回对象不同，一个是基础类型一个是包装类
        int intValue1 = Integer.parseInt("0123");
        Integer intValue2 = Integer.valueOf("0123");
        System.out.println(intValue1);
        System.out.println(intValue2);

        // bytes 数组与 String 互转
        String byteString1 = "bytes";
        byte[] byteArray = byteString1.getBytes();
        System.out.println(byteArray.toString());

        String byteString2 = new String(byteArray);
        System.out.println(byteString2);
    }
}
