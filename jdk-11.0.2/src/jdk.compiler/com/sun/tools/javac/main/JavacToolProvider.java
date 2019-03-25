/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.main;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;

/**
 * An implementation of the {@link java.util.spi.ToolProvider ToolProvider} SPI,
 * providing access to JDK Java compiler, javac.
 *
 * @since 9
 */
// This is currently a stand-alone top-level class so that it can easily be excluded
// from interims builds of javac, used while building JDK.
public class JavacToolProvider implements ToolProvider {
    public String name() {
        return "javac";
    }

    public int run(PrintWriter out, PrintWriter err, String... args) {
        Main compiler = new Main("javac", out, err);
        return compiler.compile(args).exitCode;
    }
}
