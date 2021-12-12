/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import java.security.AccessController;

import sun.security.action.GetPropertyAction;

/**
 * Printer allows you to set up global debugging status and print
 * messages accordingly.
 *
 * @author David Rivas
 * @author Kara Kytle
 */
final class Printer {

    static final boolean err = isBuildInternal();

    private static final boolean SHOW_THREADID = true;
    private static final boolean SHOW_TIMESTAMP = true;

    /**
     * Suppresses default constructor, ensuring non-instantiability.
     */
    private Printer() {
    }

    /**
     * This method is used in the special cases which "should never happen...".
     * And in fact if should be implemented as an assertion, but for
     * compatibility reason it just print an error only in case of "internal"
     * build. In time its usage should be replaced by some kind of assertion or
     * dropped completly.
     */
    public static void err(String str) {
        if (err) {
            println(str);
        }
    }

    /**
     * Returns {@code true} if the build of the current jdk is "internal".
     */
    private static boolean isBuildInternal() {
        @SuppressWarnings("removal")
        String javaVersion = AccessController.doPrivileged(
                new GetPropertyAction("java.version"));
        return javaVersion != null && javaVersion.contains("internal");
    }

    private static long startTime = 0;

    private static void println(String s) {
        String prepend = "";
        if (SHOW_THREADID) {
            prepend = "thread "  + Thread.currentThread().getId() + " " + prepend;
        }
        if (SHOW_TIMESTAMP) {
            if (startTime == 0) {
                startTime = System.nanoTime() / 1000000l;
            }
            prepend = prepend + ((System.nanoTime()/1000000l) - startTime) + "millis: ";
        }
        System.out.println(prepend + s);
    }
}
