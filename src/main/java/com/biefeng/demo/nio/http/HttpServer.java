package com.biefeng.demo.nio.http;

import com.biefeng.demo.nio.http.help.HttpThreadGroup;
import sun.misc.BASE64Encoder;
import sun.security.action.GetPropertyAction;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HttpServer {

    private ConcurrentHashMap<String, SocketChannel> connectedChannel = new ConcurrentHashMap<>();

    private static final int PORT = 7537;

//    String ;


    private static final String NEWLINE = AccessController.doPrivileged(new GetPropertyAction("line.separator"));

    private static final String webSocketLocation = "ws://127.0.0.1:7537/websocket";

    private String responseHeader = "HTTP/1.1 200 OK\r\n" +
            "Content-Length:" + content.getBytes().length + "\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "\r\n";

    private String errorResponseHeader = "HTTP/1.1 404 Not Foundr\r\n" +
            "content-length: 13\r\n";

    private static String content = "这个教程的目标读者是对机器学习和TensorFlow";

    private static String websocket_content = "<html><head><title>Web Socket Test</title></head>" + NEWLINE +
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

    public HttpServer() throws IOException {
        this.selectors = new Selector[4];
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        selectors[2] = Selector.open();
        selectors[3] = Selector.open();

    }

    public HttpServer localAddress(InetSocketAddress address) {
        this.address = address;
        return this;
    }

    public HttpServer bind() throws IOException {
        if (null == address) {
            throw new RuntimeException("未指定端口");
        }
        bind(address);
        return this;
    }

    public HttpServer bind(int port) throws IOException {
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
                                System.out.println("注册channel:" + socketChannel.getRemoteAddress().toString() + " 到读selector：" + selectors[READ_SEL_INDEX]);
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
                                System.out.println("The length of recived message is: " + msg.length);
                                String content = new String(msg, "utf-8");
                                System.out.println("The recived message from client :\r\n " + content + "(utf-8)");

                                if (content.contains("HTTP/1.1")) {
                                    RequestEncoder requestEncoder = new RequestEncoder(content);
                                    requestEncoder.decode();
                                    RequestHeader header = requestEncoder.getRequestHeader();

                                    Map<String, Object> props = new HashMap<>();
                                    props.put("path", header.getPath());
                                    props.put("key", header.get("Sec-WebSocket-Key"));
                                    props.put("protocol", header.getProtocol());
                                    props.put("handshake", false);

                                    socketChannel.register(selectors[WRITE_SEL_INDEX], SelectionKey.OP_WRITE).attach(props);
                                } else {
                                    socketChannel.register(selectors[WRITE_SEL_INDEX], SelectionKey.OP_WRITE).attach(content);
                                }
                            } catch (IOException e) {
                                //e.printStackTrace();
                                System.out.println("------------The connection has been closed by the client when reading message from client!------------");
                                socketChannel.close();
                            } finally {
                                lock.unlock();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
                                Object attach = key.attachment();
                                if (attach instanceof Map) {
                                    Map<String, Object> map = (Map<String, Object>) key.attachment();
                                    boolean handshake = (boolean) map.get("handshake");
                                    if (((String) map.get("path")).contains("websocket")) {

                                        System.out.println("websocket channel");
                                        String accept_key = (String) map.get("key");
                                        accept_key += "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
                                        MessageDigest digest = MessageDigest.getInstance("SHA-1");
                                        digest.update(accept_key.getBytes("utf-8"), 0, accept_key.length());
                                        byte[] bytes = digest.digest();
                                        accept_key = new String(new BASE64Encoder().encode(bytes));

                                        String websocketResponseHeader = "HTTP/1.1 101 Switching Protocols" + NEWLINE +
                                                "upgrade: websocket" + NEWLINE +
                                                "connection: upgrade" + NEWLINE +
                                                "sec-websocket-accept: " + accept_key + NEWLINE +
                                                "sec-websocket-extensions: permessage-deflate" + NEWLINE + NEWLINE;

                                        if (!handshake) {
                                            socketChannel.write(ByteBuffer.wrap(websocketResponseHeader.getBytes("utf-8")));
                                            System.out.println("The websocketResponseHear has been sent to client!");
                                            key.cancel();
                                            handshake = true;
                                        } else {
                                            socketChannel.write(ByteBuffer.wrap("Hell".getBytes("utf-8")));
                                        }
                                    } else if (((String) map.get("path")).contains("favicon")) {
                                        socketChannel.write(ByteBuffer.wrap(errorResponseHeader.getBytes("utf-8")));
                                        socketChannel.close();
                                    } else {
                                        System.out.println("Writing message to connection: " + socketChannel.getRemoteAddress());
                                        a = socketChannel.write(ByteBuffer.wrap(responseHeader.getBytes("UTF-8")));
                                        a += socketChannel.write(ByteBuffer.wrap(content.getBytes()));
                                        System.out.println(a + " bytes has been written to client!");
                                        socketChannel.close();
                                    }
                                } else if (attach instanceof String) {
                                    socketChannel.write(ByteBuffer.wrap("111".getBytes("utf-8")));
                                    key.cancel();
                                }
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
                    e.printStackTrace();
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

    public HttpServer group(HttpThreadGroup bossGroup, HttpThreadGroup workGroup) {
        this.workGroup = workGroup;
        this.bossGroup = bossGroup;

        return this;
    }

    public static void main(String[] args) throws IOException {
        new HttpServer().group(new HttpThreadGroup(), new HttpThreadGroup()).bind(PORT);
    }
}





