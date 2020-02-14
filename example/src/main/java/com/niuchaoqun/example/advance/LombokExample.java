package com.niuchaoqun.example.advance;

import com.niuchaoqun.example.advance.lombok.User;

public class LombokExample {
    public static void run(String[] args) {
        object();
    }

    public static void object() {
        User user1 = new User();
        user1.setId(1);
        System.out.println(user1);

        User user2 = new User(1, "张三");
        System.out.println(user2);

        // 使用 Builder，属性未赋值默认是 null，可以使用 @Default 注解解决
        User user3 = User.builder().id(1).build();
        System.out.println(user3);

        User user4 = User.builder().id(1).name("李四").build();
        System.out.println(user4);
    }
}
