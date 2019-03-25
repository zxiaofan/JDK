/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Tracks memory usage within a scope using {@link com.sun.management.ThreadMXBean}. This facility
 * should be employed using the try-with-resources pattern:
 *
 * <pre>
 * try (DebugCloseable a = memUseTracker.start()) {
 *     // the code to measure
 * }
 * </pre>
 */
public interface MemUseTrackerKey extends MetricKey {

    /**
     * Creates a point from which memory usage will be recorded if memory use tracking is
     * {@linkplain DebugContext#isMemUseTrackingEnabled() enabled}.
     *
     * @return an object that must be closed once the activity has completed to add the memory used
     *         since this call to the total for this tracker
     */
    DebugCloseable start(DebugContext debug);

    /**
     * Gets the current value of this tracker.
     */
    long getCurrentValue(DebugContext debug);

    @Override
    MemUseTrackerKey doc(String string);

    static long getCurrentThreadAllocatedBytes() {
        return GraalServices.getCurrentThreadAllocatedBytes();
    }
}
