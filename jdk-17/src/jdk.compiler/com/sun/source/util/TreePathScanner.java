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

import com.sun.source.tree.*;

/**
 * A TreeVisitor that visits all the child tree nodes, and provides
 * support for maintaining a path for the parent nodes.
 * To visit nodes of a particular type, just override the
 * corresponding visitorXYZ method.
 * Inside your method, call super.visitXYZ to visit descendant
 * nodes.
 *
 * @apiNote
 * In order to initialize the "current path", the scan must be
 * started by calling one of the {@code scan} methods.
 *
 * @author Jonathan Gibbons
 * @since 1.6
 */
public class TreePathScanner<R, P> extends TreeScanner<R, P> {
    /**
     * Constructs a {@code TreePathScanner}.
     */
    public TreePathScanner() {}

    /**
     * Scans a tree from a position identified by a TreePath.
     * @param path the path identifying the node to be scanned
     * @param p a parameter value passed to visit methods
     * @return the result value from the visit method
     */
    public R scan(TreePath path, P p) {
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
     *
     * @apiNote This method should normally only be called by the
     * scanner's {@code visit} methods, as part of an ongoing scan
     * initiated by {@link #scan(TreePath,Object) scan(TreePath, P)}.
     * The one exception is that it may also be called to initiate
     * a full scan of a {@link CompilationUnitTree}.
     *
     * @return the result value from the visit method
     */
    @Override
    public R scan(Tree tree, P p) {
        if (tree == null)
            return null;

        TreePath prev = path;
        path = new TreePath(path, tree);
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
    public TreePath getCurrentPath() {
        return path;
    }

    private TreePath path;
}
