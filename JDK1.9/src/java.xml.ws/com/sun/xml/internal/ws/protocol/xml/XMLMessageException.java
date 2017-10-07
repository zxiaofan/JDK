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

package com.sun.xml.internal.ws.protocol.xml;

import com.sun.istack.internal.localization.Localizable;
import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;

/**
 * @author WS Development Team
 */
public class XMLMessageException extends JAXWSExceptionBase {

    public XMLMessageException(String key, Object... args) {
        super(key, args);
    }

    public XMLMessageException(Throwable throwable) {
        super(throwable);
    }

    public XMLMessageException(Localizable arg) {
        super("server.rt.err", arg);
    }

    public String getDefaultResourceBundleName() {
        return "com.sun.xml.internal.ws.resources.xmlmessage";
    }

}
