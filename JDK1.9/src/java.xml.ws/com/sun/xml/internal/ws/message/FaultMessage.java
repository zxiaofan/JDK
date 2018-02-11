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

package com.sun.xml.internal.ws.message;

import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.FilterMessageImpl;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;

import javax.xml.namespace.QName;

/**
 * SOAP Fault message. It has optimized implementation to get
 * first detail entry's name. This is useful to identify the
 * corresponding {@link WSDLFault}
 *
 * @author Jitendra Kotamraju
 */
public class FaultMessage extends FilterMessageImpl {

    private final @Nullable QName detailEntryName;

    public FaultMessage(Message delegate, @Nullable QName detailEntryName) {
        super(delegate);
        this.detailEntryName = detailEntryName;
    }

    @Override
    public @Nullable QName getFirstDetailEntryName() {
        return detailEntryName;
    }

}
