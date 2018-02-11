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

import java.util.LinkedHashMap;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import jdk.jshell.Wrap.CompoundWrap;

/**
 * The outer wrap for a set of snippets wrapped in a generated class
 * @author Robert Field
 */
class OuterSnippetsClassWrap extends OuterWrap {

    private final String className;
    private final LinkedHashMap<Wrap, Snippet> wrapToSnippet;

    OuterSnippetsClassWrap(String className, CompoundWrap w, List<Snippet> snippets, List<Wrap> wraps) {
        super(w);
        assert snippets == null || snippets.size() == wraps.size();
        this.className = className;
        wrapToSnippet = new LinkedHashMap<>();
        for (int i = 0; i < snippets.size(); ++i) {
            wrapToSnippet.put(wraps.get(i), snippets.get(i));
        }
    }

    public Snippet wrapLineToSnippet(int wline) {
        Wrap wrap = ((CompoundWrap)w).wrapLineToWrap(wline);
        return wrapToSnippet.get(wrap);
    }

    @Override
    Diag wrapDiag(Diagnostic<? extends JavaFileObject> d) {
        return new WrappedDiagnostic(d) {

            @Override
            Snippet snippetOrNull() {
                Wrap wrap = ((CompoundWrap) w).wrapIndexToWrap(diag.getPosition());
                Snippet sn = wrapToSnippet.get(wrap);
                if (sn != null) {
                    return sn;
                } else {
                    return super.snippetOrNull();
                }
            }
        };
    }

    int ordinal(Snippet sn) {
        int i = 0;
        for (Snippet si : wrapToSnippet.values()) {
            if (si == sn) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    @Override
    public String className() {
        return className;
    }

    @Override
    public String toString() {
        return "OSCW(" + className + ":" + w + ")";
    }
}
