/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.management.counter.perf;

import sun.management.counter.*;

/**
 * A snapshot of the perf counter for serialization.
 */
class LongCounterSnapshot extends AbstractCounter
       implements LongCounter {

    long value;

    // package private
    LongCounterSnapshot(String name, Units u, Variability v, int flags,
                        long value) {
        super(name, u, v, flags);
        this.value = value;
    }

    public Object getValue() {
        return Long.valueOf(value);
    }

    /**
     * Get the value of this Long performance counter
     */
    public long longValue() {
        return value;
    }

    private static final long serialVersionUID = 2054263861474565758L;
}
