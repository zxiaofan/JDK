/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.management.internal;

import com.sun.management.OperatingSystemMXBean;
import sun.management.BaseOperatingSystemImpl;
import sun.management.VMManagement;

/**
 * Implementation class for the operating system.
 * Standard and committed hotspot-specific metrics if any.
 *
 * ManagementFactory.getOperatingSystemMXBean() returns an instance
 * of this class.
 */
class OperatingSystemImpl extends BaseOperatingSystemImpl
    implements OperatingSystemMXBean {

    // psapiLock is a lock to make sure only one thread loading
    // PSAPI DLL.
    private static Object psapiLock = new Object();

    OperatingSystemImpl(VMManagement vm) {
        super(vm);
    }

    @Override
    public long getCommittedVirtualMemorySize() {
        synchronized (psapiLock) {
            return getCommittedVirtualMemorySize0();
        }
    }

    @Override
    public long getTotalSwapSpaceSize() {
        return getTotalSwapSpaceSize0();
    }

    @Override
    public long getFreeSwapSpaceSize() {
        return getFreeSwapSpaceSize0();
    }

    @Override
    public long getProcessCpuTime() {
        return getProcessCpuTime0();
    }

    @Override
    public long getFreeMemorySize() {
        return getFreeMemorySize0();
    }

    @Override
    public long getTotalMemorySize() {
        return getTotalMemorySize0();
    }

    @Override
    public double getCpuLoad() {
        return getCpuLoad0();
    }

    @Override
    public double getProcessCpuLoad() {
        return getProcessCpuLoad0();
    }

    /* native methods */
    private native long getCommittedVirtualMemorySize0();
    private native long getFreeMemorySize0();
    private native long getFreeSwapSpaceSize0();
    private native double getProcessCpuLoad0();
    private native long getProcessCpuTime0();
    private native double getCpuLoad0();
    private native long getTotalMemorySize0();
    private native long getTotalSwapSpaceSize0();

    static {
        initialize0();
    }

    private static native void initialize0();
}
