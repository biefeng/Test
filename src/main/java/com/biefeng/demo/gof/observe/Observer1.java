package com.biefeng.demo.gof.observe;

public class Observer1 implements Observer {

    public String name;

    public Observer1(String name){
        this.name=name;
    }
    @Override
    public void update() {
        System.out.println(name+"发现Observed更新了");
    }
}
