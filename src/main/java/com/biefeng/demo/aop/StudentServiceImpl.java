package com.biefeng.demo.aop;

public class StudentServiceImpl {

    public String print(String str){
        System.out.println("The Service print method:"+str);
        return str;
    }
}
