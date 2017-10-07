/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.soap;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public interface LazyEnvelope extends Envelope {
    public XMLStreamReader getPayloadReader() throws SOAPException;
    public boolean isLazy();
    public void writeTo(XMLStreamWriter writer) throws XMLStreamException, SOAPException;

    /**
     * Retrieve payload qname without materializing its contents
     * @return QName
     * @throws SOAPException in case of an error
     */
    public QName getPayloadQName() throws SOAPException;

    /**
     * Retrieve payload attribute value without materializing its contents
     * @param localName local name
     * @return payload attribute value
     * @throws SOAPException in case of an error
     */
    public String getPayloadAttributeValue(String localName) throws SOAPException;

    /**
     * Retrieve payload attribute value without materializing its contents
     * @param qName QName
     * @return payload attribute value
     * @throws SOAPException in case of an error
     */
    public String getPayloadAttributeValue(QName qName) throws SOAPException;
}
