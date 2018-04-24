package com.biefeng.demo.chat;

public class MySocketServer//Java Application主类
{
    public static void main(String[] args) {
        ServerService MyServer = new ServerService(8000, 10); //建立监听服务
    }
}

