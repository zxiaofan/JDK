/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

import jdk.jfr.events.ErrorThrownEvent;
import jdk.jfr.events.ExceptionThrownEvent;

public final class ThrowableTracer {

    private static AtomicLong numThrowables = new AtomicLong(0);

    public static void traceError(Error e, String message) {
        if (e instanceof OutOfMemoryError) {
            return;
        }
        ErrorThrownEvent errorEvent = new ErrorThrownEvent();
        errorEvent.message = message;
        errorEvent.thrownClass = e.getClass();
        errorEvent.commit();

        ExceptionThrownEvent exceptionEvent = new ExceptionThrownEvent();
        exceptionEvent.message = message;
        exceptionEvent.thrownClass = e.getClass();
        exceptionEvent.commit();
        numThrowables.incrementAndGet();
    }

    public static void traceThrowable(Throwable t, String message) {
        ExceptionThrownEvent event = new ExceptionThrownEvent();
        event.message = message;
        event.thrownClass = t.getClass();
        event.commit();
        numThrowables.incrementAndGet();
    }

    public static long numThrowables() {
        return numThrowables.get();
    }
}
