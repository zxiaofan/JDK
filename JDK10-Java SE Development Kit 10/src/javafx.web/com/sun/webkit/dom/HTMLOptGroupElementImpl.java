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

import org.w3c.dom.html.HTMLOptGroupElement;

public class HTMLOptGroupElementImpl extends HTMLElementImpl implements HTMLOptGroupElement {
    HTMLOptGroupElementImpl(long peer) {
        super(peer);
    }

    static HTMLOptGroupElement getImpl(long peer) {
        return (HTMLOptGroupElement)create(peer);
    }


// Attributes
    public boolean getDisabled() {
        return getDisabledImpl(getPeer());
    }
    native static boolean getDisabledImpl(long peer);

    public void setDisabled(boolean value) {
        setDisabledImpl(getPeer(), value);
    }
    native static void setDisabledImpl(long peer, boolean value);

    public String getLabel() {
        return getLabelImpl(getPeer());
    }
    native static String getLabelImpl(long peer);

    public void setLabel(String value) {
        setLabelImpl(getPeer(), value);
    }
    native static void setLabelImpl(long peer, String value);

}

