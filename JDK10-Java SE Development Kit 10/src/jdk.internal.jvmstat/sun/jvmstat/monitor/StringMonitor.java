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

package sun.jvmstat.monitor;

/**
 * Interface for Monitoring StringInstrument objects.
 *
 * @author Brian Doherty
 * @since 1.5
 * @see sun.jvmstat.instrument.StringInstrument
 */
public interface StringMonitor extends Monitor {

    /**
     * Get a copy of the current value of the StringInstrument object.
     *
     * @return String - a String object containing a copy of the value of
     *                  the associated StringInstrument.
     */
    public String stringValue();
}
