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

package jdk.jshell;

import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * The outer wrap for a set of snippets wrapped in a generated class
 * @author Robert Field
 */
class OuterImportSnippetWrap extends OuterWrap {

    private final Snippet snippet;

    OuterImportSnippetWrap(Wrap wrap, Snippet snippet) {
        super(wrap);
        this.snippet = snippet;
    }

    @Override
    Diag wrapDiag(Diagnostic<? extends JavaFileObject> d) {
        return new WrappedDiagnostic(d) {

            @Override
            Snippet snippetOrNull() {
                return snippet;
            }
        };
    }

    @Override
    public String toString() {
        return "OISW(" + w + ")";
    }
}
