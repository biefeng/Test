package com.biefeng.demo.teststatic;

public class TestSingleton {
    public static void main(String args[]) {
        SingletonPattern6 singletonPattern61= SingletonPattern6.getInstance();
        System.out.println(singletonPattern61);
        SingletonPattern6 singletonPattern62= SingletonPattern6.getInstance();
        System.out.println(singletonPattern61);

    }
}
