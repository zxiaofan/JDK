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
 * A tree node for postfix and unary expressions.
 * Use {@link #getKind getKind} to determine the kind of operator.
 *
 * For example:
 * <pre>
 *   <em>operator</em> <em>expression</em>
 *
 *   <em>expression</em> <em>operator</em>
 * </pre>
 *
 * @jls 15.14 Postfix Expressions
 * @jls 15.15 Unary Operators
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface UnaryTree extends ExpressionTree {
    /**
     * Returns the expression that is the operand of the unary operator.
     * @return the expression
     */
    ExpressionTree getExpression();
}
