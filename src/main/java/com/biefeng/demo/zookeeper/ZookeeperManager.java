package com.biefeng.demo.zookeeper;

import com.biefeng.demo.protostuff.SerializeUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperManager {

    public static void main(String[] args) throws InterruptedException, KeeperException {
        ZookeeperManager manager = new ZookeeperManager("127.0.0.1:2181");
        ZooKeeper keeper = manager.getClient();
        TestMoudle moudle = new TestMoudle();
        moudle.setName("别峰");
        moudle.setSuccess(true);
        moudle.setTotal(20);
        manager.createNode("/test", SerializeUtils.serialzie(moudle), CreateMode.PERSISTENT);
        Stat stat = keeper.exists("/test", false);
        byte[] data = keeper.getData("/test", false, null);
        TestMoudle moudle1 = SerializeUtils.toObject(data, TestMoudle.class);
        System.out.println(moudle.getName());
        TimeUnit.MINUTES.sleep(1);
    }

    private String hostPort;

    private ZooKeeper zk;

    private CountDownLatch latch = new CountDownLatch(1);

    public ZookeeperManager(String hostPort) {
        this.hostPort = hostPort;

        try {
            zk = new ZooKeeper(hostPort, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState().equals(Event.KeeperState.SyncConnected))
                        latch.countDown();
                }
            });
            latch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

        }
    }

    public ZooKeeper getClient() {
        return zk;
    }

    /**
     * 创建节点
     *
     * @param path
     * @param data
     * @param mode
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String createNode(String path, byte[] data, CreateMode mode) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, false);
        String node = null;
        if (null == stat) {
            node = zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
        }
        return node;
    }

}
