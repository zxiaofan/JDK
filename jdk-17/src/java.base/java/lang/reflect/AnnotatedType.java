/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.Annotation;

/**
 * {@code AnnotatedType} represents the potentially annotated use of a type in
 * the program currently running in this VM. The use may be of any type in the
 * Java programming language, including an array type, a parameterized type, a
 * type variable, or a wildcard type.
 *
 * Note that any annotations returned by methods on this interface are
 * <em>type annotations</em> (JLS {@jls 9.7.4}) as the entity being
 * potentially annotated is a type.
 *
 * @jls 4.1 The Kinds of Types and Values
 * @jls 4.2 Primitive Types and Values
 * @jls 4.3 Reference Types and Values
 * @jls 4.4 Type Variables
 * @jls 4.5 Parameterized Types
 * @jls 4.8 Raw Types
 * @jls 4.9 Intersection Types
 * @jls 10.1 Array Types
 * @since 1.8
 */
public interface AnnotatedType extends AnnotatedElement {

    /**
     * Returns the potentially annotated type that this type is a member of, if
     * this type represents a nested type. For example, if this type is
     * {@code @TA O<T>.I<S>}, return a representation of {@code @TA O<T>}.
     *
     * <p>Returns {@code null} if this {@code AnnotatedType} represents a
     *     top-level class or interface, or a local or anonymous class, or
     *     a primitive type, or void.
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
     *     refers to a non-existent class or interface declaration
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

    /**
     * {@inheritDoc}
     * <p>Note that any annotation returned by this method is a type
     * annotation.
     *
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    <T extends Annotation> T getAnnotation(Class<T> annotationClass);

    /**
     * {@inheritDoc}
     * <p>Note that any annotations returned by this method are type
     * annotations.
     */
    @Override
    Annotation[] getAnnotations();

    /**
     * {@inheritDoc}
     * <p>Note that any annotations returned by this method are type
     * annotations.
     */
    @Override
    Annotation[] getDeclaredAnnotations();
}
