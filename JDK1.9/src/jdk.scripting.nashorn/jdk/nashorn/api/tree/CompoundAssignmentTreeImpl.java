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

final class CompoundAssignmentTreeImpl extends ExpressionTreeImpl implements CompoundAssignmentTree {

    private final ExpressionTree var, expr;
    private final Kind kind;

    CompoundAssignmentTreeImpl(final BinaryNode node, final ExpressionTree left, final ExpressionTree right) {
        super(node);
        assert node.isAssignment() : "not an assignment node";
        this.var = left;
        this.expr = right;
        this.kind = getOperator(node.tokenType());
        assert kind != Tree.Kind.ASSIGNMENT : "compound assignment expected";
    }

    @Override
    public Kind getKind() {
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
        return visitor.visitCompoundAssignment(this, data);
    }
}
