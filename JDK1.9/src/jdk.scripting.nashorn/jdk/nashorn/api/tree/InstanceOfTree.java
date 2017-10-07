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
 * A tree node for an 'instanceof' expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> instanceof <em>type</em>
 * </pre>
 *
 * @since 9
 */
public interface InstanceOfTree extends ExpressionTree {
    /**
     * Returns the expression whose type is being checked.
     *
     * @return the expression whose type is being checked
     */
    ExpressionTree getExpression();

    /**
     * Returns the type expression.
     *
     * @return the type expression
     */
    Tree getType();
}
