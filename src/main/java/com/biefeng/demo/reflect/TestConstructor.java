package com.biefeng.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestConstructor {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.biefeng.demo.reflect.Construstor1");
            clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        try {
            //Class clazz = Class.forName("com.biefeng.demo.reflect.Construstor1");
            //Object obj = clazz.newInstance();
          Class clazz= ClassLoader.getSystemClassLoader().loadClass("com.biefeng.demo.reflect.Construstor1");
          Object o = clazz.newInstance();
          Field f = clazz.getField("name");
            Constructor c = clazz.getDeclaredConstructor();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2()
    {
        String name="biefeng";
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value= (char[]) field.get(name);
            value[3]='c';
            System.out.println(name);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Construstor1{
   static String name="";

    static {
        System.out.println("static");
    }
    {
        System.out.println("common");
    }

    public Construstor1() {
        this.name="biefeng";
        System.out.println("aaaa"+name);
    }
    public Construstor1(int i){
        System.out.println("aaaa"+name);
    }
}

class Constructor2{

    public Constructor2() {

    }
}