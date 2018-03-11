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

package com.sun.mirror.declaration;


import java.util.Collection;

import com.sun.mirror.type.ReferenceType;


/**
 * Represents a method or constructor of a class or interface.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.ExecutableElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface ExecutableDeclaration extends MemberDeclaration {

    /**
     * Returns <tt>true</tt> if this method or constructor accepts a variable
     * number of arguments.
     *
     * @return <tt>true</tt> if this method or constructor accepts a variable
     * number of arguments
     */
    boolean isVarArgs();

    /**
     * Returns the formal type parameters of this method or constructor.
     * They are returned in declaration order.
     *
     * @return the formal type parameters of this method or constructor,
     * or an empty collection if there are none
     */
    Collection<TypeParameterDeclaration> getFormalTypeParameters();

    /**
     * Returns the formal parameters of this method or constructor.
     * They are returned in declaration order.
     *
     * @return the formal parameters of this method or constructor,
     * or an empty collection if there are none
     */
    Collection<ParameterDeclaration> getParameters();

    /**
     * Returns the exceptions and other throwables listed in this
     * method or constructor's <tt>throws</tt> clause.
     *
     * @return the exceptions and other throwables listed in the
     * <tt>throws</tt> clause, or an empty collection if there are none
     */
    Collection<ReferenceType> getThrownTypes();
}
