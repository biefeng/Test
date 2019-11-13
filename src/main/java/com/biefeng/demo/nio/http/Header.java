package com.biefeng.demo.nio.http;

import java.util.HashMap;
import java.util.Map;

public abstract class Header {

    String httpMethod = "GET";

    String protocol = "HTTP";

    String path = "/";

    String version = "1.1";

    protected String major;

    protected static final String SPACE = " ";

    protected Map<String, String> values;

    {
        values = new HashMap<>();
    }

    public void add(String name, String value) {
        values.put(name, value);
    }

    public String get(String name) {
        return values.get(name);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(major).append("\r\n");
        for (Map.Entry<String, String> entry : values.entrySet()) {

            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPath() {
        return path;
    }

    public String getVersion() {
        return version;
    }
}
