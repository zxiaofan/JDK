/*
 * Copyright (c) 1998, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.doclet;

import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

import com.sun.source.util.DocTreePath;

/**
 * This interface provides error, warning and notice reporting.
 *
 * @since 9
 */
public interface Reporter {

    /**
     * Print error message and increment error count.
     *
     * @param kind specify the diagnostic kind
     * @param msg message to print
     */
    void print(Diagnostic.Kind kind, String msg);

    /**
     * Print an error message and increment error count.
     *
     * @param kind specify the diagnostic kind
     * @param path the DocTreePath of item where the error occurs
     * @param msg message to print
     */
    void print(Diagnostic.Kind kind, DocTreePath path, String msg);

    /**
     * Print an error message and increment error count.
     *
     * @param kind specify the diagnostic kind
     * @param e the Element for which  the error occurs
     * @param msg message to print
     */
    void print(Diagnostic.Kind kind, Element e, String msg);
}
