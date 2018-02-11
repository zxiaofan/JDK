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

package com.oracle.webservices.internal.impl.internalspi.encoding;

import java.io.IOException;
import java.io.InputStream;

import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.message.AttachmentSet;
import com.sun.xml.internal.ws.api.message.Message;

/**
 * Decodes SOAPEnvelope read from an <code>InputStream</code> into a <code>Message</code> instance.
 * This SPI allows for other implementations instead of the default, which is based on XMLStreamReader.
 *
 * @since 2.2.9
 */
public interface StreamDecoder {
    Message decode(
            InputStream in, String charset,
            AttachmentSet att, SOAPVersion soapVersion) throws IOException;
}
