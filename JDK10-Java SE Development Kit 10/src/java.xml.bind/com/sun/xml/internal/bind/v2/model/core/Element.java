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

package com.sun.xml.internal.bind.v2.model.core;

import javax.xml.namespace.QName;

/**
 * {@link TypeInfo} that maps to an element.
 *
 * Either {@link ElementInfo} or {@link ClassInfo}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface Element<T,C> extends TypeInfo<T,C> {
    /**
     * Gets the element name of the class.
     *
     * @return
     *      Always non-null.
     */
    QName getElementName();

    /**
     * If this element can substitute another element, return that element.
     *
     * <p>
     * Substitutability of elements are transitive.
     *
     * @return
     *      null if no such element exists.
     */
    Element<T,C> getSubstitutionHead();

    /**
     * If non-null, this element is only active inside the given scope.
     */
    ClassInfo<T,C> getScope();
}
