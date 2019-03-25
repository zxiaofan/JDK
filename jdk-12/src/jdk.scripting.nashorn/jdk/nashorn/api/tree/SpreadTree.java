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
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 */
@Deprecated(since="11", forRemoval=true)
public interface SpreadTree extends ExpressionTree {
    /**
     * Returns the expression that is being spread.
     *
     * @return The expression that is being spread.
     */
    ExpressionTree getExpression();
}
