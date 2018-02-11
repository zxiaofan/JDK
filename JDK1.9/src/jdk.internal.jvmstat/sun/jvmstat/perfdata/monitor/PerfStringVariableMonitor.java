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
 *
 * Class for monitoring a variable PerfData String instrument.
 * The current value of a variable string instrument changes over time.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class PerfStringVariableMonitor extends PerfStringMonitor {

    /**
     * Constructor to create a StringMonitor object for the variable string
     * instrument represented by the data in the given buffer.
     *
     * @param name the name of the string instrument
     * @param supported support level indicator
     * @param bb the buffer containing the string instrument data.
     */
    public PerfStringVariableMonitor(String name, boolean supported,
                                     ByteBuffer bb) {
        this(name, supported, bb, bb.limit());
    }

    /**
     * Constructor to create a StringMonitor object for the variable
     * string instrument represented by the data in the given buffer.
     *
     * @param name the name of the string instrument
     * @param bb the buffer containing the string instrument data.
     * @param supported support level indicator
     * @param maxLength the maximum length of the string data.
     */
    public PerfStringVariableMonitor(String name, boolean supported,
                                     ByteBuffer bb, int maxLength) {
        // account for the null terminator by adding 1 to maxLength
        super(name, Variability.VARIABLE, supported, bb, maxLength+1);
    }
}
