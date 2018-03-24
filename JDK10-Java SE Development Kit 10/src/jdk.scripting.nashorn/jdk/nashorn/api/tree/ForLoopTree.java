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
 * A tree node for a basic 'for' loop statement.
 *
 * For example:
 * <pre>
 *   for ( <em>initializer</em> ; <em>condition</em> ; <em>update</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @since 9
 */
public interface ForLoopTree extends ConditionalLoopTree {
    /**
     * Returns the initializer expression of this 'for' statement.
     *
     * @return the initializer expression
     */
    ExpressionTree getInitializer();

    /**
     * Returns the condition expression of this 'for' statement.
     *
     * @return the condition expression
     */
    @Override
    ExpressionTree getCondition();

    /**
     * Returns the update expression of this 'for' statement.
     *
     * @return the update expression
     */
    ExpressionTree getUpdate();

    /**
     * Returns the statement contained in this 'for' statement.
     *
     * @return the statement
     */
    @Override
    StatementTree getStatement();
}
