package com.biefeng.demo.model;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/2 23:54
 */
public class Model implements Comparable<Model> {

    int age;

    @Override
    public int compareTo(Model o) {
        return this.age > o.age ? 0 : -1;
    }
}
