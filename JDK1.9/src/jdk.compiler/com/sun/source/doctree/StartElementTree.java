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
import javax.lang.model.element.Name;

/**
 * A tree node for the start of an HTML element.
 *
 * <p>
 * &lt; name [attributes] [/]&gt;
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
     * Returns true if this is a self-closing element,
     * as indicated by a "/" before the closing "&gt;".
     * @return true if this is a self-closing element
     */
    boolean isSelfClosing();
}
