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

import org.w3c.dom.html.HTMLHeadElement;

public class HTMLHeadElementImpl extends HTMLElementImpl implements HTMLHeadElement {
    HTMLHeadElementImpl(long peer) {
        super(peer);
    }

    static HTMLHeadElement getImpl(long peer) {
        return (HTMLHeadElement)create(peer);
    }


// Attributes
    public String getProfile() {
        return getProfileImpl(getPeer());
    }
    native static String getProfileImpl(long peer);

    public void setProfile(String value) {
        setProfileImpl(getPeer(), value);
    }
    native static void setProfileImpl(long peer, String value);

}

