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

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.AttachmentSet;

import javax.xml.stream.XMLStreamReader;

/**
 * Reads events from {@link XMLStreamReader} and constructs a
 * {@link Message} for SOAP envelope. {@link Codecs} allows a
 * way to construct a whole codec that can handle MTOM, MIME
 * encoded packages using this codec.
 *
 *
 * @see Codecs
 * @author Jitendra Kotamraju
 */
public interface StreamSOAPCodec extends Codec {
    /**
     * Reads events from {@link XMLStreamReader} and constructs a
     * {@link Message} for SOAP envelope.
     *
     * @param reader that represents SOAP envelope infoset
     * @return a {@link Message} for SOAP envelope
     */
    public @NotNull Message decode(@NotNull XMLStreamReader reader);

    /**
     * Reads events from {@link XMLStreamReader} and constructs a
     * {@link Message} for SOAP envelope.
     *
     * @param reader that represents SOAP envelope infoset
     * @param att attachments for the message
     * @return a {@link Message} for SOAP envelope
     */
    public @NotNull Message decode(@NotNull XMLStreamReader reader, @NotNull AttachmentSet att);
}
