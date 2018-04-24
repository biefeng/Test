package com.chinacoalsx;

import javax.xml.ws.Endpoint;

public class Test {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/userInfo",new SubscribeUserInfo());
        System.out.println("publish Succeded");
    }
}
