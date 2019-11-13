package com.biefeng.demo.zookeeper.queue;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class TetsQueueMain1 {
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        Queue queue  = new Queue("127.0.0.1","/test/queue");
        int i = queue.consume();
        System.out.println(i);
    }
}
