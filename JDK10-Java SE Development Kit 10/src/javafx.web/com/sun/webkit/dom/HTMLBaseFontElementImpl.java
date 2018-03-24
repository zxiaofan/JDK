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

import org.w3c.dom.html.HTMLBaseFontElement;

public class HTMLBaseFontElementImpl extends HTMLElementImpl implements HTMLBaseFontElement {
    HTMLBaseFontElementImpl(long peer) {
        super(peer);
    }

    static HTMLBaseFontElement getImpl(long peer) {
        return (HTMLBaseFontElement)create(peer);
    }


// Attributes
    public String getColor() {
        return getColorImpl(getPeer());
    }
    native static String getColorImpl(long peer);

    public void setColor(String value) {
        setColorImpl(getPeer(), value);
    }
    native static void setColorImpl(long peer, String value);

    public String getFace() {
        return getFaceImpl(getPeer());
    }
    native static String getFaceImpl(long peer);

    public void setFace(String value) {
        setFaceImpl(getPeer(), value);
    }
    native static void setFaceImpl(long peer, String value);

    public String getSize() {
        return getSizeImpl(getPeer())+"";
    }
    native static String getSizeImpl(long peer);

    public void setSize(String value) {
        setSizeImpl(getPeer(), value);
    }
    native static void setSizeImpl(long peer, String value);

}

