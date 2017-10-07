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
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.impl.FaultElementImpl;
import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import com.sun.xml.internal.messaging.saaj.SOAPExceptionImpl;
import org.w3c.dom.Element;

public class FaultElement1_2Impl extends FaultElementImpl {

    public FaultElement1_2Impl(SOAPDocumentImpl ownerDoc, NameImpl qname) {
        super(ownerDoc, qname);
    }

    public FaultElement1_2Impl(SOAPDocumentImpl ownerDoc, QName qname) {
        super(ownerDoc, qname);
    }

    public FaultElement1_2Impl(SOAPDocumentImpl ownerDoc, String localName) {
        super(ownerDoc, NameImpl.createSOAP12Name(localName));
    }

    public FaultElement1_2Impl(SOAPDocumentImpl ownerDoc, Element domElement) {
        super(ownerDoc, domElement);
    }

    @Override
    protected boolean isStandardFaultElement() {
        String localName = elementQName.getLocalPart();
        if (localName.equalsIgnoreCase("code") ||
            localName.equalsIgnoreCase("reason") ||
            localName.equalsIgnoreCase("node") ||
            localName.equalsIgnoreCase("role")) {
            return true;
        }
        return false;
    }

    @Override
    public SOAPElement setElementQName(QName newName) throws SOAPException {
        if (!isStandardFaultElement()) {
            FaultElement1_2Impl copy =
                new FaultElement1_2Impl((SOAPDocumentImpl) getOwnerDocument(), newName);
            return replaceElementWithSOAPElement(this,copy);
        } else {
            return super.setElementQName(newName);
        }
    }

    @Override
    public void setEncodingStyle(String encodingStyle) throws SOAPException {
        log.severe("SAAJ0408.ver1_2.no.encodingStyle.in.fault.child");
        throw new SOAPExceptionImpl("encodingStyle attribute cannot appear on a Fault child element");
    }

    @Override
    public SOAPElement addAttribute(Name name, String value)
        throws SOAPException {
        if (name.getLocalName().equals("encodingStyle")
            && name.getURI().equals(NameImpl.SOAP12_NAMESPACE)) {
            setEncodingStyle(value);
        }
        return super.addAttribute(name, value);
    }

    @Override
    public SOAPElement addAttribute(QName name, String value)
        throws SOAPException {
        if (name.getLocalPart().equals("encodingStyle")
            && name.getNamespaceURI().equals(NameImpl.SOAP12_NAMESPACE)) {
            setEncodingStyle(value);
        }
        return super.addAttribute(name, value);
    }
}
