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
 * Event field annotation, specifies that the value is a point in time.
 *
 * @since 9
 */
@MetadataDefinition
@ContentType
@Label("Timestamp")
@Description("A point in time")
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Timestamp {
    /**
     * The unit for the difference, measured in milliseconds, between the current
     * time and midnight, January 1, 1970 UTC.
     */
    public static final String MILLISECONDS_SINCE_EPOCH = "MILLISECONDS_SINCE_EPOCH";

    /**
     * The unit for the number of ticks that have transpired since some arbitrary
     * starting date.
     */
    public static final String TICKS = "TICKS";

    /**
     * Unit for the time stamp.
     *
     * @return time stamp unit, not {@code null}
     */
    String value() default Timestamp.MILLISECONDS_SINCE_EPOCH;
}
