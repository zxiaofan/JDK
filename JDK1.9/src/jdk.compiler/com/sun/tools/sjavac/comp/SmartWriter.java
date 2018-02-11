/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.comp;

import com.sun.tools.sjavac.Log;

import java.io.*;
import javax.tools.JavaFileObject;

/**
 * The SmartWriter will cache the written data and when the writer is closed,
 * then it will compare the cached data with the old_content string.
 * If different, then it will write all the new content to the file.
 * If not, the file is not touched.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class SmartWriter extends Writer {

    String name;
    JavaFileObject file;
    String oldContent;
    StringWriter newContent = new StringWriter();
    boolean closed;

    public SmartWriter(JavaFileObject f, String s, String n) {
        name = n;
        file = f;
        oldContent = s;
        newContent = new StringWriter();
        closed = false;
    }

    public void write(char[] chars, int i, int i1) {
        newContent.write(chars, i, i1);
    }

    public void close() throws IOException {
        if (closed) return;
        closed = true;
        String s = newContent.toString();
        if (!oldContent.equals(s)) {
            int p = file.getName().lastIndexOf(File.separatorChar);
            try (Writer writer = file.openWriter()) {
                writer.write(s);
            }
            Log.debug("Writing " + file.getName().substring(p + 1));
        }
    }

    public void flush() throws IOException {
    }
}
