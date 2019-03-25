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

/**
 * A tree node used as the base class for the different types of
 * block tags.
 *
 * @since 1.8
 */
public interface BlockTagTree extends DocTree {
    /**
     * Returns the name of the tag.
     * @return the name of the tag
     */
    String getTagName();
}
