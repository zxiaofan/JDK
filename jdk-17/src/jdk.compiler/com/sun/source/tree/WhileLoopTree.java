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
 * A tree node for a {@code while} loop statement.
 *
 * For example:
 * <pre>
 *   while ( <em>condition</em> )
 *     <em>statement</em>
 * </pre>
 *
 *
 * @jls 14.12 The while Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface WhileLoopTree extends StatementTree {
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
