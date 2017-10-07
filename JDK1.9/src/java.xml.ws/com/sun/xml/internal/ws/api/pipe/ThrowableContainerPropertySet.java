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

package com.sun.xml.internal.ws.api.pipe;

import javax.xml.ws.Dispatch;

import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.Packet;
import com.oracle.webservices.internal.api.message.BasePropertySet;
import com.oracle.webservices.internal.api.message.PropertySet;

/**
 * When using {@link Dispatch}<{@link Packet}> and the invocation completes with a Throwable, it is
 * useful to be able to inspect the Packet in addition to the Throwable as the Packet contains
 * meta-data about the request and/or response.  However, the default behavior is that the caller
 * only receives the Throwable.
 *
 * This {@link PropertySet} is part of the implementation that allows a completing Fiber to return
 * the Throwable to the caller as part of the Packet.
 *
 */
public class ThrowableContainerPropertySet extends BasePropertySet {

    public ThrowableContainerPropertySet(final Throwable throwable) {
        this.throwable = throwable;
    }

    ////////////////////////////////////////////////////
    //
    // The original throwable
    //
    public static final String FIBER_COMPLETION_THROWABLE = "com.sun.xml.internal.ws.api.pipe.fiber-completion-throwable";
    private Throwable throwable;
    @Property(FIBER_COMPLETION_THROWABLE)
    public Throwable getThrowable() {
        return throwable;
    }
    public void setThrowable(final Throwable throwable) {
        this.throwable = throwable;
    }

    ////////////////////////////////////////////////////
    //
    // The FAULT message created in WsaServerTube or WSEndpointImpl
    //
    public static final String FAULT_MESSAGE = "com.sun.xml.internal.ws.api.pipe.fiber-completion-fault-message";
    private Message faultMessage;
    @Property(FAULT_MESSAGE)
    public Message getFaultMessage() {
        return faultMessage;
    }
    public void setFaultMessage(final Message faultMessage) {
        this.faultMessage = faultMessage;
    }

    ////////////////////////////////////////////////////
    //
    // The response Packet seen in WsaServerTube.processException or WSEndpointImpl
    //
    public static final String RESPONSE_PACKET = "com.sun.xml.internal.ws.api.pipe.fiber-completion-response-packet";
    private Packet responsePacket;
    @Property(RESPONSE_PACKET)
    public Packet getResponsePacket() {
        return responsePacket;
    }
    public void setResponsePacket(final Packet responsePacket) {
        this.responsePacket = responsePacket;
    }

    ////////////////////////////////////////////////////
    //
    // If the fault representation of the exception has already been created
    //
    public static final String IS_FAULT_CREATED = "com.sun.xml.internal.ws.api.pipe.fiber-completion-is-fault-created";
    private boolean isFaultCreated = false;
    @Property(IS_FAULT_CREATED)
    public boolean isFaultCreated() {
        return isFaultCreated;
    }
    public void setFaultCreated(final boolean isFaultCreated) {
        this.isFaultCreated = isFaultCreated;
    }

    //
    // boilerplate
    //

    @Override
    protected PropertyMap getPropertyMap() {
        return model;
    }

    private static final PropertyMap model;
    static {
        model = parse(ThrowableContainerPropertySet.class);
    }
}
