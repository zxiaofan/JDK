/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public interface StreamingSOAP {
    public XMLStreamReader readEnvelope();
    public QName getPayloadQName();
    public XMLStreamReader readToBodyStarTag() throws XMLStreamException;
    public XMLStreamReader readPayload() throws XMLStreamException;
    public void writeToBodyStart(XMLStreamWriter w) throws XMLStreamException;
    public void writePayloadTo(XMLStreamWriter writer)throws XMLStreamException;
    public boolean isPayloadStreamReader();
}
