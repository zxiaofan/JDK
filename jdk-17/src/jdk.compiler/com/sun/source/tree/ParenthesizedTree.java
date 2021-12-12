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
 * A tree node for a parenthesized expression.  Note: parentheses
 * not be preserved by the parser.
 *
 * For example:
 * <pre>
 *   ( <em>expression</em> )
 * </pre>
 *
 * @jls 15.8.5 Parenthesized Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ParenthesizedTree extends ExpressionTree {
    /**
     * Returns the expression within the parentheses.
     * @return the expression
     */
    ExpressionTree getExpression();
}
