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
 * A tree node for a 'throw' statement.
 *
 * For example:
 * <pre>
 *   throw <em>expression</em>;
 * </pre>
 *
 * @since 9
 */
public interface ThrowTree extends StatementTree {
    /**
     * Returns the expression being thrown.
     *
     * @return the expression being thrown.
     */
    ExpressionTree getExpression();
}
