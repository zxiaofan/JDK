/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;

/**
 * {@code AnnotatedType} represents the potentially annotated use of a type in
 * the program currently running in this VM. The use may be of any type in the
 * Java programming language, including an array type, a parameterized type, a
 * type variable, or a wildcard type.
 *
 * @since 1.8
 */
public interface AnnotatedType extends AnnotatedElement {

    /**
     * Returns the potentially annotated type that this type is a member of, if
     * this type represents a nested type. For example, if this type is
     * {@code @TA O<T>.I<S>}, return a representation of {@code @TA O<T>}.
     *
     * <p>Returns {@code null} if this {@code AnnotatedType} represents a
     *     top-level type, or a local or anonymous class, or a primitive type, or
     *     void.
     *
     * <p>Returns {@code null} if this {@code AnnotatedType} is an instance of
     *     {@code AnnotatedArrayType}, {@code AnnotatedTypeVariable}, or
     *     {@code AnnotatedWildcardType}.
     *
     * @implSpec
     * This default implementation returns {@code null} and performs no other
     * action.
     *
     * @return an {@code AnnotatedType} object representing the potentially
     *     annotated type that this type is a member of, or {@code null}
     * @throws TypeNotPresentException if the owner type
     *     refers to a non-existent type declaration
     * @throws MalformedParameterizedTypeException if the owner type
     *     refers to a parameterized type that cannot be instantiated
     *     for any reason
     *
     * @since 9
     */
    default AnnotatedType getAnnotatedOwnerType() {
        return null;
    }

    /**
     * Returns the underlying type that this annotated type represents.
     *
     * @return the type this annotated type represents
     */
    public Type getType();
}
