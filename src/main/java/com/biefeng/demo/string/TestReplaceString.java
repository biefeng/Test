package com.biefeng.demo.string;

import org.junit.Test;

import java.lang.reflect.Field;

public class TestReplaceString {
    public  static void main(String args[]){
        String ss  = new String("adasdaas");
        ss.replace("a","v");
        System.out.println(ss);
        String test = "biefeng";
        Class clazz =  String.class;
        try {
            Field field   =  clazz.getDeclaredField("value");
            field.setAccessible(true);
            char[] chars = (char[]) field.get(test);
            chars[2]='a';
            System.out.println(test);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        String str1 = new String();
       String str2="";
        System.out.println(str1==str2);
    }
}
