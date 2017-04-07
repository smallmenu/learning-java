package com.niuchaoqun.example.common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

public class LangExample {
    public static void run(String[] args) {
        arrayUtil();
        stringUtil();
        randomUtil();
    }

    public static void arrayUtil() {
        int[] array = {2, 3, 4, 5};

        System.out.println(ArrayUtils.toString(array));

        System.out.println(ArrayUtils.contains(array, 4));

        System.out.println(ArrayUtils.indexOf(array, 4));

        System.out.println(ArrayUtils.isNotEmpty(array));

        array = ArrayUtils.add(array, 6);
        System.out.println(ArrayUtils.toString(array));

        System.out.println(ArrayUtils.toString(ArrayUtils.subarray(array, 1, 3)));
    }

    public static void stringUtil() {
        String s1 = "  HelloWorld  ";

        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.strip(s1));
        System.out.println(StringUtils.isBlank(""));

        String[] s2 = {null, "a", "b"};
        System.out.println(StringUtils.join(s2, ','));

        String s3 = "a,b,c";
        System.out.println(ArrayUtils.toString(StringUtils.split(s3, ",")));


        System.out.println(StringUtils.replace(s3, "a", "b"));
        System.out.println(StringUtils.leftPad(s3, 10, "0"));

        System.out.println(StringUtils.capitalize(s3));
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
