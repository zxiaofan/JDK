/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.binding;

import sun.util.logging.PlatformLogger;

public class Logging {

    private static class LoggerHolder {
        private static final PlatformLogger INSTANCE = PlatformLogger.getLogger("javafx.beans");
    }

    public static PlatformLogger getLogger() {
        return LoggerHolder.INSTANCE;
    }
}
