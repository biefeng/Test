
package com.chinacoalsx.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chinacoalsx.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UserInfoMobile_QNAME = new QName("http://chinacoalsx.com/xsd", "mobile");
    private final static QName _UserInfoOrgUnitCode_QNAME = new QName("http://chinacoalsx.com/xsd", "orgUnitCode");
    private final static QName _UserInfoUserCode_QNAME = new QName("http://chinacoalsx.com/xsd", "userCode");
    private final static QName _UserInfoEmail_QNAME = new QName("http://chinacoalsx.com/xsd", "email");
    private final static QName _UserInfoAddress_QNAME = new QName("http://chinacoalsx.com/xsd", "address");
    private final static QName _UserInfoTel_QNAME = new QName("http://chinacoalsx.com/xsd", "tel");
    private final static QName _UserInfoName_QNAME = new QName("http://chinacoalsx.com/xsd", "name");
    private final static QName _UserInfoJobDesc_QNAME = new QName("http://chinacoalsx.com/xsd", "jobDesc");
    private final static QName _UserInfoBirthday_QNAME = new QName("http://chinacoalsx.com/xsd", "birthday");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chinacoalsx.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link  UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new  UserInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "mobile", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoMobile(String value) {
        return new JAXBElement<String>(_UserInfoMobile_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "orgUnitCode", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoOrgUnitCode(String value) {
        return new JAXBElement<String>(_UserInfoOrgUnitCode_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "userCode", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoUserCode(String value) {
        return new JAXBElement<String>(_UserInfoUserCode_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "email", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoEmail(String value) {
        return new JAXBElement<String>(_UserInfoEmail_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "address", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoAddress(String value) {
        return new JAXBElement<String>(_UserInfoAddress_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "tel", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoTel(String value) {
        return new JAXBElement<String>(_UserInfoTel_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "name", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoName(String value) {
        return new JAXBElement<String>(_UserInfoName_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "jobDesc", scope =  UserInfo.class)
    public JAXBElement<String> createUserInfoJobDesc(String value) {
        return new JAXBElement<String>(_UserInfoJobDesc_QNAME, String.class,  UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com/xsd", name = "birthday", scope =  UserInfo.class)
    public JAXBElement<XMLGregorianCalendar> createUserInfoBirthday(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UserInfoBirthday_QNAME, XMLGregorianCalendar.class,  UserInfo.class, value);
    }

}
