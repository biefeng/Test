package com.biefeng.demo.chat;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OptimizedServer {
    public static void main(String args[]) {

        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(100);
            ServerSocket serverSocket = new ServerSocket(8800);
            System.out.println("服务器在等待连接");
            while (true) {
                Socket socket = serverSocket.accept();
               /* Runnable runnable = () -> {
                    try {

                        byte[] bytes;
                        InputStream inputStream = socket.getInputStream();
                        while (true) {
                            int first = inputStream.read();
                            if (first == -1) {
                                break;
                            }
                            int second = inputStream.read();
                            int length = (first << 8) + second;
                            bytes = new byte[length];
                            inputStream.read(bytes);
                            System.out.println("getMessage From client" + new String(bytes, "UTF-8"));

                        }
                        System.out.println("消息接受完毕");
                        *//*OutputStream outputStream = socket.getOutputStream();
                        String message = "服务器返回的消息";
                        outputStream.write(message.getBytes("UTF-8"));
                        outputStream.close();*//*
                        inputStream.close();
                        socket.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
                threadPool.submit(runnable);
            */
            }
        } catch (Exception e) {
        }
    }
}
