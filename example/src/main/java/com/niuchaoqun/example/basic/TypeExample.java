package com.niuchaoqun.example.basic;


public class TypeExample {
    public static void run(String[] args) {
        // long 8字节
        long ilong;

        // int 4字节
        int iint;

        // short 2字节
        short ishort;

        // byte 1字节
        byte b;

        // float 4字节
        float f;

        // double 8字节
        double d;

        // 包装类
        long maxl = Long.MAX_VALUE;
        int maxi = Integer.MAX_VALUE;
        byte maxb = Byte.MAX_VALUE;
        int isize = Integer.SIZE;

        System.out.println(maxl);
        System.out.println(maxi);
        System.out.println(maxb);

        // 存储位数
        System.out.println(isize);

        // 字符类型，2字节，属于整型的一种
        char ch1 = 'a';
        char ch2 = 97;
        char ch3 = '\'';

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

        // bool
        boolean flag = true;
        System.out.println(flag);

        // 自动转换
        short ta = 127;
        int tb = ta;
        System.out.println(tb);
        // 强制转换，常量计算使用强制类型转换，输出：3.3333333
        System.out.println((float)10/3);

        // 任何类型的数据都向String转型，输出：test30
        String test = "test";
        int x = 30;
        System.out.println(x + test);

        // char 数组到 String 互转
        char data[] = {'a', 'b', 'c'};
        String s = new String(data);
        final char[] css = s.toCharArray();
        System.out.println(s);

        // 字符串转整型，返回对象不同，一个是基础类型一个是包装类
        int i = Integer.parseInt("0123");
        final Integer integer = Integer.valueOf("0123");
        System.out.println(i);

        // bytes 数组与 String 互转
        String byteString1 = "bytes";
        byte[] bytes = byteString1.getBytes();

        String byteString2 = new String(bytes);
        System.out.println(byteString2);
    }
}
