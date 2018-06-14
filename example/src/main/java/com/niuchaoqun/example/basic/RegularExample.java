package com.niuchaoqun.example.basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExample {
    public static void run(String[] args) {

        string();

        regular();
    }

    public static void string() {
        // split 支持正则
        String string1 = "abcd,efg,hij";
        String[] split1 = string1.split(",");
        System.out.println(Arrays.toString(split1));

        String string2 = "abc,efg#hij";
        String[] split2 = string2.split(",|#");
        System.out.println(Arrays.toString(split2));

        // replaceAll 与 replaceFirst 支持正则
        String str = "1abcdefghidej5a";
        String regx1 = str.replaceAll("de", "##");
        String regx2 = str.replaceAll("[d|f]", "#");
        String regx3 = str.replaceAll("\\d", "#");
        String regx4 = str.replaceFirst("\\d", "#");
        System.out.println(regx1);
        System.out.println(regx2);
        System.out.println(regx3);
        System.out.println(regx4);

        // matches 验证字符串是否匹配正则
        String source1 = "2015-02-03";
        boolean match = source1.matches("\\d{4}-\\d{2}-\\d{2}");
        System.out.println(match);

        System.out.println("----- string -----");
    }

    public static void regular() {
        // String.split实现机制
        Pattern pattern1 = Pattern.compile("-|/");
        String[] split = pattern1.split("2015-02/03");
        System.out.println(Arrays.toString(split));

        String line = "This order was placed for QT3000! OK?";

        // 验证是否匹配正则表达式
        boolean matches = Pattern.matches("(\\d+)(.*)", line);
        System.out.println(matches);

        // Matcher相关操作
        Pattern pattern2 = Pattern.compile("(\\d+)(.*)");
        Matcher matcher1 = pattern2.matcher(line);
        if (matcher1.find()) {
            System.out.println(matcher1.groupCount());
            System.out.println(matcher1.group(0));
            System.out.println(matcher1.group(1));
        } else {
            System.out.println("no match");
        }


        // 多行分组匹配
        String text = "<ul>\n" +
                "<li class=\"font1\">text1</li>\n" +
                "<li class=\"font2\">text2</li>\n" +
                "<li class=\"font3\">text3</li>\n" +
                "</ul>\n";
        System.out.println(text);

        Pattern pattern3 = Pattern.compile("<li class=\"(.*?)\">(.*?)</li>");
        Matcher matcher2 = pattern3.matcher(text);
        while (matcher2.find()) {
            System.out.println(matcher2.groupCount());
            System.out.println(matcher2.group());
            System.out.println(matcher2.group(1));
            System.out.println(matcher2.group(2));
        }
    }
}
