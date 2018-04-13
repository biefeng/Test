package com.biefeng.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/biefeng/demo/spring/applicationContext.xml");
        //context.getBean("");
    }
}
