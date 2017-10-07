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

package com.sun.tools.internal.xjc.api;

import com.sun.codemodel.internal.JAnnotatable;
import com.sun.codemodel.internal.JType;

/**
 * Java type and associated JAXB annotations.
 *
 * @author Kohsuke Kawaguchi
 */
public interface TypeAndAnnotation {
    /**
     * Returns the Java type.
     *
     * <p>
     * {@link JType} is a representation of a Java type in a codeModel.
     * If you just need the fully-qualified class name, call {@link JType#fullName()}.
     *
     * @return
     *      never be null.
     */
    JType getTypeClass();

    /**
     * Annotates the given program element by additional JAXB annotations that need to be there
     * at the point of reference.
     */
    void annotate( JAnnotatable programElement );

    /**
     * Two {@link TypeAndAnnotation} are equal if they
     * has the same type and annotations.
     */
    boolean equals(Object o);
}
