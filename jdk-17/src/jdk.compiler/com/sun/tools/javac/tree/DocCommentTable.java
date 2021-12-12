/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.tree;

import com.sun.source.doctree.ErroneousTree;
import com.sun.tools.javac.parser.Tokens.Comment;
import com.sun.tools.javac.tree.DCTree.DCDocComment;

/**
 * A table giving the doc comment, if any, for any tree node.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own
 *  risk.  This code and its internal interfaces are subject to change
 *  or deletion without notice.</b>
 */
public interface DocCommentTable {
    /**
     * Check if a tree node has a corresponding doc comment.
     */
    boolean hasComment(JCTree tree);

    /**
     * Get the Comment token containing the doc comment, if any, for a tree node.
     */
    Comment getComment(JCTree tree);

    /**
     * Get the plain text of the doc comment, if any, for a tree node.
     */
    String getCommentText(JCTree tree);

    /**
     * Get the parsed form of the doc comment as a DocTree. If any errors
     * are detected during parsing, they will be reported via
     * {@link ErroneousTree ErroneousTree} nodes within the resulting tree.
     */
    DCDocComment getCommentTree(JCTree tree);

    /**
     * Set the Comment to be associated with a tree node.
     */
    void putComment(JCTree tree, Comment c);
}
