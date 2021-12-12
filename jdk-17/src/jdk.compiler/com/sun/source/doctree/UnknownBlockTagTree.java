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
 * A tree node for an unrecognized block tag.
 *
 * <pre>
 *    &#064;name content
 * </pre>
 *
 * @since 1.8
 */
public interface UnknownBlockTagTree extends BlockTagTree {
    /**
     * Returns the content of an unrecognized block tag.
     * @return the content
     */
    List<? extends DocTree> getContent();
}
