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
 * A tree node for a 'return' statement.
 *
 * For example:
 * <pre>
 *   return;
 *   return <em>expression</em>;
 * </pre>
 *
 * @since 9
 */
public interface ReturnTree extends StatementTree {
    /**
     * Returns the expression being returned. This is null if no value
     * is being returned. i.e., empty return statement.
     *
     * @return the returned expression
     */
    ExpressionTree getExpression();
}
