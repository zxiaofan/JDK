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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event field annotation, specifies that the value is a duration.
 *
 * @since 9
 */
@MetadataDefinition
@ContentType
@Label("Timespan")
@Description("A duration, measured in nanoseconds by default")
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Timespan {
    /**
     * Unit for ticks.
     */
    public static final String TICKS = "TICKS";
    /**
     * Unit for seconds.
     */
    public static final String SECONDS = "SECONDS";
    /**
     * Unit for milliseconds.
     */
    public static final String MILLISECONDS = "MILLISECONDS";
    /**
     * Unit for nanoseconds.
     */
    public static final String NANOSECONDS = "NANOSECONDS";

    /**
     * Unit for microseconds.
     */
    public static final String MICROSECONDS = "MICROSECONDS";

    /**
     * Returns the unit of measure for the time span.
     * <p>
     * By default, the unit is nanoseconds.
     *
     * @return the time span unit, default {@link #NANOSECONDS}, not {@code null}
     */
    String value() default NANOSECONDS;
}
