package com.biefeng.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {

        try {
            ServerSocket serverSocket = new ServerSocket(8800);
            System.out.println("server将一直等待连接的到来");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"连接到服务器");
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                StringBuilder sb = new StringBuilder();
                /*ReplyMessage replyMessage = new ReplyMessage(socket);
                Thread thread=new Thread(replyMessage);
                thread.start();*/
                while ((len = inputStream.read(bytes)) != -1) {
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }
                System.out.println("getMessage from client" + sb);

                /*OutputStream outputStream = socket.getOutputStream();
                outputStream.write(sb.toString().getBytes());
                outputStream.close();
*/
                inputStream.close();
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
/*
class ReplyMessage implements Runnable{

    Socket socket;
    ReplyMessage(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try{
        OutputStream outputStream = socket.getOutputStream();
        String reply = "我是服务器返回的消息";
        outputStream.write(reply.getBytes("UTF-8"));
    }catch (Exception e){
            e.printStackTrace();
        }
    }
}*/
