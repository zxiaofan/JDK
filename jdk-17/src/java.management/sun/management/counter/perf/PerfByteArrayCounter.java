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
import java.nio.*;

public class PerfByteArrayCounter extends AbstractCounter
       implements ByteArrayCounter {

    @SuppressWarnings("serial") // Value indirectly copied as a byte[] in writeReplace
    ByteBuffer bb;

    PerfByteArrayCounter(String name, Units u, Variability v,
                         int flags, int vectorLength,
                         ByteBuffer bb) {

        super(name, u, v, flags, vectorLength);
        this.bb = bb;
    }

    public Object getValue() {
        return byteArrayValue();
    }

    /**
     * Get a copy of the elements of the ByteArrayCounter.
     */
    public byte[] byteArrayValue() {

        bb.position(0);
        byte[] b = new byte[bb.limit()];

        // copy the bytes
        bb.get(b);

        return b;
    }

    /**
     * Get the value of an element of the ByteArrayCounter object.
     */
    public byte byteAt(int index) {
        bb.position(index);
        return bb.get();
    }

    public String toString() {
        String result = getName() + ": " + new String(byteArrayValue()) +
                        " " + getUnits();
        if (isInternal()) {
            return result + " [INTERNAL]";
        } else {
            return result;
        }
    }

    /**
     * Serialize as a snapshot object.
     */
    protected Object writeReplace() throws java.io.ObjectStreamException {
       return new ByteArrayCounterSnapshot(getName(),
                                           getUnits(),
                                           getVariability(),
                                           getFlags(),
                                           getVectorLength(),
                                           byteArrayValue());
    }

    private static final long serialVersionUID = 2545474036937279921L;
}
