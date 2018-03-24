/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import java.security.AccessController;
import java.security.PrivilegedAction;

class MonocleSettings {

    static final MonocleSettings settings = AccessController.doPrivileged(
            (PrivilegedAction<MonocleSettings>) () -> new MonocleSettings());

    final boolean traceEvents;
    final boolean traceEventsVerbose;
    final boolean tracePlatformConfig;

    private MonocleSettings() {
        traceEventsVerbose = Boolean.getBoolean("monocle.input.traceEvents.verbose");
        traceEvents = traceEventsVerbose || Boolean.getBoolean("monocle.input.traceEvents");
        tracePlatformConfig = Boolean.getBoolean("monocle.platform.traceConfig");
    }

}
