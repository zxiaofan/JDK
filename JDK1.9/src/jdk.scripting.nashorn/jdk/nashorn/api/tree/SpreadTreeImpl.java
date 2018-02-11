/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.nashorn.internal.ir.Expression;

final class SpreadTreeImpl extends ExpressionTreeImpl
        implements SpreadTree {

    private final ExpressionTree expr;

    SpreadTreeImpl(final Expression exprNode, final ExpressionTree expr) {
        super(exprNode);
        this.expr = expr;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.SPREAD;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitSpread(this, data);
    }
}
