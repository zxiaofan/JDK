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

import org.w3c.dom.css.CSSPageRule;
import org.w3c.dom.css.CSSStyleDeclaration;

public class CSSPageRuleImpl extends CSSRuleImpl implements CSSPageRule {
    CSSPageRuleImpl(long peer) {
        super(peer);
    }

    static CSSPageRule getImpl(long peer) {
        return (CSSPageRule)create(peer);
    }


// Attributes
    public String getSelectorText() {
        return getSelectorTextImpl(getPeer());
    }
    native static String getSelectorTextImpl(long peer);

    public void setSelectorText(String value) {
        setSelectorTextImpl(getPeer(), value);
    }
    native static void setSelectorTextImpl(long peer, String value);

    public CSSStyleDeclaration getStyle() {
        return CSSStyleDeclarationImpl.getImpl(getStyleImpl(getPeer()));
    }
    native static long getStyleImpl(long peer);

}

