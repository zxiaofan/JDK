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

package com.sun.xml.internal.ws.protocol.soap;

import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.fault.SOAPFaultBuilder;

import javax.xml.namespace.QName;

/**
 * This is used to represent Message creation exception when a {@link com.sun.xml.internal.ws.api.pipe.Codec}
 * trying to create a {@link Message}.
 *
 * @author Jitendra Kotamraju
 */
public class MessageCreationException extends ExceptionHasMessage {

    private final SOAPVersion soapVersion;

    public MessageCreationException(SOAPVersion soapVersion, Object... args) {
        super("soap.msg.create.err", args);
        this.soapVersion = soapVersion;
    }

    public String getDefaultResourceBundleName() {
        return "com.sun.xml.internal.ws.resources.soap";
    }

    public Message getFaultMessage() {
        QName faultCode = soapVersion.faultCodeClient;
        return SOAPFaultBuilder.createSOAPFaultMessage(
                soapVersion, getLocalizedMessage(), faultCode);
    }

}
