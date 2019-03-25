/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;

/**
 * A tree node for an @summary inline tag.
 *
 * <p>
 * {&#064;summary text}
 *
 * @since 10
 */
public interface SummaryTree extends InlineTagTree {
    /**
     * Returns the summary or the first line of a comment.
     * @return the summary text
     */
    List<? extends DocTree> getSummary();
}
