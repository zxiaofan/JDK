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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that overrides the default name for an element (for example, when
 * the default package for an event is not appropriate).
 * <p>
 * The name must be a valid identifiers in the Java language (for example,
 * {@code "com.example.MyEvent"} for an event class or {@code "message"} for an
 * event field).
 *
 * @since 9
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MetadataDefinition
public @interface Name {
    /**
     * Returns the name.
     *
     * @return the name
     */
    String value();
}
