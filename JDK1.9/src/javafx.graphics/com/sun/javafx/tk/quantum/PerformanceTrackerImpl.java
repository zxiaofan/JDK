/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.perf.PerformanceTracker;

/**
 * Class containing implementation for logging, and performance tracking.
 */
final class PerformanceTrackerImpl extends PerformanceTracker {

    final PerformanceTrackerHelper helper =
            PerformanceTrackerHelper.getInstance();

    public PerformanceTrackerImpl() {
       setPerfLoggingEnabled(helper.isPerfLoggingEnabled());
    }

    @Override public void doLogEvent(String s) {
        helper.logEvent(s);
    }

    @Override public void doOutputLog() {
        helper.outputLog();
    }

    @Override public long nanoTime() {
        return helper.nanoTime();
    }
}
