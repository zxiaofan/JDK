/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

/**
 * An embedded HTML comment.
 *
 * <pre>
 *    &lt;!-- text --&gt;
 * </pre>
 *
 * @since 1.8
 */
public interface CommentTree extends DocTree {
    /**
     * Returns the text of the comment.
     * @return the comment text
     */
    String getBody();
}

