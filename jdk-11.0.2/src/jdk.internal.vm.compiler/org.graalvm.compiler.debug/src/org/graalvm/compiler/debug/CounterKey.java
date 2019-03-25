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

/**
 * A counter for some value of interest.
 */
public interface CounterKey extends MetricKey {

    /**
     * Adds 1 to this counter.
     */
    void increment(DebugContext debug);

    /**
     * Adds {@code value} to this counter.
     */
    void add(DebugContext debug, long value);

    /**
     * Gets the current value of this counter.
     */
    long getCurrentValue(DebugContext debug);

    /**
     * Determines if this counter is enabled.
     */
    boolean isEnabled(DebugContext debug);

    @Override
    CounterKey doc(String string);
}
