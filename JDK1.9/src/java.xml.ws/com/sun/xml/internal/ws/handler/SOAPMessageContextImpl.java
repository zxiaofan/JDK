/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.xml.internal.ws.handler;
import com.sun.xml.internal.ws.api.message.Header;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.SOAPVersion;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link SOAPMessageContext}. This class is used at runtime
 * to pass to the handlers for processing soap messages.
 *
 * @see MessageContextImpl
 *
 * @author WS Development Team
 */
public class SOAPMessageContextImpl extends MessageUpdatableContext implements SOAPMessageContext {

    private Set<String> roles;
    private SOAPMessage soapMsg = null;
    private WSBinding binding;

    public SOAPMessageContextImpl(WSBinding binding, Packet packet,Set<String> roles) {
        super(packet);
        this.binding = binding;
        this.roles = roles;
    }

    public SOAPMessage getMessage() {
        if(soapMsg == null) {
            try {
                Message m = packet.getMessage();
                soapMsg = m != null ? m.readAsSOAPMessage() : null;
            } catch (SOAPException e) {
                throw new WebServiceException(e);
            }
        }
        return soapMsg;
    }

    public void setMessage(SOAPMessage soapMsg) {
        try {
            this.soapMsg = soapMsg;
        } catch(Exception e) {
            throw new WebServiceException(e);
        }
    }

    void setPacketMessage(Message newMessage){
        if(newMessage != null) {
            packet.setMessage(newMessage);
            soapMsg = null;
        }
    }

    protected void updateMessage() {
        //Check if SOAPMessage has changed, if so construct new one,
        // Packet are handled through MessageContext
        if(soapMsg != null) {
            packet.setMessage(SAAJFactory.create(soapMsg));
            soapMsg = null;
        }
    }

    public Object[] getHeaders(QName header, JAXBContext jaxbContext, boolean allRoles) {
        SOAPVersion soapVersion = binding.getSOAPVersion();

        List<Object> beanList = new ArrayList<Object>();
        try {
            Iterator<Header> itr = packet.getMessage().getHeaders().getHeaders(header,false);
            if(allRoles) {
                while(itr.hasNext()) {
                    beanList.add(itr.next().readAsJAXB(jaxbContext.createUnmarshaller()));
                }
            } else {
                while(itr.hasNext()) {
                    Header soapHeader = itr.next();
                    //Check if the role is one of the roles on this Binding
                    String role = soapHeader.getRole(soapVersion);
                    if(getRoles().contains(role)) {
                        beanList.add(soapHeader.readAsJAXB(jaxbContext.createUnmarshaller()));
                    }
                }
            }
            return beanList.toArray();
        } catch(Exception e) {
            throw new WebServiceException(e);
        }
    }

    public Set<String> getRoles() {
        return roles;
    }
}
