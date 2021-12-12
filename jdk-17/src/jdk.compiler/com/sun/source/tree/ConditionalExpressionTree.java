/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for the conditional operator {@code ? :}.
 *
 * For example:
 * <pre>
 *   <em>condition</em> ? <em>trueExpression</em> : <em>falseExpression</em>
 * </pre>
 *
 * @jls 15.25 Conditional Operator ? :
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ConditionalExpressionTree extends ExpressionTree {
    /**
     * Returns the condition.
     * @return the condition
     */
    ExpressionTree getCondition();

    /**
     * Returns the expression to be evaluated if the condition is true.
     * @return the expression to be evaluated if the condition is true
     */
    ExpressionTree getTrueExpression();

    /**
     * Returns the expression to be evaluated if the condition is false.
     * @return the expression to be evaluated if the condition is false
     */
    ExpressionTree getFalseExpression();
}
