/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.events;

import jdk.internal.misc.VM.BufferPool;
import jdk.internal.misc.VM;
import jdk.jfr.*;

@Category({ "Java Application", "Statistics" })
public abstract class AbstractBufferStatisticsEvent extends AbstractJDKEvent {

    protected AbstractBufferStatisticsEvent(BufferPool bufferPool) {
        count = bufferPool.getCount();
        totalCapacity = bufferPool.getTotalCapacity();
        memoryUsed = bufferPool.getMemoryUsed();
    }

    @Label("Count")
    final long count;

    @Label("Total Capacity")
    @DataAmount
    final long totalCapacity;

    @Label("Memory Used")
    @DataAmount
    final long memoryUsed;

    static BufferPool findPoolByName(String name) {
        for (BufferPool pool : VM.getBufferPools()) {
            if (pool.getName().equals(name)) {
                return pool;
            }
        }
        throw new InternalError("No buffer pool with name " + name);
    }
}
