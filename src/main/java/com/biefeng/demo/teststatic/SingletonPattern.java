package com.biefeng.demo.teststatic;

public class SingletonPattern {
//饿汉式（静态常量）[可用]
    /**
     * 优点：在类加载的时候就完成实例化。避免了线程同步的问题。
     * 缺点：在类在家的时候完成实例化，没有达到lazyload的效果，可能存在浪费内存的情况（未使用）
     */
    private static SingletonPattern singletonPattern  = new SingletonPattern();

    private SingletonPattern(){}

    public static SingletonPattern getInstance(){
        return singletonPattern;
    }

}
