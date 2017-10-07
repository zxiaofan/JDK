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

package com.sun.xml.internal.ws.model;
import com.sun.istack.internal.localization.Localizable;
import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;

/**
 * RuntimeModelerException represents an exception that occurred while
 * serializing a Java value as XML.
 *
 * @see JAXWSExceptionBase
 *
 * @author WS Development Team
 */
public class RuntimeModelerException extends JAXWSExceptionBase {

    public RuntimeModelerException(String key, Object... args) {
        super(key, args);
    }

    public RuntimeModelerException(Throwable throwable) {
        super(throwable);
    }

    public RuntimeModelerException(Localizable arg) {
        super("nestedModelerError", arg);
    }

    public String getDefaultResourceBundleName() {
        return "com.sun.xml.internal.ws.resources.modeler";
    }

}
