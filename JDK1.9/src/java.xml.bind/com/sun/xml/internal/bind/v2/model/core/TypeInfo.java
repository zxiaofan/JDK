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

import javax.xml.bind.annotation.XmlIDREF;

import com.sun.xml.internal.bind.v2.model.annotation.Locatable;


/**
 * Either {@link ClassInfo}, {@link ElementInfo}, or {@link LeafInfo}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface TypeInfo<T,C> extends Locatable {

    /**
     * Gets the underlying Java type that object represents.
     *
     * @return
     *      always non-null.
     */
    T getType();

    /**
     * True if this type is a valid target from a property annotated with {@link XmlIDREF}.
     */
    boolean canBeReferencedByIDREF();
}
