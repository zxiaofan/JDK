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
 * Interface for Monitoring LongInstrument objects.
 *
 * @author Brian Doherty
 * @since 1.5
 * @see sun.jvmstat.instrument.LongInstrument
 */
public interface LongMonitor extends Monitor {

    /**
     * Get the current value of this LongInstrument object.
     *
     * @return long - the current value of the associated LongInstrument object.
     */
    public long longValue();
}
