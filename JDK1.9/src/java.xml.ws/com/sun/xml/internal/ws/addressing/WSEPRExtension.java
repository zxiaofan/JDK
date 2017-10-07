/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.addressing;

import com.sun.xml.internal.stream.buffer.XMLStreamBuffer;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

/**
 * Implementation backed by XMLStreamBuffer
 *
 * @author Rama.Pulavarthi@sun.com
 */
public class WSEPRExtension extends WSEndpointReference.EPRExtension {
    XMLStreamBuffer xsb;
    final QName qname;

    public WSEPRExtension(XMLStreamBuffer xsb, QName qname) {
        this.xsb = xsb;
        this.qname = qname;
    }


    public XMLStreamReader readAsXMLStreamReader() throws XMLStreamException {
        return xsb.readAsXMLStreamReader();
    }

    public QName getQName() {
        return qname;
    }

}
