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

package com.sun.xml.internal.ws.api.message.stream;

import com.sun.xml.internal.ws.api.message.AttachmentSet;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.message.AttachmentSetImpl;

/**
 * Base representation an XML or SOAP message as stream.
 *
 */
abstract class StreamBasedMessage {
    /**
     * The properties of the message.
     */
    public final Packet properties;

    /**
     * The attachments of this message
     * (attachments live outside a message.)
     */
    public final AttachmentSet attachments;

    /**
     * Create a new message.
     *
     * @param properties
     *      the properties of the message.
     *
     */
    protected StreamBasedMessage(Packet properties) {
        this.properties = properties;
        this.attachments = new AttachmentSetImpl();
    }

    /**
     * Create a new message.
     *
     * @param properties
     *      the properties of the message.
     *
     * @param attachments
     *      the attachments of the message.
     */
    protected StreamBasedMessage(Packet properties, AttachmentSet attachments) {
        this.properties = properties;
        this.attachments = attachments;
    }
}
