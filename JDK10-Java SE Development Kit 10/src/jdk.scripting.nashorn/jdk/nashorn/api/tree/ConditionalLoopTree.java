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
 * A mixin for conditional "loop" statements.
 *
 * @since 9
 */
public interface ConditionalLoopTree extends LoopTree {
    /**
     * Returns the condition expression of this 'loop' statement.
     *
     * @return the condition expression
     */
    ExpressionTree getCondition();
}
