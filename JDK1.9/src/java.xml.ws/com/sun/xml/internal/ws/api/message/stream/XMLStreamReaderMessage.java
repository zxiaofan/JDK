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
import javax.xml.stream.XMLStreamReader;

/**
 * Low level representation of an XML or SOAP message as an {@link XMLStreamReader}.
 *
 */
public class XMLStreamReaderMessage extends StreamBasedMessage {
    /**
     * The message represented as an {@link XMLStreamReader}.
     */
    public final XMLStreamReader msg;

    /**
     * Create a new message.
     *
     * @param properties
     *      the properties of the message.
     *
     * @param msg
     *      always a non-null unconsumed {@link XMLStreamReader} that
     *      represents a request.
     */
    public XMLStreamReaderMessage(Packet properties, XMLStreamReader msg) {
        super(properties);
        this.msg = msg;
    }

    /**
     * Create a new message.
     *
     * @param properties
     *      the properties of the message.
     *
     * @param attachments
     *      the attachments of the message.
     *
     * @param msg
     *      always a non-null unconsumed {@link XMLStreamReader} that
     *      represents a request.
     */
    public XMLStreamReaderMessage(Packet properties, AttachmentSet attachments, XMLStreamReader msg) {
        super(properties, attachments);
        this.msg = msg;
    }
}
