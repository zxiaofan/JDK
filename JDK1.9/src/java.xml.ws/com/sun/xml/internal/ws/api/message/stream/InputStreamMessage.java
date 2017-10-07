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
import java.io.InputStream;

/**
 * Low level representation of an XML or SOAP message as an {@link InputStream}.
 *
 */
public class InputStreamMessage extends StreamBasedMessage {
    /**
     * The MIME content-type of the encoding.
     */
    public final String contentType;

    /**
     * The message represented as an {@link InputStream}.
     */
    public final InputStream msg;

    /**
     * Create a new message.
     *
     * @param properties
     *      the properties of the message.
     *
     * @param contentType
     *      the MIME content-type of the encoding.
     *
     * @param msg
     *      always a non-null unconsumed {@link InputStream} that
     *      represents a request.
     */
    public InputStreamMessage(Packet properties, String contentType, InputStream msg) {
        super(properties);

        this.contentType = contentType;
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
     * @param contentType
     *      the MIME content-type of the encoding.
     *
     * @param msg
     *      always a non-null unconsumed {@link InputStream} that
     *      represents a request.
     */
    public InputStreamMessage(Packet properties, AttachmentSet attachments,
            String contentType, InputStream msg) {
        super(properties, attachments);

        this.contentType = contentType;
        this.msg = msg;
    }
}
