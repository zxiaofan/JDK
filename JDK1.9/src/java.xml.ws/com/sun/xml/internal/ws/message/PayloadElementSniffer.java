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

package com.sun.xml.internal.ws.message;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;
import com.sun.xml.internal.ws.encoding.soap.SOAPConstants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.QName;

/**
 * Parses the SOAP message in order to get {@link QName} of a payload element.
 * It parses message until it
 *
 * @author Miroslav Kos (miroslav.kos at oracle.com)
 */
public class PayloadElementSniffer extends DefaultHandler {

    // flag if the last element was SOAP body
    private boolean bodyStarted;

    // payloadQName used as a return value
    private QName payloadQName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (bodyStarted) {
            payloadQName = new QName(uri, localName);
            // we have what we wanted - let's skip rest of parsing ...
            throw new SAXException("Payload element found, interrupting the parsing process.");
        }

        // check for both SOAP 1.1/1.2
        if (equalsQName(uri, localName, SOAPConstants.QNAME_SOAP_BODY) ||
                equalsQName(uri, localName, SOAP12Constants.QNAME_SOAP_BODY)) {
            bodyStarted = true;
        }

    }

    private boolean equalsQName(String uri, String localName, QName qname) {
        return qname.getLocalPart().equals(localName) &&
                qname.getNamespaceURI().equals(uri);
    }

    public QName getPayloadQName() {
        return payloadQName;
    }
}
