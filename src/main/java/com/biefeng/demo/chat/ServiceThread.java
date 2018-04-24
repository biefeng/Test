package com.biefeng.demo.chat;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
class ServiceThread extends Frame implements Runnable
{//当Client有请求时，Server创建一个Frame用于与之交互数据
    ServerService FatherListener; //创建当前通信线程的监听器对象
    Socket ConnectedClient;          //负责当前线程中C/S通信的Socket对象
    Thread ConnectThread;          //负责通信的线程
    Panel ListenerPanel;       //本次通信Server端的信息显示窗口
    TextArea ServerMeg;     //信息显示窗口的文本区域
    public ServiceThread (ServerService sv, Socket s ) //构造函数
    {
        FatherListener = sv;
        ConnectedClient = s;
        ConnectThread = new Thread(this);
        setTitle("Answer Client "); //建立并显示Server端信息显示窗口
        setLayout(new BorderLayout());
        ServerMeg = new TextArea(10, 50);
        add("Center", ServerMeg);
        setResizable(false); //不可改变窗口大小
        pack();
        show();
        //获得请求服务的Client端计算机的IP地址
        InetAddress ClientAddress =ConnectedClient.getInetAddress( );
        ServerMeg.appendText( "Client connected"+" from \n"+
                ClientAddress.toString( )+"\n");
    }
    public void run( )       //子线程任务：与Client端通信
    {
        try{
            DataInputStream in = new DataInputStream (
                    //获得从Client读入数据流
                    new BufferedInputStream(ConnectedClient.getInputStream()));
            PrintStream out = new PrintStream (
                    //获得向Client输出的数据流
                    new BufferedOutputStream( ConnectedClient.getOutputStream( )));
            out.println("Hello!Wellcome connect to our server!\r");
            out.flush( );            //向Client端输出信息
            String s = in.readLine( ); //从Client端读入信息
            while (!s.equals("Bye"))        //直至Client端表						       示要断开连接
            {
                ServerMeg.appendText("Client端输入的信息为：\n"+ s);
                s = in.readLine( );        //读入Client端写入的						下一行信息
            }
            ConnectedClient.close( );  //若Client端写入					      ″Bye″则结束通信
        }                         //try
        catch(Exception e){}

        FatherListener.addMeg( "Client " + " closed." 	+ "\n" );
        dispose( );                     //关闭当前通信Frame
    }                                       //run( )
}
class ServerService extends Frame //服务器端的监听器						   窗口
{
    ServerSocket  he;         //监听器
    TextArea ListenerMeg;         //显示信息的监听器窗口
    public ServerService(int Port,int Count)
    {
        try{
            he = new ServerSocket(Port, Count); //建							   立监听服务
            setTitle("Server Listener"); //建立监听服务的 							     窗口并显示
            this.addWindowListener(new WinAdpt());
            setLayout(new BorderLayout());
            ListenerMeg = new TextArea("监听服务已经启动\n", 10, 50);
            add("Center", ListenerMeg);
            setResizable(true);
            pack();

            show();
            while (true) {
                Socket Connected = he.accept();
                //接受来自Client端的请求
                InetAddress ClientAddress = Connected.getInetAddress();
                ListenerMeg.appendText("Client " + " 	connected" +
                        " from \n" + ClientAddress.toString() + " \n");
                //获得请求Client的IP并建立新线程新窗口与此Client通信
                ServiceThread MyST = new ServiceThread(this, Connected);
                MyST.ConnectThread.start(); //启动新线程
            }
        }
        catch(IOException e){}
    }
    public void addMeg(String s)
    //在监听器窗口中加入信息
    {
        ListenerMeg.appendText(s);
    }
}   //ServerSerive Class
class WinAdpt extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        ((Frame)e.getWindow( )).dispose( );

        System.exit(0);
    }
}



