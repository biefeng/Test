package com.biefeng.demo.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChatClient {
    public static void main(String args[]) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        // ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("127.0.0.1", 8800));
            if (channel.finishConnect()) {
                int i = 0;

                String msg = "This is Message_" + i++ + "from client";
                byteBuffer1.clear();
                byte[] bs = msg.getBytes();
                int mark = 0;
                while (mark < bs.length) {
                    int limit = 0;
                    while ((bs.length - mark) > 0 && limit < 1023) {

                        byteBuffer1.put(bs[mark]);

                        limit++;
                        mark++;
                    }
                       /* byte[] bytes = CommonUtils.int2bytes(limit);
                        System.out.println(bytes.length);
                        byteBuffer2.put(bytes);
                        byteBuffer2.flip();*/
                    byteBuffer1.flip();
                        /*while ((byteBuffer2.hasRemaining()))
                            channel.write(byteBuffer2);*/
                    while (byteBuffer1.hasRemaining()) {

                        channel.write(byteBuffer1);
                    }
                }


            }
            channel.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils {
    //高位在前，低位在后
    public static byte[] int2bytes(int num) {
        byte[] result = new byte[4];
        result[0] = (byte) ((num >>> 24) & 0xff);//说明一
        result[1] = (byte) ((num >>> 16) & 0xff);
        result[2] = (byte) ((num >>> 8) & 0xff);
        result[3] = (byte) ((num >>> 0) & 0xff);
        return result;
    }
}
