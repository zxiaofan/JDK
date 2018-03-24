/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for an array access expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> [ <em>index</em> ]
 * </pre>
 *
 * @since 9
 */
public interface ArrayAccessTree extends ExpressionTree {
    /**
     * Returns the array that is accessed.
     *
     * @return the array that is accessed
     */
    ExpressionTree getExpression();

    /**
     * Returns the index of the array element accessed.
     *
     * @return the index expression
     */
    ExpressionTree getIndex();
}
