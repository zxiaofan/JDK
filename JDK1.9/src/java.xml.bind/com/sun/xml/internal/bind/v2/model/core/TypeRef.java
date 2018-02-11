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
 * Information about a type referenced from {@link ElementPropertyInfo}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface TypeRef<T,C> extends NonElementRef<T,C> {
    /**
     * The associated element name.
     *
     * @return
     *      never null.
     */
    QName getTagName();

    /**
     * Returns true if this element is nillable.
     */
    boolean isNillable();

    /**
     * The default value for this element if any.
     * Otherwise null.
     */
    String getDefaultValue();
}
