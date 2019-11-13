package com.biefeng.demo.nio;

import org.junit.Test;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class TestFileChannel {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("d:\\testChannel.txt", "rw");
            FileChannel channel = file.getChannel();

            ByteBuffer bf = ByteBuffer.allocate(256);

            int i = channel.read(bf);

            while (i != -1) {
                System.out.println("Read " + i);
                bf.flip();
                while (bf.hasRemaining()) {
                    System.out.println((char) bf.get());
                }
                bf.clear();
                i = channel.read(bf);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws FileNotFoundException {
        File file = new File("d:\\testChannel.txt");
        FileInputStream is = new FileInputStream(file);
        is.getChannel();
    }
}
