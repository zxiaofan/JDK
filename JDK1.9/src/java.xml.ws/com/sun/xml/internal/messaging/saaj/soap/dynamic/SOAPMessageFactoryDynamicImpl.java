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


import javax.xml.soap.*;

import com.sun.xml.internal.messaging.saaj.soap.MessageFactoryImpl;

public class SOAPMessageFactoryDynamicImpl extends MessageFactoryImpl {
    @Override
    public SOAPMessage createMessage() throws SOAPException {
        throw new UnsupportedOperationException(
                "createMessage() not supported for Dynamic Protocol");
    }
}
