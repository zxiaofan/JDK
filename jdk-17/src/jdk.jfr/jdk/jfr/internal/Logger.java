/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal;

import java.util.Arrays;

/**
 * JFR logger
 *
 */

public final class Logger {

    private static final int MAX_SIZE = 10_000;
    private static final int MAX_EVENT_SIZE = 100_000;
    static {
        // This will try to initialize the JVM logging system
        JVMSupport.tryToInitializeJVM();
    }


    public static void log(LogTag logTag, LogLevel logLevel, String message) {
        if (shouldLog(logTag, logLevel)) {
            logInternal(logTag, logLevel, message);
        }
    }

    public static void logEvent(LogLevel logLevel, String[] lines, boolean system) {
        if (lines == null || lines.length == 0) {
            return;
        }
        if (shouldLog(LogTag.JFR_EVENT, logLevel) || shouldLog(LogTag.JFR_SYSTEM_EVENT, logLevel)) {
            int size = 0;
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                if (size + line.length() > MAX_EVENT_SIZE) {
                    lines = Arrays.copyOf(lines, i + 1);
                    lines[i] = "...";
                    break;
                }
                size+=line.length();
            }
            JVM.logEvent(logLevel.level, lines, system);
        }
    }

    private static void logInternal(LogTag logTag, LogLevel logLevel, String message) {
        if (message == null || message.length() < MAX_SIZE) {
            JVM.log(logTag.id, logLevel.level, message);
        } else {
            JVM.log(logTag.id, logLevel.level, message.substring(0, MAX_SIZE));
        }
    }

    public static boolean shouldLog(LogTag tag, LogLevel level) {
        return level.level >= tag.tagSetLevel;
    }
}
