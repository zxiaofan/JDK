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
 * A tree node for an @serialData block tag.
 *
 * <p>
 * &#064;serialData data-description
 *
 * @since 1.8
 */
public interface SerialDataTree extends BlockTagTree {
    /**
     * Returns the description of the serial data.
     * @return the description
     */
    List<? extends DocTree> getDescription();
}
