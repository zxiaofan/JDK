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
 * A tree node for an "enhanced" {@code for} loop statement.
 *
 * For example:
 * <pre>
 *   for ( <em>variable</em> : <em>expression</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @jls 14.14.2 The enhanced for statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface EnhancedForLoopTree extends StatementTree {
    /**
     * Returns the control variable for the loop.
     * @return the control variable
     */
    VariableTree getVariable();

    /**
     * Returns the expression yielding the values for the control variable.
     * @return the expression
     */
    ExpressionTree getExpression();

    /**
     * Returns the body of the loop.
     * @return the body of the loop
     */
    StatementTree getStatement();
}
