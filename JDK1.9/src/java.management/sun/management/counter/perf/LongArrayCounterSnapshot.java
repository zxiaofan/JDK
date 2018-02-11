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
class LongArrayCounterSnapshot extends AbstractCounter
       implements LongArrayCounter {

    long[] value;

    // package private
    LongArrayCounterSnapshot(String name, Units u, Variability v, int flags,
                             int vectorLength, long[] value) {
        super(name, u, v, flags, vectorLength);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public long[] longArrayValue() {
        return value;
    }

    public long longAt(int index) {
        return value[index];
    }

    private static final long serialVersionUID = 3585870271405924292L;
}
