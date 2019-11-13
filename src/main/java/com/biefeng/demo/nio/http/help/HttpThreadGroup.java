package com.biefeng.demo.nio.http.help;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpThreadGroup {

    private static AtomicInteger count = new AtomicInteger(0);

    private ExecutorService service;

   /* public HttpThreadGroup() {
        this.selectorProvider = SelectorProvider.provider();
        selectors = new Selector[3];
        for (int i = 0; i < selectors.length; i++) {
            try {
                selectors[i] = selectorProvider.openSelector();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public HttpThreadGroup() {

        service = new ThreadPoolExecutor(5, 10, 3000, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(20), new ServerThreadFactory());
    }

    public ExecutorService getService() {
        return service;
    }

  /*  public void bind(int port) {

        Future f = service.submit(() -> {
            System.out.println("Start");
            Selector selector = null;
            try {


                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.bind(new InetSocketAddress(port));
                serverSocketChannel.configureBlocking(false);
                selector = selectors[ACCEPT_INDEX];
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while (!Thread.interrupted()) {
                    selector.select();
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();
                        if (key.isAcceptable()) {
                            dispatcher(key);
                        } else if (key.isReadable()) {
                            serverSocketChannel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);

                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("异常信息：" + e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }*/

   /* private void dispatcher(SelectionKey key) {
        Future future = service.submit(() -> {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel;
            try {
                System.out.println("Solving the msg");
                socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                socketChannel.read(byteBuffer);
                byte[] msg = byteBuffer.array();
                System.out.println(new String(msg, "UTF-8"));
                //byteBuffer.flip();
                //byteBuffer.put("The return message!".getBytes("UTF-8"));
                // socketChannel.write(byteBuffer);
            } catch (IOException e) {
                System.out.println("异常信息：" + e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }*/

    private static class ServerThreadFactory implements ThreadFactory {


        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "Thread-" + Integer.toString(count.getAndIncrement()));
            t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
            return t;
        }
    }

    private static class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("异常信息: " + e.getMessage());
            t.interrupt();
        }
    }


    /*public static void main(String[] args) {
        HttpThreadGroup group = new HttpThreadGroup();
        group.init().bind(8888);
    }*/

}
