/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.util.spi.ToolProvider;

/**
 * An implementation of the {@link java.util.spi.ToolProvider ToolProvider} SPI,
 * providing access to JDK documentation tool, javadoc.
 *
 * @since 9
 */
// This is currently a stand-alone top-level class so that it can easily be excluded
// from interims builds of javadoc, used while building JDK.
public class JavadocToolProvider implements ToolProvider {

    @Override
    public String name() {
        return "javadoc";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        return Main.execute(args, out, err);
    }
}
