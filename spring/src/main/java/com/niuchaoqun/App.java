package com.niuchaoqun;

import com.niuchaoqun.config.HelloWorld;
import com.niuchaoqun.other.Other;
import com.niuchaoqun.output.OutputHelper;
import com.niuchaoqun.xml.MyComponent;
import com.niuchaoqun.xml.Customer;
import com.niuchaoqun.xml.CustomerService;
import com.niuchaoqun.xml.FileNameGenerator;
import com.niuchaoqun.xml.SingleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        springXml();
        springJavaConfig();
    }

    public static void springJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld);
        System.out.println(helloWorld.getPerson());

        Other other = (Other)context.getBean("myOther");
        System.out.println(other);
        System.out.println(other.getPerson());
    }

    public static void springXml() {
        // OutputHelper output = new OutputHelper();
        // output.generateOutput();

        // 实现了依赖注入，通过xml配置文件改变具体要调用哪个实现，并且不需要重新编译
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
        output.generateOutput();

        // 构造函数注入，应当限定类型
        Customer customer = (Customer) context.getBean("Customer");
        System.out.println(customer);

        // 属性类型注入
        CustomerService customerService = (CustomerService) context.getBean("CustomerService");
        customerService.printName();
        customerService.printURL();

        // 属性类型注入
        FileNameGenerator fileNameGenerator = (FileNameGenerator) context.getBean("FileNameGenerator");
        System.out.println(fileNameGenerator);

        // 默认注入为Singleton单例模式，可通过scope传入不同的模式
        SingleService singleService1 = (SingleService) context.getBean("SingleService");
        singleService1.setMessage("hello");
        System.out.println(singleService1.getMessage());
        SingleService singleService2 = (SingleService) context.getBean("SingleService");
        System.out.println(singleService2.getMessage());

        // XML 自动扫描，默认返回的是类名首字母小写
        MyComponent myComponent = (MyComponent) context.getBean("myComponent");
        System.out.println(myComponent);
        System.out.println(myComponent.getMyEngine());
    }
}
