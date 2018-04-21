package com.biefeng.thinkInJava.generic;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
            Class c1 = new ArrayList<String>().getClass();
            Class c2 = new ArrayList<Integer>().getClass();
            Class c3 = ArrayList.class;
            //Class c4 = ArrayList<String>.class //无法进行声明
        System.out.println(c1==c2);
    }
}
