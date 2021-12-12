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
 * A tree node for a {@code throw} statement.
 *
 * For example:
 * <pre>
 *   throw <em>expression</em>;
 * </pre>
 *
 * @jls 14.18 The throw Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ThrowTree extends StatementTree {
    /**
     * Returns the expression to be thrown.
     * @return the expression
     */
    ExpressionTree getExpression();
}
