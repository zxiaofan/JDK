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

import javax.xml.soap.Detail;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;

import javax.xml.namespace.QName;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.SOAPFactoryImpl;

public class SOAPFactory1_2Impl extends SOAPFactoryImpl {
    @Override
    protected SOAPDocumentImpl createDocument() {
        return (new SOAPPart1_2Impl()).getDocument();
    }

    @Override
    public Detail createDetail() throws SOAPException {
        return new Detail1_2Impl(createDocument());
    }

    @Override
    public SOAPFault createFault(String reasonText, QName faultCode)
        throws SOAPException {
         if (faultCode == null) {
            throw new IllegalArgumentException("faultCode argument for createFault was passed NULL");
        }
        if (reasonText == null) {
            throw new IllegalArgumentException("reasonText argument for createFault was passed NULL");
        }
        Fault1_2Impl fault = new Fault1_2Impl(createDocument());
        fault.setFaultCode(faultCode);
        fault.setFaultString(reasonText);
        return fault;
    }

    @Override
    public SOAPFault createFault() throws SOAPException {
        Fault1_2Impl fault = new Fault1_2Impl(createDocument());
        fault.setFaultCode(fault.getDefaultFaultCode());
        fault.setFaultString("Fault string, and possibly fault code, not set");
        return fault;
    }

}
