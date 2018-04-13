package com.biefeng.demo.chat.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

public class ChatRoomServer {
    private Selector selector;
    static final int port = 9999;
    private Charset charset = Charset.forName("utf-8");

    //记录在线人数及昵称
    private HashSet<String> users = new HashSet<>();

    private static String user_exit = "System Message :user exit ,please chage another name";
    //自定义协议格式，与客户端协商好的
    private static String USER_CONTENT_SPLIT = "#a#";

    private static boolean flag=false;

    private void init()throws IOException {
        selector=Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        //设定非阻塞
        serverSocketChannel.configureBlocking(false);

    }
}
