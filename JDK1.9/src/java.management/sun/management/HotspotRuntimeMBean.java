/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
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
 * Hotspot internal management interface for the runtime system.
 *
 * This management interface is internal and uncommitted
 * and subject to change without notice.
 */
public interface HotspotRuntimeMBean {

    /**
     * Returns the number of safepoints taken place since the Java
     * virtual machine started.
     *
     * @return the number of safepoints taken place since the Java
     * virtual machine started.
     */
    public long getSafepointCount();

    /**
     * Returns the accumulated time spent at safepoints in milliseconds.
     * This is the accumulated elapsed time that the application has
     * been stopped for safepoint operations.
     *
     * @return the accumulated time spent at safepoints in milliseconds.
     */
    public long getTotalSafepointTime();

    /**
     * Returns the accumulated time spent getting to safepoints in milliseconds.
     *
     * @return the accumulated time spent getting to safepoints in milliseconds.
     */
    public long getSafepointSyncTime();

    /**
     * Returns a list of internal counters maintained in the Java
     * virtual machine for the runtime system.
     *
     * @return a {@code List} of internal counters maintained in the VM
     * for the runtime system.
     */
    public java.util.List<Counter> getInternalRuntimeCounters();
}
