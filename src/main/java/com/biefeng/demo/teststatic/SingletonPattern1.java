package com.biefeng.demo.teststatic;

public class SingletonPattern1 {

    //利用静态代码块进行初始化，与利用构造方法直接初始化类似。
    private static SingletonPattern1 singletonPattern1;

    private SingletonPattern1() {
    }

    static {
        singletonPattern1 = new SingletonPattern1();
    }

    public static SingletonPattern1 getInstance() {
        return singletonPattern1;
    }
}
