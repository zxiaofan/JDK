/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
package jdk.packager.internal;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;

public class JavaPackagerToolProvider implements ToolProvider {

    public String name() {
        return "javapackager";
    }

    public synchronized int run(PrintWriter out, PrintWriter err, String... args) {
        try {
            com.sun.javafx.tools.packager.Main.run(out, err, args);
        } catch (Exception ignored) {
            return 1;
        }
        return 0;
    }
}
