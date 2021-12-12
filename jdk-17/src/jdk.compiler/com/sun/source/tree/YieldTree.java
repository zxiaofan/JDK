/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a {@code yield} statement.
 *
 * For example:
 * <pre>
 *   yield <em>expression</em> ;
 * </pre>
 *
 * @jls 14.21 The yield Statement
 *
 * @since 13
 */
public interface YieldTree extends StatementTree {

    /**
     * Returns the expression for this {@code yield} statement.
     *
     * @return the expression
     */
    ExpressionTree getValue();
}
