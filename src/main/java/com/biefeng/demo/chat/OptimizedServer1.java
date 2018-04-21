package com.biefeng.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class OptimizedServer1 {
    public static void main(String args[]) {
      /*  try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

            ExecutorService threadPool = Executors.newFixedThreadPool(100);
            ServerSocket serverSocket = new ServerSocket(8800);
            System.out.println("服务器等待连接");
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable runnable = () -> {
                    try {
                        byte bytes[];
                        InputStream inputStream = socket.getInputStream();
                        int count = 0;
                        while (true) {
                            int first = inputStream.read();
                            if (first == -1) {
                                break;
                            }
                            int second = inputStream.read();
                            int len = (first << 8) + second;
                            bytes = new byte[len];
                            inputStream.read(bytes);
                            count++;
                            System.out.println("getMessage " + count + " from client :" + new String(bytes, "UTF-8"));
                        }
                        System.out.println("消息接受完毕，开始发送消息");
                        OutputStream outputStream = socket.getOutputStream();
                        Scanner input = new Scanner(System.in);
                        String returnMsg=input.next();
                        System.out.println("returnMsg："+returnMsg);
                        outputStream.write(returnMsg.getBytes("UTF-8"));
                        outputStream.flush();
                        outputStream.close();
                        System.out.println("消息发送完毕");
                        System.out.println(sdf.format(new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
                threadPool.submit(runnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
