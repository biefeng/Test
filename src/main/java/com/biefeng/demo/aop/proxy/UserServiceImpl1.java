package com.biefeng.demo.aop.proxy;

public class UserServiceImpl1 implements UserService {

    @Override
    public void doSomething() {
        System.out.println("UserServiceImpl1");
    }

    @Override
    public int getNum() {
        return 1;
    }
}
