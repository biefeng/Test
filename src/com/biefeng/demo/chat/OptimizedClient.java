package com.biefeng.demo.chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class OptimizedClient {

    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            String message = "客户端发送的消息1";
            byte[] bs = message.getBytes("UTF-8");
            outputStream.write(bs.length >> 8);
            outputStream.write(bs.length);
            outputStream.write(bs);
            outputStream.flush();
            String message2 = "客户端发送的消息2";
            bs = message2.getBytes("UTF-8");
            outputStream.write(bs.length >> 8);
            outputStream.write(bs.length);
            outputStream.write(bs);
            outputStream.flush();
            socket.shutdownOutput();
            System.out.println("消息发送完毕，开始接收服务器的消息");
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("收到服务器返回的消息：" + stringBuilder);
            inputStream.close();
            socket.close();
        } catch (Exception e) {
        }
    }


    public static void test(){

    }
}
