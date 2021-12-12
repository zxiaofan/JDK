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
 * A tree node for an unrecognized inline tag.
 *
 * <pre>
 *    {&#064;name content}
 * </pre>
 *
 * @since 1.8
 */
public interface UnknownInlineTagTree extends InlineTagTree {
    /**
     * Returns the content of an unrecognized inline tag.
     * @return the content
     */
    List<? extends DocTree> getContent();
}
