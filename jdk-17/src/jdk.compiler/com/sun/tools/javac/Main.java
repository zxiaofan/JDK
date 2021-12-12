/*
 * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac;

import java.io.PrintWriter;

/**
 * A legacy programmatic interface for the Java Programming Language
 * compiler, javac.
 * See the <a href="{@docRoot}/jdk.compiler/module-summary.html">{@code jdk.compiler}</a>
 * module for details on replacement APIs.
 */
public class Main {
    /**
     * Do not call.
     */
    @Deprecated(since="16", forRemoval=true)
    public Main(){}

    /** Main entry point for the launcher.
     *  Note: This method calls System.exit.
     *  @param args command line arguments
     *  @throws Exception only if an uncaught internal exception occurs;
     *      just retained for historical compatibility
     */
    public static void main(String[] args) throws Exception {
        System.exit(compile(args));
    }

    /** Programmatic interface to the Java Programming Language
     * compiler, javac.
     *
     * @param args The command line arguments that would normally be
     * passed to the javac program as described in the man page.
     * @return an integer equivalent to the exit value from invoking
     * javac, see the man page for details.
     */
    public static int compile(String[] args) {
        com.sun.tools.javac.main.Main compiler =
            new com.sun.tools.javac.main.Main("javac");
        return compiler.compile(args).exitCode;
    }



    /** Programmatic interface to the Java Programming Language
     * compiler, javac.
     *
     * @param args The command line arguments that would normally be
     * passed to the javac program as described in the man page.
     * @param out PrintWriter to which the compiler's diagnostic
     * output is directed.
     * @return an integer equivalent to the exit value from invoking
     * javac, see the man page for details.
     */
    public static int compile(String[] args, PrintWriter out) {
        com.sun.tools.javac.main.Main compiler =
            new com.sun.tools.javac.main.Main("javac", out);
        return compiler.compile(args).exitCode;
    }
}
