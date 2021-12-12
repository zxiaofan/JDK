/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jmod;

import java.io.*;
import java.util.spi.ToolProvider;

public class Main {
    public static void main(String... args) throws Exception {
        JmodTask t = new JmodTask();
        int rc = t.run(args);
        System.exit(rc);
    }

    /**
     * Entry point that does <i>not</i> call System.exit.
     *
     * @param out output stream
     * @param err error output stream
     * @param args command line arguments
     * @return an exit code. 0 means success, non-zero means an error occurred.
     */
    public static int run(PrintWriter out, PrintWriter err, String... args) {
        JmodTask t = new JmodTask();
        t.setLog(out, err);
        return t.run(args);
    }

    public static class JmodToolProvider implements ToolProvider {
        @Override
        public String name() {
            return "jmod";
        }

        @Override
        public int run(PrintWriter out, PrintWriter err, String... args) {
            return Main.run(out, err, args);
        }
    }
}
