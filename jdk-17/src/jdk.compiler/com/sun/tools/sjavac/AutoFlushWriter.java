/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class AutoFlushWriter extends FilterWriter {

    public AutoFlushWriter(Writer out) {
        super(out);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        if (c == '\n' || c == '\r')
            flush();
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        if (str.contains("\n") || str.contains("\r"))
            flush();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        for (char c : cbuf) {
            if (c == '\n' || c == '\r') {
                flush();
                break;
            }
        }
    }
}
