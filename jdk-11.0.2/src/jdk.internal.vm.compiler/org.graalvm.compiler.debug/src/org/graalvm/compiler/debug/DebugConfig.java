/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.debug;

import java.io.PrintStream;
import java.util.Collection;

import org.graalvm.compiler.debug.DebugContext.Scope;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.meta.JavaMethod;

public interface DebugConfig {

    /**
     * Returns the option values used to configure this object.
     */
    OptionValues getOptions();

    /**
     * Determines the current log level in {@code scope}.
     */
    int getLogLevel(DebugContext.Scope scope);

    /**
     * Determines the current dump level in {@code scope}.
     */
    int getDumpLevel(DebugContext.Scope scope);

    /**
     * Determines if logging is enabled for any {@link JavaMethod} in {@code scope}'s
     * {@linkplain Scope#getCurrentContext() context}.
     */
    boolean isLogEnabledForMethod(DebugContext.Scope scope);

    /**
     * Determines if counting is enabled in {@code scope}.
     *
     * @see DebugContext#counter(CharSequence)
     */
    boolean isCountEnabled(DebugContext.Scope scope);

    /**
     * Determines if memory use tracking is {@code scope}.
     *
     * @see DebugContext#memUseTracker(CharSequence)
     */
    boolean isMemUseTrackingEnabled(DebugContext.Scope scope);

    /**
     * Determines if dumping is enabled for any {@link JavaMethod} in {@code scope}'s
     * {@linkplain Scope#getCurrentContext() context}.
     */
    boolean isDumpEnabledForMethod(DebugContext.Scope scope);

    /**
     * @see DebugContext#isVerifyEnabled()
     */
    boolean isVerifyEnabled(DebugContext.Scope scope);

    /**
     * @see DebugContext#isVerifyEnabledForMethod()
     */
    boolean isVerifyEnabledForMethod(DebugContext.Scope scope);

    /**
     * @see DebugContext#timer(CharSequence)
     */
    boolean isTimeEnabled(DebugContext.Scope scope);

    /**
     * Handles notification of an exception occurring within a debug scope.
     *
     * @return the exception object that is to be propagated to parent scope. A value of
     *         {@code null} indicates that {@code e} is to be propagated.
     */
    RuntimeException interceptException(DebugContext debug, Throwable e);

    /**
     * Gets an unmodifiable view of the dump handlers registered with this configuration.
     */
    Collection<DebugDumpHandler> dumpHandlers();

    /**
     * Gets the {@link PrintStream} for logging.
     */
    PrintStream output();

    /**
     * Gets an unmodifiable view of the verify handlers registered with this configuration.
     */
    Collection<DebugVerifyHandler> verifyHandlers();

    default void closeDumpHandlers(boolean ignoreErrors) {
        for (DebugDumpHandler handler : dumpHandlers()) {
            try {
                handler.close();
            } catch (Throwable e) {
                if (!ignoreErrors) {
                    throw e;
                }
            }
        }
    }

    /**
     * Extracts a {@link JavaMethod} from an opaque debug context.
     *
     * @return the {@link JavaMethod} represented by {@code context} or null
     */
    static JavaMethod asJavaMethod(Object context) {
        if (context instanceof JavaMethodContext) {
            return ((JavaMethodContext) context).asJavaMethod();
        }
        if (context instanceof JavaMethod) {
            return (JavaMethod) context;
        }
        return null;
    }
}
