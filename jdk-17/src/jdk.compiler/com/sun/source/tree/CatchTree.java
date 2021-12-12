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
 * A tree node for a {@code catch} block in a {@code try} statement.
 *
 * For example:
 * <pre>
 *   catch ( <em>parameter</em> )
 *       <em>block</em>
 * </pre>
 *
 * @jls 14.20 The try statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface CatchTree extends Tree {
    /**
     * Returns the catch variable.
     * A multi-catch variable will have a
     * {@link UnionTypeTree UnionTypeTree}
     * as the type of the variable.
     * @return the catch variable
     */
    VariableTree getParameter();

    /**
     * Returns the catch block.
     * @return the catch block
     */
    BlockTree getBlock();
}
