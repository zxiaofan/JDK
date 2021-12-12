/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the API for JDK Flight Recorder.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jfr {
    exports jdk.jfr;
    exports jdk.jfr.consumer;

    exports jdk.jfr.internal.management to jdk.management.jfr;
}
