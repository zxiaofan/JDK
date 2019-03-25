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

class BinaryTreeImpl extends ExpressionTreeImpl implements BinaryTree {
    private final Tree.Kind kind;
    private final ExpressionTree left, right;

    BinaryTreeImpl(final BinaryNode node, final ExpressionTree left, final ExpressionTree right) {
        super(node);
        assert !node.isAssignment() : "assignment node";
        this.left = left;
        this.right = right;
        this.kind = getOperator(node.tokenType());
    }

    @Override
    public Tree.Kind getKind() {
        return kind;
    }

    @Override
    public ExpressionTree getLeftOperand() {
        return left;
    }

    @Override
    public ExpressionTree getRightOperand() {
        return right;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitBinary(this, data);
    }
}
