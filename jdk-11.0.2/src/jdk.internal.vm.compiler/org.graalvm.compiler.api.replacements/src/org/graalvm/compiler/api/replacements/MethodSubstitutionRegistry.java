/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.api.replacements;

import java.lang.reflect.Type;

/**
 * A registry for {@link MethodSubstitution}s.
 */
public interface MethodSubstitutionRegistry {

    /**
     * Gets the type representing the receiver (i.e., {@code this}) argument in a non-static method.
     */
    Class<?> getReceiverType();

    /**
     * Registers a substitution method.
     *
     * @param substituteDeclaringClass the class declaring the substitute method
     * @param name the name of both the original and substitute method
     * @param argumentTypes the argument types of the method. Element 0 of this array must be
     *            {@link #getReceiverType()} iff the method is non-static. Upon returning, element 0
     *            will have been rewritten to {@code declaringClass}.
     */
    default void registerMethodSubstitution(Class<?> substituteDeclaringClass, String name, Type... argumentTypes) {
        registerMethodSubstitution(substituteDeclaringClass, name, name, argumentTypes);
    }

    /**
     * Registers a substitution method.
     *
     * @param substituteDeclaringClass the class declaring the substitute method
     * @param name the name of both the original method
     * @param substituteName the name of the substitute method
     * @param argumentTypes the argument types of the method. Element 0 of this array must be
     *            {@link #getReceiverType()} iff the method is non-static. Upon returning, element 0
     *            will have been rewritten to {@code declaringClass}.
     */
    void registerMethodSubstitution(Class<?> substituteDeclaringClass, String name, String substituteName, Type... argumentTypes);
}
