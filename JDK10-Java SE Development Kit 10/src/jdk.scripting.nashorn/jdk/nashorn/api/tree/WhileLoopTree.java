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
 * A tree node for a 'while' loop statement.
 *
 * For example:
 * <pre>
 *   while ( <em>condition</em> )
 *     <em>statement</em>
 * </pre>
 *
 * @since 9
 */
public interface WhileLoopTree extends ConditionalLoopTree {
    /**
     * The condition expression of this 'while' statement.
     *
     * @return the condition expression
     */
    @Override
    ExpressionTree getCondition();

    /**
     * The statement contained in this 'while' statement.
     *
     * @return the statement contained
     */
    @Override
    StatementTree getStatement();
}
