
package net.luculent.liems.webservice.business.usrInfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.luculent.liems.webservice.business.usrInfo.xsd.UserInfo;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chinacoalsx package. 
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

    private final static QName _EnableUserUserCode_QNAME = new QName("http://chinacoalsx.com", "userCode");
    private final static QName _UpdateUserUser_QNAME = new QName("http://chinacoalsx.com", "user");
    private final static QName _RemoveUserUsercode_QNAME = new QName("http://chinacoalsx.com", "usercode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chinacoalsx
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link RemoveUser }
     * 
     */
    public RemoveUser createRemoveUser() {
        return new RemoveUser();
    }

    /**
     * Create an instance of {@link EnableUser }
     * 
     */
    public EnableUser createEnableUser() {
        return new EnableUser();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com", name = "userCode", scope = EnableUser.class)
    public JAXBElement<String> createEnableUserUserCode(String value) {
        return new JAXBElement<String>(_EnableUserUserCode_QNAME, String.class, EnableUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com", name = "user", scope = UpdateUser.class)
    public JAXBElement<UserInfo> createUpdateUserUser(UserInfo value) {
        return new JAXBElement<UserInfo>(_UpdateUserUser_QNAME, UserInfo.class, UpdateUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com", name = "usercode", scope = RemoveUser.class)
    public JAXBElement<String> createRemoveUserUsercode(String value) {
        return new JAXBElement<String>(_RemoveUserUsercode_QNAME, String.class, RemoveUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chinacoalsx.com", name = "user", scope = AddUser.class)
    public JAXBElement<UserInfo> createAddUserUser(UserInfo value) {
        return new JAXBElement<UserInfo>(_UpdateUserUser_QNAME, UserInfo.class, AddUser.class, value);
    }

}
