
package net.luculent.liems.webservice.business.usrInfo;

import net.luculent.liems.webservice.business.usrInfo.xsd.UserInfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user"
})
@XmlRootElement(name = "UpdateUser")
public class UpdateUser {

    @XmlElementRef(name = "user", namespace = "http://chinacoalsx.com", type = JAXBElement.class, required = false)
    protected JAXBElement<UserInfo> user;

    public JAXBElement<UserInfo> getUser() {
        return user;
    }

    public void setUser(JAXBElement<UserInfo> value) {
        this.user = value;
    }

}
