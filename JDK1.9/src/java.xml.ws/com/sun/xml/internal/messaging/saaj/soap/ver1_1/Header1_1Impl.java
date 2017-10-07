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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocument;
import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;
import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import com.sun.xml.internal.messaging.saaj.util.LogDomainConstants;
import org.w3c.dom.Element;

public class Header1_1Impl extends HeaderImpl {

    protected static final Logger log =
        Logger.getLogger(LogDomainConstants.SOAP_VER1_1_DOMAIN,
                         "com.sun.xml.internal.messaging.saaj.soap.ver1_1.LocalStrings");

    public Header1_1Impl(SOAPDocumentImpl ownerDocument, String prefix) {
            super(ownerDocument, NameImpl.createHeader1_1Name(prefix));
    }

    public Header1_1Impl(SOAPDocumentImpl ownerDoc, Element domElement) {
        super(ownerDoc, domElement);
    }

    @Override
    protected NameImpl getNotUnderstoodName() {
        log.log(
            Level.SEVERE,
            "SAAJ0301.ver1_1.hdr.op.unsupported.in.SOAP1.1",
            new String[] { "getNotUnderstoodName" });
        throw new UnsupportedOperationException("Not supported by SOAP 1.1");
    }

    @Override
    protected NameImpl getUpgradeName() {
        return NameImpl.create(
            "Upgrade",
            getPrefix(),
            SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE);
    }

    @Override
    protected NameImpl getSupportedEnvelopeName() {
        return NameImpl.create(
            "SupportedEnvelope",
            getPrefix(),
            SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE);
    }

    @Override
    public SOAPHeaderElement addNotUnderstoodHeaderElement(QName name)
        throws SOAPException {
        log.log(
            Level.SEVERE,
            "SAAJ0301.ver1_1.hdr.op.unsupported.in.SOAP1.1",
            new String[] { "addNotUnderstoodHeaderElement" });
        throw new UnsupportedOperationException("Not supported by SOAP 1.1");
    }

    @Override
    protected SOAPHeaderElement createHeaderElement(Name name) {
        return new HeaderElement1_1Impl(
            ((SOAPDocument) getOwnerDocument()).getDocument(),
            name);
    }
    @Override
    protected SOAPHeaderElement createHeaderElement(QName name) {
        return new HeaderElement1_1Impl(
            ((SOAPDocument) getOwnerDocument()).getDocument(),
            name);
    }
}
