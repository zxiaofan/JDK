/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Visitor for {@link CPropertyInfo}.
 *
 * The number 2 signals number of arguments.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @see CPropertyInfo#accept(CPropertyVisitor2, Object)
 *
 * @author Marcel Valovy
 */
public interface CPropertyVisitor2<R, P> {

    /**
     * Visits a CElementPropertyInfo type.
     * @param t the type to visit
     * @param p a visitor-specified parameter
     * @return  a visitor-specified result
     */
    R visit(CElementPropertyInfo t, P p);

    /**
     * Visits a CAttributePropertyInfo type.
     * @param t the type to visit
     * @param p a visitor-specified parameter
     * @return  a visitor-specified result
     */
    R visit(CAttributePropertyInfo t, P p);

    /**
     * Visits a CValuePropertyInfo type.
     * @param t the type to visit
     * @param p a visitor-specified parameter
     * @return  a visitor-specified result
     */
    R visit(CValuePropertyInfo t, P p);

    /**
     * Visits a CReferencePropertyInfo type.
     * @param t the type to visit
     * @param p a visitor-specified parameter
     * @return  a visitor-specified result
     */
    R visit(CReferencePropertyInfo t, P p);
}
