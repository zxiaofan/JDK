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

import jdk.nashorn.internal.ir.TernaryNode;

final class ConditionalExpressionTreeImpl extends ExpressionTreeImpl implements ConditionalExpressionTree {
    private final ExpressionTree condExpr, trueExpr, falseExpr;

    ConditionalExpressionTreeImpl(final TernaryNode node,
            final ExpressionTree condExpr, final ExpressionTree trueExpr,
            final ExpressionTree falseExpr) {
        super(node);
        this.condExpr = condExpr;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;

    }

    @Override
    public Kind getKind() {
        return Kind.CONDITIONAL_EXPRESSION;
    }

    @Override
    public ExpressionTree getCondition() {
        return condExpr;
    }

    @Override
    public ExpressionTree getTrueExpression() {
        return trueExpr;
    }

    @Override
    public ExpressionTree getFalseExpression() {
        return falseExpr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitConditionalExpression(this, data);
    }
}
