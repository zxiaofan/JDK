/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.management;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;

/**
 * Platform-specific management interface for a garbage collector
 * which performs collections in cycles.
 *
 * <p> This platform extension is only available to the garbage
 * collection implementation that supports this extension.
 *
 * @author  Mandy Chung
 * @since   1.5
 */
public interface GarbageCollectorMXBean
    extends java.lang.management.GarbageCollectorMXBean {

    /**
     * Returns the GC information about the most recent GC.
     * This method returns a {@link GcInfo}.
     * If no GC information is available, {@code null} is returned.
     * The collector-specific attributes, if any, can be obtained
     * via the {@link CompositeData CompositeData} interface.
     * <p>
     * <b>MBeanServer access:</b>
     * The mapped type of {@code GcInfo} is {@code CompositeData}
     * with attributes specified in {@link GcInfo#from GcInfo}.
     *
     * @return a {@code GcInfo} object representing
     * the most GC information; or {@code null} if no GC
     * information available.
     */
    public GcInfo getLastGcInfo();
}
