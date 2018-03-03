package com.biefeng.demo.proxy;

public class TestDynamicProxy {
    public static void main(String args[]) {
        UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();
        UserService userService = (UserService) new DynamicProxy().bind(userServiceImpl2);
        userService.doSomething();
    }

}
