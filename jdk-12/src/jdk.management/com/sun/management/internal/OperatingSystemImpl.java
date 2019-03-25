/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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
    implements com.sun.management.UnixOperatingSystemMXBean {

    OperatingSystemImpl(VMManagement vm) {
        super(vm);
    }

    public long getCommittedVirtualMemorySize() {
        return getCommittedVirtualMemorySize0();
    }

    public long getTotalSwapSpaceSize() {
        return getTotalSwapSpaceSize0();
    }

    public long getFreeSwapSpaceSize() {
        return getFreeSwapSpaceSize0();
    }

    public long getProcessCpuTime() {
        return getProcessCpuTime0();
    }

    public long getFreePhysicalMemorySize() {
        return getFreePhysicalMemorySize0();
    }

    public long getTotalPhysicalMemorySize() {
        return getTotalPhysicalMemorySize0();
    }

    public long getOpenFileDescriptorCount() {
        return getOpenFileDescriptorCount0();
    }

    public long getMaxFileDescriptorCount() {
        return getMaxFileDescriptorCount0();
    }

    public double getSystemCpuLoad() {
        return getSystemCpuLoad0();
    }

    public double getProcessCpuLoad() {
        return getProcessCpuLoad0();
    }

    /* native methods */
    private native long getCommittedVirtualMemorySize0();
    private native long getFreePhysicalMemorySize0();
    private native long getFreeSwapSpaceSize0();
    private native long getMaxFileDescriptorCount0();
    private native long getOpenFileDescriptorCount0();
    private native long getProcessCpuTime0();
    private native double getProcessCpuLoad0();
    private native double getSystemCpuLoad0();
    private native long getTotalPhysicalMemorySize0();
    private native long getTotalSwapSpaceSize0();

    static {
        initialize0();
    }

    private static native void initialize0();
}
