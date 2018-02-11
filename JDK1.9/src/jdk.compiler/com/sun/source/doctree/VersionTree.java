/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
 *
 * A tree node for an @version block tag.
 *
 * <p>
 * &#064;version version-text
 *
 * @since 1.8
 */
public interface VersionTree extends BlockTagTree {
    /**
     * Returns the body of the tag.
     * @return the body
     */
    List<? extends DocTree> getBody();
}
