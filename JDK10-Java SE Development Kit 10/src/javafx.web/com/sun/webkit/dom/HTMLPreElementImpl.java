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

import org.w3c.dom.html.HTMLPreElement;

public class HTMLPreElementImpl extends HTMLElementImpl implements HTMLPreElement {
    HTMLPreElementImpl(long peer) {
        super(peer);
    }

    static HTMLPreElement getImpl(long peer) {
        return (HTMLPreElement)create(peer);
    }


// Attributes
    public int getWidth() {
        return getWidthImpl(getPeer());
    }
    native static int getWidthImpl(long peer);

    public void setWidth(int value) {
        setWidthImpl(getPeer(), value);
    }
    native static void setWidthImpl(long peer, int value);

    public boolean getWrap() {
        return getWrapImpl(getPeer());
    }
    native static boolean getWrapImpl(long peer);

    public void setWrap(boolean value) {
        setWrapImpl(getPeer(), value);
    }
    native static void setWrapImpl(long peer, boolean value);

}

