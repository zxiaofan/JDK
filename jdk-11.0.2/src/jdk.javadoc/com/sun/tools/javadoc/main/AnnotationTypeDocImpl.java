/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javadoc.main;

import com.sun.javadoc.*;

import com.sun.source.util.TreePath;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol.*;
import com.sun.tools.javac.util.List;

import static com.sun.tools.javac.code.Scope.LookupKind.NON_RECURSIVE;

import static com.sun.tools.javac.code.Kinds.Kind.*;

/**
 * Represents an annotation type.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Scott Seligman
 * @since 1.5
 */

@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public class AnnotationTypeDocImpl
        extends ClassDocImpl implements AnnotationTypeDoc {

    public AnnotationTypeDocImpl(DocEnv env, ClassSymbol sym) {
        this(env, sym, null);
    }

    public AnnotationTypeDocImpl(DocEnv env, ClassSymbol sym, TreePath treePath) {
        super(env, sym, treePath);
    }

    /**
     * Returns true, as this is an annotation type.
     * (For legacy doclets, return false.)
     */
    public boolean isAnnotationType() {
        return !isInterface();
    }

    /**
     * Returns false.  Though technically an interface, an annotation
     * type is not considered an interface for this purpose.
     * (For legacy doclets, returns true.)
     */
    public boolean isInterface() {
        return env.legacyDoclet;
    }

    /**
     * Returns an empty array, as all methods are annotation type elements.
     * (For legacy doclets, returns the elements.)
     * @see #elements()
     */
    public MethodDoc[] methods(boolean filter) {
        return env.legacyDoclet
                ? (MethodDoc[])elements()
                : new MethodDoc[0];
    }

    /**
     * Returns the elements of this annotation type.
     * Returns an empty array if there are none.
     * Elements are always public, so no need to filter them.
     */
    public AnnotationTypeElementDoc[] elements() {
        List<AnnotationTypeElementDoc> elements = List.nil();
        for (Symbol sym : tsym.members().getSymbols(NON_RECURSIVE)) {
            if (sym != null && sym.kind == MTH) {
                MethodSymbol s = (MethodSymbol)sym;
                elements = elements.prepend(env.getAnnotationTypeElementDoc(s));
            }
        }
        return
            elements.toArray(new AnnotationTypeElementDoc[elements.length()]);
    }
}
