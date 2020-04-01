package com.niuchaoqun.example.basic;

/**
 * Java 字符串
 *
 * @author niuchaoqun
 */
public class StringExample {

    public static void run(String[] args) {
        string();
        empty();
        function();
        StringBufferExample();
        StringBuilderExample();
    }

    public static void string() {
        // String 匿名对象，创建了字符串name在字符串池中，string1与string2都是对该字符串的引用
        String string1 = "name";
        String string2 = "name";

        // String 对象，默认为引用赋值，string3与string4相同
        String string3 = new String("name");
        String string4 = string3;

        // 比较字符串对象
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
        System.out.println(string3 == string4);

        // 比较字符串值
        System.out.println(string1.equals(string3));
        System.out.println(string1.equalsIgnoreCase(string3));

        // 判断是否等于字符串更严谨的写法，可避免空指针异常
        System.out.println("name".equals(string3));
        System.out.println("----------");
    }

    public static void empty() {
        String string1 = "abc";

        // 判断空。不推荐。检查字符串长度，可能有空指针异常，一般使用 "".equals()
        boolean empty = string1.isEmpty();
        System.out.println(empty);

        // 判断空。"".equals() 能避免空指针异常错误，但是使用时依然要判断是否为null
        String nullString = null;
        if (!"".equals(nullString)) {
            // 条件通过，但使用时报空指针异常
            //if (nullString.endsWith("c")) {
            //	System.out.println(nullString);
            //}
        }

        // 更严谨的判断
        // 这样判断实在是有点狗屎，一般借助 StringUtils.isEmpty() 或 StringUtils.equals(a, "") 来简化
        if (nullString != null && !"".equals(nullString)) {
            if (nullString.endsWith("c")) {
                System.out.println(nullString);
            }
        }

        System.out.println("----------");
    }

    public static void function() {
        // 内置的字符串的函数，不能避免 Null，实际一般使用Commons StringUtils 来替代
        String string1 = "hello";
        String string2 = "world";
        String string3 = "hello，中国.";

        // trim
        System.out.println(" adsf ".trim());

        // string1 > string2 是负值
        int compare = string1.compareTo(string2);
        System.out.println(compare);

        // 字符串连接
        String concat = string1.concat(string2);
        System.out.println(concat);

        // 前缀后缀匹配
        System.out.println(string1.startsWith("h"));
        System.out.println(string2.endsWith("ld"));

        // 返回子串
        String substring = string1.substring(1, 3);
        System.out.println(substring);

        // 静态方法，返回字符串表示
        String valueof = String.valueOf(123456.12);
        System.out.println(valueof);

        // 字符串查找
        int indexOf = string1.indexOf("ll");
        System.out.println(indexOf);

        // 包含
        boolean contain = string1.contains("ll");
        System.out.println(contain);

        // 字符串长度，中、英文、标点的长度都是 1
        int length1 = string1.length();
        int length2 = string3.length();
        System.out.println(length1);
        System.out.println(length2);

        // 替换
        String replace = string1.replace("h", "o");
        System.out.println(replace);

        // 转换大写
        System.out.println(string1.toUpperCase());

        System.out.println("----------");
    }

    public static void StringBufferExample() {
        // StringBuffer 是线程安全的
        StringBuffer buffer = new StringBuffer();

        // 字符串连接
        buffer.append("Hello");
        buffer.append("World");
        System.out.println(buffer);

        // 任意位置插入
        buffer.insert(1, "-INSERT-");
        System.out.println(buffer);

        // 特有方法，反转字符串
        String reverse = buffer.reverse().toString();
        System.out.println(reverse);

        System.out.println("----------");
    }

    public static void StringBuilderExample() {
        // StringBuilder 非线程安全，功能与 StringBuffer 类似，性能更好
        // 一般情况下 Java 编译会自动优化字符串连接，StringBuffer 和 StringBuilder 主要是为了避免大量的字符串连接（循环中），
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        System.out.println(builder);

        System.out.println("----------");
    }
}
