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

/**
 * {@code AnnotatedTypeVariable} represents the potentially annotated use of a
 * type variable, whose declaration may have bounds which themselves represent
 * annotated uses of types.
 *
 * @jls 4.4 Type Variables
 * @since 1.8
 */
public interface AnnotatedTypeVariable extends AnnotatedType {

    /**
     * Returns the potentially annotated bounds of this type variable.
     * If no bound is explicitly declared, the bound is unannotated
     * {@code Object}.
     *
     * @return the potentially annotated bounds of this type variable
     * @see TypeVariable#getBounds()
     */
    AnnotatedType[] getAnnotatedBounds();

    /**
     * Returns the potentially annotated type that this type is a member of, if
     * this type represents a nested type. For example, if this type is
     * {@code @TA O<T>.I<S>}, return a representation of {@code @TA O<T>}.
     *
     * <p>Returns {@code null} for an {@code AnnotatedType} that is an instance
     *     of {@code AnnotatedTypeVariable}.
     *
     * @return {@code null}
     *
     * @since 9
     */
    @Override
    AnnotatedType getAnnotatedOwnerType();
}
