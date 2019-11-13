package com.biefeng.demo.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Barriers extends SyncPrimitive {

    String root;
    int size;
    String name;

    public Barriers(String address, String name, int size) throws IOException, KeeperException, InterruptedException {
        super(address);
        this.root = name;
        this.size = size;

        if (zk != null) {
            Stat s = zk.exists(root, false);
            if (null == s) {
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }
        this.name = new String(InetAddress.getLocalHost().getCanonicalHostName().toString());
    }

    public boolean enter() throws KeeperException, InterruptedException {
        zk.create(root + "/" + name, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        while (true) {
            synchronized (metux) {
                List<String> list = zk.getChildren(root, true);
                if (list.size() < size) {
                    metux.wait();
                } else {
                    return true;
                }
            }
        }
    }

    public boolean leave() throws KeeperException, InterruptedException {
        zk.delete(root + "/" + name, 0);
        while (true) {
            synchronized (metux) {
                List<String> list = zk.getChildren(root, true);
                if (list.size() > 0) {
                    metux.wait();
                } else {
                    return true;
                }
            }
        }
    }

}
