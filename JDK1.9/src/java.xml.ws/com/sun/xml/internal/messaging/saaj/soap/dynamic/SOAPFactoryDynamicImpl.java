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
package com.sun.xml.internal.messaging.saaj.soap.dynamic;

import javax.xml.soap.Detail;
import javax.xml.soap.SOAPException;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import com.sun.xml.internal.messaging.saaj.soap.SOAPFactoryImpl;

public class SOAPFactoryDynamicImpl extends SOAPFactoryImpl {
    @Override
    protected SOAPDocumentImpl createDocument() {
        return null;
    }

    @Override
    public Detail createDetail() throws SOAPException {
        throw new UnsupportedOperationException(
                "createDetail() not supported for Dynamic Protocol");
    }

}
