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

package com.sun.xml.internal.ws.server;

import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.server.WSEndpoint;
import com.sun.xml.internal.ws.api.server.WSWebServiceContext;
import com.sun.xml.internal.ws.server.provider.AsyncProviderInvokerTube;
import com.sun.istack.internal.NotNull;
import org.w3c.dom.Element;

import javax.xml.ws.EndpointReference;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import java.security.Principal;

/**
 * Partial {@link WSWebServiceContext} implementation. This implementation depends on
 * {@link Packet} and concrete implementations provide it via
 * {@link #getRequestPacket()}.
 *
 * @see InvokerTube,
 * @see AsyncProviderInvokerTube
 *
 * @author Jitendra Kotamraju
 */
public abstract class AbstractWebServiceContext implements WSWebServiceContext {

    private final WSEndpoint endpoint;

    public AbstractWebServiceContext(@NotNull WSEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    public MessageContext getMessageContext() {
        Packet packet = getRequestPacket();
        if (packet == null) {
            throw new IllegalStateException("getMessageContext() can only be called while servicing a request");
        }
        return new EndpointMessageContextImpl(packet);
    }

    public Principal getUserPrincipal() {
        Packet packet = getRequestPacket();
        if (packet == null) {
            throw new IllegalStateException("getUserPrincipal() can only be called while servicing a request");
        }
        return packet.webServiceContextDelegate.getUserPrincipal(packet);
    }

    public boolean isUserInRole(String role) {
        Packet packet = getRequestPacket();
        if (packet == null) {
            throw new IllegalStateException("isUserInRole() can only be called while servicing a request");
        }
        return packet.webServiceContextDelegate.isUserInRole(packet,role);
    }

    public EndpointReference getEndpointReference(Element...referenceParameters) {
        return getEndpointReference(W3CEndpointReference.class, referenceParameters);
    }

    public <T extends EndpointReference> T getEndpointReference(Class<T> clazz, Element...referenceParameters) {
        Packet packet = getRequestPacket();
        if (packet == null) {
            throw new IllegalStateException("getEndpointReference() can only be called while servicing a request");
        }
        String address = packet.webServiceContextDelegate.getEPRAddress(packet, endpoint);
        String wsdlAddress = null;
        if(endpoint.getServiceDefinition() != null) {
            wsdlAddress = packet.webServiceContextDelegate.getWSDLAddress(packet,endpoint);
        }
        return clazz.cast(endpoint.getEndpointReference(clazz,address,wsdlAddress, referenceParameters));
    }

}
