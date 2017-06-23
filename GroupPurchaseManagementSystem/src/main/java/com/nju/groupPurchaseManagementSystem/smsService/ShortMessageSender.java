
package com.nju.groupPurchaseManagementSystem.smsService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ShortMessageSender", targetNamespace = "http://assignment3/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ShortMessageSender {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendMessage", targetNamespace = "http://assignment3/", className = "com.nju.groupPurchaseManagementSystem.smsService.SendMessage")
    @ResponseWrapper(localName = "sendMessageResponse", targetNamespace = "http://assignment3/", className = "com.nju.groupPurchaseManagementSystem.smsService.SendMessageResponse")
    public boolean sendMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
