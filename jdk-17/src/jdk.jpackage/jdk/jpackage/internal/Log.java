/*
 * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Log
 *
 * General purpose logging mechanism.
 */
public class Log {
    public static class Logger {
        private boolean verbose = false;
        private PrintWriter out = null;
        private PrintWriter err = null;

        // verbose defaults to true unless environment variable JPACKAGE_DEBUG
        // is set to true.
        // Then it is only set to true by using --verbose jpackage option

        public Logger() {
            verbose = ("true".equals(System.getenv("JPACKAGE_DEBUG")));
        }

        public void setVerbose() {
            verbose = true;
        }

        public boolean isVerbose() {
            return verbose;
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
            }
        }

        public void fatalError(String msg) {
            if (err != null) {
                err.println(msg);
            }
        }

        public void error(String msg) {
            msg = addTimestamp(msg);
            if (err != null) {
                err.println(msg);
            }
        }

        public void verbose(Throwable t) {
            if (out != null && verbose) {
                out.print(addTimestamp(""));
                t.printStackTrace(out);
            }
        }

        public void verbose(String msg) {
            msg = addTimestamp(msg);
            if (out != null && verbose) {
                out.println(msg);
            }
        }

        public void verbose(List<String> strings,
                List<String> output, int returnCode, long pid) {
            if (verbose) {
                StringBuffer sb = new StringBuffer();
                sb.append("Command [PID: ");
                sb.append(pid);
                sb.append("]:\n   ");

                for (String s : strings) {
                    sb.append(" " + s);
                }
                verbose(new String(sb));
                if (output != null && !output.isEmpty()) {
                    sb = new StringBuffer("Output:");
                    for (String s : output) {
                        sb.append("\n    " + s);
                    }
                    verbose(new String(sb));
                }
                verbose("Returned: " + returnCode + "\n");
            }
        }

        private String addTimestamp(String msg) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Date time = new Date(System.currentTimeMillis());
            return String.format("[%s] %s", sdf.format(time), msg);
        }
    }

    private static final InheritableThreadLocal<Logger> instance =
            new InheritableThreadLocal<Logger>() {
                @Override protected Logger initialValue() {
                    return new Logger();
                }
            };

    public static void setPrintWriter (PrintWriter out, PrintWriter err) {
        instance.get().setPrintWriter(out, err);
    }

    public static void flush() {
        instance.get().flush();
    }

    public static void info(String msg) {
        instance.get().info(msg);
    }

    public static void fatalError(String msg) {
        instance.get().fatalError(msg);
    }

    public static void error(String msg) {
        instance.get().error(msg);
    }

    public static void setVerbose() {
        instance.get().setVerbose();
    }

    public static boolean isVerbose() {
        return instance.get().isVerbose();
    }

    public static void verbose(String msg) {
       instance.get().verbose(msg);
    }

    public static void verbose(Throwable t) {
       instance.get().verbose(t);
    }

    public static void verbose(List<String> strings, List<String> out,
            int ret, long pid) {
       instance.get().verbose(strings, out, ret, pid);
    }
}
