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

/**
 * Defines the Management Interface for JDK Flight Recorder.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.management.jfr {
    requires transitive jdk.jfr;
    requires jdk.management;

    requires transitive java.management;

    exports jdk.management.jfr;

    provides sun.management.spi.PlatformMBeanProvider with
        jdk.management.jfr.internal.FlightRecorderMXBeanProvider;
}
