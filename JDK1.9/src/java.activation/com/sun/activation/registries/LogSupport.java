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

package com.sun.activation.registries;

import java.io.*;
import java.util.logging.*;

/**
 * Logging related methods.
 */
public class LogSupport {
    private static boolean debug = false;
    private static Logger logger;
    private static final Level level = Level.FINE;

    static {
        try {
            debug = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable t) {
            // ignore any errors
        }
        logger = Logger.getLogger("javax.activation");
    }

    /**
     * Constructor.
     */
    private LogSupport() {
        // private constructor, can't create instances
    }

    public static void log(String msg) {
        if (debug)
            System.out.println(msg);
        logger.log(level, msg);
    }

    public static void log(String msg, Throwable t) {
        if (debug)
            System.out.println(msg + "; Exception: " + t);
        logger.log(level, msg, t);
    }

    public static boolean isLoggable() {
        return debug || logger.isLoggable(level);
    }
}
