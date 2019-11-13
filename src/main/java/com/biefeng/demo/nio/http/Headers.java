package com.biefeng.demo.nio.http;

import java.util.ArrayList;
import java.util.List;

public class Headers {
    private static final List headers = new ArrayList();

    public void addHead(Header header) {
        headers.add(header);
    }

    public void delHeader(Header header) {
        headers.remove(header);
    }
}
