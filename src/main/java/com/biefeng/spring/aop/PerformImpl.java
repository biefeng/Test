package com.biefeng.spring.aop;

/**
 * @Author BieFeNg
 * @Date 2018-06-09 14:16
 * @Desc
 */
public class PerformImpl implements Perform {
    @Override
    public void perform() {
        System.out.println("Zhou is performing");
    }
}
