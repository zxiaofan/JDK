/*
 * Copyright (c) 2006, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.util;

import com.sun.source.doctree.DocTree;

/**
 * A DocTreeVisitor that visits all the child tree nodes, and provides
 * support for maintaining a path for the parent nodes.
 * To visit nodes of a particular type, just override the
 * corresponding visitorXYZ method.
 * Inside your method, call super.visitXYZ to visit descendant
 * nodes.
 *
 * @since 1.8
 */
public class DocTreePathScanner<R, P> extends DocTreeScanner<R, P> {
    /**
     * Constructs a {@code DocTreePathScanner}.
     */
    public DocTreePathScanner() {}

    /**
     * Scans a tree from a position identified by a tree path.
     * @param path the path
     * @param p a value to be passed to visitor methods
     * @return the result returned from the main visitor method
     */
    public R scan(DocTreePath path, P p) {
        this.path = path;
        try {
            return path.getLeaf().accept(this, p);
        } finally {
            this.path = null;
        }
    }

    /**
     * Scans a single node.
     * The current path is updated for the duration of the scan.
     * @param tree the tree to be scanned
     * @param p a value to be passed to visitor methods
     * @return the result returned from the main visitor method
     */
    @Override
    public R scan(DocTree tree, P p) {
        if (tree == null)
            return null;

        DocTreePath prev = path;
        path = new DocTreePath(path, tree);
        try {
            return tree.accept(this, p);
        } finally {
            path = prev;
        }
    }

    /**
     * Returns the current path for the node, as built up by the currently
     * active set of scan calls.
     * @return the current path
     */
    public DocTreePath getCurrentPath() {
        return path;
    }

    private DocTreePath path;
}
