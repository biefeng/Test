package com.biefeng.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Executor implements Watcher, Runnable, DataMonitor.DataMonitorListener {

    private ZooKeeper zk;

    private String hostPort;

    private String fileName;

    private String[] exec;

    private DataMonitor dm;

    Process child;


    public Executor(String hostPort, String fileName, String[] exec, String znode) throws IOException {
        this.fileName = fileName;
        this.exec = exec;

        zk = new ZooKeeper(hostPort, 4000, this);
        dm = new DataMonitor(zk, znode, null, this);
    }

    public static void main(String args[]) {
        if(args.length<4){
            System.err.println("USAGE: Executor hostPort znode filename program [args ...]");
            System.exit(2);
        }

        String hostPort=args[0];
        String zNode=args[1];
        String fileName=args[2];
        String exec[] = new String[args.length-3];

        System.arraycopy(args,3,exec,0,exec.length);

        try {
            new Executor(hostPort,fileName,exec,zNode).run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!dm.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void process(WatchedEvent event) {
        dm.process(event);
    }

    @Override
    public void exists(byte[] data) {
        if (data == null) {
            if (child != null) {
                System.out.println("Killing the process!");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                child = null;
            }
        }else {
            if (child != null) {
                System.out.println("Stopping child");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(data);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Starting child");
                System.out.println();
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    static class StreamWriter extends Thread {
        OutputStream out;

        InputStream in;

        StreamWriter(InputStream in,OutputStream out) {
            this.out = out;
            this.in = in;
            start();
        }

        @Override
        public void run() {
            byte bytes[] = new byte[80];
            int rc;
            try {
                while ((rc = in.read(bytes)) != -1) {
                    out.write(bytes, 0, rc);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
