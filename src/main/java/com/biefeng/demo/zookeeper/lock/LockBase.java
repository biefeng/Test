package com.biefeng.demo.zookeeper.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/1 9:53
 */
public class LockBase {

    protected static final Logger LOG = LoggerFactory.getLogger(LockDemo.class);

    private String address;

    protected ZooKeeper zk;

    private CountDownLatch latch = new CountDownLatch(1);

    public LockBase(String address) {
        this.address = address;
        if(null==zk){
            try {
                zk = new ZooKeeper(address, 5000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if(event.getState()== Event.KeeperState.SyncConnected)
                            latch.countDown();
                    }
                });
                latch.await();
                LOG.info("Connection was established successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
