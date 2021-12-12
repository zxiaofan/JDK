/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.instrument;

import java.util.concurrent.atomic.AtomicLong;

import jdk.jfr.events.Handlers;
import jdk.jfr.internal.handlers.EventHandler;

public final class ThrowableTracer {

    private static final AtomicLong numThrowables = new AtomicLong();

    public static void traceError(Error e, String message) {
        if (e instanceof OutOfMemoryError) {
            return;
        }
        long timestamp = EventHandler.timestamp();

        EventHandler h1 = Handlers.ERROR_THROWN;
        if (h1.isEnabled()) {
            h1.write(timestamp, 0L, message, e.getClass());
        }
        EventHandler h2 = Handlers.EXCEPTION_THROWN;
        if (h2.isEnabled()) {
            h2.write(timestamp, 0L, message, e.getClass());
        }
        numThrowables.incrementAndGet();
    }

    public static void traceThrowable(Throwable t, String message) {
        EventHandler h = Handlers.EXCEPTION_THROWN;
        if (h.isEnabled()) {
            long timestamp = EventHandler.timestamp();
            h.write(timestamp, 0L, message, t.getClass());
        }
        numThrowables.incrementAndGet();
    }

    public static long numThrowables() {
        return numThrowables.get();
    }
}
