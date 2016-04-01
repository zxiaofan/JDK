/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.mirror.type;


import java.util.Collection;


/**
 * Represents a wildcard type argument.
 * Examples include:    <pre><tt>
 *   ?
 *   ? extends Number
 *   ? super T
 * </tt></pre>
 *
 * <p> A wildcard may have its upper bound explicitly set by an
 * <tt>extends</tt> clause, its lower bound explicitly set by a
 * <tt>super</tt> clause, or neither (but not both).
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.type.WildcardType}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface WildcardType extends TypeMirror {

    /**
     * Returns the upper bounds of this wildcard.
     * If no upper bound is explicitly declared, then
     * an empty collection is returned.
     *
     * @return the upper bounds of this wildcard
     */
    Collection<ReferenceType> getUpperBounds();

    /**
     * Returns the lower bounds of this wildcard.
     * If no lower bound is explicitly declared, then
     * an empty collection is returned.
     *
     * @return the lower bounds of this wildcard
     */
    Collection<ReferenceType> getLowerBounds();
}
