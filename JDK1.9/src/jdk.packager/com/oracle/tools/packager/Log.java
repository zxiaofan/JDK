/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.tools.packager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Log {
    public static class Logger {
        private boolean verbose = false;

        public Logger(boolean v) {
            verbose = v;
        }

        public void info(String msg) {
            System.out.println(msg);
        }

        public void verbose(Throwable t) {
            if (Log.debug || verbose) {
                t.printStackTrace(System.out);
            }
        }

        public void verbose(String msg) {
            if (Log.debug || verbose) {
                System.out.println(msg);
            }
        }

        public void debug(String msg) {
            if (Log.debug) {
                System.out.println(msg);
            }
        }
    }

    private static Logger delegate = null;
    private static boolean debug =
            "true".equals(System.getenv("JAVAFX_ANT_DEBUG"));

    public static void setLogger(Logger l) {
        delegate = l;
        if (l == null) {
            delegate = new Logger(false);
        }
    }


    public static void info(String msg) {
        if (delegate != null) {
           delegate.info(msg);
        }
    }

    public static void verbose(String msg) {
        if (delegate != null) {
           delegate.verbose(msg);
        }
    }

    public static void verbose(Throwable t) {
        if (delegate != null) {
           delegate.verbose(t);
        }
    }

    public static void debug(String msg) {
        if (delegate != null) {
           delegate.debug(msg);
        }
    }

    public static void debug(RuntimeException re) {
        debug((Throwable) re);
    }

    public static void debug(Throwable t) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (PrintStream ps = new PrintStream(baos)) {
                t.printStackTrace(ps);
            }
            debug(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        Log.debug = debug;
    }
}
