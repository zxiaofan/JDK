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
 * Interface for Monitoring ByteArrayInstrument objects.
 *
 * This interface is provided to support the StringMonitor interface. No
 * instrumentation objects of this direct type can currently be created
 * or monitored.
 *
 * @author Brian Doherty
 * @since 1.5
 * @see sun.jvmstat.instrument.ByteArrayInstrument
 */
public interface ByteArrayMonitor extends Monitor {

    /**
     * Get a copy of the current values of the elements of the
     * ByteArrayInstrument object.
     *
     * @return byte[] - a copy of the bytes in the associated
     *                  instrumenattion object.
     */
    public byte[] byteArrayValue();

    /**
     * Get the current value of an element of the ByteArrayInstrument object.
     *
     * @return byte - the byte value at the specified index in the
     *                associated instrumentation object.
     */
    public byte byteAt(int index);
}
