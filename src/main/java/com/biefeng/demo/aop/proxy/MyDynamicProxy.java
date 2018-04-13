package com.biefeng.demo.aop.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy implements InvocationHandler {
    private Object target;



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行前");
        Object obj = method.invoke(target, args);
        System.out.println("执行后");
        return obj;
    }


    public Object bind(Object obj) {
        this.target=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Test
    public void test() {
        UserService userService = new UserServiceImpl2();
        userService = (UserService) new MyDynamicProxy().bind(userService);
        System.out.println(userService.getNum());
    }
}
