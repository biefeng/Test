package com.biefeng.demo.nio.http;

public class ResponserHeader extends Header {

    private String state = "200";

    private String stateDesc = "OK";

    public ResponserHeader(String httpMethod, String protocol, String version, String state, String stateDesc) {

        super.httpMethod = httpMethod;
        super.protocol = protocol;
        super.version = version;
        this.state = state;
        this.stateDesc = stateDesc;

        major = httpMethod + SPACE + protocol + "/" + version + SPACE + state + SPACE + stateDesc;
    }

}
