package com.biefeng.demo.zookeeper.lock;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static com.biefeng.demo.zookeeper.lock.LockBase.LOG;

/**
 * @Author : BieFeNg
 * @DATE : 2018/8/31 21:35
 */
public class LockDemo extends LockBase{

    private String lockNode;



    private static final Object MUTEX = new Object();

    LockDemo(String address, String lockNode) throws IOException, InterruptedException {
        super(address);
        this.lockNode = lockNode;

    }

    public void watchNode() {
        try {
            zk.exists(lockNode, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.NodeDeleted) {
                        LOG.info("The lock has been released!");
                        synchronized (MUTEX) {
                            MUTEX.notifyAll();
                        }
                    }
                    watchNode();
                }
            });
        } catch (KeeperException e) {
            LOG.error(e.getMessage());
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }

    public void lock() throws InterruptedException {
        watchNode();
        while (true) {
            try {
                zk.create(lockNode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                LOG.info("The current process gets the lock!");
                return;
            } catch (KeeperException e) {
                LOG.info("There is an another process hold the lock");
                synchronized (MUTEX) {
                    LOG.info("Waiting the other process to release the lock!");
                    MUTEX.wait();
                }
            } catch (InterruptedException e) {
                LOG.error(e.getMessage());
                return;


            }
        }
    }

    public void releaseLock() {
        try {
            zk.delete(lockNode, -1);
            LOG.info("The current process release the lock!");
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        } catch (KeeperException e) {
            LOG.error(e.getMessage());
        }
    }

}
