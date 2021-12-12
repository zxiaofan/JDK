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
 * A tree node for an {@code @value} inline tag.
 *
 * <pre>
 *    {&#064;value reference}
 * </pre>
 *
 * @since 1.8
 */
public interface ValueTree extends InlineTagTree {
    /**
     * Returns the reference to the value.
     * @return the reference
     */
    ReferenceTree getReference();
}
