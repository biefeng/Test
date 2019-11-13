package com.biefeng.demo.nio.http;

import java.util.Map;

public class RequestHeader extends Header {

    public RequestHeader(String str) {
        major = str;
    }

    public void setHttpMethod(String httpMethod) {
        super.httpMethod = httpMethod;
    }

    public void setProtocol(String protocol) {
        super.protocol = protocol;
    }

    public void setPath(String path) {
        super.path = path;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map getValues() {
        return super.values;
    }
}

