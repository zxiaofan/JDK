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
 * A tree node for an {@code assert} statement.
 *
 * For example:
 * <pre>
 *   assert <em>condition</em> ;
 *
 *   assert <em>condition</em> : <em>detail</em> ;
 * </pre>
 *
 * @jls 14.10 The assert Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface AssertTree extends StatementTree {
    /**
     * Returns the condition being asserted.
     * @return the condition
     */
    ExpressionTree getCondition();

    /**
     * Returns the detail expression.
     * @return the detail expression
     */
    ExpressionTree getDetail();
}
