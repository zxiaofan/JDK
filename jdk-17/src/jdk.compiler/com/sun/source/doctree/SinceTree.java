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

import java.util.List;

/**
 * A tree node for an {@code @since} block tag.
 *
 * <pre>
 *    &#064;since since-text
 * </pre>
 *
 * @since 1.8
 */
public interface SinceTree extends BlockTagTree {
    /**
     * Returns the text explaining the availability of the item being documented.
     * @return the text
     */
    List<? extends DocTree> getBody();
}
