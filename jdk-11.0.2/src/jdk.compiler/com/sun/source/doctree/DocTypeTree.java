/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a {@code doctype} declaration.
 *
 * <p>
 * &lt;!doctype text&gt;
 *
 * @since 10
 */
public interface DocTypeTree extends DocTree {
    /**
     * Returns the text of the doctype declaration.
     * @return text
     */
    String getText();
}
