/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.platform;

/*
 * @author bobv
 * @since 11
 */

public class Container {

    private Container() { }

    /**
     * Returns the platform specific Container Metrics class or
     * null if not supported on this platform.
     *
     * @return Metrics instance or null if not supported
     */
    public static Metrics metrics() {
        return Metrics.systemMetrics();
    }
}
