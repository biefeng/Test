package com.biefeng.demo.chat;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;


public class MyClient extends Frame implements ActionListener {
    Socket ClientSocket;
    PrintStream os;
    DataInputStream is;
    String s;
    String labelMessage="欢迎使用本机提供的信息";
    Label Mylabel;

    {
        try {
            Mylabel = new Label(new String(labelMessage.getBytes("GBK"),"GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    TextArea textArea;
    Button MyButton = new Button("发送");

    public MyClient() {
        setTitle("Client Window");//建立并显示与Server					           通信的信息窗口
        setLayout(new BorderLayout());
        this.addWindowListener(new WinAdptClient(this));
        MyButton.addActionListener(this);
        textArea = new TextArea(20, 50);
        add("North", Mylabel);
        add("South", MyButton);
        add("Center", textArea);
        setResizable(false);
        pack();
        show();
        connect();                           //与Server端连接通信
    }

    public void connect() {
        try {
            ClientSocket = new Socket("", 8000);   //连向Server主机的8000端口
            os = new PrintStream(
                    new BufferedOutputStream(ClientSocket.getOutputStream()));
            is = new DataInputStream(
                    new BufferedInputStream(ClientSocket.getInputStream()));
            s = is.readLine();//从Server端读入数据
            textArea.appendText(s + "\n");
        } catch (Exception e) {
        }
    }

    public void actionPerformed(ActionEvent e) {//当点击按钮时向Server端发送信息
        if (e.getSource() == MyButton) {
            try {
                os.print(textArea.getText());
                os.flush();
            } catch (Exception ex) {
            }
        }
    }

    public static void main(String args[]) {
        new MyClient();
    }
}
