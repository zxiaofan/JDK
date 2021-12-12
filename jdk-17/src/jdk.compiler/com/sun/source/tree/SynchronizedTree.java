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
 * A tree node for a {@code synchronized} statement.
 *
 * For example:
 * <pre>
 *   synchronized ( <em>expression</em> )
 *       <em>block</em>
 * </pre>
 *
 * @jls 14.19 The synchronized Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface SynchronizedTree extends StatementTree {
    /**
     * Returns the expression on which to synchronize.
     * @return the expression
     */
    ExpressionTree getExpression();

    /**
     * Returns the block of the {@code synchronized} statement.
     * @return the block
     */
    BlockTree getBlock();
}
