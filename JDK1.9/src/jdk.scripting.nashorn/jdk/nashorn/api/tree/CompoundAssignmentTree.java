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
 * A tree node for compound assignment operator.
 * Use {@link #getKind getKind} to determine the kind of operator.
 *
 * For example:
 * <pre>
 *   <em>variable</em> <em>operator</em> <em>expression</em>
 * </pre>
 *
 * @since 9
 */
public interface CompoundAssignmentTree extends ExpressionTree {
    /**
     * Returns the left hand side (LHS) of this assignment.
     *
     * @return left hand side (LHS) expression
     */
    ExpressionTree getVariable();

    /**
     * Returns the right hand side (RHS) of this assignment.
     *
     * @return right hand side (RHS) expression
     */
    ExpressionTree getExpression();
}
