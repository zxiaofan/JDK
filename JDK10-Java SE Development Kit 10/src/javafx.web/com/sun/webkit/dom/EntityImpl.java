/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.dom;

import org.w3c.dom.Entity;

public class EntityImpl extends NodeImpl implements Entity {
    EntityImpl(long peer) {
        super(peer);
    }

    static Entity getImpl(long peer) {
        return (Entity)create(peer);
    }


// Attributes
    public String getPublicId() {
        return getPublicIdImpl(getPeer());
    }
    native static String getPublicIdImpl(long peer);

    public String getSystemId() {
        return getSystemIdImpl(getPeer());
    }
    native static String getSystemIdImpl(long peer);

    public String getNotationName() {
        return getNotationNameImpl(getPeer());
    }
    native static String getNotationNameImpl(long peer);


//stubs
    public String getInputEncoding() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getXmlVersion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getXmlEncoding() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

