package com.biefeng.demo.zookeeper.queue;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TetsQueueMain2 {


    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        Queue queue  = new Queue("127.0.0.1","/test/queue");
        boolean i = queue.produce(2);
        System.out.println(i);
        TimeUnit.MINUTES.sleep(10);
    }
}
