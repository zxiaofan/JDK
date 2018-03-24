/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema;

import com.sun.tools.internal.xjc.reader.gbind.Element;
import com.sun.xml.internal.xsom.XSWildcard;

/**
 * {@link Element} that represents a wildcard,
 * for the "ease of binding" we always just bind this to DOM elements.
 * @author Kohsuke Kawaguchi
 */
final class GWildcardElement extends GElement {

    /**
     * If true, bind to {@code Object} for eager JAXB unmarshalling.
     * Otherwise bind to DOM (I hate "you can put both" semantics,
     * so I'm not going to do that in this binding mode.)
     */
    private boolean strict = true;

    public String toString() {
        return "#any";
    }

    String getPropertyNameSeed() {
        return "any";
    }

    public void merge(XSWildcard wc) {
        switch(wc.getMode()) {
        case XSWildcard.LAX:
        case XSWildcard.SKIP:
            strict = false;
        }
    }

    public boolean isStrict() {
        return strict;
    }
}
