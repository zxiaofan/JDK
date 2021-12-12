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

import java.util.List;

/**
 * A tree node for a {@code try} statement.
 *
 * For example:
 * <pre>
 *   try
 *       <em>block</em>
 *   <em>catches</em>
 *   finally
 *       <em>finallyBlock</em>
 * </pre>
 *
 * @jls 14.20 The try statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface TryTree extends StatementTree {
    /**
     * Returns the block of the {@code try} statement.
     * @return the block
     */
    BlockTree getBlock();

    /**
     * Returns any catch blocks provided in the {@code try} statement.
     * The result will be an empty list if there are no
     * catch blocks.
     * @return the catch blocks
     */
    List<? extends CatchTree> getCatches();

    /**
     * Returns the finally block provided in the {@code try} statement,
     * or {@code null} if there is none.
     * @return the finally block
     */
    BlockTree getFinallyBlock();


    /**
     * Returns any resource declarations provided in the {@code try} statement.
     * The result will be an empty list if there are no
     * resource declarations.
     * @return the resource declarations
     */
    List<? extends Tree> getResources();
}
