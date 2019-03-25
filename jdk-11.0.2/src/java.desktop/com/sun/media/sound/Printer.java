/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Printer allows you to set up global debugging status and print
 * messages accordingly.
 *
 * @author David Rivas
 * @author Kara Kytle
 */
final class Printer {

    static final boolean err = false;
    static final boolean debug = false;
    static final boolean trace = false;
    static final boolean verbose = false;
    static final boolean release = false;

    static final boolean SHOW_THREADID = false;
    static final boolean SHOW_TIMESTAMP = false;

    /*static void setErrorPrint(boolean on) {

      err = on;
      }

      static void setDebugPrint(boolean on) {

      debug = on;
      }

      static void setTracePrint(boolean on) {

      trace = on;
      }

      static void setVerbosePrint(boolean on) {

      verbose = on;
      }

      static void setReleasePrint(boolean on) {

      release = on;
      }*/

    /**
     * Suppresses default constructor, ensuring non-instantiability.
     */
    private Printer() {
    }

    public static void err(String str) {

        if (err)
            println(str);
    }

    public static void debug(String str) {

        if (debug)
            println(str);
    }

    public static void trace(String str) {

        if (trace)
            println(str);
    }

    public static void verbose(String str) {

        if (verbose)
            println(str);
    }

    public static void release(String str) {

        if (release)
            println(str);
    }

    private static long startTime = 0;

    public static void println(String s) {
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

    public static void println() {
        System.out.println();
    }

}
