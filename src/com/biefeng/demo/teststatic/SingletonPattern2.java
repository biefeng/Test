package com.biefeng.demo.teststatic;

public class SingletonPattern2 {
    //在调用getInstance时进行初始化，能够起到懒加载的作用，但是是线程不安全的，多个线程调用，就可能会产生多个对象。
    private static SingletonPattern2 singletonPattern2;

    private SingletonPattern2() {

    }

    public static SingletonPattern2 getInstance() {
        if (singletonPattern2 == null) {
            singletonPattern2 = new SingletonPattern2();
        }
        return singletonPattern2;
    }
}
