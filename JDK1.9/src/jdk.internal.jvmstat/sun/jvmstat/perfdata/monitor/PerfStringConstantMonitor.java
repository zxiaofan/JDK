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
 * Class for monitoring a constant PerfData String instrument. The
 * value associated with a constant string instrument is fixed at
 * the string instrument's creation time. Its value and length never
 * change.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class PerfStringConstantMonitor extends PerfStringMonitor {

    /**
     * The cached value of the string instrument.
     */
    String data;

    /**
     * Constructor to create a StringMonitor object for the constant string
     * instrument object represented by the data in the given buffer.
     *
     * @param name the name of the instrumentation object
     * @param supported support level indicator
     * @param bb the buffer containing the string instrument data
     */
    public PerfStringConstantMonitor(String name, boolean supported,
                                     ByteBuffer bb) {
        super(name, Variability.CONSTANT, supported, bb);
        this.data = super.stringValue();
    }

    /**
     * {@inheritDoc}
     */
    public Object getValue() {
        return data;        // return the cached string
    }

    /**
     * {@inheritDoc}
     */
    public String stringValue() {
        return data;        // return the cached string
    }
}
