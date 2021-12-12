/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jdk.jfr.MetadataDefinition;

/**
 * Event annotation, determines the cutoff above which an event should not be
 * recorded, i.e. {@code "20 ms"}.
 *
 * This settings is only supported for JVM events.
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Cutoff {
    /**
     * Settings name {@code "cutoff"} for configuring event cutoffs.
     */
    public static final String NAME = "cutoff";
    public static final String INFINITY = "infinity";

    /**
     * Cutoff, for example {@code "20 ms"}.
     * <p>
     * String representation of a positive {@code Long} value followed by an empty
     * space and one of the following units<br>
     * <br>
     * {@code "ns"} (nanoseconds)<br>
     * {@code "us"} (microseconds)<br>
     * {@code "ms"} (milliseconds)<br>
     * {@code "s"} (seconds)<br>
     * {@code "m"} (minutes)<br>
     * {@code "h"} (hours)<br>
     * {@code "d"} (days)<br>
     * <p>
     * Example values, {@code "0 ns"}, {@code "10 ms"} and {@code "1 s"}. If the
     * events has an infinite timespan, the text {@code "infinity"} should be used.
     *
     * @return the threshold, default {@code "0 ns"} not {@code null}
     */
    String value() default "infinity";
}
