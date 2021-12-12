/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.javadoc.internal.tool;

import java.io.PrintWriter;

/**
 * Provides external entry points (tool and programmatic) for the javadoc program.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public class Main {

    /**
     * This constructor should never be called.
     */
    private Main() { throw new AssertionError(); }

    /**
     * The main entry point called by the launcher. This will call
     * System.exit with an appropriate return value.
     *
     * @param args the command-line parameters
     */
    public static void main(String... args) {
        System.exit(execute(args));
    }

    /**
     * Programmatic interface.
     *
     * @param args the command-line parameters
     * @return The return code.
     */
    public static int execute(String... args) {
        Start jdoc = new Start();
        return jdoc.begin(args).exitCode;
    }

    /**
     * Programmatic interface.
     *
     * @param writer a stream for all output
     * @param args the command-line parameters
     * @return The return code.
     */
    public static int execute(String[] args, PrintWriter writer) {
        Start jdoc = new Start(writer, writer);
        return jdoc.begin(args).exitCode;
    }

    /**
     * Programmatic interface.
     *
     * @param outWriter a stream for expected output
     * @param errWriter a stream for diagnostic output
     * @param args the command-line parameters
     * @return The return code.
     */
    public static int execute(String[] args, PrintWriter outWriter, PrintWriter errWriter) {
        Start jdoc = new Start(outWriter, errWriter);
        return jdoc.begin(args).exitCode;
    }

    public enum Result {
        /** completed with no errors */
        OK(0),
        /** Completed with reported errors */
        ERROR(1),
        /** Bad command-line arguments */
        CMDERR(2),
        /** System error or resource exhaustion */
        SYSERR(3),
        /** Terminated abnormally */
        ABNORMAL(4);

        Result(int exitCode) {
            this.exitCode = exitCode;
        }

        public boolean isOK() {
            return (exitCode == 0);
        }

        public final int exitCode;

        @Override
        public String toString() {
            return name() + '(' + exitCode + ')';
        }
    }
}
