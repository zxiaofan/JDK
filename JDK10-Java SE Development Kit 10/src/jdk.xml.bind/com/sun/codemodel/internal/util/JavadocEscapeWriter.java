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

package com.sun.codemodel.internal.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * {@link Writer} that escapes characters that are unsafe
 * as Javadoc comments.
 *
 * Such characters include '&lt;' and '&amp;'.
 *
 * <p>
 * Note that this class doesn't escape other Unicode characters
 * that are typically unsafe. For example, {@literal &#x611B;} (A kanji
 * that means "love") can be considered as unsafe because
 * javac with English Windows cannot accept this character in the
 * source code.
 *
 * <p>
 * If the application needs to escape such characters as well, then
 * they are on their own.
 *
 * @author
 *      Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class JavadocEscapeWriter extends FilterWriter {

    public JavadocEscapeWriter( Writer next ) {
        super(next);
    }

    public void write(int ch) throws IOException {
        if(ch=='<')
            out.write("&lt;");
        else
        if(ch=='&')
            out.write("&amp;");
        else
        if(ch=='>')
            out.write("&gt;");
        else
            out.write(ch);
    }

    public void write(char[] buf, int off, int len) throws IOException {
        for( int i=0; i<len; i++ )
            write(buf[off+i]);
    }

    public void write(char[] buf) throws IOException {
        write(buf,0,buf.length);
    }

    public void write(String buf, int off, int len) throws IOException {
        write( buf.toCharArray(), off, len );
    }

    public void write(String buf) throws IOException {
        write( buf.toCharArray(), 0, buf.length() );
    }

}
