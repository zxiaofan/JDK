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
 * A tree node for an {@code if} statement.
 *
 * For example:
 * <pre>
 *   if ( <em>condition</em> )
 *      <em>thenStatement</em>
 *
 *   if ( <em>condition</em> )
 *       <em>thenStatement</em>
 *   else
 *       <em>elseStatement</em>
 * </pre>
 *
 * @jls 14.9 The if Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface IfTree extends StatementTree {
    /**
     * Returns the condition of the if-statement.
     * @return the condition
     */
    ExpressionTree getCondition();

    /**
     * Returns the statement to be executed if the condition is true
     * @return the statement to be executed if the condition is true
     */
    StatementTree getThenStatement();

    /**
     * Returns the statement to be executed if the condition is false,
     * or {@code null} if there is no such statement.
     * @return the statement to be executed if the condition is false
     */
    StatementTree getElseStatement();
}
