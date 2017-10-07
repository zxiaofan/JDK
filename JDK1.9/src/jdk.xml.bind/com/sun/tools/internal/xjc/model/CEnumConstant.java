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

package com.sun.tools.internal.xjc.model;

import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.xml.internal.bind.v2.model.core.EnumConstant;

import com.sun.xml.internal.xsom.XSComponent;
import org.xml.sax.Locator;

/**
 * Enumeration constant.
 *
 * @author Kohsuke Kawaguchi
 */
public final class CEnumConstant implements EnumConstant<NType,NClass>, CCustomizable {
    /** Name of the constant. */
    public final String name;
    /** Javadoc comment. Can be null. */
    public final String javadoc;
    /** Lexical representation of this enum constant. Always non-null. */
    private final String lexical;

    private CEnumLeafInfo parent;

    private final XSComponent source;

    private final CCustomizations customizations;

    private final Locator locator;

    /**
     * @param name
     */
    public CEnumConstant(String name, String javadoc, String lexical, XSComponent source, CCustomizations customizations, Locator loc) {
        assert name!=null;
        this.name = name;
        this.javadoc = javadoc;
        this.lexical = lexical;
        this.source = source;
        this.customizations = customizations;
        this.locator = loc;
    }

    public CEnumLeafInfo getEnclosingClass() {
        return parent;
    }

    /*package*/ void setParent(CEnumLeafInfo parent) {
        this.parent = parent;
    }

    public String getLexicalValue() {
        return lexical;
    }

    public String getName() {
        return name;
    }

    public XSComponent getSchemaComponent() {
        return source;
    }

    public CCustomizations getCustomizations() {
        return customizations;
    }

    public Locator getLocator() {
        return locator;
    }
}
