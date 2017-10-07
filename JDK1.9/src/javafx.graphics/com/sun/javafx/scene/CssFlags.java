/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene;

/**
 * Flags used for processing the CSS pass in the scenegraph
 */
public enum CssFlags {
    // NOTE: Order is significant as I use a quick ordinal() check for
    // determining whether to continue processing, so these are ranked
    // according to precedence
    /**
     * Indicates that the node is clean from here on down and does not
     * require any work on the next CSS pass
     */
    CLEAN,
    /**
     * DIRTY_BRANCH means that this node is CLEAN but one of its children,
     * or grandchildren, etc is UPDATE or REAPPLY so we need to step into this branch.
     */
    DIRTY_BRANCH,
    /**
     * Indicates that we must update properties for this node and all child
     * nodes. This is typically in response to a pseudoclass state change and
     * is much faster than a REAPPLY.
     */
    UPDATE,
    /**
     * Indicates that we must reapply all the styles from this point downwards
     * in the tree, including figuring out which styles apply to each Node. This
     * is the most expensive CSS operation that can occur, and usually only
     * happens when the CSS tree has changed.
     */
    REAPPLY
}
