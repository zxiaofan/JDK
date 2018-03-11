/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.util;


import java.util.Collection;

import com.sun.mirror.declaration.*;
import com.sun.mirror.type.*;


/**
 * Utility methods for operating on types.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface Types {

    /**
     * Tests whether one type is a subtype of the another.
     * Any type is considered to be a subtype of itself.
     *
     * @param t1  the first type
     * @param t2  the second type
     * @return <tt>true</tt> if and only if the first type is a subtype
     *		of the second
     */
    boolean isSubtype(TypeMirror t1, TypeMirror t2);

    /**
     * Tests whether one type is assignable to another.
     *
     * @param t1  the first type
     * @param t2  the second type
     * @return <tt>true</tt> if and only if the first type is assignable
     *		to the second
     */
    boolean isAssignable(TypeMirror t1, TypeMirror t2);

    /**
     * Returns the erasure of a type.
     *
     * @param t  the type to be erased
     * @return the erasure of the given type
     */
    TypeMirror getErasure(TypeMirror t);

    /**
     * Returns a primitive type.
     *
     * @param kind  the kind of primitive type to return
     * @return a primitive type
     */
    PrimitiveType getPrimitiveType(PrimitiveType.Kind kind);

    /**
     * Returns the pseudo-type representing the type of <tt>void</tt>.
     *
     * @return the pseudo-type representing the type of <tt>void</tt>
     */
    VoidType getVoidType();

    /**
     * Returns an array type with the specified component type.
     *
     * @param componentType  the component type
     * @return an array type with the specified component type.
     * @throws IllegalArgumentException if the component type is not valid for
     *		an array
     */
    ArrayType getArrayType(TypeMirror componentType);

    /**
     * Returns the type variable declared by a type parameter.
     *
     * @param tparam  the type parameter
     * @return the type variable declared by the type parameter
     */
    TypeVariable getTypeVariable(TypeParameterDeclaration tparam);

    /**
     * Returns a new wildcard.
     * Either the wildcards's upper bounds or lower bounds may be
     * specified, or neither, but not both.
     *
     * @param upperBounds  the upper bounds of this wildcard,
     *		or an empty collection if none
     * @param lowerBounds  the lower bounds of this wildcard,
     *		or an empty collection if none
     * @return a new wildcard
     * @throws IllegalArgumentException if bounds are not valid
     */
    WildcardType getWildcardType(Collection<ReferenceType> upperBounds,
				 Collection<ReferenceType> lowerBounds);

    /**
     * Returns the type corresponding to a type declaration and
     * actual type arguments.
     * Given the declaration for <tt>String</tt>, for example, this
     * method may be used to get the <tt>String</tt> type.  It may
     * then be invoked a second time, with the declaration for <tt>Set</tt>,
     * to make the parameterized type {@code Set<String>}.
     *
     * <p> The number of type arguments must either equal the
     * number of the declaration's formal type parameters, or must be
     * zero.  If zero, and if the declaration is generic,
     * then the declaration's raw type is returned.
     *
     * <p> If a parameterized type is being returned, its declaration
     * must not be contained within a generic outer class.
     * The parameterized type {@code Outer<String>.Inner<Number>},
     * for example, may be constructed by first using this
     * method to get the type {@code Outer<String>}, and then invoking
     * {@link #getDeclaredType(DeclaredType, TypeDeclaration, TypeMirror...)}.
     *
     * @param decl	the type declaration
     * @param typeArgs	the actual type arguments
     * @return the type corresponding to the type declaration and
     *		actual type arguments
     * @throws IllegalArgumentException if too many or too few
     *		type arguments are given, or if an inappropriate type
     *		argument or declaration is provided
     */
    DeclaredType getDeclaredType(TypeDeclaration decl,
				 TypeMirror... typeArgs);

    /**
     * Returns the type corresponding to a type declaration
     * and actual arguments, given a
     * {@linkplain DeclaredType#getContainingType() containing type}
     * of which it is a member.
     * The parameterized type {@code Outer<String>.Inner<Number>},
     * for example, may be constructed by first using
     * {@link #getDeclaredType(TypeDeclaration, TypeMirror...)}
     * to get the type {@code Outer<String>}, and then invoking
     * this method.
     *
     * <p> If the containing type is a parameterized type,
     * the number of type arguments must equal the
     * number of the declaration's formal type parameters.
     * If it is not parameterized or if it is <tt>null</tt>, this method is
     * equivalent to <tt>getDeclaredType(decl, typeArgs)</tt>.
     *
     * @param containing  the containing type, or <tt>null</tt> if none
     * @param decl	  the type declaration
     * @param typeArgs	  the actual type arguments
     * @return the type corresponding to the type declaration and
     *		actual type arguments,
     *		contained within the given type
     * @throws IllegalArgumentException if too many or too few
     *		type arguments are given, or if an inappropriate type
     *		argument, declaration, or containing type is provided
     */
    DeclaredType getDeclaredType(DeclaredType containing,
				 TypeDeclaration decl,
				 TypeMirror... typeArgs);
}
