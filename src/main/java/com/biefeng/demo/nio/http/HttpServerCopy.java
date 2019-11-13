package com.biefeng.demo.nio.http;

import com.biefeng.demo.nio.http.help.HttpThreadGroup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HttpServerCopy {

    private ConcurrentHashMap<String, SocketChannel> connectedChannel = new ConcurrentHashMap<>();

    private static final int PORT = 7537;


    private static final String NEWLINE = "\r\n";

    private static final String webSocketLocation = "ws://127.0.0.1:7537/test";

    private String responseHeader = "HTTP/1.1 200 OK\r\n" +
            "Content-Length:" + content.length() + "\r\n" +
            "Content-Type: text/html\r\n" +
            "\r\n";

    private static String content = "<html><head><title>Web Socket Test</title></head>" + NEWLINE +
            "<body>" + NEWLINE +
            "<script type=\"text/javascript\">" + NEWLINE +
            "var socket;" + NEWLINE +
            "if (!window.WebSocket) {" + NEWLINE +
            "  window.WebSocket = window.MozWebSocket;" + NEWLINE +
            '}' + NEWLINE +
            "if (window.WebSocket) {" + NEWLINE +
            "  socket = new WebSocket(\"" + webSocketLocation + "\");" + NEWLINE +
            "  socket.onmessage = function(event) {" + NEWLINE +
            "    var ta = document.getElementById('responseText');" + NEWLINE +
            "    ta.value = ta.value + '\\n' + event.data" + NEWLINE +
            "  };" + NEWLINE +
            "  socket.onopen = function(event) {" + NEWLINE +
            "    var ta = document.getElementById('responseText');" + NEWLINE +
            "    ta.value = \"Web Socket opened!\";" + NEWLINE +
            "  };" + NEWLINE +
            "  socket.onclose = function(event) {" + NEWLINE +
            "    var ta = document.getElementById('responseText');" + NEWLINE +
            "    ta.value = ta.value + \"Web Socket closed\"; " + NEWLINE +
            "  };" + NEWLINE +
            "} else {" + NEWLINE +
            "  alert(\"Your browser does not support Web Socket.\");" + NEWLINE +
            '}' + NEWLINE +
            NEWLINE +
            "function send(message) {" + NEWLINE +
            "  if (!window.WebSocket) { return; }" + NEWLINE +
            "  if (socket.readyState == WebSocket.OPEN) {" + NEWLINE +
            "    socket.send(message);" + NEWLINE +
            "  } else {" + NEWLINE +
            "    alert(\"The socket is not open.\");" + NEWLINE +
            "  }" + NEWLINE +
            '}' + NEWLINE +
            "</script>" + NEWLINE +
            "<form onsubmit=\"return false;\">" + NEWLINE +
            "<input type=\"text\" name=\"message\" value=\"Hello, World!\"/>" +
            "<input type=\"button\" value=\"Send Web Socket Data\"" + NEWLINE +
            "       onclick=\"send(this.form.message.value)\" />" + NEWLINE +
            "<h3>Output</h3>" + NEWLINE +
            "<textarea id=\"responseText\" style=\"width:500px;height:300px;\"></textarea>" + NEWLINE +
            "</form>" + NEWLINE +
            "</body>" + NEWLINE +
            "</html>" + NEWLINE;

    private HttpThreadGroup workGroup;
    private HttpThreadGroup bossGroup;

    private static final int ACCRPT_SEL_INDEX = 0;
    private static final int READ_SEL_INDEX = 1;
    private static final int WRITE_SEL_INDEX = 2;
    private static final int HEART_BEAT = 3;

    private Lock lock = new ReentrantLock();

    private volatile Selector selectors[];

    private Boolean flag = false;

    private InetSocketAddress address;

    private ExecutorService service;

    public HttpServerCopy() throws IOException {
        this.selectors = new Selector[4];
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        selectors[2] = Selector.open();
        selectors[3] = Selector.open();

    }

    public HttpServerCopy localAddress(InetSocketAddress address) {
        this.address = address;
        return this;
    }

    public HttpServerCopy bind() throws IOException {
        if (null == address) {
            throw new RuntimeException("未指定端口");
        }
        bind(address);
        return this;
    }

    public HttpServerCopy bind(int port) throws IOException {
        service = bossGroup.getService();
        ServerSocketChannel serverSocketChannel = bind(new InetSocketAddress("127.0.0.1", port));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selectors[ACCRPT_SEL_INDEX], SelectionKey.OP_ACCEPT);
        service.submit(() -> {
            try {
                Selector selector = selectors[ACCRPT_SEL_INDEX];
                while (!Thread.currentThread().isInterrupted()) {
                    selector.select();
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();
                        if (key.isAcceptable()) {
                            ServerSocketChannel tempChannel = (ServerSocketChannel) key.channel();
                            try {
                                lock.lock();
                                SocketChannel socketChannel = tempChannel.accept();
                                socketChannel.configureBlocking(false);
                                System.out.println("A connection come in,address: " + socketChannel.getRemoteAddress());
                                socketChannel.register(selectors[READ_SEL_INDEX], SelectionKey.OP_READ);
                                System.out.println("注册channel:" + socketChannel.getRemoteAddress().toString() + "到读selector：" + selectors[READ_SEL_INDEX]);
                            } finally {
                                lock.unlock();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        service = workGroup.getService();
        service.submit(() -> {
            Selector selector = selectors[READ_SEL_INDEX];
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    selector.select(5);


                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();
                        SocketChannel socketChannel;
                        if (key.isReadable()) {
                            socketChannel = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
                            try {
                                lock.lock();
                                System.out.println("Reading meassage from connection: " + socketChannel.getRemoteAddress());
                                socketChannel.read(byteBuffer);
                                byte[] msg = byteBuffer.array();
                                System.out.println("The recived message from client:\r\n " + new String(msg, "UTF-8"));
                                socketChannel.register(selectors[WRITE_SEL_INDEX], SelectionKey.OP_WRITE);
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("------------The connection has been closed by the client when reading message from client!------------");
                                socketChannel.close();
                            } finally {
                                lock.unlock();
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        service.submit(() -> {
            Selector selector = selectors[WRITE_SEL_INDEX];
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    int i = selector.select(5);
                    if (i <= 0) {
                        continue;
                    }
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();
                        SocketChannel socketChannel;
                        if (key.isWritable()) {
                            socketChannel = (SocketChannel) key.channel();
                            try {
                                lock.lock();
                                int a = 0;
                                System.out.println("Writing message to connection: " + socketChannel.getRemoteAddress());
                                a = socketChannel.write(ByteBuffer.wrap(responseHeader.getBytes("UTF-8")));
                                a += socketChannel.write(ByteBuffer.wrap(content.getBytes("utf-8")));
                                System.out.println(a + " bytes has been written to client!");
                                socketChannel.socket().setKeepAlive(true);
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("---------The connection has been closed by the client when writing message to client!----------");
                                socketChannel.close();
                                continue;
                            } finally {
                                lock.unlock();
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return this;
    }

    private ServerSocketChannel bind(InetSocketAddress address) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(address);
        return serverSocketChannel;
    }

    public HttpServerCopy group(HttpThreadGroup bossGroup, HttpThreadGroup workGroup) {
        this.workGroup = workGroup;
        this.bossGroup = bossGroup;

        return this;
    }

    public static void main(String[] args) throws IOException {
        new HttpServerCopy().group(new HttpThreadGroup(), new HttpThreadGroup()).bind(7537);

    }
}





