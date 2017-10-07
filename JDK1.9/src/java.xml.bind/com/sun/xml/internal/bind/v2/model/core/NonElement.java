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

import com.sun.xml.internal.bind.v2.WellKnownNamespace;
import javax.xml.namespace.QName;

/**
 * {@link TypeInfo} that maps to an element.
 *
 * Either {@link LeafInfo} or {@link ClassInfo}.
 *
 * TODO: better ANYTYPE_NAME.
 *
 * @author Kohsuke Kawaguchi
 */
public interface NonElement<T,C> extends TypeInfo<T,C> {
    public static final QName ANYTYPE_NAME = new QName(WellKnownNamespace.XML_SCHEMA, "anyType");

    /**
     * Gets the primary XML type ANYTYPE_NAME of the class.
     *
     * <p>
     * A Java type can be mapped to multiple XML types, but one of them is
     * considered "primary" and used when we generate a schema.
     *
     * @return
     *      null if the object doesn't have an explicit type ANYTYPE_NAME (AKA anonymous.)
     */
    QName getTypeName();

    /**
     * Returns true if this {@link NonElement} maps to text in XML,
     * without any attribute nor child elements.
     */
    boolean isSimpleType();
}
