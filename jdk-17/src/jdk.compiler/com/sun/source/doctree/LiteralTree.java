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

/**
 * A tree node for an {@code @literal} or {@code @code} inline tag.
 *
 * <pre>
 *    {&#064;literal text}
 *    {&#064;code text}
 * </pre>
 *
 * @since 1.8
 */
public interface LiteralTree extends InlineTagTree {
    /**
     * Returns the body of the {@code @literal} or {@code @code} tag.
     * @return the body of the tag
     */
    TextTree getBody();
}
