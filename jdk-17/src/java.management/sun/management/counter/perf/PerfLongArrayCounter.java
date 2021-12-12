/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.LongBuffer;
import java.nio.ReadOnlyBufferException;

public class PerfLongArrayCounter extends AbstractCounter
       implements LongArrayCounter {


    @SuppressWarnings("serial") // Value indirectly copied as a long[] in writeReplace
    LongBuffer lb;

    PerfLongArrayCounter(String name, Units u, Variability v,
                         int flags, int vectorLength,
                         LongBuffer lb) {

        super(name, u, v, flags, vectorLength);
        this.lb = lb;
    }

    public Object getValue() {
        return longArrayValue();
    }

    /**
     * Get a copy of the elements of the LongArrayCounter.
     */
    public long[] longArrayValue() {

        lb.position(0);
        long[] l = new long[lb.limit()];

        // copy the bytes
        lb.get(l);

        return l;
    }

    /**
     * Get the value of an element of the LongArrayCounter object.
     */
    public long longAt(int index) {
        lb.position(index);
        return lb.get();
    }

    /**
     * Serialize as a snapshot object.
     */
    protected Object writeReplace() throws java.io.ObjectStreamException {
        return new LongArrayCounterSnapshot(getName(),
                                            getUnits(),
                                            getVariability(),
                                            getFlags(),
                                            getVectorLength(),
                                            longArrayValue());
    }

    private static final long serialVersionUID = -2733617913045487126L;
}
