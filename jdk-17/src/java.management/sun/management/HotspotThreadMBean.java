/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import sun.management.counter.Counter;

/**
 * Hotspot internal management interface for the thread system.
 */
public interface HotspotThreadMBean {

    /**
     * Returns the current number of VM internal threads.
     *
     * @return the current number of VM internal threads.
     */
    public int getInternalThreadCount();

    /**
     * Returns a {@code Map} of the name of all VM internal threads
     * to the thread CPU time in nanoseconds.  The returned value is
     * of nanoseconds precision but not necessarily nanoseconds accuracy.
     *
     * @return a {@code Map} object of the name of all VM internal threads
     * to the thread CPU time in nanoseconds.
     *
     * @throws java.lang.UnsupportedOperationException if the Java virtual
     * machine does not support CPU time measurement.
     *
     * @see java.lang.management.ThreadMXBean#isThreadCpuTimeSupported
     */
    public java.util.Map<String,Long> getInternalThreadCpuTimes();

    /**
     * Returns a list of internal counters maintained in the Java
     * virtual machine for the thread system.
     *
     * @return a list of internal counters maintained in the VM
     * for the thread system.
     */
    public java.util.List<Counter> getInternalThreadingCounters();
}
