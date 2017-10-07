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
 * JAXB spec designates a few Java classes to be mapped to leaves in XML.
 *
 * <p>
 * Built-in leaves also have another priviledge; specifically, they often
 * have more than one XML type names associated with it.
 *
 * @author Kohsuke Kawaguchi
 */
public interface BuiltinLeafInfo<T,C> extends LeafInfo<T,C> {
    /**
     * {@inheritDoc}
     *
     * <p>
     * This method returns the 'primary' type name of this built-in leaf,
     * which should be used when values of this type are marshalled.
     *
     * @return
     *      never null.
     */
    public QName getTypeName();
}
