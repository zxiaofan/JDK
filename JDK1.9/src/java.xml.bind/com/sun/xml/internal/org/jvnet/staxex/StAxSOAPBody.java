/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.staxex;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * A StAxSOAPBody is a SOAPBody that allows to be loaded from a StAX style payload.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface StAxSOAPBody {

    /**
     * The StAxSOAPBody represents the StAX source of SOAPBody payload.
     */
    public static interface Payload {

        /**
         * Retrieve payload qname without materializing its contents
         * @return
         */
       public QName getPayloadQName();

       public XMLStreamReader readPayload() throws XMLStreamException;

       public void writePayloadTo(XMLStreamWriter writer)throws XMLStreamException;

       /**
        * Retrieve payload attribute value without materializing its contents
        * @param localName
        * @return
        * @throws XMLStreamException
        */
       public String getPayloadAttributeValue(String localName) throws XMLStreamException;

       /**
        * Retrieve payload attribute value without materializing its contents
        * @param qName
        * @return
        * @throws XMLStreamException
        */
       public String getPayloadAttributeValue(QName qName) throws XMLStreamException;

       public void materialize() throws XMLStreamException;
    }

    public void setPayload(Payload src) throws XMLStreamException;

    public Payload getPayload()throws XMLStreamException;

    public boolean hasStaxPayload();
 }
