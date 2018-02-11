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
 * A tree node for a 'with' statement.
 *
 * For example:
 * <pre>
 *   with ( <em>scope</em> )
 *     <em>statement</em>
 * </pre>
 *
 * @since 9
 */
public interface WithTree extends StatementTree {
    /**
     * The scope object expression for this 'with' statement.
     *
     * @return the scope object
     */
    ExpressionTree getScope();

    /**
     * The statement contained in this 'with' statement.
     *
     * @return the statement contained
     */
    StatementTree getStatement();
}
