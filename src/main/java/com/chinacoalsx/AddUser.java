
package com.chinacoalsx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.chinacoalsx.xsd.UserInfo;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "AddUser")
public class AddUser {

    @XmlElementRef(name = "user", namespace = "http://chinacoalsx.com", type = JAXBElement.class, required = false)
    protected JAXBElement<UserInfo> user;

    public JAXBElement<UserInfo> getUser() {
        return user;
    }

    public void setUser(JAXBElement<UserInfo> value) {
        this.user = value;
    }

}
