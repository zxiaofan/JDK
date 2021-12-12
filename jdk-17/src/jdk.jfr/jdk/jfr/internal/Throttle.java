/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, Datadog, Inc. All rights reserved.
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
 * Event annotation, determines the event emission rate in events per time unit.
 *
 * This setting is only supported for JVM events.
 *
 * @since 16
 */
@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Throttle {
    /**
     * Settings name {@code "throttle"} for configuring an event emission rate in events per time unit.
     */
    public static final String NAME = "throttle";
    public static final String DEFAULT = "off";

    /**
     * Throttle, for example {@code "100/s"}.
     * <p>
     * String representation of a non-negative {@code Long} value followed by a slash ("/")
     * and one of the following units<br>
     * {@code "ns"} (nanoseconds)<br>
     * {@code "us"} (microseconds)<br>
     * {@code "ms"} (milliseconds)<br>
     * {@code "s"} (seconds)<br>
     * {@code "m"} (minutes)<br>
     * {@code "h"} (hours)<br>
     * {@code "d"} (days)<br>
     * <p>
     * Example values, {@code "6000/m"}, {@code "10/ms"} and {@code "200/s"}.
     * When zero is specified, for example {@code "0/s"}, no events are emitted.
     * When {@code "off"} is specified, all events are emitted.
     *
     * @return the throttle value, default {@code "off"} not {@code null}
     *
     */
    String value() default DEFAULT;
}
