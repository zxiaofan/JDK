/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

/**
 * A tree node for a literal expression.
 * Use {@link #getKind getKind} to determine the kind of literal.
 *
 * For example:
 * <pre>
 *   <em>value</em>
 * </pre>
 *
 * @jls 15.28 Constant Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface LiteralTree extends ExpressionTree {
    /**
     * Returns the value of the literal expression.
     * The value will be a boxed primitive value, a String, or {@code null}.
     * @return the value
     */
    Object getValue();
}
