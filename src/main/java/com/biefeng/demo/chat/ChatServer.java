package com.biefeng.demo.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    public static void main(String args[]) {
        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(100);
            ServerSocket serverSocket = new ServerSocket(8800);
            while (true) {
                Socket socket = serverSocket.accept();
                SocketChannel socketChannel = socket.getChannel();
                if (socketChannel != null) {
                    ByteBuffer buffer = ByteBuffer.allocate(50);
                    int byteCount = socketChannel.read(buffer);
                    StringBuffer msgFromClient = new StringBuffer();
                    while ((byteCount) != -1) {
                        socketChannel.read(buffer);
                        byte[] bs = new byte[byteCount];
                        buffer.flip();
                        int mark = 0;
                        while (buffer.hasRemaining()) {
                            bs[mark] = buffer.get();

                        }
                        msgFromClient.append(new String(bs, "UTF-8"));
                        buffer.clear();
                    /*buffer.compact();
                    if(buffer.hasRemaining()){
                        System.out.println("发生错误，还有数据未读");
                    }*/
                    }
                    System.out.println(msgFromClient.toString());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
