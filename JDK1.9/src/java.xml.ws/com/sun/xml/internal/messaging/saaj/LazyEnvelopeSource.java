/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * LazyEnvelopeSource provides the source to create lazy Envelope
 *
 * @author shih-chang.chen@oracle.com
 */
public interface LazyEnvelopeSource extends javax.xml.transform.Source {
    /**
     * Retrieve payload qname without materializing its contents
     * @return payload QName
     */
    public QName getPayloadQName();
    public XMLStreamReader readToBodyStarTag() throws XMLStreamException;
    public XMLStreamReader readPayload();
    public void writePayloadTo(XMLStreamWriter writer)throws XMLStreamException;
    public boolean isPayloadStreamReader();
}
