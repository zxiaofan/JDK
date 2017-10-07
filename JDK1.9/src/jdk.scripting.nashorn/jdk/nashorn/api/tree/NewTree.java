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
 * A tree node to declare a new instance of a class.
 *
 * For example:
 * <pre>
 *   new <em>identifier</em> ( )
 *
 *   new <em>identifier</em> ( <em>arguments</em> )
 * </pre>
 *
 * @since 9
 */
public interface NewTree extends ExpressionTree {
    /**
     * Returns the constructor expression of this 'new' expression.
     *
     * @return the constructor expression of this 'new' expression
     */
    ExpressionTree getConstructorExpression();
}
