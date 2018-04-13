package com.biefeng.demo.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        Map<String,String> map  = new HashMap<>();
        map.put("name","别峰");
        System.out.println(map.get("name"));
    }



}
