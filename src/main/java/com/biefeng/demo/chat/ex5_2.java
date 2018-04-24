package com.biefeng.demo.chat;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class WinAdptClient extends WindowAdapter
{
    MyClient hel;

    WinAdptClient(MyClient p)
    {
        hel = p;
    }
    public void windowClosing(WindowEvent e)
    {
        try{//关闭窗口前先向Server端发送结束信息，并		    关闭各输入输出流与连接
            hel.os.println("Bye");
            hel.os.flush( );
            hel.is.close( );
            hel.os.close( );
            hel.ClientSocket.close( );
            hel.dispose( );
            System.exit(0);
        }catch(Exception ex){}
    }
}
