/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom.impl.util;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class ResourceEntityResolver implements EntityResolver {
    public ResourceEntityResolver( Class _base ) {
        this.base = _base;
    }

    private final Class base;

    public InputSource resolveEntity( String publicId, String systemId ) {
        return new InputSource(base.getResourceAsStream(systemId));
    }
}
