/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


import java.util.Collection;

import com.sun.mirror.declaration.TypeDeclaration;


/**
 * Represents a declared type, either a class type or an interface type.
 * This includes parameterized types such as {@code java.util.Set<String>}
 * as well as raw types.
 *
 * <p> While a <tt>TypeDeclaration</tt> represents the <i>declaration</i>
 * of a class or interface, a <tt>DeclaredType</tt> represents a class
 * or interface <i>type</i>, the latter being a use of the former.
 * See {@link TypeDeclaration} for more on this distinction.
 *
 * <p> A <tt>DeclaredType</tt> may represent a type
 * for which details (declaration, supertypes, <i>etc.</i>) are unknown.
 * This may be the result of a processing error, such as a missing class file,
 * and is indicated by {@link #getDeclaration()} returning <tt>null</tt>.
 * Other method invocations on such an unknown type will not, in general,
 * return meaningful results.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface DeclaredType extends ReferenceType {

    /**
     * Returns the declaration of this type.
     *
     * <p> Returns null if this type's declaration is unknown.  This may
     * be the result of a processing error, such as a missing class file.
     *
     * @return the declaration of this type, or null if unknown
     */
    TypeDeclaration getDeclaration();

    /**
     * Returns the type that contains this type as a member.
     * Returns <tt>null</tt> if this is a top-level type.
     *
     * <p> For example, the containing type of {@code O.I<S>}
     * is the type {@code O}, and the containing type of
     * {@code O<T>.I<S>} is the type {@code O<T>}.
     *
     * @return the type that contains this type,
     * or <tt>null</tt> if this is a top-level type
     */
    DeclaredType getContainingType();

    /**
     * Returns (in order) the actual type arguments of this type.
     * For a generic type nested within another generic type
     * (such as {@code Outer<String>.Inner<Number>}), only the type
     * arguments of the innermost type are included.
     *
     * @return the actual type arguments of this type, or an empty collection
     * if there are none
     */
    Collection<TypeMirror> getActualTypeArguments();

    /**
     * Returns the interface types that are direct supertypes of this type.
     * These are the interface types implemented or extended
     * by this type's declaration, with any type arguments
     * substituted in.
     *
     * <p> For example, the interface type extended by
     * {@code java.util.Set<String>} is {@code java.util.Collection<String>}.
     *
     * @return the interface types that are direct supertypes of this type,
     * or an empty collection if there are none
     */
    Collection<InterfaceType> getSuperinterfaces();
}
