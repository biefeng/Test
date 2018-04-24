package com.chinacoalsx.xsd;



import com.chinacoalsx.SubscribeUserInfo;

import javax.xml.ws.Endpoint;

public class Test {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/Liems/webserive", new SubscribeUserInfo());

    }
}
