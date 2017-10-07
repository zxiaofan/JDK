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

import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.*;
import javax.xml.stream.XMLStreamReader;

import com.sun.xml.internal.messaging.saaj.SOAPExceptionImpl;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType;
import com.sun.xml.internal.messaging.saaj.soap.MessageImpl;

public class Message1_2Impl extends MessageImpl implements SOAPConstants{

    public Message1_2Impl() {
        super();
    }

    public Message1_2Impl(SOAPMessage msg) {
        super(msg);
    }

    public Message1_2Impl(boolean isFastInfoset, boolean acceptFastInfoset) {
        super(isFastInfoset, acceptFastInfoset);
    }

    // unused. can we delete this? - Kohsuke
    public Message1_2Impl(MimeHeaders headers, InputStream in)
        throws IOException, SOAPExceptionImpl {
        super(headers, in);
    }

    public Message1_2Impl(MimeHeaders headers, ContentType ct, int stat, InputStream in)
        throws SOAPExceptionImpl {
        super(headers,ct,stat,in);
    }

    public Message1_2Impl(MimeHeaders headers, ContentType ct, int stat, XMLStreamReader reader)
            throws SOAPExceptionImpl {
            super(headers,ct,stat,reader);
    }

    @Override
    public SOAPPart getSOAPPart()  {
        if (soapPartImpl == null)
            soapPartImpl = new SOAPPart1_2Impl(this);

        return soapPartImpl;
    }

    @Override
    protected boolean isCorrectSoapVersion(int contentTypeId) {
        return (contentTypeId & SOAP1_2_FLAG) != 0;
    }

    @Override
    protected String getExpectedContentType() {
        return isFastInfoset ? "application/soap+fastinfoset" : "application/soap+xml";
    }

    @Override
   protected String getExpectedAcceptHeader() {
       String accept = "application/soap+xml, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2";
       return acceptFastInfoset ? ("application/soap+fastinfoset, " + accept) : accept;
   }

}
