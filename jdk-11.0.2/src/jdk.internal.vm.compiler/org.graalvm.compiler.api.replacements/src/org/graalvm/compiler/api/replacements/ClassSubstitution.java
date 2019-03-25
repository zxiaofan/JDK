/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Denotes a class that substitutes methods of another specified class. The substitute methods are
 * exactly those annotated by {@link MethodSubstitution}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassSubstitution {

    /**
     * Specifies the original class.
     * <p>
     * If the default value is specified for this element, then a non-default value must be given
     * for the {@link #className()} element.
     */
    Class<?> value() default ClassSubstitution.class;

    /**
     * Specifies the original class or classes if a single class is being used for multiple
     * substitutions.
     * <p>
     * This method is provided for cases where the original class is not accessible (according to
     * Java language access control rules).
     * <p>
     * If the default value is specified for this element, then a non-default value must be given
     * for the {@link #value()} element.
     */
    String[] className() default {};

    /**
     * Determines if the substitutions are for classes that may not be part of the runtime.
     * Substitutions for such classes are omitted if the original classes cannot be found. If
     * multiple classes are specified using {@link #className()} and {@link #optional()} is false,
     * then at least one of the classes is required to be reachable.
     */
    boolean optional() default false;
}
