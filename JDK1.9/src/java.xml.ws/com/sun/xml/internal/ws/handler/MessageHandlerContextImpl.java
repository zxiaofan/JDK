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

import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.handler.MessageHandlerContext;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;

import java.util.Set;

/**
 * @author Rama Pulavarthi
 */
public class MessageHandlerContextImpl extends MessageUpdatableContext implements MessageHandlerContext {
    private @Nullable SEIModel seiModel;
    private Set<String> roles;
    private WSBinding binding;
    private @Nullable WSDLPort wsdlModel;

    public MessageHandlerContextImpl(@Nullable SEIModel seiModel, WSBinding binding, @Nullable WSDLPort wsdlModel, Packet packet, Set<String> roles) {
        super(packet);
        this.seiModel = seiModel;
        this.binding = binding;
        this.wsdlModel = wsdlModel;
        this.roles = roles;
    }
    public Message getMessage() {
        return packet.getMessage();
    }

    public void setMessage(Message message) {
        packet.setMessage(message);
    }

    public Set<String> getRoles() {
        return roles;
    }

    public WSBinding getWSBinding() {
        return binding;
    }

    public @Nullable SEIModel getSEIModel() {
        return seiModel;
    }

    public @Nullable WSDLPort getPort() {
        return wsdlModel;
    }

    void updateMessage() {
       // Do Nothing
    }

    void setPacketMessage(Message newMessage) {
        setMessage(newMessage);
    }
}
