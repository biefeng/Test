package com.biefeng.demo.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable1());
        t1.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t1.interrupt();

    }

    static class Runnable1 implements Runnable {

        volatile boolean flag = true;

        @Override
        public void run() {

            int count = 1;
            while (!Thread.interrupted()) {
                System.out.println("Thread is running:" + count++);
            }
        }
    }

}
