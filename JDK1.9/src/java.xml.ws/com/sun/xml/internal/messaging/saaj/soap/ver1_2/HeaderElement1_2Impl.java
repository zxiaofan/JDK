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
package com.sun.xml.internal.messaging.saaj.soap.ver1_2;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderElementImpl;
import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import org.w3c.dom.Element;

public class HeaderElement1_2Impl extends HeaderElementImpl {

    public HeaderElement1_2Impl(SOAPDocumentImpl ownerDoc, Name qname) {
        super(ownerDoc, qname);
    }
    public HeaderElement1_2Impl(SOAPDocumentImpl ownerDoc, QName qname) {
        super(ownerDoc, qname);
    }

    public HeaderElement1_2Impl(SOAPDocumentImpl ownerDoc, Element domElement) {
        super(ownerDoc, domElement);
    }

    @Override
    public SOAPElement setElementQName(QName newName) throws SOAPException {
        HeaderElementImpl copy =
            new HeaderElement1_2Impl((SOAPDocumentImpl)getOwnerDocument(), newName);
        return replaceElementWithSOAPElement(this,copy);
    }

    @Override
    protected NameImpl getRoleAttributeName() {
        return NameImpl.create("role", null, NameImpl.SOAP12_NAMESPACE);
    }

    // Actor equivalent to Role in SOAP 1.2
    @Override
    protected NameImpl getActorAttributeName() {
        return getRoleAttributeName();
    }

    @Override
    protected NameImpl getMustunderstandAttributeName() {
        return NameImpl.create("mustUnderstand", null, NameImpl.SOAP12_NAMESPACE);
    }

    // mustUnderstand attribute has literal value "true" or "false"
    @Override
    protected String getMustunderstandLiteralValue(boolean mustUnderstand) {
        return (mustUnderstand == true ? "true" : "false");
    }

    @Override
    protected boolean getMustunderstandAttributeValue(String mu) {
        if (mu.equals("true") || mu.equals("1"))
            return true;
        return false;
    }

    @Override
   protected NameImpl getRelayAttributeName() {
        return NameImpl.create("relay", null, NameImpl.SOAP12_NAMESPACE);
    }

    //relay attribute has literal value "true" or "false"
    @Override
    protected String getRelayLiteralValue(boolean relay) {
        return (relay == true ? "true" : "false");
    }

    @Override
    protected boolean getRelayAttributeValue(String relay) {
        if (relay.equals("true") || relay.equals("1"))
            return true;
        return false;
    }

    @Override
    protected String getActorOrRole() {
        return getRole();
    }
}
