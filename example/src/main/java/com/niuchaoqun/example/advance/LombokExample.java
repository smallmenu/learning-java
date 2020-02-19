package com.niuchaoqun.example.advance;

import com.niuchaoqun.example.advance.lombok.User;
import com.niuchaoqun.example.advance.lombok.UserChild;
import com.niuchaoqun.example.advance.lombok.UserChildBuilder;

public class LombokExample {
    public static void run(String[] args) {
        object();
        child();
        childBuilder();
    }

    private static void childBuilder() {
        UserChildBuilder userChildBuilder = UserChildBuilder.builder().id(1).name("名字").age(10).build();
        System.out.println(userChildBuilder);
    }

    private static void child() {
        User user11 = new User();
        user11.setId(1);
        user11.setName("孩子");
        System.out.println(user11);

        UserChild userChild11 = new UserChild();
        userChild11.setId(1);
        userChild11.setName("孩子1");
        userChild11.setAge(12);
        System.out.println(userChild11);

        UserChild userChild12 = new UserChild();
        userChild12.setId(2);
        userChild12.setName("孩子2");
        userChild12.setAge(12);
        System.out.println(userChild12);
        System.out.println(userChild11.equals(userChild12));

        System.out.println("------------");
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

        System.out.println("------------");
    }
}
