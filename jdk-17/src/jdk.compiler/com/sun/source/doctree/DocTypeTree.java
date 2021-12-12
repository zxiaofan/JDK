/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * <pre>
 *    &lt;!doctype text&gt;
 * </pre>
 *
 * For HTML5 documents, the correct form is {@code <!doctype html>}.
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
