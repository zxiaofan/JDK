/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 *  A tree node for spread operator in array elements, function call arguments.
 */
public interface SpreadTree extends ExpressionTree {
    /**
     * Returns the expression that is being spread.
     *
     * @return The expression that is being spread.
     */
    ExpressionTree getExpression();
}
