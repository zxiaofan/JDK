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

package com.sun.mirror.util;


import com.sun.mirror.declaration.*;


/**
 * Utility methods for operating on declarations.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.util.Elements}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface Declarations {

    /**
     * Tests whether one type, method, or field declaration hides another.
     *
     * @param sub the first member
     * @param sup the second member
     * @return <tt>true</tt> if and only if the first member hides
     *          the second
     */
    boolean hides(MemberDeclaration sub, MemberDeclaration sup);

    /**
     * Tests whether one method overrides another.  When a
     * non-abstract method overrides an abstract one, the
     * former is also said to <i>implement</i> the latter.
     *
     * @param sub the first method
     * @param sup the second method
     * @return <tt>true</tt> if and only if the first method overrides
     *          the second
     */
    boolean overrides(MethodDeclaration sub, MethodDeclaration sup);
}
