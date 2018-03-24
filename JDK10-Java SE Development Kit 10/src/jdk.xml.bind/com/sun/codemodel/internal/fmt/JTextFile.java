/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal.fmt;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.sun.codemodel.internal.JResourceFile;


/**
 * Simple text file.
 *
 * @author
 *      Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class JTextFile extends JResourceFile
{
    public JTextFile( String name ) {
        super(name);
    }

    private String contents = null;

    public void setContents( String _contents ) {
        this.contents = _contents;
    }

    public void build( OutputStream out ) throws IOException {
        Writer w = new OutputStreamWriter(out);
        w.write(contents);
        w.close();
    }
}
