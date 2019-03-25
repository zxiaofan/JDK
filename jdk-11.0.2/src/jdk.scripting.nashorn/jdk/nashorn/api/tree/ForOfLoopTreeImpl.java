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

import jdk.nashorn.internal.ir.ForNode;

final class ForOfLoopTreeImpl extends StatementTreeImpl implements ForOfLoopTree {
    private final ExpressionTree lhsExpr;
    private final ExpressionTree expr;
    private final StatementTree stat;

    ForOfLoopTreeImpl(final ForNode node,
            final ExpressionTree lhsExpr,
            final ExpressionTree expr,
            final StatementTree stat) {
        super(node);
        assert node.isForIn() : "for ..in expected";
        this.lhsExpr = lhsExpr;
        this.expr = expr;
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.FOR_IN_LOOP;
    }

    @Override
    public ExpressionTree getVariable() {
        return lhsExpr;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitForOfLoop(this, data);
    }
}
