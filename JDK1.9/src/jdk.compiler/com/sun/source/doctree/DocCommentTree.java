/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;

/**
 * The top level representation of a documentation comment.
 *
 * <p>
 * first-sentence body block-tags
 *
 * @since 1.8
 */
public interface DocCommentTree extends DocTree {
    /**
     * Returns the first sentence of a documentation comment.
     * @return the first sentence of a documentation comment
     */
    List<? extends DocTree> getFirstSentence();

    /**
     * Returns the entire body of a documentation comment, appearing
     * before any block tags, including the first sentence.
     * @return body of a documentation comment first sentence inclusive
     *
     * @since 9
     */
    default List<? extends DocTree> getFullBody() {
        ArrayList<DocTree> bodyList = new ArrayList<>();
        bodyList.addAll(getFirstSentence());
        bodyList.addAll(getBody());
        return bodyList;
    }

    /**
     * Returns the body of a documentation comment,
     * appearing after the first sentence, and before any block tags.
     * @return the body of a documentation comment
     */
    List<? extends DocTree> getBody();

    /**
     * Returns the block tags for a documentation comment.
     * @return the block tags of a documentation comment
     */
    List<? extends DocTree> getBlockTags();
}
