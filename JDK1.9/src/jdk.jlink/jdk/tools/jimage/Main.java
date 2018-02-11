/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jimage;

import java.io.PrintWriter;


public class Main {
    public static void main(String[] args) throws Exception {
        JImageTask t = new JImageTask();
        int rc = t.run(args);
        System.exit(rc);
    }

    /**
     * Entry point that does <i>not</i> call System.exit.
     *
     * @param args command line arguments
     * @param out output stream
     * @return an exit code. 0 means success, non-zero means an error occurred.
     */
    public static int run(String[] args, PrintWriter out) {
        JImageTask t = new JImageTask();
        t.setLog(out);
        return t.run(args);
    }
}
