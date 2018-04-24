package com.chinacoalsx;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "SubscribeUserInfoPortType", targetNamespace = "http://chinacoalsx.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SubscribeUserInfoPortType {

    @WebMethod(operationName = "RemoveUser", action = "urn:RemoveUser")
    public void removeUser(
            @WebParam(name = "RemoveUser", targetNamespace = "http://chinacoalsx.com", partName = "parameters")
                    RemoveUser parameters);

    @WebMethod(operationName = "UpdateUser", action = "urn:UpdateUser")
    public void updateUser(
            @WebParam(name = "UpdateUser", targetNamespace = "http://chinacoalsx.com", partName = "parameters")
                    UpdateUser parameters);

    @WebMethod(operationName = "EnableUser", action = "urn:EnableUser")
    public void enableUser(
            @WebParam(name = "EnableUser", targetNamespace = "http://chinacoalsx.com", partName = "parameters")
                    EnableUser parameters);

    @WebMethod(operationName = "AddUser", action = "urn:AddUser")
    public void addUser(
            @WebParam(name = "AddUser", targetNamespace = "http://chinacoalsx.com", partName = "parameters")
                    AddUser parameters);
}
