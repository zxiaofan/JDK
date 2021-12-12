/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

/**
 * A tree node for an import declaration.
 *
 * For example:
 * <pre>
 *   import <em>qualifiedIdentifier</em> ;
 *
 *   static import <em>qualifiedIdentifier</em> ;
 * </pre>
 *
 * @jls 7.5 Import Declarations
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ImportTree extends Tree {
    /**
     * Returns true if this is a static import declaration.
     * @return true if this is a static import
     */
    boolean isStatic();

    /**
     * Returns the qualified identifier for the declaration(s)
     * being imported.
     * If this is an import-on-demand declaration, the
     * qualified identifier will end in "*".
     * @return a qualified identifier, ending in "*" if and only if
     * this is an import-on-demand
     */
    Tree getQualifiedIdentifier();
}
