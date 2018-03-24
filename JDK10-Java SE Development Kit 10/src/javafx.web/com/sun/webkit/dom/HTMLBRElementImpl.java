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

import org.w3c.dom.html.HTMLBRElement;

public class HTMLBRElementImpl extends HTMLElementImpl implements HTMLBRElement {
    HTMLBRElementImpl(long peer) {
        super(peer);
    }

    static HTMLBRElement getImpl(long peer) {
        return (HTMLBRElement)create(peer);
    }


// Attributes
    public String getClear() {
        return getClearImpl(getPeer());
    }
    native static String getClearImpl(long peer);

    public void setClear(String value) {
        setClearImpl(getPeer(), value);
    }
    native static void setClearImpl(long peer, String value);

}

