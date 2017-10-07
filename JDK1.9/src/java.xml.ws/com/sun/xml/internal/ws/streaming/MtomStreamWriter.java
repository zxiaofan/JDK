/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.streaming;

import com.sun.xml.internal.ws.message.jaxb.JAXBMessage;
import com.sun.xml.internal.ws.encoding.MtomCodec;

import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.stream.XMLStreamWriter;

/**
 * A {@link XMLStreamWriter} that used for MTOM encoding may provide its own
 * {@link AttachmentMarshaller}. The marshaller could do processing based on
 * MTOM threshold, and make decisions about inlining the attachment data or not.
 *
 *
 * @author Jitendra Kotamraju
 * @see JAXBMessage
 * @see MtomCodec
 *
 * @deprecated use com.sun.xml.internal.org.jvnet.staxex.util.MtomStreamWriter
 */
public interface MtomStreamWriter {
    AttachmentMarshaller getAttachmentMarshaller();
}
