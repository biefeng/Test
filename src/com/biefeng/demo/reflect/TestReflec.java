package com.biefeng.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TestReflec {
    public static void main(String args[]) {

        Map<String,Object> map  = new HashMap<>();
        try {
            Reflect r  =  new Reflect("nihao",30);
            Class clazz = Reflect.class;
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m:methods){
                Type[] types = m.getParameterTypes();
                System.out.println(types.length);
                for (Type t:types){
                   System.out.println( "type"+t.getTypeName());

                }
            }
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            for (Method method : methods) {
                System.out.println(method.getName());

            }
            System.out.println(name.get(r));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Reflect {

    private int count;
    private String name;
    public String age;

    public Reflect(String name, int count) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void print(String str1,int a){
        System.out.println(str1+a);
    }

    public String getAge() {
        return age;
    }
}
