package com.biefeng.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OptimizedClient1 {
    public static void main(String args[]) {

        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        Scanner input = new Scanner(System.in);
        byte[] bs;
        while (true) {
            try {
                Runnable runnable = () -> {

                };
                Socket socket = new Socket("localhost", 8800);

                OutputStream outputStream = socket.getOutputStream();
                String str = input.next();
                bs = str.getBytes("UTF-8");
                outputStream.write(bs.length >> 8);
                outputStream.write(bs.length);
                outputStream.write(str.getBytes("UTF-8"));
                socket.shutdownOutput();
                InputStream inputStream = socket.getInputStream();
                bs = new byte[1024];
                int len = 0;
                StringBuffer stringBuffer = new StringBuffer();
                while ((len = inputStream.read(bs)) != -1) {
                    stringBuffer.append(new String(bs, "UTF-8"));
                }
                System.out.println(stringBuffer.toString());
                inputStream.close();
                outputStream.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
