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

import jdk.nashorn.internal.ir.BinaryNode;

final class AssignmentTreeImpl extends ExpressionTreeImpl implements AssignmentTree {
    private final Tree.Kind kind;
    private final ExpressionTree var, expr;

    AssignmentTreeImpl(final BinaryNode node, final ExpressionTree left, final ExpressionTree right) {
        super(node);
        assert node.isAssignment() : "assignment node expected";
        this.var = left;
        this.expr = right;
        this.kind = getOperator(node.tokenType());
    }

    @Override
    public Tree.Kind getKind() {
        return kind;
    }

    @Override
    public ExpressionTree getVariable() {
        return var;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitAssignment(this, data);
    }
}
