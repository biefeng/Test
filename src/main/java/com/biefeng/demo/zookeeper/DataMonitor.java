package com.biefeng.demo.zookeeper;

import org.apache.zookeeper.AsyncCallback.StatCallback;


import org.apache.zookeeper.KeeperException;
//import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

public class DataMonitor implements Watcher, StatCallback {

    private ZooKeeper zk;

    private String znode;

    private Watcher chainedWatcher;

    private DataMonitorListener listener;

    public boolean dead;

    byte[] preData;

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;
        zk.exists(znode, true, this, null);
    }

    public void process(WatchedEvent event) {
        String path = event.getPath();
        if (event.getType() == Watcher.Event.EventType.None) {
            switch (event.getState()) {
                case SyncConnected:
                    break;
                case Expired:
                    dead = true;
                    listener.closing(KeeperException.Code.SESSIONEXPIRED.intValue());
                    break;
            }
        } else {
            if (path != null) {
                zk.exists(znode, true, this, null);
            }
        }
        if (chainedWatcher != null) {
            chainedWatcher.process(event);
        }
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        boolean exists;
        switch (i) {
            case KeeperException.Code.Ok:
                exists = true;
                break;
            case KeeperException.Code.NoNode:
                exists = false;
                break;
            case KeeperException.Code.SessionExpired:
            case KeeperException.Code.NoAuth:
                exists = false;
                break;
            default:
                zk.exists(znode, true, this, null);
                return;
        }
        byte[] b = null;
        if (exists) {
            try {
                b = zk.getData(znode, false, null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                return;
            }
        }
        if ((b == null && b != preData) || (b != null && !Arrays.equals(b, preData))) {
            listener.exists(b);
            preData = b;
        }


    }

    public interface DataMonitorListener {
        void exists(byte[] data);

        void closing(int rc);
    }


}
