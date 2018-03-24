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

package com.sun.source.doctree;

import java.util.List;

/**
 * A tree node for an @index or &#064;index inline tag.
 *
 * <p>
 * {&#064;index keyword optional description} <br>
 *
 * @since 9
 */
public interface IndexTree extends InlineTagTree {
    /**
     * Returns the specified search term.
     * @return the search term
     */
    DocTree getSearchTerm();

    /**
     * Returns the description, if any.
     * @return the description
     */
    List<? extends DocTree> getDescription();
}
