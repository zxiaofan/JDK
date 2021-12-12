/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for an {@code @hidden} block tag.
 *
 * <pre>
 *    &#064;hidden
 * </pre>
 *
 * @since 9
 */
public interface HiddenTree extends BlockTagTree {
    /**
     * Returns the description explaining why an item is hidden.
     * @return the description
     */
    List<? extends DocTree> getBody();
}
