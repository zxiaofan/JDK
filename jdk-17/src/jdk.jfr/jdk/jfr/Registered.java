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
 * Event annotation, for programmatic event registration.
 * <p>
 * Events are automatically registered when they are first used. This annotation
 * can be used to override that registration. To register
 * events programmatically, use {@link FlightRecorder#register(Class)}.
 *
 * @since 9
 */
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Registered {
    /**
     * Returns {@code true} if the event is to be registered when the event class is
     * first used, {@code false} otherwise.
     *
     * @return {@code true} if the event is to be registered when the event class is
     *         first used, {@code false} otherwise.
     */
    public boolean value() default true;
}
