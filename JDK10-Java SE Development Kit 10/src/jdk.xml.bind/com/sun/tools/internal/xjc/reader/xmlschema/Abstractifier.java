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

import com.sun.tools.internal.xjc.model.CElement;
import com.sun.xml.internal.xsom.XSComplexType;
import com.sun.xml.internal.xsom.XSElementDecl;

/**
 * {@link ClassBinder} that marks abstract components as abstract.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
class Abstractifier extends ClassBinderFilter {
    public Abstractifier(ClassBinder core) {
        super(core);
    }

    public CElement complexType(XSComplexType xs) {
        CElement ci = super.complexType(xs);
        if(ci!=null && xs.isAbstract())
            ci.setAbstract();
        return ci;
    }

    public CElement elementDecl(XSElementDecl xs) {
        CElement ci = super.elementDecl(xs);
        if(ci!=null && xs.isAbstract())
            ci.setAbstract();
        return ci;
    }
}
