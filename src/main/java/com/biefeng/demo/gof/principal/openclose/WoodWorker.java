package com.biefeng.demo.gof.principal.openclose;

public class WoodWorker implements Worker {
    @Override
    public void name(String name) {
        System.out.println("name: " + name);
    }

    @Override
    public void role(String role) {
        System.out.println("role: " + role);
    }

    @Override
    public void doSomething(String job) {
        System.out.println("job: " + job);
    }


}
