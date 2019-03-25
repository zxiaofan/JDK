/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Annotates a method replaced by a compile-time constant. A (resolved) call to the annotated method
 * is replaced with a constant obtained by calling the annotated method via reflection.
 *
 * All arguments to such a method (including the receiver if applicable) must be compile-time
 * constants.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Fold {

    /**
     * Annotates a parameter to an {@link Fold}-annotated method. This parameter will be
     * automatically injected by the compiler. The caller should always pass {@code null}.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface InjectedParameter {
    }
}
