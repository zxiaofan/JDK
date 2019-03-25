/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.logger;

import java.util.function.Function;
import sun.util.logging.PlatformLogger;

/**
 * A simple console logger used to emulate the behavior of JUL loggers when
 * java.util.logging has no custom configuration.
 * Surrogate loggers are usually only used temporarily, until the LogManager
 * is initialized. At this point, the surrogates are replaced by an actual
 * logger obtained from LogManager.
 */
public final class SurrogateLogger extends SimpleConsoleLogger {

    private static final PlatformLogger.Level JUL_DEFAULT_LEVEL =
            PlatformLogger.Level.INFO;
    private static volatile String simpleFormatString;

    SurrogateLogger(String name) {
        super(name, true);
    }

    @Override
    PlatformLogger.Level defaultPlatformLevel() {
        return JUL_DEFAULT_LEVEL;
    }

    @Override
    String getSimpleFormatString() {
        if (simpleFormatString == null) {
            simpleFormatString = getSimpleFormat(null);
        }
        return simpleFormatString;
    }

    public static String getSimpleFormat(Function<String, String> defaultPropertyGetter) {
        return Formatting.getSimpleFormat(Formatting.JUL_FORMAT_PROP_KEY, defaultPropertyGetter);
    }

    public static SurrogateLogger makeSurrogateLogger(String name) {
        return new SurrogateLogger(name);
    }

    public static boolean isFilteredFrame(StackWalker.StackFrame st) {
        return Formatting.isFilteredFrame(st);
    }
}
