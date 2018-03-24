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

package com.sun.xml.internal.messaging.saaj.soap;

import com.sun.xml.internal.messaging.saaj.util.stax.SaajStaxWriter;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import com.sun.xml.internal.org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter;


/**
 * StaxBridge builds Envelope using a XMLStreamReaderToXMLStreamWriter
 *
 * @author shih-chang.chen@oracle.com
 */
public abstract class StaxBridge {
        protected SaajStaxWriter saajWriter;
        protected XMLStreamReaderToXMLStreamWriter readerToWriter;
        protected XMLStreamReaderToXMLStreamWriter.Breakpoint breakpoint;


        public StaxBridge(SOAPPartImpl soapPart) throws SOAPException {
                readerToWriter = new XMLStreamReaderToXMLStreamWriter();
                saajWriter = new SaajStaxWriter(soapPart.message, soapPart.getSOAPNamespace());
        }

        public void bridgeEnvelopeAndHeaders() throws XMLStreamException {
                readerToWriter.bridge(breakpoint);
        }

        public void bridgePayload() throws XMLStreamException {
                readerToWriter.bridge(breakpoint);
        }

    abstract public XMLStreamReader getPayloadReader();

    abstract public QName getPayloadQName();

    abstract public String getPayloadAttributeValue(String attName) ;

    abstract public String getPayloadAttributeValue(QName attName) ;
}
