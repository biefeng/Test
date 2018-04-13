package com.biefeng.demo.aop.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String args[]) {
        UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();
        UserService userService = (UserService) new DynamicProxy().bind(userServiceImpl2);
        userService.doSomething();
    }

    @Test
    public void test1() {
        UserService userService = new UserServiceImpl2();
        MyDynamicProxy invocationHandler = new MyDynamicProxy();

        Object obj = (Object) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, invocationHandler);


    }
}
