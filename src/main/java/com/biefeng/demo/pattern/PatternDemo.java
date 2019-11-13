package com.biefeng.demo.pattern;

import org.junit.Test;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    Pattern pattern = Pattern.compile("(\\d+)\\s+(\\S)??");

    @Test
    public void test1() {
        Matcher matcher = pattern.matcher("1 ASD1E NE ADSAS DASAS ADSAS 0 NA");
        if(matcher.find()){
            System.out.println(matcher.group(0));
        }

    }


    @Test
    public void test2() {
        BigInteger val1 = new BigInteger("11");
        System.out.println(val1.max(new BigInteger("12")));
    }
}
