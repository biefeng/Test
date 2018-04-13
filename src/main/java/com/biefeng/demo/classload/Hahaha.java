package com.biefeng.demo.classload;

import org.junit.Test;

public class Hahaha {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

    @Test
    public void test(){
        String a[] = {"","",""};
    }

}
class SSClass{
    static {
        System.out.println("SSClass init");
    }
}
class SuperClass extends SSClass{
    static int value=123;
    static {
        System.out.println("SuperClass Init");
    }

    public SuperClass() {
        System.out.println("Init SupperClass by constructor");
    }
}

class SubClass extends SuperClass{
    static int a;
    static {
        System.out.println("SubClass Init");
    }

    public SubClass(){
        System.out.println("Init SubClass by cons");
    }
}
