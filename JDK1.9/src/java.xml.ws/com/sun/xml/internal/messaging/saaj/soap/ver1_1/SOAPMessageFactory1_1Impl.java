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

import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.*;

import com.sun.xml.internal.messaging.saaj.SOAPExceptionImpl;
import com.sun.xml.internal.messaging.saaj.soap.MessageFactoryImpl;
import com.sun.xml.internal.messaging.saaj.soap.MessageImpl;

public class SOAPMessageFactory1_1Impl extends MessageFactoryImpl {

    @Override
    public SOAPMessage createMessage() throws SOAPException {
        return new Message1_1Impl();
    }

    @Override
    public SOAPMessage createMessage(boolean isFastInfoset,
        boolean acceptFastInfoset) throws SOAPException
    {
        return new Message1_1Impl(isFastInfoset, acceptFastInfoset);
    }

    @Override
    public SOAPMessage createMessage(MimeHeaders headers, InputStream in) throws IOException, SOAPExceptionImpl {

        if (headers == null) {
            headers = new MimeHeaders();
        }

        if (getContentType(headers) == null) {
            headers.setHeader("Content-Type", SOAPConstants.SOAP_1_1_CONTENT_TYPE);
        }

        MessageImpl msg = new Message1_1Impl(headers, in);
        msg.setLazyAttachments(lazyAttachments);
        return msg;
    }
}
