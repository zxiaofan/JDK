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

import java.util.function.Supplier;

/**
 * JFR logger
 *
 */

public final class Logger {

    private final static int MAX_SIZE = 10000;

    public static void log(LogTag logTag, LogLevel logLevel, String message) {
        if (logTag.shouldLog(logLevel.level)) {
            logInternal(logTag, logLevel, message);
        }
    }

    public static void log(LogTag logTag, LogLevel logLevel, Supplier<String> messageSupplier) {
        if (logTag.shouldLog(logLevel.level)) {
            logInternal(logTag, logLevel, messageSupplier.get());
        }
    }

    private static void logInternal(LogTag logTag, LogLevel logLevel, String message) {
        if (message == null || message.length() < MAX_SIZE) {
            JVM.log(logTag.id, logLevel.level, message);
        } else {
            JVM.log(logTag.id, logLevel.level, message.substring(0, MAX_SIZE));
        }
    }
}
