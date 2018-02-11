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



/**
 * Reference to a {@link NonElement}.
 *
 * This interface defines properties of a reference.
 *
 * @author Kohsuke Kawaguchi
 */
public interface NonElementRef<T,C> {
    /**
     * Target of the reference.
     *
     * @return never null
     */
    NonElement<T,C> getTarget();

    /**
     * Gets the property which is the source of this reference.
     *
     * @return never null
     */
    PropertyInfo<T,C> getSource();
}
