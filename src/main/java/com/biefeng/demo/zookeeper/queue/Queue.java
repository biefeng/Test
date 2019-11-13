package com.biefeng.demo.zookeeper.queue;

import com.biefeng.demo.zookeeper.SyncPrimitive;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class Queue extends SyncPrimitive {

    private String root;

    public Queue(String address, String name) throws IOException, KeeperException, InterruptedException {
        super(address);
        this.root = name;
        if (zk != null) {
            Stat s = zk.exists(root, false);
            if (null == s) {
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }
    }

    boolean produce(int i) throws KeeperException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        byte[] value;
        buffer.putInt(i);
        value = buffer.array();
        zk.create(root + "/element", value, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
        return true;
    }

    int consume() throws KeeperException, InterruptedException {
        int retValue = -1;
        Stat s = null;
        while (true) {
            synchronized (metux){
                List<String> list = zk.getChildren(root,true);
                if(list.isEmpty()){
                    System.out.println("Going to wait");
                    metux.wait();
                }else {
                    Integer min = new Integer(list.get(0).substring(7));
                    for(String str: list){
                        Integer tempValue = new Integer(str.substring(7));
                        if(tempValue < min) min = tempValue;
                    }
                    System.out.println("Temporary value: " + root + "/element" + min);
                    byte[] b = zk.getData(root + "/element000000000" + min, false, s);
                    zk.delete(root + "/element000000000" + min, 0);
                    ByteBuffer buffer = ByteBuffer.wrap(b);
                    retValue = buffer.getInt();

                    return retValue;
                }

            }
        }
    }
}
