package com.biefeng.demo.aop.proxy;

public class UserServiceImpl2 implements  UserService {
    @Override
    public void doSomething() {
        System.out.println("UserServiceImpl2");
    }

    @Override
    public int getNum() {
        System.out.println("The method getNum was invoked");
        return 2;
    }
}
