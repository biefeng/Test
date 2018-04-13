package com.biefeng.demo.aop.proxy;

public class EmployServiceImpl implements EmployService{

    @Override
    public void employSomeBody() {
        System.out.println("EmployService");
    }
}
