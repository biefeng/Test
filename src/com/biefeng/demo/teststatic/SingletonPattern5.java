package com.biefeng.demo.teststatic;

public class SingletonPattern5 {
    /*利用double-check对上个方法的改进，可以达到线程安全期望，且比方法3的同步代码块效率要高，也达到了延迟加载*/
    private static SingletonPattern5 singletonPattern5;

    private SingletonPattern5() {

    }

    public static SingletonPattern5 getSingletonPattern5() {

        if (singletonPattern5 == null) {
            synchronized (SingletonPattern5.class) {
                if (singletonPattern5 == null) {
                    singletonPattern5 = new SingletonPattern5();
                }
            }
        }

        return singletonPattern5;
    }
}
