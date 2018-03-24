/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.message;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.ws.soap.MTOMFeature;

import com.oracle.webservices.internal.api.message.ContentType;

/**
 * A Message implementation may implement this interface as an alternative way to write the
 * message into the OutputStream.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface MessageWritable {

    /**
     * Gets the Content-type of this message.
     *
     * @return The MIME content type of this message
     */
    ContentType getContentType();

    /**
     * Writes the XML infoset portion of this MessageContext
     * (from &lt;soap:Envelope> to &lt;/soap:Envelope>).
     *
     * @param out
     *      Must not be null. The caller is responsible for closing the stream,
     *      not the callee.
     *
     * @return
     *      The MIME content type of this message (such as "application/xml").
     *      This information is often ncessary by transport.
     *
     * @throws IOException
     *      if a {@link OutputStream} throws {@link IOException}.
     */
    ContentType writeTo( OutputStream out ) throws IOException;

    /**
     * Passes configuration information to this message to ensure the proper
     * wire format is created. (from &lt;soap:Envelope> to &lt;/soap:Envelope>).
     *
     * @param mtomFeature
     *            The standard <code>WebServicesFeature</code> for specifying
     *            the MTOM enablement and possibly threshold for the endpoint.
     *            This value may be <code>null</code>.
     */
    void setMTOMConfiguration(final MTOMFeature mtomFeature);
}
