package com.biefeng.thinkInJava.generic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//在InstraintFactory的基础上进行优化
public class Demo21 {


    public static void main(String[] args) {
        try {
            System.out.println(Integer.class.getConstructor(Integer.TYPE));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object obj=1;
        for(Constructor c:Integer.class.getConstructors()){
            System.out.println(c.getParameterTypes());
            for (Class clazz:c.getParameterTypes()){
                System.out.println(clazz.getTypeName());
            }
        }
        System.out.println(Integer.TYPE);

        ClassFactory1<Employee> factory = new ClassFactory1(Employee.class);
        Employee employee = factory.createNew();
        if (null != employee)
            System.out.println("Employ create succeeded");
        ClassFactory1<Integer> factory1 = new ClassFactory1(Integer.class);
       //  Integer integer=factory1.createNew(1);

    }

}

class ClassFactory1<T> {
    Class<T> kind;
    T x;
    List list=new ArrayList();

    public ClassFactory1(Class<T> kind, T x,int a) {
        this.kind = kind;
        this.x = x;
        this.list = list;
        System.out.println(a);
    }

    public ClassFactory1(Class<T> kind) {
        this.kind = kind;
    }

    public T createNew() {
        try {
            return kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T createNew(Object... args) {

        Class[] classes = null;

        classes = new Class[args.length];
        int i = 0;
        for (Object obj : args) {

            classes[i++] = obj.getClass();
        }
        try {
            return kind.getConstructor(classes).newInstance(args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}

class Employee1 {
}



