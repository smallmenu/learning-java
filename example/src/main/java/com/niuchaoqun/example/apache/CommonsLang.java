package com.niuchaoqun.example.apache;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

public class CommonsLang {
    /**
     * Apache Commons Lang 是对 java.lang 的扩充，并且很多Util弥补了默认JDK对null的不足
     *
     * @param args
     */
    public static void run(String[] args) {
        arrayUtil();
        stringUtil();
        numberUtil();
        randomUtil();
    }

    /**
     * ArrayUtils 扩展了一些方法
     */
    public static void arrayUtil() {
        int[] array = {2, 3, 4, 5};

        System.out.println(ArrayUtils.indexOf(array, 3));

        System.out.println(ArrayUtils.toString(array));

        System.out.println(ArrayUtils.contains(array, 4));

        System.out.println(ArrayUtils.indexOf(array, 4));

        System.out.println(ArrayUtils.isNotEmpty(array));

        array = ArrayUtils.add(array, 6);
        System.out.println(ArrayUtils.toString(array));

        System.out.println(ArrayUtils.toString(ArrayUtils.subarray(array, 1, 3)));

        System.out.println("----- ArrayUtils -----");
    }

    /**
     * StringUtils 主要扩展了一些方法，并且大部分方法都对 null 进行了一些处理
     * null安全、线程安全
     *
     * 如 indexOf
     */
    public static void stringUtil() {
        String s1 = "  HelloWorld  ";

        // isEmpty 判断了 null 和空字符串
        System.out.println(StringUtils.isEmpty(""));
        // isBlank 判断了null、空字符串、以及含有空格的空字符串
        System.out.println(StringUtils.isBlank(""));


        // String.trim() 会有空指针异常，StringUtils.trim() 可以返回 null
        // strip() 具有自定义trim()列表的功能
        String nullString = null;
        System.out.println(StringUtils.trim(nullString));
        System.out.println(StringUtils.strip(s1, " Hd"));

        // 数组连接，null被当成空字符串
        String[] s2 = {null, "a", "b"};
        System.out.println(StringUtils.join(s2, ','));

        // 同样，split对null会返回null，对待分隔符null当成空格
        String s3 = "a,b,c";
        System.out.println(Arrays.toString(StringUtils.split(s3, ",")));

        // 替换
        System.out.println(StringUtils.replace(s3, "a", "b"));

        // 填充
        System.out.println(StringUtils.leftPad(s3, 10, "0"));

        // 首字母大写
        System.out.println(StringUtils.capitalize(s3));

        // 前缀、后缀检查，注意null,null为true
        String s4 = "p_abc_s";
        System.out.println(StringUtils.startsWith(s4, "p_"));
        System.out.println(StringUtils.endsWith(s4, "_s"));

        // 反转
        System.out.println(StringUtils.reverse(s4));

        // 字符串截取
        System.out.println(StringUtils.substring(s4, 0, 3));

        // 字符串查找
        System.out.println(StringUtils.indexOf(s4, "ab"));

        // 检查字符串是否
        System.out.println(StringUtils.isNumeric("12345"));
        System.out.println(StringUtils.isNumeric("a12345"));


        System.out.println("----- StringUtil -----");
    }

    public static void numberUtil() {
        System.out.println(NumberUtils.isNumber("12345"));
        System.out.println(NumberUtils.isNumber("a12345"));

        // 非数字与null会转换成0，解决 parseInt 异常
        System.out.println(NumberUtils.toInt("12345"));
        System.out.println(NumberUtils.toInt("a12345"));
        System.out.println(NumberUtils.toInt("-12345"));
        System.out.println(NumberUtils.toInt(null));

        System.out.println(Integer.parseInt("123"));
        // 异常
        //System.out.println(Integer.parseInt("a123"));
        //System.out.println(Integer.parseInt(null));

        System.out.println("----- NumberUtils -----");
    }

    public static void randomUtil()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.nextInt(0, 2));
        }
        System.out.println(RandomStringUtils.random(32, true, true));
        System.out.println(RandomStringUtils.random(32, "abcdefghigk"));
    }
}
