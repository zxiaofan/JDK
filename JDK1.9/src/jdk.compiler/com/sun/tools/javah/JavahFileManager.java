/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javah;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.util.Context;

/**
 *  javah's implementation of JavaFileManager.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
class JavahFileManager extends JavacFileManager {
    private JavahFileManager(Context context, Charset charset) {
        super(context, true, charset);
        setSymbolFileEnabled(false);
    }

    static JavahFileManager create(final DiagnosticListener<? super JavaFileObject> dl, PrintWriter log) {
        Context javac_context = new Context();

        if (dl != null)
            javac_context.put(DiagnosticListener.class, dl);
        javac_context.put(com.sun.tools.javac.util.Log.errKey, log);

        return new JavahFileManager(javac_context, null);
    }
}
