/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.debug;

import org.graalvm.compiler.serviceprovider.GraalServices;

/**
 * A consistent source of timing data that should be used by all facilities in the debug package.
 */
public class TimeSource {
    private static final boolean USING_THREAD_CPU_TIME = GraalServices.isCurrentThreadCpuTimeSupported();

    /**
     * Gets the current time of this thread in nanoseconds from the most accurate timer available on
     * the system. The returned value will be the current time in nanoseconds precision but not
     * necessarily nanoseconds accuracy.
     * <p>
     * The intended use case of this method is to measure the time a certain action takes by making
     * successive calls to it. It should not be used to measure total times in the sense of a time
     * stamp.
     *
     * @return the current thread's time in nanoseconds
     */
    public static long getTimeNS() {
        return USING_THREAD_CPU_TIME ? GraalServices.getCurrentThreadCpuTime() : System.nanoTime();
    }

}
