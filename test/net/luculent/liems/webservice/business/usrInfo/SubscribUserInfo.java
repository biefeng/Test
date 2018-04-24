package net.luculent.liems.webservice.business.usrInfo;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "SubscribeUserInfo", targetNamespace = "http://chinacoalsx.com", wsdlLocation = "http://10.3.4.207:7010/chinacoalsxliems/webservice/SubscribUserInfo?wsdl")
public class SubscribUserInfo extends Service {

    private static final URL SUBSCRIBEUSERINFO_WSDL_LOCATION;
    private static final WebServiceException SUBSCRIBEUSERINFO_EXCEPTION;
    private static final QName SUBSCRIBEUSERINFO_QNAME = new QName("http://chinacoalsx.com", "SubscribeUserInfo");


    static {
        URL url = null;
        WebServiceException serviceException = null;
        try {
            url = new URL("http://10.3.4.207:7011/Liems/webservice/SubscribUserInfo?wsdl");
        } catch (MalformedURLException ex) {
            serviceException = new WebServiceException(ex);
        }
        SUBSCRIBEUSERINFO_WSDL_LOCATION = url;
        SUBSCRIBEUSERINFO_EXCEPTION = serviceException;
    }

    public SubscribUserInfo() {
        super(getSubscribeuserinfoWsdlLocation(), SUBSCRIBEUSERINFO_QNAME);
    }

    public SubscribUserInfo(WebServiceFeature... features) {
        super(getSubscribeuserinfoWsdlLocation(), SUBSCRIBEUSERINFO_QNAME, features);
    }

    public SubscribUserInfo(URL serviceLocation) {
        super(serviceLocation, SUBSCRIBEUSERINFO_QNAME);
    }

    public SubscribUserInfo(URL serviceLocation, WebServiceFeature... features) {
        super(serviceLocation, SUBSCRIBEUSERINFO_QNAME, features);
    }


    protected SubscribUserInfo(URL url, QName serviceName) {
        super(url, serviceName);
    }

    protected SubscribUserInfo(URL url, QName serviceName, WebServiceFeature... features) {
        super(url, serviceName, features);
    }

    public SubscribeUserInfoPortType getSubscribeUserInfoHttpSoap11Endpoint() {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpSoap11Endpoint"), SubscribeUserInfoPortType.class);
    }

    @WebEndpoint(name = "SubscribeUserInfoHttpSoap11Endpoint")
    public SubscribeUserInfoPortType getSubscribeUserInfoHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpSoap11Endpoint"), SubscribeUserInfoPortType.class, features);
    }

    @WebEndpoint(name = "SubscribeUserInfoHttpSoap12Endpoint")
    public SubscribeUserInfoPortType getSubscribeUserInfoHttpSoap12Endpoint() {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpSoap12Endpoint"), SubscribeUserInfoPortType.class);
    }

    @WebEndpoint(name = "SubscribeUserInfoHttpSoap12Endpoint")
    public SubscribeUserInfoPortType getSubscribeUserInfoHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpSoap12Endpoint"), SubscribeUserInfoPortType.class, features);
    }

    @WebEndpoint(name = "SubscribeUserInfoHttpEndpoint")
    public SubscribeUserInfoPortType getSubscribeUserInfoHttpEndpoint() {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpEndpoint"), SubscribeUserInfoPortType.class);
    }

    @WebEndpoint(name = "SubscribeUserInfoHttpEndpoint")
    public SubscribeUserInfoPortType getSubscribeUserInfoHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://chinacoalsx.com", "SubscribeUserInfoHttpEndpoint"), SubscribeUserInfoPortType.class, features);
    }
    protected static URL getSubscribeuserinfoWsdlLocation() {
        if (SUBSCRIBEUSERINFO_EXCEPTION != null)
            throw SUBSCRIBEUSERINFO_EXCEPTION;
        return SUBSCRIBEUSERINFO_WSDL_LOCATION;
    }
}
