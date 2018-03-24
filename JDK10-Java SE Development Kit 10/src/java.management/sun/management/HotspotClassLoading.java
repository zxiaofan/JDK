/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

import sun.management.counter.*;

/**
 * Implementation class of HotspotClassLoadingMBean interface.
 *
 * Internal, uncommitted management interface for Hotspot class loading
 * system.
 */
class HotspotClassLoading
    implements HotspotClassLoadingMBean {

    private VMManagement jvm;

    /**
     * Constructor of HotspotClassLoading class.
     */
    HotspotClassLoading(VMManagement vm) {
        jvm = vm;
    }

    public long getLoadedClassSize() {
        return jvm.getLoadedClassSize();
    }

    public long getUnloadedClassSize() {
        return jvm.getUnloadedClassSize();
    }

    public long getClassLoadingTime() {
        return jvm.getClassLoadingTime();
    }

    public long getMethodDataSize() {
        return jvm.getMethodDataSize();
    }

    public long getInitializedClassCount() {
        return jvm.getInitializedClassCount();
    }

    public long getClassInitializationTime() {
        return jvm.getClassInitializationTime();
    }

    public long getClassVerificationTime() {
        return jvm.getClassVerificationTime();
    }

    // Performance counter support
    private static final String JAVA_CLS    = "java.cls.";
    private static final String COM_SUN_CLS = "com.sun.cls.";
    private static final String SUN_CLS     = "sun.cls.";
    private static final String CLS_COUNTER_NAME_PATTERN =
        JAVA_CLS + "|" + COM_SUN_CLS + "|" + SUN_CLS;

    public java.util.List<Counter> getInternalClassLoadingCounters() {
        return jvm.getInternalCounters(CLS_COUNTER_NAME_PATTERN);
    }
}
