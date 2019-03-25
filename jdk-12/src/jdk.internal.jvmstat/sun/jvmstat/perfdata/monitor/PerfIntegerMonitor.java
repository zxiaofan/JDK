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
import java.nio.IntBuffer;

/**
 * Class for monitoring a PerfData Integer instrument.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class PerfIntegerMonitor extends AbstractMonitor
                                implements IntegerMonitor {

    /**
     * The buffer containing the data for the integer instrument.
     */
    IntBuffer ib;

    /**
     * Constructor to create an IntegerMonitor object for the integer
     *  instrument represented by the data in the given buffer.
     *
     * @param name the name of the integer instrument
     * @param u the units of measure attribute
     * @param v the variability attribute
     * @param supported support level indicator
     * @param ib the buffer containing the integer instrument data.
     */
    public PerfIntegerMonitor(String name, Units u, Variability v,
                              boolean supported, IntBuffer ib) {
        super(name, u, v, supported);
        this.ib = ib;
    }

    /**
     * {@inheritDoc}
     * The object returned contains an Integer object containing the
     * current value of the IntegerInstrument.
     *
     * @return Object - the current value of the IntegerInstrument. The
     *                   return type is guaranteed to be of type Integer.
     */
    public Object getValue() {
        return ib.get(0);
    }

    /**
     * Return the current value of the IntegerInstrument as an int.
     *
     * @return int - a the current value of the IntegerInstrument.
     */
    public int intValue() {
        return ib.get(0);
    }
}
