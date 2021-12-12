/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event annotation, determines whether an event by default has a stack trace
 * or not.
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface StackTrace {
    /**
     * Settings name {@code "stackTrace"} to be used for enabling event stack traces.
     */
    public static final String NAME = "stackTrace";

    /**
     * Returns if the stack trace from the {@code Event#commit()} method should be recorded.
     *
     * @return {@code true} if the stack trace should be recorded, {@code false}
     *         otherwise
     */
    boolean value() default true;
}
