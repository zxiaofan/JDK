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

package com.sun.javafx.scene.control;

import sun.util.logging.PlatformLogger;

/**
 * Holds PlatformLoggers to use for logging javafx-ui-controls related things.
 */
public class Logging {

    /**
     * A PlatformLogger to use for logging controls activities.  Created
     * lazily to delay calls to com.sun.javafx.tk.Toolkit.getToolkit() so that
     * it will no intefere with the build. Note, this is no longer true.
     */
    private static PlatformLogger controlsLogger = null;

    /**
     * Returns the PlatformLogger for logging control-related activities.
     */
    public static final PlatformLogger getControlsLogger() {
        if (controlsLogger == null) {
            controlsLogger = PlatformLogger.getLogger("javafx.scene.control");
        }
        return controlsLogger;
    }
}
