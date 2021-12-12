/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.management.ThreadMXBean;
import sun.management.ManagementFactoryHelper;
import sun.management.ThreadImpl;
import sun.management.VMManagement;

/**
 *
 */
public class HotSpotThreadImpl extends ThreadImpl implements ThreadMXBean {
    public HotSpotThreadImpl(VMManagement vm) {
        super(ManagementFactoryHelper.getVMManagement());
    }

    @Override
    public boolean isThreadAllocatedMemorySupported() {
        return super.isThreadAllocatedMemorySupported();
    }

    @Override
    public boolean isThreadAllocatedMemoryEnabled() {
        return super.isThreadAllocatedMemoryEnabled();
    }

    @Override
    public long[] getThreadCpuTime(long[] ids) {
        return super.getThreadCpuTime(ids);
    }

    @Override
    public long[] getThreadUserTime(long[] ids) {
        return super.getThreadUserTime(ids);
    }

    @Override
    public long getCurrentThreadAllocatedBytes() {
        return super.getCurrentThreadAllocatedBytes();
    }

    @Override
    public long getThreadAllocatedBytes(long id) {
        return super.getThreadAllocatedBytes(id);
    }

    @Override
    public long[] getThreadAllocatedBytes(long[] ids) {
        return super.getThreadAllocatedBytes(ids);
    }

    @Override
    public void setThreadAllocatedMemoryEnabled(boolean enable) {
        super.setThreadAllocatedMemoryEnabled(enable);
    }
}
