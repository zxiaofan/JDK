/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
package jdk.javadoc.internal.doclets.toolkit.util;


import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import com.sun.source.doctree.AttributeTree;
import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.DocTree.Kind;
import com.sun.source.doctree.StartElementTree;
import com.sun.source.util.DocTreePath;
import com.sun.source.util.DocTreePathScanner;
import com.sun.source.util.TreePath;
import com.sun.tools.javac.util.DefinedBy;
import com.sun.tools.javac.util.DefinedBy.Api;

/**
 * A DocTree scanner to detect use of JavaScript in a doc comment tree.
 */
public class JavaScriptScanner extends DocTreePathScanner<Void, Consumer<DocTreePath>> {

    public Void scan(DocCommentTree tree, TreePath p, Consumer<DocTreePath> f) {
        return scan(new DocTreePath(p, tree), f);
    }

    @Override @DefinedBy(Api.COMPILER_TREE)
    public Void visitStartElement(StartElementTree tree, Consumer<DocTreePath> f) {
        String name = tree.getName().toString();
        if (name.equalsIgnoreCase("script"))
            f.accept(getCurrentPath());
        return super.visitStartElement(tree, f);
    }

    @Override @DefinedBy(Api.COMPILER_TREE)
    public Void visitAttribute(AttributeTree tree, Consumer<DocTreePath> f) {
        String name = tree.getName().toString().toLowerCase(Locale.ENGLISH);
        switch (name) {
            // See https://www.w3.org/TR/html4/sgml/dtd.html
            //     https://www.w3.org/TR/html52/fullindex.html#attributes-table
            // These are all the attributes that take a %URI or a valid URL potentially surrounded
            // by spaces
            case "action":  case "cite":  case "classid":  case "codebase":  case "data":
            case "datasrc":  case "for":  case "href":  case "longdesc":  case "profile":
            case "src":  case "usemap":
                List<? extends DocTree> value = tree.getValue();
                if (value != null && !value.isEmpty() && value.get(0).getKind() == Kind.TEXT) {
                    String v = value.get(0).toString().trim().toLowerCase(Locale.ENGLISH);
                    if (v.startsWith("javascript:")) {
                        f.accept(getCurrentPath());
                    }
                }
                break;
            // See https://www.w3.org/TR/html52/webappapis.html#events-event-handlers
            // An event handler has a name, which always starts with "on" and is followed by
            // the name of the event for which it is intended.
            default:
                if (name.startsWith("on")) {
                    f.accept(getCurrentPath());
                }
                break;
        }
        return super.visitAttribute(tree, f);
    }

    /**
     * Used to indicate a fault when parsing, typically used in
     * lambda methods.
     */
    public static class Fault extends RuntimeException {
        private static final long serialVersionUID = 0L;
    }
}
