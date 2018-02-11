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
import java.nio.LongBuffer;

/**
 * Class for monitoring a PerfData Long instrument.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class PerfLongMonitor extends AbstractMonitor implements LongMonitor {

    /**
     * The buffer containing the data for the long instrument.
     */
    LongBuffer lb;

    /**
     * Constructor to create a LongMonitor object for the long instrument
     * represented by the data in the given buffer.
     *
     * @param name the name of the long instrument
     * @param u the units of measure attribute
     * @param v the variability attribute
     * @param supported support level indicator
     * @param lb the buffer containing the long instrument data.
     */
    public PerfLongMonitor(String name, Units u, Variability v,
                           boolean supported, LongBuffer lb) {
        super(name, u, v, supported);
        this.lb = lb;
    }

    /**
     * {@inheritDoc}
     * The object returned contains a Long object containing the
     * current value of the LongInstrument.
     *
     * @return Object - the current value of the LongInstrument. The
     *                  return type is guaranteed to be of type Long.
     */
    public Object getValue() {
        return Long.valueOf(lb.get(0));
    }

    /**
     * Return the current value of the LongInstrument as an long.
     *
     * @return long - the current value of the LongInstrument
     */
    public long longValue() {
        return lb.get(0);
    }
}
