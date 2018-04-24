package com.biefeng.demo.gof.principal.openclose;

import java.util.UUID;

public class Manager {
    public void nameWorker(Worker worker, String id) {
        worker.name("我的工人的编号是：" + id);
    }

    public void allocateTask(Worker worker) {
        worker.role("我是木匠");
        worker.doSomething("我去干嘛了");
    }
}
