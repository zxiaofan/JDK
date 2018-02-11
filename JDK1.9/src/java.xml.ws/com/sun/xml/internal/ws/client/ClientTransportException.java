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

package com.sun.xml.internal.ws.client;

import com.sun.istack.internal.localization.Localizable;
import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;


/**
 * @author WS Development Team
 */
public class ClientTransportException extends JAXWSExceptionBase {
    public ClientTransportException(Localizable msg) {
        super(msg);
    }

    public ClientTransportException(Localizable msg, Throwable cause) {
        super(msg, cause);
    }

    public ClientTransportException(Throwable throwable) {
        super(throwable);
    }

    public String getDefaultResourceBundleName() {
        return "com.sun.xml.internal.ws.resources.client";
    }
}
