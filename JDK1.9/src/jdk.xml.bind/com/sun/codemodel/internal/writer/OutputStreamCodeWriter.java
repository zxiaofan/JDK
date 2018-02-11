/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Output all source files into a single stream.
 *
 * This is primarily for test purposes.
 *
 * @author
 *      Aleksei Valikov (valikov@gmx.net)
 */
package com.sun.codemodel.internal.writer;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.sun.codemodel.internal.CodeWriter;
import com.sun.codemodel.internal.JPackage;

public class OutputStreamCodeWriter extends CodeWriter {
        private final PrintStream out;

        /**
         * @param os
         *            This stream will be closed at the end of the code generation.
         */
        public OutputStreamCodeWriter(OutputStream os, String encoding) {
                try {
                        this.out = new PrintStream(os, false, encoding);
                } catch (UnsupportedEncodingException ueex) {
                        throw new IllegalArgumentException(ueex);
                }
                this.encoding = encoding;
        }

        public OutputStream openBinary(JPackage pkg, String fileName)
                        throws IOException {
                return new FilterOutputStream(out) {
                        public void close() {
                                // don't let this stream close
                        }
                };
        }

        public void close() throws IOException {
                out.close();
        }
}
