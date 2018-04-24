package net.luculent.liems.webservice.business.usrInfo.xsd;


import net.luculent.liems.webservice.business.usrInfo.SubscribUserInfo;

import javax.xml.ws.Endpoint;

public class Test {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/Liems/webserive", new SubscribUserInfo());

    }
}
