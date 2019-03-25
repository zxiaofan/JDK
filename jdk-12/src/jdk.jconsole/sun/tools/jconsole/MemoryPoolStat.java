/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole;

import java.lang.management.MemoryUsage;

public class MemoryPoolStat {
    private String      poolName;
    private long        usageThreshold;
    private MemoryUsage usage;
    private long        lastGcId;
    private long        lastGcStartTime;
    private long        lastGcEndTime;
    private long        collectThreshold;
    private MemoryUsage beforeGcUsage;
    private MemoryUsage afterGcUsage;

    MemoryPoolStat(String name,
                   long usageThreshold,
                   MemoryUsage usage,
                   long lastGcId,
                   long lastGcStartTime,
                   long lastGcEndTime,
                   long collectThreshold,
                   MemoryUsage beforeGcUsage,
                   MemoryUsage afterGcUsage) {
        this.poolName = name;
        this.usageThreshold = usageThreshold;
        this.usage = usage;
        this.lastGcId = lastGcId;
        this.lastGcStartTime = lastGcStartTime;
        this.lastGcEndTime = lastGcEndTime;
        this.collectThreshold = collectThreshold;
        this.beforeGcUsage = beforeGcUsage;
        this.afterGcUsage = afterGcUsage;
    }

    /**
     * Returns the memory pool name.
     */
    public String getPoolName() {
        return poolName;
    }

    /**
     * Returns the current memory usage.
     */
    public MemoryUsage getUsage() {
        return usage;
    }

    /**
     * Returns the current usage threshold.
     * -1 if not supported.
     */
    public long getUsageThreshold() {
        return usageThreshold;
    }

    /**
     * Returns the current collection usage threshold.
     * -1 if not supported.
     */
    public long getCollectionUsageThreshold() {
        return collectThreshold;
    }

    /**
     * Returns the Id of GC.
     */
    public long getLastGcId() {
        return lastGcId;
    }


    /**
     * Returns the start time of the most recent GC on
     * the memory pool for this statistics in milliseconds.
     *
     * Return 0 if no GC occurs.
     */
    public long getLastGcStartTime() {
        return lastGcStartTime;
    }

    /**
     * Returns the end time of the most recent GC on
     * the memory pool for this statistics in milliseconds.
     *
     * Return 0 if no GC occurs.
     */
    public long getLastGcEndTime() {
        return lastGcEndTime;
    }

    /**
     * Returns the memory usage before the most recent GC started.
     * null if no GC occurs.
     */
    public MemoryUsage getBeforeGcUsage() {
        return beforeGcUsage;
    }

    /**
     * Returns the memory usage after the most recent GC finished.
     * null if no GC occurs.
     */
    public MemoryUsage getAfterGcUsage() {
        return afterGcUsage;
    }
}
