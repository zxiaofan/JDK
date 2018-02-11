/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;
import java.util.HashMap;
import sun.management.counter.Counter;


/**
 * Implementation class of HotspotThreadMBean interface.
 *
 * Internal, uncommitted management interface for Hotspot threading
 * system.
 */
class HotspotThread
    implements HotspotThreadMBean {

    private VMManagement jvm;

    /**
     * Constructor of HotspotThread class.
     */
    HotspotThread(VMManagement vm) {
        jvm = vm;
    }

    public native int getInternalThreadCount();

    public Map<String, Long> getInternalThreadCpuTimes() {
        int count = getInternalThreadCount();
        if (count == 0) {
            return java.util.Collections.emptyMap();
        }
        String[] names = new String[count];
        long[] times = new long[count];
        int numThreads = getInternalThreadTimes0(names, times);
        Map<String, Long> result = new HashMap<>(numThreads);
        for (int i = 0; i < numThreads; i++) {
            result.put(names[i], times[i]);
        }
        return result;
    }
    public native int getInternalThreadTimes0(String[] names, long[] times);

    // Performance counter support
    private static final String JAVA_THREADS    = "java.threads.";
    private static final String COM_SUN_THREADS = "com.sun.threads.";
    private static final String SUN_THREADS     = "sun.threads.";
    private static final String THREADS_COUNTER_NAME_PATTERN =
        JAVA_THREADS + "|" + COM_SUN_THREADS + "|" + SUN_THREADS;

    public java.util.List<Counter> getInternalThreadingCounters() {
        return jvm.getInternalCounters(THREADS_COUNTER_NAME_PATTERN);
    }
}
