package com.biefeng.thinkInJava.generic;

//如果此处不指定T extends 则无法用obj调用f（）方法
public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulator() {
        obj.f();
    }

    public static void main(String[] args) {
        Manipulator<HasF> manipulator=new Manipulator<>(new HasF());
        manipulator.manipulator();
    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}
