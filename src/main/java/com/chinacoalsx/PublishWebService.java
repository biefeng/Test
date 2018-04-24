package com.chinacoalsx;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.Endpoint;

public class PublishWebService extends HttpServlet {
    public PublishWebService() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        Endpoint.publish("http://10.3.4.207:7011/Liems/webservice/SubscribUseInfoPortType",new SubscribeUserInfo());
        //Endpoint.publish("http://10.3.4.207:7011/Liems/webservice/SubscribUserInfo",new SubscribUserInfo());
        System.out.println("**************Service published!**********************");
    }
}
