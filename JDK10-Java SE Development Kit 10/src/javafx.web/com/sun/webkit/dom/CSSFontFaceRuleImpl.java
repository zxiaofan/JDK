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

import org.w3c.dom.css.CSSFontFaceRule;
import org.w3c.dom.css.CSSStyleDeclaration;

public class CSSFontFaceRuleImpl extends CSSRuleImpl implements CSSFontFaceRule {
    CSSFontFaceRuleImpl(long peer) {
        super(peer);
    }

    static CSSFontFaceRule getImpl(long peer) {
        return (CSSFontFaceRule)create(peer);
    }


// Attributes
    public CSSStyleDeclaration getStyle() {
        return CSSStyleDeclarationImpl.getImpl(getStyleImpl(getPeer()));
    }
    native static long getStyleImpl(long peer);

}

