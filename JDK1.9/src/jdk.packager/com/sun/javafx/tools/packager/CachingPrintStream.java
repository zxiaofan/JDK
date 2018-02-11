/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager;

import java.io.PrintStream;

public class CachingPrintStream {

    private PrintStream ps;
    private StringBuilder sb;

    public CachingPrintStream(PrintStream ps) {
        this.ps = ps;
        sb = new StringBuilder();
    }

    public void println(String s) {
        sb.append(s).append('\n');
        ps.println(s);
    }

    public String getString() {
        return sb.toString();
    }

    public void flush() {
        ps.flush();
        sb = new StringBuilder();
    }
}
