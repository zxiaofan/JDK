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
 * A tree node for an expression statement.
 *
 * For example:
 * <pre>
 *   <em>expression</em> ;
 * </pre>
 *
 * @jls 14.8 Expression Statements
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ExpressionStatementTree extends StatementTree {
    /**
     * Returns the expression constituting this statement.
     * @return the expression
     */
    ExpressionTree getExpression();
}
