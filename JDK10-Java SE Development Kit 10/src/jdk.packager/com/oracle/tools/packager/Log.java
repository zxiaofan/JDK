/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.io.PrintWriter;

/**
 * @deprecated use {@link ToolProvider} to locate the {@code "javapackager"} tool instead.
 */
@Deprecated(since="10", forRemoval=true)
public class Log {
    public static class Logger {
        private boolean verbose = false;
        private PrintWriter out = null;
        private PrintWriter err = null;

        public Logger(boolean v) {
            verbose = v;
        }

        public void setVerbose(boolean v) {
            verbose = v;
        }

        public void setPrintWriter(PrintWriter out, PrintWriter err) {
            this.out = out;
            this.err = err;
        }

        public void flush() {
            if (out != null) {
                out.flush();
            }

            if (err != null) {
                err.flush();
            }
        }

        public void info(String msg) {
            if (out != null) {
                out.println(msg);
            } else {
                System.out.println(msg);
            }
        }

        public void infof(String format, Object... args) {
            if (out != null) {
                out.printf(format, args);
            } else {
                System.out.printf(format, args);
            }
        }

        public void error(String msg) {
            if (err != null) {
                err.println(msg);
            } else {
                System.err.println(msg);
            }
        }

        public void verbose(Throwable t) {
            if (out != null && (Log.debug || verbose)) {
                t.printStackTrace(out);
            } else if (Log.debug || verbose) {
                t.printStackTrace(System.out);
            }
        }

        public void verbose(String msg) {
            if (out != null && (Log.debug || verbose)) {
                out.println(msg);
            } else if (Log.debug || verbose) {
                System.out.println(msg);
            }
        }

        public void debug(String msg) {
            if (out != null && Log.debug) {
                out.println(msg);
            } else if (Log.debug) {
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

    public static Logger getLogger() {
        return delegate;
    }

    public static void flush() {
        if (delegate != null) {
            delegate.flush();
        }
    }

    public static void info(String msg) {
        if (delegate != null) {
           delegate.info(msg);
        }
    }

    public static void infof(String format, Object... args) {
        if (delegate != null) {
           delegate.infof(format, args);
        }
    }

    public static void error(String msg) {
        if (delegate != null) {
            delegate.error(msg);
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
