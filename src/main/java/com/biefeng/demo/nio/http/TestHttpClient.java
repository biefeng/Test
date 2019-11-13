package com.biefeng.demo.nio.http;

import com.biefeng.demo.nio.http.help.HttpThreadGroup;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestHttpClient {

    private static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        HttpThreadGroup group = new HttpThreadGroup();
        ExecutorService service = group.getService();
        //  for (int i = 0; i < 30; i++) {
        service.execute(() -> {
            try {
                startUpRequest();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //}
    }

    public static void startUpRequest() throws IOException {
        HttpClientParams clientParams = new HttpClientParams();
        clientParams.setContentCharset("utf-8");
        clientParams.setIntParameter("total", 20);

        HttpClient client = new HttpClient();
        client.setParams(clientParams);

        HostConfiguration configuration = new HostConfiguration();
        configuration.setHost("127.0.0.1", 7537, "http");
        client.setHostConfiguration(configuration);

        GetMethod getMethod = new GetMethod("/");

        int state = client.executeMethod(getMethod);
        Header[] headers = getMethod.getResponseHeaders();

        InputStream in = null;

        if (state == 200) {
            in = getMethod.getResponseBodyAsStream();
        }

        StringBuilder sb = new StringBuilder();

        if (null != in) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        try {
            lock.lock();
            for (Header header : headers) {
                System.out.println(header.getName() + " : " + header.getValue());
            }
            System.out.println(sb);
        } finally {
            lock.unlock();
        }

    }
}
