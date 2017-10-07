/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javah;

import java.io.PrintWriter;

/**
 *  Main entry point.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Main {
    /**
     * Main entry point for the launcher.
     * Note: This method calls System.exit.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        JavahTask t = new JavahTask();
        int rc = t.run(args);
        System.exit(rc);
    }

    /**
     * Entry point that does <i>not</i> call System.exit.
     * @param args command line arguments
     * @param out output stream
     * @return an exit code. 0 means success, non-zero means an error occurred.
     */
    public static int run(String[] args, PrintWriter out) {
        JavahTask t = new JavahTask();
        t.setLog(out);
        return t.run(args);
    }
}
