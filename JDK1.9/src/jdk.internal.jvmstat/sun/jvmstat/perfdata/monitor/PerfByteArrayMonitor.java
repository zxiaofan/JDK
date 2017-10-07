/*
 * Copyright (c) 2004, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor;

import sun.jvmstat.monitor.*;
import java.nio.ByteBuffer;

/**
 * Class for monitoring a PerfData Byte Array instrumentation object.
 *
 * This class is provided to support the PerfStringMonitor classes.
 * Instrumentation objects of this direct type currently cannot be
 * created or monitored.
 *
 * @author Brian Doherty
 * @since 1.5
 * @see sun.jvmstat.instrument.ByteArrayInstrument
 */
public class PerfByteArrayMonitor extends AbstractMonitor
       implements ByteArrayMonitor {

    /**
     * The buffer containing the data for the byte array instrument.
     */
    ByteBuffer bb;

    /**
     * Constructor to create a ByteArrayMonitor for the byte array instrument
     * represented by the data in the given buffer.
     *
     * @param name the name of the instrumentation object
     * @param u the units of measure attribute
     * @param v the variability attribute
     * @param supported support level indicator
     * @param bb the buffer containing the byte array instrument data
     * @param vectorLength the length of the vector.
     */
    public PerfByteArrayMonitor(String name, Units u, Variability v,
                                boolean supported, ByteBuffer bb,
                                int vectorLength) {
        super(name, u, v, supported, vectorLength);
        this.bb = bb;
    }

    /**
     * {@inheritDoc}
     * The object returned contains a byte[] with a copy of the current
     * elements of the ByteArrayInstrument.
     *
     * @return Object - a copy of the current value of the elements of the
     *                  byte array instrument. The return type is guaranteed
     *                  to be of type byte[].
     */
    public Object getValue() {
        return byteArrayValue();
    }

    /**
     * Get a copy of the elements of the byte array instrument.
     *
     * @return byte[] - a copy of the current value of the elements of the
     *                  byte array instrument.
     */
    public byte[] byteArrayValue() {
        bb.position(0);
        byte[] b = new byte[bb.limit()];

        // copy the bytes
        bb.get(b);

        return b;
    }

    /**
     * Get the current value of an element of the byte array instrument.
     *
     * @return byte - a copy of the current value of the element at index
     *                {@code index} of the byte array instrument.
     */
    public byte byteAt(int index) {
        bb.position(index);
        return bb.get();
    }

    /**
     * Get the maximum length of the byte array for this byte array instrument.
     *
     * @return int - the maximum length of the byte array.
     */
    public int getMaximumLength() {
        return bb.limit();
    }
}
