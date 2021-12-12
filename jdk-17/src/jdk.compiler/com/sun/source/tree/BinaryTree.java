/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a binary expression.
 * Use {@link #getKind getKind} to determine the kind of operator.
 *
 * For example:
 * <pre>
 *   <em>leftOperand</em> <em>operator</em> <em>rightOperand</em>
 * </pre>
 *
 * @jls 15.17 Multiplicative Operators
 * @jls 15.18 Additive Operators
 * @jls 15.19 Shift Operators
 * @jls 15.20 Relational Operators
 * @jls 15.21 Equality Operators
 * @jls 15.22 Bitwise and Logical Operators
 * @jls 15.23 Conditional-And Operator {@code &&}
 * @jls 15.24 Conditional-Or Operator {@code ||}
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface BinaryTree extends ExpressionTree {
    /**
     * Returns the left (first) operand of the expression.
     * @return the left operand
     */
    ExpressionTree getLeftOperand();

    /**
     * Returns the right (second) operand of the expression.
     * @return the right operand
     */
    ExpressionTree getRightOperand();
}
