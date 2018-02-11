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
 * A mixin for "loop" statements.
 *
 * @since 9
 */
public interface LoopTree extends StatementTree {
    /**
     * Returns the statement contained in this 'loop' statement.
     *
     * @return the statement
     */
    StatementTree getStatement();
}
