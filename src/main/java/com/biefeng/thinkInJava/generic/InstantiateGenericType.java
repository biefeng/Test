package com.biefeng.thinkInJava.generic;

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassFactory<Employee> fe = new ClassFactory<Employee>(Employee.class);
        System.out.println("ClassFactory<Employ> succeeded");
        try {
            ClassFactory<Integer> fi = new ClassFactory<>(Integer.class);//对于用Class的newInstance()方法创建实例时，默认调用无参构造器进行初始化，所以Class必须要有无参构造器，否则会报错。
        } catch (Exception e) {
            System.out.println("ClassFactory<Integer> failed");
        }
    }
}

class ClassFactory<T> {
    T x;

    public ClassFactory(Class<T> kind) {
        try {
            this.x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}


