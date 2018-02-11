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

package com.sun.tools.internal.ws.wsdl.framework;

import org.xml.sax.Locator;

import javax.xml.namespace.QName;

/**
 * Interface implemented by classes that are mappable to XML elements.
 *
 * @author WS Development Team
 */
public interface Elemental {
    public QName getElementName();
    public Locator getLocator();
}
