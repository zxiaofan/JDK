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
import javax.lang.model.element.Name;

/**
 * A tree node for the start of an HTML element.
 *
 * <pre>
 *    &lt; name [attributes] [/]&gt;
 * </pre>
 *
 * @since 1.8
 */
public interface StartElementTree extends DocTree {
    /**
     * Returns the name of the element.
     * @return the name
     */
    Name getName();

    /**
     * Returns any attributes defined by this element.
     * @return the attributes
     */
    List<? extends DocTree> getAttributes();

    /**
     * Returns {@code true} if this is a self-closing element,
     * as indicated by a {@code "/"} before the closing {@code ">"}.
     * @return {@code true} if this is a self-closing element
     */
    boolean isSelfClosing();
}
