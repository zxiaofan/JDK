/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit;

/**
 * The class reflects the native webkit module.
 */
final class MainThread {

    private static void fwkScheduleDispatchFunctions() {
        Invoker.getInvoker().postOnEventThread(() -> {
            twkScheduleDispatchFunctions();
        });
    }

    private static native void twkScheduleDispatchFunctions();
}
