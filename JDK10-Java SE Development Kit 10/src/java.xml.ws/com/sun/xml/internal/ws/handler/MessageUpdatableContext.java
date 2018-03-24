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

import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.Packet;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.xml.ws.handler.MessageContext;

/**
 * The class represents a MessageContext(Properties) and also allows the Message to be modified.
 * This is extended by SOAPMessageContextImpl and LogicalMessageContextImpl.
 *
 * @author WS Development Team
 */
public abstract class MessageUpdatableContext implements MessageContext {
    final Packet packet;
    private MessageContextImpl ctxt;
    /** Creates a new instance of MessageUpdatableContext */
    public MessageUpdatableContext(Packet packet) {
        ctxt = new MessageContextImpl(packet);
        this.packet = packet;
    }

    /**
     * Updates Message in the packet with user modifications
     */
    abstract void updateMessage();

    /**
     * Updates Message in the packet with user modifications
     * returns the new packet's message
     */
    Message getPacketMessage(){
        updateMessage();
        return packet.getMessage();
    }

    /**
     * Sets Message in the packet
     * Any user modifications done on previous Message are lost.
     */
    abstract void setPacketMessage(Message newMessage);

    /**
     * Updates the complete packet with user modfications to the message and
     * properties cahnges in MessageContext
     */
    public final void updatePacket() {
        updateMessage();
    }

    MessageContextImpl getMessageContext() {
        return ctxt;
    }

    public void setScope(String name, Scope scope) {
        ctxt.setScope(name, scope);
    }

    public Scope getScope(String name) {
        return ctxt.getScope(name);
    }

    /* java.util.Map methods below here */

    public void clear() {
        ctxt.clear();
    }

    public boolean containsKey(Object obj) {
        return ctxt.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return ctxt.containsValue(obj);
    }

    public Set<Entry<String, Object>> entrySet() {
        return ctxt.entrySet();
    }

    public Object get(Object obj) {
        return ctxt.get(obj);
    }

    public boolean isEmpty() {
        return ctxt.isEmpty();
    }

    public Set<String> keySet() {
        return ctxt.keySet();
    }

    public Object put(String str, Object obj) {
        return ctxt.put(str, obj);
    }

    public void putAll(Map<? extends String, ? extends Object> map) {
        ctxt.putAll(map);
    }

    public Object remove(Object obj) {
        return ctxt.remove(obj);
    }

    public int size() {
        return ctxt.size();
    }

    public Collection<Object> values() {
        return ctxt.values();
    }

}
