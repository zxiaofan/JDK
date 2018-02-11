/*
 * Copyright (c) 1997, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.ws.wscompile;

import com.sun.codemodel.internal.CodeWriter;
import com.sun.codemodel.internal.JPackage;

import javax.annotation.processing.Filer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Writes all the source files using the specified Filer.
 *
 * @author WS Development Team
 */
public class FilerCodeWriter extends CodeWriter {

    /** The Filer used to create files. */
    private final Filer filer;

    private Writer w;

    public FilerCodeWriter(Options options) throws IOException {
        this.filer = options.filer;
    }

    @Override
    public OutputStream openBinary(JPackage pkg, String fileName) throws IOException {
        throw new UnsupportedOperationException("Not supported.");
    }

    public Writer openSource(JPackage pkg, String fileName) throws IOException {
        String tmp = fileName.substring(0, fileName.length()-5);
        if (pkg.name() != null && ! "".equals(pkg.name())) {
                w = filer.createSourceFile(pkg.name() + "." + tmp).openWriter();
        } else {
                w = filer.createSourceFile(tmp).openWriter();
        }
        return w;
    }


    public void close() throws IOException {
        if (w != null)
            w.close();
        w = null;
    }
}
