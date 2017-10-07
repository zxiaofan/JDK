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

package com.sun.xml.internal.ws.message.stream;

import com.sun.xml.internal.stream.buffer.XMLStreamBuffer;
import com.sun.xml.internal.ws.message.Util;
import com.sun.istack.internal.FinalArrayList;

import javax.xml.soap.SOAPConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

/**
 * {@link StreamHeader} for SOAP 1.2.
 *
 * @author Paul.Sandoz@Sun.Com
 */
@SuppressWarnings({"StringEquality"})
public class StreamHeader12 extends StreamHeader {
    protected static final String SOAP_1_2_MUST_UNDERSTAND = "mustUnderstand";

    protected static final String SOAP_1_2_ROLE = "role";

    protected static final String SOAP_1_2_RELAY = "relay";

    public StreamHeader12(XMLStreamReader reader, XMLStreamBuffer mark) {
        super(reader, mark);
    }

    public StreamHeader12(XMLStreamReader reader) throws XMLStreamException {
        super(reader);
    }

    protected final FinalArrayList<Attribute> processHeaderAttributes(XMLStreamReader reader) {
        FinalArrayList<Attribute> atts = null;

        _role = SOAPConstants.URI_SOAP_1_2_ROLE_ULTIMATE_RECEIVER;

        for (int i = 0; i < reader.getAttributeCount(); i++) {
            final String localName = reader.getAttributeLocalName(i);
            final String namespaceURI = reader.getAttributeNamespace(i);
            final String value = reader.getAttributeValue(i);

            if (SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE.equals(namespaceURI)) {
                if (SOAP_1_2_MUST_UNDERSTAND.equals(localName)) {
                    _isMustUnderstand = Util.parseBool(value);
                } else if (SOAP_1_2_ROLE.equals(localName)) {
                    if (value != null && value.length() > 0) {
                        _role = value;
                    }
                } else if (SOAP_1_2_RELAY.equals(localName)) {
                    _isRelay = Util.parseBool(value);
                }
            }

            if(atts==null) {
                atts = new FinalArrayList<Attribute>();
            }
            atts.add(new Attribute(namespaceURI,localName,value));
        }

        return atts;
    }

}
