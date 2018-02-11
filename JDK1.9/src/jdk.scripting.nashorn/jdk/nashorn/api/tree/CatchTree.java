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
 * A tree node for a 'catch' block in a 'try' statement.
 *
 * For example:
 * <pre>
 *   catch ( <em>parameter</em> )
 *       <em>block</em>
 * </pre>
 *
 * @since 9
 */
public interface CatchTree extends Tree {
    /**
     * Returns the catch parameter identifier or parameter binding pattern of the exception caught.
     *
     * @return the catch parameter identifier or parameter binding pattern
     */
    ExpressionTree getParameter();

    /**
     * Returns the code block of this catch block.
     *
     * @return the code block
     */
    BlockTree getBlock();

    /**
     * Returns the optional catch condition expression. This is null
     * if this is an unconditional catch statement.
     *
     * @return the optional catch condition expression.
     */
    ExpressionTree getCondition();
}
