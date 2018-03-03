package com.biefeng.demo.teststatic;

public class SingletonPattern4 {

    /*虽然锁了对象，但是无法起到多线程场景下的线程安全问题，当两个线程同时进入if并通过判断时，就会产生多个对
    象（一个线程完成创建，另一个处于阻塞，当第一个线程完成创建时，第二个线程便会重新创建对象）。*/
    private static SingletonPattern4 singletonPattern4;

    private SingletonPattern4() {
    }

    public static SingletonPattern4 getSingletonPattern4() {
        if (singletonPattern4 == null) {
            synchronized (SingletonPattern4.class) {
                singletonPattern4 = new SingletonPattern4();
            }
        }
        return singletonPattern4;
    }
}
