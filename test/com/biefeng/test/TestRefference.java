package com.biefeng.test;

import org.junit.Test;

public class TestRefference {

    public void printStr(String name){
        name="biefeng";
        System.out.println(name);
    }

    @Test
    public void test1(){
        String name="wahha";
        printStr(name);
        System.out.println(name);
    }

    @Test
    public void testURShift() {
        int i=32;
        System.out.println(32>>>2);
    }
}
