package com.biefeng.demo.map;

import org.junit.Test;

import java.util.*;

public class TestMap {

    @Test
    public void test1() {
        SortedSet<String> sortedSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            sortedSet.add(Integer.toString(i));
        }
        SortedSet<String> newSet = ((TreeSet<String>) sortedSet).headSet("3");

        for(String str:newSet){
            System.out.println(str);
        }
    }

    @Test
    public void name() {


    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","111");
    }
}
