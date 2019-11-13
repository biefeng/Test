package com.biefeng.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class SyncPrimitive implements Watcher {
    protected static ZooKeeper zk = null;
    protected static final Object metux = new Object();

    public SyncPrimitive(String address) throws IOException {
        if (zk == null) {
            System.out.println("Starting the zookeeper");
            zk = new ZooKeeper(address, 5000, this);
            System.out.println("Finished starting the zookeeper! " + zk);
        }
    }

    @Override
    public void process(WatchedEvent event) {
        synchronized (metux) {
            metux.notify();
        }
    }
}
