/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @(#)OutputUtil.java  1.6 02/03/27
 */



package com.sun.xml.internal.messaging.saaj.packaging.mime.util;

import java.io.OutputStream;
import java.io.IOException;

/**
 * This class is to support writing out Strings as a sequence of bytes
 * terminated by a CRLF sequence. The String must contain only US-ASCII
 * characters.<p>
 *
 * The expected use is to write out RFC822 style headers to an output
 * stream. <p>
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class OutputUtil {
    private static byte[] newline = {'\r','\n'};

    public static void writeln(String s,OutputStream out) throws IOException {
        writeAsAscii(s,out);
        writeln(out);
    }

    /**
     * Writes a string as ASCII string.
     *
     * @param s string.
     * @param out output stream.
     *
     * @throws IOException if an I/O error occurs.
     */
    public static void writeAsAscii(String s,OutputStream out) throws IOException {
        int len = s.length();
        for( int i=0; i<len; i++ )
            out.write((byte)s.charAt(i));
    }

    public static void writeln(OutputStream out) throws IOException {
        out.write(newline);
    }
}
