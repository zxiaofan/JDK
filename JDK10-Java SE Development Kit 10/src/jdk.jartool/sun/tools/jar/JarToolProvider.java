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

package sun.tools.jar;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;

public class JarToolProvider implements ToolProvider {
    public String name() {
        return "jar";
    }

    public int run(PrintWriter out, PrintWriter err, String... args) {
        boolean ok = new Main(out, err, name()).run(args);
        return ok ? 0 : 1;
    }
}
