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

package com.sun.xml.internal.ws.handler;

import com.sun.istack.internal.localization.Localizable;
import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;

/**
 * Exception thrown by handler-related code. Extends
 * {@link com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase}
 * using the appropriate resource bundle.
 *
 * @see com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase
 *
 * @author WS Development Team
 */
public class HandlerException extends JAXWSExceptionBase {
    public HandlerException(String key, Object... args) {
        super(key, args);
    }

    public HandlerException(Throwable throwable) {
        super(throwable);
    }

    public HandlerException(Localizable arg) {
        super("handler.nestedError", arg);
    }

    public String getDefaultResourceBundleName() {
        return "com.sun.xml.internal.ws.resources.handler";
    }
}
