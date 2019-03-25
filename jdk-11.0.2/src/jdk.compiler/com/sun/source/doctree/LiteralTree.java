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
 *
 * A tree node for an @literal or @code inline tag.
 *
 * <p>
 * {&#064;literal text}
 *
 * @since 1.8
 */
public interface LiteralTree extends InlineTagTree {
    /**
     * Returns the body of the {@code @code} or {@code @literal} tag.
     * @return the body of the tag
     */
    TextTree getBody();
}
