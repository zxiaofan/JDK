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
 * A tree node for a reference to a Java language element.
 *
 * <pre>
 *    package.class#field
 *    package.class#method(<i>arg-types</i>)
 * </pre>
 *
 * @since 1.8
 */
public interface ReferenceTree extends DocTree {
    /**
     * Returns the signature of the Java language element being referenced,
     * as found in {@code @see} and similar nodes.
     * @return the signature
     */
    String getSignature();
}
