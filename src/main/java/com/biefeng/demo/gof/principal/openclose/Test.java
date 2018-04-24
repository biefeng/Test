package com.biefeng.demo.gof.principal.openclose;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.nameWorker(new WoodWorker(), UUID.randomUUID().toString().replace("-",""));
        manager.allocateTask(new WoodWorker());
    }

}
