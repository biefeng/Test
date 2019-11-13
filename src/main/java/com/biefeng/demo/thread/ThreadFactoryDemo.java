package com.biefeng.demo.thread;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo {
    static class OwnThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread();
        }
    }
}
