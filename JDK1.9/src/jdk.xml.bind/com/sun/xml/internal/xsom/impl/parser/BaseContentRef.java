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

package com.sun.xml.internal.xsom.impl.parser;

import com.sun.xml.internal.xsom.impl.Ref;
import com.sun.xml.internal.xsom.XSContentType;
import com.sun.xml.internal.xsom.XSType;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public final class BaseContentRef implements Ref.ContentType, Patch {
    private final Ref.Type baseType;
    private final Locator loc;

    public BaseContentRef(final NGCCRuntimeEx $runtime, Ref.Type _baseType) {
        this.baseType = _baseType;
        $runtime.addPatcher(this);
        $runtime.addErrorChecker(new Patch() {
            public void run() throws SAXException {
                XSType t = baseType.getType();
                if (t.isComplexType() && t.asComplexType().getContentType().asParticle()!=null) {
                    $runtime.reportError(
                        Messages.format(Messages.ERR_SIMPLE_CONTENT_EXPECTED,
                            t.getTargetNamespace(), t.getName()), loc);
                }
            }
        });
        this.loc = $runtime.copyLocator();
    }

    public XSContentType getContentType() {
        XSType t = baseType.getType();
        if(t.asComplexType()!=null)
            return t.asComplexType().getContentType();
        else
            return t.asSimpleType();
    }

    public void run() throws SAXException {
        if (baseType instanceof Patch)
            ((Patch) baseType).run();
    }
}
