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
 * A tree node for a 'do' statement.
 *
 * For example:
 * <pre>
 *   do
 *       <em>statement</em>
 *   while ( <em>expression</em> );
 * </pre>
 *
 * @since 9
 */
public interface DoWhileLoopTree extends ConditionalLoopTree {
    /**
     * Returns the condition expression of this do-while statement.
     *
     * @return the condition expression
     */
    @Override
    ExpressionTree getCondition();

    /**
     * The statement contained within this do-while statement.
     *
     * @return the statement
     */
    @Override
    StatementTree getStatement();
}
