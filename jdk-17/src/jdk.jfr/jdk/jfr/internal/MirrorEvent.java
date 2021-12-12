/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface MirrorEvent {
    /**
     * Fully qualified name of the class to mirror metadata for (for example,
     * {@code "jdk.internal.event.Example"})
     *
     * @return the fully qualified class name of the event
     */
    String className();

    /**
     * The module where the event is located, by default {@code "java.base"}.
     *
     * @return the module name
     */
    String module() default "java.base";
}
