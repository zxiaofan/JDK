/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 * Interface for receiving diagnostics from Nashorn parser.
 *
 * @since 9
 */
@FunctionalInterface
public interface DiagnosticListener {
    /**
     * Invoked whenever a parsing problem is found.
     *
     * @param diagnostic additional information errors, warnings detected during parsing.
     */
    void report(Diagnostic diagnostic);
}
