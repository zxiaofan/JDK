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

import jdk.nashorn.internal.ir.UnaryNode;

class UnaryTreeImpl extends ExpressionTreeImpl implements UnaryTree {
    private final ExpressionTree expr;
    private final Kind kind;
    UnaryTreeImpl(final UnaryNode node, final ExpressionTree expr) {
        super(node);
        this.expr = expr;
        this.kind = getOperator(node.tokenType());
    }

    @Override
    public Kind getKind() {
        return kind;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitUnary(this, data);
    }
}
