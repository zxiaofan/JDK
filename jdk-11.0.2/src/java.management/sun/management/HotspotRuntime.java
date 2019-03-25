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

import java.util.List;
import java.util.ArrayList;
import sun.management.counter.Counter;


/**
 * Implementation class of HotspotRuntimeMBean interface.
 *
 * Internal, uncommitted management interface for Hotspot runtime
 * system.
 */
class HotspotRuntime
    implements HotspotRuntimeMBean {

    private VMManagement jvm;

    /**
     * Constructor of HotspotRuntime class.
     */
    HotspotRuntime(VMManagement vm) {
        jvm = vm;
    }

    public long getSafepointCount() {
        return jvm.getSafepointCount();
    }

    public long getTotalSafepointTime() {
        return jvm.getTotalSafepointTime();
    }

    public long getSafepointSyncTime() {
        return jvm.getSafepointSyncTime();
    }

    // Performance counter support
    private static final String JAVA_RT          = "java.rt.";
    private static final String COM_SUN_RT       = "com.sun.rt.";
    private static final String SUN_RT           = "sun.rt.";
    private static final String JAVA_PROPERTY    = "java.property.";
    private static final String COM_SUN_PROPERTY = "com.sun.property.";
    private static final String SUN_PROPERTY     = "sun.property.";
    private static final String RT_COUNTER_NAME_PATTERN =
        JAVA_RT + "|" + COM_SUN_RT + "|" + SUN_RT + "|" +
        JAVA_PROPERTY + "|" + COM_SUN_PROPERTY + "|" + SUN_PROPERTY;

    public java.util.List<Counter> getInternalRuntimeCounters() {
        return jvm.getInternalCounters(RT_COUNTER_NAME_PATTERN);
    }
}
