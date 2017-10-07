/*
 * Copyright (c) 2003, 2006, Oracle and/or its affiliates. All rights reserved.
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
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.charset.Charset;

public class PerfStringCounter extends PerfByteArrayCounter
    implements StringCounter {

    private static Charset defaultCharset = Charset.defaultCharset();
    PerfStringCounter(String name, Variability v,
                      int flags, ByteBuffer bb) {
        this(name, v, flags, bb.limit(), bb);
    }

    PerfStringCounter(String name, Variability v, int flags,
                      int maxLength, ByteBuffer bb) {

        super(name, Units.STRING, v, flags, maxLength, bb);
    }

    // override isVector and getVectorLength in ByteArrayCounter
    public boolean isVector() {
        return false;
    }

    public int getVectorLength() {
        return 0;
    }

    public Object getValue() {
        return stringValue();
    }

    public String stringValue() {

        String str = "";
        byte[] b = byteArrayValue();

        if (b == null || b.length <= 1) {
            return str;
        }

        int i;
        for (i = 0; i < b.length && b[i] != (byte)0; i++);

        // convert byte array to string, using all bytes up to, but
        // not including the first null byte.
        return new String(b , 0, i, defaultCharset);
    }

    /**
     * Serialize as a snapshot object.
     */
    protected Object writeReplace() throws java.io.ObjectStreamException {
        return new StringCounterSnapshot(getName(),
                                         getUnits(),
                                         getVariability(),
                                         getFlags(),
                                         stringValue());
    }

    private static final long serialVersionUID = 6802913433363692452L;
}
