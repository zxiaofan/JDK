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

import org.w3c.dom.html.HTMLModElement;

public class HTMLModElementImpl extends HTMLElementImpl implements HTMLModElement {
    HTMLModElementImpl(long peer) {
        super(peer);
    }

    static HTMLModElement getImpl(long peer) {
        return (HTMLModElement)create(peer);
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

    public String getDateTime() {
        return getDateTimeImpl(getPeer());
    }
    native static String getDateTimeImpl(long peer);

    public void setDateTime(String value) {
        setDateTimeImpl(getPeer(), value);
    }
    native static void setDateTimeImpl(long peer, String value);

}

