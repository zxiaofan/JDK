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
 * A tree node for an 'if' statement.
 *
 * For example:
 * <pre>
 *   if ( <em>condition</em> )
 *      <em>thenStatement</em>
 *
 *   if ( <em>condition</em> )
 *       <em>thenStatement</em>
 *   else
 *       <em>elseStatement</em>
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface IfTree extends StatementTree {
    /**
     * Returns the condition expression of this 'if' statement.
     *
     * @return the condition expression
     */
    ExpressionTree getCondition();

    /**
     * Returns the 'then' statement of this 'if' statement.
     *
     * @return the 'then' statement
     */
    StatementTree getThenStatement();

    /**
     * Returns the then statement of this 'if' statement.
     * null if this if statement has no else branch.
     *
     * @return the 'else' statement
     */
    StatementTree getElseStatement();
}
