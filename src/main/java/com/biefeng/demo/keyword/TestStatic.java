package com.biefeng.demo.keyword;

public class TestStatic {

    public static void main(String[] args) {
        staticFunction();
    }

    static TestStatic st = new TestStatic();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    TestStatic() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
