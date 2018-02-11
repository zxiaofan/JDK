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

package com.sun.xml.internal.xsom.util;

import java.util.Set;

import com.sun.xml.internal.xsom.XSType;

/**
 * A very simple TypeSet.
 *
 * The contains method returns true if the set explicitly contains an
 * instance of the specified XSType.
 *
 * @author <a href="mailto:Ryan.Shoemaker@Sun.COM">Ryan Shoemaker</a>, Sun Microsystems, Inc.
 */
public class SimpleTypeSet extends TypeSet {

    private final Set typeSet;

    public SimpleTypeSet(Set s) {
        typeSet = s;
    }

    /* (non-Javadoc)
     * @see com.sun.xml.internal.xsom.util.TypeSet#contains(com.sun.xml.internal.xsom.XSDeclaration)
     */
    public boolean contains(XSType type) {
        return typeSet.contains(type);
    }

}
