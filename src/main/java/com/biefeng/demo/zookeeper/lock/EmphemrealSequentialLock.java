package com.biefeng.demo.zookeeper.lock;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/1 9:53
 */
public class EmphemrealSequentialLock extends LockBase {


    private String lockName;

    private static AtomicBoolean isLock = new AtomicBoolean(false);

    private static String tmpNode=null;

    public EmphemrealSequentialLock(String address, String lockName) {
        super(address);
        this.lockName = lockName;
    }

    public void lock() {
        try {
            if (!isLock.get()) {
                String createName = zk.create(lockName, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                List<String> children = zk.getChildren(lockName, false);
                if (null != children && children.size() > 0) {
                    String minNode = children.get(0);
                    if (minNode.equals(createName)) {
                        LOG.info("The current process get the lock!");
                    }else {
                        int index = children.indexOf(createName);
                        zk.exists(lockName + "/" + children.get(index-1), new Watcher() {
                            @Override
                            public void process(WatchedEvent event) {
                                if (event.getType()== Event.EventType.NodeDeleted){

                                }
                            }
                        });
                    }
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
