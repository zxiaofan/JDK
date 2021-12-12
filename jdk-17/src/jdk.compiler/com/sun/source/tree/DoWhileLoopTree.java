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
 * A tree node for a {@code do} statement.
 *
 * For example:
 * <pre>
 *   do
 *       <em>statement</em>
 *   while ( <em>expression</em> );
 * </pre>
 *
 * @jls 14.13 The do Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface DoWhileLoopTree extends StatementTree {
    /**
     * Returns the condition of the loop.
     * @return the condition
     */
    ExpressionTree getCondition();

    /**
     * Returns the body of the loop.
     * @return the body of the loop
     */
    StatementTree getStatement();
}
