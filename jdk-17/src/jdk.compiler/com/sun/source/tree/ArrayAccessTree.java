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
 * A tree node for an array access expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> [ <em>index</em> ]
 * </pre>
 *
 * @jls 15.10.3 Array Access Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ArrayAccessTree extends ExpressionTree {
    /**
     * Returns the expression for the array being accessed.
     * @return the array
     */
    ExpressionTree getExpression();

    /**
     * Returns the expression for the index.
     * @return the index
     */
    ExpressionTree getIndex();
}
