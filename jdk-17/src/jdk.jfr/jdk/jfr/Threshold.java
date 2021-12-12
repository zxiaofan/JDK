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
 * Event annotation, specifies the default duration below which an event is not
 * recorded (for example, {@code "20 ms"}).
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Threshold {
    /**
     * Setting name {@code "threshold"} for configuring event thresholds.
     */
    public static final String NAME = "threshold";

    /**
     * The threshold (for example, {@code "20 ms"}).
     * <p>
     * A {@code String} representation of a positive {@code Long} value followed by an
     * empty space and one of the following units:<br>
     * <br>
     * {@code "ns"} (nanoseconds)<br>
     * {@code "us"} (microseconds)<br>
     * {@code "ms"} (milliseconds)<br>
     * {@code "s"} (seconds)<br>
     * {@code "m"} (minutes)<br>
     * {@code "h"} (hours)<br>
     * {@code "d"} (days)<br>
     * <p>
     * Example values are {@code "0 ns"}, {@code "10 ms"}, and {@code "1 s"}.
     *
     * @return the threshold, default {@code "0 ns"}, not {@code null}
     */
    String value() default "0 ns";
}
