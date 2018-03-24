/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
*
* @author SAAJ RI Development Team
*/
package com.sun.xml.internal.messaging.saaj.soap.ver1_1;

import java.util.Locale;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocument;
import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.impl.BodyImpl;
import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import org.w3c.dom.Element;

public class Body1_1Impl extends BodyImpl {
    public Body1_1Impl(SOAPDocumentImpl ownerDocument, String prefix) {
            super(ownerDocument, NameImpl.createBody1_1Name(prefix));
    }

    public Body1_1Impl(SOAPDocumentImpl ownerDoc, Element domElement) {
        super(ownerDoc, domElement);
    }

    public SOAPFault addSOAP12Fault(QName faultCode, String faultReason, Locale locale) {
        // log message here
        throw new UnsupportedOperationException("Not supported in SOAP 1.1");
    }

    @Override
    protected NameImpl getFaultName(String name) {
        // Ignore name
        return NameImpl.createFault1_1Name(null);
    }

    @Override
    protected SOAPBodyElement createBodyElement(Name name) {
        return new BodyElement1_1Impl(
            ((SOAPDocument) getOwnerDocument()).getDocument(),
            name);
    }

    @Override
    protected SOAPBodyElement createBodyElement(QName name) {
        return new BodyElement1_1Impl(
            ((SOAPDocument) getOwnerDocument()).getDocument(),
            name);
    }

    @Override
    protected QName getDefaultFaultCode() {
        return new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE, "Server");
    }

    @Override
    protected boolean isFault(SOAPElement child) {
        // SOAP 1.1 faults always use the default name
        return child.getElementName().equals(getFaultName(null));
    }

    @Override
    protected SOAPFault createFaultElement() {
        return new Fault1_1Impl(
            ((SOAPDocument) getOwnerDocument()).getDocument(), getPrefix());
    }

}
