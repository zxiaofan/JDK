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

package jdk.jfr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event annotation, specifies the default setting value for a periodic event.
 *
 * @since 9
 */
@MetadataDefinition
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface Period {
    /**
     * Settings name {@code "period"} for configuring periodic events
     */
    public static final String NAME = "period";

    /**
     * Returns the default setting value for a periodic setting.
     * <p>
     * String representation of a positive {@code Long} value followed by an empty
     * space and one of the following units:<br>
     * <br>
     * {@code "ns"} (nanoseconds)<br>
     * {@code "us"} (microseconds)<br>
     * {@code "ms"} (milliseconds)<br>
     * {@code "s"} (seconds)<br>
     * {@code "m"} (minutes)<br>
     * {@code "h"} (hours)<br>
     * {@code "d"} (days)<br>
     * <p>
     * Example values: {@code "0 ns"}, {@code "10 ms"}, and {@code "1 s"}.
     * <p>
     * A period may also be {@code "everyChunk"} to specify that it occurs at
     * least once for every recording file. The number of events that are emitted
     * depends on how many times the file rotations occur when data is recorded.
     *
     * @return the default setting value, not {@code null}
     */
    String value() default "everyChunk";
}
