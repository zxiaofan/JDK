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

package com.oracle.webservices.internal.impl.encoding;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLStreamReader;

import com.oracle.webservices.internal.impl.internalspi.encoding.StreamDecoder;

import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.message.AttachmentSet;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import com.sun.xml.internal.ws.encoding.StreamSOAPCodec;
import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;

public class StreamDecoderImpl implements StreamDecoder {

    @Override
    public Message decode(InputStream in, String charset,
            AttachmentSet att, SOAPVersion soapVersion) throws IOException {
        XMLStreamReader reader = XMLStreamReaderFactory.create(null, in, charset, true);
        reader =  new TidyXMLStreamReader(reader, in);
        return StreamSOAPCodec.decode(soapVersion, reader, att);
    }

}
