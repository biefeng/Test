package com.biefeng.demo.teststatic;

public class SingletonPattern3 {
   //通过加锁，实现了多线程下的线程安全，但是效率很低。获取实例方法只进行一次初始化，后面就可以直接返回，所以效率很低。
    private static SingletonPattern3 singletonPattern3;
    private SingletonPattern3() {
    }

    public static synchronized SingletonPattern3 getSingletonPattern3() {

        if (singletonPattern3 == null) {
            singletonPattern3 = new SingletonPattern3();
        }
        return singletonPattern3;
    }
}
