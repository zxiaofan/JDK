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
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
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
