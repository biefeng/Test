package com.biefeng.demo.zookeeper.lock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author : BieFeNg
 * @DATE : 2018/8/31 22:53
 */
public class TestLockDemo2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        LockDemo lockDemo = new LockDemo("127.0.0.1:2181","/test/lock");
        lockDemo.lock();
        TimeUnit.SECONDS.sleep(30);
        lockDemo.releaseLock();
        System.out.println("The process finish the work and release the lock!");
        TimeUnit.SECONDS.sleep(60);
    }
}
