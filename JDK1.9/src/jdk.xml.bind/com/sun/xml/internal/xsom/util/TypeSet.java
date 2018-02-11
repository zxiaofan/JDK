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

import com.sun.xml.internal.xsom.XSType;

/**
 * A simple abstraction for a set of Types that defines containment functions.
 *
 * @author <a href="mailto:Ryan.Shoemaker@Sun.COM">Ryan Shoemaker</a>, Sun Microsystems, Inc.
 */
public abstract class TypeSet {

    /**
     * Return true if this TypeSet contains the specified type.
     *
     * Concrete implementations of this method determine what it
     * means for the TypeSet to "contain" a type.
     *
     * @param type the type
     * @return true iff this TypeSet contains the specified type
     */
    public abstract boolean contains(XSType type);

    /**
     * Calculate the TypeSet formed by the intersection of two
     * other TypeSet objects.
     *
     * @param a a TypeSet
     * @param b another TypeSet
     * @return the intersection of a and b
     */
    public static TypeSet intersection(final TypeSet a, final TypeSet b) {
        return new TypeSet(){
            public boolean contains(XSType type) {
                return a.contains(type) && b.contains(type);
            }
        };
    }

    /**
     * Calculate the TypeSet formed by the union of two
     * other TypeSet objects.
     *
     * @param a a TypeSet
     * @param b another TypeSet
     * @return the union of a and b
     */
    public static TypeSet union(final TypeSet a, final TypeSet b) {
        return new TypeSet(){
            public boolean contains(XSType type) {
                return a.contains(type) || b.contains(type);
            }
        };
    }
}
