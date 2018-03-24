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

import org.w3c.dom.html.HTMLQuoteElement;

public class HTMLQuoteElementImpl extends HTMLElementImpl implements HTMLQuoteElement {
    HTMLQuoteElementImpl(long peer) {
        super(peer);
    }

    static HTMLQuoteElement getImpl(long peer) {
        return (HTMLQuoteElement)create(peer);
    }


// Attributes
    public String getCite() {
        return getCiteImpl(getPeer());
    }
    native static String getCiteImpl(long peer);

    public void setCite(String value) {
        setCiteImpl(getPeer(), value);
    }
    native static void setCiteImpl(long peer, String value);

}

