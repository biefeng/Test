package com.biefeng.demo.chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            String message = "你是谁啊";
            outputStream.write(message.getBytes("UTF-8"));
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] bs = new byte[1024];
            int len=0;
            StringBuilder sb = new StringBuilder();
            while((len=inputStream.read(bs))!=-1){
                sb.append(new String(bs,0,len));
            }
            System.out.println("回复的消息："+sb);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
